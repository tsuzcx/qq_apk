package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class OnlineFileSessionCenter$1
  implements Runnable
{
  OnlineFileSessionCenter$1(OnlineFileSessionCenter paramOnlineFileSessionCenter, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    OnlineFileSessionCenter.a(this.this$0, new OnlineFileSessionCenter.1.1(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.a.getApp().registerReceiver(OnlineFileSessionCenter.a(this.this$0), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1
 * JD-Core Version:    0.7.0.1
 */