package com.tencent.mobileqq.microapp.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class a
{
  private static volatile a b;
  private a.a a;
  private final BroadcastReceiver c = new b(this);
  
  public static a a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new a();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(a.a parama)
  {
    this.a = parama;
    parama = new IntentFilter();
    parama.addAction("android.intent.action.SCREEN_ON");
    parama.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.c, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a
 * JD-Core Version:    0.7.0.1
 */