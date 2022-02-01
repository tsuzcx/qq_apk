package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.listentogether.ListenTogetherSession;

public class BaseListenTogetherPanel$UiData
{
  int a = -1;
  String b = "";
  int c;
  int d;
  boolean e;
  boolean f;
  long g;
  long h;
  int i;
  boolean j = true;
  boolean k = false;
  String l = "";
  String m = "";
  String n = null;
  int o;
  int p = 0;
  ListenTogetherSession q;
  
  public void a()
  {
    this.c = 0;
    this.d = -1;
    this.i = 0;
    this.j = true;
    this.q = null;
    this.g = 0L;
    this.h = 0L;
    this.k = false;
    this.m = "";
    this.n = null;
    this.l = "";
    this.o = 1;
    this.p = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UiData{mCurType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCurUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", changeMusic=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", isAdmin=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", canOper=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", playMode=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mutualLevel=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", creatorUin=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", creatorNick=");
    String str2 = this.n;
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(", isShowPanel=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", progres=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", titleMsg=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", session=\n");
    localStringBuilder.append(this.q);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.UiData
 * JD-Core Version:    0.7.0.1
 */