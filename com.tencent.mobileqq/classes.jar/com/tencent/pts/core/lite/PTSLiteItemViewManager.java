package com.tencent.pts.core.lite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.utils.PTSLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@Deprecated
public class PTSLiteItemViewManager
{
  public final String TAG = "PTSLiteItemViewManager";
  private Context context;
  private HashMap<String, PTSAppInstance> itemIdToAppInstanceMap;
  private IPTSLiteEventListener liteEventListener;
  
  public PTSLiteItemViewManager(Context paramContext)
  {
    this.context = paramContext;
    this.itemIdToAppInstanceMap = new HashMap();
  }
  
  private void bindData(PTSItemData paramPTSItemData, PTSItemView paramPTSItemView)
  {
    if ((paramPTSItemData == null) || (paramPTSItemView == null))
    {
      PTSLog.e("PTSLiteItemViewManager", "[bindData] error, itemData or ptsItemView is null.");
      return;
    }
    String str = paramPTSItemData.getItemID();
    if (TextUtils.isEmpty(str))
    {
      PTSLog.e("PTSLiteItemViewManager", "[bindData] error, itemId is null.");
      return;
    }
    PTSAppInstance localPTSAppInstance2 = (PTSAppInstance)this.itemIdToAppInstanceMap.get(str);
    PTSAppInstance localPTSAppInstance1 = localPTSAppInstance2;
    if (localPTSAppInstance2 == null)
    {
      localPTSAppInstance1 = new PTSAppInstance.Builder().withContext(this.context).withRootView(paramPTSItemView).withRootNodeType(1).withItemData(paramPTSItemData).withPageName(paramPTSItemData.getPageName()).withFrameTreeJson(paramPTSItemData.getFrameTreeJson()).withLiteItemViewManager(this).build();
      this.itemIdToAppInstanceMap.put(str, localPTSAppInstance1);
    }
    paramPTSItemView.bindData(localPTSAppInstance1);
    PTSThreadUtil.runOnSubThread(new PTSLiteItemViewManager.1(this, paramPTSItemData, localPTSAppInstance1));
  }
  
  private void destroyAppInstance()
  {
    if (this.itemIdToAppInstanceMap != null)
    {
      Iterator localIterator = this.itemIdToAppInstanceMap.values().iterator();
      while (localIterator.hasNext()) {
        ((PTSAppInstance)localIterator.next()).onDestroy();
      }
      this.itemIdToAppInstanceMap.clear();
    }
  }
  
  public void destroy()
  {
    PTSLog.i("PTSLiteItemViewManager", "[destroy]");
    destroyAppInstance();
  }
  
  public PTSItemView getView(View paramView, PTSItemData paramPTSItemData)
  {
    if ((paramView instanceof PTSItemView)) {}
    for (paramView = (PTSItemView)paramView;; paramView = new PTSItemView(this.context))
    {
      bindData(paramPTSItemData, paramView);
      return paramView;
    }
  }
  
  public void setLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    this.liteEventListener = paramIPTSLiteEventListener;
  }
  
  public void triggerLiteEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if (this.liteEventListener == null)
    {
      PTSLog.i("PTSLiteItemViewManager", "[triggerLiteEvent], liteEventListener is null.");
      return;
    }
    switch (paramInt)
    {
    default: 
      PTSLog.i("PTSLiteItemViewManager", "[triggerLiteEvent] unknown, eventType = " + paramInt);
      return;
    case 1: 
      this.liteEventListener.onTapEventTriggered(paramString, paramHashMap, paramView, null);
      return;
    case 2: 
      this.liteEventListener.onExposureTriggered(paramString, paramHashMap, paramView, null);
      return;
    case 3: 
      this.liteEventListener.onSwiperItemExposureTriggered(paramString, paramHashMap, paramView, null);
      return;
    case 4: 
      this.liteEventListener.onSwiperDragTriggered(paramString, paramHashMap, paramView, null);
      return;
    }
    this.liteEventListener.onScrollViewItemExposureTriggered(paramString, paramHashMap, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.PTSLiteItemViewManager
 * JD-Core Version:    0.7.0.1
 */