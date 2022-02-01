package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

class BaseShortVideoOprerator$MultiForwardShortVideoTask$MultiForwardVideoUpCallback
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  ShortVideoResult jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult;
  
  BaseShortVideoOprerator$MultiForwardShortVideoTask$MultiForwardVideoUpCallback(BaseShortVideoOprerator.MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult = ((ShortVideoResult)paramMultiForwardShortVideoTask.b.get(this.jdField_a_of_type_Int));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
    localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
    localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
    localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
    localMessageForShortVideo.videoKandianType = paramSendResult.jdField_d_of_type_Int;
    localMessageForShortVideo.serial();
    paramSendResult = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a.getMultiMessageProxy();
    if (paramSendResult != null) {
      paramSendResult.a(localMessageForShortVideo, null);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b)
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          a(paramSendResult);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
          }
          i = BaseShortVideoOprerator.MultiForwardShortVideoTask.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask);
          if (i == 0) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.this$0.a(3, 0, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.b);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int = paramSendResult.b;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + paramSendResult.jdField_a_of_type_JavaLangString);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.jdField_a_of_type_JavaUtilArrayList.size() - i) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator$MultiForwardShortVideoTask.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.MultiForwardShortVideoTask.MultiForwardVideoUpCallback
 * JD-Core Version:    0.7.0.1
 */