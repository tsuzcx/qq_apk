package com.tencent.mobileqq.kandian.base.automator;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseStep
{
  private long a;
  @Nullable
  private StepGroup b;
  @NotNull
  private final Automator c;
  private final boolean d;
  @Nullable
  private String e;
  
  public BaseStep(@NotNull Automator paramAutomator, boolean paramBoolean, @Nullable String paramString)
  {
    this.c = paramAutomator;
    this.d = paramBoolean;
    this.e = paramString;
    if (this.e == null) {
      this.e = getClass().getSimpleName();
    }
  }
  
  public final void a(@Nullable StepGroup paramStepGroup)
  {
    this.b = paramStepGroup;
  }
  
  protected final void a(@NotNull String paramString)
  {
    Object localObject = this.c.a();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Step(");
      localStringBuilder.append(this.e);
      localStringBuilder.append(')');
      ((ILog)localObject).a(localStringBuilder.toString(), paramString);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Step(");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(')');
    Log.d(((StringBuilder)localObject).toString(), paramString);
  }
  
  public boolean a()
  {
    this.a = System.currentTimeMillis();
    a("onStart");
    return true;
  }
  
  public abstract boolean b();
  
  public void c()
  {
    a("onStop");
  }
  
  @Nullable
  public final StepGroup e()
  {
    return this.b;
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnd, time = ");
    localStringBuilder.append(System.currentTimeMillis() - this.a);
    a(localStringBuilder.toString());
  }
  
  public void g()
  {
    this.c.a(this);
  }
  
  @NotNull
  public final Automator h()
  {
    return this.c;
  }
  
  public final boolean i()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.BaseStep
 * JD-Core Version:    0.7.0.1
 */