package com.tencent.mobileqq.guild.profilecard.game;

import java.util.ArrayList;
import java.util.List;

public class GuildProfileGameGloryKingData
{
  private String a;
  private boolean b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private List<String> m = new ArrayList();
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.m.clear();
    this.m.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public void g(String paramString)
  {
    this.i = paramString;
  }
  
  public String h()
  {
    return this.j;
  }
  
  public void h(String paramString)
  {
    this.j = paramString;
  }
  
  public String i()
  {
    return this.k;
  }
  
  public void i(String paramString)
  {
    this.k = paramString;
  }
  
  public String j()
  {
    return this.l;
  }
  
  public void j(String paramString)
  {
    this.l = paramString;
  }
  
  public List<String> k()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildProfileGameGloryKingData{mGloryDisplayGrade='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsGradeKing=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mStarNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mBgIconPath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGloryTopGradeKingNumText='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGloryTopIconPath='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGloryBottomIconPath='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGloryInnerIconPath='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTotalNum='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTotalMvp='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mWinRate='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGoodAtRole='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGoodAtHeroes=");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameGloryKingData
 * JD-Core Version:    0.7.0.1
 */