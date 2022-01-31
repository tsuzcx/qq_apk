package com.tencent.open.wadl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.adapter.CommonDataAdapter;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
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
    if (paramInt == 13) {
      return 20;
    }
    if (paramInt == 2) {
      return 20;
    }
    if (paramInt == 1) {
      return 20;
    }
    if (paramInt == 3) {
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
      return CommonDataAdapter.a().a().getString(2131428522);
    case 0: 
      return "";
    case 1: 
      return CommonDataAdapter.a().a().getString(2131428521);
    case 2: 
      return CommonDataAdapter.a().a().getString(2131428528);
    case 3: 
      return CommonDataAdapter.a().a().getString(2131428526);
    case 4: 
      return CommonDataAdapter.a().a().getString(2131428519);
    case 5: 
      return CommonDataAdapter.a().a().getString(2131428522);
    }
    return CommonDataAdapter.a().a().getString(2131428522);
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("wadlAppInfo", 2).getString(paramString, "");
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
        localJSONObject.put("appid", localWadlParams.a);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("packagename", localWadlParams.d);
        localJSONObject.put("ismyapp", 0);
        localJSONObject.put("download_from", 0);
        localJSONObject.put("realDownloadType", 0);
        localJSONObject.put("via", localWadlParams.h);
        localJSONObject.put("writecodestate", 0);
        localJSONObject.put("extraInfo", localWadlParams.k);
        localJSONObject.put("isAutoInstallBySDK", localWadlParams.a(1));
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wadlAppInfo", 2).edit();
    localEditor.putString(paramString1, paramString2);
    boolean bool = localEditor.commit();
    WLog.b("WadlJsBridgeUtil", "savePackageInfo:appid:" + paramString2 + ",packageName:" + paramString1 + ",flag:" + bool);
    return bool;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -72: 
    case -70: 
    case -69: 
    case -68: 
    case -67: 
    case -66: 
    case -65: 
    case -64: 
    case -63: 
    case -62: 
    case -61: 
    case -59: 
    case -58: 
    case -57: 
    case -56: 
    case -55: 
    case -54: 
    case -53: 
    case -52: 
    case -50: 
    case -49: 
    case -48: 
    case -47: 
    case -46: 
    case -45: 
    case -44: 
    case -43: 
    case -42: 
    case -41: 
    case -29: 
    case -28: 
    case -27: 
    case -22: 
    case -19: 
    case -18: 
    case -17: 
    case -14: 
    case -13: 
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
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeUtil
 * JD-Core Version:    0.7.0.1
 */