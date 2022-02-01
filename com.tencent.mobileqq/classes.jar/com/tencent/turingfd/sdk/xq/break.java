package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class break
{
  public String Ad = "";
  public int Bd = 0;
  public String Cd = "";
  public String Da = "";
  public Map<Integer, String> Dd = new HashMap();
  public boolean Ed = true;
  public Context F;
  public boolean Fd = false;
  public boolean Gd = false;
  public boolean Hd = true;
  public int Id = 5000;
  public int Jd = 3;
  public String metaData;
  public this ud;
  public String vd = "";
  public boolean wd = true;
  public String xd = "";
  public int ya = 0;
  public String yd = "";
  public String zd = "";
  
  public final boolean A()
  {
    return this.Gd;
  }
  
  public final boolean B()
  {
    return this.Ed;
  }
  
  public final boolean C()
  {
    return this.Fd;
  }
  
  public final boolean D()
  {
    return this.wd;
  }
  
  public boolean E()
  {
    return this.Hd;
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
    return this.Id;
  }
  
  public final String getUniqueId()
  {
    if (TextUtils.isEmpty(this.vd)) {
      return "";
    }
    return this.vd;
  }
  
  public final String o()
  {
    if (TextUtils.isEmpty(this.Da)) {
      return "";
    }
    return this.Da;
  }
  
  public int p()
  {
    return this.Bd;
  }
  
  public String q()
  {
    return this.zd;
  }
  
  public String r()
  {
    return this.Cd;
  }
  
  public Map<Integer, String> s()
  {
    return this.Dd;
  }
  
  public String t()
  {
    return this.Ad;
  }
  
  public final int u()
  {
    return this.Jd;
  }
  
  public String v()
  {
    return this.yd;
  }
  
  public final void w() {}
  
  public void x() {}
  
  public long y()
  {
    String str;
    if (!TextUtils.isEmpty(this.xd))
    {
      Log.i("TuringFdJava", this.xd);
      str = this.xd;
    }
    else
    {
      str = "https://tdid.m.qq.com?mc=2";
    }
    return new default(str);
  }
  
  public this z()
  {
    return this.ud;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.break
 * JD-Core Version:    0.7.0.1
 */