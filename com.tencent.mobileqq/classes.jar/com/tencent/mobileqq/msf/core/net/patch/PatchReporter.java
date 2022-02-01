package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.b.e;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
  public static final int CODE_RELAX_INJECT_FAILED = 807;
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
    for (;;)
    {
      try
      {
        String str = String.valueOf(paramInt1);
        HashMap localHashMap = new HashMap();
        localHashMap.put("resultCode", str);
        localHashMap.put("patchPath", paramString2);
        localHashMap.put("patchTmpPath", paramString3);
        localHashMap.put("patchUrl", paramString1);
        Object localObject = "";
        paramString1 = (String)localObject;
        if (TextUtils.isEmpty(""))
        {
          paramString1 = (String)localObject;
          if (MsfCore.sCore != null) {
            paramString1 = MsfCore.sCore.getMainAccount();
          }
        }
        localObject = new StringBuilder("reportPatchDownload reportPatchEvent curUin=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", path=");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", result=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", tmpPath=");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
        if (paramInt1 == 0)
        {
          bool = true;
          e.a(paramString1, "actPatchDownMsf", bool, paramLong, paramInt2, localHashMap, null, false);
          QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchDownMsf");
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      boolean bool = false;
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
      try
      {
        Object localObject1 = String.valueOf(paramInt1);
        HashMap localHashMap = new HashMap();
        localHashMap.put("resultCode", localObject1);
        localHashMap.put("relaxCode", String.valueOf(paramInt2));
        localHashMap.put("patchName", paramString3);
        if ((!TextUtils.isEmpty(paramString1)) || (MsfCore.sCore == null)) {
          break label527;
        }
        paramString1 = MsfCore.sCore.getMainAccount();
        Object localObject2 = new StringBuilder("PatchReporter reportPatchEvent curUin=");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(", event=");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(", result=");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(", patchName=");
        ((StringBuilder)localObject2).append(paramString3);
        QLog.d("PatchLogTag", 1, ((StringBuilder)localObject2).toString());
        if (paramInt1 % 100 != 0) {
          break label530;
        }
        bool = true;
        if ((!"actPatchConfig".equals(paramString2)) && (!"actPatchDownload".equals(paramString2)) && (!"actPatchResolve".equals(paramString2)) && (!"actPatchUnzip".equals(paramString2)))
        {
          localObject2 = new StringBuilder(paramString2);
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(paramString3);
          paramString3 = ((StringBuilder)localObject2).toString();
          localObject2 = PatchSharedPreUtil.getPatchReportInfo(paramContext, paramString3);
          if ("actPatchCheck".equals(paramString2))
          {
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject1)))
            {
              e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
              PatchSharedPreUtil.updatePatchReportInfo(paramContext, paramString3, (String)localObject1);
              QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchCheck");
            }
          }
          else if ("actPatchInstall".equals(paramString2))
          {
            String str = patchReportDateFormat.format(new Date(System.currentTimeMillis()));
            localObject1 = new StringBuilder((String)localObject1);
            ((StringBuilder)localObject1).append(str.substring(0, 8));
            ((StringBuilder)localObject1).append(Integer.parseInt(str.substring(8)) / 8);
            localObject1 = ((StringBuilder)localObject1).toString();
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject1)))
            {
              localHashMap.put("uin", paramString1);
              localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
              e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
              PatchSharedPreUtil.updatePatchReportInfo(paramContext, paramString3, (String)localObject1);
              QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchInstall");
            }
          }
        }
        else
        {
          e.a(paramString1, paramString2, bool, 0L, 0L, localHashMap, null, false);
          paramContext = new StringBuilder();
          paramContext.append("PatchReporter reportPatchEvent ");
          paramContext.append(paramString2);
          QLog.d("PatchLogTag", 1, paramContext.toString());
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramString1 = new StringBuilder();
        paramString1.append("PatchReporter reportPatchEvent throwable=");
        paramString1.append(paramContext);
        QLog.d("PatchLogTag", 1, paramString1.toString());
      }
      return;
      label527:
      continue;
      label530:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchReporter
 * JD-Core Version:    0.7.0.1
 */