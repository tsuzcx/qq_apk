package com.tencent.mobileqq.mini.push;

import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;

class ClearCacheAction$2$1
  implements Runnable
{
  ClearCacheAction$2$1(ClearCacheAction.2 param2) {}
  
  public void run()
  {
    Intent localIntent = new Intent("com.tencent.mobile.mini.process.exit");
    localIntent.setPackage("com.tencent.mobileqq");
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.ClearCacheAction.2.1
 * JD-Core Version:    0.7.0.1
 */