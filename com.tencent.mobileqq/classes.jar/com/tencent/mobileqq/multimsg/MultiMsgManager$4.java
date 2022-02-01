package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.MultiForwardUploadAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class MultiMsgManager$4
  extends UiCallBack.MultiForwardUploadAdapter
{
  MultiMsgManager$4(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, int paramInt2) {}
  
  public void a(int paramInt, ArrayList<ShortVideoResult> paramArrayList)
  {
    int j = 0;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMultiForwardVideoUploadResult success[");
        ((StringBuilder)localObject).append(paramArrayList.size());
        ((StringBuilder)localObject).append("]");
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
      }
      paramInt = 0;
      int k = 0;
      for (;;)
      {
        i = paramInt;
        if (j >= this.a.size()) {
          break;
        }
        localObject = (MessageRecord)this.a.get(j);
        int m = k;
        i = paramInt;
        if ((localObject instanceof MessageForShortVideo)) {
          if (k >= paramArrayList.size())
          {
            QLog.e("MultiMsg_TAG", 1, "MultiForwardVideo: error index!");
            m = k;
            i = paramInt;
          }
          else
          {
            ShortVideoResult localShortVideoResult = (ShortVideoResult)paramArrayList.get(k);
            i = paramInt;
            if (localShortVideoResult != null) {
              if ((localShortVideoResult.a == 0) && (localShortVideoResult.d != null) && ((localShortVideoResult.d instanceof im_msg_body.RichText)))
              {
                ((MessageForShortVideo)localObject).richText = ((im_msg_body.RichText)localShortVideoResult.d);
                i = paramInt;
              }
              else
              {
                i = paramInt;
                if (localShortVideoResult.a == -1)
                {
                  i = paramInt;
                  if (localShortVideoResult.b != null)
                  {
                    i = paramInt;
                    if ("cancel".equals(localShortVideoResult.b.b)) {
                      i = 1;
                    }
                  }
                }
              }
            }
            m = k + 1;
          }
        }
        j += 1;
        k = m;
        paramInt = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult failed!");
    }
    int i = 0;
    if (i != 0)
    {
      MultiMsgManager.a(this.h, this.b, this.c, this.d, this.e);
      return;
    }
    MultiMsgManager.b(this.h, 2);
    if (MultiMsgManager.d(this.h) == 0) {
      MultiMsgManager.a(this.h, this.c, this.d, this.e, this.f, this.b, null, this.a, false, this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.4
 * JD-Core Version:    0.7.0.1
 */