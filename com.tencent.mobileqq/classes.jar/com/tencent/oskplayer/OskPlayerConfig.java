package com.tencent.oskplayer;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.oskplayer.cache.CacheKeyGenerator;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.util.QLog;
import java.util.List;

public class OskPlayerConfig
{
  private String[] mAllowedContentType = new String[0];
  private boolean mCacheEnabled = true;
  private CacheKeyGenerator mCacheKeyGenerator;
  private int mConnectionRetryCount = 3;
  private boolean mEnableProxySecret = true;
  private HttpHeader mExtraHeader;
  private boolean mIsDebugVersion = true;
  private boolean mIsEnableHLSCache = true;
  private QLog mLogger;
  private long mMaxCacheSizeByte = 536870912L;
  private int mMaxMediaPlayerInstance = 3;
  private NativeLibLoader mNativeLibLoader;
  private boolean mProxyEnabled = true;
  private volatile boolean mSSLCertVerify = false;
  private IVideoReporter mVideoReporter = null;
  
  List<String> getAllowedContentType()
  {
    return null;
  }
  
  CacheKeyGenerator getCacheKeyGenerator()
  {
    if (this.mCacheKeyGenerator == null) {
      this.mCacheKeyGenerator = new DefaultCacheKeyGenerator();
    }
    return this.mCacheKeyGenerator;
  }
  
  int getConnectionRetryCount()
  {
    return this.mConnectionRetryCount;
  }
  
  public HttpHeader getGlobalExtraHeader()
  {
    return this.mExtraHeader;
  }
  
  QLog getLogger()
  {
    return this.mLogger;
  }
  
  long getMaxCacheSizeByte()
  {
    return this.mMaxCacheSizeByte;
  }
  
  int getMaxMediaPlayerInstance()
  {
    return this.mMaxMediaPlayerInstance;
  }
  
  NativeLibLoader getNativeLibLoader()
  {
    return this.mNativeLibLoader;
  }
  
  IVideoReporter getVideoReporter()
  {
    return this.mVideoReporter;
  }
  
  boolean isCacheEnabled()
  {
    return this.mCacheEnabled;
  }
  
  boolean isDebugVersion()
  {
    return this.mIsDebugVersion;
  }
  
  boolean isEnableHLSCache()
  {
    return this.mIsEnableHLSCache;
  }
  
  boolean isEnableProxySecret()
  {
    return this.mEnableProxySecret;
  }
  
  boolean isProxyEnabled()
  {
    return this.mProxyEnabled;
  }
  
  public boolean isSSLCertVerifyEnabled()
  {
    return this.mSSLCertVerify;
  }
  
  public void setAllowedContentType(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mAllowedContentType = paramString.split("\\|");
    }
  }
  
  public void setCacheKeyGenerator(CacheKeyGenerator paramCacheKeyGenerator)
  {
    this.mCacheKeyGenerator = paramCacheKeyGenerator;
  }
  
  public void setConnectionRetryCount(int paramInt)
  {
    this.mConnectionRetryCount = paramInt;
  }
  
  public void setDebugVersion(boolean paramBoolean)
  {
    this.mIsDebugVersion = paramBoolean;
  }
  
  public void setEnableCache(boolean paramBoolean)
  {
    this.mCacheEnabled = paramBoolean;
  }
  
  public void setEnableHLSCache(boolean paramBoolean)
  {
    this.mIsEnableHLSCache = paramBoolean;
  }
  
  public void setEnableProxy(boolean paramBoolean)
  {
    this.mProxyEnabled = paramBoolean;
  }
  
  public void setEnableProxySecret(boolean paramBoolean)
  {
    this.mEnableProxySecret = paramBoolean;
  }
  
  public void setEnableSSLVerify(boolean paramBoolean)
  {
    this.mSSLCertVerify = paramBoolean;
  }
  
  public void setGlobalExtraHeader(HttpHeader paramHttpHeader)
  {
    this.mExtraHeader = paramHttpHeader;
  }
  
  public void setLogger(QLog paramQLog)
  {
    if (this.mLogger != null) {
      Log.w("OskPlayer", "logger is modified, which is not recommended");
    }
    this.mLogger = paramQLog;
  }
  
  public void setMaxCacheSizeByte(int paramInt)
  {
    this.mMaxCacheSizeByte = paramInt;
  }
  
  public void setNativeLibLoader(NativeLibLoader paramNativeLibLoader)
  {
    this.mNativeLibLoader = paramNativeLibLoader;
  }
  
  public void setVideoReporter(IVideoReporter paramIVideoReporter)
  {
    this.mVideoReporter = paramIVideoReporter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.OskPlayerConfig
 * JD-Core Version:    0.7.0.1
 */