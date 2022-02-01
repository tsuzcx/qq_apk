package com.tencent.oskplayer.datasource;

import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.cache.CacheDataSource;
import com.tencent.oskplayer.cache.CacheDataSource.EventListener;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;

public class DefaultDataSourceBuilder
  implements DataSourceBuilder
{
  private static final String TAG = "DefaultDataSourceBuilder";
  private static BandwidthMeter bandwidthMeter;
  private Cache cache;
  private CacheDataSink cacheDataSink;
  private FileDataSource fileDataSource;
  private DefaultHttpDataSource httpTransport;
  private VideoRequest mVideoRequest;
  
  public DefaultDataSourceBuilder(Cache paramCache, HttpRetryLogic paramHttpRetryLogic, VideoRequest paramVideoRequest)
  {
    if (bandwidthMeter == null) {
      bandwidthMeter = new DefaultBandwidthMeter(null, null);
    }
    this.httpTransport = new NiceHttpDataSource("com.qzone.player-v20150909", new PassOnVideoType(), bandwidthMeter, paramHttpRetryLogic, paramVideoRequest.getContentTypeFixer(), paramVideoRequest);
    this.fileDataSource = new FileDataSource();
    this.cache = paramCache;
    if (paramCache != null) {
      this.cacheDataSink = new CacheDataSink(paramCache, PlayerConfig.g().getCacheSingleFileBytes());
    }
    this.mVideoRequest = paramVideoRequest;
  }
  
  public static BandwidthMeter getBandwidthMeter()
  {
    return bandwidthMeter;
  }
  
  public DataSource build(String paramString1, String paramString2)
  {
    this.httpTransport.setLogTag(paramString2);
    Object localObject = this.cacheDataSink;
    if (localObject != null) {
      ((CacheDataSink)localObject).setLogTag(paramString2);
    }
    this.fileDataSource.setLogTag(paramString2);
    boolean bool1 = URLUtil.isNetworkUrl(paramString1);
    boolean bool2 = PlayerUtils.isAssetsUri(paramString1);
    boolean bool3 = PlayerUtils.isRawResourceUri(paramString1);
    if (bool2)
    {
      paramString1 = new AssetDataSource(PlayerConfig.g().getAppContext());
      paramString1.setLogTag(paramString2);
      return paramString1;
    }
    if (bool3)
    {
      paramString1 = new RawResourceDataSource(PlayerConfig.g().getAppContext());
      paramString1.setLogTag(paramString2);
      return paramString1;
    }
    if ((bool1 ^ true))
    {
      paramString1 = this.fileDataSource;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("DefaultDataSourceBuilder");
      PlayerUtils.log(3, ((StringBuilder)localObject).toString(), "play local file");
    }
    for (;;)
    {
      return paramString1;
      if ((this.cache != null) && (PlayerConfig.g().isEnableCache()))
      {
        localObject = new DefaultDataSourceBuilder.CacheEventListener(this);
        Cache localCache = this.cache;
        DefaultHttpDataSource localDefaultHttpDataSource = this.httpTransport;
        FileDataSource localFileDataSource = this.fileDataSource;
        if (this.mVideoRequest.isCacheEnabled()) {
          paramString1 = this.cacheDataSink;
        } else {
          paramString1 = null;
        }
        paramString1 = new CacheDataSource(localCache, localDefaultHttpDataSource, localFileDataSource, paramString1, false, true, (CacheDataSource.EventListener)localObject);
        paramString1.setLogTag(paramString2);
        return paramString1;
      }
      paramString1 = this.httpTransport;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("DefaultDataSourceBuilder");
      PlayerUtils.log(5, ((StringBuilder)localObject).toString(), "cache disabled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultDataSourceBuilder
 * JD-Core Version:    0.7.0.1
 */