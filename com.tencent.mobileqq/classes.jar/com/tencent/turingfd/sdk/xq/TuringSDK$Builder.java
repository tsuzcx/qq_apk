package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class TuringSDK$Builder
{
  public Context a;
  public String b = "";
  public int c = 5000;
  public int d = 3;
  public String e = "";
  public String f = "";
  public int g = 0;
  public String h = "";
  public int i = 0;
  public Cascara j;
  public Map<Integer, String> k = new HashMap();
  public boolean l = true;
  public String m = "";
  public String n = "";
  public boolean o = true;
  public String p = "turingfd.cert";
  public boolean q = true;
  public boolean r = false;
  public boolean s = true;
  public ITuringPrivacyLite t;
  
  public TuringSDK$Builder(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public final Builder a(ITuringPrivacyLite paramITuringPrivacyLite)
  {
    this.t = paramITuringPrivacyLite;
    return this;
  }
  
  public final Builder a(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public final Builder a(Map<Integer, String> paramMap)
  {
    this.k = paramMap;
    return this;
  }
  
  public final TuringSDK a()
  {
    return new TuringSDK(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringSDK.Builder
 * JD-Core Version:    0.7.0.1
 */