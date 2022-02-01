package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;

public class AbsShareMsg$Builder
{
  String A = null;
  Class<? extends AbsShareMsg> a;
  AbsShareMsg b;
  int c = -1;
  int d = -1;
  String e = "web";
  String f = null;
  String g = null;
  String h = null;
  String i = null;
  String j = null;
  String k = null;
  int l;
  int m;
  int n;
  String o = null;
  String p = null;
  String q = null;
  String r = null;
  String s = null;
  String t = null;
  String u = null;
  long v = -1L;
  boolean w;
  String x = null;
  String y = null;
  long z = 0L;
  
  public AbsShareMsg$Builder(Class<? extends AbsShareMsg> paramClass)
  {
    this.a = paramClass;
    this.c = 1;
    this.d = 1;
    this.e = "web";
    this.l = 29;
  }
  
  public Builder a(int paramInt)
  {
    this.n = paramInt;
    if ((paramInt & 0x1) == 1) {
      this.m = 1;
    }
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.v = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder a(String paramString1, String paramString2)
  {
    this.u = paramString1;
    this.t = paramString2;
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
      this.w = true;
    }
    return this;
  }
  
  public Builder a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.e = paramString1;
    this.i = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    return this;
  }
  
  public AbsShareMsg a()
  {
    try
    {
      this.b = ((AbsShareMsg)this.a.newInstance());
    }
    catch (IllegalAccessException|InstantiationException localIllegalAccessException)
    {
      label17:
      AbsShareMsg localAbsShareMsg;
      break label17;
    }
    localAbsShareMsg = this.b;
    if (localAbsShareMsg != null)
    {
      localAbsShareMsg.mMsgTemplateID = this.c;
      localAbsShareMsg.mMsgServiceID = this.d;
      localAbsShareMsg.mVersion = this.l;
      localAbsShareMsg.mMsgAction = this.e;
      localAbsShareMsg.mMsgActionData = this.f;
      localAbsShareMsg.mMsg_A_ActionData = this.g;
      localAbsShareMsg.mMsg_I_ActionData = this.h;
      localAbsShareMsg.mMsgUrl = this.i;
      localAbsShareMsg.mMsgBrief = this.j;
      localAbsShareMsg.mCompatibleText = this.k;
      localAbsShareMsg.mFlag = this.n;
      localAbsShareMsg.mSourceAction = this.p;
      localAbsShareMsg.mSourceUrl = this.o;
      localAbsShareMsg.mSourceActionData = this.q;
      localAbsShareMsg.mSource_A_ActionData = this.r;
      localAbsShareMsg.mSource_I_ActionData = this.s;
      localAbsShareMsg.mSourceName = this.u;
      localAbsShareMsg.mSourceIcon = this.t;
      localAbsShareMsg.mHasSource = this.w;
      localAbsShareMsg.mResid = this.x;
      localAbsShareMsg.mFileName = this.y;
      localAbsShareMsg.mFileSize = this.z;
      localAbsShareMsg.mSType = this.A;
    }
    return this.b;
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.x = paramString;
    return this;
  }
  
  public Builder b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.p = paramString1;
    this.o = paramString2;
    this.q = paramString3;
    this.r = paramString4;
    this.s = paramString5;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.y = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    return a("web", paramString, null, null, null);
  }
  
  public Builder f(String paramString)
  {
    return b("web", paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.Builder
 * JD-Core Version:    0.7.0.1
 */