package com.tencent.mobileqq.kandian.base.automator;

import org.jetbrains.annotations.NotNull;

public final class AsyncSteps
  extends BaseStep
  implements StepGroup
{
  private int jdField_a_of_type_Int;
  private final BaseStep[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep;
  
  public AsyncSteps(@NotNull Automator paramAutomator, @NotNull BaseStep[] paramArrayOfBaseStep)
  {
    super(paramAutomator, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep = paramArrayOfBaseStep;
    paramAutomator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep;
    int j = paramAutomator.length;
    while (i < j)
    {
      paramAutomator[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncSteps onEnd: mFinishCount = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    a(localStringBuilder.toString());
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep.length) {
      d();
    }
  }
  
  public boolean b()
  {
    BaseStep[] arrayOfBaseStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseAutomatorBaseStep;
    int j = arrayOfBaseStep.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfBaseStep[i];
      if (((BaseStep)localObject).a())
      {
        AsyncSteps.1 local1 = new AsyncSteps.1(this, (BaseStep)localObject);
        if (((BaseStep)localObject).c())
        {
          local1.run();
        }
        else
        {
          localObject = a().a();
          if (localObject != null) {
            ((IThreadExecutor)localObject).a(local1);
          } else {
            new Thread(local1).start();
          }
        }
      }
      else
      {
        a().b(new AsyncSteps.2(this, (BaseStep)localObject));
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.AsyncSteps
 * JD-Core Version:    0.7.0.1
 */