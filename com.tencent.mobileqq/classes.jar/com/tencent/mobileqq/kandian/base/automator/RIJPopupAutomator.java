package com.tencent.mobileqq.kandian.base.automator;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class RIJPopupAutomator
{
  private ArrayList<BasePopupStep> a = new ArrayList();
  private int b = 0;
  private boolean c = false;
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private void j()
  {
    if (this.b < this.a.size())
    {
      BasePopupStep localBasePopupStep = (BasePopupStep)this.a.get(this.b);
      if (this.c)
      {
        localBasePopupStep.i();
        return;
      }
      localBasePopupStep.h();
      return;
    }
    QLog.d("RIJPopupAutomator", 2, "startNext currentIndex out of bound");
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).a();
    }
  }
  
  void a(BasePopupStep paramBasePopupStep, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finishStep(");
      localStringBuilder.append(paramBasePopupStep.toString());
      localStringBuilder.append("): isShown = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RIJPopupAutomator", 2, localStringBuilder.toString());
    }
    this.d.compareAndSet(false, paramBoolean);
    if (!paramBoolean)
    {
      this.b += 1;
      j();
    }
  }
  
  public void a(BasePopupStep... paramVarArgs)
  {
    this.d.compareAndSet(true, false);
    this.a.addAll(Arrays.asList(paramVarArgs));
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnResume");
    this.b = 0;
    this.c = false;
    j();
  }
  
  public void h()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnShowSelf");
    this.b = 0;
    this.c = true;
    j();
  }
  
  public boolean i()
  {
    return this.d.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator
 * JD-Core Version:    0.7.0.1
 */