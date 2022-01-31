package com.tencent.oskplayer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoProxy.OnConnectionChangeListener;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerConfig
{
  public static final boolean ASSERTIONS_ENABLED = true;
  public static final int CACHE_PROVIDER_LOCAL = 1;
  public static final int CACHE_PROVIDER_TC = 2;
  public static String CONTENT_TYPE_AUDIO_MP4;
  public static String CONTENT_TYPE_HLS_PLAYLIST = "application/vnd.apple.mpegurl";
  public static String CONTENT_TYPE_HLS_PLAYLIST_COMPAT = "application/x-mpeg";
  public static String CONTENT_TYPE_HLS_PLAYLIST_COMPAT2 = "application/x-mpegURL";
  public static String CONTENT_TYPE_MPEG_TS = "video/MP2T";
  public static String CONTENT_TYPE_OCT_STREAM;
  public static String CONTENT_TYPE_VIDEO_3GP;
  public static String CONTENT_TYPE_VIDEO_MP4 = "video/mp4";
  public static String CONTENT_TYPE_VIDEO_MPEG;
  private static final long DEFUALT_CACHE_MAX_BYTES = 536870912L;
  private static final long DEFUALT_CACHE_SINGLE_FILE_BYTES = 1048576L;
  private static final int DEFUALT_CORE_CLIENT_COUNT = 10;
  private static final int DEFUALT_MAX_CLIENT_COUNT = 10;
  public static final String H265_DECODE_SCORE_REPORTED_MARK_PREFERENCE_KEY = "h265_decode_score_reported";
  public static final String LOCAL_CACHE_DIR_NAME = "local";
  public static final int MIN_FREE_SPACE = 1;
  public static final String SERVER = "videoproxy 1.4.1";
  private static final String TAG = "PlayerConfig";
  public static final String TC_CACHE_DIR_NAME = "tc";
  public static final boolean TRACE_ENABLED = true;
  public static final String USER_AGENT = "com.qzone.player-v20150909";
  public static final String VERSION = "1.4.1";
  private static final QLog defaultLogger = new DefaultLogger();
  private static volatile PlayerConfig instance;
  private Context appContext;
  private String cacheDir;
  private long cacheMaxBytes = 536870912L;
  private long cacheSingleFileBytes = 1048576L;
  private int coreClientCount = 10;
  private DataSourceBuilder dataSourceBuilder;
  private boolean enableCache = true;
  private boolean enableProxy = true;
  private boolean enableProxySecret = true;
  private List<String> hostLastPathVideoList;
  private QLog logger;
  private int mCacheProvider = 1;
  private List<String> mContentTypeList;
  public int mDataSourceMaxRetryCount = 5;
  private String mDefaultDataSourceType = "-1";
  private DNSService mDnsService;
  private boolean mEnableIResearchReport;
  private boolean mEnableWeishiDirectIp = false;
  private HttpHeader mExtraHeader;
  private List<String> mHeroInfoList = new ArrayList();
  private String mHostEnableHttpDNSService = "";
  private String mHostEnableHttpDNSServicePrependIp = "";
  private volatile int mIPStackType = -1;
  private boolean mIsDebug = false;
  private boolean mIsEnableHLSCache = true;
  private boolean mIsEnableHevcHwDecode = false;
  private NativeLibLoader mLibLoader;
  private int mLogcatContextSeconds = 10;
  private String mQLoadControlConfig = "65536,15000,30000,2000,5000";
  private int mSafeUrlTimeOut = 8;
  private boolean mServerIPWithGetByName = false;
  private List<String> mTcVideoPathList;
  public int mVideoFloatCompleteType = 1;
  private int mVideoLowSpeedRates = 20;
  private int mVideoLowSpeedSeconds = 8;
  private IVideoReporter mVideoReporter;
  private int mVideoVkeyTimeOut = 10;
  private List<String> mWeiShiUgcVideoPathList;
  private List<String> mWeiShiVideoPathList;
  private int maxClientCount = 10;
  private List<String> normalVideoPathList;
  private VideoProxy.OnConnectionChangeListener onConnectionChangeListener;
  private Set<PlayerCallBack> playerCallBacks;
  private String tmpDir;
  private VideoKeyGenerator videoKeyGenerator;
  
  static
  {
    CONTENT_TYPE_VIDEO_3GP = "video/3gp";
    CONTENT_TYPE_AUDIO_MP4 = "audio/mp4";
    CONTENT_TYPE_VIDEO_MPEG = "video/mpeg";
    CONTENT_TYPE_OCT_STREAM = "application/octet-stream";
  }
  
  private PlayerConfig(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  public static PlayerConfig g()
  {
    if (instance == null) {
      throw new RuntimeException("PlayerConfig not initialized!");
    }
    return instance;
  }
  
  private String getCacheProvideFileDir(String paramString)
  {
    Object localObject = new StringBuilder().append(paramString).append(File.separator);
    if (isCacheProviderLocal()) {}
    for (paramString = "local";; paramString = "tc")
    {
      paramString = paramString;
      localObject = new File(paramString);
      boolean bool;
      if (((File)localObject).isFile())
      {
        bool = ((File)localObject).delete();
        PlayerUtils.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!((File)localObject).exists())
      {
        bool = ((File)localObject).mkdirs();
        PlayerUtils.log(4, "PlayerConfig", "fileDir:" + paramString + " is not exist, make dir result:" + bool);
      }
      return paramString;
    }
  }
  
  public static boolean hasInit()
  {
    return instance != null;
  }
  
  public static void init(Context paramContext)
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new PlayerConfig(paramContext);
        }
        return;
      }
      finally {}
    }
  }
  
  public Context getAppContext()
  {
    return this.appContext;
  }
  
  public String getCacheDir()
  {
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        File localFile = this.appContext.getExternalCacheDir();
        if (localFile == null) {
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        for (;;)
        {
          localObject = null;
        }
        return getCacheProvideFileDir(localObject + File.separator + "video_cache");
      }
    }
    return this.cacheDir;
  }
  
  public long getCacheMaxBytes()
  {
    return this.cacheMaxBytes;
  }
  
  public long getCacheSingleFileBytes()
  {
    return this.cacheSingleFileBytes;
  }
  
  public Set<PlayerCallBack> getCallbacks()
  {
    try
    {
      Set localSet = this.playerCallBacks;
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<String> getContentTypeList()
  {
    if (this.mContentTypeList != null) {
      return this.mContentTypeList;
    }
    return new ArrayList(Arrays.asList(new String[] { CONTENT_TYPE_VIDEO_MP4, CONTENT_TYPE_VIDEO_3GP, CONTENT_TYPE_AUDIO_MP4, CONTENT_TYPE_OCT_STREAM, CONTENT_TYPE_VIDEO_MPEG, CONTENT_TYPE_HLS_PLAYLIST, CONTENT_TYPE_HLS_PLAYLIST_COMPAT, CONTENT_TYPE_HLS_PLAYLIST_COMPAT2, CONTENT_TYPE_MPEG_TS }));
  }
  
  public int getCoreClientCount()
  {
    return this.coreClientCount;
  }
  
  public DNSService getDNSService()
  {
    return this.mDnsService;
  }
  
  public DataSourceBuilder getDataSourceBuilder()
  {
    return this.dataSourceBuilder;
  }
  
  public int getDataSourceMaxRetryCount()
  {
    return this.mDataSourceMaxRetryCount;
  }
  
  public String getDefaultDataSourceType()
  {
    return this.mDefaultDataSourceType;
  }
  
  public int getFloafVideoCompleteType()
  {
    return this.mVideoFloatCompleteType;
  }
  
  public HttpHeader getGlobalExtraHeader()
  {
    return this.mExtraHeader;
  }
  
  public List<String> getHeroPlayerSetInfo()
  {
    return this.mHeroInfoList;
  }
  
  public List<String> getHostLastPathVideoList()
  {
    return this.hostLastPathVideoList;
  }
  
  public int getIPStackType()
  {
    return this.mIPStackType;
  }
  
  public int getLogcatContextSecond()
  {
    return this.mLogcatContextSeconds;
  }
  
  public QLog getLogger()
  {
    if (this.logger == null) {
      return defaultLogger;
    }
    return this.logger;
  }
  
  public int getMaxClientCount()
  {
    return this.maxClientCount;
  }
  
  public NativeLibLoader getNativeLibLoader()
  {
    if (this.mLibLoader == null) {
      this.mLibLoader = new DefaultNativeLibLoader();
    }
    return this.mLibLoader;
  }
  
  public List<String> getNormalVideoPathList()
  {
    return this.normalVideoPathList;
  }
  
  public VideoProxy.OnConnectionChangeListener getOnConnectionChangeListener()
  {
    return this.onConnectionChangeListener;
  }
  
  public String getQLoadControlConfig()
  {
    return this.mQLoadControlConfig;
  }
  
  public int getSafeUrlTimeOut()
  {
    return this.mSafeUrlTimeOut;
  }
  
  public List<String> getTcVideoPathList()
  {
    return this.mTcVideoPathList;
  }
  
  public String getTempDir()
  {
    if (TextUtils.isEmpty(this.tmpDir))
    {
      File localFile = this.appContext.getFilesDir();
      if (localFile == null) {
        return null;
      }
      return localFile + File.separator + "video_tmp_files";
    }
    return this.tmpDir;
  }
  
  public int getVideoEnableLowSpeedRates()
  {
    return this.mVideoLowSpeedRates;
  }
  
  public int getVideoEnableLowSpeedSeconds()
  {
    return this.mVideoLowSpeedSeconds;
  }
  
  public VideoKeyGenerator getVideoKeyGenerator()
  {
    return this.videoKeyGenerator;
  }
  
  public IVideoReporter getVideoReporter()
  {
    return this.mVideoReporter;
  }
  
  public int getVideoVkeyTimeOut()
  {
    return this.mVideoVkeyTimeOut;
  }
  
  public List<String> getWeiShiUgcVideoPathList()
  {
    return this.mWeiShiUgcVideoPathList;
  }
  
  public List<String> getWeiShiVideoPathList()
  {
    return this.mWeiShiVideoPathList;
  }
  
  public boolean isCacheProviderLocal()
  {
    return this.mCacheProvider == 1;
  }
  
  public boolean isDebugVersion()
  {
    return this.mIsDebug;
  }
  
  public boolean isEnableCache()
  {
    return this.enableCache;
  }
  
  public boolean isEnableHLSCache()
  {
    return this.mIsEnableHLSCache;
  }
  
  public boolean isEnableHevcHwDecode()
  {
    return this.mIsEnableHevcHwDecode;
  }
  
  public boolean isEnableProxy()
  {
    return this.enableProxy;
  }
  
  public boolean isEnableProxySecret()
  {
    return this.enableProxySecret;
  }
  
  public boolean isEnableWeishiDirectIp()
  {
    return this.mEnableWeishiDirectIp;
  }
  
  public boolean isHostEnableHttpDNSService(String paramString)
  {
    if (!TextUtils.isEmpty(this.mHostEnableHttpDNSService)) {
      return this.mHostEnableHttpDNSService.contains(paramString);
    }
    return false;
  }
  
  public boolean isHostEnableHttpDNSServicePrependIp(String paramString)
  {
    if (!TextUtils.isEmpty(this.mHostEnableHttpDNSServicePrependIp)) {
      return this.mHostEnableHttpDNSServicePrependIp.contains(paramString);
    }
    return false;
  }
  
  public boolean isIResearchEnabled()
  {
    return this.mEnableIResearchReport;
  }
  
  public boolean isServerIPWithGetByName()
  {
    return this.mServerIPWithGetByName;
  }
  
  public void registerCallback(PlayerCallBack paramPlayerCallBack)
  {
    if (paramPlayerCallBack != null) {}
    try
    {
      if (this.playerCallBacks == null) {
        this.playerCallBacks = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.75F));
      }
      this.playerCallBacks.add(paramPlayerCallBack);
      return;
    }
    finally {}
  }
  
  public void setCacheDir(String paramString)
  {
    this.cacheDir = getCacheProvideFileDir(paramString);
  }
  
  public void setCacheMaxBytes(long paramLong)
  {
    this.cacheMaxBytes = paramLong;
  }
  
  public void setCacheProvider(int paramInt)
  {
    this.mCacheProvider = paramInt;
  }
  
  public void setCacheSingleFileBytes(long paramLong)
  {
    this.cacheSingleFileBytes = paramLong;
  }
  
  public void setContentTypeList(List<String> paramList)
  {
    this.mContentTypeList = paramList;
  }
  
  public void setDNSService(DNSService paramDNSService)
  {
    this.mDnsService = paramDNSService;
  }
  
  public void setDataSourceBuilder(DataSourceBuilder paramDataSourceBuilder)
  {
    this.dataSourceBuilder = paramDataSourceBuilder;
  }
  
  public void setDataSourceMaxRetryCount(int paramInt)
  {
    this.mDataSourceMaxRetryCount = paramInt;
  }
  
  public void setDefaultDataSourceType(String paramString)
  {
    this.mDefaultDataSourceType = paramString;
  }
  
  public void setEnableCache(boolean paramBoolean)
  {
    this.enableCache = paramBoolean;
  }
  
  public void setEnableHLSCache(boolean paramBoolean)
  {
    this.mIsEnableHLSCache = paramBoolean;
  }
  
  public void setEnableHevcHwDecode(boolean paramBoolean)
  {
    this.mIsEnableHevcHwDecode = paramBoolean;
  }
  
  public void setEnableIResearchReport(boolean paramBoolean)
  {
    this.mEnableIResearchReport = paramBoolean;
  }
  
  public void setEnableProxy(boolean paramBoolean)
  {
    this.enableProxy = paramBoolean;
  }
  
  public void setEnableProxySecret(boolean paramBoolean)
  {
    this.enableProxySecret = paramBoolean;
  }
  
  public void setEnableWeishiDirectIp(boolean paramBoolean)
  {
    this.mEnableWeishiDirectIp = paramBoolean;
  }
  
  public void setFloatVideoCompleteType(int paramInt)
  {
    this.mVideoFloatCompleteType = paramInt;
  }
  
  public void setGlobalExtraHeader(HttpHeader paramHttpHeader)
  {
    this.mExtraHeader = paramHttpHeader;
  }
  
  public void setHeroPlayerSetInfo(List<String> paramList)
  {
    this.mHeroInfoList = paramList;
  }
  
  public void setHostEnableHttpDNSService(String paramString)
  {
    this.mHostEnableHttpDNSService = paramString;
  }
  
  public void setHostEnableHttpDNSServicePrependIp(String paramString)
  {
    this.mHostEnableHttpDNSServicePrependIp = paramString;
  }
  
  public void setHostLastPathVideoList(List<String> paramList)
  {
    this.hostLastPathVideoList = paramList;
  }
  
  public void setIPStackType(int paramInt)
  {
    PlayerUtils.log(4, "PlayerConfig", "setIPStackType " + paramInt);
    this.mIPStackType = paramInt;
  }
  
  public void setIsDebugVersion(boolean paramBoolean)
  {
    this.mIsDebug = paramBoolean;
  }
  
  public void setLogcatContextSecond(int paramInt)
  {
    this.mLogcatContextSeconds = paramInt;
  }
  
  public void setLogger(QLog paramQLog)
  {
    this.logger = paramQLog;
  }
  
  public void setNativeLibLoader(NativeLibLoader paramNativeLibLoader)
  {
    this.mLibLoader = paramNativeLibLoader;
  }
  
  public void setNormalVideoPathList(List<String> paramList)
  {
    this.normalVideoPathList = paramList;
  }
  
  public void setOnConnectionChangeListener(VideoProxy.OnConnectionChangeListener paramOnConnectionChangeListener)
  {
    this.onConnectionChangeListener = paramOnConnectionChangeListener;
  }
  
  public void setQLoadControlConfig(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mQLoadControlConfig = paramString;
      return;
    }
    PlayerUtils.log(6, "PlayerConfig", "setQLoadControlConfig ineffective " + paramString);
  }
  
  public void setSafeUrlTimeOut(int paramInt)
  {
    this.mSafeUrlTimeOut = paramInt;
  }
  
  public void setServerIpWithGetByName(boolean paramBoolean)
  {
    this.mServerIPWithGetByName = paramBoolean;
  }
  
  public void setTcVideoPathList(List<String> paramList)
  {
    this.mTcVideoPathList = paramList;
  }
  
  public void setVideoEnableLowSpeedRates(int paramInt)
  {
    this.mVideoLowSpeedRates = paramInt;
  }
  
  public void setVideoEnableLowSpeedSeconds(int paramInt)
  {
    this.mVideoLowSpeedSeconds = paramInt;
  }
  
  public void setVideoKeyGenerator(VideoKeyGenerator paramVideoKeyGenerator)
  {
    this.videoKeyGenerator = paramVideoKeyGenerator;
  }
  
  public void setVideoReporter(IVideoReporter paramIVideoReporter)
  {
    this.mVideoReporter = paramIVideoReporter;
  }
  
  public void setVideoVkeyTimeOut(int paramInt)
  {
    this.mVideoVkeyTimeOut = paramInt;
  }
  
  public void setWeiShiUgcVideoPathList(List<String> paramList)
  {
    this.mWeiShiUgcVideoPathList = paramList;
  }
  
  public void setWeiShiVideoPathList(List<String> paramList)
  {
    this.mWeiShiVideoPathList = paramList;
  }
  
  public void unregisterCallback(PlayerCallBack paramPlayerCallBack)
  {
    if (paramPlayerCallBack != null) {}
    try
    {
      if (this.playerCallBacks != null) {
        this.playerCallBacks.remove(paramPlayerCallBack);
      }
      return;
    }
    finally
    {
      paramPlayerCallBack = finally;
      throw paramPlayerCallBack;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.PlayerConfig
 * JD-Core Version:    0.7.0.1
 */