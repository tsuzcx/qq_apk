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
  public int l;
  public int m;
  public String n = "";
  public int o = -1;
  public int p;
  public int q;
  public String r = "";
  @Nullable
  public String s;
  public long t;
  public int u;
  public int v;
  public String w = "";
  public long x;
  public long y;
  public int z = 0;
  
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
    if (!TextUtils.isEmpty(this.r))
    {
      str = a(paramQQAppInterface, this.n, this.r);
      if (!TextUtils.isEmpty(str)) {
        str = TogetherUtils.a(16, str);
      } else {
        str = paramQQAppInterface.getApp().getString(2131897481);
      }
    }
    else
    {
      str = paramQQAppInterface.getApp().getString(2131897481);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramQQAppInterface.getApp().getString(paramInt));
    return localStringBuilder.toString();
  }
  
  protected String a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.p != 3)
    {
      String str = a(paramQQAppInterface, 2131897445);
      int i = this.o;
      if (i == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(paramInt1));
        return ((StringBuilder)localObject).toString();
      }
      localObject = str;
      if (i > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.o) }));
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
    int i = this.p;
    Object localObject = "";
    if (i != 3)
    {
      i = this.o;
      if (i == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(paramInt1));
        return ((StringBuilder)localObject).toString();
      }
      if (i > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(String.format(paramQQAppInterface.getApp().getString(paramInt2), new Object[] { Integer.valueOf(this.o) }));
        return ((StringBuilder)localObject).toString();
      }
      localObject = a(paramQQAppInterface, paramInt3);
    }
    return localObject;
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ContactUtils.j(paramQQAppInterface, paramString);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return ContactUtils.b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public int b()
  {
    return ThemeImageWrapper.MODE_SQURE;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public int c()
  {
    return 0;
  }
  
  public boolean g()
  {
    int i = this.m;
    return ((i == 2) || (i == 1)) && (!TextUtils.isEmpty(this.n));
  }
  
  public int h()
  {
    return 2131897519;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherSession
 * JD-Core Version:    0.7.0.1
 */