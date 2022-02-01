package com.tencent.mobileqq.kandian.base.automator;

import org.jetbrains.annotations.NotNull;

public final class AsyncSteps
  extends BaseStep
  implements StepGroup
{
  private int a;
  private final BaseStep[] b;
  
  public AsyncSteps(@NotNull Automator paramAutomator, @NotNull BaseStep[] paramArrayOfBaseStep)
  {
    super(paramAutomator, false, "AsyncSteps");
    this.b = paramArrayOfBaseStep;
    paramAutomator = this.b;
    int j = paramAutomator.length;
    while (i < j)
    {
      paramAutomator[i].a(this);
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.a = 0;
    return true;
  }
  
  public boolean b()
  {
    BaseStep[] arrayOfBaseStep = this.b;
    int j = arrayOfBaseStep.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfBaseStep[i];
      if (((BaseStep)localObject).a())
      {
        AsyncSteps.1 local1 = new AsyncSteps.1(this, (BaseStep)localObject);
        if (((BaseStep)localObject).i())
        {
          local1.run();
        }
        else
        {
          localObject = h().b();
          if (localObject != null) {
            ((IThreadExecutor)localObject).a(local1);
          } else {
            new Thread(local1).start();
          }
        }
      }
      else
      {
        h().b(new AsyncSteps.2(this, (BaseStep)localObject));
      }
      i += 1;
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    BaseStep[] arrayOfBaseStep = this.b;
    int j = arrayOfBaseStep.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBaseStep[i].c();
      i += 1;
    }
  }
  
  public final void d()
  {
    this.a += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncSteps onEnd: mFinishCount = ");
    localStringBuilder.append(this.a);
    a(localStringBuilder.toString());
    if (this.a == this.b.length) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.AsyncSteps
 * JD-Core Version:    0.7.0.1
 */