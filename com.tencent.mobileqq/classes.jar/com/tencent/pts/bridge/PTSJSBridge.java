package com.tencent.pts.bridge;

import android.app.Activity;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSFileUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class PTSJSBridge
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private final String ANIMATION_JS_FILE_NAME = "Animation.js";
  private final String BIND_DATA_JS_FILE_NAME = "BindData.js";
  private final String FRAME_TREE_SUFFIX = ".frametree";
  private final String JS_SUFFIX = ".js";
  private final String TAG = "PTSJSBridge";
  private volatile boolean hasInitBasicJSBundle = false;
  private Activity mActivity;
  private int mJSEnvID;
  
  PTSJSBridge(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mJSEnvID = NEXT_ID.getAndIncrement();
    createJSEnvironment();
  }
  
  private void createJSEnvironment()
  {
    PTSJNIHandler.createJSEnvironment(getJSEnvID());
  }
  
  private String getFileContent(String paramString1, String paramString2)
  {
    return PTSFileUtil.getFileContent(paramString1, paramString2, this.mActivity);
  }
  
  private void initBasicJSBundle(String paramString, PTSAppInstance paramPTSAppInstance)
  {
    PTSThreadUtil.runOnSubThread(new PTSJSBridge.2(this, paramString, paramPTSAppInstance));
  }
  
  private void loadAppJSBundle(String paramString1, String paramString2, PTSAppInstance paramPTSAppInstance)
  {
    PTSJNIHandler.create(paramPTSAppInstance, getFileContent("pages/" + paramString1 + "/" + paramString1 + ".frametree", paramString2), getFileContent("pages/" + paramString1 + "/" + paramString1 + ".js", paramString2), getJSEnvID());
    PTSJNIHandler.get(paramPTSAppInstance).callJSFunction("onLoad", null, getJSEnvID());
  }
  
  private void loadBasicJSBundle(String paramString, PTSAppInstance paramPTSAppInstance)
  {
    if (this.hasInitBasicJSBundle) {
      return;
    }
    paramPTSAppInstance = getFileContent("BindData.js", paramString);
    paramString = getFileContent("Animation.js", paramString);
    PTSJNIHandler.evaluateJavaScript(getJSEnvID(), paramPTSAppInstance);
    PTSJNIHandler.evaluateJavaScript(getJSEnvID(), paramString);
    this.hasInitBasicJSBundle = true;
  }
  
  public void callJSEventFunction(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, PTSAppInstance paramPTSAppInstance)
  {
    paramPTSAppInstance = PTSJNIHandler.get(paramPTSAppInstance);
    if (paramPTSAppInstance != null) {
      paramPTSAppInstance.callJSEventFunction(paramString1, paramInt, paramString2, paramString3, paramArrayOfString1, paramArrayOfString2, paramArrayOfFloat1, paramArrayOfFloat2, getJSEnvID());
    }
  }
  
  public void callJSFunction(String paramString, Object[] paramArrayOfObject, PTSAppInstance paramPTSAppInstance)
  {
    paramPTSAppInstance = PTSJNIHandler.get(paramPTSAppInstance);
    if (paramPTSAppInstance != null) {
      paramPTSAppInstance.callJSFunction(paramString, paramArrayOfObject, getJSEnvID());
    }
  }
  
  void destroyJSEnvironment()
  {
    PTSJNIHandler.destroyJSEnvironment(getJSEnvID());
  }
  
  public int getJSEnvID()
  {
    return this.mJSEnvID;
  }
  
  public void initAppJSBundle(String paramString1, String paramString2, PTSAppInstance paramPTSAppInstance)
  {
    if (!this.hasInitBasicJSBundle) {
      initBasicJSBundle(paramString2, paramPTSAppInstance);
    }
    PTSThreadUtil.runOnSubThread(new PTSJSBridge.1(this, paramString1, paramString2, paramPTSAppInstance));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.bridge.PTSJSBridge
 * JD-Core Version:    0.7.0.1
 */