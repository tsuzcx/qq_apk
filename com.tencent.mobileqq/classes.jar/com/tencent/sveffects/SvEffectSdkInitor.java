package com.tencent.sveffects;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import java.io.File;

public class SvEffectSdkInitor
{
  private static final String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/qav");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("beauty");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      SdkContext.getInstance().init("QQ", BaseApplicationImpl.getContext(), new SvEffectSdkInitor.QQDpcSwitcher(), new SvEffectSdkInitor.QQResources(), new SvEffectSdkInitor.QQLogger(), new SvEffectSdkInitor.QQReporter());
      jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor
 * JD-Core Version:    0.7.0.1
 */