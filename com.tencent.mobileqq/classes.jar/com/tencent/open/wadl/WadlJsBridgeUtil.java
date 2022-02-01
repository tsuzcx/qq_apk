package com.tencent.open.wadl;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.open.adapter.CommonDataAdapter;
import org.json.JSONObject;

public class WadlJsBridgeUtil
{
  public static int a(int paramInt)
  {
    if (paramInt == 6) {
      return 4;
    }
    if (paramInt == 4) {
      return 2;
    }
    if (paramInt == 5) {
      return 3;
    }
    if ((paramInt == 7) || (paramInt == 14)) {
      return -2;
    }
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 9) {
      return 6;
    }
    if (paramInt == 11) {
      return 9;
    }
    if (paramInt == 12) {
      return 10;
    }
    if ((paramInt == 2) || (paramInt == 13)) {
      return 20;
    }
    if (paramInt == 10) {
      return 13;
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonDataAdapter.a().a().getString(2131694648);
    case 0: 
      return "";
    case 1: 
      return CommonDataAdapter.a().a().getString(2131694653);
    case 2: 
      return CommonDataAdapter.a().a().getString(2131694657);
    case 3: 
      return CommonDataAdapter.a().a().getString(2131694655);
    case 4: 
      return CommonDataAdapter.a().a().getString(2131694651);
    case 5: 
      return CommonDataAdapter.a().a().getString(2131694648);
    }
    return CommonDataAdapter.a().a().getString(2131694648);
  }
  
  public static JSONObject a(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("packagename", localWadlParams.f);
        localJSONObject.put("via", localWadlParams.l);
        localJSONObject.put("isAutoInstallBySDK", localWadlParams.a(1));
        localJSONObject.put("isRes", localWadlParams.jdField_a_of_type_Boolean);
        localJSONObject.put("writecodestate", 0);
        localJSONObject.put("extraInfo", localWadlParams.o);
        localJSONObject.put("versionCode", localWadlParams.e);
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 6;
    case 0: 
      return 0;
    case -71: 
    case -30: 
    case -26: 
    case -25: 
    case -24: 
    case -23: 
    case -16: 
    case -15: 
    case -1: 
      return 1;
    case -51: 
    case -11: 
      return 2;
    case -40: 
    case -12: 
      return 3;
    case 999: 
      return 7;
    }
    return 5;
  }
  
  public static JSONObject b(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("packagename", localWadlParams.f);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("via", localWadlParams.l);
        localJSONObject.put("versionCode", localWadlParams.e);
        localJSONObject.put("resMD5", localWadlParams.i);
        localJSONObject.put("resVersionName", localWadlParams.g);
        localJSONObject.put("resName", localWadlParams.h);
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeUtil
 * JD-Core Version:    0.7.0.1
 */