package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.qphone.base.util.QLog;

public abstract class a
  implements Runnable
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -2;
  public static final int d = -3;
  protected int e;
  protected a.a f;
  public Object g;
  
  public a(int paramInt, a.a parama)
  {
    this.e = paramInt;
    this.f = parama;
  }
  
  protected abstract int a(String paramString);
  
  protected void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyEchoResult: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("EchoTask", 2, ((StringBuilder)localObject).toString());
    }
    b();
    Object localObject = this.f;
    if (localObject != null) {
      ((a.a)localObject).a(this, this.e, paramInt, paramString, d());
    }
  }
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  protected abstract String c();
  
  protected abstract Object d();
  
  public void run()
  {
    if (!a())
    {
      a(-1, null);
      return;
    }
    String str = c();
    if (str == null)
    {
      a(-2, null);
      return;
    }
    a(a(str), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.a
 * JD-Core Version:    0.7.0.1
 */