package com.tencent.pts.bridge;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.utils.PTSLog;
import java.util.concurrent.atomic.AtomicInteger;

public class PTSJSBridge
{
  public static final String ANIMATION_JS_FILE_NAME = "Animation.js";
  public static final String BIND_DATA_JS_FILE_NAME = "BindData.js";
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private final String TAG = "PTSJSBridge";
  private volatile boolean hasInitBasicJSBundle = false;
  private int jsEnvId = NEXT_ID.getAndIncrement();
  
  PTSJSBridge(String paramString1, String paramString2)
  {
    createJsEnvironment();
    initBasicJSBundle(paramString1, paramString2);
  }
  
  private void createJsEnvironment()
  {
    PTSJsJniHandler.createJSEnvironment(getJsEnvID());
  }
  
  private void initBasicJSBundle(String paramString1, String paramString2)
  {
    if (this.hasInitBasicJSBundle) {
      return;
    }
    PTSJsJniHandler.evaluateJavaScript(getJsEnvID(), paramString1);
    PTSJsJniHandler.evaluateJavaScript(getJsEnvID(), paramString2);
    this.hasInitBasicJSBundle = true;
  }
  
  public void callJSEventFunction(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, PTSAppInstance paramPTSAppInstance)
  {
    PTSJsJniHandler.callJSEventFunction(paramPTSAppInstance, paramString1, paramInt, paramString2, paramString3, paramArrayOfString1, paramArrayOfString2, paramArrayOfFloat1, paramArrayOfFloat2, getJsEnvID());
  }
  
  public void callJSFunction(String paramString, Object[] paramArrayOfObject, PTSAppInstance paramPTSAppInstance)
  {
    PTSJsJniHandler.callJSFunction(paramPTSAppInstance, paramString, paramArrayOfObject, getJsEnvID());
  }
  
  public void callOnLoadJsFunction(PTSAppInstance paramPTSAppInstance)
  {
    if (!this.hasInitBasicJSBundle)
    {
      PTSLog.e("PTSJSBridge", "[callOnLoadJsFunction] error, has not init basic js bundle.");
      return;
    }
    PTSJsJniHandler.callJSFunction(paramPTSAppInstance, "onLoad", null, getJsEnvID());
  }
  
  void destroyJsEnvironment()
  {
    PTSJsJniHandler.destroyJSEnvironment(getJsEnvID());
  }
  
  public int getJsEnvID()
  {
    return this.jsEnvId;
  }
  
  public void initAppJSBundle(String paramString1, String paramString2, PTSAppInstance paramPTSAppInstance)
  {
    if (!this.hasInitBasicJSBundle)
    {
      PTSLog.e("PTSJSBridge", "[initAppJSBundle] error, has not init basic js bundle.");
      return;
    }
    PTSJsJniHandler.create(paramPTSAppInstance, paramString1, paramString2, getJsEnvID());
    PTSJsJniHandler.callJSFunction(paramPTSAppInstance, "onLoad", null, getJsEnvID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.bridge.PTSJSBridge
 * JD-Core Version:    0.7.0.1
 */