package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.qphone.base.util.QLog;

public class QQGuildGrayUserTypeConfig
{
  private static volatile QQGuildGrayUserTypeConfig.Memento a = new QQGuildGrayUserTypeConfig.Memento();
  private int b = 0;
  
  public static QQGuildGrayUserTypeConfig a()
  {
    try
    {
      Object localObject1 = QQGuildUtil.f();
      if (TextUtils.equals((CharSequence)localObject1, a.a))
      {
        localObject1 = a.b;
        return localObject1;
      }
      a = new QQGuildGrayUserTypeConfig.Memento((String)localObject1, new QQGuildGrayUserTypeConfig());
      localObject1 = a.b;
      return localObject1;
    }
    finally {}
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return String.valueOf(paramInt);
            }
            return "已邀请并同意用户";
          }
          return "内部用户";
        }
        return "KA用户";
      }
      return "已邀请未同意用户";
    }
    return "未知用户";
  }
  
  public void a(int paramInt)
  {
    this.b = (paramInt & 0x7);
    if ((this.b == 1) && (a(paramInt, 8))) {
      this.b = 4;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildGrayUserTypeConfig", 2, new Object[] { "update: ", Integer.toBinaryString(paramInt), " -> ", b(this.b) });
    }
    QQGuildSPUtils.a(this.b);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    int i = this.b;
    return (i == 3) || (i == 4) || (i == 2);
  }
  
  public boolean d()
  {
    return this.b == 3;
  }
  
  public boolean e()
  {
    int i = this.b;
    return (i == 3) || (i == 2);
  }
  
  public boolean f()
  {
    int i = this.b;
    return (i == 3) || (i == 2);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGuildGrayUserTypeConfig{mUserType=");
    localStringBuilder.append(b(this.b));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig
 * JD-Core Version:    0.7.0.1
 */