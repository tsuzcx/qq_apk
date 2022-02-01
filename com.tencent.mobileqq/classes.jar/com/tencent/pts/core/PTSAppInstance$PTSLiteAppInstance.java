package com.tencent.pts.core;

import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
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
  
  public void triggerLiteEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              paramString = new StringBuilder();
              paramString.append("[triggerLiteEvent] unknown, eventType = ");
              paramString.append(paramInt);
              PTSLog.i("PTSAppInstance", paramString.toString());
              return;
            }
            this.liteEventListener.onScrollViewItemExposureTriggered(paramString, (HashMap)localObject, paramView, paramPTSComposer);
            return;
          }
          this.liteEventListener.onSwiperDragTriggered(paramString, (HashMap)localObject, paramView, paramPTSComposer);
          return;
        }
        this.liteEventListener.onSwiperItemExposureTriggered(paramString, (HashMap)localObject, paramView, paramPTSComposer);
        return;
      }
      this.liteEventListener.onExposureTriggered(paramString, (HashMap)localObject, paramView, paramPTSComposer);
      return;
    }
    this.liteEventListener.onTapEventTriggered(paramString, (HashMap)localObject, paramView, paramPTSComposer);
  }
  
  public String updateData(String paramString)
  {
    paramString = this.ptsLiteBridge.updateData(paramString, this);
    if (getItemData() != null) {
      this.itemData = new PTSItemData.Builder().withPageName(getItemData().getPageName()).withFrameTreeJson(getItemData().getFrameTreeJson()).withJsonData(paramString).build();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance
 * JD-Core Version:    0.7.0.1
 */