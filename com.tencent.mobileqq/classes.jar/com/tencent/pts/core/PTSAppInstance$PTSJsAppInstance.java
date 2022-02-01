package com.tencent.pts.core;

import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSJsJniHandler;

public class PTSAppInstance$PTSJsAppInstance
  extends PTSAppInstance
{
  private PTSJSBridge ptsJsBridge;
  
  private PTSAppInstance$PTSJsAppInstance()
  {
    super(null);
  }
  
  private void setJsBridge(PTSJSBridge paramPTSJSBridge)
  {
    this.ptsJsBridge = paramPTSJSBridge;
  }
  
  public PTSJSBridge getJsBridge()
  {
    return this.ptsJsBridge;
  }
  
  void initPTSAppInstance(String paramString1, String paramString2)
  {
    this.ptsJsBridge.initAppJSBundle(paramString1, paramString2, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PTSJsJniHandler.destroy(this, this.ptsJsBridge.getJsEnvID());
    this.ptsJsBridge = null;
  }
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    super.setItemData(paramPTSItemData);
    this.ptsJsBridge.callOnLoadJsFunction(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.PTSJsAppInstance
 * JD-Core Version:    0.7.0.1
 */