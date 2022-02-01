package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class long
{
  public ITuringDeviceInfoProvider I;
  public Context J;
  public int K = 0;
  public String Q = "";
  public boolean R = true;
  public String S = "";
  public String U = "";
  public String W = "";
  public String aa = "";
  public int ba = 0;
  public String ca = "";
  public Map<Integer, String> da = new HashMap();
  public String ea = "";
  public boolean fa = true;
  public boolean ga = false;
  public boolean ha = false;
  public boolean ia = true;
  public int ja = 5000;
  public int ka = 3;
  public String metaData;
  
  public final boolean A()
  {
    return this.ha;
  }
  
  public final boolean B()
  {
    return this.fa;
  }
  
  public final boolean C()
  {
    return this.ga;
  }
  
  public final boolean D()
  {
    return this.R;
  }
  
  public boolean E()
  {
    return this.ia;
  }
  
  public final Context getContext()
  {
    return this.J;
  }
  
  public String getMetaData()
  {
    return this.metaData;
  }
  
  public final int getTimeout()
  {
    return this.ja;
  }
  
  public final String getUniqueId()
  {
    if (TextUtils.isEmpty(this.Q)) {
      return "";
    }
    return this.Q;
  }
  
  public final String o()
  {
    if (TextUtils.isEmpty(this.ea)) {
      return "";
    }
    return this.ea;
  }
  
  public int p()
  {
    return this.ba;
  }
  
  public String q()
  {
    return this.W;
  }
  
  public String r()
  {
    return this.ca;
  }
  
  public Map<Integer, String> s()
  {
    return this.da;
  }
  
  public String t()
  {
    return this.aa;
  }
  
  public final int u()
  {
    return this.ka;
  }
  
  public String v()
  {
    return this.U;
  }
  
  public final void w() {}
  
  public ITuringDeviceInfoProvider x()
  {
    return this.I;
  }
  
  public else y()
  {
    String str;
    if (!TextUtils.isEmpty(this.S))
    {
      Log.i("TuringFdJava", this.S);
      str = this.S;
    }
    else
    {
      str = "https://tdid.m.qq.com?mc=2";
    }
    return new boolean(str);
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.long
 * JD-Core Version:    0.7.0.1
 */