package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class GamePreConnectManager
{
  private static final String CONNECTION_KEEP_ALIVE = "keep-alive";
  private static final String HEADER_CONNECTION = "Connection";
  private static final String HOST_HTTPS_PREFIX = "https://";
  private static final int PRE_CONNECTION_LIMIT = ;
  private static final String TAG = "GamePreConnectManager";
  private static boolean sPreConnectDownloader;
  
  public static void connectHost(MiniGamePkg paramMiniGamePkg)
  {
    if (PRE_CONNECTION_LIMIT <= 0) {
      break label6;
    }
    label130:
    for (;;)
    {
      label6:
      return;
      if ((paramMiniGamePkg != null) && (paramMiniGamePkg.appConfig != null) && (paramMiniGamePkg.appConfig.config != null) && (paramMiniGamePkg.appConfig.config.requestDomainList != null) && (paramMiniGamePkg.appConfig.config.requestDomainList.size() > 0))
      {
        paramMiniGamePkg = paramMiniGamePkg.appConfig.config.requestDomainList.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramMiniGamePkg.hasNext()) {
            break label130;
          }
          String str = (String)paramMiniGamePkg.next();
          if (i >= PRE_CONNECTION_LIMIT) {
            break;
          }
          tryConnectHost("https://" + str);
          i += 1;
        }
      }
    }
  }
  
  public static void preConnectDownloader()
  {
    if ((!sPreConnectDownloader) && (GameWnsUtils.enableDownloaderPreConnect()) && (MiniappDownloadUtil.getInstance().rangeDownloadEnable()))
    {
      sPreConnectDownloader = true;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(GameWnsUtils.downloaderPreConnectHost());
      MiniappDownloadUtil.getInstance().preConnectHost(localArrayList);
    }
  }
  
  private static void tryConnectHost(String paramString)
  {
    GameLog.getInstance().i("GamePreConnectManager", "try pre-connect:" + paramString);
    long l = System.currentTimeMillis();
    Request.Builder localBuilder = new Request.Builder().url(paramString).addHeader("Connection", "keep-alive").head();
    paramString = new GamePreConnectManager.1(paramString, l);
    MiniOkHttpClientFactory.getRequestClient().newCall(localBuilder.build()).enqueue(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager
 * JD-Core Version:    0.7.0.1
 */