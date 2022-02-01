package com.tencent.tmassistantsdk.internal.logreport;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class OuterCallReportModel
{
  public static final String COMPONENT_LINKPROXY = "LinkProxyActivity";
  public static final String COMPONENT_SERVICE = "SDKSupportService";
  public static final String COMPONENT_SPLASH = "SplashActivity";
  public static final int OUTER_CALL_MODE_BROWSER = 1;
  public static final int OUTER_CALL_MODE_SILENT = 0;
  public static final int OUTER_CALL_SUPPORT_YYB_VERSION = 7132130;
  public static final int OUTER_CALL_TYPE_ACTIVITY = 1;
  public static final int OUTER_CALL_TYPE_SERVICE = 0;
  private static final String TAG = "OuterCallReportModel";
  public String mBuildId = "";
  public String mComponentName = "";
  public String mDisplay = "";
  public String mFingerprints = "";
  public String mHostPname = "";
  public String mHostVersion = "";
  public String mInCremental = "";
  public int mOuterCallMode = 0;
  public long mOuterCallTime = 0L;
  public int mOuterCallType = 0;
  public String mVia = "";
  public String mYYBSDKAPILevel = "";
  public String mYYBVersion = "";
  
  public static OuterCallReportModel getDefaultModel()
  {
    OuterCallReportModel localOuterCallReportModel = new OuterCallReportModel();
    localOuterCallReportModel.mFingerprints = Build.FINGERPRINT;
    localOuterCallReportModel.mDisplay = Build.DISPLAY;
    localOuterCallReportModel.mBuildId = Build.ID;
    localOuterCallReportModel.mInCremental = Build.VERSION.INCREMENTAL;
    localOuterCallReportModel.mYYBVersion = String.valueOf(GlobalUtil.getInstance().getQQDownloaderVersionCode());
    localOuterCallReportModel.mHostPname = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    localOuterCallReportModel.mHostVersion = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
    localOuterCallReportModel.mYYBSDKAPILevel = String.valueOf(GlobalUtil.getInstance().getQQDownloaderAPILevel());
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    return localOuterCallReportModel;
  }
  
  public static boolean isYYBSupportOutcallReport()
  {
    return GlobalUtil.getInstance().getQQDownloaderVersionCode() >= 7132130;
  }
  
  public Bundle getBundleData()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("outerCallType", String.valueOf(this.mOuterCallType));
    localBundle.putString("outerCallMode", String.valueOf(this.mOuterCallMode));
    localBundle.putString("outerCallTime", String.valueOf(this.mOuterCallTime));
    localBundle.putString("hostversion", this.mHostVersion);
    localBundle.putString("hostpname", GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
    return localBundle;
  }
  
  public String getJsonData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("via", String.valueOf(this.mVia));
      localJSONObject.put("outerCallType", String.valueOf(this.mOuterCallType));
      localJSONObject.put("outerCallMode", String.valueOf(this.mOuterCallMode));
      localJSONObject.put("outerCallTime", String.valueOf(this.mOuterCallTime));
      localJSONObject.put("hostversion", this.mHostVersion);
      localJSONObject.put("hostpname", GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "||||||||" + this.mComponentName + "|" + this.mVia + "|" + this.mOuterCallType + "|" + this.mOuterCallMode + "|" + this.mOuterCallTime + "|" + this.mFingerprints + "|" + this.mDisplay + "|" + this.mBuildId + "|" + this.mInCremental + "|" + this.mHostPname + "|" + this.mHostVersion + "|" + this.mYYBVersion + "|" + this.mYYBSDKAPILevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel
 * JD-Core Version:    0.7.0.1
 */