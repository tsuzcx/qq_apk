package com.tencent.mobileqq.kandian.base.automator;

import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class SyncSteps
  extends BaseStep
  implements StepGroup
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final BaseStep[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep;
  
  public SyncSteps(@NotNull Automator paramAutomator, @NotNull BaseStep[] paramArrayOfBaseStep)
  {
    super(paramAutomator, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep = paramArrayOfBaseStep;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfBaseStep.length;
    j = paramArrayOfBaseStep.length;
    while (i < j)
    {
      paramArrayOfBaseStep[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfBaseStep);
  }
  
  public void a()
  {
    super.a();
    BaseStep[] arrayOfBaseStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep;
    int j = arrayOfBaseStep.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBaseStep[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (BaseStep)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((BaseStep)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (BaseStep)localObject);
        if (((BaseStep)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((IThreadExecutor)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (BaseStep)localObject));
      return;
    }
    d();
  }
  
  public boolean b()
  {
    b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.SyncSteps
 * JD-Core Version:    0.7.0.1
 */