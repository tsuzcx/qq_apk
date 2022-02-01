package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class DataCollector
{
  static String a = "DataCollector";
  private static HandlerThread d = new HandlerThread("Colloector-Tasker");
  public boolean b = true;
  Handler c = new DataCollector.1(this, d.getLooper());
  
  static
  {
    d.start();
  }
  
  public DataCollector(Context paramContext)
  {
    a = getClass().getSimpleName();
  }
  
  static Looper e()
  {
    return d.getLooper();
  }
  
  protected void a(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataCollector
 * JD-Core Version:    0.7.0.1
 */