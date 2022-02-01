package com.tencent.oskplayer;

import android.content.Context;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.proxy.PreloadListener;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.util.LogProxy;
import com.tencent.oskplayer.util.OskVideoKeyGenerator;
import com.tencent.oskplayer.util.Singleton;
import java.util.List;

public class OskPlayerCore
{
  private static boolean mIsInited;
  private static OskPlayerConfig sConfig;
  static final Singleton<OskPlayerCore> sSingleton = new OskPlayerCore.1();
  
  public static OskPlayerCore getInstance()
  {
    return (OskPlayerCore)sSingleton.getInstance();
  }
  
  public static void init(Context paramContext, OskPlayerConfig paramOskPlayerConfig)
  {
    if (!mIsInited)
    {
      PlayerConfig.init(paramContext);
      initConfig(paramOskPlayerConfig);
      OskSupport.init(paramContext, new LogProxy(paramOskPlayerConfig.getLogger()), paramOskPlayerConfig.getNativeLibLoader());
      VideoManager.init(paramContext);
      mIsInited = true;
    }
  }
  
  private static void initConfig(OskPlayerConfig paramOskPlayerConfig)
  {
    if (paramOskPlayerConfig != null)
    {
      sConfig = paramOskPlayerConfig;
      PlayerConfig.g().setCacheProvider(1);
      PlayerConfig.g().setIsDebugVersion(sConfig.isDebugVersion());
      PlayerConfig.g().setEnableProxy(sConfig.isProxyEnabled());
      PlayerConfig.g().setEnableCache(sConfig.isCacheEnabled());
      PlayerConfig.g().setCacheMaxBytes(sConfig.getMaxCacheSizeByte());
      PlayerConfig.g().setVideoReporter(sConfig.getVideoReporter());
      PlayerConfig.g().setContentTypeList(sConfig.getAllowedContentType());
      PlayerConfig.g().setDataSourceMaxRetryCount(sConfig.getConnectionRetryCount());
      PlayerConfig.g().setVideoKeyGenerator(new OskVideoKeyGenerator(sConfig.getCacheKeyGenerator()));
      PlayerConfig localPlayerConfig = PlayerConfig.g();
      if (paramOskPlayerConfig.getNativeLibLoader() == null) {
        paramOskPlayerConfig = new DefaultNativeLibLoader();
      } else {
        paramOskPlayerConfig = paramOskPlayerConfig.getNativeLibLoader();
      }
      localPlayerConfig.setNativeLibLoader(paramOskPlayerConfig);
      PlayerConfig.g().setEnableHLSCache(sConfig.isEnableHLSCache());
      PlayerConfig.g().setLogger(sConfig.getLogger());
      PlayerConfig.g().setGlobalExtraHeader(sConfig.getGlobalExtraHeader());
      PlayerConfig.g().setEnableProxySecret(sConfig.isEnableProxySecret());
    }
  }
  
  public void addDownloadErrorListener(String paramString, DownloadErrorListener paramDownloadErrorListener)
  {
    VideoManager.getInstance().addHttpErrorListener(paramString, paramDownloadErrorListener);
  }
  
  public void cancelPreloadMedia()
  {
    VideoManager.getInstance().cancelPreloadMedia();
  }
  
  public OskPlayerConfig getConfig()
  {
    return sConfig;
  }
  
  public String getUrl(String paramString)
  {
    return VideoManager.getInstance().getUrl(paramString);
  }
  
  public String getUrl(String paramString, HttpHeader paramHttpHeader)
  {
    return VideoManager.getInstance().getUrl(paramString, paramHttpHeader);
  }
  
  public void preloadMedia(List<String> paramList, int paramInt, long paramLong, PreloadListener paramPreloadListener)
  {
    VideoManager.getInstance().preloadMedia(paramList, paramInt, paramLong, paramPreloadListener);
  }
  
  public void removeDownloadErrorListener(String paramString)
  {
    VideoManager.getInstance().removeHttpErrorListener(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.OskPlayerCore
 * JD-Core Version:    0.7.0.1
 */