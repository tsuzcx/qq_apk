package com.tencent.mobileqq.winkpublish.uploader.report;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import java.util.HashMap;

public class ReportObj
{
  public static final String j = ;
  public static boolean k = false;
  private String a;
  public int l = 0;
  public int m = 0;
  public String n = "";
  public long o = 0L;
  public long p = 0L;
  public int q;
  public StringBuilder r = new StringBuilder();
  public long s;
  public long t;
  public String u = "";
  public boolean v = false;
  
  protected String a()
  {
    if (this.v) {
      return "water";
    }
    return "mqq";
  }
  
  public boolean b()
  {
    return true;
  }
  
  public HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.u;
    if (localObject != null) {
      localHashMap.put("cmdId", localObject);
    }
    localHashMap.put("size", String.valueOf(this.o));
    localHashMap.put("delay", String.valueOf(this.p));
    localHashMap.put("network", String.valueOf(this.l));
    localHashMap.put("terminal", "Android-QZoneInQQ");
    localHashMap.put("terminalver", j);
    localHashMap.put("refer", a());
    localHashMap.put("errcode", String.valueOf(this.m));
    localHashMap.put("uin", String.valueOf(LoginData.a().b()));
    localHashMap.put("time", String.valueOf(this.t / 1000L));
    localHashMap.put("flow", String.valueOf(this.q));
    localHashMap.put("sip", this.n);
    if (!TextUtils.isEmpty(this.a)) {
      localHashMap.put("appid", this.a);
    }
    localObject = this.r;
    if ((localObject != null) && (((StringBuilder)localObject).length() > 0)) {
      localHashMap.put("msg", this.r.toString());
    }
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkType = ");
    int i = this.l;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          localStringBuilder.append("未知");
        } else {
          localStringBuilder.append("3G");
        }
      }
      else {
        localStringBuilder.append("2G");
      }
    }
    else {
      localStringBuilder.append("WIFI");
    }
    localStringBuilder.append(" retCode = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" serverIP = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" fileSize = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" elapse = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" errMsg = ");
    localStringBuilder.append(this.r.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.report.ReportObj
 * JD-Core Version:    0.7.0.1
 */