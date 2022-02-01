package com.tencent.mobileqq.guild.live.livemanager.model;

import android.graphics.drawable.Drawable;

public class QQGuildLiveGiftMsgModel
{
  private Drawable a;
  private String b;
  private String c;
  private Drawable d;
  
  public Drawable a()
  {
    return this.a;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(Drawable paramDrawable)
  {
    this.d = paramDrawable;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Drawable d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGuildLiveGiftMsgModel{userHeadDrawable=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", userNick='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", giftDrawable=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel
 * JD-Core Version:    0.7.0.1
 */