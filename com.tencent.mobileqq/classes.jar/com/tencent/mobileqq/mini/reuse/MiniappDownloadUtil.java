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
    if (this.resumableDownloader == null)
    {
      if (QDLog.getLog() == null) {
        QDLog.setLog(new MiniappDownloadUtil.1(this));
      }
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_use_download_optimize", 1);
      boolean bool = false;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Config.setConfig(new MiniDownloadConfig());
        DownloaderFactory.getInstance(BaseApplicationImpl.getContext());
        this.resumableDownloader = DownloaderFactory.createDownloader("mini_app_downloader");
      }
      else
      {
        this.resumableDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
      }
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
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MiniappDownloadUtil();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private List<Integer> getRangeModeNetworkLevel()
  {
    try
    {
      if (sRangeModeNetworkLevel != null) {
        break label136;
      }
      localObject1 = new ArrayList();
      localObject3 = GameWnsUtils.getRangeModeNetworkLevel();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRangeModeNetworkLevel wns config: ");
      localStringBuilder.append((String)localObject3);
      QLog.i("[mini] MiniappDownloadUtil", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label132;
      }
      localObject3 = ((String)localObject3).split(",");
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label132;
      }
      j = localObject3.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        StringBuilder localStringBuilder;
        int j;
        int i;
        for (;;)
        {
          label132:
          label136:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localStringBuilder = localObject3[i];
      try
      {
        ((List)localObject1).add(Integer.valueOf(localStringBuilder));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("[mini] MiniappDownloadUtil", 1, "getRangeModeNetworkLevel exception:", localNumberFormatException);
      }
    }
    else
    {
      sRangeModeNetworkLevel = (List)localObject1;
      localObject1 = sRangeModeNetworkLevel;
      return localObject1;
    }
  }
  
  private List<Integer> getRangeModePerfLevel()
  {
    try
    {
      if (sRangeModePerfLevel != null) {
        break label136;
      }
      localObject1 = new ArrayList();
      localObject3 = GameWnsUtils.getRangeModePerfLevel();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRangeModePerfLevel wns config: ");
      localStringBuilder.append((String)localObject3);
      QLog.i("[mini] MiniappDownloadUtil", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label132;
      }
      localObject3 = ((String)localObject3).split(",");
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label132;
      }
      j = localObject3.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        StringBuilder localStringBuilder;
        int j;
        int i;
        for (;;)
        {
          label132:
          label136:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localStringBuilder = localObject3[i];
      try
      {
        ((List)localObject1).add(Integer.valueOf(localStringBuilder));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("[mini] MiniappDownloadUtil", 1, "getRangeModePerfLevel exception:", localNumberFormatException);
      }
    }
    else
    {
      sRangeModePerfLevel = (List)localObject1;
      localObject1 = sRangeModePerfLevel;
      return localObject1;
    }
  }
  
  private boolean isUrlSupportRange(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = paramString;
    if (paramString.indexOf("?") > 0) {
      str = paramString.substring(0, paramString.indexOf("?"));
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.toLowerCase().endsWith(".zip");
  }
  
  public static void preLoadDownloader()
  {
    getInstance();
  }
  
  private boolean rangeDownloadEnvEnable()
  {
    List localList = getRangeModePerfLevel();
    if ((localList != null) && (!localList.contains(Integer.valueOf(DeviceInfoUtils.getPerfLevel())))) {
      return false;
    }
    localList = getRangeModeNetworkLevel();
    return (localList == null) || (localList.contains(Integer.valueOf(NetworkState.g().getNetworkType())));
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
    paramString2 = new StringBuilder();
    paramString2.append("download unsupported url:");
    paramString2.append(paramString1);
    paramString2.append(", callback fail");
    QLog.w("[mini] MiniappDownloadUtil", 1, paramString2.toString());
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
    Downloader.DownloadMode localDownloadMode = getDownloadMode();
    if ((localDownloadMode == Downloader.DownloadMode.RangeMode) && ((!isUrlSupportRange(paramString)) || (!rangeDownloadEnvEnable()))) {
      return Downloader.DownloadMode.StrictMode;
    }
    return localDownloadMode;
  }
  
  public int getRangeNumber(long paramLong)
  {
    long l = GameWnsUtils.getRangeSize();
    int k = GameWnsUtils.getMaxRangeNumber();
    int i;
    if ((paramLong > 0L) && (l > 0L))
    {
      double d1 = paramLong;
      Double.isNaN(d1);
      double d2 = l;
      Double.isNaN(d2);
      i = (int)Math.ceil(d1 * 1.0D / d2);
    }
    else
    {
      i = -1;
    }
    int j = i;
    if (i > k) {
      j = k;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRangeNumber return ");
    localStringBuilder.append(j);
    localStringBuilder.append(" for contentLength ");
    localStringBuilder.append(paramLong);
    QLog.i("[mini] MiniappDownloadUtil", 1, localStringBuilder.toString());
    return j;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preconnect method = ");
      localStringBuilder.append(paramString);
      QLog.d("[mini] MiniappDownloadUtil", 1, localStringBuilder.toString());
      this.resumableDownloader.preConnectHost(paramArrayList, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil
 * JD-Core Version:    0.7.0.1
 */