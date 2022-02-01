package com.tencent.mobileqq.guild.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;

public class ChannelTitleLayout$Param
{
  public final String a;
  public final String b;
  public final boolean c;
  public final boolean d;
  public final String e;
  public final int f;
  
  public ChannelTitleLayout$Param(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.b = paramString2;
    this.e = paramString3;
    this.f = paramInt;
  }
  
  boolean a()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
  
  boolean b()
  {
    return TextUtils.isEmpty(GuildCoverInfo.a(this.e).d()) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ChannelTitleLayout.Param
 * JD-Core Version:    0.7.0.1
 */