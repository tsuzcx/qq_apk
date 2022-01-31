package com.tencent.mobileqq.mini.sdk;

import ajya;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

final class MiniAppLauncher$2
  implements Runnable
{
  MiniAppLauncher$2(String paramString) {}
  
  public void run()
  {
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131706820) + this.val$appId, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.2
 * JD-Core Version:    0.7.0.1
 */