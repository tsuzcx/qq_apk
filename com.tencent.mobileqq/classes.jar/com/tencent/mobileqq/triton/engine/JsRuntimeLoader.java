package com.tencent.mobileqq.triton.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsRuntimeLoader
{
  private static final String DEFAULT_GLOBAL_CONFIG = "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = 'wxfile://usr';\n__wxConfig.platform = 'android';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  public static final String DEFAULT_PRELOAD_JS_MAIN = "QGame.js";
  public static final String DEFAULT_PRELOAD_JS_OPENDATA = "QGameOpenDataContext.js";
  public static final String DEFAULT_PRELOAD_JS_WORKER = "QGameWorkerContext.js";
  public static final String GAME_DEBUG_PATH = "/game";
  public static final String GAME_PLUGIN_DEBUG_PATH = "/game_plugin";
  public static final String GAME_PRELOAD_DEBUG_PATH = "/game_preload";
  private static final String JS_CONFIG = "preload.json";
  private static final String TAG = "JsRuntimeLoader";
  private static final String TAG_MAIN_PRE_JS = "preloadJS";
  private static final String TAG_OPENDATA_PRE_JS = "preloadJSForOpendata";
  private static JsRuntimeLoader.JsRuntimeConfigs defaultConfig = new JsRuntimeLoader.JsRuntimeConfigs();
  private String GLOBAL_CONFIG;
  private volatile boolean bInitJsRuntime = false;
  private volatile boolean bPreload = false;
  private final ConcurrentHashMap<String, String> mJsStrCache;
  private JsRuntimeLoader.JsRuntimeConfigs mRuntimeConfig;
  private TTEngine mTritonEngine;
  
  static
  {
    defaultConfig.mainList = new String[] { "QGame.js" };
    defaultConfig.openDataList = new String[] { "QGameOpenDataContext.js" };
  }
  
  public JsRuntimeLoader(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
    this.mJsStrCache = new ConcurrentHashMap();
  }
  
  private void collectJsFile(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!this.mJsStrCache.containsKey(paramString1)))
    {
      paramString2 = new File(paramString2, paramString1);
      if (!paramString2.exists()) {
        TTLog.e("JsRuntimeLoader", "prepare js error, get js " + paramString1 + " file is not exist");
      }
    }
    else
    {
      return;
    }
    TTLog.i("JsRuntimeLoader", "prepare js collect " + paramString1);
    this.mJsStrCache.put(paramString1, paramString2.getAbsolutePath());
  }
  
  private JsRuntimeLoader.JsRuntimeConfigs getRuntimeConfig(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      TTLog.e("JsRuntimeLoader", "getRuntimeConfig error, runtimeLibDir: " + paramString);
      return null;
    }
    paramString = this.mTritonEngine.getQQEnv().readFileToString(new File(paramString, "preload.json"));
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new JsRuntimeLoader.JsRuntimeConfigs();
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("preloadJS");
        paramString.mainList = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          paramString.mainList[i] = localJSONArray.getString(i);
          i += 1;
        }
        localObject = ((JSONObject)localObject).getJSONArray("preloadJSForOpendata");
        paramString.openDataList = new String[((JSONArray)localObject).length()];
        i = j;
        while (i < ((JSONArray)localObject).length())
        {
          paramString.openDataList[i] = ((JSONArray)localObject).getString(i);
          i += 1;
        }
        TTLog.i("JsRuntimeLoader", "getRuntimeConfig success, mainInjectJs " + Arrays.toString(paramString.mainList) + ", openDataInjectJs " + Arrays.toString(paramString.openDataList));
        return paramString;
      }
      catch (Throwable paramString)
      {
        TTLog.e("JsRuntimeLoader", "getRuntimeConfig exception, load default config, exception:", paramString);
        return defaultConfig;
      }
    }
    TTLog.i("JsRuntimeLoader", "getRuntimeConfig preloadConfig empty, load default config, mainInjectJs " + Arrays.toString(defaultConfig.mainList) + ", openDataInjectJs " + Arrays.toString(defaultConfig.openDataList));
    return defaultConfig;
  }
  
  private void injectGlobalConfig(int paramInt)
  {
    if (TextUtils.isEmpty(this.GLOBAL_CONFIG)) {
      if (this.mTritonEngine.getQQEnv() == null) {
        break label56;
      }
    }
    label56:
    for (String str = this.mTritonEngine.getQQEnv().getGlobalConfig();; str = "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = 'wxfile://usr';\n__wxConfig.platform = 'android';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n")
    {
      this.GLOBAL_CONFIG = str;
      this.mTritonEngine.getJsRuntime(paramInt).evaluateJs(this.GLOBAL_CONFIG);
      return;
    }
  }
  
  public boolean collectJsFileToPreload()
  {
    if (this.bPreload)
    {
      TTLog.w("JsRuntimeLoader", "already has preload js, return directly");
      return true;
    }
    try
    {
      String str = this.mTritonEngine.getQQEnv().getBaseEnginePath();
      TTLog.i("JsRuntimeLoader", "preload js, use runtimeLibPath " + str);
      Object localObject = getRuntimeConfig(str);
      if ((localObject == null) || (((JsRuntimeLoader.JsRuntimeConfigs)localObject).mainList == null) || (((JsRuntimeLoader.JsRuntimeConfigs)localObject).mainList.length == 0) || (((JsRuntimeLoader.JsRuntimeConfigs)localObject).openDataList == null) || (((JsRuntimeLoader.JsRuntimeConfigs)localObject).openDataList.length == 0))
      {
        TTLog.e("JsRuntimeLoader", "init js runtime, get mRuntimeConfig error");
        return false;
      }
      this.mRuntimeConfig = ((JsRuntimeLoader.JsRuntimeConfigs)localObject);
      String[] arrayOfString = ((JsRuntimeLoader.JsRuntimeConfigs)localObject).mainList;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        collectJsFile(arrayOfString[i], str);
        i += 1;
      }
      localObject = ((JsRuntimeLoader.JsRuntimeConfigs)localObject).openDataList;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        collectJsFile(localObject[i], str);
        i += 1;
      }
      this.bPreload = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("JsRuntimeLoader", "preload js error", localThrowable);
    }
    return false;
  }
  
  public boolean initJsRuntime()
  {
    if (this.bInitJsRuntime)
    {
      TTLog.w("JsRuntimeLoader", "already has init js runtime, return directly");
      return true;
    }
    collectJsFileToPreload();
    if ((this.mRuntimeConfig == null) || (this.mRuntimeConfig.mainList == null) || (this.mRuntimeConfig.mainList.length == 0) || (this.mRuntimeConfig.openDataList == null) || (this.mRuntimeConfig.openDataList.length == 0))
    {
      TTLog.e("JsRuntimeLoader", "init js runtime, get mRuntimeConfig error");
      return false;
    }
    injectGlobalConfig(1);
    String str1 = "/game_preload" + File.separator;
    String[] arrayOfString = this.mRuntimeConfig.mainList;
    int j = arrayOfString.length;
    int i = 0;
    String str2;
    String str3;
    while (i < j)
    {
      str2 = arrayOfString[i];
      str3 = (String)this.mJsStrCache.get(str2);
      if (str3 != null)
      {
        this.mTritonEngine.loadScriptPathWithCodeCache(1, str3, str1 + str2, str3 + ".cc");
        i += 1;
      }
      else
      {
        TTLog.e("JsRuntimeLoader", "inject mainContext js error, mJsStrs Cache do not have " + str2);
        return false;
      }
    }
    injectGlobalConfig(2);
    arrayOfString = this.mRuntimeConfig.openDataList;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      str2 = arrayOfString[i];
      str3 = (String)this.mJsStrCache.get(str2);
      if (str3 != null)
      {
        this.mTritonEngine.loadScriptPathWithCodeCache(2, str3, str1 + str2, str3 + ".cc");
        i += 1;
      }
      else
      {
        TTLog.e("JsRuntimeLoader", "inject openDataContext js error, mJsStrs Cache do not have " + str2);
        return false;
      }
    }
    this.mJsStrCache.clear();
    this.bInitJsRuntime = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JsRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */