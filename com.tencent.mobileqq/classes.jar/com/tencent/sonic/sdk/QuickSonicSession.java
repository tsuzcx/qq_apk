package com.tencent.sonic.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class QuickSonicSession
  extends SonicSession
  implements Handler.Callback
{
  private static final int CLIENT_CORE_MSG_BEGIN = 4;
  private static final int CLIENT_CORE_MSG_CONNECTION_ERROR = 9;
  private static final int CLIENT_CORE_MSG_DATA_UPDATE = 7;
  private static final int CLIENT_CORE_MSG_END = 11;
  private static final int CLIENT_CORE_MSG_FIRST_LOAD = 6;
  private static final int CLIENT_CORE_MSG_PRE_LOAD = 5;
  private static final int CLIENT_CORE_MSG_SERVICE_UNAVAILABLE = 10;
  private static final int CLIENT_CORE_MSG_TEMPLATE_CHANGE = 8;
  private static final int FIRST_LOAD_NO_DATA = 1;
  private static final int FIRST_LOAD_WITH_DATA = 2;
  private static final int PRE_LOAD_NO_CACHE = 1;
  private static final int PRE_LOAD_WITH_CACHE = 2;
  private static final String TAG = "SonicSdk_QuickSonicSession";
  private static final int TEMPLATE_CHANGE_REFRESH = 1;
  private Message pendingClientCoreMessage;
  private final AtomicBoolean wasLoadDataInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasLoadUrlInvoked = new AtomicBoolean(false);
  
  QuickSonicSession(String paramString1, String paramString2, SonicSessionConfig paramSonicSessionConfig)
  {
    super(paramString1, paramString2, paramSonicSessionConfig);
  }
  
  private void handleClientCoreMessage_ConnectionError(Message paramMessage)
  {
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_ConnectionError: load src url.");
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
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_DataUpdate:try to notify web callback.");
        setResult(200, 200, true);
        return;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_DataUpdate:diffData is null, cache-offline = store , do not refresh.");
      setResult(200, 304, true);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = new StringBuilder().append("handleClientCoreMessage_DataUpdate:oh yeah data update hit 304, now clear pending data ->");
      if (this.pendingDiffData != null) {}
      for (;;)
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, bool + ".");
        this.pendingDiffData = null;
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, str, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        setResult(200, 304, false);
        return;
        bool = false;
      }
    }
    SonicUtils.log("SonicSdk_QuickSonicSession", 6, "handleClientCoreMessage_DataUpdate error:call load url.");
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
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_DATA.");
        setResult(1000, 1000, true);
        return;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
      return;
    }
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:oh yeah, first load hit 304.");
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, (String)paramMessage.obj, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
      setResult(1000, 304, false);
      return;
    }
    SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") FIRST_LOAD_WITH_DATA load url was invoked.");
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
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "1");
        this.sessionClient.loadUrl(this.currUrl, null);
        return;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
      return;
    }
    if (this.wasLoadDataInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
      paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), null);
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", SonicUtils.DEFAULT_CHARSET, this.srcUrl, getCacheHeaders());
      return;
    }
    SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
  }
  
  private void handleClientCoreMessage_ServiceUnavailable(Message paramMessage)
  {
    if (this.wasLoadUrlInvoked.compareAndSet(false, true))
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_ServiceUnavailable:load src url.");
      }
      this.sessionClient.loadUrl(this.srcUrl, null);
    }
  }
  
  private void handleClientCoreMessage_TemplateChange(Message paramMessage)
  {
    boolean bool = true;
    SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_TemplateChange wasLoadDataInvoked = " + this.wasLoadDataInvoked.get() + ",msg arg1 = " + paramMessage.arg1);
    if (this.wasLoadDataInvoked.get()) {
      if (1 == paramMessage.arg1) {
        if (TextUtils.isEmpty((String)paramMessage.obj))
        {
          paramMessage = new StringBuilder().append("handleClientCoreMessage_TemplateChange:load url with preload=2, webCallback is null? ->");
          if (this.diffDataCallback != null)
          {
            SonicUtils.log("SonicSdk_QuickSonicSession", 4, bool);
            this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "2");
            this.sessionClient.loadUrl(this.currUrl, null);
            label137:
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
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_TemplateChange:load data.");
      paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()));
      this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
      break label137;
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_TemplateChange:not refresh.");
      setResult(2000, 304, true);
      continue;
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_TemplateChange:oh yeah template change hit 304.");
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = SonicUtils.addTagInfo((String)paramMessage.obj, String.valueOf(System.currentTimeMillis()), null);
        this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, paramMessage, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
        setResult(2000, 304, false);
      }
      else
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 6, "handleClientCoreMessage_TemplateChange error:call load url.");
        this.sessionClient.loadUrl(this.srcUrl, null);
        setResult(2000, 1000, false);
      }
    }
  }
  
  protected void clearSessionData()
  {
    if (this.pendingClientCoreMessage != null) {
      this.pendingClientCoreMessage = null;
    }
  }
  
  protected void handleFlow_DataUpdate(String paramString)
  {
    SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: start.");
    Object localObject1 = null;
    String str1;
    String str2;
    Object localObject3;
    Object localObject2;
    JSONObject localJSONObject1;
    String str3;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramString = this.server.getResponseData(true);
          if (TextUtils.isEmpty(paramString)) {
            SonicUtils.log("SonicSdk_QuickSonicSession", 6, "handleFlow_DataUpdate:getResponseData error.");
          }
        }
        else
        {
          localObject1 = this.server.getResponseData(false);
          continue;
        }
        str1 = this.server.getResponseHeaderField("eTag");
        str2 = this.server.getResponseHeaderField("template-tag");
        localObject3 = this.server.getResponseHeaderField("cache-offline");
        l1 = System.currentTimeMillis();
        localObject2 = new JSONObject(paramString);
        localJSONObject1 = ((JSONObject)localObject2).optJSONObject("data");
        str3 = ((JSONObject)localObject2).optString("html-sha1");
        localJSONObject2 = SonicUtils.getDiffData(this.id, localJSONObject1);
        localObject2 = new Bundle();
        if (localJSONObject2 != null)
        {
          ((Bundle)localObject2).putString("_diff_data_", localJSONObject2.toString());
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_QuickSonicSession", 3, "handleFlow_DataUpdate:getDiffData cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          int i = 0;
          if (this.wasLoadDataInvoked.get())
          {
            if (SonicUtils.shouldLog(4)) {
              SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleFlow_DataUpdate:loadData was invoked, quick notify web data update.");
            }
            localObject4 = this.mainHandler.obtainMessage(7);
            if (!"store".equals(localObject3)) {
              ((Message)localObject4).setData((Bundle)localObject2);
            }
            this.mainHandler.sendMessage((Message)localObject4);
            i = 1;
          }
          l1 = System.currentTimeMillis();
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = SonicUtils.buildHtml(this.id, localJSONObject1, str3, paramString.length());
          }
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_QuickSonicSession", 3, "handleFlow_DataUpdate:buildHtml cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1008);
          }
          if (i == 0)
          {
            this.mainHandler.removeMessages(5);
            localObject1 = this.mainHandler.obtainMessage(7);
            ((Message)localObject1).obj = localObject2;
            this.mainHandler.sendMessage((Message)localObject1);
          }
          localObject1 = this.sessionCallbackList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject4 = (SonicSessionCallback)((WeakReference)((Iterator)localObject1).next()).get();
          if (localObject4 == null) {
            continue;
          }
          ((SonicSessionCallback)localObject4).onSessionDataUpdated(paramString);
          continue;
        }
        SonicUtils.log("SonicSdk_QuickSonicSession", 6, "handleFlow_DataUpdate:getDiffData error.");
      }
      catch (Throwable paramString)
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate error:" + paramString.getMessage());
        return;
      }
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1006);
    }
    if ((localJSONObject2 == null) || (localObject2 == null) || (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject3, this.server.getResponseHeaderFields())))
    {
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: clean session cache.");
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    switchState(1, 2, true);
    Thread.yield();
    long l1 = System.currentTimeMillis();
    paramString = this.server.getResponseHeaderFields();
    localObject1 = this.sessionCallbackList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (SonicSessionCallback)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject3 != null) {
        ((SonicSessionCallback)localObject3).onSessionSaveCache((String)localObject2, null, localJSONObject1.toString());
      }
    }
    if (SonicUtils.saveSessionFiles(this.id, (String)localObject2, null, localJSONObject1.toString(), paramString))
    {
      long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
      SonicUtils.saveSonicData(this.id, str1, str2, str3, l2, false, paramString);
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: finish save session cache, cost " + (System.currentTimeMillis() - l1) + " ms.");
      return;
    }
    SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate: save session files fail.");
    SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
  }
  
  protected void handleFlow_FirstLoad()
  {
    boolean bool = false;
    this.pendingWebResourceStream = this.server.getResponseStream(this.wasInterceptInvoked);
    if (this.pendingWebResourceStream == null) {
      SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleFlow_FirstLoad error:server.getResponseStream is null!");
    }
    String str;
    Object localObject;
    do
    {
      return;
      str = this.server.getResponseData(false);
      if (!TextUtils.isEmpty(str)) {
        bool = true;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:hasCompletionData=" + bool + ".");
      this.mainHandler.removeMessages(5);
      localObject = this.mainHandler.obtainMessage(6);
      ((Message)localObject).obj = str;
      if (bool) {}
      for (int i = 2;; i = 1)
      {
        ((Message)localObject).arg1 = i;
        this.mainHandler.sendMessage((Message)localObject);
        localObject = this.sessionCallbackList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)localObject).next()).get();
          if (localSonicSessionCallback != null) {
            localSonicSessionCallback.onSessionFirstLoad(str);
          }
        }
      }
      localObject = this.server.getResponseHeaderField("cache-offline");
      if (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject, this.server.getResponseHeaderFields())) {
        break;
      }
    } while ((!bool) || (this.wasLoadUrlInvoked.get()) || (this.wasInterceptInvoked.get()));
    switchState(1, 2, true);
    postTaskToSaveSonicCache(str);
    return;
    SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:offline->" + (String)localObject + " , so do not need cache to file.");
  }
  
  protected void handleFlow_HttpError(int paramInt)
  {
    if (this.config.RELOAD_IN_BAD_NETWORK)
    {
      this.mainHandler.removeMessages(5);
      localObject = this.mainHandler.obtainMessage(9);
      ((Message)localObject).arg1 = paramInt;
      this.mainHandler.sendMessage((Message)localObject);
    }
    Object localObject = this.sessionCallbackList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)localObject).next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSessionHttpError(paramInt);
      }
    }
  }
  
  protected void handleFlow_LoadLocalCache(String paramString)
  {
    Object localObject = this.mainHandler.obtainMessage(5);
    if (!TextUtils.isEmpty(paramString))
    {
      ((Message)localObject).arg1 = 2;
      ((Message)localObject).obj = paramString;
    }
    for (;;)
    {
      this.mainHandler.sendMessage((Message)localObject);
      localObject = this.sessionCallbackList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)localObject).next()).get();
        if (localSonicSessionCallback != null) {
          localSonicSessionCallback.onSessionLoadLocalCache(paramString);
        }
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") runSonicFlow has no cache, do first load flow.");
      ((Message)localObject).arg1 = 1;
    }
  }
  
  protected void handleFlow_ServiceUnavailable()
  {
    this.mainHandler.removeMessages(5);
    Message localMessage = this.mainHandler.obtainMessage(10);
    this.mainHandler.sendMessage(localMessage);
  }
  
  protected void handleFlow_TemplateChange(String paramString)
  {
    String str;
    long l;
    for (;;)
    {
      Object localObject;
      try
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleFlow_TemplateChange.");
        str = paramString;
        l = System.currentTimeMillis();
        paramString = str;
        if (TextUtils.isEmpty(str))
        {
          this.pendingWebResourceStream = this.server.getResponseStream(this.wasOnPageFinishInvoked);
          if (this.pendingWebResourceStream == null)
          {
            SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") handleFlow_TemplateChange error:server.getResponseStream = null!");
            return;
          }
          paramString = this.server.getResponseData(this.clientIsReload.get());
        }
        str = this.server.getResponseHeaderField("cache-offline");
        if (!this.clientIsReload.get())
        {
          this.mainHandler.removeMessages(5);
          localObject = this.mainHandler.obtainMessage(8);
          ((Message)localObject).obj = paramString;
          if (!"store".equals(str)) {
            ((Message)localObject).arg1 = 1;
          }
          this.mainHandler.sendMessage((Message)localObject);
          localObject = this.sessionCallbackList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)localObject).next()).get();
          if (localSonicSessionCallback == null) {
            continue;
          }
          localSonicSessionCallback.onSessionTemplateChanged(paramString);
          continue;
        }
        localObject = this.mainHandler.obtainMessage(1);
      }
      catch (Throwable paramString)
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 3, "session(" + this.sId + ") handleFlow_TemplateChange error:" + paramString.getMessage());
        return;
      }
      ((Message)localObject).arg1 = 2000;
      ((Message)localObject).arg2 = 2000;
      this.mainHandler.sendMessage((Message)localObject);
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_QuickSonicSession", 3, "session(" + this.sId + ") read byte stream cost " + (System.currentTimeMillis() - l) + " ms, wasInterceptInvoked: " + this.wasInterceptInvoked.get());
    }
    if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, str, this.server.getResponseHeaderFields()))
    {
      switchState(1, 2, true);
      if (!TextUtils.isEmpty(paramString)) {
        postTaskToSaveSonicCache(paramString);
      }
    }
    else
    {
      if ("false".equals(str))
      {
        SonicUtils.removeSessionCache(this.id);
        SonicUtils.log("SonicSdk_QuickSonicSession", 4, "handleClientCoreMessage_TemplateChange:offline mode is 'false', so clean cache.");
        return;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleFlow_TemplateChange:offline->" + str + " , so do not need cache to file.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (super.handleMessage(paramMessage)) {
      return true;
    }
    if ((4 < paramMessage.what) && (paramMessage.what < 11) && (!this.clientIsReady.get()))
    {
      this.pendingClientCoreMessage = Message.obtain(paramMessage);
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    default: 
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_QuickSonicSession", 3, "session(" + this.sId + ") can not  recognize refresh type: " + paramMessage.what);
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
  
  public boolean onClientReady()
  {
    boolean bool = false;
    if (this.clientIsReady.compareAndSet(false, true))
    {
      Object localObject = new StringBuilder().append("session(").append(this.sId).append(") onClientReady: have pending client core message ? -> ");
      if (this.pendingClientCoreMessage != null) {
        bool = true;
      }
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, bool + ".");
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
  
  protected Object onRequestResource(String arg1)
  {
    if ((this.wasInterceptInvoked.get()) || (!isMatchCurrentUrl(???))) {
      return null;
    }
    if (!this.wasInterceptInvoked.compareAndSet(false, true))
    {
      SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ")  onClientRequestResource error:Intercept was already invoked, url = " + ???);
      return null;
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_QuickSonicSession", 3, "session(" + this.sId + ")  onClientRequestResource:url = " + ???);
    }
    long l = System.currentTimeMillis();
    if (this.sessionState.get() == 1) {}
    for (;;)
    {
      boolean bool;
      synchronized (this.sessionState)
      {
        try
        {
          if (this.sessionState.get() == 1)
          {
            SonicUtils.log("SonicSdk_QuickSonicSession", 4, "session(" + this.sId + ") now wait for pendingWebResourceStream!");
            this.sessionState.wait(30000L);
          }
          ??? = new StringBuilder().append("session(").append(this.sId).append(") have pending stream? -> ");
          if (this.pendingWebResourceStream == null) {
            break label426;
          }
          bool = true;
          SonicUtils.log("SonicSdk_QuickSonicSession", 4, bool + ", cost " + (System.currentTimeMillis() - l) + "ms.");
          if (this.pendingWebResourceStream == null) {
            break;
          }
          if (isDestroyedOrWaitingForDestroy()) {
            break label432;
          }
          ??? = SonicUtils.getMime(this.srcUrl);
          ??? = SonicEngine.getInstance().getRuntime().createWebResourceResponse(???, getCharsetFromHeaders(), this.pendingWebResourceStream, getHeaders());
          this.pendingWebResourceStream = null;
          return ???;
        }
        catch (Throwable localThrowable)
        {
          SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") wait for pendingWebResourceStream failed" + localThrowable.getMessage());
          continue;
        }
      }
      if (SonicUtils.shouldLog(3))
      {
        SonicUtils.log("SonicSdk_QuickSonicSession", 3, "session(" + this.sId + ") is not in running state: " + this.sessionState);
        continue;
        label426:
        bool = false;
        continue;
        label432:
        ??? = null;
        SonicUtils.log("SonicSdk_QuickSonicSession", 6, "session(" + this.sId + ") onClientRequestResource error: session is destroyed!");
      }
    }
    return null;
  }
  
  public boolean onWebReady(SonicDiffDataCallback paramSonicDiffDataCallback)
  {
    Object localObject = new StringBuilder().append("session(").append(this.sId).append(") onWebReady: webCallback has set ? ->");
    if (this.diffDataCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      SonicUtils.log("SonicSdk_QuickSonicSession", 4, bool);
      if (this.diffDataCallback != null)
      {
        this.diffDataCallback = null;
        SonicUtils.log("SonicSdk_QuickSonicSession", 5, "session(" + this.sId + ") onWebReady: call more than once.");
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramSonicDiffDataCallback;
      this.mainHandler.sendMessage((Message)localObject);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.QuickSonicSession
 * JD-Core Version:    0.7.0.1
 */