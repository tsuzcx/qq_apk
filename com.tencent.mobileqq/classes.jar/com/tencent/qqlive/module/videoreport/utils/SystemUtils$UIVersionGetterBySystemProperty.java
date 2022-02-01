package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

class SystemUtils$UIVersionGetterBySystemProperty
  extends SystemUtils.AbstractUIVersionGetter
{
  private String mPropertyName;
  
  SystemUtils$UIVersionGetterBySystemProperty(String paramString1, @NonNull String paramString2)
  {
    super(paramString1);
    this.mPropertyName = paramString2;
  }
  
  public String getUIVersion()
  {
    String str2 = SystemUtils.access$000(this.mPropertyName);
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (TextUtils.isEmpty(this.mUIPrefix));
    return this.mUIPrefix + " " + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils.UIVersionGetterBySystemProperty
 * JD-Core Version:    0.7.0.1
 */