package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.MultiForwardUploadAdapter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class VideoMultiMsgProcessor$1
  extends UiCallBack.MultiForwardUploadAdapter
{
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = null;
  
  VideoMultiMsgProcessor$1(VideoMultiMsgProcessor paramVideoMultiMsgProcessor, ArrayList paramArrayList, HashMap paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback, MultiMsgRequest paramMultiMsgRequest) {}
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, ArrayList<ShortVideoResult> paramArrayList)
  {
    int j = 0;
    int i = 0;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult success[" + paramArrayList.size() + "]");
      }
      j = 0;
      int k = 0;
      paramInt = i;
      Object localObject2;
      while (k < this.b.size())
      {
        localObject2 = (MessageRecord)this.b.get(k);
        if (j >= paramArrayList.size())
        {
          QLog.e("VideoMultiMsgProcessor", 1, "MultiForwardVideo: error index!");
          i = paramInt;
          paramInt = j;
          k += 1;
          j = paramInt;
          paramInt = i;
        }
        else
        {
          localObject1 = (ShortVideoResult)paramArrayList.get(j);
          i = paramInt;
          if (localObject1 != null)
          {
            if ((((ShortVideoResult)localObject1).jdField_a_of_type_Int != 0) || (((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject == null) || (!(((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject instanceof im_msg_body.RichText))) {
              break label200;
            }
            ((MessageForShortVideo)localObject2).richText = ((im_msg_body.RichText)((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject);
            i = paramInt;
          }
          for (;;)
          {
            paramInt = j + 1;
            break;
            label200:
            i = paramInt;
            if (((ShortVideoResult)localObject1).jdField_a_of_type_Int == -1)
            {
              i = paramInt;
              if (((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null) {
                if ("cancel".equals(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b))
                {
                  i = 1;
                  b(1);
                }
                else
                {
                  b(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int);
                  if (this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int))
                  {
                    i = 1;
                  }
                  else
                  {
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a.getMultiMessageProxy().a((MessageRecord)localObject2, VideoMultiMsgProcessor.a(), true);
                    bool = this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a.getMultiMessageProxy().a(this.jdField_a_of_type_JavaUtilHashMap, (MessageRecord)localObject2);
                    QLog.e("VideoMultiMsgProcessor", 1, String.format("MultiForwardVideo errCode:%d, errStr:%s, update:%s, uniseq:%d", new Object[] { Integer.valueOf(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int), ((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b, Boolean.valueOf(bool), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
                    i = paramInt;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("totalCount", String.valueOf(paramArrayList.size()));
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        ((HashMap)localObject1).put("errCount", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        ((HashMap)localObject1).put("errCodeStr", Arrays.asList(new ArrayList[] { this.jdField_a_of_type_JavaUtilArrayList }).toString());
        ((HashMap)localObject1).put("errCode", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.get(0)));
        localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label562;
        }
      }
      label562:
      for (bool = true;; bool = false)
      {
        ((StatisticCollector)localObject2).collectPerformance(null, "MultiMsgVideoSendResult", bool, 0L, paramArrayList.size(), (HashMap)localObject1, null);
        if (paramInt == 0) {
          break label621;
        }
        this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(1, 8, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
        return;
        ((HashMap)localObject1).put("errCount", "0");
        ((HashMap)localObject1).put("errCode", "0");
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult failed!");
    }
    paramArrayList = StatisticCollector.getInstance(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList.collectPerformance(null, "MultiMsgVideoSendFail", bool, 0L, 0L, null, null);
      paramInt = j;
      break;
    }
    label621:
    this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(0, 8, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.VideoMultiMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */