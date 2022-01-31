package com.tencent.mobileqq.mini.report;

import aaob;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGdtReporter
{
  public static final int CODE_APKG_FAIL = 315;
  public static final int CODE_BASELIB_LOAD_FAIL = 310;
  public static final int CODE_G_BASELIB_LOAD_FAIL = 510;
  public static final int CODE_G_PKG_DOWNLOAD_FAIL = 511;
  public static final int CODE_G_PKG_LOAD_FAIL = 512;
  public static final int CODE_SUCCESS = 0;
  private static final String KEY_ACTION = "__PAGE_ACTION_ID__";
  private static final String KEY_ERROR_CODE = "__LANDING_ERROR_CODE__";
  private static final String KEY_OS = "__OS_TYPE__";
  private static final String KEY_TIME = "__PAGE_TIME__";
  private static final String KEY_VER = "__VERSION__";
  private static final String TAG = "MiniGdtReporter";
  private static final AtomicBoolean sNoNeedReport = new AtomicBoolean(true);
  
  public static void prepareReport()
  {
    sNoNeedReport.set(false);
  }
  
  public static void report(MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    if (!sNoNeedReport.compareAndSet(false, true))
    {
      QLog.w("MiniGdtReporter", 2, "report: no need report now " + paramInt);
      return;
    }
    if (paramMiniAppConfig == null)
    {
      QLog.w("MiniGdtReporter", 2, "report: null config", new Throwable());
      return;
    }
    LaunchParam localLaunchParam = paramMiniAppConfig.launchParam;
    if (localLaunchParam == null)
    {
      QLog.w("MiniGdtReporter", 2, "report: null param " + paramMiniAppConfig.config, new Throwable());
      return;
    }
    if (localLaunchParam.scene != 1095)
    {
      QLog.d("MiniGdtReporter", 2, "report: not form ad " + localLaunchParam.scene);
      return;
    }
    if (localLaunchParam.timestamp == 0L)
    {
      QLog.w("MiniGdtReporter", 2, "report: no timestamp " + paramMiniAppConfig.config, new Throwable());
      return;
    }
    String str = null;
    paramMiniAppConfig = str;
    if (!TextUtils.isEmpty(localLaunchParam.navigateExtData)) {}
    try
    {
      paramMiniAppConfig = new JSONObject(localLaunchParam.navigateExtData).optString("reportUrl");
      if (TextUtils.isEmpty(paramMiniAppConfig))
      {
        QLog.w("MiniGdtReporter", 2, "report: empty url " + localLaunchParam, new Throwable());
        return;
      }
    }
    catch (JSONException paramMiniAppConfig)
    {
      for (;;)
      {
        QLog.w("MiniGdtReporter", 2, "report: failed to read ext data " + localLaunchParam, paramMiniAppConfig);
        paramMiniAppConfig = str;
      }
    }
    if (paramInt == 0) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          str = paramMiniAppConfig.replace("__PAGE_ACTION_ID__", Integer.toString(51)).replace("__PAGE_TIME__", Long.toString(System.currentTimeMillis() - localLaunchParam.timestamp));
          paramMiniAppConfig = str;
        }
        catch (Exception localException1) {}
        try
        {
          str = paramMiniAppConfig.replace("__OS_TYPE__", Integer.toString(2)).replace("__VERSION__", URLEncoder.encode("8.3.3", "utf-8"));
          paramMiniAppConfig = str;
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          QLog.i("MiniGdtReporter", 2, "report: get report url " + paramMiniAppConfig + " " + localLaunchParam.timestamp);
          aaob.a(paramMiniAppConfig);
          return;
        }
        catch (Exception localException2)
        {
          label423:
          break label423;
        }
      }
      str = paramMiniAppConfig.replace("__PAGE_ACTION_ID__", Integer.toString(52)).replace("__LANDING_ERROR_CODE__", Integer.toString(paramInt));
      paramMiniAppConfig = str;
      continue;
      QLog.w("MiniGdtReporter", 2, "report: failed to convert report url " + paramMiniAppConfig + " " + paramInt, localException1);
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniGdtReporter
 * JD-Core Version:    0.7.0.1
 */