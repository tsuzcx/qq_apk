package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public class DataFactory$EmojiPayReqData
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.n = paramString11;
  }
  
  public DataFactory$EmojiPayReqData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
    this.l = paramString12;
    this.m = paramString13;
    this.n = paramString14;
  }
  
  public static EmojiPayReqData a(Bundle paramBundle)
  {
    String str1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("callbackid");
      String str2 = paramBundle.getString("appid");
      localObject1 = paramBundle.getString("userId");
      localObject2 = paramBundle.getString("userKey");
      localObject3 = paramBundle.getString("sessionId");
      localObject4 = paramBundle.getString("sessionType");
      localObject5 = paramBundle.getString("zoneId");
      localObject6 = paramBundle.getString("pf");
      localObject7 = paramBundle.getString("pfKey");
      localObject8 = paramBundle.getString("tokenUrl");
      localObject9 = paramBundle.getString("discountId");
      localObject10 = paramBundle.getString("other");
      localObject11 = paramBundle.getString("payload");
      localObject12 = paramBundle.getString("drmInfo");
      paramBundle = str2;
    }
    else
    {
      str1 = "";
      paramBundle = str1;
      localObject1 = paramBundle;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject6 = localObject5;
      localObject7 = localObject6;
      localObject8 = localObject7;
      localObject9 = localObject8;
      localObject10 = localObject9;
      localObject11 = localObject10;
      localObject12 = localObject11;
    }
    return new EmojiPayReqData(str1, paramBundle, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12);
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackid", this.a);
    localBundle.putString("appid", this.b);
    localBundle.putString("userId", this.c);
    localBundle.putString("userKey", this.d);
    localBundle.putString("sessionId", this.e);
    localBundle.putString("sessionType", this.f);
    localBundle.putString("zoneId", this.g);
    localBundle.putString("pf", this.h);
    localBundle.putString("pfKey", this.i);
    localBundle.putString("tokenUrl", this.j);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData
 * JD-Core Version:    0.7.0.1
 */