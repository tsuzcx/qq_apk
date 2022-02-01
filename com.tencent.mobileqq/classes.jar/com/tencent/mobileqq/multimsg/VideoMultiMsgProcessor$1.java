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
    boolean bool;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMultiForwardVideoUploadResult success[");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append("]");
        QLog.d("VideoMultiMsgProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      int j = 0;
      int k = 0;
      paramInt = 0;
      while (j < this.b.size())
      {
        localObject2 = (MessageRecord)this.b.get(j);
        if (k >= paramArrayList.size())
        {
          QLog.e("VideoMultiMsgProcessor", 1, "MultiForwardVideo: error index!");
        }
        else
        {
          localObject1 = (ShortVideoResult)paramArrayList.get(k);
          int i = paramInt;
          if (localObject1 != null) {
            if ((((ShortVideoResult)localObject1).jdField_a_of_type_Int == 0) && (((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject != null) && ((((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject instanceof im_msg_body.RichText)))
            {
              ((MessageForShortVideo)localObject2).richText = ((im_msg_body.RichText)((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject);
              i = paramInt;
            }
            else
            {
              i = paramInt;
              if (((ShortVideoResult)localObject1).jdField_a_of_type_Int == -1)
              {
                i = paramInt;
                if (((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
                {
                  if ("cancel".equals(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b)) {
                    b(1);
                  }
                  do
                  {
                    i = 1;
                    break;
                    b(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int);
                  } while (this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int));
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a.getMultiMessageProxy().a((MessageRecord)localObject2, VideoMultiMsgProcessor.a(), true);
                  bool = this.jdField_a_of_type_ComTencentMobileqqMultimsgVideoMultiMsgProcessor.a.getMultiMessageProxy().a(this.jdField_a_of_type_JavaUtilHashMap, (MessageRecord)localObject2);
                  QLog.e("VideoMultiMsgProcessor", 1, String.format("MultiForwardVideo errCode:%d, errStr:%s, update:%s, uniseq:%d", new Object[] { Integer.valueOf(((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int), ((ShortVideoResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b, Boolean.valueOf(bool), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
                  i = paramInt;
                }
              }
            }
          }
          k += 1;
          paramInt = i;
        }
        j += 1;
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("totalCount", String.valueOf(paramArrayList.size()));
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 != null)
      {
        ((HashMap)localObject1).put("errCount", String.valueOf(((ArrayList)localObject2).size()));
        ((HashMap)localObject1).put("errCodeStr", Arrays.asList(new ArrayList[] { this.jdField_a_of_type_JavaUtilArrayList }).toString());
        ((HashMap)localObject1).put("errCode", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.get(0)));
      }
      else
      {
        ((HashMap)localObject1).put("errCount", "0");
        ((HashMap)localObject1).put("errCode", "0");
      }
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StatisticCollector)localObject2).collectPerformance(null, "MultiMsgVideoSendResult", bool, 0L, paramArrayList.size(), (HashMap)localObject1, null);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult failed!");
      }
      paramArrayList = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayList.collectPerformance(null, "MultiMsgVideoSendFail", bool, 0L, 0L, null, null);
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(1, 8, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(0, 8, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.VideoMultiMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */