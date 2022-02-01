package com.tencent.mobileqq.kandian.base.automator;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class RIJPopupAutomator
{
  private int jdField_a_of_type_Int = 0;
  private ArrayList<BasePopupStep> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  
  private void i()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      BasePopupStep localBasePopupStep = (BasePopupStep)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean)
      {
        localBasePopupStep.h();
        return;
      }
      localBasePopupStep.g();
      return;
    }
    QLog.d("RIJPopupAutomator", 2, "startNext currentIndex out of bound");
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Int += 1;
      i();
    }
  }
  
  public void a(BasePopupStep... paramVarArgs)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(paramVarArgs));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BasePopupStep)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnResume");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    i();
  }
  
  public void h()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnShowSelf");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator
 * JD-Core Version:    0.7.0.1
 */