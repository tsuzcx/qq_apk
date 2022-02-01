package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class Bullace$do
  extends Handler
{
  public Context a;
  
  public Bullace$do(Bullace paramBullace, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void handleMessage(Message arg1)
  {
    System.currentTimeMillis();
    int i = ???.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      i = ((Integer)???.obj).intValue();
      ??? = Bullace.a(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace, this.jdField_a_of_type_AndroidContentContext, true, false, i);
      Bullace.a(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace, ???, false);
      synchronized (Bullace.b(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace))
      {
        Bullace.b(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace).set(Boolean.valueOf(false));
        Bullace.b(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace).notifyAll();
        return;
      }
    }
    Bullace.b(this.jdField_a_of_type_ComTencentTuringfdSdkXqBullace, this.jdField_a_of_type_AndroidContentContext, true, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bullace.do
 * JD-Core Version:    0.7.0.1
 */