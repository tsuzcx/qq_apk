package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

class MultiForwardVideoUpCallback
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  private final MultiForwardShortVideoTask jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask;
  ShortVideoResult jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult;
  
  MultiForwardVideoUpCallback(MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask = paramMultiForwardShortVideoTask;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult = ((ShortVideoResult)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramSendResult.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    ((IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class)).updateMultiMsg(this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a, localMessageForShortVideo);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.b)
    {
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        a(paramSendResult);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int = paramSendResult.b;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onsend fail! err:");
          localStringBuilder.append(paramSendResult.jdField_a_of_type_JavaLangString);
          QLog.d("BaseShortVideoOprerator", 2, localStringBuilder.toString());
        }
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.a();
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoUpOperator.a(3, 0, this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.b);
      } else if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMultiForwardShortVideoTask.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.MultiForwardVideoUpCallback
 * JD-Core Version:    0.7.0.1
 */