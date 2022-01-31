package com.tencent.sonic.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class StandardSonicSession
  extends SonicSession
  implements Handler.Callback
{
  private static final int CLIENT_CORE_MSG_BEGIN = 4;
  private static final int CLIENT_MSG_CLIENT_READY = 5;
  private static final String TAG = "SonicSdk_StandardSonicSession";
  private static final String TEMPLATE_CHANGE_BUNDLE_PARAMS_REFRESH = "refresh";
  private final AtomicBoolean isCachePendingStream = new AtomicBoolean(false);
  private final Object webResponseLock = new Object();
  
  StandardSonicSession(String paramString1, String paramString2, SonicSessionConfig paramSonicSessionConfig)
  {
    super(paramString1, paramString2, paramSonicSessionConfig);
  }
  
  public int getSrcResultCode()
  {
    return this.srcResultCode;
  }
  
  protected void handleFlow_DataUpdate(String arg1)
  {
    SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: start.");
    Object localObject3 = null;
    Object localObject1 = null;
    String str1;
    String str2;
    Object localObject5;
    JSONObject localJSONObject3;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(???))
        {
          ??? = this.server.getResponseData(true);
          if (!TextUtils.isEmpty(???)) {}
        }
        else
        {
          localObject1 = this.server.getResponseData(false);
          localObject3 = this.server.getResponseHeaderField("sonic-html-sha1");
          continue;
        }
        str1 = this.server.getResponseHeaderField("eTag");
        str2 = this.server.getResponseHeaderField("template-tag");
        localObject5 = this.server.getResponseHeaderField("cache-offline");
        l1 = System.currentTimeMillis();
        localJSONObject3 = new JSONObject(???);
        localJSONObject1 = localJSONObject3.optJSONObject("data");
        localJSONObject2 = SonicUtils.getDiffData(this.id, localJSONObject1);
        localObject4 = new Bundle();
        if (localJSONObject2 != null)
        {
          ((Bundle)localObject4).putString("_diff_data_", localJSONObject2.toString());
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_StandardSonicSession", 3, "handleFlow_DataUpdate:getDiffData cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          if (SonicUtils.needRefreshPage((String)localObject5))
          {
            if (SonicUtils.shouldLog(4)) {
              SonicUtils.log("SonicSdk_StandardSonicSession", 4, "handleFlow_DataUpdate:loadData was invoked, quick notify web data update.");
            }
            localObject6 = this.mainHandler.obtainMessage(1);
            ((Message)localObject6).arg2 = 200;
            ((Message)localObject6).arg1 = 200;
            ((Message)localObject6).setData((Bundle)localObject4);
            this.mainHandler.sendMessage((Message)localObject6);
          }
          localObject4 = this.sessionCallbackList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          Object localObject6 = (SonicSessionCallback)((WeakReference)((Iterator)localObject4).next()).get();
          if (localObject6 == null) {
            continue;
          }
          ((SonicSessionCallback)localObject6).onSessionDataUpdated(???);
          continue;
        }
        SonicUtils.log("SonicSdk_StandardSonicSession", 6, "handleFlow_DataUpdate:getDiffData error.");
      }
      catch (Throwable ???)
      {
        SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate error:" + ???.getMessage());
        return;
      }
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1006);
    }
    long l1 = System.currentTimeMillis();
    Object localObject4 = localObject3;
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject4 = localJSONObject3.optString("html-sha1");
      localObject3 = SonicUtils.buildHtml(this.id, localJSONObject1, (String)localObject4, ???.length());
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_StandardSonicSession", 3, "handleFlow_DataUpdate:buildHtml cost " + (System.currentTimeMillis() - l1) + " ms.");
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!this.wasInterceptInvoked.get()) && (SonicUtils.needRefreshPage((String)localObject5))) {}
    synchronized (this.webResponseLock)
    {
      this.pendingWebResourceStream = new ByteArrayInputStream(((String)localObject3).getBytes());
      this.isCachePendingStream.set(false);
      SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate:oh yeah, dataUpdate load hit 304.");
      this.mainHandler.removeMessages(1);
      ??? = this.mainHandler.obtainMessage(1);
      ???.arg1 = 200;
      ???.arg2 = 304;
      this.mainHandler.sendMessage(???);
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1008);
      }
      if ((localJSONObject2 == null) || (localObject3 == null) || (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject5, this.server.getResponseHeaderFields())))
      {
        SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: clean session cache.");
        SonicUtils.removeSessionCache(this.id);
      }
      switchState(1, 2, true);
      Thread.yield();
      l1 = System.currentTimeMillis();
      ??? = this.server.getResponseHeaderFields();
      localObject1 = this.sessionCallbackList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = (SonicSessionCallback)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject5 != null) {
          ((SonicSessionCallback)localObject5).onSessionSaveCache((String)localObject3, null, localJSONObject1.toString());
        }
      }
    }
    if (SonicUtils.saveSessionFiles(this.id, (String)localObject3, null, localJSONObject1.toString(), ???))
    {
      long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
      SonicUtils.saveSonicData(this.id, str1, str2, (String)localObject4, l2, false, ???);
      SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_DataUpdate: finish save session cache, cost " + (System.currentTimeMillis() - l1) + " ms.");
      return;
    }
    SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") handleFlow_DataUpdate: save session files fail.");
    SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
  }
  
  protected void handleFlow_FirstLoad()
  {
    for (;;)
    {
      synchronized (this.webResponseLock)
      {
        this.pendingWebResourceStream = this.server.getResponseStream(this.wasInterceptInvoked);
        if (this.pendingWebResourceStream == null)
        {
          SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") handleFlow_FirstLoad error:server.getResponseStream is null!");
          return;
        }
      }
      Object localObject4 = this.mainHandler.obtainMessage(1);
      ((Message)localObject4).arg2 = 1000;
      ((Message)localObject4).arg1 = 1000;
      ??? = this.server.getResponseData(false);
      if (!TextUtils.isEmpty((CharSequence)???)) {}
      try
      {
        ((Message)localObject4).arg2 = 304;
        SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:oh yeah, first load hit 304.");
        this.isCachePendingStream.set(false);
        this.mainHandler.sendMessage((Message)localObject4);
        ??? = this.sessionCallbackList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (SonicSessionCallback)((WeakReference)((Iterator)???).next()).get();
          if (localObject4 != null) {
            ((SonicSessionCallback)localObject4).onSessionFirstLoad((String)???);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        synchronized (this.webResponseLock)
        {
          this.pendingWebResourceStream = null;
          SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") handleFlow_FirstLoad error:" + localThrowable.getMessage() + ".");
        }
        if (!TextUtils.isEmpty(localCharSequence)) {}
        for (boolean bool = true;; bool = false)
        {
          SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:hasCacheData=" + bool + ".");
          ??? = this.server.getResponseHeaderField("cache-offline");
          if (!SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)???, this.server.getResponseHeaderFields())) {
            break label404;
          }
          if (!bool) {
            break;
          }
          switchState(1, 2, true);
          postTaskToSaveSonicCache(localCharSequence);
          return;
        }
        label404:
        SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") handleFlow_FirstLoad:offline->" + (String)??? + " , so do not need cache to file.");
      }
    }
  }
  
  protected void handleFlow_HttpError(int paramInt)
  {
    Iterator localIterator = this.sessionCallbackList.iterator();
    while (localIterator.hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)localIterator.next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSessionHttpError(paramInt);
      }
    }
  }
  
  protected void handleFlow_LoadLocalCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    synchronized (this.webResponseLock)
    {
      this.pendingWebResourceStream = new ByteArrayInputStream(paramString.getBytes());
      this.isCachePendingStream.set(true);
      switchState(1, 2, true);
      ??? = this.sessionCallbackList.iterator();
      while (((Iterator)???).hasNext())
      {
        SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)???).next()).get();
        if (localSonicSessionCallback != null) {
          localSonicSessionCallback.onSessionLoadLocalCache(paramString);
        }
      }
    }
  }
  
  protected void handleFlow_ServiceUnavailable()
  {
    Iterator localIterator = this.sessionCallbackList.iterator();
    while (localIterator.hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)localIterator.next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSessionUnAvailable();
      }
    }
  }
  
  /* Error */
  protected void handleFlow_TemplateChange(String paramString)
  {
    // Byte code:
    //   0: ldc 15
    //   2: iconst_4
    //   3: ldc_w 383
    //   6: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   12: lstore_2
    //   13: aload_1
    //   14: astore 4
    //   16: aload 4
    //   18: astore_1
    //   19: aload 4
    //   21: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +70 -> 94
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 88	com/tencent/sonic/sdk/StandardSonicSession:server	Lcom/tencent/sonic/sdk/SonicServer;
    //   32: aload_0
    //   33: getfield 386	com/tencent/sonic/sdk/StandardSonicSession:wasOnPageFinishInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   36: invokevirtual 345	com/tencent/sonic/sdk/SonicServer:getResponseStream	(Ljava/util/concurrent/atomic/AtomicBoolean;)Ljava/io/InputStream;
    //   39: putfield 273	com/tencent/sonic/sdk/StandardSonicSession:pendingWebResourceStream	Ljava/io/InputStream;
    //   42: aload_0
    //   43: getfield 273	com/tencent/sonic/sdk/StandardSonicSession:pendingWebResourceStream	Ljava/io/InputStream;
    //   46: ifnonnull +39 -> 85
    //   49: ldc 15
    //   51: bipush 6
    //   53: new 52	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   60: ldc 55
    //   62: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   69: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: ldc_w 388
    //   75: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: return
    //   85: aload_0
    //   86: getfield 88	com/tencent/sonic/sdk/StandardSonicSession:server	Lcom/tencent/sonic/sdk/SonicServer;
    //   89: iconst_0
    //   90: invokevirtual 94	com/tencent/sonic/sdk/SonicServer:getResponseData	(Z)Ljava/lang/String;
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 88	com/tencent/sonic/sdk/StandardSonicSession:server	Lcom/tencent/sonic/sdk/SonicServer;
    //   98: ldc 106
    //   100: invokevirtual 100	com/tencent/sonic/sdk/SonicServer:getResponseHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 4
    //   105: aload_0
    //   106: getfield 157	com/tencent/sonic/sdk/StandardSonicSession:mainHandler	Landroid/os/Handler;
    //   109: iconst_1
    //   110: invokevirtual 163	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   113: astore 6
    //   115: aload 6
    //   117: sipush 2000
    //   120: putfield 168	android/os/Message:arg2	I
    //   123: aload 6
    //   125: sipush 2000
    //   128: putfield 171	android/os/Message:arg1	I
    //   131: aload_0
    //   132: getfield 33	com/tencent/sonic/sdk/StandardSonicSession:webResponseLock	Ljava/lang/Object;
    //   135: astore 5
    //   137: aload 5
    //   139: monitorenter
    //   140: aload_0
    //   141: getfield 258	com/tencent/sonic/sdk/StandardSonicSession:wasInterceptInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   144: invokevirtual 260	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   147: ifne +214 -> 361
    //   150: aload_1
    //   151: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +162 -> 316
    //   157: aload 6
    //   159: sipush 304
    //   162: putfield 168	android/os/Message:arg2	I
    //   165: ldc 15
    //   167: iconst_4
    //   168: new 52	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   175: ldc 55
    //   177: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   184: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc_w 390
    //   190: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: getfield 40	com/tencent/sonic/sdk/StandardSonicSession:isCachePendingStream	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   203: iconst_0
    //   204: invokevirtual 276	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   207: aload 5
    //   209: monitorexit
    //   210: aload_0
    //   211: getfield 157	com/tencent/sonic/sdk/StandardSonicSession:mainHandler	Landroid/os/Handler;
    //   214: aload 6
    //   216: invokevirtual 179	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   219: pop
    //   220: aload_0
    //   221: getfield 183	com/tencent/sonic/sdk/StandardSonicSession:sessionCallbackList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   224: invokevirtual 189	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   227: astore 5
    //   229: aload 5
    //   231: invokeinterface 195 1 0
    //   236: ifeq +171 -> 407
    //   239: aload 5
    //   241: invokeinterface 199 1 0
    //   246: checkcast 201	java/lang/ref/WeakReference
    //   249: invokevirtual 204	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   252: checkcast 206	com/tencent/sonic/sdk/SonicSessionCallback
    //   255: astore 6
    //   257: aload 6
    //   259: ifnull -30 -> 229
    //   262: aload 6
    //   264: aload_1
    //   265: invokeinterface 393 2 0
    //   270: goto -41 -> 229
    //   273: astore_1
    //   274: ldc 15
    //   276: iconst_3
    //   277: new 52	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   284: ldc 55
    //   286: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   293: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc_w 395
    //   299: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: invokevirtual 214	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: return
    //   316: ldc 15
    //   318: bipush 6
    //   320: new 52	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   327: ldc 55
    //   329: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   336: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc_w 397
    //   342: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 5
    //   353: monitorexit
    //   354: return
    //   355: astore_1
    //   356: aload 5
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    //   361: aload 4
    //   363: invokestatic 151	com/tencent/sonic/sdk/SonicUtils:needRefreshPage	(Ljava/lang/String;)Z
    //   366: ifeq +30 -> 396
    //   369: new 131	android/os/Bundle
    //   372: dup
    //   373: invokespecial 132	android/os/Bundle:<init>	()V
    //   376: astore 7
    //   378: aload 7
    //   380: ldc 18
    //   382: iconst_1
    //   383: invokevirtual 401	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   386: aload 6
    //   388: aload 7
    //   390: invokevirtual 175	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   393: goto -194 -> 199
    //   396: aload 6
    //   398: sipush 304
    //   401: putfield 168	android/os/Message:arg2	I
    //   404: goto -205 -> 199
    //   407: iconst_3
    //   408: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:shouldLog	(I)Z
    //   411: ifeq +61 -> 472
    //   414: ldc 15
    //   416: iconst_3
    //   417: new 52	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   424: ldc 55
    //   426: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   433: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   436: ldc_w 403
    //   439: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   445: lload_2
    //   446: lsub
    //   447: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: ldc_w 405
    //   453: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_0
    //   457: getfield 258	com/tencent/sonic/sdk/StandardSonicSession:wasInterceptInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   460: invokevirtual 260	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   463: invokevirtual 361	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_0
    //   473: getfield 286	com/tencent/sonic/sdk/StandardSonicSession:config	Lcom/tencent/sonic/sdk/SonicSessionConfig;
    //   476: getfield 292	com/tencent/sonic/sdk/SonicSessionConfig:SUPPORT_CACHE_CONTROL	Z
    //   479: aload 4
    //   481: aload_0
    //   482: getfield 88	com/tencent/sonic/sdk/StandardSonicSession:server	Lcom/tencent/sonic/sdk/SonicServer;
    //   485: invokevirtual 296	com/tencent/sonic/sdk/SonicServer:getResponseHeaderFields	()Ljava/util/Map;
    //   488: invokestatic 300	com/tencent/sonic/sdk/SonicUtils:needSaveData	(ZLjava/lang/String;Ljava/util/Map;)Z
    //   491: ifeq +24 -> 515
    //   494: aload_0
    //   495: iconst_1
    //   496: iconst_2
    //   497: iconst_1
    //   498: invokevirtual 309	com/tencent/sonic/sdk/StandardSonicSession:switchState	(IIZ)Z
    //   501: pop
    //   502: aload_1
    //   503: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   506: ifne +82 -> 588
    //   509: aload_0
    //   510: aload_1
    //   511: invokevirtual 364	com/tencent/sonic/sdk/StandardSonicSession:postTaskToSaveSonicCache	(Ljava/lang/String;)V
    //   514: return
    //   515: ldc_w 407
    //   518: aload 4
    //   520: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   523: ifeq +20 -> 543
    //   526: aload_0
    //   527: getfield 125	com/tencent/sonic/sdk/StandardSonicSession:id	Ljava/lang/String;
    //   530: invokestatic 305	com/tencent/sonic/sdk/SonicUtils:removeSessionCache	(Ljava/lang/String;)V
    //   533: ldc 15
    //   535: iconst_4
    //   536: ldc_w 413
    //   539: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: return
    //   543: ldc 15
    //   545: iconst_4
    //   546: new 52	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   553: ldc 55
    //   555: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_0
    //   559: getfield 63	com/tencent/sonic/sdk/StandardSonicSession:sId	J
    //   562: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: ldc_w 415
    //   568: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 4
    //   573: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 368
    //   579: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 78	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	StandardSonicSession
    //   0	589	1	paramString	String
    //   12	434	2	l	long
    //   14	558	4	str	String
    //   113	284	6	localObject2	Object
    //   376	13	7	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   0	13	273	java/lang/Throwable
    //   19	84	273	java/lang/Throwable
    //   85	94	273	java/lang/Throwable
    //   94	140	273	java/lang/Throwable
    //   210	229	273	java/lang/Throwable
    //   229	257	273	java/lang/Throwable
    //   262	270	273	java/lang/Throwable
    //   359	361	273	java/lang/Throwable
    //   407	472	273	java/lang/Throwable
    //   472	514	273	java/lang/Throwable
    //   515	542	273	java/lang/Throwable
    //   543	588	273	java/lang/Throwable
    //   140	199	355	finally
    //   199	210	355	finally
    //   316	354	355	finally
    //   356	359	355	finally
    //   361	393	355	finally
    //   396	404	355	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (super.handleMessage(paramMessage)) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    default: 
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_StandardSonicSession", 3, "session(" + this.sId + ") can not  recognize refresh type: " + paramMessage.what);
      }
      return false;
    case 5: 
      this.sessionClient.loadUrl(this.srcUrl, new Bundle());
      return true;
    case 1: 
      if (paramMessage.arg2 == 200) {
        this.pendingDiffData = paramMessage.getData().getString("_diff_data_");
      }
      for (;;)
      {
        setResult(paramMessage.arg1, paramMessage.arg2, true);
        return true;
        if ((paramMessage.arg2 == 2000) && (paramMessage.getData().getBoolean("refresh", false)))
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleClientCoreMessage_TemplateChange:load url with preload=2, webCallback is null? ->");
          if (this.diffDataCallback != null) {
            bool = true;
          }
          SonicUtils.log("SonicSdk_StandardSonicSession", 4, bool);
          this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, "_preload", "2");
          this.sessionClient.loadUrl(this.currUrl, null);
        }
      }
    }
    this.diffDataCallback = ((SonicDiffDataCallback)paramMessage.obj);
    setResult(this.srcResultCode, this.finalResultCode, true);
    return true;
  }
  
  public boolean onClientReady()
  {
    if (this.sessionState.get() == 0) {
      start();
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      this.sessionClient.loadUrl(this.srcUrl, new Bundle());
    }
    for (;;)
    {
      return true;
      Message localMessage = this.mainHandler.obtainMessage(5);
      this.mainHandler.sendMessage(localMessage);
    }
  }
  
  protected Object onRequestResource(String arg1)
  {
    boolean bool = true;
    if (!isMatchCurrentUrl(???)) {
      return null;
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_StandardSonicSession", 3, "session(" + this.sId + ")  onClientRequestResource:url = " + ???);
    }
    this.wasInterceptInvoked.set(true);
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
            SonicUtils.log("SonicSdk_StandardSonicSession", 4, "session(" + this.sId + ") now wait for pendingWebResourceStream!");
            this.sessionState.wait(30000L);
          }
          ??? = new StringBuilder().append("session(").append(this.sId).append(") have pending stream? -> ");
          if (this.pendingWebResourceStream == null) {
            break label422;
          }
          SonicUtils.log("SonicSdk_StandardSonicSession", 4, bool + ", cost " + (System.currentTimeMillis() - l) + "ms.");
          synchronized (this.webResponseLock)
          {
            if (this.pendingWebResourceStream == null) {
              break;
            }
            if (isDestroyedOrWaitingForDestroy()) {
              break label444;
            }
            String str = SonicUtils.getMime(this.srcUrl);
            SonicRuntime localSonicRuntime = SonicEngine.getInstance().getRuntime();
            if (!this.isCachePendingStream.get()) {
              break label427;
            }
            ??? = SonicUtils.DEFAULT_CHARSET;
            InputStream localInputStream = this.pendingWebResourceStream;
            if (!this.isCachePendingStream.get()) {
              break label435;
            }
            HashMap localHashMap1 = getCacheHeaders();
            ??? = localSonicRuntime.createWebResourceResponse(str, ???, localInputStream, localHashMap1);
            this.pendingWebResourceStream = null;
            return ???;
          }
        }
        catch (Throwable localThrowable)
        {
          SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") wait for pendingWebResourceStream failed" + localThrowable.getMessage());
          continue;
        }
      }
      if (SonicUtils.shouldLog(3))
      {
        SonicUtils.log("SonicSdk_StandardSonicSession", 3, "session(" + this.sId + ") is not in running state: " + this.sessionState);
        continue;
        label422:
        bool = false;
        continue;
        label427:
        ??? = getCharsetFromHeaders();
        continue;
        label435:
        HashMap localHashMap2 = getHeaders();
        continue;
        label444:
        ??? = null;
        SonicUtils.log("SonicSdk_StandardSonicSession", 6, "session(" + this.sId + ") onClientRequestResource error: session is destroyed!");
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
      SonicUtils.log("SonicSdk_StandardSonicSession", 4, bool);
      if (this.diffDataCallback != null)
      {
        this.diffDataCallback = null;
        SonicUtils.log("SonicSdk_StandardSonicSession", 5, "session(" + this.sId + ") onWebReady: call more than once.");
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
 * Qualified Name:     com.tencent.sonic.sdk.StandardSonicSession
 * JD-Core Version:    0.7.0.1
 */