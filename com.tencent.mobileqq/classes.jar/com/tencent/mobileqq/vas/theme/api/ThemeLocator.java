package com.tencent.mobileqq.vas.theme.api;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import mqq.app.MobileQQ;

public class ThemeLocator
{
  private String a;
  private String b;
  private String c;
  
  public ThemeLocator a()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    return a("999").a(localBaseApplication, "999_540", "999_540");
  }
  
  public ThemeLocator a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext);
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".zip");
    this.b = localStringBuilder.toString();
    localStringBuilder = StringBuilderUtils.a();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    this.c = localStringBuilder.toString();
    return this;
  }
  
  public ThemeLocator a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("theme_810", 0).getAbsolutePath();
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    localStringBuilder.append(paramContext);
    if (!paramContext.endsWith(File.separator)) {
      localStringBuilder.append(File.separator);
    }
    localStringBuilder.append(this.a);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public ThemeLocator b()
  {
    return a(MobileQQ.getContext(), "test", "test");
  }
  
  public String b(Context paramContext)
  {
    paramContext = a(paramContext);
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("3_");
    localStringBuilder.append(e());
    localStringBuilder.append(".cfg");
    return localStringBuilder.toString();
  }
  
  public ThemeLocator c()
  {
    this.b = null;
    this.c = null;
    return this;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public String e()
  {
    return ThemeUtil.getThemeConfigID(this.a);
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return new File(this.b).exists();
  }
  
  public boolean i()
  {
    return new File(this.c).exists();
  }
  
  public String toString()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeLocator
 * JD-Core Version:    0.7.0.1
 */