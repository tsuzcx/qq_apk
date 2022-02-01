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
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") create:id=" + paramString1 + ", url = " + paramString2 + ".");
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
      SonicDataHelper.SessionData localSessionData = new SonicDataHelper.SessionData();
      localSessionData.eTag = this.server.getResponseHeaderField("eTag");
      localSessionData.templateTag = this.server.getResponseHeaderField("template-tag");
      if (((TextUtils.isEmpty(localSessionData.eTag)) || (TextUtils.isEmpty(localSessionData.templateTag))) && (this.config.SUPPORT_LOCAL_SERVER))
      {
        this.server.separateTemplateAndData();
        localSessionData.eTag = this.server.getResponseHeaderField("eTag");
        localSessionData.templateTag = this.server.getResponseHeaderField("template-tag");
      }
      localSessionData.sessionId = this.id;
      return localSessionData;
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:server is not valid!");
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
    boolean bool = true;
    String str = (String)paramMessage.obj;
    paramMessage = paramMessage.getData().getString("_diff_data_");
    if (this.wasLoadDataInvoked.get())
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
      paramMessage = new StringBuilder().append("handleClientCoreMessage_DataUpdate:oh yeah data update hit 304, now clear pending data ->");
      if (this.pendingDiffData != null) {}
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, bool + ".");
        this.pendingDiffData = null;
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, str, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        setResult(200, 304, false);
        return;
        bool = false;
      }
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "handleClientCoreMessage_DataUpdate error:call load url.");
    this.sessionClient.loadUrl(this.srcUrl, null);
    setResult(200, 1000, false);
  }
  
  private void handleClientCoreMessage_FirstLoad(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 1: 
      if (this.wasInterceptInvoked.get())
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_DATA.");
        setResult(1000, 1000, true);
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
      return;
    }
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:oh yeah, first load hit 304.");
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, (String)paramMessage.obj, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
      setResult(1000, 304, false);
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") FIRST_LOAD_WITH_DATA load url was invoked.");
    setResult(1000, 1000, true);
  }
  
  private void handleClientCoreMessage_PreLoad(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 1: 
      if (this.wasLoadUrlInvoked.compareAndSet(false, true))
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "1");
        this.sessionClient.loadUrl(this.currUrl, null);
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
      return;
    }
    if (this.wasLoadDataInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
      paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), null);
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", SonicUtils.DEFAULT_CHARSET, this.srcUrl, getCacheHeaders());
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
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
    SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange wasLoadDataInvoked = " + this.wasLoadDataInvoked.get() + ",msg arg1 = " + paramMessage.arg1);
    boolean bool;
    if (this.wasLoadDataInvoked.get()) {
      if (1 == paramMessage.arg1) {
        if (TextUtils.isEmpty((String)paramMessage.obj))
        {
          paramMessage = new StringBuilder().append("handleClientCoreMessage_TemplateChange:load url with preload=2, webCallback is null? ->");
          if (this.diffDataCallback != null)
          {
            bool = true;
            SonicUtils.log("SonicSdk_SonicSession", 4, bool);
            this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "2");
            this.sessionClient.loadUrl(this.currUrl, null);
            label141:
            setResult(2000, 2000, false);
          }
        }
      }
    }
    for (;;)
    {
      this.diffDataCallback = null;
      this.mainHandler.removeMessages(2);
      return;
      bool = false;
      break;
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:load data.");
      paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()));
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
      break label141;
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:not refresh.");
      setResult(2000, 304, true);
      continue;
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
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:sessionState=" + this.sessionState.get() + ".");
      return;
    }
    this.statistics.sonicFlowStartTime = System.currentTimeMillis();
    Object localObject = null;
    SonicDataHelper.SessionData localSessionData = getSessionData(paramBoolean);
    if (paramBoolean)
    {
      localObject = SonicCacheInterceptor.getSonicCacheData(this);
      this.statistics.cacheVerifyTime = System.currentTimeMillis();
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") runSonicFlow verify cache cost " + (this.statistics.cacheVerifyTime - this.statistics.sonicFlowStartTime) + " ms");
      handleFlow_LoadLocalCache((String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!paramBoolean))
    {
      paramBoolean = true;
      label178:
      localObject = SonicEngine.getInstance().getRuntime();
      if (((SonicRuntime)localObject).isNetworkValid()) {
        break label325;
      }
      if ((paramBoolean) && (!TextUtils.isEmpty(this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST))) {
        ((SonicRuntime)localObject).postTaskToMainThread(new SonicSession.3(this, (SonicRuntime)localObject), 1500L);
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:network is not valid!");
    }
    for (;;)
    {
      switchState(1, 2, true);
      this.isWaitingForSessionThread.set(false);
      if (!postForceDestroyIfNeed()) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") runSonicFlow:send force destroy message.");
      return;
      paramBoolean = false;
      break label178;
      label325:
      handleFlow_Connection(paramBoolean, localSessionData);
      this.statistics.connectionFlowFinishTime = System.currentTimeMillis();
    }
  }
  
  private void saveSonicCacheOnServerClose(SonicServer paramSonicServer)
  {
    boolean bool = false;
    if (isDestroyedOrWaitingForDestroy())
    {
      localObject = new StringBuilder().append("session(").append(this.sId).append(") doSaveSonicCache: save session files fail. Current session is destroy (").append(isDestroyedOrWaitingForDestroy()).append(") or refresh ( ");
      if (paramSonicServer != this.server) {
        bool = true;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, bool + ")");
      return;
    }
    Object localObject = paramSonicServer.getResponseData(false);
    StringBuilder localStringBuilder;
    if (SonicUtils.shouldLog(3))
    {
      localStringBuilder = new StringBuilder().append("session(").append(this.sId).append(") onClose:htmlString size:");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label275;
      }
    }
    label275:
    for (int i = ((String)localObject).length();; i = 0)
    {
      SonicUtils.log("SonicSdk_SonicSession", 3, i);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = System.currentTimeMillis();
        doSaveSonicCache(paramSonicServer, (String)localObject);
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:separate And save ache finish, cost " + (System.currentTimeMillis() - l) + " ms.");
      }
      this.isWaitingForSaveFile.set(false);
      if (!postForceDestroyIfNeed()) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message.");
      return;
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
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") bind client.");
      return true;
    }
    return false;
  }
  
  protected boolean canDestroy()
  {
    if ((this.isWaitingForSessionThread.get()) || (this.isWaitingForSaveFile.get()))
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") canDestroy:false, isWaitingForSessionThread=" + this.isWaitingForDestroy.get() + ", isWaitingForSaveFile=" + this.isWaitingForSaveFile.get());
      return false;
    }
    return true;
  }
  
  protected void clearSessionData()
  {
    if (this.pendingClientCoreMessage != null) {
      this.pendingClientCoreMessage = null;
    }
  }
  
  protected Intent createConnectionIntent(SonicDataHelper.SessionData paramSessionData)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    SonicUtils.log("SonicSdk_SonicSession", 4, String.format("Session (%s) send sonic request, etag=(%s), templateTag=(%s)", new Object[] { this.id, paramSessionData.eTag, paramSessionData.templateTag }));
    localIntent.putExtra("eTag", paramSessionData.eTag);
    localIntent.putExtra("template-tag", paramSessionData.templateTag);
    Object localObject = SonicEngine.getInstance().getRuntime().getHostDirectAddress(this.srcUrl);
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
          localStringBuilder.append(";").append(localChunkData.toHeader());
          i += 1;
        }
        localIntent.putExtra("X-sonic-chunk", localStringBuilder.toString());
        SonicUtils.log("SonicSdk_SonicSession", 4, String.format("Session (%s) send sonic request with chunk hash, etag=(%s), cost=(%d)", new Object[] { this.id, paramSessionData.eTag, Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
    if (paramSessionData.isRedPointPreload == 1)
    {
      this.lastIsRedPointPreload = bool;
      this.lastDateUpdateTime = paramSessionData.templateUpdateTime;
      paramSessionData = SonicEngine.getInstance().getRuntime();
      if (SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE) {
        break label416;
      }
      localObject = paramSessionData.getCookie(this.srcUrl);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra("Cookie", (String)localObject);
      }
      label365:
      paramSessionData = paramSessionData.getUserAgent();
      if (TextUtils.isEmpty(paramSessionData)) {
        break label438;
      }
    }
    label416:
    label438:
    for (paramSessionData = paramSessionData + " Sonic/3.0.2";; paramSessionData = "Sonic/3.0.2")
    {
      localIntent.putExtra("User-Agent", paramSessionData);
      return localIntent;
      bool = false;
      break;
      localIntent.putExtra("Cookie", this.intent.getStringExtra("Cookie"));
      break label365;
    }
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
      if (this.pendingWebResourceStream == null) {}
    }
    try
    {
      this.pendingWebResourceStream.close();
      this.pendingWebResourceStream = null;
      if (this.pendingDiffData != null) {
        this.pendingDiffData = null;
      }
      clearSessionData();
      checkAndClearCacheData();
      if ((paramBoolean) || (canDestroy())) {
        this.sessionState.set(3);
      }
      while (!this.isWaitingForDestroy.compareAndSet(false, true)) {}
    }
    catch (Throwable localThrowable)
    {
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
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") final destroy, force=" + paramBoolean + ".");
        return;
        localThrowable = localThrowable;
        SonicUtils.log("SonicSdk_SonicSession", 6, "pendingWebResourceStream.close error:" + localThrowable.getMessage());
      }
    }
    this.mainHandler.sendEmptyMessageDelayed(3, 6000L);
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") waiting for destroy, current state =" + i + ".");
  }
  
  protected void doSaveSonicCache(SonicServer paramSonicServer, String paramString)
  {
    if ((isDestroyedOrWaitingForDestroy()) || (this.server == null))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail. Current session is destroy!");
      return;
    }
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
    }
    for (;;)
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") doSaveSonicCache: finish, cost " + (System.currentTimeMillis() - l1) + "ms.");
      return;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail.");
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
      continue;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save separate template and data files fail.");
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1005);
    }
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
    String str1 = SonicUtils.DEFAULT_CHARSET;
    String str2 = "Content-Type".toLowerCase();
    if ((paramMap != null) && (paramMap.containsKey(str2)))
    {
      paramMap = (String)paramMap.get(str2);
      if (!TextUtils.isEmpty(paramMap)) {
        return SonicUtils.getCharset(paramMap);
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
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") won't send any request in " + (paramSessionData.expiredTime - this.statistics.connectionFlowStartTime) + ".ms");
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
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") connection get header fields cost = " + (System.currentTimeMillis() - l1) + " ms.");
      }
      l1 = System.currentTimeMillis();
      setCookiesFromHeaders(paramSessionData, shouldSetCookieAsynchronous());
      i = j;
      if (SonicUtils.shouldLog(3))
      {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") connection set cookies cost = " + (System.currentTimeMillis() - l1) + " ms.");
        i = j;
      }
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - this.statistics.connectionFlowStartTime) + " ms.");
    if (isDestroyedOrWaitingForDestroy())
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: destroy before server response!");
      return;
    }
    if (304 == i)
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: Server response is not modified.");
      handleFlow_NotModified();
      return;
    }
    if (200 != i)
    {
      handleFlow_HttpError(i);
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, i);
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: response code(" + i + ") is not OK!");
      return;
    }
    paramSessionData = this.server.getResponseHeaderField("cache-offline");
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: cacheOffline is " + paramSessionData + ".");
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
    if ((TextUtils.isEmpty(paramSessionData)) || ("false".equalsIgnoreCase(paramSessionData)))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: Cache-Offline is empty or false!");
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    paramSessionData = this.server.getResponseHeaderField("eTag");
    String str = this.server.getResponseHeaderField("template-change");
    if ((TextUtils.isEmpty(paramSessionData)) || (TextUtils.isEmpty(str)))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: eTag is ( " + paramSessionData + " ) , templateChange is ( " + str + " )!");
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    if (("false".equals(str)) || ("0".equals(str)))
    {
      handleFlow_DataUpdate(this.server.getUpdatedData());
      return;
    }
    handleFlow_TemplateChange(this.server.getResponseData(this.clientIsReload.get()));
  }
  
  protected void handleFlow_DataUpdate(String paramString)
  {
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: start.");
    String str1 = null;
    String str2;
    String str3;
    Object localObject;
    JSONObject localJSONObject1;
    String str5;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramString = this.server.getResponseData(true);
          if (TextUtils.isEmpty(paramString)) {
            SonicUtils.log("SonicSdk_SonicSession", 6, "handleFlow_DataUpdate:getResponseData error.");
          }
        }
        else
        {
          str1 = this.server.getResponseData(false);
          continue;
        }
        str2 = this.server.getResponseHeaderField("eTag");
        str3 = this.server.getResponseHeaderField("template-tag");
        String str4 = this.server.getResponseHeaderField("cache-offline");
        l1 = System.currentTimeMillis();
        localObject = new JSONObject(paramString);
        localJSONObject1 = ((JSONObject)localObject).optJSONObject("data");
        str5 = ((JSONObject)localObject).optString("html-sha1");
        JSONObject localJSONObject2 = SonicUtils.getDiffData(this.id, localJSONObject1);
        localObject = new Bundle();
        if (localJSONObject2 != null)
        {
          ((Bundle)localObject).putString("_diff_data_", localJSONObject2.toString());
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_SonicSession", 3, "handleFlow_DataUpdate:getDiffData cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          int i = 0;
          if (this.wasLoadDataInvoked.get())
          {
            if (SonicUtils.shouldLog(4)) {
              SonicUtils.log("SonicSdk_SonicSession", 4, "handleFlow_DataUpdate:loadData was invoked, quick notify web data update.");
            }
            Message localMessage = this.mainHandler.obtainMessage(7);
            if (!"store".equals(str4)) {
              localMessage.setData((Bundle)localObject);
            }
            this.mainHandler.sendMessage(localMessage);
            i = 1;
          }
          l1 = System.currentTimeMillis();
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = SonicUtils.buildHtml(this.id, localJSONObject1, str5, paramString.length(), this.config.SUPPORT_SONIC_CHUNK_DATA);
          }
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_SonicSession", 3, "handleFlow_DataUpdate:buildHtml cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1008);
          }
          if (i == 0)
          {
            this.mainHandler.removeMessages(5);
            paramString = this.mainHandler.obtainMessage(7);
            paramString.obj = localObject;
            this.mainHandler.sendMessage(paramString);
          }
          if ((localJSONObject2 != null) && (localObject != null) && (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, str4, this.server.getResponseHeaderFields()))) {
            break;
          }
          SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: clean session cache.");
          SonicUtils.removeSessionCache(this.id);
          return;
        }
      }
      catch (Throwable paramString)
      {
        SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate error:" + paramString.getMessage());
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "handleFlow_DataUpdate:getDiffData error.");
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1006);
    }
    switchState(1, 2, true);
    Thread.yield();
    long l1 = System.currentTimeMillis();
    paramString = this.server.getResponseHeaderFields();
    if (SonicUtils.saveSessionFiles(this.id, (String)localObject, null, localJSONObject1.toString(), paramString))
    {
      long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
      SonicUtils.saveSonicData(this.id, str2, str3, str5, l2, false, paramString);
      if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
        SonicChunkDataHelper.saveChunkData(this.id, str2, localJSONObject1.toString());
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: finish save session cache, cost " + (System.currentTimeMillis() - l1) + " ms.");
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate: save session files fail.");
    SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
  }
  
  protected void handleFlow_FirstLoad()
  {
    boolean bool = false;
    this.pendingWebResourceStream = this.server.getResponseStream(this.wasInterceptInvoked);
    if (this.pendingWebResourceStream == null)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_FirstLoad error:server.getResponseStream is null!");
      return;
    }
    String str = this.server.getResponseData(false);
    if (!TextUtils.isEmpty(str)) {
      bool = true;
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:hasCompletionData=" + bool + ".");
    this.mainHandler.removeMessages(5);
    Object localObject = this.mainHandler.obtainMessage(6);
    ((Message)localObject).obj = str;
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      ((Message)localObject).arg1 = i;
      this.mainHandler.sendMessage((Message)localObject);
      localObject = this.server.getResponseHeaderField("cache-offline");
      if (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject, this.server.getResponseHeaderFields())) {
        break label248;
      }
      if ((!bool) || (this.wasLoadUrlInvoked.get()) || (this.wasInterceptInvoked.get())) {
        break;
      }
      switchState(1, 2, true);
      postTaskToSaveSonicCache(str);
      return;
    }
    label248:
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:offline->" + (String)localObject + " , so do not need cache to file.");
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
    for (;;)
    {
      this.mainHandler.sendMessage(localMessage);
      return;
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") runSonicFlow has no cache, do first load flow.");
      localMessage.arg1 = 1;
    }
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
    for (;;)
    {
      try
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "handleFlow_TemplateChange.");
        long l = System.currentTimeMillis();
        String str = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          this.pendingWebResourceStream = this.server.getResponseStream(this.wasOnPageFinishInvoked);
          if (this.pendingWebResourceStream == null)
          {
            SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_TemplateChange error:server.getResponseStream = null!");
            return;
          }
          str = this.server.getResponseData(this.clientIsReload.get());
        }
        paramString = this.server.getResponseHeaderField("cache-offline");
        if (!this.clientIsReload.get())
        {
          this.mainHandler.removeMessages(5);
          localMessage = this.mainHandler.obtainMessage(8);
          localMessage.obj = str;
          if (!"store".equals(paramString)) {
            localMessage.arg1 = 1;
          }
          this.mainHandler.sendMessage(localMessage);
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") read byte stream cost " + (System.currentTimeMillis() - l) + " ms, wasInterceptInvoked: " + this.wasInterceptInvoked.get());
          }
          if (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, paramString, this.server.getResponseHeaderFields())) {
            break;
          }
          switchState(1, 2, true);
          if (TextUtils.isEmpty(str)) {
            return;
          }
          postTaskToSaveSonicCache(str);
          return;
        }
      }
      catch (Throwable paramString)
      {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") handleFlow_TemplateChange error:" + paramString.getMessage());
        return;
      }
      Message localMessage = this.mainHandler.obtainMessage(1);
      localMessage.arg1 = 2000;
      localMessage.arg2 = 2000;
      this.mainHandler.sendMessage(localMessage);
    }
    if ("false".equals(paramString))
    {
      SonicUtils.removeSessionCache(this.id);
      SonicUtils.log("SonicSdk_SonicSession", 4, "handleClientCoreMessage_TemplateChange:offline mode is 'false', so clean cache.");
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_TemplateChange:offline->" + paramString + " , so do not need cache to file.");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (3 == paramMessage.what)
    {
      destroy(true);
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleMessage:force destroy.");
      return true;
    }
    if (isDestroyedOrWaitingForDestroy())
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleMessage error: is destroyed or waiting for destroy.");
      return true;
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") handleMessage: msg what = " + paramMessage.what + ".");
    }
    if ((4 < paramMessage.what) && (paramMessage.what < 11) && (!this.clientIsReady.get()))
    {
      this.pendingClientCoreMessage = Message.obtain(paramMessage);
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    default: 
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") can not  recognize refresh type: " + paramMessage.what);
      }
      return false;
    case 5: 
      handleClientCoreMessage_PreLoad(paramMessage);
    }
    for (;;)
    {
      return true;
      handleClientCoreMessage_FirstLoad(paramMessage);
      continue;
      handleClientCoreMessage_ConnectionError(paramMessage);
      continue;
      handleClientCoreMessage_ServiceUnavailable(paramMessage);
      continue;
      handleClientCoreMessage_DataUpdate(paramMessage);
      continue;
      handleClientCoreMessage_TemplateChange(paramMessage);
      continue;
      setResult(paramMessage.arg1, paramMessage.arg2, true);
      continue;
      this.diffDataCallback = ((SonicDiffDataCallback)paramMessage.obj);
      setResult(this.srcResultCode, this.finalResultCode, true);
    }
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
      Object localObject = localUri.getHost() + localUri.getPath();
      String str = paramString.getHost() + paramString.getPath();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("/")) {
          paramString = (String)localObject + "/";
        }
        localObject = str;
        if (!str.endsWith("/")) {
          localObject = str + "/";
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "isMatchCurrentUrl error:" + paramString.getMessage());
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
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClientPageFinished:url=" + paramString + ".");
      this.wasOnPageFinishInvoked.set(true);
      return true;
    }
    return false;
  }
  
  public boolean onClientReady()
  {
    boolean bool = false;
    if (this.clientIsReady.compareAndSet(false, true))
    {
      Object localObject = new StringBuilder().append("session(").append(this.sId).append(") onClientReady: have pending client core message ? -> ");
      if (this.pendingClientCoreMessage != null) {
        bool = true;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, bool + ".");
      if (this.pendingClientCoreMessage != null)
      {
        localObject = this.pendingClientCoreMessage;
        this.pendingClientCoreMessage = null;
        handleMessage((Message)localObject);
      }
      while (this.sessionState.get() != 0) {
        return true;
      }
      start();
      return true;
    }
    return false;
  }
  
  public final Object onClientRequestResource(String paramString)
  {
    if ("Chrome_FileThread".equals(Thread.currentThread().getName()))
    {
      this.resourceInterceptState.set(1);
      if (!isMatchCurrentUrl(paramString)) {
        break label57;
      }
    }
    label57:
    for (paramString = onRequestResource(paramString);; paramString = null)
    {
      this.resourceInterceptState.set(0);
      return paramString;
      this.resourceInterceptState.set(2);
      break;
    }
  }
  
  protected Object onRequestResource(String arg1)
  {
    boolean bool = true;
    if ((this.wasInterceptInvoked.get()) || (!isMatchCurrentUrl(???))) {
      return null;
    }
    if (!this.wasInterceptInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  onClientRequestResource error:Intercept was already invoked, url = " + ???);
      return null;
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ")  onClientRequestResource:url = " + ???);
    }
    long l = System.currentTimeMillis();
    if (this.sessionState.get() == 1) {}
    for (;;)
    {
      synchronized (this.sessionState)
      {
        try
        {
          if (this.sessionState.get() == 1)
          {
            SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") now wait for pendingWebResourceStream!");
            this.sessionState.wait(30000L);
          }
          ??? = new StringBuilder().append("session(").append(this.sId).append(") have pending stream? -> ");
          if (this.pendingWebResourceStream == null) {
            break label430;
          }
          SonicUtils.log("SonicSdk_SonicSession", 4, bool + ", cost " + (System.currentTimeMillis() - l) + "ms.");
          if (this.pendingWebResourceStream == null) {
            break;
          }
          if (isDestroyedOrWaitingForDestroy()) {
            break label435;
          }
          ??? = SonicUtils.getMime(this.srcUrl);
          ??? = SonicEngine.getInstance().getRuntime().createWebResourceResponse(???, getCharsetFromHeaders(), this.pendingWebResourceStream, getHeaders());
          this.pendingWebResourceStream = null;
          return ???;
        }
        catch (Throwable localThrowable)
        {
          SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") wait for pendingWebResourceStream failed" + localThrowable.getMessage());
          continue;
        }
      }
      if (SonicUtils.shouldLog(3))
      {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") is not in running state: " + this.sessionState);
        continue;
        label430:
        bool = false;
        continue;
        label435:
        SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") onClientRequestResource error: session is destroyed!");
        ??? = null;
      }
    }
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
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:offline->" + (String)localObject + " , post separateAndSaveCache task.");
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramSonicServer;
        this.fileHandler.sendMessageDelayed((Message)localObject, 1500L);
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:offline->" + (String)localObject + " , so do not need cache to file.");
    }
    for (;;)
    {
      this.isWaitingForSaveFile.set(false);
      if (postForceDestroyIfNeed()) {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!SonicUtils.shouldLog(3)) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
      return;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") onClose error:readComplete = false!");
    }
  }
  
  public boolean onWebReady(SonicDiffDataCallback paramSonicDiffDataCallback)
  {
    Object localObject = new StringBuilder().append("session(").append(this.sId).append(") onWebReady: webCallback has set ? ->");
    if (this.diffDataCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, bool);
      if (this.diffDataCallback != null)
      {
        this.diffDataCallback = null;
        SonicUtils.log("SonicSdk_SonicSession", 5, "session(" + this.sId + ") onWebReady: call more than once.");
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramSonicDiffDataCallback;
      this.mainHandler.sendMessage((Message)localObject);
      return true;
    }
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
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") refresh error:sessionState=" + this.sessionState.get() + ".");
      return false;
    }
    this.wasInterceptInvoked.set(false);
    this.clientIsReload.set(true);
    this.finalResultCode = -1;
    this.srcResultCode = -1;
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") now refresh sonic flow task.");
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
    SonicSessionStatistics localSonicSessionStatistics = this.statistics;
    String str = paramString.trim();
    localSonicSessionStatistics.srcUrl = str;
    this.srcUrl = str;
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") is preload, new url=" + paramString + ".");
    }
  }
  
  protected void setResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ")  setResult: srcCode=" + paramInt1 + ", finalCode=" + paramInt2 + ".");
    Object localObject1 = this.statistics;
    this.srcResultCode = paramInt1;
    ((SonicSessionStatistics)localObject1).originalMode = paramInt1;
    localObject1 = this.statistics;
    this.finalResultCode = paramInt2;
    ((SonicSessionStatistics)localObject1).finalMode = paramInt2;
    if (!paramBoolean) {
      return;
    }
    if (this.wasNotified.get()) {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify error -> already has notified!");
    }
    if (this.diffDataCallback == null)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify fail as webCallback is not set, please wait!");
      return;
    }
    if (this.finalResultCode == -1)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify fail finalResultCode is not set, please wait!");
      return;
    }
    this.wasNotified.compareAndSet(false, true);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.finalResultCode == 200)
      {
        localObject1 = new JSONObject(this.pendingDiffData);
        if (!((JSONObject)localObject1).has("local_refresh_time"))
        {
          SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") setResult: no any updated data. " + this.pendingDiffData);
          this.pendingDiffData = "";
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") setResult: notify error -> " + localThrowable.getMessage());
      Object localObject2;
      if (SonicUtils.shouldLog(3))
      {
        String str = localJSONObject.toString();
        localObject2 = str;
        if (str.length() > 512) {
          localObject2 = str.substring(0, 512);
        }
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") setResult: notify now call jsCallback, jsonStr = " + (String)localObject2);
      }
      this.pendingDiffData = null;
      long l1 = 0L;
      if (this.clientIsReload.get())
      {
        long l2 = System.currentTimeMillis() - this.statistics.diffDataCallbackTime;
        l1 = l2;
        if (l2 >= 2000L) {
          l1 = 0L;
        }
      }
      if (l1 > 0L)
      {
        SonicEngine.getInstance().getRuntime().postTaskToMainThread(new SonicSession.5(this, localJSONObject), 2000L - l1);
        return;
        l1 = System.currentTimeMillis() - ((JSONObject)localObject2).optLong("local_refresh_time", 0L);
        if (l1 > 30000L)
        {
          SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") setResult: notify fail as receive js call too late, " + l1 / 1000.0D + " s.");
          this.pendingDiffData = "";
          return;
        }
        if (SonicUtils.shouldLog(3)) {
          SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") setResult: notify receive js call in time: " + l1 / 1000.0D + " s.");
        }
        if (l1 > 0L) {
          localJSONObject.put("local_refresh_time", l1);
        }
        ((JSONObject)localObject2).remove("local_refresh_time");
        localJSONObject.put("result", ((JSONObject)localObject2).toString());
        if (this.isRedPointPreload) {
          this.lastIsRedPointPreload = true;
        }
        for (;;)
        {
          localJSONObject.put("isPreload", this.lastIsRedPointPreload);
          localJSONObject.put("code", this.finalResultCode);
          localJSONObject.put("srcCode", this.srcResultCode);
          localObject2 = new JSONObject();
          if (this.server != null)
          {
            ((JSONObject)localObject2).put("eTag", this.server.getResponseHeaderField("eTag"));
            ((JSONObject)localObject2).put("template-tag", this.server.getResponseHeaderField("template-tag"));
            ((JSONObject)localObject2).put("cache-offline", this.server.getResponseHeaderField("cache-offline"));
          }
          ((JSONObject)localObject2).put("isReload", this.clientIsReload);
          localJSONObject.put("extra", localObject2);
          break;
          if (System.currentTimeMillis() - this.lastDateUpdateTime > 86400000L) {
            this.lastIsRedPointPreload = false;
          }
        }
      }
      this.diffDataCallback.callback(localJSONObject.toString());
      this.statistics.diffDataCallbackTime = System.currentTimeMillis();
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
      SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") start error:sessionState=" + this.sessionState.get() + ".");
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") now post sonic flow task.");
    this.statistics.sonicStartTime = System.currentTimeMillis();
    this.isWaitingForSessionThread.set(true);
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new SonicSession.2(this));
    notifyStateChange(0, 1, null);
  }
  
  protected boolean switchState(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.sessionState.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {}
      synchronized (this.sessionState)
      {
        this.sessionState.notify();
        notifyStateChange(paramInt1, paramInt2, null);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession
 * JD-Core Version:    0.7.0.1
 */