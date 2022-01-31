package com.tencent.mobileqq.minigame.jsapi;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class GameJsPluginEngine
  extends BaseJsPluginEngine
  implements IJSEngine
{
  private static final String TAG = "GameJsPluginEngine";
  private volatile boolean hasInit;
  private volatile boolean hasInitPlugins;
  private ITTEngine mTTEngine = GameLoadManager.g().getGameEngine();
  private Map<Integer, GameJsRuntime> runtimeMap = new HashMap();
  
  private void registComponentCallback()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      BaseApplication.getContext().getApplicationContext().registerComponentCallbacks(new GameJsPluginEngine.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void callJsApi(String paramString, JSONObject paramJSONObject)
  {
    GameJsRuntime localGameJsRuntime = getGameJsRuntime(1);
    if (paramJSONObject == null) {}
    for (paramJSONObject = "";; paramJSONObject = paramJSONObject.toString())
    {
      localGameJsRuntime.evaluateSubcribeJS(paramString, paramJSONObject, -1);
      return;
    }
  }
  
  public void callbackJsEventCancel(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJsRuntime != null)
    {
      paramString = ApiUtil.wrapCallbackCancel(paramString, paramJSONObject);
      if (paramString == null) {
        break label29;
      }
    }
    label29:
    for (paramString = paramString.toString();; paramString = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramJsRuntime, paramString, paramJSONObject, null, paramInt);
  }
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramJsRuntime != null)
    {
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2);
      if (paramString1 == null) {
        break label31;
      }
    }
    label31:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1);
      return;
    }
  }
  
  public void callbackJsEventOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    super.callbackJsEventOK(paramJsRuntime, paramString, paramJSONObject, paramInt);
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public boolean canHandleEvent(String paramString)
  {
    return getEventHandler(paramString) != null;
  }
  
  public GameJsRuntime getGameJsRuntime(int paramInt)
  {
    if (this.runtimeMap.get(Integer.valueOf(paramInt)) != null) {
      return (GameJsRuntime)this.runtimeMap.get(Integer.valueOf(paramInt));
    }
    GameJsRuntime localGameJsRuntime = new GameJsRuntime(this.mTTEngine, paramInt);
    this.runtimeMap.put(Integer.valueOf(paramInt), localGameJsRuntime);
    return localGameJsRuntime;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.runtimeMap.get(Integer.valueOf(paramInt)) != null) {
      return ((GameJsRuntime)this.runtimeMap.get(Integer.valueOf(paramInt))).getRealRuntime();
    }
    return null;
  }
  
  public JsRuntime getServiceRuntime()
  {
    return getGameJsRuntime(1);
  }
  
  public boolean hasInit()
  {
    return this.hasInit;
  }
  
  public void init()
  {
    super.init();
    this.mTTEngine.setJsEngine(this);
    initJsPluginList();
    registComponentCallback();
    this.hasInit = true;
  }
  
  /* Error */
  public void initJsPluginList()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 173	com/tencent/mobileqq/minigame/jsapi/GameJsPluginEngine:hasInitPlugins	Z
    //   6: ifeq +17 -> 23
    //   9: invokestatic 179	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   12: ldc 10
    //   14: ldc 181
    //   16: invokevirtual 185	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 179	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   26: ldc 10
    //   28: ldc 186
    //   30: invokevirtual 185	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   33: pop
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 173	com/tencent/mobileqq/minigame/jsapi/GameJsPluginEngine:hasInitPlugins	Z
    //   39: new 188	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 189	java/util/ArrayList:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: new 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin
    //   51: dup
    //   52: invokespecial 192	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:<init>	()V
    //   55: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_1
    //   60: new 198	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin
    //   63: dup
    //   64: invokespecial 199	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:<init>	()V
    //   67: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   70: pop
    //   71: aload_1
    //   72: new 201	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NetworkJsPlugin
    //   75: dup
    //   76: invokespecial 202	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NetworkJsPlugin:<init>	()V
    //   79: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_1
    //   84: new 204	com/tencent/mobileqq/minigame/jsapi/plugins/UDPPlugin
    //   87: dup
    //   88: invokespecial 205	com/tencent/mobileqq/minigame/jsapi/plugins/UDPPlugin:<init>	()V
    //   91: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload_1
    //   96: new 207	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin
    //   99: dup
    //   100: invokespecial 208	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:<init>	()V
    //   103: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_1
    //   108: new 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ScreenJsPlugin
    //   111: dup
    //   112: invokespecial 211	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ScreenJsPlugin:<init>	()V
    //   115: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload_1
    //   120: new 213	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BatteryJsPlugin
    //   123: dup
    //   124: invokespecial 214	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BatteryJsPlugin:<init>	()V
    //   127: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: aload_1
    //   132: new 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ClipboardJsPlugin
    //   135: dup
    //   136: invokespecial 217	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ClipboardJsPlugin:<init>	()V
    //   139: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: aload_1
    //   144: new 219	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/FileJsPlugin
    //   147: dup
    //   148: invokespecial 220	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/FileJsPlugin:<init>	()V
    //   151: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: aload_1
    //   156: new 222	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SensorJsPlugin
    //   159: dup
    //   160: invokespecial 223	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SensorJsPlugin:<init>	()V
    //   163: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_1
    //   168: new 225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/StoragePlugin
    //   171: dup
    //   172: invokespecial 226	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/StoragePlugin:<init>	()V
    //   175: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   178: pop
    //   179: aload_1
    //   180: new 228	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OuterJsPlugin
    //   183: dup
    //   184: invokespecial 229	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OuterJsPlugin:<init>	()V
    //   187: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: aload_1
    //   192: new 231	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NavigationPlugin
    //   195: dup
    //   196: invokespecial 232	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NavigationPlugin:<init>	()V
    //   199: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   202: pop
    //   203: aload_1
    //   204: new 234	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin
    //   207: dup
    //   208: invokespecial 235	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin:<init>	()V
    //   211: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   214: pop
    //   215: aload_1
    //   216: new 237	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin
    //   219: dup
    //   220: invokespecial 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:<init>	()V
    //   223: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_1
    //   228: new 240	com/tencent/mobileqq/minigame/jsapi/plugins/InputPlugin
    //   231: dup
    //   232: invokespecial 241	com/tencent/mobileqq/minigame/jsapi/plugins/InputPlugin:<init>	()V
    //   235: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   238: pop
    //   239: aload_1
    //   240: new 243	com/tencent/mobileqq/minigame/jsapi/plugins/OrientationPlugin
    //   243: dup
    //   244: invokespecial 244	com/tencent/mobileqq/minigame/jsapi/plugins/OrientationPlugin:<init>	()V
    //   247: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload_1
    //   252: new 246	com/tencent/mobileqq/minigame/jsapi/plugins/OpenDataPlugin
    //   255: dup
    //   256: invokespecial 247	com/tencent/mobileqq/minigame/jsapi/plugins/OpenDataPlugin:<init>	()V
    //   259: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: aload_1
    //   264: new 249	com/tencent/mobileqq/minigame/jsapi/plugins/VideoPlugin
    //   267: dup
    //   268: invokespecial 250	com/tencent/mobileqq/minigame/jsapi/plugins/VideoPlugin:<init>	()V
    //   271: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: aload_1
    //   276: new 252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ReportJsPlugin
    //   279: dup
    //   280: invokespecial 253	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ReportJsPlugin:<init>	()V
    //   283: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_1
    //   288: new 255	com/tencent/mobileqq/minigame/jsapi/plugins/ReportPlugin
    //   291: dup
    //   292: invokespecial 256	com/tencent/mobileqq/minigame/jsapi/plugins/ReportPlugin:<init>	()V
    //   295: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   298: pop
    //   299: aload_1
    //   300: new 258	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SchemeJsPlugin
    //   303: dup
    //   304: invokespecial 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SchemeJsPlugin:<init>	()V
    //   307: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload_1
    //   312: new 261	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/LogJsPlugin
    //   315: dup
    //   316: invokespecial 262	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/LogJsPlugin:<init>	()V
    //   319: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload_1
    //   324: new 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPJsPlugin
    //   327: dup
    //   328: invokespecial 265	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPJsPlugin:<init>	()V
    //   331: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: aload_1
    //   336: new 267	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin
    //   339: dup
    //   340: invokespecial 268	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:<init>	()V
    //   343: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: aload_1
    //   348: new 270	com/tencent/mobileqq/minigame/jsapi/plugins/ImmersivePlugin
    //   351: dup
    //   352: invokespecial 271	com/tencent/mobileqq/minigame/jsapi/plugins/ImmersivePlugin:<init>	()V
    //   355: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   358: pop
    //   359: aload_1
    //   360: new 273	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ImageJsPlugin
    //   363: dup
    //   364: invokespecial 274	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ImageJsPlugin:<init>	()V
    //   367: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   370: pop
    //   371: aload_1
    //   372: new 276	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin
    //   375: dup
    //   376: invokespecial 277	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin:<init>	()V
    //   379: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   382: pop
    //   383: aload_1
    //   384: new 279	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/MapJsPlugin
    //   387: dup
    //   388: invokespecial 280	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/MapJsPlugin:<init>	()V
    //   391: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   394: pop
    //   395: aload_1
    //   396: new 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/PayJsPlugin
    //   399: dup
    //   400: invokespecial 283	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/PayJsPlugin:<init>	()V
    //   403: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   406: pop
    //   407: aload_1
    //   408: new 285	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ContactJsPlugin
    //   411: dup
    //   412: invokespecial 286	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/ContactJsPlugin:<init>	()V
    //   415: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: aload_1
    //   420: new 288	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/QQFriendsJsPlugin
    //   423: dup
    //   424: invokespecial 289	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/QQFriendsJsPlugin:<init>	()V
    //   427: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   430: pop
    //   431: aload_1
    //   432: new 291	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin
    //   435: dup
    //   436: invokespecial 292	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:<init>	()V
    //   439: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   442: pop
    //   443: aload_1
    //   444: new 294	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppBoxPlugin
    //   447: dup
    //   448: invokespecial 295	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppBoxPlugin:<init>	()V
    //   451: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   454: pop
    //   455: aload_1
    //   456: new 297	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NativeFeatureJsPlugin
    //   459: dup
    //   460: invokespecial 298	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/NativeFeatureJsPlugin:<init>	()V
    //   463: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   466: pop
    //   467: aload_1
    //   468: new 300	com/tencent/mobileqq/minigame/jsapi/plugins/UpdateManagerPlugin
    //   471: dup
    //   472: invokespecial 301	com/tencent/mobileqq/minigame/jsapi/plugins/UpdateManagerPlugin:<init>	()V
    //   475: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   478: pop
    //   479: aload_1
    //   480: new 303	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SubpackageJsPlugin
    //   483: dup
    //   484: invokespecial 304	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/SubpackageJsPlugin:<init>	()V
    //   487: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   490: pop
    //   491: aload_1
    //   492: new 306	com/tencent/mobileqq/minigame/jsapi/plugins/WebAudioPlugin
    //   495: dup
    //   496: invokespecial 307	com/tencent/mobileqq/minigame/jsapi/plugins/WebAudioPlugin:<init>	()V
    //   499: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   502: pop
    //   503: aload_1
    //   504: new 309	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InterstitialAdPlugin
    //   507: dup
    //   508: invokespecial 310	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InterstitialAdPlugin:<init>	()V
    //   511: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   514: pop
    //   515: aload_0
    //   516: aload_1
    //   517: invokevirtual 314	com/tencent/mobileqq/minigame/jsapi/GameJsPluginEngine:registerPlugins	(Ljava/util/ArrayList;)V
    //   520: goto -500 -> 20
    //   523: astore_1
    //   524: aload_0
    //   525: monitorexit
    //   526: aload_1
    //   527: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	GameJsPluginEngine
    //   46	471	1	localArrayList	java.util.ArrayList
    //   523	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	523	finally
    //   23	520	523	finally
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.hasInit = false;
    this.hasInitPlugins = false;
    if (this.runtimeMap != null)
    {
      QLog.e("[minigame] GameJsPluginEngine", 1, "onDestroy clear runtimeMap");
      this.runtimeMap.clear();
    }
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (getGameJsRuntime(paramInt2) != null) {}
    for (paramString1 = handleNativeRequest(paramString1, paramString2, getGameJsRuntime(paramInt2), paramInt1);; paramString1 = localObject)
    {
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = "{}";
      }
      return paramString2;
      QLog.e("GameJsPluginEngine", 1, "onScriptCall on null gameJsRuntime, eventName:" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */