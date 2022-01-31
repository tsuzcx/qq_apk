package com.tencent.pts.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

public class PTSAppInstance$Builder
{
  private String appName;
  private Context context;
  private String frameTreeJson;
  private PTSItemData itemData;
  private PTSLiteItemViewManager liteItemViewManager;
  private String pageJs;
  private PTSJSBridge ptsJSBridge;
  private int rootNodeType;
  private ViewGroup rootView;
  
  private void check()
  {
    if (this.context == null) {
      throw new IllegalStateException("PTSAppInstance context is null.");
    }
    if (this.rootView == null) {
      throw new IllegalStateException("PTSAppInstance rootView is null.");
    }
    if (TextUtils.isEmpty(this.appName)) {
      throw new IllegalStateException("PTSAppInstance appName is empty.");
    }
    if (TextUtils.isEmpty(this.frameTreeJson)) {
      throw new IllegalStateException("PTSAppInstance frameTreeJson is empty.");
    }
  }
  
  public PTSAppInstance build()
  {
    Object localObject;
    if (this.ptsJSBridge != null)
    {
      localObject = new PTSAppInstance.PTSJsAppInstance(null);
      PTSAppInstance.PTSJsAppInstance.access$200((PTSAppInstance.PTSJsAppInstance)localObject, this.ptsJSBridge);
    }
    for (;;)
    {
      PTSAppInstance.access$502((PTSAppInstance)localObject, this.context);
      PTSAppInstance.access$602((PTSAppInstance)localObject, this.rootView);
      PTSAppInstance.access$702((PTSAppInstance)localObject, this.rootNodeType);
      PTSAppInstance.access$802((PTSAppInstance)localObject, this.appName);
      PTSAppInstance.access$902((PTSAppInstance)localObject, this.itemData);
      PTSAppInstance.access$1002((PTSAppInstance)localObject, this.frameTreeJson);
      PTSAppInstance.access$1102((PTSAppInstance)localObject, this.pageJs);
      check();
      PTSAppInstance.access$1200((PTSAppInstance)localObject, this.rootNodeType);
      return localObject;
      localObject = new PTSAppInstance.PTSLiteAppInstance(null);
      PTSAppInstance.PTSLiteAppInstance.access$400((PTSAppInstance.PTSLiteAppInstance)localObject, this.liteItemViewManager);
    }
  }
  
  public Builder withAppName(String paramString)
  {
    this.appName = paramString;
    return this;
  }
  
  public Builder withContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public Builder withFrameTreeJson(String paramString)
  {
    this.frameTreeJson = paramString;
    return this;
  }
  
  public Builder withItemData(PTSItemData paramPTSItemData)
  {
    this.itemData = paramPTSItemData;
    return this;
  }
  
  public Builder withLiteItemViewManager(PTSLiteItemViewManager paramPTSLiteItemViewManager)
  {
    this.liteItemViewManager = paramPTSLiteItemViewManager;
    return this;
  }
  
  public Builder withPTSJSBridge(PTSJSBridge paramPTSJSBridge)
  {
    this.ptsJSBridge = paramPTSJSBridge;
    return this;
  }
  
  public Builder withPageJs(String paramString)
  {
    this.pageJs = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.Builder
 * JD-Core Version:    0.7.0.1
 */