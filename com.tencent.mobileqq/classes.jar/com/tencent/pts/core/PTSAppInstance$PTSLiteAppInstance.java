package com.tencent.pts.core;

import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSLiteJniHandler;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;

public class PTSAppInstance$PTSLiteAppInstance
  extends PTSAppInstance
{
  private IPTSLiteEventListener liteEventListener;
  private PTSLiteItemViewManager liteItemViewManager;
  private PTSLiteBridge ptsLiteBridge = new PTSLiteBridge();
  
  private PTSAppInstance$PTSLiteAppInstance()
  {
    super(null);
  }
  
  private void setLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    this.liteEventListener = paramIPTSLiteEventListener;
  }
  
  private void setLiteItemViewManager(PTSLiteItemViewManager paramPTSLiteItemViewManager)
  {
    this.liteItemViewManager = paramPTSLiteItemViewManager;
  }
  
  public PTSLiteBridge getLiteBridge()
  {
    return this.ptsLiteBridge;
  }
  
  public IPTSLiteEventListener getLiteEventListener()
  {
    return this.liteEventListener;
  }
  
  public PTSLiteItemViewManager getLiteItemViewManager()
  {
    return this.liteItemViewManager;
  }
  
  void initPTSAppInstance(String paramString1, String paramString2)
  {
    this.ptsLiteBridge.initAppLiteBundle(paramString1, this);
    this.ptsLiteBridge.setData(getItemData(), this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PTSLiteJniHandler.destroy(this);
    this.liteItemViewManager = null;
    this.liteEventListener = null;
  }
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    super.setItemData(paramPTSItemData);
    this.ptsLiteBridge.setData(getItemData(), this);
  }
  
  public void triggerLiteEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if (this.liteEventListener == null)
    {
      PTSLog.i("PTSAppInstance", "[triggerLiteEvent], liteEventListener is null.");
      return;
    }
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("pts:pageName", getPageName());
    switch (paramInt)
    {
    default: 
      PTSLog.i("PTSAppInstance", "[triggerLiteEvent] unknown, eventType = " + paramInt);
      return;
    case 1: 
      this.liteEventListener.onTapEventTriggered(paramString, (HashMap)localObject, paramView);
      return;
    case 2: 
      this.liteEventListener.onExposureTriggered(paramString, (HashMap)localObject, paramView);
      return;
    case 3: 
      this.liteEventListener.onSwiperItemExposureTriggered(paramString, (HashMap)localObject, paramView);
      return;
    case 4: 
      this.liteEventListener.onSwiperDragTriggered(paramString, (HashMap)localObject, paramView);
      return;
    }
    this.liteEventListener.onScrollViewItemExposureTriggered(paramString, (HashMap)localObject, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance
 * JD-Core Version:    0.7.0.1
 */