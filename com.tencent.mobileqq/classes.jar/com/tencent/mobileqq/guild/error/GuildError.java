package com.tencent.mobileqq.guild.error;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

public class GuildError
{
  public final int a;
  public final String b;
  public final Object c;
  
  private GuildError(int paramInt, @NonNull String paramString, @Nullable Object paramObject)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramObject;
  }
  
  public static GuildError a(int paramInt, @NonNull String paramString)
  {
    return a(paramInt, paramString, null);
  }
  
  public static GuildError a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0) {
      return a(paramInt, paramString, paramIGProSecurityResult);
    }
    if (!QQGuildUtil.a(paramIGProSecurityResult)) {
      return a(-200, "安全错误", paramIGProSecurityResult);
    }
    return a(paramInt, paramString, paramIGProSecurityResult);
  }
  
  public static GuildError a(int paramInt, @NonNull String paramString, Object paramObject)
  {
    return new GuildError(paramInt, paramString, paramObject);
  }
  
  public static GuildError a(@NonNull String paramString)
  {
    return a(0, paramString, null);
  }
  
  public static GuildError b()
  {
    return a("OK");
  }
  
  public boolean a()
  {
    return this.a == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildError{code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", message='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", what=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.error.GuildError
 * JD-Core Version:    0.7.0.1
 */