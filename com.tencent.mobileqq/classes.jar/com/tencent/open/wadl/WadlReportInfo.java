package com.tencent.open.wadl;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlReportInfo
{
  public static String a;
  private static int b = DeviceInfoUtil.e();
  private static String f = ;
  private static String g;
  public int a;
  private long jdField_a_of_type_Long;
  public WadlParams a;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  public String d = "";
  public String e;
  private String h;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceInfoUtil.a();
    g = DeviceInfoUtil.b();
  }
  
  public static WadlReportInfo a()
  {
    WadlReportInfo localWadlReportInfo = new WadlReportInfo();
    try
    {
      localWadlReportInfo.jdField_a_of_type_Boolean = AppNetConnInfo.isWifiConn();
      localWadlReportInfo.jdField_a_of_type_Long = (DeviceInfoUtil.f() / 1048576L);
      localWadlReportInfo.h = String.valueOf(DeviceInfoUtil.b()[1]);
      localWadlReportInfo.i = "";
      localWadlReportInfo.jdField_a_of_type_Int = 0;
      return localWadlReportInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localWadlReportInfo;
  }
  
  public WadlReportInfo a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public WadlReportInfo a(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(f))
        {
          String str1 = f;
          localJSONObject.put("androidId", str1);
          if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
            break label161;
          }
          str1 = jdField_a_of_type_JavaLangString;
          localJSONObject.put("imei", str1);
          if (!TextUtils.isEmpty(g))
          {
            str1 = g;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", b);
            localJSONObject.put("isWifiStatusOn", this.jdField_a_of_type_Boolean);
            localJSONObject.put("leftMemorySize", this.jdField_a_of_type_Long);
            localJSONObject.put("leftDiskSize", this.h);
            localJSONObject.put("downloadRate", this.i);
            localJSONObject.put("pageUrl", this.e);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label161:
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlReportInfo
 * JD-Core Version:    0.7.0.1
 */