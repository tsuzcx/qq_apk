package com.tencent.mobileqq.kandian.base.automator;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;

public abstract class BasePopupStep
{
  @NonNull
  private RIJPopupAutomator a;
  private boolean b = false;
  private boolean c = false;
  @NonNull
  private String d = getClass().getSimpleName();
  
  public BasePopupStep(@NonNull RIJPopupAutomator paramRIJPopupAutomator, @NonNull String paramString)
  {
    this.a = paramRIJPopupAutomator;
    this.d = paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onCreate");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  @UiThread
  public void a(boolean paramBoolean)
  {
    this.a.a(this, paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onDestroy");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    this.b = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onResume");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.b = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onPause");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    this.c = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onShowSelf");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void f()
  {
    this.c = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(") onHideSelf");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  protected abstract void h();
  
  protected abstract void i();
  
  public RIJPopupAutomator k()
  {
    return this.a;
  }
  
  @NonNull
  public String toString()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.BasePopupStep
 * JD-Core Version:    0.7.0.1
 */