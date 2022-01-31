package com.tencent.pts.core;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;

public class PTSAppInstance$Builder
{
  private Activity activity;
  private String appName;
  private String appPath;
  private PTSItemData itemData;
  private PTSJSBridge ptsJSBridge;
  private int rootNodeType;
  private ViewGroup rootView;
  
  private void check()
  {
    if (this.activity == null) {
      throw new IllegalStateException("PTSAppInstance activity is null.");
    }
    if (this.rootView == null) {
      throw new IllegalStateException("PTSAppInstance rootView is null.");
    }
    if (this.ptsJSBridge == null) {
      throw new IllegalStateException("PTSAppInstance ptsJSBridge is null.");
    }
    if (TextUtils.isEmpty(this.appName)) {
      throw new IllegalStateException("PTSAppInstance appName is empty.");
    }
  }
  
  public PTSAppInstance build()
  {
    PTSAppInstance localPTSAppInstance = new PTSAppInstance(null);
    PTSAppInstance.access$102(localPTSAppInstance, this.activity);
    PTSAppInstance.access$202(localPTSAppInstance, this.rootView);
    PTSAppInstance.access$302(localPTSAppInstance, this.rootNodeType);
    PTSAppInstance.access$402(localPTSAppInstance, this.ptsJSBridge);
    PTSAppInstance.access$502(localPTSAppInstance, this.appName);
    PTSAppInstance.access$602(localPTSAppInstance, this.appPath);
    PTSAppInstance.access$702(localPTSAppInstance, this.itemData);
    check();
    PTSAppInstance.access$800(localPTSAppInstance, this.rootNodeType);
    return localPTSAppInstance;
  }
  
  public Builder withActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
    return this;
  }
  
  public Builder withAppName(String paramString)
  {
    this.appName = paramString;
    return this;
  }
  
  public Builder withAppPath(String paramString)
  {
    this.appPath = paramString;
    return this;
  }
  
  public Builder withItemData(PTSItemData paramPTSItemData)
  {
    this.itemData = paramPTSItemData;
    return this;
  }
  
  public Builder withPTSJSBridge(PTSJSBridge paramPTSJSBridge)
  {
    this.ptsJSBridge = paramPTSJSBridge;
    return this;
  }
  
  public Builder withRootNodeType(int paramInt)
  {
    this.rootNodeType = paramInt;
    return this;
  }
  
  public Builder withRootView(ViewGroup paramViewGroup)
  {
    this.rootView = paramViewGroup;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.Builder
 * JD-Core Version:    0.7.0.1
 */