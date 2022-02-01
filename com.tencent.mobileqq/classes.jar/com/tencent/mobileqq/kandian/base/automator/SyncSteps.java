package com.tencent.mobileqq.kandian.base.automator;

import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class SyncSteps
  extends BaseStep
  implements StepGroup
{
  private LinkedList a;
  private final BaseStep[] b;
  
  public SyncSteps(@NotNull Automator paramAutomator, @NotNull BaseStep[] paramArrayOfBaseStep)
  {
    super(paramAutomator, false, "SyncSteps");
    this.b = paramArrayOfBaseStep;
    this.a = new LinkedList();
    int j = paramArrayOfBaseStep.length;
    j = paramArrayOfBaseStep.length;
    while (i < j)
    {
      paramArrayOfBaseStep[i].a(this);
      i += 1;
    }
    Collections.addAll(this.a, paramArrayOfBaseStep);
  }
  
  public boolean a()
  {
    super.a();
    this.a.clear();
    Collections.addAll(this.a, this.b);
    return true;
  }
  
  public boolean b()
  {
    d();
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
    if (!this.a.isEmpty())
    {
      Object localObject = (BaseStep)this.a.removeFirst();
      if (((BaseStep)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (BaseStep)localObject);
        if (((BaseStep)localObject).i())
        {
          local1.run();
          return;
        }
        localObject = h().b();
        if (localObject != null)
        {
          ((IThreadExecutor)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      h().b(new SyncSteps.2(this, (BaseStep)localObject));
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.SyncSteps
 * JD-Core Version:    0.7.0.1
 */