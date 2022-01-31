package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class WebP
  extends Step
{
  protected boolean a()
  {
    if ((!WebpSoLoader.a()) && (QLog.isColorLevel())) {
      QLog.d("WEBP", 2, String.format("Can't load libwebp support library when start %s process!", new Object[] { BaseApplicationImpl.getMobileQQ().getProcessName() }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.WebP
 * JD-Core Version:    0.7.0.1
 */