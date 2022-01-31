package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aoke;
import aokf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class OnlineFileSessionCenter$1
  implements Runnable
{
  public OnlineFileSessionCenter$1(aoke paramaoke, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    aoke.a(this.this$0, new aokf(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.a.getApp().registerReceiver(aoke.a(this.this$0), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1
 * JD-Core Version:    0.7.0.1
 */