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
    if ((paramPTSItemData != null) && (paramPTSItemView != null))
    {
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
      return;
    }
    PTSLog.e("PTSLiteItemViewManager", "[bindData] error, itemData or ptsItemView is null.");
  }
  
  private void destroyAppInstance()
  {
    Object localObject = this.itemIdToAppInstanceMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PTSAppInstance)((Iterator)localObject).next()).onDestroy();
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
    if ((paramView instanceof PTSItemView)) {
      paramView = (PTSItemView)paramView;
    } else {
      paramView = new PTSItemView(this.context);
    }
    bindData(paramPTSItemData, paramView);
    return paramView;
  }
  
  public void setLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    this.liteEventListener = paramIPTSLiteEventListener;
  }
  
  public void triggerLiteEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    IPTSLiteEventListener localIPTSLiteEventListener = this.liteEventListener;
    if (localIPTSLiteEventListener == null)
    {
      PTSLog.i("PTSLiteItemViewManager", "[triggerLiteEvent], liteEventListener is null.");
      return;
    }
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
              PTSLog.i("PTSLiteItemViewManager", paramString.toString());
              return;
            }
            localIPTSLiteEventListener.onScrollViewItemExposureTriggered(paramString, paramHashMap, paramView, null);
            return;
          }
          localIPTSLiteEventListener.onSwiperDragTriggered(paramString, paramHashMap, paramView, null);
          return;
        }
        localIPTSLiteEventListener.onSwiperItemExposureTriggered(paramString, paramHashMap, paramView, null);
        return;
      }
      localIPTSLiteEventListener.onExposureTriggered(paramString, paramHashMap, paramView, null);
      return;
    }
    localIPTSLiteEventListener.onTapEventTriggered(paramString, paramHashMap, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.PTSLiteItemViewManager
 * JD-Core Version:    0.7.0.1
 */