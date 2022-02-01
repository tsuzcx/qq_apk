package com.tencent.mobileqq.richmedia.segment;

import android.os.Bundle;
import bboi;
import bboj;
import bbxv;
import beuw;
import bhmi;
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
  public VideoSend$1(bboj parambboj, bboi parambboi, Bundle paramBundle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "submitTask begin");
    }
    if (this.jdField_a_of_type_Bboi.jdField_c_of_type_Int == 1) {
      if (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Bboi.d)
      {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bboi);
        localObject = new File(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bboi.jdField_a_of_type_Long = ((File)localObject).length();
        this.jdField_a_of_type_Bboi.jdField_b_of_type_JavaLangString = bbxv.a(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Bboi.d == 0)
        {
          this.jdField_a_of_type_Bboi.jdField_b_of_type_Long = 0L;
          this.this$0.a(this.jdField_a_of_type_Bboi);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Bboi.jdField_b_of_type_Long = (this.jdField_a_of_type_Bboi.jdField_c_of_type_Long - ((bboi)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Long);
        break;
      } while (!QLog.isColorLevel());
      QLog.d("VideoSend", 2, "submitTask failed, mVideoSliceInfos.size():" + this.this$0.jdField_a_of_type_JavaUtilArrayList.size() + " info:" + this.jdField_a_of_type_Bboi);
      return;
      if (this.jdField_a_of_type_Bboi.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString = this.this$0.c();
        localObject = new File(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bboi.jdField_a_of_type_Long = ((File)localObject).length();
        this.jdField_a_of_type_Bboi.jdField_b_of_type_JavaLangString = bbxv.a(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
        this.this$0.b = this.jdField_a_of_type_Bboi;
        this.jdField_a_of_type_Bboi.d = this.this$0.jdField_a_of_type_JavaUtilArrayList.size();
        this.this$0.a(this.jdField_a_of_type_Bboi);
        return;
      }
      if (this.jdField_a_of_type_Bboi.jdField_c_of_type_Int == 4)
      {
        this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString = this.this$0.a();
        this.jdField_a_of_type_Bboi.d = -1;
        this.this$0.b(this.jdField_a_of_type_Bboi, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
    } while (this.jdField_a_of_type_Bboi.jdField_c_of_type_Int != 5);
    this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString = this.this$0.b();
    Object localObject = new File(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bboi.jdField_a_of_type_Long = ((File)localObject).length();
    int i = this.jdField_a_of_type_Bboi.e;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated," + this.jdField_a_of_type_Bboi + " msVideo:" + i);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileStatus == 1003))
    {
      localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
      bhmi.d(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString, (String)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.jdField_a_of_type_Bboi.jdField_a_of_type_Long);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "combine file is generated,message is sent, info:" + this.jdField_a_of_type_Bboi + " saveVideoPath:" + (String)localObject);
      }
      this.this$0.c = this.jdField_a_of_type_Bboi;
      if (this.this$0.jdField_a_of_type_Beuw != null) {
        this.this$0.jdField_a_of_type_Beuw.d(1003);
      }
      this.this$0.c();
      return;
    }
    this.jdField_a_of_type_Bboi.jdField_b_of_type_JavaLangString = bbxv.a(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mLocalMd5 = this.jdField_a_of_type_Bboi.jdField_b_of_type_JavaLangString;
    localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
    bhmi.d(this.jdField_a_of_type_Bboi.jdField_a_of_type_JavaLangString, (String)localObject);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.jdField_a_of_type_Bboi.jdField_a_of_type_Long);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated, info:" + this.jdField_a_of_type_Bboi + " saveVideoPath:" + (String)localObject);
    }
    if ((this.this$0.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("video_segment_capture_success", true))) {
      this.jdField_a_of_type_Bboi.jdField_a_of_type_Boolean = false;
    }
    this.this$0.a(this.jdField_a_of_type_Bboi);
    this.this$0.c = this.jdField_a_of_type_Bboi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.1
 * JD-Core Version:    0.7.0.1
 */