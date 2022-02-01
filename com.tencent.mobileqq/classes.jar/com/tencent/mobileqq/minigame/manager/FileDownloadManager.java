package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.proxyimpl.HttpUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class FileDownloadManager
{
  private static final String TAG = "FileDownloadManager";
  private static int enableDownloader = QzoneConfig.getInstance().getConfig("qqtriton", "minigamesdkenabledownloader", 1);
  private static ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap();
  
  public static void abort(String paramString)
  {
    int i = enableDownloader;
    if ((i != 1) && (i != 2))
    {
      Call localCall = (Call)taskMap.get(paramString);
      if (localCall != null) {
        localCall.cancel();
      }
      taskMap.remove(paramString);
      return;
    }
    MiniappDownloadUtil.getInstance().abort(paramString);
  }
  
  @NonNull
  private static DownloaderProxy.DownloadListener.DownloadResult convertDownloadResult(DownloadResult paramDownloadResult, Map<String, List<String>> paramMap)
  {
    DownloadReport localDownloadReport = paramDownloadResult.getReport();
    return new DownloaderProxy.DownloadListener.DownloadResult(paramDownloadResult.getUrl(), localDownloadReport.httpStatus, localDownloadReport.isSucceed, paramDownloadResult.getDescInfo(), false, localDownloadReport.t_wait, localDownloadReport.t_prepare, localDownloadReport.t_conn, localDownloadReport.t_recvdata, localDownloadReport.totaltime, localDownloadReport.fileSize, paramMap);
  }
  
  public static boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    int i = enableDownloader;
    if (i == 1) {
      return downloadWithDownloader(paramString1, paramMap, paramString2, paramInt, Downloader.DownloadMode.OkHttpMode, paramDownloadListener);
    }
    if (i == 2) {
      return downloadWithDownloader(paramString1, paramMap, paramString2, paramInt, Downloader.DownloadMode.StrictMode, paramDownloadListener);
    }
    return downloadWithOkhttp(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
  }
  
  private static boolean downloadWithDownloader(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, Downloader.DownloadMode paramDownloadMode, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    MiniappDownloadUtil.getInstance().download(paramString1, paramString2, false, new FileDownloadManager.2(paramDownloadListener, paramString2, paramString1), paramDownloadMode, HttpUtil.a(paramMap));
    return true;
  }
  
  private static boolean downloadWithOkhttp(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    paramMap = MiniOkHttpClientFactory.getDownloadClient(true).newCall(HttpUtil.a(paramString1, paramMap, "GET", null, null));
    paramMap.enqueue(new FileDownloadManager.1(paramString1, paramDownloadListener, paramString2, SystemClock.uptimeMillis()));
    taskMap.put(paramString1, paramMap);
    return true;
  }
  
  public static void getLameMp3SoDownloadPath(DownloaderProxy.LameMp3SoDownloadListener paramLameMp3SoDownloadListener)
  {
    if (paramLameMp3SoDownloadListener == null) {
      return;
    }
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("libminigame_lamemp3.so", new FileDownloadManager.4(paramLameMp3SoDownloadListener));
  }
  
  public static void getWebAudioDownloadPath(DownloaderProxy.WebAudioDownloadListener paramWebAudioDownloadListener)
  {
    if (paramWebAudioDownloadListener == null) {
      return;
    }
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("libwebAudio.so", new FileDownloadManager.3(paramWebAudioDownloadListener));
  }
  
  public static void preConnectDownloader()
  {
    if (enableDownloader == 1) {
      GamePreConnectManager.preConnectDownloaderForSDK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager
 * JD-Core Version:    0.7.0.1
 */