package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadRequest.OnResponseDataListener;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class MiniappDownloadUtil
{
  private static final String TAG = "[mini] MiniappDownloadUtil";
  public static float gDownloadProgressStep = 0.2F;
  private static volatile MiniappDownloadUtil instance;
  private static List<Integer> sRangeModeNetworkLevel;
  private static List<Integer> sRangeModePerfLevel;
  private Downloader resumableDownloader;
  
  public MiniappDownloadUtil()
  {
    int i;
    if (this.resumableDownloader == null)
    {
      if (QDLog.getLog() == null) {
        QDLog.setLog(new MiniappDownloadUtil.1(this));
      }
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_use_download_optimize", 1) != 1) {
        break label143;
      }
      i = 1;
      if (i == 0) {
        break label148;
      }
      Config.setConfig(new MiniDownloadConfig());
      DownloaderFactory.getInstance(BaseApplicationImpl.getContext());
    }
    label143:
    label148:
    for (this.resumableDownloader = DownloaderFactory.createDownloader("mini_app_downloader");; this.resumableDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader())
    {
      this.resumableDownloader.enableResumeTransfer(true);
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_https_ipdirect_enable", 1) == 1) {
        bool = true;
      }
      this.resumableDownloader.setHttpsIpDirectEnable(bool);
      try
      {
        Object localObject = new QzoneIPStracyConfig();
        this.resumableDownloader.setDirectIPConfigStrategy((IPStrategy)localObject);
        localObject = new QzoneBackupConfig();
        this.resumableDownloader.setBackupIPConfigStrategy((IPStrategy)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] MiniappDownloadUtil", 1, "", localThrowable);
      }
      i = 0;
      break;
    }
  }
  
  private Downloader.DownloadMode getDownloadMode()
  {
    int i = GameWnsUtils.getDownloaderMode();
    if (i == Downloader.DownloadMode.RangeMode.ordinal()) {
      return Downloader.DownloadMode.RangeMode;
    }
    if (i == Downloader.DownloadMode.OkHttpMode.ordinal()) {
      return Downloader.DownloadMode.OkHttpMode;
    }
    return Downloader.DownloadMode.StrictMode;
  }
  
  public static MiniappDownloadUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MiniappDownloadUtil();
      }
      return instance;
    }
    finally {}
  }
  
  private List<Integer> getRangeModeNetworkLevel()
  {
    try
    {
      if (sRangeModeNetworkLevel == null)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = GameWnsUtils.getRangeModeNetworkLevel();
        QLog.i("[mini] MiniappDownloadUtil", 1, "getRangeModeNetworkLevel wns config: " + (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            int j = localObject2.length;
            int i = 0;
            for (;;)
            {
              if (i < j)
              {
                String str = localObject2[i];
                try
                {
                  localArrayList.add(Integer.valueOf(str));
                  i += 1;
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  for (;;)
                  {
                    QLog.e("[mini] MiniappDownloadUtil", 1, "getRangeModeNetworkLevel exception:", localNumberFormatException);
                  }
                }
              }
            }
          }
        }
        sRangeModeNetworkLevel = localObject1;
      }
    }
    finally {}
    List localList = sRangeModeNetworkLevel;
    return localList;
  }
  
  private List<Integer> getRangeModePerfLevel()
  {
    try
    {
      if (sRangeModePerfLevel == null)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = GameWnsUtils.getRangeModePerfLevel();
        QLog.i("[mini] MiniappDownloadUtil", 1, "getRangeModePerfLevel wns config: " + (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            int j = localObject2.length;
            int i = 0;
            for (;;)
            {
              if (i < j)
              {
                String str = localObject2[i];
                try
                {
                  localArrayList.add(Integer.valueOf(str));
                  i += 1;
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  for (;;)
                  {
                    QLog.e("[mini] MiniappDownloadUtil", 1, "getRangeModePerfLevel exception:", localNumberFormatException);
                  }
                }
              }
            }
          }
        }
        sRangeModePerfLevel = localObject1;
      }
    }
    finally {}
    List localList = sRangeModePerfLevel;
    return localList;
  }
  
  private boolean isUrlSupportRange(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return false;
      str = paramString;
      if (paramString.indexOf("?") > 0) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    } while (TextUtils.isEmpty(str));
    return str.toLowerCase().endsWith(".zip");
  }
  
  public static void preLoadDownloader()
  {
    getInstance();
  }
  
  private boolean rangeDownloadEnvEnable()
  {
    List localList = getRangeModePerfLevel();
    if ((localList != null) && (!localList.contains(Integer.valueOf(DeviceInfoUtils.a())))) {}
    do
    {
      return false;
      localList = getRangeModeNetworkLevel();
    } while ((localList != null) && (!localList.contains(Integer.valueOf(NetworkState.g().getNetworkType()))));
    return true;
  }
  
  public void abort(String paramString)
  {
    this.resumableDownloader.abort(paramString, null);
  }
  
  public boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, int paramInt, long paramLong, JSONObject paramJSONObject, DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    if (NetworkUtils.isNetworkUrl(paramString1))
    {
      paramString1 = new DownloadRequest(paramString1, new String[] { paramString2 }, false, paramDownloadListener);
      paramString1.mode = paramDownloadMode;
      paramString1.onResponseDataListener = paramOnResponseDataListener;
      paramString1.rangeNumber = paramInt;
      paramString1.progressCallbackStep = gDownloadProgressStep;
      paramString1.addParam("Accept-Encoding", "gzip, deflate");
      paramString1.setFileSizeForRangeMode(paramLong);
      if (paramJSONObject != null)
      {
        paramString2 = paramJSONObject.keys();
        while (paramString2.hasNext())
        {
          paramDownloadListener = (String)paramString2.next();
          paramString1.addParam(paramDownloadListener, paramJSONObject.optString(paramDownloadListener));
        }
      }
      return this.resumableDownloader.download(paramString1, paramBoolean);
    }
    QLog.w("[mini] MiniappDownloadUtil", 1, "download unsupported url:" + paramString1 + ", callback fail");
    ThreadManager.excute(new MiniappDownloadUtil.3(this, paramDownloadListener, paramString1), 16, null, false);
    return false;
  }
  
  public boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, JSONObject paramJSONObject)
  {
    return download(paramString1, paramString2, paramBoolean, paramDownloadListener, paramDownloadMode, -1, 0L, paramJSONObject, null);
  }
  
  public boolean downloadApkg(MiniAppConfig paramMiniAppConfig, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, int paramInt, long paramLong, JSONObject paramJSONObject, DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    return download(paramString1, paramString2, paramBoolean2, new MiniappDownloadUtil.2(this, paramDownloadListener, paramBoolean1, paramMiniAppConfig), paramDownloadMode, paramInt, paramLong, paramJSONObject, paramOnResponseDataListener);
  }
  
  public boolean downloadApkg(MiniAppConfig paramMiniAppConfig, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, JSONObject paramJSONObject)
  {
    return downloadApkg(paramMiniAppConfig, paramBoolean1, paramString1, paramString2, paramBoolean2, paramDownloadListener, paramDownloadMode, -1, 0L, paramJSONObject, null);
  }
  
  public Downloader.DownloadMode getDownloadMode(String paramString)
  {
    Downloader.DownloadMode localDownloadMode2 = getDownloadMode();
    Downloader.DownloadMode localDownloadMode1 = localDownloadMode2;
    if (localDownloadMode2 == Downloader.DownloadMode.RangeMode) {
      if (isUrlSupportRange(paramString))
      {
        localDownloadMode1 = localDownloadMode2;
        if (rangeDownloadEnvEnable()) {}
      }
      else
      {
        localDownloadMode1 = Downloader.DownloadMode.StrictMode;
      }
    }
    return localDownloadMode1;
  }
  
  public int getRangeNumber(long paramLong)
  {
    long l = GameWnsUtils.getRangeSize();
    int j = GameWnsUtils.getMaxRangeNumber();
    int i;
    if ((paramLong > 0L) && (l > 0L))
    {
      i = (int)Math.ceil(paramLong * 1.0D / l);
      if (i <= j) {
        break label88;
      }
      i = j;
    }
    label88:
    for (;;)
    {
      QLog.i("[mini] MiniappDownloadUtil", 1, "getRangeNumber return " + i + " for contentLength " + paramLong);
      return i;
      i = -1;
      break;
    }
  }
  
  public boolean needPreConnect()
  {
    Downloader.DownloadMode localDownloadMode = getDownloadMode();
    if (localDownloadMode == Downloader.DownloadMode.OkHttpMode) {
      return true;
    }
    if (localDownloadMode == Downloader.DownloadMode.RangeMode) {
      return rangeDownloadEnvEnable();
    }
    return false;
  }
  
  public void preConnectHost(ArrayList<String> paramArrayList, String paramString)
  {
    if (this.resumableDownloader != null)
    {
      QLog.d("[mini] MiniappDownloadUtil", 1, "preconnect method = " + paramString);
      this.resumableDownloader.preConnectHost(paramArrayList, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil
 * JD-Core Version:    0.7.0.1
 */