package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class Step$QIPCConnectStep
{
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "tryConnect");
    }
    try
    {
      Method localMethod = BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.qipc.QIPCEnvironmentInit").getDeclaredMethod("initEnvironment", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIPCEnvironmentInit", 2, "tryConnect", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.QIPCConnectStep
 * JD-Core Version:    0.7.0.1
 */