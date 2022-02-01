package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class break
{
  public Context F;
  public String G = "";
  public int H = 5000;
  public int I = 3;
  public String J = "";
  public String K = "";
  public int Q = 0;
  public String R = "";
  public int S = 0;
  public boolean ca = true;
  public String da = "";
  public String ea = "";
  public String fa = "";
  public boolean ga = true;
  public boolean ha = false;
  public boolean ia = false;
  public boolean ja = true;
  public String metaData;
  
  public final boolean A()
  {
    return this.ha;
  }
  
  public final boolean B()
  {
    return this.ca;
  }
  
  public boolean C()
  {
    return this.ja;
  }
  
  public final Context getContext()
  {
    return this.F;
  }
  
  public String getMetaData()
  {
    return this.metaData;
  }
  
  public final int getTimeout()
  {
    return this.H;
  }
  
  public final String getUniqueId()
  {
    if (TextUtils.isEmpty(this.G)) {
      return "";
    }
    return this.G;
  }
  
  public final String n()
  {
    if (TextUtils.isEmpty(this.fa)) {
      return "";
    }
    return this.fa;
  }
  
  public int o()
  {
    return this.Q;
  }
  
  public String p()
  {
    return this.J;
  }
  
  public String q()
  {
    return this.R;
  }
  
  public String r()
  {
    return this.K;
  }
  
  public final int s()
  {
    return this.I;
  }
  
  public String t()
  {
    return this.ea;
  }
  
  public final void u() {}
  
  public void v() {}
  
  public this w()
  {
    String str;
    if (!TextUtils.isEmpty(this.da))
    {
      Log.i("TuringFdJava", this.da);
      str = this.da;
    }
    else
    {
      str = "https://tdid.m.qq.com?mc=2";
    }
    return new boolean(str);
  }
  
  public void x() {}
  
  public final boolean y()
  {
    return this.ia;
  }
  
  public final boolean z()
  {
    return this.ga;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.break
 * JD-Core Version:    0.7.0.1
 */