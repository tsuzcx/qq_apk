package com.tencent.sveffects;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import java.io.File;

public class SvEffectSdkInitor
{
  private static final String a;
  private static volatile boolean b = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.a);
    localStringBuilder.append("/qav");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("beauty");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      boolean bool = b;
      if (bool) {
        return;
      }
      SdkContext.getInstance().init("QQ", BaseApplicationImpl.getContext(), new SvEffectSdkInitor.QQDpcSwitcher(), new SvEffectSdkInitor.QQResources(), new SvEffectSdkInitor.QQLogger(), new SvEffectSdkInitor.QQReporter());
      b = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor
 * JD-Core Version:    0.7.0.1
 */