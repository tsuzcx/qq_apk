package com.tencent.mobileqq.troop.homework.config;

import android.os.Handler;
import bbzc;
import com.tencent.qphone.base.util.QLog;

public class BeginnerGuideDownloadManager$1
  implements Runnable
{
  public BeginnerGuideDownloadManager$1(bbzc parambbzc, Handler paramHandler, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((!bbzc.a(this.this$0, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)) && (QLog.isColorLevel())) {
      QLog.d("BeginnerGuideDownloadManager", 2, "postDownload return false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */