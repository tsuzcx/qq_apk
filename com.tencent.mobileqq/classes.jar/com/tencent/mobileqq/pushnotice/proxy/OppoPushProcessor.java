package com.tencent.mobileqq.pushnotice.proxy;

import com.heytap.msp.push.HeytapPushManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class OppoPushProcessor
  extends ThirdPushProcessorImpl
{
  public OppoPushProcessor()
  {
    try
    {
      HeytapPushManager.init(BaseApplicationImpl.getContext(), true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("OPUSH", 1, "init error! ", localException);
    }
  }
  
  public void a()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (!c()) {
        return;
      }
      HeytapPushManager.register(localBaseApplication, "b5808b3d9wGkWsoW4C4sO40wo", "7BCae2b64B939196D86210a12B024508", new OppoPushProcessor.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("OPUSH", 1, "registerPush error! ", localException);
    }
  }
  
  public int b()
  {
    return 4;
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = HeytapPushManager.isSupportPush();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("OPUSH", 1, "isSupport error! ", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.OppoPushProcessor
 * JD-Core Version:    0.7.0.1
 */