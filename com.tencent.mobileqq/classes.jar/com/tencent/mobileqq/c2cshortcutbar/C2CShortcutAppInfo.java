package com.tencent.mobileqq.c2cshortcutbar;

import java.util.ArrayList;

public class C2CShortcutAppInfo
{
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public int i;
  public int j;
  public boolean k;
  public String l;
  public ArrayList<C2CShortcutAppInfo.Label> m;
  public int n;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CShortcutAppInfo{appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cmdTrace='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redPoint=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", showFrame=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", playingNum=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", canSendArkMsg=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", arkLabelWording=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", labels=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.n);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo
 * JD-Core Version:    0.7.0.1
 */