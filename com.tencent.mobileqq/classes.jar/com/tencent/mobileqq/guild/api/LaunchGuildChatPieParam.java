package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import android.text.TextUtils;

public class LaunchGuildChatPieParam
{
  public String a;
  public String b;
  public String c;
  public int d = 0;
  public boolean e = false;
  public boolean f = true;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public boolean j = false;
  public boolean k = false;
  public Bundle l;
  
  public LaunchGuildChatPieParam a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public LaunchGuildChatPieParam a(Bundle paramBundle)
  {
    this.l = paramBundle;
    return this;
  }
  
  public LaunchGuildChatPieParam a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public LaunchGuildChatPieParam a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b);
  }
  
  public LaunchGuildChatPieParam b()
  {
    return this;
  }
  
  public LaunchGuildChatPieParam b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public LaunchGuildChatPieParam b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public LaunchGuildChatPieParam b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public LaunchGuildChatPieParam c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public LaunchGuildChatPieParam c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public LaunchGuildChatPieParam d(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public LaunchGuildChatPieParam e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public LaunchGuildChatPieParam f(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("guildId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("channelId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("uinName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("channelType:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    localStringBuilder.append("keepOpenPos:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("withoutAnimation:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append("openOnRight:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("forceStartActivity:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append("from:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" ");
    localStringBuilder.append("diableReuse:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append("updateSession:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" ");
    localStringBuilder.append("guildExtra:");
    Object localObject = this.l;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((Bundle)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam
 * JD-Core Version:    0.7.0.1
 */