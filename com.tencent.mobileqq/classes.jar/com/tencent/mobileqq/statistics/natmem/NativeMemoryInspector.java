package com.tencent.mobileqq.statistics.natmem;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class NativeMemoryInspector
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("natmem_inspector");
  private boolean jdField_a_of_type_Boolean = false;
  
  public NativeMemoryInspector()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3600000L);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            NatMemMonitor.a().a();
            a();
          }
        }
        else
        {
          NatMemMonitor.a().nativePrintUsage();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
        }
      }
      else
      {
        NatMemMonitor.a().d();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      NatMemMonitor.a().b();
      NatMemMonitor.a().a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3600000L);
      if (this.jdField_a_of_type_Boolean) {
        b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryInspector
 * JD-Core Version:    0.7.0.1
 */