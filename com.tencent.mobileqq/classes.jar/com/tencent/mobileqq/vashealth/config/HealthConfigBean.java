package com.tencent.mobileqq.vashealth.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean;", "", "isRedirectAIO", "", "mainPageUrl", "", "(ZLjava/lang/String;)V", "()Z", "getMainPageUrl", "()Ljava/lang/String;", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthConfigBean
{
  public static final HealthConfigBean.Companion a;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVashealthConfigHealthConfigBean$Companion = new HealthConfigBean.Companion(null);
  }
  
  public HealthConfigBean()
  {
    this(false, null, 3, null);
  }
  
  public HealthConfigBean(boolean paramBoolean, @NotNull String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthConfigBean
 * JD-Core Version:    0.7.0.1
 */