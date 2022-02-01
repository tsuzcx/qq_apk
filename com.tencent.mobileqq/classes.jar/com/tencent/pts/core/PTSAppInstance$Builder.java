package com.tencent.pts.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.utils.PTSLog;

public class PTSAppInstance$Builder
{
  private float containerWidth;
  private Context context;
  private String frameTreeJson;
  private PTSItemData itemData;
  private IPTSLiteEventListener liteEventListener;
  private PTSLiteItemViewManager liteItemViewManager;
  private String pageJs;
  private String pageName;
  private PTSJSBridge ptsJSBridge;
  private int rootNodeType;
  private ViewGroup rootView;
  
  private void check()
  {
    if (TextUtils.isEmpty(this.pageName))
    {
      if (PTSLog.isDebug()) {
        throw new IllegalStateException("PTSAppInstance pageName is empty.");
      }
      this.pageName = "null";
      PTSLog.e("PTSAppInstance", "[check] PTSAppInstance pageName is empty.");
    }
    if (TextUtils.isEmpty(this.frameTreeJson))
    {
      if (PTSLog.isDebug()) {
        throw new IllegalStateException("PTSAppInstance frameTreeJson is empty.");
      }
      this.frameTreeJson = "{}";
      PTSLog.e("PTSAppInstance", "[check] PTSAppInstance frameTreeJson is empty.");
    }
  }
  
  public PTSAppInstance build()
  {
    Object localObject;
    if (this.ptsJSBridge != null)
    {
      localObject = new PTSAppInstance.PTSJsAppInstance(null);
      PTSAppInstance.PTSJsAppInstance.access$300((PTSAppInstance.PTSJsAppInstance)localObject, this.ptsJSBridge);
    }
    for (;;)
    {
      PTSAppInstance.access$602((PTSAppInstance)localObject, this.context);
      PTSAppInstance.access$702((PTSAppInstance)localObject, this.rootView);
      PTSAppInstance.access$802((PTSAppInstance)localObject, this.rootNodeType);
      PTSAppInstance.access$902((PTSAppInstance)localObject, this.pageName);
      ((PTSAppInstance)localObject).itemData = this.itemData;
      PTSAppInstance.access$1002((PTSAppInstance)localObject, this.frameTreeJson);
      PTSAppInstance.access$1102((PTSAppInstance)localObject, this.pageJs);
      PTSAppInstance.access$1202((PTSAppInstance)localObject, this.containerWidth);
      check();
      PTSAppInstance.access$1300((PTSAppInstance)localObject, this.rootNodeType);
      return localObject;
      localObject = new PTSAppInstance.PTSLiteAppInstance(null);
      PTSAppInstance.PTSLiteAppInstance.access$500((PTSAppInstance.PTSLiteAppInstance)localObject, this.liteItemViewManager);
      PTSAppInstance.PTSLiteAppInstance.access$000((PTSAppInstance.PTSLiteAppInstance)localObject, this.liteEventListener);
    }
  }
  
  public Builder withContainerWidth(float paramFloat)
  {
    this.containerWidth = paramFloat;
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
    if (paramPTSItemData != null)
    {
      this.pageName = paramPTSItemData.getPageName();
      this.frameTreeJson = paramPTSItemData.getFrameTreeJson();
      this.pageJs = paramPTSItemData.getPageJs();
    }
    return this;
  }
  
  public Builder withLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    this.liteEventListener = paramIPTSLiteEventListener;
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
  
  public Builder withPageName(String paramString)
  {
    this.pageName = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.Builder
 * JD-Core Version:    0.7.0.1
 */