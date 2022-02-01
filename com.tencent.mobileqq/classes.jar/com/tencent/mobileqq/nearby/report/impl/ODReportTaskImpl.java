package com.tencent.mobileqq.nearby.report.impl;

import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.nearby.report.TurtleReportCenter;
import com.tencent.mobileqq.nearby.report.TurtleReportHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ODReportTaskImpl
  implements IODReportTask
{
  private static final String REPORT_BID_NAME = "b_sng_im_personal_live";
  private static final String REPORT_TABLE_NAME = "personal_live_base";
  private Application mApplication;
  private final Bundle mBundle;
  private String mImei;
  private String mQQVersion;
  
  public ODReportTaskImpl()
  {
    this(BaseApplication.getContext());
  }
  
  public ODReportTaskImpl(Application paramApplication)
  {
    this.mApplication = paramApplication;
    this.mQQVersion = DeviceInfoUtil.c();
    this.mImei = DeviceInfoUtil.a();
    this.mBundle = createBaseReportBundle(this.mApplication);
    this.mBundle.putString("tid", "personal_live_base");
    this.mBundle.putString("bid", "b_sng_im_personal_live");
  }
  
  private Bundle createBaseReportBundle(Application paramApplication)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "Android");
    localBundle.putString("uin_type", "0");
    localBundle.putString("manufacturer", Build.MANUFACTURER);
    localBundle.putString("deviceID", String.valueOf(DeviceInfoUtil.a()));
    localBundle.putString("osversion", Build.VERSION.RELEASE);
    localBundle.putString("osVersion", Build.VERSION.RELEASE);
    localBundle.putString("rom", Build.MANUFACTURER);
    localBundle.putString("device", DeviceInfoUtil.j());
    localBundle.putString("qqversion", this.mQQVersion);
    localBundle.putString("clientVersion", this.mQQVersion);
    localBundle.putString("actiontime", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("network", String.valueOf(TurtleReportHelper.a(paramApplication)));
    localBundle.putString("networktype", String.valueOf(TurtleReportHelper.a(paramApplication)));
    localBundle.putString("timestr", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("reporttime", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("imei", this.mImei);
    return localBundle;
  }
  
  public ODReportTaskImpl addKeyValue(String paramString, double paramDouble)
  {
    this.mBundle.putString(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ODReportTaskImpl addKeyValue(String paramString, int paramInt)
  {
    this.mBundle.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ODReportTaskImpl addKeyValue(String paramString, long paramLong)
  {
    this.mBundle.putString(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ODReportTaskImpl addKeyValue(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "null";
    }
    this.mBundle.putString(paramString1, str.replace("&", "_"));
    return this;
  }
  
  public IODReportTask obj1(int paramInt)
  {
    return addKeyValue("obj1", paramInt);
  }
  
  public IODReportTask obj2(String paramString)
  {
    return addKeyValue("obj2", paramString);
  }
  
  public IODReportTask obj3(int paramInt)
  {
    return addKeyValue("obj3", paramInt);
  }
  
  public void report()
  {
    TurtleReportCenter.a.a(this.mBundle);
  }
  
  public ODReportTaskImpl setAction(String paramString)
  {
    this.mBundle.putString("action", paramString);
    return this;
  }
  
  public IODReportTask setAnchor(long paramLong)
  {
    return addKeyValue("anchor", paramLong);
  }
  
  public IODReportTask setAnchorId(long paramLong)
  {
    return addKeyValue("anchorid", paramLong);
  }
  
  public ODReportTaskImpl setBid(String paramString)
  {
    this.mBundle.putString("bid", paramString);
    return this;
  }
  
  public ODReportTaskImpl setExtCol1(String paramString)
  {
    return addKeyValue("extcol1", paramString);
  }
  
  public ODReportTaskImpl setExtCol2(String paramString)
  {
    return addKeyValue("extcol2", paramString);
  }
  
  public ODReportTaskImpl setExtCol3(String paramString)
  {
    return addKeyValue("extcol3", paramString);
  }
  
  public ODReportTaskImpl setExtCol4(String paramString)
  {
    return addKeyValue("extcol4", paramString);
  }
  
  public ODReportTaskImpl setExtCol5(String paramString)
  {
    return addKeyValue("extcol5", paramString);
  }
  
  public IODReportTask setInstallSrc(String paramString)
  {
    return addKeyValue("installsrc", paramString);
  }
  
  public ODReportTaskImpl setIntCol1(int paramInt)
  {
    return addKeyValue("int1", paramInt);
  }
  
  public ODReportTaskImpl setIntCol1(long paramLong)
  {
    return addKeyValue("int1", paramLong);
  }
  
  public ODReportTaskImpl setIntCol2(int paramInt)
  {
    return addKeyValue("int2", paramInt);
  }
  
  public ODReportTaskImpl setIntCol2(long paramLong)
  {
    return addKeyValue("int2", paramLong);
  }
  
  public ODReportTaskImpl setModule(String paramString)
  {
    this.mBundle.putString("module", paramString);
    return this;
  }
  
  public ODReportTaskImpl setOperName(String paramString)
  {
    this.mBundle.putString("opername", paramString);
    return this;
  }
  
  public IODReportTask setReferId(String paramString)
  {
    return addKeyValue("referer_id", paramString);
  }
  
  public ODReportTaskImpl setRes1(double paramDouble)
  {
    return addKeyValue("res1", paramDouble);
  }
  
  public ODReportTaskImpl setRes1(String paramString)
  {
    return addKeyValue("res1", paramString);
  }
  
  public ODReportTaskImpl setRes2(double paramDouble)
  {
    return addKeyValue("res2", paramDouble);
  }
  
  public ODReportTaskImpl setRes2(String paramString)
  {
    return addKeyValue("res2", paramString);
  }
  
  public ODReportTaskImpl setRes3(double paramDouble)
  {
    return addKeyValue("res3", paramDouble);
  }
  
  public ODReportTaskImpl setRes3(String paramString)
  {
    return addKeyValue("res3", paramString);
  }
  
  public ODReportTaskImpl setRoomId(int paramInt)
  {
    this.mBundle.putInt("roomId", paramInt);
    return this;
  }
  
  public ODReportTaskImpl setSource(String paramString)
  {
    this.mBundle.putString("source", paramString);
    return this;
  }
  
  public ODReportTaskImpl setTDBankImpDate(String paramString)
  {
    this.mBundle.putString("tdbank_imp_date", paramString);
    return this;
  }
  
  public ODReportTaskImpl setTid(String paramString)
  {
    this.mBundle.putString("tid", paramString);
    return this;
  }
  
  public ODReportTaskImpl setType(String paramString)
  {
    this.mBundle.putString("type", paramString);
    return this;
  }
  
  public ODReportTaskImpl setUin(String paramString)
  {
    this.mBundle.putString("uin", paramString);
    return this;
  }
  
  public IODReportTask setUserId(String paramString)
  {
    return addKeyValue("userid", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.impl.ODReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */