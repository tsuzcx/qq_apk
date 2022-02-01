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
    String str = SystemUtils.access$000(this.mPropertyName);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject = str;
    if (!TextUtils.isEmpty(this.mUIPrefix))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mUIPrefix);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils.UIVersionGetterBySystemProperty
 * JD-Core Version:    0.7.0.1
 */