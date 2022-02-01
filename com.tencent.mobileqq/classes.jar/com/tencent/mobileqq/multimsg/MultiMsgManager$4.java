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
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(j);
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
              if ((localShortVideoResult.jdField_a_of_type_Int == 0) && (localShortVideoResult.jdField_a_of_type_JavaLangObject != null) && ((localShortVideoResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.RichText)))
              {
                ((MessageForShortVideo)localObject).richText = ((im_msg_body.RichText)localShortVideoResult.jdField_a_of_type_JavaLangObject);
                i = paramInt;
              }
              else
              {
                i = paramInt;
                if (localShortVideoResult.jdField_a_of_type_Int == -1)
                {
                  i = paramInt;
                  if (localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
                  {
                    i = paramInt;
                    if ("cancel".equals(localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b)) {
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
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 2);
    if (MultiMsgManager.c(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager) == 0) {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, false, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.4
 * JD-Core Version:    0.7.0.1
 */