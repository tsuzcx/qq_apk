package com.tencent.sonic.sdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class SonicSession
  implements Handler.Callback
{
  public static final String CHROME_FILE_THREAD = "Chrome_FileThread";
  private static final int CLIENT_CORE_MSG_BEGIN = 4;
  private static final int CLIENT_CORE_MSG_CONNECTION_ERROR = 9;
  private static final int CLIENT_CORE_MSG_DATA_UPDATE = 7;
  private static final int CLIENT_CORE_MSG_END = 11;
  private static final int CLIENT_CORE_MSG_FIRST_LOAD = 6;
  private static final int CLIENT_CORE_MSG_PRE_LOAD = 5;
  private static final int CLIENT_CORE_MSG_SERVICE_UNAVAILABLE = 10;
  private static final int CLIENT_CORE_MSG_TEMPLATE_CHANGE = 8;
  protected static final int CLIENT_MSG_NOTIFY_RESULT = 1;
  protected static final int CLIENT_MSG_ON_WEB_READY = 2;
  protected static final int COMMON_MSG_BEGIN = 0;
  protected static final int COMMON_MSG_END = 4;
  public static final String DATA_UPDATE_BUNDLE_PARAMS_DIFF = "_diff_data_";
  protected static final int FILE_THREAD_MSG_BEGIN = 0;
  protected static final int FILE_THREAD_SAVE_CACHE_ON_SERVER_CLOSE = 1;
  protected static final int FILE_THREAD_SAVE_CACHE_ON_SESSION_FINISHED = 2;
  private static final int FIRST_LOAD_NO_DATA = 1;
  private static final int FIRST_LOAD_WITH_DATA = 2;
  public static final String OFFLINE_MODE_FALSE = "false";
  public static final String OFFLINE_MODE_HTTP = "http";
  public static final String OFFLINE_MODE_STORE = "store";
  public static final String OFFLINE_MODE_TRUE = "true";
  private static final int PRE_LOAD_NO_CACHE = 1;
  private static final int PRE_LOAD_WITH_CACHE = 2;
  protected static final int RESOURCE_INTERCEPT_STATE_IN_FILE_THREAD = 1;
  protected static final int RESOURCE_INTERCEPT_STATE_IN_OTHER_THREAD = 2;
  protected static final int RESOURCE_INTERCEPT_STATE_NONE = 0;
  protected static final int SESSION_MSG_FORCE_DESTROY = 3;
  public static final int SONIC_RESULT_CODE_DATA_UPDATE = 200;
  public static final int SONIC_RESULT_CODE_FIRST_LOAD = 1000;
  public static final int SONIC_RESULT_CODE_HIT_CACHE = 304;
  public static final int SONIC_RESULT_CODE_TEMPLATE_CHANGE = 2000;
  public static final int SONIC_RESULT_CODE_UNKNOWN = -1;
  public static final String SONIC_URL_PARAM_PRELOAD = "_preload";
  public static final String SONIC_URL_PARAM_SESSION_ID = "_sonic_id";
  public static final int STATE_DESTROY = 3;
  public static final int STATE_NONE = 0;
  public static final int STATE_READY = 2;
  public static final int STATE_RUNNING = 1;
  public static final String TAG = "SonicSdk_SonicSession";
  private static final int TEMPLATE_CHANGE_REFRESH = 1;
  public static final String WEB_RESPONSE_CODE = "code";
  public static final String WEB_RESPONSE_DATA = "result";
  public static final String WEB_RESPONSE_EXTRA = "extra";
  public static final String WEB_RESPONSE_LAST_IS_RED_PRELOAD = "isPreload";
  public static final String WEB_RESPONSE_LOCAL_REFRESH_TIME = "local_refresh_time";
  public static final String WEB_RESPONSE_SRC_CODE = "srcCode";
  protected static long sNextSessionLogId = new Random().nextInt(263167);
  protected final AtomicBoolean clientIsReady = new AtomicBoolean(false);
  protected final AtomicBoolean clientIsReload = new AtomicBoolean(false);
  public final SonicSessionConfig config;
  public long createdTime;
  public String currUrl;
  protected SonicDiffDataCallback diffDataCallback;
  protected final Handler fileHandler;
  protected int finalResultCode = -1;
  public final String id;
  protected final Intent intent = new Intent();
  protected boolean isPreload;
  private boolean isRedPointPreload;
  protected final AtomicBoolean isWaitingForDestroy = new AtomicBoolean(false);
  protected final AtomicBoolean isWaitingForSaveFile = new AtomicBoolean(false);
  protected final AtomicBoolean isWaitingForSessionThread = new AtomicBoolean(false);
  private long lastDateUpdateTime;
  private boolean lastIsRedPointPreload;
  protected final Handler mainHandler = new Handler(Looper.getMainLooper(), this);
  private Message pendingClientCoreMessage;
  protected String pendingDiffData = "";
  protected volatile InputStream pendingWebResourceStream;
  protected List<String> preloadLinks;
  protected final AtomicInteger resourceInterceptState = new AtomicInteger(0);
  public final long sId;
  protected volatile SonicServer server;
  protected volatile SonicSessionClient sessionClient;
  protected final AtomicInteger sessionState = new AtomicInteger(0);
  protected int srcResultCode = -1;
  public String srcUrl;
  protected final CopyOnWriteArrayList<WeakReference<SonicSession.Callback>> stateChangedCallbackList = new CopyOnWriteArrayList();
  protected SonicSessionStatistics statistics = new SonicSessionStatistics();
  protected final AtomicBoolean wasInterceptInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasLoadDataInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasLoadUrlInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasNotified = new AtomicBoolean(false);
  protected final AtomicBoolean wasOnPageFinishInvoked = new AtomicBoolean(false);
  
  SonicSession(String paramString1, String paramString2, SonicSessionConfig paramSonicSessionConfig)
  {
    this.id = paramString1;
    this.config = paramSonicSessionConfig;
    long l = sNextSessionLogId;
    sNextSessionLogId = 1L + l;
    this.sId = l;
    this.statistics.srcUrl = paramString2.trim();
    this.srcUrl = SonicUtils.addSonicUrlParam(this.statistics.srcUrl, "_sonic_id", String.valueOf(this.sId));
    this.currUrl = this.srcUrl;
    this.createdTime = System.currentTimeMillis();
    this.isRedPointPreload = isRedPointPreload();
    this.fileHandler = new Handler(SonicEngine.getInstance().getRuntime().getFileThreadLooper(), new SonicSession.1(this));
    if (SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE)
    {
      paramSonicSessionConfig = SonicEngine.getInstance().getRuntime().getCookie(this.srcUrl);
      if (!TextUtils.isEmpty(paramSonicSessionConfig)) {
        this.intent.putExtra("Cookie", paramSonicSessionConfig);
      }
    }
    if (SonicUtils.shouldLog(4))
    {
      paramSonicSessionConfig = new StringBuilder();
      paramSonicSessionConfig.append("session(");
      paramSonicSessionConfig.append(this.sId);
      paramSonicSessionConfig.append(") create:id=");
      paramSonicSessionConfig.append(paramString1);
      paramSonicSessionConfig.append(", url = ");
      paramSonicSessionConfig.append(paramString2);
      paramSonicSessionConfig.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicSessionConfig.toString());
    }
  }
  
  private void checkAndClearCacheData()
  {
    SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicSession.7(this), 50L);
  }
  
  @Nullable
  private SonicDataHelper.SessionData getSessionData(boolean paramBoolean)
  {
    if (paramBoolean) {
      return SonicDataHelper.getSessionData(this.id);
    }
    if (this.server != null)
    {
      localObject = new SonicDataHelper.SessionData();
      ((SonicDataHelper.SessionData)localObject).eTag = this.server.getResponseHeaderField("eTag");
      ((SonicDataHelper.SessionData)localObject).templateTag = this.server.getResponseHeaderField("template-tag");
      if (((TextUtils.isEmpty(((SonicDataHelper.SessionData)localObject).eTag)) || (TextUtils.isEmpty(((SonicDataHelper.SessionData)localObject).templateTag))) && (this.config.SUPPORT_LOCAL_SERVER))
      {
        this.server.separateTemplateAndData();
        ((SonicDataHelper.SessionData)localObject).eTag = this.server.getResponseHeaderField("eTag");
        ((SonicDataHelper.SessionData)localObject).templateTag = this.server.getResponseHeaderField("template-tag");
      }
      ((SonicDataHelper.SessionData)localObject).sessionId = this.id;
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("session(");
    ((StringBuilder)localObject).append(this.sId);
    ((StringBuilder)localObject).append(") runSonicFlow error:server is not valid!");
    SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject).toString());
    return new SonicDataHelper.SessionData();
  }
  
  private void handleClientCoreMessage_ConnectionError(Message paramMessage)
  {
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_ConnectionError: load src url.");
      }
      this.sessionClient.loadUrl(this.srcUrl, null);
    }
  }
  
  private void handleClientCoreMessage_DataUpdate(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    paramMessage = paramMessage.getData().getString("_diff_data_");
    boolean bool2 = this.wasLoadDataInvoked.get();
    boolean bool1 = true;
    if (bool2)
    {
      this.pendingDiffData = paramMessage;
      if (!TextUtils.isEmpty(paramMessage))
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_DataUpdate:try to notify web callback.");
        setResult(200, 200, true);
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_DataUpdate:diffData is null, cache-offline = store , do not refresh.");
      setResult(200, 304, true);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = new StringBuilder();
      paramMessage.append("handleClientCoreMessage_DataUpdate:oh yeah data update hit 304, now clear pending data ->");
      if (this.pendingDiffData == null) {
        bool1 = false;
      }
      paramMessage.append(bool1);
      paramMessage.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
      this.pendingDiffData = null;
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, str, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
      setResult(200, 304, false);
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "handleClientCoreMessage_DataUpdate error:call load url.");
    this.sessionClient.loadUrl(this.srcUrl, null);
    setResult(200, 1000, false);
  }
  
  private void handleClientCoreMessage_FirstLoad(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (this.wasLoadUrlInvoked.compareAndSet(false, true))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("session(");
        localStringBuilder.append(this.sId);
        localStringBuilder.append(") handleClientCoreMessage_FirstLoad:oh yeah, first load hit 304.");
        SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, (String)paramMessage.obj, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        setResult(1000, 304, false);
        return;
      }
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") FIRST_LOAD_WITH_DATA load url was invoked.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
      setResult(1000, 1000, true);
      return;
    }
    if (this.wasInterceptInvoked.get())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_DATA.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
      setResult(1000, 1000, true);
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("session(");
    paramMessage.append(this.sId);
    paramMessage.append(") handleClientCoreMessage_FirstLoad:url was not invoked.");
    SonicUtils.log("SonicSdk_SonicSession", 6, paramMessage.toString());
  }
  
  private void handleClientCoreMessage_PreLoad(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (this.wasLoadDataInvoked.compareAndSet(false, true))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("session(");
        localStringBuilder.append(this.sId);
        localStringBuilder.append(") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
        SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
        paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), null);
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", SonicUtils.DEFAULT_CHARSET, this.srcUrl, getCacheHeaders());
        return;
      }
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramMessage.toString());
      return;
    }
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
      this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "1");
      this.sessionClient.loadUrl(this.currUrl, null);
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("session(");
    paramMessage.append(this.sId);
    paramMessage.append(") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
    SonicUtils.log("SonicSdk_SonicSession", 6, paramMessage.toString());
  }
  
  private void handleClientCoreMessage_ServiceUnavailable(Message paramMessage)
  {
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_ServiceUnavailable:load src url.");
      }
      this.sessionClient.loadUrl(this.srcUrl, null);
    }
  }
  
  private void handleClientCoreMessage_TemplateChange(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleClientCoreMessage_TemplateChange wasLoadDataInvoked = ");
    localStringBuilder.append(this.wasLoadDataInvoked.get());
    localStringBuilder.append(",msg arg1 = ");
    localStringBuilder.append(paramMessage.arg1);
    SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
    if (this.wasLoadDataInvoked.get())
    {
      int i = paramMessage.arg1;
      boolean bool = true;
      if (1 == i)
      {
        if (TextUtils.isEmpty((String)paramMessage.obj))
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleClientCoreMessage_TemplateChange:load url with preload=2, webCallback is null? ->");
          if (this.diffDataCallback == null) {
            bool = false;
          }
          paramMessage.append(bool);
          SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
          this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "2");
          this.sessionClient.loadUrl(this.currUrl, null);
        }
        else
        {
          SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:load data.");
          paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()));
          this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        }
        setResult(2000, 2000, false);
      }
      else
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:not refresh.");
        setResult(2000, 304, true);
      }
    }
    else
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:oh yeah template change hit 304.");
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), null);
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        setResult(2000, 304, false);
      }
      else
      {
        SonicUtils.log("SonicSdk_SonicSession", 6, "handleClientCoreMessage_TemplateChange error:call load url.");
        this.sessionClient.loadUrl(this.srcUrl, null);
        setResult(2000, 1000, false);
      }
    }
    this.diffDataCallback = null;
    this.mainHandler.removeMessages(2);
  }
  
  private boolean isRedPointPreload()
  {
    Uri localUri = Uri.parse(this.srcUrl);
    this.isRedPointPreload = false;
    if ((localUri != null) && (localUri.isHierarchical())) {
      this.isRedPointPreload = "1".equals(localUri.getQueryParameter("_sonic_rp"));
    }
    return this.isRedPointPreload;
  }
  
  private void runSonicFlow(boolean paramBoolean)
  {
    if (1 != this.sessionState.get())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") runSonicFlow error:sessionState=");
      ((StringBuilder)localObject).append(this.sessionState.get());
      ((StringBuilder)localObject).append(".");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject).toString());
      return;
    }
    this.statistics.sonicFlowStartTime = System.currentTimeMillis();
    Object localObject = null;
    SonicDataHelper.SessionData localSessionData = getSessionData(paramBoolean);
    if (paramBoolean)
    {
      localObject = SonicCacheInterceptor.getSonicCacheData(this);
      this.statistics.cacheVerifyTime = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") runSonicFlow verify cache cost ");
      localStringBuilder.append(this.statistics.cacheVerifyTime - this.statistics.sonicFlowStartTime);
      localStringBuilder.append(" ms");
      SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
      handleFlow_LoadLocalCache((String)localObject);
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (paramBoolean)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    localObject = SonicEngine.getInstance().getRuntime();
    if (!((SonicRuntime)localObject).isNetworkValid())
    {
      if ((paramBoolean) && (!TextUtils.isEmpty(this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST))) {
        ((SonicRuntime)localObject).postTaskToMainThread(new SonicSession.3(this, (SonicRuntime)localObject), 1500L);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") runSonicFlow error:network is not valid!");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject).toString());
    }
    else
    {
      handleFlow_Connection(paramBoolean, localSessionData);
      this.statistics.connectionFlowFinishTime = System.currentTimeMillis();
    }
    switchState(1, 2, true);
    this.isWaitingForSessionThread.set(false);
    if (postForceDestroyIfNeed())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") runSonicFlow:send force destroy message.");
      SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  private void saveSonicCacheOnServerClose(SonicServer paramSonicServer)
  {
    boolean bool2 = isDestroyedOrWaitingForDestroy();
    boolean bool1 = false;
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") doSaveSonicCache: save session files fail. Current session is destroy (");
      ((StringBuilder)localObject).append(isDestroyedOrWaitingForDestroy());
      ((StringBuilder)localObject).append(") or refresh ( ");
      if (paramSonicServer != this.server) {
        bool1 = true;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(")");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramSonicServer.getResponseData(false);
    if (SonicUtils.shouldLog(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") onClose:htmlString size:");
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = ((String)localObject).length();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      SonicUtils.log("SonicSdk_SonicSession", 3, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = System.currentTimeMillis();
      doSaveSonicCache(paramSonicServer, (String)localObject);
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose:separate And save ache finish, cost ");
      paramSonicServer.append(System.currentTimeMillis() - l);
      paramSonicServer.append(" ms.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicServer.toString());
    }
    this.isWaitingForSaveFile.set(false);
    if (postForceDestroyIfNeed())
    {
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose: postForceDestroyIfNeed send destroy message.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicServer.toString());
    }
  }
  
  protected boolean addSessionStateChangedCallback(SonicSession.Callback paramCallback)
  {
    return this.stateChangedCallbackList.add(new WeakReference(paramCallback));
  }
  
  public boolean bindClient(SonicSessionClient paramSonicSessionClient)
  {
    if (this.sessionClient == null)
    {
      this.sessionClient = paramSonicSessionClient;
      paramSonicSessionClient.bindSession(this);
      paramSonicSessionClient = new StringBuilder();
      paramSonicSessionClient.append("session(");
      paramSonicSessionClient.append(this.sId);
      paramSonicSessionClient.append(") bind client.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicSessionClient.toString());
      return true;
    }
    return false;
  }
  
  protected boolean canDestroy()
  {
    if ((!this.isWaitingForSessionThread.get()) && (!this.isWaitingForSaveFile.get())) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("session(");
    localStringBuilder.append(this.sId);
    localStringBuilder.append(") canDestroy:false, isWaitingForSessionThread=");
    localStringBuilder.append(this.isWaitingForDestroy.get());
    localStringBuilder.append(", isWaitingForSaveFile=");
    localStringBuilder.append(this.isWaitingForSaveFile.get());
    SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
    return false;
  }
  
  protected void clearSessionData()
  {
    if (this.pendingClientCoreMessage != null) {
      this.pendingClientCoreMessage = null;
    }
  }
  
  protected Intent createConnectionIntent(SonicDataHelper.SessionData paramSessionData)
  {
    Intent localIntent = new Intent();
    Object localObject = this.id;
    boolean bool = false;
    SonicUtils.log("SonicSdk_SonicSession", 4, String.format("Session (%s) send sonic request, etag=(%s), templateTag=(%s)", new Object[] { localObject, paramSessionData.eTag, paramSessionData.templateTag }));
    localIntent.putExtra("eTag", paramSessionData.eTag);
    localIntent.putExtra("template-tag", paramSessionData.templateTag);
    localObject = SonicEngine.getInstance().getRuntime().getHostDirectAddress(this.srcUrl);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localIntent.putExtra("dns-prefetch-address", (String)localObject);
      this.statistics.isDirectAddress = true;
    }
    if (this.config.SUPPORT_SONIC_CHUNK_DATA)
    {
      long l = System.currentTimeMillis();
      localObject = SonicChunkDataHelper.getChunkDataList(paramSessionData.sessionId, paramSessionData.eTag);
      if (((List)localObject).size() > 0)
      {
        SonicChunkDataHelper.ChunkData localChunkData = (SonicChunkDataHelper.ChunkData)((List)localObject).get(0);
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append(localChunkData.toHeader());
        int i = 1;
        while (i < ((List)localObject).size())
        {
          localChunkData = (SonicChunkDataHelper.ChunkData)((List)localObject).get(i);
          localStringBuilder.append(";");
          localStringBuilder.append(localChunkData.toHeader());
          i += 1;
        }
        localIntent.putExtra("X-sonic-chunk", localStringBuilder.toString());
        SonicUtils.log("SonicSdk_SonicSession", 4, String.format("Session (%s) send sonic request with chunk hash, etag=(%s), cost=(%d)", new Object[] { this.id, paramSessionData.eTag, Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
    if (paramSessionData.isRedPointPreload == 1) {
      bool = true;
    }
    this.lastIsRedPointPreload = bool;
    this.lastDateUpdateTime = paramSessionData.templateUpdateTime;
    paramSessionData = SonicEngine.getInstance().getRuntime();
    if (!SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE)
    {
      localObject = paramSessionData.getCookie(this.srcUrl);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra("Cookie", (String)localObject);
      }
    }
    else
    {
      localIntent.putExtra("Cookie", this.intent.getStringExtra("Cookie"));
    }
    paramSessionData = paramSessionData.getUserAgent();
    if (!TextUtils.isEmpty(paramSessionData))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSessionData);
      ((StringBuilder)localObject).append(" Sonic/3.0.2");
      paramSessionData = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramSessionData = "Sonic/3.0.2";
    }
    localIntent.putExtra("User-Agent", paramSessionData);
    return localIntent;
  }
  
  public void destroy()
  {
    destroy(false);
  }
  
  protected void destroy(boolean paramBoolean)
  {
    int i = this.sessionState.get();
    if (3 != i)
    {
      if (this.sessionClient != null) {
        this.sessionClient = null;
      }
      if (this.pendingWebResourceStream != null)
      {
        try
        {
          this.pendingWebResourceStream.close();
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pendingWebResourceStream.close error:");
          localStringBuilder.append(localThrowable.getMessage());
          SonicUtils.log("SonicSdk_SonicSession", 6, localStringBuilder.toString());
        }
        this.pendingWebResourceStream = null;
      }
      if (this.pendingDiffData != null) {
        this.pendingDiffData = null;
      }
      clearSessionData();
      checkAndClearCacheData();
      if ((!paramBoolean) && (!canDestroy()))
      {
        if (this.isWaitingForDestroy.compareAndSet(false, true))
        {
          this.mainHandler.sendEmptyMessageDelayed(3, 6000L);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("session(");
          ((StringBuilder)???).append(this.sId);
          ((StringBuilder)???).append(") waiting for destroy, current state =");
          ((StringBuilder)???).append(i);
          ((StringBuilder)???).append(".");
          SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)???).toString());
        }
      }
      else
      {
        this.sessionState.set(3);
        synchronized (this.sessionState)
        {
          this.sessionState.notify();
          if ((this.server != null) && (!paramBoolean))
          {
            this.server.disconnect();
            this.server = null;
          }
          notifyStateChange(i, 3, null);
          this.mainHandler.removeMessages(3);
          this.stateChangedCallbackList.clear();
          this.isWaitingForDestroy.set(false);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("session(");
          ((StringBuilder)???).append(this.sId);
          ((StringBuilder)???).append(") final destroy, force=");
          ((StringBuilder)???).append(paramBoolean);
          ((StringBuilder)???).append(".");
          SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)???).toString());
          return;
        }
      }
    }
  }
  
  protected void doSaveSonicCache(SonicServer paramSonicServer, String paramString)
  {
    if ((!isDestroyedOrWaitingForDestroy()) && (this.server != null))
    {
      long l1 = System.currentTimeMillis();
      String str3 = paramSonicServer.getTemplate();
      String str4 = paramSonicServer.getUpdatedData();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str3)))
      {
        String str2 = paramSonicServer.getResponseHeaderField("sonic-html-sha1");
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = SonicUtils.getSHA1(paramString);
        }
        str2 = paramSonicServer.getResponseHeaderField("eTag");
        String str5 = paramSonicServer.getResponseHeaderField("template-tag");
        paramSonicServer = paramSonicServer.getResponseHeaderFields();
        if (SonicUtils.saveSessionFiles(this.id, paramString, str3, str4, paramSonicServer))
        {
          long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
          SonicUtils.saveSonicData(this.id, str2, str5, str1, l2, this.isRedPointPreload, paramSonicServer);
          if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
            SonicChunkDataHelper.saveChunkData(this.id, str2, str4);
          }
        }
        else
        {
          paramSonicServer = new StringBuilder();
          paramSonicServer.append("session(");
          paramSonicServer.append(this.sId);
          paramSonicServer.append(") doSaveSonicCache: save session files fail.");
          SonicUtils.log("SonicSdk_SonicSession", 6, paramSonicServer.toString());
          SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
        }
      }
      else
      {
        paramSonicServer = new StringBuilder();
        paramSonicServer.append("session(");
        paramSonicServer.append(this.sId);
        paramSonicServer.append(") doSaveSonicCache: save separate template and data files fail.");
        SonicUtils.log("SonicSdk_SonicSession", 6, paramSonicServer.toString());
        SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1005);
      }
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") doSaveSonicCache: finish, cost ");
      paramSonicServer.append(System.currentTimeMillis() - l1);
      paramSonicServer.append("ms.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicServer.toString());
      return;
    }
    paramSonicServer = new StringBuilder();
    paramSonicServer.append("session(");
    paramSonicServer.append(this.sId);
    paramSonicServer.append(") doSaveSonicCache: save session files fail. Current session is destroy!");
    SonicUtils.log("SonicSdk_SonicSession", 6, paramSonicServer.toString());
  }
  
  protected HashMap<String, String> getCacheHeaders()
  {
    return SonicUtils.getFilteredHeaders(SonicFileUtils.getHeaderFromLocalCache(SonicFileUtils.getSonicHeaderPath(this.id)));
  }
  
  protected String getCharsetFromHeaders()
  {
    return getCharsetFromHeaders(getHeaders());
  }
  
  public String getCharsetFromHeaders(Map<String, String> paramMap)
  {
    String str2 = SonicUtils.DEFAULT_CHARSET;
    String str3 = "Content-Type".toLowerCase();
    String str1 = str2;
    if (paramMap != null)
    {
      str1 = str2;
      if (paramMap.containsKey(str3))
      {
        paramMap = (String)paramMap.get(str3);
        str1 = str2;
        if (!TextUtils.isEmpty(paramMap)) {
          str1 = SonicUtils.getCharset(paramMap);
        }
      }
    }
    return str1;
  }
  
  public String getCurrentUrl()
  {
    return this.srcUrl;
  }
  
  public int getFinalResultCode()
  {
    return this.finalResultCode;
  }
  
  protected HashMap<String, String> getHeaders()
  {
    if (this.server != null) {
      return SonicUtils.getFilteredHeaders(this.server.getResponseHeaderFields());
    }
    return null;
  }
  
  public SonicSessionClient getSessionClient()
  {
    return this.sessionClient;
  }
  
  public int getSrcResultCode()
  {
    return this.srcResultCode;
  }
  
  public SonicSessionStatistics getStatistics()
  {
    return this.statistics;
  }
  
  protected void handleFlow_Connection(boolean paramBoolean, SonicDataHelper.SessionData paramSessionData)
  {
    this.statistics.connectionFlowStartTime = System.currentTimeMillis();
    if ((this.config.SUPPORT_CACHE_CONTROL) && (this.statistics.connectionFlowStartTime < paramSessionData.expiredTime))
    {
      if (SonicUtils.shouldLog(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("session(");
        ((StringBuilder)localObject).append(this.sId);
        ((StringBuilder)localObject).append(") won't send any request in ");
        ((StringBuilder)localObject).append(paramSessionData.expiredTime - this.statistics.connectionFlowStartTime);
        ((StringBuilder)localObject).append(".ms");
        SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.server = new SonicServer(this, createConnectionIntent(paramSessionData));
    int j = this.server.connect();
    int i = j;
    long l1;
    if (j == 0)
    {
      j = this.server.getResponseCode();
      l1 = System.currentTimeMillis();
      paramSessionData = this.server.getResponseHeaderFields();
      if (SonicUtils.shouldLog(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("session(");
        ((StringBuilder)localObject).append(this.sId);
        ((StringBuilder)localObject).append(") connection get header fields cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject).append(" ms.");
        SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject).toString());
      }
      l1 = System.currentTimeMillis();
      setCookiesFromHeaders(paramSessionData, shouldSetCookieAsynchronous());
      i = j;
      if (SonicUtils.shouldLog(3))
      {
        paramSessionData = new StringBuilder();
        paramSessionData.append("session(");
        paramSessionData.append(this.sId);
        paramSessionData.append(") connection set cookies cost = ");
        paramSessionData.append(System.currentTimeMillis() - l1);
        paramSessionData.append(" ms.");
        SonicUtils.log("SonicSdk_SonicSession", 3, paramSessionData.toString());
        i = j;
      }
    }
    paramSessionData = new StringBuilder();
    paramSessionData.append("session(");
    paramSessionData.append(this.sId);
    paramSessionData.append(") handleFlow_Connection: respCode = ");
    paramSessionData.append(i);
    paramSessionData.append(", cost ");
    paramSessionData.append(System.currentTimeMillis() - this.statistics.connectionFlowStartTime);
    paramSessionData.append(" ms.");
    SonicUtils.log("SonicSdk_SonicSession", 4, paramSessionData.toString());
    if (isDestroyedOrWaitingForDestroy())
    {
      paramSessionData = new StringBuilder();
      paramSessionData.append("session(");
      paramSessionData.append(this.sId);
      paramSessionData.append(") handleFlow_Connection error: destroy before server response!");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramSessionData.toString());
      return;
    }
    if (304 == i)
    {
      paramSessionData = new StringBuilder();
      paramSessionData.append("session(");
      paramSessionData.append(this.sId);
      paramSessionData.append(") handleFlow_Connection: Server response is not modified.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSessionData.toString());
      handleFlow_NotModified();
      return;
    }
    if (200 != i)
    {
      handleFlow_HttpError(i);
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, i);
      paramSessionData = new StringBuilder();
      paramSessionData.append("session(");
      paramSessionData.append(this.sId);
      paramSessionData.append(") handleFlow_Connection error: response code(");
      paramSessionData.append(i);
      paramSessionData.append(") is not OK!");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramSessionData.toString());
      return;
    }
    paramSessionData = this.server.getResponseHeaderField("cache-offline");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("session(");
    ((StringBuilder)localObject).append(this.sId);
    ((StringBuilder)localObject).append(") handleFlow_Connection: cacheOffline is ");
    ((StringBuilder)localObject).append(paramSessionData);
    ((StringBuilder)localObject).append(".");
    SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject).toString());
    if ("http".equalsIgnoreCase(paramSessionData))
    {
      if (paramBoolean) {
        handleFlow_ServiceUnavailable();
      }
      l1 = System.currentTimeMillis();
      long l2 = SonicEngine.getInstance().getConfig().SONIC_UNAVAILABLE_TIME;
      SonicDataHelper.setSonicUnavailableTime(this.id, l1 + l2);
      return;
    }
    if (!paramBoolean)
    {
      handleFlow_FirstLoad();
      return;
    }
    if ((!TextUtils.isEmpty(paramSessionData)) && (!"false".equalsIgnoreCase(paramSessionData)))
    {
      paramSessionData = this.server.getResponseHeaderField("eTag");
      localObject = this.server.getResponseHeaderField("template-change");
      if ((!TextUtils.isEmpty(paramSessionData)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!"false".equals(localObject)) && (!"0".equals(localObject)))
        {
          handleFlow_TemplateChange(this.server.getResponseData(this.clientIsReload.get()));
          return;
        }
        handleFlow_DataUpdate(this.server.getUpdatedData());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") handleFlow_Connection error: eTag is ( ");
      localStringBuilder.append(paramSessionData);
      localStringBuilder.append(" ) , templateChange is ( ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" )!");
      SonicUtils.log("SonicSdk_SonicSession", 6, localStringBuilder.toString());
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    paramSessionData = new StringBuilder();
    paramSessionData.append("session(");
    paramSessionData.append(this.sId);
    paramSessionData.append(") handleFlow_Connection error: Cache-Offline is empty or false!");
    SonicUtils.log("SonicSdk_SonicSession", 6, paramSessionData.toString());
    SonicUtils.removeSessionCache(this.id);
  }
  
  protected void handleFlow_DataUpdate(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("session(");
    ((StringBuilder)localObject1).append(this.sId);
    ((StringBuilder)localObject1).append(") handleFlow_DataUpdate: start.");
    SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
    for (;;)
    {
      Object localObject2;
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = this.server.getResponseData(true);
          paramString = null;
        }
        else
        {
          localObject2 = this.server.getResponseData(false);
          localObject1 = paramString;
          paramString = (String)localObject2;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          SonicUtils.log("SonicSdk_SonicSession", 6, "handleFlow_DataUpdate:getResponseData error.");
          return;
        }
        String str1 = this.server.getResponseHeaderField("eTag");
        String str2 = this.server.getResponseHeaderField("template-tag");
        String str3 = this.server.getResponseHeaderField("cache-offline");
        long l1 = System.currentTimeMillis();
        localObject2 = new JSONObject((String)localObject1);
        JSONObject localJSONObject1 = ((JSONObject)localObject2).optJSONObject("data");
        String str4 = ((JSONObject)localObject2).optString("html-sha1");
        JSONObject localJSONObject2 = SonicUtils.getDiffData(this.id, localJSONObject1);
        localObject2 = new Bundle();
        Object localObject3;
        SonicSessionClient localSonicSessionClient;
        if (localJSONObject2 != null)
        {
          ((Bundle)localObject2).putString("_diff_data_", localJSONObject2.toString());
        }
        else
        {
          SonicUtils.log("SonicSdk_SonicSession", 6, "handleFlow_DataUpdate:getDiffData error.");
          localObject3 = SonicEngine.getInstance().getRuntime();
          localSonicSessionClient = this.sessionClient;
        }
        try
        {
          ((SonicRuntime)localObject3).notifyError(localSonicSessionClient, this.srcUrl, -1006);
          boolean bool = SonicUtils.shouldLog(3);
          if (bool)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleFlow_DataUpdate:getDiffData cost ");
            ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
            ((StringBuilder)localObject3).append(" ms.");
            SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject3).toString());
          }
          if (!this.wasLoadDataInvoked.get()) {
            break label936;
          }
          if (SonicUtils.shouldLog(4)) {
            SonicUtils.log("SonicSdk_SonicSession", 4, "handleFlow_DataUpdate:loadData was invoked, quick notify web data update.");
          }
          localObject3 = this.mainHandler.obtainMessage(7);
          if (!"store".equals(str3)) {
            ((Message)localObject3).setData((Bundle)localObject2);
          }
          this.mainHandler.sendMessage((Message)localObject3);
          i = 1;
          l1 = System.currentTimeMillis();
          localObject2 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            localObject2 = SonicUtils.buildHtml(this.id, localJSONObject1, str4, ((String)localObject1).length(), this.config.SUPPORT_SONIC_CHUNK_DATA);
          }
          if (SonicUtils.shouldLog(3))
          {
            paramString = new StringBuilder();
            paramString.append("handleFlow_DataUpdate:buildHtml cost ");
            paramString.append(System.currentTimeMillis() - l1);
            paramString.append(" ms.");
            SonicUtils.log("SonicSdk_SonicSession", 3, paramString.toString());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1008);
          }
          if (i == 0)
          {
            this.mainHandler.removeMessages(5);
            paramString = this.mainHandler.obtainMessage(7);
            paramString.obj = localObject2;
            this.mainHandler.sendMessage(paramString);
          }
          if ((localJSONObject2 != null) && (localObject2 != null) && (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, str3, this.server.getResponseHeaderFields())))
          {
            switchState(1, 2, true);
            Thread.yield();
            l1 = System.currentTimeMillis();
            paramString = this.server.getResponseHeaderFields();
            if (SonicUtils.saveSessionFiles(this.id, (String)localObject2, null, localJSONObject1.toString(), paramString))
            {
              long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
              SonicUtils.saveSonicData(this.id, str1, str2, str4, l2, false, paramString);
              if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
                SonicChunkDataHelper.saveChunkData(this.id, str1, localJSONObject1.toString());
              }
              paramString = new StringBuilder();
            }
          }
          try
          {
            paramString.append("session(");
            paramString.append(this.sId);
            paramString.append(") handleFlow_DataUpdate: finish save session cache, cost ");
            paramString.append(System.currentTimeMillis() - l1);
            paramString.append(" ms.");
            SonicUtils.log("SonicSdk_SonicSession", 4, paramString.toString());
            return;
          }
          catch (Throwable paramString)
          {
            localObject1 = "session(";
            paramString = paramString;
          }
          paramString = new StringBuilder();
          paramString.append("session(");
          paramString.append(this.sId);
          paramString.append(") handleFlow_DataUpdate: save session files fail.");
          SonicUtils.log("SonicSdk_SonicSession", 6, paramString.toString());
          SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
          return;
          paramString = new StringBuilder();
          paramString.append("session(");
          paramString.append(this.sId);
          paramString.append(") handleFlow_DataUpdate: clean session cache.");
          SonicUtils.log("SonicSdk_SonicSession", 4, paramString.toString());
          SonicUtils.removeSessionCache(this.id);
          return;
        }
        catch (Throwable paramString)
        {
          localObject1 = "session(";
        }
        localObject2 = new StringBuilder();
      }
      catch (Throwable paramString)
      {
        localObject1 = "session(";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.sId);
      ((StringBuilder)localObject2).append(") handleFlow_DataUpdate error:");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject2).toString());
      return;
      label936:
      int i = 0;
    }
  }
  
  protected void handleFlow_FirstLoad()
  {
    this.pendingWebResourceStream = this.server.getResponseStream(this.wasInterceptInvoked);
    if (this.pendingWebResourceStream == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(") handleFlow_FirstLoad error:server.getResponseStream is null!");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = this.server.getResponseData(false);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("session(");
    ((StringBuilder)localObject2).append(this.sId);
    ((StringBuilder)localObject2).append(") handleFlow_FirstLoad:hasCompletionData=");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append(".");
    SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject2).toString());
    this.mainHandler.removeMessages(5);
    localObject2 = this.mainHandler.obtainMessage(6);
    ((Message)localObject2).obj = localObject1;
    int i;
    if (bool) {
      i = 2;
    } else {
      i = 1;
    }
    ((Message)localObject2).arg1 = i;
    this.mainHandler.sendMessage((Message)localObject2);
    localObject2 = this.server.getResponseHeaderField("cache-offline");
    if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject2, this.server.getResponseHeaderFields()))
    {
      if ((bool) && (!this.wasLoadUrlInvoked.get()) && (!this.wasInterceptInvoked.get()))
      {
        switchState(1, 2, true);
        postTaskToSaveSonicCache((String)localObject1);
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(") handleFlow_FirstLoad:offline->");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" , so do not need cache to file.");
      SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void handleFlow_HttpError(int paramInt)
  {
    if (this.config.RELOAD_IN_BAD_NETWORK)
    {
      this.mainHandler.removeMessages(5);
      Message localMessage = this.mainHandler.obtainMessage(9);
      localMessage.arg1 = paramInt;
      this.mainHandler.sendMessage(localMessage);
    }
  }
  
  protected void handleFlow_LoadLocalCache(String paramString)
  {
    Message localMessage = this.mainHandler.obtainMessage(5);
    if (!TextUtils.isEmpty(paramString))
    {
      localMessage.arg1 = 2;
      localMessage.obj = paramString;
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("session(");
      paramString.append(this.sId);
      paramString.append(") runSonicFlow has no cache, do first load flow.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramString.toString());
      localMessage.arg1 = 1;
    }
    this.mainHandler.sendMessage(localMessage);
  }
  
  protected void handleFlow_NotModified()
  {
    Message localMessage = this.mainHandler.obtainMessage(1);
    localMessage.arg1 = 304;
    localMessage.arg2 = 304;
    this.mainHandler.sendMessage(localMessage);
  }
  
  protected void handleFlow_ServiceUnavailable()
  {
    this.mainHandler.removeMessages(5);
    Message localMessage = this.mainHandler.obtainMessage(10);
    this.mainHandler.sendMessage(localMessage);
  }
  
  protected void handleFlow_TemplateChange(String paramString)
  {
    try
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleFlow_TemplateChange.");
      long l = System.currentTimeMillis();
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        this.pendingWebResourceStream = this.server.getResponseStream(this.wasOnPageFinishInvoked);
        if (this.pendingWebResourceStream == null)
        {
          paramString = new StringBuilder();
          paramString.append("session(");
          paramString.append(this.sId);
          paramString.append(") handleFlow_TemplateChange error:server.getResponseStream = null!");
          SonicUtils.log("SonicSdk_SonicSession", 6, paramString.toString());
          return;
        }
        localObject1 = this.server.getResponseData(this.clientIsReload.get());
      }
      paramString = this.server.getResponseHeaderField("cache-offline");
      Object localObject2;
      if (!this.clientIsReload.get())
      {
        this.mainHandler.removeMessages(5);
        localObject2 = this.mainHandler.obtainMessage(8);
        ((Message)localObject2).obj = localObject1;
        if (!"store".equals(paramString)) {
          ((Message)localObject2).arg1 = 1;
        }
        this.mainHandler.sendMessage((Message)localObject2);
      }
      else
      {
        localObject2 = this.mainHandler.obtainMessage(1);
        ((Message)localObject2).arg1 = 2000;
        ((Message)localObject2).arg2 = 2000;
        this.mainHandler.sendMessage((Message)localObject2);
      }
      if (SonicUtils.shouldLog(3))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("session(");
        ((StringBuilder)localObject2).append(this.sId);
        ((StringBuilder)localObject2).append(") read byte stream cost ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject2).append(" ms, wasInterceptInvoked: ");
        ((StringBuilder)localObject2).append(this.wasInterceptInvoked.get());
        SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject2).toString());
      }
      if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, paramString, this.server.getResponseHeaderFields()))
      {
        switchState(1, 2, true);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          postTaskToSaveSonicCache((String)localObject1);
        }
      }
      else
      {
        if ("false".equals(paramString))
        {
          SonicUtils.removeSessionCache(this.id);
          SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:offline mode is 'false', so clean cache.");
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(this.sId);
        ((StringBuilder)localObject1).append(") handleFlow_TemplateChange:offline->");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" , so do not need cache to file.");
        SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(") handleFlow_TemplateChange error:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (3 == paramMessage.what)
    {
      destroy(true);
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") handleMessage:force destroy.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramMessage.toString());
      return true;
    }
    if (isDestroyedOrWaitingForDestroy())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("session(");
      paramMessage.append(this.sId);
      paramMessage.append(") handleMessage error: is destroyed or waiting for destroy.");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramMessage.toString());
      return true;
    }
    StringBuilder localStringBuilder;
    if (SonicUtils.shouldLog(3))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") handleMessage: msg what = ");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 3, localStringBuilder.toString());
    }
    if ((4 < paramMessage.what) && (paramMessage.what < 11) && (!this.clientIsReady.get()))
    {
      this.pendingClientCoreMessage = Message.obtain(paramMessage);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") handleMessage: client not ready, core msg = ");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
      return true;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        switch (i)
        {
        default: 
          if (SonicUtils.shouldLog(3))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("session(");
            localStringBuilder.append(this.sId);
            localStringBuilder.append(") can not  recognize refresh type: ");
            localStringBuilder.append(paramMessage.what);
            SonicUtils.log("SonicSdk_SonicSession", 3, localStringBuilder.toString());
          }
          return false;
        case 10: 
          handleClientCoreMessage_ServiceUnavailable(paramMessage);
          return true;
        case 9: 
          handleClientCoreMessage_ConnectionError(paramMessage);
          return true;
        case 8: 
          handleClientCoreMessage_TemplateChange(paramMessage);
          return true;
        case 7: 
          handleClientCoreMessage_DataUpdate(paramMessage);
          return true;
        case 6: 
          handleClientCoreMessage_FirstLoad(paramMessage);
          return true;
        }
        handleClientCoreMessage_PreLoad(paramMessage);
        return true;
      }
      this.diffDataCallback = ((SonicDiffDataCallback)paramMessage.obj);
      setResult(this.srcResultCode, this.finalResultCode, true);
      return true;
    }
    setResult(paramMessage.arg1, paramMessage.arg2, true);
    return true;
  }
  
  public boolean isDestroyedOrWaitingForDestroy()
  {
    return (3 == this.sessionState.get()) || (this.isWaitingForDestroy.get());
  }
  
  public boolean isMatchCurrentUrl(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.srcUrl);
      paramString = Uri.parse(paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getHost());
      ((StringBuilder)localObject1).append(localUri.getPath());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString.getHost());
      ((StringBuilder)localObject2).append(paramString.getPath());
      localObject2 = ((StringBuilder)localObject2).toString();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).endsWith("/"))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append("/");
          paramString = paramString.toString();
        }
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("/");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject1);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isMatchCurrentUrl error:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public boolean isPreload()
  {
    return this.isPreload;
  }
  
  protected void notifyStateChange(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Iterator localIterator = this.stateChangedCallbackList.iterator();
    while (localIterator.hasNext())
    {
      SonicSession.Callback localCallback = (SonicSession.Callback)((WeakReference)localIterator.next()).get();
      if (localCallback != null) {
        localCallback.onSessionStateChange(this, paramInt1, paramInt2, paramBundle);
      }
    }
  }
  
  public boolean onClientPageFinished(String paramString)
  {
    if (isMatchCurrentUrl(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") onClientPageFinished:url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
      this.wasOnPageFinishInvoked.set(true);
      return true;
    }
    return false;
  }
  
  public boolean onClientReady()
  {
    Object localObject = this.clientIsReady;
    boolean bool = false;
    if (((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") onClientReady: have pending client core message ? -> ");
      if (this.pendingClientCoreMessage != null) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject).toString());
      localObject = this.pendingClientCoreMessage;
      if (localObject != null)
      {
        this.pendingClientCoreMessage = null;
        handleMessage((Message)localObject);
        return true;
      }
      if (this.sessionState.get() == 0) {
        start();
      }
      return true;
    }
    return false;
  }
  
  public final Object onClientRequestResource(String paramString)
  {
    if ("Chrome_FileThread".equals(Thread.currentThread().getName())) {
      this.resourceInterceptState.set(1);
    } else {
      this.resourceInterceptState.set(2);
    }
    if (isMatchCurrentUrl(paramString)) {
      paramString = onRequestResource(paramString);
    } else {
      paramString = null;
    }
    this.resourceInterceptState.set(0);
    return paramString;
  }
  
  protected Object onRequestResource(String arg1)
  {
    if (!this.wasInterceptInvoked.get())
    {
      if (!isMatchCurrentUrl(???)) {
        return null;
      }
      Object localObject1 = this.wasInterceptInvoked;
      boolean bool = false;
      if (!((AtomicBoolean)localObject1).compareAndSet(false, true))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(this.sId);
        ((StringBuilder)localObject1).append(")  onClientRequestResource error:Intercept was already invoked, url = ");
        ((StringBuilder)localObject1).append(???);
        SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
        return null;
      }
      if (SonicUtils.shouldLog(3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(this.sId);
        ((StringBuilder)localObject1).append(")  onClientRequestResource:url = ");
        ((StringBuilder)localObject1).append(???);
        SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject1).toString());
      }
      long l = System.currentTimeMillis();
      if (this.sessionState.get() == 1)
      {
        try
        {
          synchronized (this.sessionState)
          {
            if (this.sessionState.get() == 1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("session(");
              ((StringBuilder)localObject1).append(this.sId);
              ((StringBuilder)localObject1).append(") now wait for pendingWebResourceStream!");
              SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
              this.sessionState.wait(30000L);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("session(");
          localStringBuilder.append(this.sId);
          localStringBuilder.append(") wait for pendingWebResourceStream failed");
          localStringBuilder.append(localThrowable.getMessage());
          SonicUtils.log("SonicSdk_SonicSession", 6, localStringBuilder.toString());
        }
        throw localThrowable;
      }
      else if (SonicUtils.shouldLog(3))
      {
        ??? = new StringBuilder();
        ???.append("session(");
        ???.append(this.sId);
        ???.append(") is not in running state: ");
        ???.append(this.sessionState);
        SonicUtils.log("SonicSdk_SonicSession", 3, ???.toString());
      }
      ??? = new StringBuilder();
      ???.append("session(");
      ???.append(this.sId);
      ???.append(") have pending stream? -> ");
      if (this.pendingWebResourceStream != null) {
        bool = true;
      }
      ???.append(bool);
      ???.append(", cost ");
      ???.append(System.currentTimeMillis() - l);
      ???.append("ms.");
      SonicUtils.log("SonicSdk_SonicSession", 4, ???.toString());
      if (this.pendingWebResourceStream != null)
      {
        if (!isDestroyedOrWaitingForDestroy())
        {
          ??? = SonicUtils.getMime(this.srcUrl);
          ??? = SonicEngine.getInstance().getRuntime().createWebResourceResponse(???, getCharsetFromHeaders(), this.pendingWebResourceStream, getHeaders());
        }
        else
        {
          ??? = new StringBuilder();
          ???.append("session(");
          ???.append(this.sId);
          ???.append(") onClientRequestResource error: session is destroyed!");
          SonicUtils.log("SonicSdk_SonicSession", 6, ???.toString());
          ??? = null;
        }
        this.pendingWebResourceStream = null;
        return ???;
      }
    }
    return null;
  }
  
  public void onServerClosed(SonicServer paramSonicServer, boolean paramBoolean)
  {
    if (isDestroyedOrWaitingForDestroy()) {
      return;
    }
    if (this.pendingWebResourceStream != null) {
      this.pendingWebResourceStream = null;
    }
    this.isWaitingForSaveFile.set(true);
    long l = System.currentTimeMillis();
    if (paramBoolean)
    {
      Object localObject = paramSonicServer.getResponseHeaderField("cache-offline");
      if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject, paramSonicServer.getResponseHeaderFields()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("session(");
        localStringBuilder.append(this.sId);
        localStringBuilder.append(") onClose:offline->");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" , post separateAndSaveCache task.");
        SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramSonicServer;
        this.fileHandler.sendMessageDelayed((Message)localObject, 1500L);
        return;
      }
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose:offline->");
      paramSonicServer.append((String)localObject);
      paramSonicServer.append(" , so do not need cache to file.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicServer.toString());
    }
    else
    {
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose error:readComplete = false!");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramSonicServer.toString());
    }
    this.isWaitingForSaveFile.set(false);
    if (postForceDestroyIfNeed())
    {
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      SonicUtils.log("SonicSdk_SonicSession", 4, paramSonicServer.toString());
    }
    if (SonicUtils.shouldLog(3))
    {
      paramSonicServer = new StringBuilder();
      paramSonicServer.append("session(");
      paramSonicServer.append(this.sId);
      paramSonicServer.append(") onClose cost ");
      paramSonicServer.append(System.currentTimeMillis() - l);
      paramSonicServer.append(" ms.");
      SonicUtils.log("SonicSdk_SonicSession", 6, paramSonicServer.toString());
    }
  }
  
  public boolean onWebReady(SonicDiffDataCallback paramSonicDiffDataCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("session(");
    ((StringBuilder)localObject).append(this.sId);
    ((StringBuilder)localObject).append(") onWebReady: webCallback has set ? ->");
    boolean bool;
    if (this.diffDataCallback != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject).toString());
    if (this.diffDataCallback != null)
    {
      this.diffDataCallback = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") onWebReady: call more than once.");
      SonicUtils.log("SonicSdk_SonicSession", 5, ((StringBuilder)localObject).toString());
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 2;
    ((Message)localObject).obj = paramSonicDiffDataCallback;
    this.mainHandler.sendMessage((Message)localObject);
    return true;
  }
  
  protected boolean postForceDestroyIfNeed()
  {
    if ((this.isWaitingForDestroy.get()) && (canDestroy()))
    {
      this.mainHandler.sendEmptyMessage(3);
      return true;
    }
    return false;
  }
  
  protected void postTaskToSaveSonicCache(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramString;
    this.fileHandler.sendMessageDelayed(localMessage, 1500L);
  }
  
  public boolean refresh()
  {
    if (!this.sessionState.compareAndSet(2, 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") refresh error:sessionState=");
      localStringBuilder.append(this.sessionState.get());
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 6, localStringBuilder.toString());
      return false;
    }
    this.wasInterceptInvoked.set(false);
    this.clientIsReload.set(true);
    this.finalResultCode = -1;
    this.srcResultCode = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("session(");
    localStringBuilder.append(this.sId);
    localStringBuilder.append(") now refresh sonic flow task.");
    SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
    this.statistics.sonicStartTime = System.currentTimeMillis();
    this.isWaitingForSessionThread.set(true);
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new SonicSession.4(this));
    notifyStateChange(2, 1, null);
    return true;
  }
  
  protected boolean removeSessionStateChangedCallback(SonicSession.Callback paramCallback)
  {
    return this.stateChangedCallbackList.remove(new WeakReference(paramCallback));
  }
  
  protected boolean setCookiesFromHeaders(Map<String, List<String>> paramMap, boolean paramBoolean)
  {
    if (paramMap != null)
    {
      paramMap = (List)paramMap.get("Set-Cookie".toLowerCase());
      if ((paramMap != null) && (paramMap.size() != 0))
      {
        if (!paramBoolean) {
          return SonicEngine.getInstance().getRuntime().setCookie(getCurrentUrl(), paramMap);
        }
        SonicUtils.log("SonicSdk_SonicSession", 4, "setCookiesFromHeaders asynchronous in new thread.");
        SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicSession.6(this, paramMap), 0L);
        return true;
      }
    }
    return false;
  }
  
  void setIsPreload(String paramString)
  {
    this.isPreload = true;
    Object localObject = this.statistics;
    String str = paramString.trim();
    ((SonicSessionStatistics)localObject).srcUrl = str;
    this.srcUrl = str;
    if (SonicUtils.shouldLog(4))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.sId);
      ((StringBuilder)localObject).append(") is preload, new url=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".");
      SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void setResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("session(");
    ((StringBuilder)localObject1).append(this.sId);
    ((StringBuilder)localObject1).append(")  setResult: srcCode=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", finalCode=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(".");
    SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
    localObject1 = this.statistics;
    this.srcResultCode = paramInt1;
    ((SonicSessionStatistics)localObject1).originalMode = paramInt1;
    this.finalResultCode = paramInt2;
    ((SonicSessionStatistics)localObject1).finalMode = paramInt2;
    if (!paramBoolean) {
      return;
    }
    if (this.wasNotified.get())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(")  setResult: notify error -> already has notified!");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
    }
    if (this.diffDataCallback == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(")  setResult: notify fail as webCallback is not set, please wait!");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
      return;
    }
    if (this.finalResultCode == -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(")  setResult: notify fail finalResultCode is not set, please wait!");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
      return;
    }
    this.wasNotified.compareAndSet(false, true);
    JSONObject localJSONObject = new JSONObject();
    long l1;
    long l2;
    double d;
    Object localObject3;
    try
    {
      if (this.finalResultCode != 200) {
        break label1119;
      }
      localObject1 = new JSONObject(this.pendingDiffData);
      paramBoolean = ((JSONObject)localObject1).has("local_refresh_time");
      if (!paramBoolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(this.sId);
        ((StringBuilder)localObject1).append(") setResult: no any updated data. ");
        ((StringBuilder)localObject1).append(this.pendingDiffData);
        SonicUtils.log("SonicSdk_SonicSession", 4, ((StringBuilder)localObject1).toString());
        this.pendingDiffData = "";
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = ((JSONObject)localObject1).optLong("local_refresh_time", 0L);
      l1 -= l2;
      if (l1 <= 30000L) {}
    }
    catch (Throwable localThrowable2) {}
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("session(");
      ((StringBuilder)localObject1).append(this.sId);
      ((StringBuilder)localObject1).append(") setResult: notify fail as receive js call too late, ");
      d = l1;
      Double.isNaN(d);
      d /= 1000.0D;
      ((StringBuilder)localObject1).append(d);
      ((StringBuilder)localObject1).append(" s.");
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject1).toString());
      this.pendingDiffData = "";
      return;
    }
    catch (Throwable localThrowable3)
    {
      label848:
      break label848;
    }
    if (SonicUtils.shouldLog(3))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("session(");
      ((StringBuilder)localObject3).append(this.sId);
      ((StringBuilder)localObject3).append(") setResult: notify receive js call in time: ");
      d = l1;
      Double.isNaN(d);
      d /= 1000.0D;
      ((StringBuilder)localObject3).append(d);
      ((StringBuilder)localObject3).append(" s.");
      SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject3).toString());
    }
    if (l1 > 0L) {}
    label1119:
    for (;;)
    {
      try
      {
        localJSONObject.put("local_refresh_time", l1);
        ((JSONObject)localObject1).remove("local_refresh_time");
        localJSONObject.put("result", ((JSONObject)localObject1).toString());
        localObject1 = localJSONObject;
        if (this.isRedPointPreload) {
          this.lastIsRedPointPreload = true;
        } else if (System.currentTimeMillis() - this.lastDateUpdateTime > 86400000L) {
          this.lastIsRedPointPreload = false;
        }
        ((JSONObject)localObject1).put("isPreload", this.lastIsRedPointPreload);
        ((JSONObject)localObject1).put("code", this.finalResultCode);
        ((JSONObject)localObject1).put("srcCode", this.srcResultCode);
        localObject3 = new JSONObject();
        if (this.server != null)
        {
          ((JSONObject)localObject3).put("eTag", this.server.getResponseHeaderField("eTag"));
          ((JSONObject)localObject3).put("template-tag", this.server.getResponseHeaderField("template-tag"));
          ((JSONObject)localObject3).put("cache-offline", this.server.getResponseHeaderField("cache-offline"));
        }
        ((JSONObject)localObject3).put("isReload", this.clientIsReload);
        ((JSONObject)localObject1).put("extra", localObject3);
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("session(");
      ((StringBuilder)localObject3).append(this.sId);
      ((StringBuilder)localObject3).append(") setResult: notify error -> ");
      ((StringBuilder)localObject3).append(localThrowable2.getMessage());
      SonicUtils.log("SonicSdk_SonicSession", 6, ((StringBuilder)localObject3).toString());
      if (SonicUtils.shouldLog(3))
      {
        localObject3 = localJSONObject.toString();
        Object localObject2 = localObject3;
        if (((String)localObject3).length() > 512) {
          localObject2 = ((String)localObject3).substring(0, 512);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("session(");
        ((StringBuilder)localObject3).append(this.sId);
        ((StringBuilder)localObject3).append(") setResult: notify now call jsCallback, jsonStr = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        SonicUtils.log("SonicSdk_SonicSession", 3, ((StringBuilder)localObject3).toString());
      }
      this.pendingDiffData = null;
      if (this.clientIsReload.get())
      {
        l2 = System.currentTimeMillis() - this.statistics.diffDataCallbackTime;
        l1 = l2;
        if (l2 < 2000L) {}
      }
      else
      {
        l1 = 0L;
      }
      if (l1 > 0L)
      {
        SonicEngine.getInstance().getRuntime().postTaskToMainThread(new SonicSession.5(this, localJSONObject), 2000L - l1);
        return;
      }
      this.diffDataCallback.callback(localJSONObject.toString());
      this.statistics.diffDataCallbackTime = System.currentTimeMillis();
      return;
    }
  }
  
  protected boolean shouldSetCookieAsynchronous()
  {
    return 2 == this.resourceInterceptState.get();
  }
  
  public void start()
  {
    if (!this.sessionState.compareAndSet(0, 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.sId);
      localStringBuilder.append(") start error:sessionState=");
      localStringBuilder.append(this.sessionState.get());
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicSession", 3, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("session(");
    localStringBuilder.append(this.sId);
    localStringBuilder.append(") now post sonic flow task.");
    SonicUtils.log("SonicSdk_SonicSession", 4, localStringBuilder.toString());
    this.statistics.sonicStartTime = System.currentTimeMillis();
    this.isWaitingForSessionThread.set(true);
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new SonicSession.2(this));
    notifyStateChange(0, 1, null);
  }
  
  protected boolean switchState(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.sessionState.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {
        synchronized (this.sessionState)
        {
          this.sessionState.notify();
        }
      }
      notifyStateChange(paramInt1, paramInt2, null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession
 * JD-Core Version:    0.7.0.1
 */