package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.qphone.base.util.QLog;

class MiniAppEntityManager$1
  implements Runnable
{
  MiniAppEntityManager$1(MiniAppEntityManager paramMiniAppEntityManager) {}
  
  public void run()
  {
    try
    {
      MiniAppEntityManager.access$000(this.this$0).verifyAuthentication();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppEntityManager", 1, "verifyAuthentication error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager.1
 * JD-Core Version:    0.7.0.1
 */