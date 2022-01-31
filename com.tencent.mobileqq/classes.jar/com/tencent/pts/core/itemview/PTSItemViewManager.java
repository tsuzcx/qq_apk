package com.tencent.pts.core.itemview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.utils.PTSLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PTSItemViewManager
{
  public final String TAG = "PTSItemViewManager";
  private Activity mActivity;
  private HashMap<String, PTSAppInstance> mItemIDToAppInstanceMap;
  private PTSJSBridge mJSBridge;
  
  public PTSItemViewManager(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mJSBridge = PTSJSBridgeManager.getInstance().getJSBridge(paramActivity);
    this.mItemIDToAppInstanceMap = new HashMap();
  }
  
  private void destroyAppInstance()
  {
    if (this.mItemIDToAppInstanceMap != null)
    {
      Iterator localIterator = this.mItemIDToAppInstanceMap.values().iterator();
      while (localIterator.hasNext()) {
        ((PTSAppInstance)localIterator.next()).onDestroy();
      }
      this.mItemIDToAppInstanceMap.clear();
    }
  }
  
  private PTSAppInstance getAppInstanceByItemData(PTSItemData paramPTSItemData, PTSItemView paramPTSItemView)
  {
    Object localObject = null;
    if (paramPTSItemData == null) {
      PTSLog.e("PTSItemViewManager", "[getAppInstanceByItemData], data is null.");
    }
    String str;
    PTSAppInstance localPTSAppInstance;
    do
    {
      return localObject;
      str = paramPTSItemData.getItemID();
      if (TextUtils.isEmpty(str))
      {
        PTSLog.e("PTSItemViewManager", "[getAppInstanceByItemData], itemID is null.");
        return null;
      }
      localPTSAppInstance = (PTSAppInstance)this.mItemIDToAppInstanceMap.get(str);
      localObject = localPTSAppInstance;
    } while (localPTSAppInstance != null);
    paramPTSItemData = new PTSAppInstance.Builder().withActivity(this.mActivity).withRootView(paramPTSItemView).withRootNodeType(1).withPTSJSBridge(this.mJSBridge).withItemData(paramPTSItemData).withAppName(paramPTSItemData.getAppName()).withAppPath(paramPTSItemData.getAppPath()).build();
    this.mItemIDToAppInstanceMap.put(str, paramPTSItemData);
    return paramPTSItemData;
  }
  
  public void destroy()
  {
    PTSLog.i("PTSItemViewManager", "[destroy].");
    destroyAppInstance();
    if ((this.mActivity != null) && (this.mActivity.isFinishing()))
    {
      PTSLog.i("PTSItemViewManager", "[destroy], destroyJSBridge.");
      PTSJSBridgeManager.getInstance().destroyJSBridge(this.mActivity);
      return;
    }
    PTSLog.i("PTSItemViewManager", "[destroy], do not destroyJSBridge.");
  }
  
  public PTSItemView getView(View paramView, PTSItemData paramPTSItemData)
  {
    if ((paramView instanceof PTSItemView)) {}
    for (paramView = (PTSItemView)paramView;; paramView = new PTSItemView(this.mActivity))
    {
      paramView.bindData(getAppInstanceByItemData(paramPTSItemData, paramView));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemViewManager
 * JD-Core Version:    0.7.0.1
 */