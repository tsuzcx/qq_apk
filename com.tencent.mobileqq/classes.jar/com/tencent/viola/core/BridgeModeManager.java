package com.tencent.viola.core;

import android.text.TextUtils;
import com.tencent.viola.adapter.IMultiV8ViolaRuntimeAdapter;
import com.tencent.viola.commons.JSParam;
import java.util.List;

public class BridgeModeManager
  implements IMultiV8ViolaRuntimeAdapter
{
  public static final int MODE_JSC = 0;
  public static final int MODE_V8_MULTI_INSTANCE = 2;
  public static final int MODE_V8_SINGE_INSTANCE = 1;
  private IViolaBridge mBridge;
  private int mode;
  private MultiV8ViolaBridge multiV8ViolaBridge;
  
  public BridgeModeManager(int paramInt)
  {
    this.mode = paramInt;
    if (paramInt == 0)
    {
      this.mBridge = new ViolaBridge();
      return;
    }
    if (paramInt == 1)
    {
      this.mBridge = new V8ViolaBridge();
      return;
    }
    this.multiV8ViolaBridge = new MultiV8ViolaBridge(this);
  }
  
  public void callJS(String paramString1, String paramString2)
  {
    if (this.mode == 2)
    {
      this.multiV8ViolaBridge.callJS(paramString1, paramString2);
      return;
    }
    this.mBridge.callJS(paramString1, paramString2);
  }
  
  public void createInstance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.mode == 2)
    {
      paramString5 = this.multiV8ViolaBridge;
      if (TextUtils.isEmpty(paramString4)) {
        paramString4 = "";
      }
      paramString5.createInstance(paramString1, paramString2, paramString3, paramString4, "");
      return;
    }
    paramString5 = this.mBridge;
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "";
    }
    paramString5.createInstance(paramString2, paramString3, paramString1, "");
  }
  
  public void destroyInstance(String paramString, boolean paramBoolean)
  {
    if (this.mode == 2)
    {
      this.multiV8ViolaBridge.destroyInstance(paramString);
      return;
    }
    this.mBridge.destroyInstance(paramString);
  }
  
  public void execJSFunc(String paramString1, String paramString2, String paramString3)
  {
    if (this.mode == 2)
    {
      this.multiV8ViolaBridge.execJSFunc(paramString1, paramString2, paramString3);
      return;
    }
    this.mBridge.execJSFunc(paramString2, paramString3);
  }
  
  public JSParam execJSFuncWithResult(String paramString1, String paramString2, List<JSParam> paramList)
  {
    if (this.mode == 2) {
      return this.multiV8ViolaBridge.execJSFuncWithResult(paramString1, paramString2, paramList);
    }
    return this.mBridge.execJSFuncWithResult(paramString2, paramList);
  }
  
  public void init()
  {
    if (this.mode == 2)
    {
      this.multiV8ViolaBridge.init();
      return;
    }
    this.mBridge.init();
  }
  
  public int initJsFramework(String paramString1, String paramString2)
  {
    if (this.mode == 2) {
      return this.multiV8ViolaBridge.initJsFramework(paramString1, paramString2);
    }
    return this.mBridge.initJsFramework(paramString1, paramString2);
  }
  
  public boolean multiV8Instance()
  {
    return this.mode == 2;
  }
  
  public boolean needKeepGlobalVar(String paramString)
  {
    return ViolaSDKManager.getInstance().getMultiV8ViolaRuntimeAdapter().needKeepGlobalVar(paramString);
  }
  
  public boolean needPreloadRuntime(String paramString)
  {
    return ViolaSDKManager.getInstance().getMultiV8ViolaRuntimeAdapter().needPreloadRuntime(paramString);
  }
  
  public void onViolaRuntimeReady()
  {
    ViolaSDKEngine.registerBase();
    ViolaSDKManager.getInstance().getMultiV8ViolaRuntimeAdapter().onViolaRuntimeReady();
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    if (this.mode == 2)
    {
      this.multiV8ViolaBridge.updateInstance(paramString1, paramString2);
      return;
    }
    this.mBridge.updateInstance(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.BridgeModeManager
 * JD-Core Version:    0.7.0.1
 */