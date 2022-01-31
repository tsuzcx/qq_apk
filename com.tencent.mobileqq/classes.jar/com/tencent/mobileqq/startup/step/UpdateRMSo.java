package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class UpdateRMSo
  extends Step
{
  protected boolean a()
  {
    long l1 = System.currentTimeMillis();
    VideoEnvironment.a(2131230759, 2131230760);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "initBuiltInDoCopyEnvStep... time=" + (l2 - l1) + " ms");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateRMSo
 * JD-Core Version:    0.7.0.1
 */