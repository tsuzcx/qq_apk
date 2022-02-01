package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.action.RepeatRequestEvent;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class JsPluginEngine
  extends BaseJsPluginEngine
{
  public static final String TAG = "JsPluginEngine[Dispatcher]";
  protected final Map<Class, IJsPlugin> mActivatedPlugins = new ConcurrentHashMap();
  private final Map<String, Class> mEventPluginMap = new HashMap();
  private final Map<String, Class> mSecondaryEventPluginMap = new HashMap();
  
  public JsPluginEngine(Context paramContext)
  {
    super(paramContext);
    fillEventPluginMap(this.mEventPluginMap, this.mSecondaryEventPluginMap);
  }
  
  private static String buildMessage(String paramString, RequestEvent paramRequestEvent)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("eventName=");
    paramString.append(paramRequestEvent.event);
    paramString.append(", ");
    paramString.append("jsonParams=");
    paramString.append(paramRequestEvent.jsonParams);
    paramString.append(", ");
    paramString.append("callbackId=");
    paramString.append(paramRequestEvent.callbackId);
    paramString.append("jsService=");
    paramString.append(paramRequestEvent.jsService);
    return paramString.toString();
  }
  
  /* Error */
  private IJsPlugin createJsPlugin(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 8
    //   11: ldc 94
    //   13: invokestatic 100	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getfield 32	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 106 2 0
    //   30: checkcast 108	com/tencent/qqmini/sdk/launcher/core/plugins/IJsPlugin
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: areturn
    //   42: aload_1
    //   43: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: instanceof 108
    //   51: ifeq +42 -> 93
    //   54: aload_2
    //   55: checkcast 108	com/tencent/qqmini/sdk/launcher/core/plugins/IJsPlugin
    //   58: astore_2
    //   59: aload_2
    //   60: aload_0
    //   61: getfield 92	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   64: invokeinterface 118 2 0
    //   69: aload_0
    //   70: getfield 32	com/tencent/qqmini/sdk/plugins/engine/JsPluginEngine:mActivatedPlugins	Ljava/util/Map;
    //   73: aload_1
    //   74: aload_2
    //   75: invokeinterface 122 3 0
    //   80: pop
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: areturn
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: astore_2
    //   90: goto +40 -> 130
    //   93: new 41	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   100: astore_1
    //   101: aload_1
    //   102: ldc 125
    //   104: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: aload_3
    //   110: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 8
    //   116: aload_1
    //   117: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 128	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_0
    //   124: monitorexit
    //   125: aconst_null
    //   126: areturn
    //   127: astore_2
    //   128: aload_3
    //   129: astore_1
    //   130: new 41	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   137: astore_3
    //   138: aload_3
    //   139: ldc 130
    //   141: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: aload_1
    //   147: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 8
    //   153: aload_3
    //   154: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_2
    //   158: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_0
    //   162: monitorexit
    //   163: aconst_null
    //   164: areturn
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	JsPluginEngine
    //   0	170	1	paramClass	Class
    //   46	44	2	localObject	java.lang.Object
    //   127	31	2	localException1	java.lang.Exception
    //   33	8	3	localIJsPlugin	IJsPlugin
    //   85	44	3	localException2	java.lang.Exception
    //   137	17	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	81	85	java/lang/Exception
    //   42	59	127	java/lang/Exception
    //   93	123	127	java/lang/Exception
    //   2	16	165	finally
    //   20	34	165	finally
    //   42	59	165	finally
    //   59	81	165	finally
    //   93	123	165	finally
    //   130	161	165	finally
  }
  
  protected String dispatchRequestEvent(RequestEvent paramRequestEvent)
  {
    IJsPlugin localIJsPlugin = getEventHandler(paramRequestEvent.event);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, event not support! ", paramRequestEvent));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(paramRequestEvent))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, event is intercepted. ", paramRequestEvent));
      return "";
    }
    reportApiInvoke(this.mMiniAppContext.getMiniAppInfo(), paramRequestEvent.event);
    return dispatchRequestEventToPlugin(paramRequestEvent, localIJsPlugin);
  }
  
  protected abstract String dispatchRequestEventToPlugin(RequestEvent paramRequestEvent, IJsPlugin paramIJsPlugin);
  
  public String dispatchSecondaryRequestEvent(RepeatRequestEvent paramRepeatRequestEvent)
  {
    IJsPlugin localIJsPlugin = getSecondaryEventHandler(paramRepeatRequestEvent.event);
    if (localIJsPlugin == null)
    {
      QMLog.w("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest failed, secondary event not support! ", paramRepeatRequestEvent));
      return "";
    }
    if (localIJsPlugin.onInterceptJsEvent(paramRepeatRequestEvent))
    {
      QMLog.i("JsPluginEngine[Dispatcher]", buildMessage("handleNativeRequest aborted, secondary event is intercepted. ", paramRepeatRequestEvent));
      return "";
    }
    return dispatchRequestEventToPlugin(paramRepeatRequestEvent, localIJsPlugin);
  }
  
  abstract void fillEventPluginMap(Map<String, Class> paramMap1, Map<String, Class> paramMap2);
  
  protected final IJsPlugin getEventHandler(String paramString)
  {
    paramString = (Class)this.mEventPluginMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    IJsPlugin localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(paramString);
    if (localIJsPlugin != null) {
      return localIJsPlugin;
    }
    return createJsPlugin(paramString);
  }
  
  protected final IJsPlugin getSecondaryEventHandler(String paramString)
  {
    paramString = (Class)this.mSecondaryEventPluginMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    IJsPlugin localIJsPlugin = (IJsPlugin)this.mActivatedPlugins.get(paramString);
    if (localIJsPlugin != null) {
      return localIJsPlugin;
    }
    return createJsPlugin(paramString);
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = JsPluginList.getPreloadPlugins(paramIMiniAppContext.isMiniGame()).iterator();
    while (paramIMiniAppContext.hasNext()) {
      createJsPlugin((Class)paramIMiniAppContext.next());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onDestroy();
    }
    this.mActivatedPlugins.clear();
    this.mEventPluginMap.clear();
    this.mSecondaryEventPluginMap.clear();
    JsPluginList.clear();
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.mActivatedPlugins.values().iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onResume();
    }
  }
  
  public void reportApiInvoke(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.executeOnComputationThreadPool(new JsPluginEngine.1(this, paramString, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
 * JD-Core Version:    0.7.0.1
 */