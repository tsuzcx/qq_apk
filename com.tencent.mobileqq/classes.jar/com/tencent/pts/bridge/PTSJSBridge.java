package com.tencent.pts.bridge;

import android.app.Activity;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class PTSJSBridge
{
  private static final AtomicInteger NEXT_ID = new AtomicInteger(1);
  private final String ANIMATION_JS_FILE_NAME = "Animation.js";
  private final String BIND_DATA_JS_FILE_NAME = "BindData.js";
  private final String FRAME_TREE_SUFFIX = ".frametree";
  private final String JS_SUFFIX = ".js";
  private final String TAG = "PTSJSBridge";
  private boolean hasInitBasicJSBundle = false;
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
  
  private void initBasicJSBundle(String paramString, PTSAppInstance paramPTSAppInstance)
  {
    PTSThreadUtil.runOnSubThread(new PTSJSBridge.2(this, paramString, paramPTSAppInstance));
  }
  
  private void loadAppJSBundle(String paramString1, String paramString2, PTSAppInstance paramPTSAppInstance)
  {
    PTSJNIHandler.create(paramPTSAppInstance, loadFile("pages/" + paramString1 + "/" + paramString1 + ".frametree", paramString2), loadFile("pages/" + paramString1 + "/" + paramString1 + ".js", paramString2), getJSEnvID());
    PTSJNIHandler.get(paramPTSAppInstance).callJSFunction("onLoad", null, getJSEnvID());
  }
  
  private void loadBasicJSBundle(String paramString, PTSAppInstance paramPTSAppInstance)
  {
    paramPTSAppInstance = loadFile("BindData.js", paramString);
    paramString = loadFile("Animation.js", paramString);
    PTSJNIHandler.evaluateJavaScript(getJSEnvID(), paramPTSAppInstance);
    PTSJNIHandler.evaluateJavaScript(getJSEnvID(), paramString);
    this.hasInitBasicJSBundle = true;
  }
  
  private String loadFile(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      try
      {
        paramString1 = this.mActivity.getAssets().open(paramString1);
        paramString2 = new byte[paramString1.available()];
        paramString1.read(paramString2);
        paramString1.close();
        paramString1 = new String(paramString2);
        return paramString1;
      }
      catch (IOException paramString1)
      {
        PTSLog.e("PTSJSBridge", "loadFile exception, e = " + paramString1);
        return "";
      }
    }
    paramString1 = paramString2 + "/" + paramString1;
    PTSLog.i("PTSJSBridge", "[loadFile], fullFileName = " + paramString1);
    for (paramString1 = new File(paramString1);; paramString1 = "") {
      try
      {
        if (paramString1.exists())
        {
          paramString1 = new FileInputStream(paramString1);
          paramString2 = new byte[paramString1.available()];
          paramString1.read(paramString2);
          paramString1.close();
          paramString1 = new String(paramString2);
          return paramString1;
        }
      }
      catch (IOException paramString1)
      {
        PTSLog.e("PTSJSBridge", "[loadFilePathAsString], e = " + paramString1);
        return "";
      }
      catch (Throwable paramString1)
      {
        PTSLog.e("PTSJSBridge", "[loadFilePathAsString], t = " + paramString1);
        return "";
      }
    }
  }
  
  public void callJSEventFunction(String paramString1, int paramInt, String paramString2, PTSAppInstance paramPTSAppInstance)
  {
    paramPTSAppInstance = PTSJNIHandler.get(paramPTSAppInstance);
    if (paramPTSAppInstance != null) {
      paramPTSAppInstance.callJSEventFunction(paramString1, paramInt, paramString2, getJSEnvID());
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