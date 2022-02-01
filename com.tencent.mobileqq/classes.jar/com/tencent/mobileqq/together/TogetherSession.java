package com.tencent.mobileqq.together;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ThemeImageWrapper;

public abstract class TogetherSession
  implements Cloneable
{
  public long c;
  public long d;
  public int e;
  public long e;
  public String e = "";
  public int f;
  public String f;
  public int g = -1;
  @Nullable
  public String g;
  public int h;
  public String h;
  public int i;
  public int j;
  public int k;
  public int l = 0;
  
  public TogetherSession()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return ThemeImageWrapper.MODE_SQURE;
  }
  
  public String a()
  {
    return "";
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      str = a(paramQQAppInterface, this.e, this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str)) {
        str = TogetherUtils.a(16, str);
      }
    }
    for (;;)
    {
      return str + paramQQAppInterface.getApp().getString(paramInt);
      str = paramQQAppInterface.getApp().getString(2131699345);
      continue;
      str = paramQQAppInterface.getApp().getString(2131699345);
    }
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = "";
    String str;
    if (this.jdField_h_of_type_Int != 3)
    {
      str = a(paramQQAppInterface, 2131699309);
      if (this.g != 1) {
        break label60;
      }
      localObject = str + paramQQAppInterface.getApp().getString(paramInt1);
    }
    label60:
    do
    {
      return localObject;
      localObject = str;
    } while (this.g <= 1);
    return str + String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.g) });
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "";
    if (this.jdField_h_of_type_Int != 3)
    {
      if (this.g == 1) {
        str = "" + paramQQAppInterface.getApp().getString(paramInt1);
      }
    }
    else {
      return str;
    }
    if (this.g > 1) {
      return "" + String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.g) });
    }
    return a(paramQQAppInterface, paramInt3);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ContactUtils.p(paramQQAppInterface, paramString);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return ContactUtils.g(paramQQAppInterface, paramString1, paramString2);
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public boolean a()
  {
    return ((this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 1)) && (!TextUtils.isEmpty(this.e));
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public int d()
  {
    return 2131699383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherSession
 * JD-Core Version:    0.7.0.1
 */