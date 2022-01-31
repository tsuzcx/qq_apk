package com.tencent.mobileqq.startup.step;

import axpj;
import axsm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LoadDex$2
  implements Runnable
{
  LoadDex$2(LoadDex paramLoadDex) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.a().a();
      axpj.b(29, this.this$0.mDirector, null).step();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDex", 2, "", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex.2
 * JD-Core Version:    0.7.0.1
 */