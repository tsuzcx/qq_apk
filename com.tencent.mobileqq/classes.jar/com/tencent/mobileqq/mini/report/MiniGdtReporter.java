package com.tencent.mobileqq.mini.report;

import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtReporter;
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
    Object localObject1 = sNoNeedReport;
    int i = 1;
    if (!((AtomicBoolean)localObject1).compareAndSet(false, true))
    {
      paramMiniAppConfig = new StringBuilder();
      paramMiniAppConfig.append("report: no need report now ");
      paramMiniAppConfig.append(paramInt);
      QLog.w("MiniGdtReporter", 2, paramMiniAppConfig.toString());
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report: null param ");
      ((StringBuilder)localObject1).append(paramMiniAppConfig.config);
      QLog.w("MiniGdtReporter", 2, ((StringBuilder)localObject1).toString(), new Throwable());
      return;
    }
    if (localLaunchParam.scene != 1095)
    {
      paramMiniAppConfig = new StringBuilder();
      paramMiniAppConfig.append("report: not form ad ");
      paramMiniAppConfig.append(localLaunchParam.scene);
      QLog.d("MiniGdtReporter", 2, paramMiniAppConfig.toString());
      return;
    }
    if (localLaunchParam.timestamp == 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report: no timestamp ");
      ((StringBuilder)localObject1).append(paramMiniAppConfig.config);
      QLog.w("MiniGdtReporter", 2, ((StringBuilder)localObject1).toString(), new Throwable());
      return;
    }
    paramMiniAppConfig = null;
    localObject1 = paramMiniAppConfig;
    StringBuilder localStringBuilder2;
    Object localObject2;
    if (!TextUtils.isEmpty(localLaunchParam.navigateExtData)) {
      try
      {
        localObject1 = new JSONObject(localLaunchParam.navigateExtData).optString("reportUrl");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("report: failed to read ext data ");
        localStringBuilder2.append(localLaunchParam);
        QLog.w("MiniGdtReporter", 2, localStringBuilder2.toString(), localJSONException);
        localObject2 = paramMiniAppConfig;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramMiniAppConfig = new StringBuilder();
      paramMiniAppConfig.append("report: empty url ");
      paramMiniAppConfig.append(localLaunchParam);
      QLog.w("MiniGdtReporter", 2, paramMiniAppConfig.toString(), new Throwable());
      return;
    }
    if (paramInt == 0) {
      paramMiniAppConfig = (MiniAppConfig)localObject2;
    }
    try
    {
      localObject2 = ((String)localObject2).replace("__PAGE_ACTION_ID__", Integer.toString(51)).replace("__PAGE_TIME__", Long.toString(System.currentTimeMillis() - localLaunchParam.timestamp));
      break label403;
      paramMiniAppConfig = (MiniAppConfig)localObject2;
      localObject2 = ((String)localObject2).replace("__PAGE_ACTION_ID__", Integer.toString(52)).replace("__LANDING_ERROR_CODE__", Integer.toString(paramInt));
      label403:
      paramMiniAppConfig = (MiniAppConfig)localObject2;
      localObject2 = ((String)localObject2).replace("__OS_TYPE__", Integer.toString(2)).replace("__VERSION__", URLEncoder.encode("8.8.17", "utf-8"));
      paramInt = i;
      paramMiniAppConfig = (MiniAppConfig)localObject2;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("report: failed to convert report url ");
      localStringBuilder2.append(paramMiniAppConfig);
      localStringBuilder2.append(" ");
      localStringBuilder2.append(paramInt);
      QLog.w("MiniGdtReporter", 2, localStringBuilder2.toString(), localException);
      paramInt = 0;
    }
    if (paramInt == 0) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("report: get report url ");
    localStringBuilder1.append(paramMiniAppConfig);
    localStringBuilder1.append(" ");
    localStringBuilder1.append(localLaunchParam.timestamp);
    QLog.i("MiniGdtReporter", 2, localStringBuilder1.toString());
    GdtReporter.doCgiReport(paramMiniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniGdtReporter
 * JD-Core Version:    0.7.0.1
 */