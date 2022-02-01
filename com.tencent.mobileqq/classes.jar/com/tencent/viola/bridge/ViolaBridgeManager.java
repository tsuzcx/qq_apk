package com.tencent.viola.bridge;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.commons.ViolaThread;
import com.tencent.viola.core.ViolaBridge;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKEngine.InitCallback;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.module.DomModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBridgeManager
  implements Handler.Callback
{
  public static final int JS_EXCE_SUCC = 1;
  public static final String METHD_FIRE_EVENT_SYNC = "fireEventSync";
  public static final String METHOD_CALLBACK = "callback";
  public static final String METHOD_CREATE_INSTANCE = "createInstance";
  public static final String METHOD_DESTROY_INSTANCE = "destroyInstance";
  public static final String METHOD_FIRE_EVENT = "fireEvent";
  public static final String METHOD_NAME_JS_REGISTER_MODULES = "registerModules";
  public static final String METHOD_REGISTER_COMPONENT = "registerComponent";
  public static String TAG = "ViolaBridgeManager";
  private static final Object mLock = new Object();
  static volatile ViolaBridgeManager mViolaBridgeManager;
  private ViolaBridge mBridge = new ViolaBridge();
  private volatile boolean mInit = false;
  Handler mJSHandler = this.mJSThread.getHandler();
  private ViolaThread mJSThread = new ViolaThread("ViolaJSBridgeThread", this);
  StringBuilder mLogBuilder = new StringBuilder(50);
  private String mRefreshRef;
  private List<Map<String, Object>> mRegisterComponentFailList = new ArrayList(8);
  private List<Map<String, Object>> mRegisterModuleFailList = new ArrayList(8);
  
  private void addJSEventTask(String paramString1, String paramString2, List<Object> paramList, Object... paramVarArgs) {}
  
  private void addJSTask(String paramString1, String paramString2, Object... paramVarArgs)
  {
    addJSEventTask(paramString1, paramString2, null, paramVarArgs);
  }
  
  private void createInstanceImpl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (ViolaEnvironment.isDebugable())
    {
      this.mLogBuilder.append("createInstance >>>> instanceId:").append(paramString1).append("template:").append(paramString2);
      this.mLogBuilder.append(" data:").append(paramString3);
      ViolaLogUtils.d(TAG, this.mLogBuilder.substring(0));
      this.mLogBuilder.setLength(0);
    }
    if (TextUtils.isEmpty(paramString2)) {
      ViolaLogUtils.e(TAG, "violaInstance createInstanceImpl template null!");
    }
    do
    {
      return;
      ViolaModuleManager.createDomModule(ViolaSDKManager.getInstance().getViolaInstance(paramString1));
      if (Thread.currentThread().getName().equals("ViolaJSBridgeThread"))
      {
        ViolaLogUtils.e(TAG, "violaInstance createInstanceImpl ViolaJSBridgeThread start!");
        paramString4 = this.mBridge;
        byte[] arrayOfByte = paramString2.getBytes();
        int i = paramString2.getBytes().length;
        if (TextUtils.isEmpty(paramString3)) {}
        for (paramString2 = "";; paramString2 = paramString3)
        {
          paramString4.createInstance(paramString1, arrayOfByte, i, paramString2, "");
          return;
        }
      }
      post(new ViolaBridgeManager.5(this, paramString1, paramString2, paramString3), paramString1);
      ViolaLogUtils.e(TAG, "violaInstance createInstanceImpl end!");
    } while (TextUtils.isEmpty(paramString4));
    this.mBridge.preloadTest(paramString1, paramString4);
  }
  
  public static ViolaBridgeManager getInstance()
  {
    if (mViolaBridgeManager == null) {}
    try
    {
      if (mViolaBridgeManager == null) {
        mViolaBridgeManager = new ViolaBridgeManager();
      }
      return mViolaBridgeManager;
    }
    finally {}
  }
  
  private void initFrameworkLocalPathImpl(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ViolaUtils.readFile(new File(paramString1));
      if (!TextUtils.isEmpty(paramString1)) {
        break label43;
      }
      if (paramInitCallback != null) {
        paramInitCallback.onFinish(101, 0L, "mainjs error");
      }
    }
    return;
    label43:
    initFrameworkStringImpl(paramString1, paramInitCallback, paramString2);
  }
  
  private void initFrameworkStringImpl(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (!isJSFrameworkInit())
    {
      this.mBridge.init();
      l = System.currentTimeMillis();
      if (!TextUtils.isEmpty(paramString1)) {
        if (1 == this.mBridge.initJsFramework(paramString1.getBytes(), paramString1.getBytes().length, paramString2))
        {
          ViolaSDKEngine.registerBase();
          setJSFrameworkInit(true);
          paramInitCallback.onFinish(0, System.currentTimeMillis() - l, "");
        }
      }
    }
    while (paramInitCallback == null)
    {
      do
      {
        long l;
        do
        {
          return;
        } while (paramInitCallback == null);
        paramInitCallback.onFinish(102, 0L, "mainjs error");
        return;
      } while (paramInitCallback == null);
      paramInitCallback.onFinish(101, 0L, "mainjs had inited");
      return;
    }
    paramInitCallback.onFinish(1, 0L, "mainjs had inited");
  }
  
  private void invokeDestroyInstance(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mJSHandler == null)) {
      return;
    }
    try
    {
      if (ViolaEnvironment.isDebugable()) {
        ViolaLogUtils.d(TAG, "destroyInstance >>>> instanceId:" + paramString);
      }
      this.mBridge.destroyInstance(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString = "[BridgeManager] invokeDestroyInstance " + paramString.getCause();
      ViolaLogUtils.e(TAG, paramString);
    }
  }
  
  private void invokeExecJS(String paramString1, String paramString2)
  {
    invokeExecJS(paramString1, paramString2, true);
  }
  
  private void invokeExecJS(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (ViolaEnvironment.isDebugable())
    {
      this.mLogBuilder.append("callJS >>>> instanceId:").append(paramString1).append("function:").append(paramString2.toString());
      if (paramBoolean) {
        this.mLogBuilder.append(" tasks:").append(paramString2);
      }
      ViolaLogUtils.d(TAG, this.mLogBuilder.substring(0));
      this.mLogBuilder.setLength(0);
    }
    if (!this.mInit)
    {
      ViolaLogUtils.e(TAG, "invokeExecJS Exception mInit is false");
      return;
    }
    if (!ViolaSDKManager.getInstance().isViolaInstanceAlive(paramString1))
    {
      ViolaLogUtils.e(TAG, "violaInstance is destroy!  temp instanceId:" + paramString1 + ", temp data:" + paramString2);
      return;
    }
    this.mBridge.callJS(paramString1, paramString2.getBytes(), paramString2.getBytes().length);
  }
  
  private boolean isJSThread()
  {
    return (this.mJSThread != null) && (this.mJSThread.getId() == Thread.currentThread().getId());
  }
  
  private void registerComponentsImpl(List<Map<String, Object>> paramList)
  {
    if (paramList == this.mRegisterComponentFailList) {
      throw new RuntimeException("Fail receiver should not use source.");
    }
    Object localObject1;
    if (!isJSFrameworkInit())
    {
      ViolaLogUtils.e(TAG, "invokeRegisterComponents: framework.js uninitialized.");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map)paramList.next();
        this.mRegisterComponentFailList.add(localObject1);
      }
    }
    if (paramList == null) {}
    do
    {
      return;
      localObject1 = new JSONObject();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (Map)paramList.next();
        JSONArray localJSONArray = new JSONArray();
        Object localObject3 = ((Map)localObject2).get("methods");
        if ((localObject3 != null) && ((localObject3 instanceof String[])))
        {
          localObject3 = (String[])localObject3;
          int j = localObject3.length;
          if (j >= 1)
          {
            int i = 0;
            while (i < j)
            {
              localJSONArray.put(localObject3[i]);
              i += 1;
            }
            localObject2 = ((Map)localObject2).get("type");
            if ((localObject2 != null) && ((localObject2 instanceof String))) {
              try
              {
                ((JSONObject)localObject1).put((String)localObject2, localJSONArray);
              }
              catch (JSONException localJSONException) {}
            }
          }
        }
      }
    } while (((JSONObject)localObject1).length() == 0);
    execJSFuncByName("registerComponent", ((JSONObject)localObject1).toString());
  }
  
  private void registerModulesImpl(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((localObject != null) && ((localObject instanceof String[])))
      {
        localObject = (String[])localObject;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(localObject[i]);
          i += 1;
        }
      }
      try
      {
        localJSONObject.put(str, localJSONArray);
        execJSFuncByName("registerModules", localJSONObject.toString());
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  private void sendMessage(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain(this.mJSHandler);
    localMessage.obj = paramString;
    localMessage.what = paramInt;
    localMessage.sendToTarget();
  }
  
  private void setJSFrameworkInit(boolean paramBoolean)
  {
    this.mInit = paramBoolean;
  }
  
  public Object callNativeComponent(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray)
  {
    return Boolean.valueOf(ViolaModuleManager.getDomModule(paramString1).invokeComponetMethod(paramString1, paramString2, paramString3, paramJSONArray));
  }
  
  public Object callNativeModule(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if (ViolaEnvironment.isDebugable())
    {
      this.mLogBuilder.append("[BridgeManager] callNativeModule >>>> instanceId:").append(paramString1).append(", module:").append(paramString2).append(", method:").append(paramString3).append(", arguments:").append(paramJSONArray);
      ViolaLogUtils.d(TAG, this.mLogBuilder.substring(0));
      this.mLogBuilder.setLength(0);
    }
    try
    {
      paramString1 = ViolaModuleManager.callModuleMethod(paramString1, paramString2, paramString3, paramJSONArray);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1 = "[BridgeManager] callNative exception: " + paramString1.getMessage();
      ViolaLogUtils.e(TAG, paramString1);
    }
    return null;
  }
  
  public void callbackJavascript(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.mJSHandler == null)) {
      return;
    }
    if (isJSThread())
    {
      invokeExecJS(paramString1, createParamForCallJS(paramString2, paramString3, paramObject1, paramObject2));
      return;
    }
    post(new ViolaBridgeManager.1(this, paramString1, paramString2, paramString3, paramObject1, paramObject2));
  }
  
  @Deprecated
  public void createInstance(String paramString1, String paramString2, Map<String, Object> paramMap, String paramString3)
  {
    if (isJSFrameworkInit())
    {
      createInstanceImpl(paramString1, ViolaUtils.readFile(new File(paramString2)), paramString3, "");
      return;
    }
    ViolaLogUtils.e(TAG, "violaInstance createInstance init false!");
  }
  
  public void createInstanceBySource(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (isJSFrameworkInit())
    {
      createInstanceImpl(paramString1, paramString2, paramString4, paramString3);
      return;
    }
    ViolaLogUtils.e(TAG, "violaInstance createInstance init false!");
  }
  
  public String createParamForCallJS(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("module", paramString1);
      localJSONObject.put("method", paramString2);
      if (paramString2.equals("fireEvent"))
      {
        localJSONObject.put("args", paramObject1);
        localJSONObject.put("data", paramObject2);
      }
      for (;;)
      {
        localJSONArray.put(localJSONObject);
        return localJSONArray.toString();
        if (paramString2.equals("callback"))
        {
          paramString1 = new JSONArray();
          paramString1.put(paramObject1);
          localJSONObject.put("args", paramString1);
          localJSONObject.put("data", paramObject2);
        }
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void destroy()
  {
    if (this.mJSThread != null) {
      this.mJSThread.quit();
    }
  }
  
  public void destroyInstance(String paramString, boolean paramBoolean)
  {
    if ((this.mJSHandler == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.mJSHandler.removeCallbacksAndMessages(paramString);
    if (isJSThread())
    {
      invokeDestroyInstance(paramString, paramBoolean);
      return;
    }
    post(new ViolaBridgeManager.7(this, paramString, paramBoolean), paramString);
  }
  
  public void execJSFuncByName(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.mJSHandler == null)) {
      return;
    }
    if (isJSThread())
    {
      this.mBridge.execJSFunc(paramString1, paramString2.getBytes(), paramString2.getBytes().length);
      return;
    }
    post(new ViolaBridgeManager.2(this, paramString1, paramString2));
  }
  
  public JSParam execJSFuncByNameWithResult(String paramString, List<JSParam> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (ViolaUtils.isUTF8(paramString))) {
      return this.mBridge.execJSFuncWithResult(paramString, paramList);
    }
    return null;
  }
  
  public String getRefreshRef()
  {
    return this.mRefreshRef;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initFrameworkLocalPath(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    for (;;)
    {
      try
      {
        Handler localHandler = this.mJSHandler;
        if (localHandler == null) {
          return;
        }
        if (isJSThread()) {
          initFrameworkLocalPathImpl(paramString1, paramInitCallback, paramString2);
        } else {
          post(new ViolaBridgeManager.3(this, paramString1, paramInitCallback, paramString2));
        }
      }
      finally {}
    }
  }
  
  public void initFrameworkString(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    for (;;)
    {
      try
      {
        Handler localHandler = this.mJSHandler;
        if (localHandler == null) {
          return;
        }
        if (isJSThread()) {
          initFrameworkStringImpl(paramString1, paramInitCallback, paramString2);
        } else {
          post(new ViolaBridgeManager.4(this, paramString1, paramInitCallback, paramString2));
        }
      }
      finally {}
    }
  }
  
  public boolean isJSFrameworkInit()
  {
    return this.mInit;
  }
  
  public void post(Runnable paramRunnable)
  {
    if (this.mJSHandler == null) {
      return;
    }
    synchronized (mLock)
    {
      this.mJSHandler.post(ViolaThread.secure(paramRunnable));
      return;
    }
  }
  
  public void post(Runnable paramRunnable, Object paramObject)
  {
    if (this.mJSHandler == null) {
      return;
    }
    paramRunnable = Message.obtain(this.mJSHandler, ViolaThread.secure(paramRunnable));
    paramRunnable.obj = paramObject;
    paramRunnable.sendToTarget();
  }
  
  public void registerComponents(List<Map<String, Object>> paramList)
  {
    if ((this.mJSHandler == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (isJSThread())
    {
      registerComponentsImpl(paramList);
      return;
    }
    post(new ViolaBridgeManager.8(this, paramList), null);
  }
  
  public void registerModules(String paramString, ArrayList<String> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList.isEmpty())) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(i, paramArrayList.get(i));
        i += 1;
      }
      localJSONObject.put(paramString, localJSONArray);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    execJSFuncByName("registerModules", localJSONObject.toString());
  }
  
  public void registerModules(Map<String, Object> paramMap)
  {
    if ((this.mJSHandler == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    if (Thread.currentThread().getName().equals("ViolaJSBridgeThread"))
    {
      registerModulesImpl(paramMap);
      return;
    }
    post(new ViolaBridgeManager.9(this, paramMap), null);
  }
  
  public void setRefreshRef(String paramString)
  {
    this.mRefreshRef = paramString;
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (isJSThread())
    {
      this.mBridge.updateInstance(paramString1, paramString2);
      return;
    }
    post(new ViolaBridgeManager.6(this, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.bridge.ViolaBridgeManager
 * JD-Core Version:    0.7.0.1
 */