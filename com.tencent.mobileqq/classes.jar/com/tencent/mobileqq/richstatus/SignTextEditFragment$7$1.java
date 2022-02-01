package com.tencent.mobileqq.richstatus;

import bbtv;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignTextEditFragment$7$1
  implements Runnable
{
  public SignTextEditFragment$7$1(bbtv parambbtv) {}
  
  public void run()
  {
    if (SignTextEditFragment.a(this.a.a).get())
    {
      SignTextEditFragment.a(this.a.a).set(false);
      this.a.a.onBackEvent();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.7.1
 * JD-Core Version:    0.7.0.1
 */