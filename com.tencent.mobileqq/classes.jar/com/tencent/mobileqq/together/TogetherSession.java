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
      } else {
        str = paramQQAppInterface.getApp().getString(2131699450);
      }
    }
    else
    {
      str = paramQQAppInterface.getApp().getString(2131699450);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramQQAppInterface.getApp().getString(paramInt));
    return localStringBuilder.toString();
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.jdField_h_of_type_Int != 3)
    {
      String str = a(paramQQAppInterface, 2131699414);
      int m = this.g;
      if (m == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(paramInt1));
        return ((StringBuilder)localObject).toString();
      }
      localObject = str;
      if (m > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.g) }));
        return ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.jdField_h_of_type_Int;
    Object localObject = "";
    if (m != 3)
    {
      m = this.g;
      if (m == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(paramInt1));
        return ((StringBuilder)localObject).toString();
      }
      if (m > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.g) }));
        return ((StringBuilder)localObject).toString();
      }
      localObject = a(paramQQAppInterface, paramInt3);
    }
    return localObject;
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ContactUtils.i(paramQQAppInterface, paramString);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return ContactUtils.b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public boolean a()
  {
    int m = this.jdField_f_of_type_Int;
    return ((m == 2) || (m == 1)) && (!TextUtils.isEmpty(this.e));
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
    return 2131699488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherSession
 * JD-Core Version:    0.7.0.1
 */