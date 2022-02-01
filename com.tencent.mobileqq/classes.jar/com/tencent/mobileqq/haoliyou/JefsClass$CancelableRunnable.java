package com.tencent.mobileqq.haoliyou;

import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.qphone.base.util.QLog;

public class JefsClass$CancelableRunnable
  implements JefsClass.IdSetter, Runnable
{
  boolean a = false;
  WeakOuterRefRunnable b;
  
  JefsClass$CancelableRunnable(WeakOuterRefRunnable paramWeakOuterRefRunnable)
  {
    this.b = paramWeakOuterRefRunnable;
  }
  
  public JefsClass.Cancelable a()
  {
    return new JefsClass.Cancelable(this);
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void run()
  {
    if (!this.a)
    {
      JefsClass.a(JefsClass.getInstance(), this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "canceled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.CancelableRunnable
 * JD-Core Version:    0.7.0.1
 */