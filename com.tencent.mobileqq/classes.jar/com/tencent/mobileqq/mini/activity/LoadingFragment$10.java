package com.tencent.mobileqq.mini.activity;

import ajyc;
import android.os.Handler;
import android.os.Message;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class LoadingFragment$10
  implements Runnable
{
  LoadingFragment$10(LoadingFragment paramLoadingFragment, Message paramMessage) {}
  
  public void run()
  {
    String str;
    BaseApplication localBaseApplication;
    if (this.val$msg.obj != null)
    {
      str = (String)this.val$msg.obj;
      localBaseApplication = BaseApplicationImpl.getContext();
      if (str == null) {
        break label68;
      }
    }
    for (;;)
    {
      bcpw.a(localBaseApplication, 1, str, 1).a();
      this.this$0.uiHandler.postDelayed(new LoadingFragment.10.1(this), 1000L);
      return;
      str = null;
      break;
      label68:
      str = ajyc.a(2131706241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.10
 * JD-Core Version:    0.7.0.1
 */