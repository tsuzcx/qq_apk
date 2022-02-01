package com.tencent.pts.core.itemview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PTSItemViewManager
{
  public final String TAG = "PTSItemViewManager";
  private Activity activity;
  private PTSJSBridge jsBridge;
  private HashMap<String, PTSAppInstance> mItemIDToAppInstanceMap;
  
  public PTSItemViewManager(Activity paramActivity, String paramString1, String paramString2)
  {
    this.activity = paramActivity;
    this.jsBridge = PTSJSBridgeManager.getInstance().getJSBridge(paramActivity, paramString1, paramString2);
    this.mItemIDToAppInstanceMap = new HashMap();
  }
  
  private void bindData(PTSItemData paramPTSItemData, PTSItemView paramPTSItemView)
  {
    if ((paramPTSItemData != null) && (paramPTSItemView != null))
    {
      String str = paramPTSItemData.getItemID();
      if (TextUtils.isEmpty(str))
      {
        PTSLog.e("PTSItemViewManager", "[bindData] error, itemId is null.");
        return;
      }
      PTSAppInstance localPTSAppInstance2 = (PTSAppInstance)this.mItemIDToAppInstanceMap.get(str);
      PTSAppInstance localPTSAppInstance1 = localPTSAppInstance2;
      if (localPTSAppInstance2 == null)
      {
        localPTSAppInstance1 = new PTSAppInstance.Builder().withContext(this.activity).withRootView(paramPTSItemView).withRootNodeType(1).withPTSJSBridge(this.jsBridge).withItemData(paramPTSItemData).withPageName(paramPTSItemData.getPageName()).withFrameTreeJson(paramPTSItemData.getFrameTreeJson()).withPageJs(paramPTSItemData.getPageJs()).build();
        this.mItemIDToAppInstanceMap.put(str, localPTSAppInstance1);
      }
      paramPTSItemView.bindData(localPTSAppInstance1);
      PTSThreadUtil.runOnSubThread(new PTSItemViewManager.1(this, paramPTSItemData, localPTSAppInstance1));
      return;
    }
    PTSLog.e("PTSItemViewManager", "[bindData] error, itemData or ptsItemView is null.");
  }
  
  private void destroyAppInstance()
  {
    Object localObject = this.mItemIDToAppInstanceMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PTSAppInstance)((Iterator)localObject).next()).onDestroy();
      }
      this.mItemIDToAppInstanceMap.clear();
    }
  }
  
  public void destroy()
  {
    PTSLog.i("PTSItemViewManager", "[destroy].");
    destroyAppInstance();
    Activity localActivity = this.activity;
    if ((localActivity != null) && (localActivity.isFinishing()))
    {
      PTSLog.i("PTSItemViewManager", "[destroy], destroyJSBridge.");
      PTSJSBridgeManager.getInstance().destroyJSBridge(this.activity);
      return;
    }
    PTSLog.i("PTSItemViewManager", "[destroy], do not destroyJSBridge.");
  }
  
  public PTSItemView getView(View paramView, PTSItemData paramPTSItemData)
  {
    if ((paramView instanceof PTSItemView)) {
      paramView = (PTSItemView)paramView;
    } else {
      paramView = new PTSItemView(this.activity);
    }
    bindData(paramPTSItemData, paramView);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemViewManager
 * JD-Core Version:    0.7.0.1
 */