package com.tencent.mobileqq.richmedia.segment;

import android.os.Bundle;
import axxo;
import axxp;
import aygu;
import bauo;
import bdhb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class VideoSend$1
  implements Runnable
{
  public VideoSend$1(axxp paramaxxp, axxo paramaxxo, Bundle paramBundle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "submitTask begin");
    }
    if (this.jdField_a_of_type_Axxo.jdField_c_of_type_Int == 1) {
      if (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Axxo.d)
      {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Axxo);
        localObject = new File(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Axxo.jdField_a_of_type_Long = ((File)localObject).length();
        this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString = aygu.a(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Axxo.d == 0)
        {
          this.jdField_a_of_type_Axxo.jdField_b_of_type_Long = 0L;
          this.this$0.a(this.jdField_a_of_type_Axxo);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Axxo.jdField_b_of_type_Long = (this.jdField_a_of_type_Axxo.jdField_c_of_type_Long - ((axxo)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Long);
        break;
      } while (!QLog.isColorLevel());
      QLog.d("VideoSend", 2, "submitTask failed, mVideoSliceInfos.size():" + this.this$0.jdField_a_of_type_JavaUtilArrayList.size() + " info:" + this.jdField_a_of_type_Axxo);
      return;
      if (this.jdField_a_of_type_Axxo.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString = this.this$0.c();
        localObject = new File(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Axxo.jdField_a_of_type_Long = ((File)localObject).length();
        this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString = aygu.a(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
        this.this$0.b = this.jdField_a_of_type_Axxo;
        this.jdField_a_of_type_Axxo.d = this.this$0.jdField_a_of_type_JavaUtilArrayList.size();
        this.this$0.a(this.jdField_a_of_type_Axxo);
        return;
      }
      if (this.jdField_a_of_type_Axxo.jdField_c_of_type_Int == 4)
      {
        this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString = this.this$0.a();
        this.jdField_a_of_type_Axxo.d = -1;
        this.this$0.b(this.jdField_a_of_type_Axxo, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
    } while (this.jdField_a_of_type_Axxo.jdField_c_of_type_Int != 5);
    this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString = this.this$0.b();
    Object localObject = new File(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Axxo.jdField_a_of_type_Long = ((File)localObject).length();
    int i = this.jdField_a_of_type_Axxo.e;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated," + this.jdField_a_of_type_Axxo + " msVideo:" + i);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileStatus == 1003))
    {
      localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
      bdhb.d(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString, (String)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.jdField_a_of_type_Axxo.jdField_a_of_type_Long);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "combine file is generated,message is sent, info:" + this.jdField_a_of_type_Axxo + " saveVideoPath:" + (String)localObject);
      }
      this.this$0.c = this.jdField_a_of_type_Axxo;
      if (this.this$0.jdField_a_of_type_Bauo != null) {
        this.this$0.jdField_a_of_type_Bauo.d(1003);
      }
      this.this$0.c();
      return;
    }
    this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString = aygu.a(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mLocalMd5 = this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString;
    localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
    bdhb.d(this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString, (String)localObject);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.jdField_a_of_type_Axxo.jdField_a_of_type_Long);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated, info:" + this.jdField_a_of_type_Axxo + " saveVideoPath:" + (String)localObject);
    }
    if ((this.this$0.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("video_segment_capture_success", true))) {
      this.jdField_a_of_type_Axxo.jdField_a_of_type_Boolean = false;
    }
    this.this$0.a(this.jdField_a_of_type_Axxo);
    this.this$0.c = this.jdField_a_of_type_Axxo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.1
 * JD-Core Version:    0.7.0.1
 */