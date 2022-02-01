package com.tencent.mobileqq.kandian.base.automator;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;

public abstract class BasePopupStep
{
  @NonNull
  private RIJPopupAutomator jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
  @NonNull
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public BasePopupStep(@NonNull RIJPopupAutomator paramRIJPopupAutomator, @NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator = paramRIJPopupAutomator;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public RIJPopupAutomator a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onCreate");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  @UiThread
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorRIJPopupAutomator.a(this, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onDestroy");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onResume");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onPause");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    this.b = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onShowSelf");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  public void f()
  {
    this.b = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(") onHideSelf");
      QLog.d("BasePopupStep", 2, localStringBuilder.toString());
    }
  }
  
  protected abstract void g();
  
  protected abstract void h();
  
  @NonNull
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.BasePopupStep
 * JD-Core Version:    0.7.0.1
 */