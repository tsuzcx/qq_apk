package com.tencent.sveffects;

import android.app.Application;
import com.tencent.mobileqq.shortvideo.resource.Resources;

public class SdkContext
{
  private static SdkContext jdField_a_of_type_ComTencentSveffectsSdkContext = new SdkContext();
  private Application jdField_a_of_type_AndroidAppApplication;
  private Resources jdField_a_of_type_ComTencentMobileqqShortvideoResourceResources;
  private DpcSwitcher jdField_a_of_type_ComTencentSveffectsDpcSwitcher;
  private Logger jdField_a_of_type_ComTencentSveffectsLogger;
  private Reporter jdField_a_of_type_ComTencentSveffectsReporter;
  private String jdField_a_of_type_JavaLangString;
  
  public static SdkContext a()
  {
    return jdField_a_of_type_ComTencentSveffectsSdkContext;
  }
  
  public Application a()
  {
    return this.jdField_a_of_type_AndroidAppApplication;
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoResourceResources;
  }
  
  public DpcSwitcher a()
  {
    return this.jdField_a_of_type_ComTencentSveffectsDpcSwitcher;
  }
  
  public Logger a()
  {
    if (this.jdField_a_of_type_ComTencentSveffectsLogger == null) {
      this.jdField_a_of_type_ComTencentSveffectsLogger = new DefaultLogger();
    }
    return this.jdField_a_of_type_ComTencentSveffectsLogger;
  }
  
  public Reporter a()
  {
    return this.jdField_a_of_type_ComTencentSveffectsReporter;
  }
  
  public void a(String paramString, Application paramApplication, DpcSwitcher paramDpcSwitcher, Resources paramResources, Logger paramLogger, Reporter paramReporter)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_ComTencentSveffectsDpcSwitcher = paramDpcSwitcher;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoResourceResources = paramResources;
    this.jdField_a_of_type_ComTencentSveffectsLogger = paramLogger;
    this.jdField_a_of_type_ComTencentSveffectsReporter = paramReporter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sveffects.SdkContext
 * JD-Core Version:    0.7.0.1
 */