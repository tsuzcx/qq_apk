package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.qphone.base.util.QLog;

class PreloadConfig$1
  implements Runnable
{
  PreloadConfig$1(PreloadConfig paramPreloadConfig) {}
  
  public void run()
  {
    synchronized (this.this$0.mSaveLock)
    {
      if (this.this$0.isModulesChange(this.this$0.mLastModules))
      {
        QWalletTools.a(this.this$0, this.this$0.mSavePath);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "really save:" + this.this$0);
        }
        this.this$0.mLastModules = this.this$0.getCloneModules();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadConfig.1
 * JD-Core Version:    0.7.0.1
 */