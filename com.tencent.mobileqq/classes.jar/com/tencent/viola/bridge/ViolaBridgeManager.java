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
  public static final String TAG = "ViolaBridgeManager";
  private static final Object mLock = new Object();
  static volatile ViolaBridgeManager mViolaBridgeManager;
  private volatile boolean hasCallBridgeInit;
  private ViolaBridge mBridge = new ViolaBridge();
  private volatile boolean mInit = false;
  Handler mJSHandler = this.mJSThread.getHandler();
  private ViolaThread mJSThread = new ViolaThread("ViolaJSBridgeThread", this);
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
    Object localObject;
    if (ViolaEnvironment.isDebugable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createInstance >>>> instanceId:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" data:");
      ((StringBuilder)localObject).append(paramString3);
      ViolaLogUtils.d("ViolaBridgeManager", ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString2))
    {
      ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstanceImpl template null!");
      return;
    }
    ViolaModuleManager.createDomModule(ViolaSDKManager.getInstance().getViolaInstance(paramString1));
    if (Thread.currentThread().getName().equals("ViolaJSBridgeThread"))
    {
      ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstanceImpl ViolaJSBridgeThread start!");
      paramString4 = this.mBridge;
      localObject = paramString2.getBytes();
      int i = paramString2.getBytes().length;
      paramString2 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString2 = "";
      }
      paramString4.createInstance(paramString1, (byte[])localObject, i, paramString2, "");
      return;
    }
    post(new ViolaBridgeManager.5(this, paramString1, paramString2, paramString3), paramString1);
    ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstanceImpl end!");
    if (!TextUtils.isEmpty(paramString4)) {
      this.mBridge.preloadTest(paramString1, paramString4);
    }
  }
  
  public static ViolaBridgeManager getInstance()
  {
    if (mViolaBridgeManager == null) {
      try
      {
        if (mViolaBridgeManager == null) {
          mViolaBridgeManager = new ViolaBridgeManager();
        }
      }
      finally {}
    }
    return mViolaBridgeManager;
  }
  
  private void initFrameworkLocalPathImpl(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ViolaUtils.readFile(new File(paramString1));
      if (TextUtils.isEmpty(paramString1))
      {
        if (paramInitCallback != null) {
          paramInitCallback.onFinish(101, 0L, "mainjs error");
        }
        return;
      }
      initFrameworkStringImpl(paramString1, paramInitCallback, paramString2);
    }
  }
  
  private void initFrameworkStringImpl(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (!isJSFrameworkInit())
    {
      if (!this.hasCallBridgeInit)
      {
        this.mBridge.init();
        this.hasCallBridgeInit = true;
      }
      long l = System.currentTimeMillis();
      if (!TextUtils.isEmpty(paramString1))
      {
        if (1 == this.mBridge.initJsFramework(paramString1.getBytes(), paramString1.getBytes().length, paramString2))
        {
          ViolaSDKEngine.registerBase();
          setJSFrameworkInit(true);
          paramInitCallback.onFinish(0, System.currentTimeMillis() - l, "");
          return;
        }
        if (paramInitCallback != null) {
          paramInitCallback.onFinish(102, 0L, "mainjs error");
        }
      }
      else if (paramInitCallback != null)
      {
        paramInitCallback.onFinish(101, 0L, "mainjs had inited");
      }
    }
    else if (paramInitCallback != null)
    {
      paramInitCallback.onFinish(1, 0L, "mainjs had inited");
    }
  }
  
  private void invokeDestroyInstance(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mJSHandler == null) {
        return;
      }
      try
      {
        if (ViolaEnvironment.isDebugable())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("destroyInstance >>>> instanceId:");
          localStringBuilder.append(paramString);
          ViolaLogUtils.d("ViolaBridgeManager", localStringBuilder.toString());
        }
        this.mBridge.destroyInstance(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[BridgeManager] invokeDestroyInstance ");
        localStringBuilder.append(paramString.getCause());
        ViolaLogUtils.e("ViolaBridgeManager", localStringBuilder.toString());
      }
    }
  }
  
  private void invokeExecJS(String paramString1, String paramString2)
  {
    invokeExecJS(paramString1, paramString2, true);
  }
  
  private void invokeExecJS(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (ViolaEnvironment.isDebugable())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("callJS >>>> instanceId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("function:");
      localStringBuilder.append(paramString2);
      if (paramBoolean)
      {
        localStringBuilder.append(" tasks:");
        localStringBuilder.append(paramString2);
      }
      ViolaLogUtils.d("ViolaBridgeManager", localStringBuilder.toString());
    }
    if (!this.mInit)
    {
      ViolaLogUtils.e("ViolaBridgeManager", "invokeExecJS Exception mInit is false");
      return;
    }
    if (!ViolaSDKManager.getInstance().isViolaInstanceAlive(paramString1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("violaInstance is destroy!  temp instanceId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", temp data:");
      localStringBuilder.append(paramString2);
      ViolaLogUtils.e("ViolaBridgeManager", localStringBuilder.toString());
      return;
    }
    this.mBridge.callJS(paramString1, paramString2.getBytes(), paramString2.getBytes().length);
  }
  
  private boolean isJSThread()
  {
    ViolaThread localViolaThread = this.mJSThread;
    return (localViolaThread != null) && (localViolaThread.getId() == Thread.currentThread().getId());
  }
  
  private void registerComponentsImpl(List<Map<String, Object>> paramList)
  {
    if (paramList != this.mRegisterComponentFailList)
    {
      if (!isJSFrameworkInit())
      {
        ViolaLogUtils.e("ViolaBridgeManager", "invokeRegisterComponents: framework.js uninitialized.");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (Map)paramList.next();
          this.mRegisterComponentFailList.add(localObject1);
        }
        return;
      }
      if (paramList == null) {
        return;
      }
      Object localObject1 = new JSONObject();
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
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {}
          }
        }
        try
        {
          ((JSONObject)localObject1).put((String)localObject2, localJSONArray);
        }
        catch (JSONException localJSONException)
        {
          label228:
          break label228;
        }
      }
      if (((JSONObject)localObject1).length() == 0) {
        return;
      }
      execJSFuncByName("registerComponent", ((JSONObject)localObject1).toString());
      return;
    }
    paramList = new RuntimeException("Fail receiver should not use source.");
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void registerModulesImpl(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
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
      }
      try
      {
        localJSONObject.put(str, localJSONArray);
        execJSFuncByName("registerModules", localJSONObject.toString());
      }
      catch (JSONException localJSONException) {}
      return;
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
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("[BridgeManager] callNativeModule >>>> instanceId:");
      paramJSONObject.append(paramString1);
      paramJSONObject.append(", module:");
      paramJSONObject.append(paramString2);
      paramJSONObject.append(", method:");
      paramJSONObject.append(paramString3);
      paramJSONObject.append(", arguments:");
      paramJSONObject.append(paramJSONArray);
      ViolaLogUtils.d("ViolaBridgeManager", paramJSONObject.toString());
    }
    try
    {
      paramString1 = ViolaModuleManager.callModuleMethod(paramString1, paramString2, paramString3, paramJSONArray);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[BridgeManager] callNative exception: ");
      paramString2.append(paramString1.getMessage());
      ViolaLogUtils.e("ViolaBridgeManager", paramString2.toString());
    }
    return null;
  }
  
  public void callbackJavascript(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.mJSHandler == null) {
        return;
      }
      if (isJSThread())
      {
        invokeExecJS(paramString1, createParamForCallJS(paramString2, paramString3, paramObject1, paramObject2));
        return;
      }
      post(new ViolaBridgeManager.1(this, paramString1, paramString2, paramString3, paramObject1, paramObject2));
    }
  }
  
  @Deprecated
  public void createInstance(String paramString1, String paramString2, Map<String, Object> paramMap, String paramString3)
  {
    if (isJSFrameworkInit())
    {
      createInstanceImpl(paramString1, ViolaUtils.readFile(new File(paramString2)), paramString3, "");
      return;
    }
    ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstance init false!");
  }
  
  public void createInstanceBySource(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (isJSFrameworkInit())
    {
      createInstanceImpl(paramString1, paramString2, paramString4, paramString3);
      return;
    }
    ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstance init false!");
  }
  
  public String createParamForCallJS(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("module", paramString1);
      localJSONObject.put("method", paramString2);
      boolean bool = paramString2.equals("fireEvent");
      if (bool)
      {
        localJSONObject.put("args", paramObject1);
        localJSONObject.put("data", paramObject2);
      }
      else if (paramString2.equals("callback"))
      {
        paramString1 = new JSONArray();
        paramString1.put(paramObject1);
        localJSONObject.put("args", paramString1);
        localJSONObject.put("data", paramObject2);
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    localJSONArray.put(localJSONObject);
    return localJSONArray.toString();
  }
  
  public void destroy()
  {
    ViolaThread localViolaThread = this.mJSThread;
    if (localViolaThread != null) {
      localViolaThread.quit();
    }
  }
  
  public void destroyInstance(String paramString, boolean paramBoolean)
  {
    if (this.mJSHandler != null)
    {
      if (TextUtils.isEmpty(paramString)) {
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
  }
  
  public void execJSFuncByName(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.mJSHandler == null) {
        return;
      }
      if (isJSThread())
      {
        this.mBridge.execJSFunc(paramString1, paramString2.getBytes(), paramString2.getBytes().length);
        return;
      }
      post(new ViolaBridgeManager.2(this, paramString1, paramString2));
    }
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
    try
    {
      Handler localHandler = this.mJSHandler;
      if (localHandler == null) {
        return;
      }
      if (isJSThread())
      {
        initFrameworkLocalPathImpl(paramString1, paramInitCallback, paramString2);
        return;
      }
      post(new ViolaBridgeManager.3(this, paramString1, paramInitCallback, paramString2));
      return;
    }
    finally {}
  }
  
  public void initFrameworkString(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    try
    {
      Handler localHandler = this.mJSHandler;
      if (localHandler == null) {
        return;
      }
      if (isJSThread())
      {
        initFrameworkStringImpl(paramString1, paramInitCallback, paramString2);
        return;
      }
      post(new ViolaBridgeManager.4(this, paramString1, paramInitCallback, paramString2));
      return;
    }
    finally {}
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
    Handler localHandler = this.mJSHandler;
    if (localHandler == null) {
      return;
    }
    paramRunnable = Message.obtain(localHandler, ViolaThread.secure(paramRunnable));
    paramRunnable.obj = paramObject;
    paramRunnable.sendToTarget();
  }
  
  public void registerComponents(List<Map<String, Object>> paramList)
  {
    if ((this.mJSHandler != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      if (isJSThread())
      {
        registerComponentsImpl(paramList);
        return;
      }
      post(new ViolaBridgeManager.8(this, paramList), null);
    }
  }
  
  public void registerModules(String paramString, ArrayList<String> paramArrayList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramArrayList.isEmpty()) {
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
        paramString.printStackTrace();
      }
      execJSFuncByName("registerModules", localJSONObject.toString());
    }
  }
  
  public void registerModules(Map<String, Object> paramMap)
  {
    if ((this.mJSHandler != null) && (paramMap != null))
    {
      if (paramMap.size() == 0) {
        return;
      }
      if (Thread.currentThread().getName().equals("ViolaJSBridgeThread"))
      {
        registerModulesImpl(paramMap);
        return;
      }
      post(new ViolaBridgeManager.9(this, paramMap), null);
    }
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