package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.b;
import com.tencent.mobileqq.msf.sdk.report.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class PatchReporter
{
  public static final String ACTION_PATCH_CHECK = "actPatchCheck";
  public static final String ACTION_PATCH_CONFIG = "actPatchConfig";
  public static final String ACTION_PATCH_DOWNLOAD = "actPatchDownload";
  public static final String ACTION_PATCH_DOWN_MSF = "actPatchDownMsf";
  public static final String ACTION_PATCH_INSTALL = "actPatchInstall";
  public static final String ACTION_PATCH_LOAD = "actPatchLoad";
  public static final String ACTION_PATCH_RESOLVE = "actPatchResolve";
  public static final String ACTION_PATCH_UNZIP = "actPatchUnzip";
  public static final int CODE_CHECK_EXCEPTION = 302;
  public static final int CODE_CHECK_FAIL = 301;
  public static final int CODE_CHECK_SUCCESS = 300;
  public static final int CODE_CONFIG_EXCEPTION = 102;
  public static final int CODE_CONFIG_FAIL = 101;
  public static final int CODE_CONFIG_SUCCESS = 100;
  public static final int CODE_DOWNLOAD_EXCEPTION = 202;
  public static final int CODE_DOWNLOAD_FAIL = 201;
  public static final int CODE_DOWNLOAD_SUCCESS = 200;
  public static final int CODE_INSTALL_EXCEPTION = 502;
  public static final int CODE_INSTALL_FAIL = 501;
  public static final int CODE_INSTALL_START_FAIL = 503;
  public static final int CODE_INSTALL_SUCCESS = 500;
  public static final int CODE_LOAD_FAIL = 401;
  public static final int CODE_LOAD_SUCCESS = 400;
  public static final int CODE_RELAX_FAIL = 801;
  public static final int CODE_RELAX_INIT_FAIL = 803;
  public static final int CODE_RELAX_IO_EXCEPTION = 802;
  public static final int CODE_RELAX_LOAD_SO_FAIL = 806;
  public static final int CODE_RELAX_LOSE_FILE = 804;
  public static final int CODE_RELAX_OK = 800;
  public static final int CODE_RELAX_REMOVE_PATCH_CLASSES_FAIL = 805;
  public static final int CODE_RESOLVE_LIB_UNLOAD = 609;
  public static final int CODE_RESOLVE_SUCCESS = 600;
  public static final int CODE_UNZIP_7Z_EXCEPTION = 702;
  public static final int CODE_UNZIP_7Z_FAIL = 701;
  public static final int CODE_UNZIP_7Z_SIZE_ERROR = 703;
  public static final int CODE_UNZIP_7Z_SUCCESS = 700;
  private static final int INTERVAL_REPORT_PATCH_INSTALL = 8;
  public static final int PATCH_DOWN_BAD_URL = 5001;
  public static final int PATCH_DOWN_OK = 5000;
  public static final int PATCH_DOWN_RENAME_FAILED = 5002;
  private static SimpleDateFormat patchReportDateFormat = new SimpleDateFormat("yyyyMMddHH");
  
  public static void reportPatchDownload(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      String str2 = String.valueOf(paramInt1);
      HashMap localHashMap = new HashMap();
      localHashMap.put("resultCode", str2);
      localHashMap.put("patchPath", paramString2);
      localHashMap.put("patchTmpPath", paramString3);
      localHashMap.put("patchUrl", paramString1);
      String str1 = "";
      paramString1 = str1;
      if (TextUtils.isEmpty(""))
      {
        paramString1 = str1;
        if (MsfCore.sCore != null) {
          paramString1 = MsfCore.sCore.getMainAccount();
        }
      }
      QLog.d("PatchLogTag", 1, "reportPatchDownload reportPatchEvent curUin=" + paramString1 + ", path=" + paramString2 + ", result=" + str2 + ", tmpPath=" + paramString3);
      if (paramInt1 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        e.a(paramString1, "actPatchDownMsf", bool, paramLong, paramInt2, localHashMap, null, false);
        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchDownMsf");
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void reportPatchEvent(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    reportPatchEvent(paramContext, paramString1, paramString2, paramInt, paramString3, 0);
  }
  
  public static void reportPatchEvent(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    for (;;)
    {
      String str1;
      HashMap localHashMap;
      String str2;
      try
      {
        str1 = String.valueOf(paramInt1);
        localHashMap = new HashMap();
        localHashMap.put("resultCode", str1);
        localHashMap.put("relaxCode", String.valueOf(paramInt2));
        localHashMap.put("patchName", paramString3);
        if ((!TextUtils.isEmpty(paramString1)) || (MsfCore.sCore == null)) {
          break label515;
        }
        paramString1 = MsfCore.sCore.getMainAccount();
        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent curUin=" + paramString1 + ", event=" + paramString2 + ", result=" + paramInt1 + ", patchName=" + paramString3);
        if (paramInt1 % 100 != 0) {
          break label519;
        }
        bool = true;
        if (("actPatchConfig".equals(paramString2)) || ("actPatchDownload".equals(paramString2)) || ("actPatchResolve".equals(paramString2)) || ("actPatchUnzip".equals(paramString2)))
        {
          e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
          QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent " + paramString2);
          return;
        }
        paramString3 = paramString2 + paramString1 + paramString3;
        str2 = PatchSharedPreUtil.getPatchReportInfo(paramContext, paramString3);
        if ("actPatchCheck".equals(paramString2))
        {
          if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1))) {
            break label518;
          }
          e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
          PatchSharedPreUtil.updatePatchReportInfo(paramContext, paramString3, str1);
          QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchCheck");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent throwable=" + paramContext);
        return;
      }
      if ("actPatchInstall".equals(paramString2))
      {
        String str3 = patchReportDateFormat.format(new Date(System.currentTimeMillis()));
        str1 = str1 + str3.substring(0, 8) + Integer.parseInt(str3.substring(8)) / 8;
        if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1)))
        {
          e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
          try
          {
            localHashMap.put("uin", paramString1);
            localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            paramString1 = new Properties();
            paramString1.putAll(localHashMap);
            b.a(BaseApplication.getContext()).reportKVEvent("actPatchInstall", paramString1);
            PatchSharedPreUtil.updatePatchReportInfo(paramContext, paramString3, str1);
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchInstall");
            return;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.d("PatchLogTag", 1, "PatchReporter reportKVEvent actPatchInstall exception=" + paramString1);
            }
          }
          label515:
          continue;
        }
      }
      label518:
      return;
      label519:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchReporter
 * JD-Core Version:    0.7.0.1
 */