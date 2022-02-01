package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;

public class FontConvert
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public static FontConvert a()
  {
    return FontConvert.FontConvertHolder.a;
  }
  
  public String a()
  {
    ResourceInfo localResourceInfo = ((IPreloadService)QWalletHelperImpl.getAppRuntime().getRuntimeService(IPreloadService.class, "")).getResInfoByResId("text_translate");
    if (localResourceInfo == null) {
      return null;
    }
    return localResourceInfo.folderPath;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(this.b)) {
        return paramString;
      }
      Object localObject = new StringBuilder();
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        int j = this.jdField_a_of_type_JavaLangString.indexOf(c);
        if (j != -1) {
          ((StringBuilder)localObject).append(this.b.charAt(j));
        } else {
          ((StringBuilder)localObject).append(c);
        }
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("traditionalToSimplified params is ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",result is ");
        localStringBuilder.append((String)localObject);
        QLog.d("FontConvert", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    return paramString;
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      new Handler(ThreadManager.getSubThreadLooper()).post(new FontConvert.1(this));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.FontConvert
 * JD-Core Version:    0.7.0.1
 */