package com.tencent.mobileqq.kandian.base.automator;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseStep
{
  private long jdField_a_of_type_Long;
  @NotNull
  private final Automator jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorAutomator;
  @Nullable
  private StepGroup jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorStepGroup;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  
  public BaseStep(@NotNull Automator paramAutomator, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorAutomator = paramAutomator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final Automator a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorAutomator;
  }
  
  @Nullable
  public final StepGroup a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorStepGroup;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  public final void a(@Nullable StepGroup paramStepGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorStepGroup = paramStepGroup;
  }
  
  protected final void a(@NotNull String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorAutomator.a();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Step(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(')');
      ((ILog)localObject).a(localStringBuilder.toString(), paramString);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Step(");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(')');
    Log.d(((StringBuilder)localObject).toString(), paramString);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a("onStart");
    return true;
  }
  
  public abstract boolean b();
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnd, time = ");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    a(localStringBuilder.toString());
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorAutomator.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.BaseStep
 * JD-Core Version:    0.7.0.1
 */