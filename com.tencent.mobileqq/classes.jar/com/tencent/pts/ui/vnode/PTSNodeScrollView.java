package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.PTSScrollView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PTSNodeScrollView
  extends PTSNodeVirtual<PTSScrollView>
{
  public PTSNodeScrollView(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public void addChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if (isLeafNode()) {
      PTSLog.e(this.TAG, "[addChild] failed, can not add child for leaf node, nodeInfo = \n" + getNodeInfo());
    }
    PTSScrollView localPTSScrollView;
    do
    {
      return;
      if (this.mChildren == null) {
        this.mChildren = new ArrayList();
      }
      if (paramPTSNodeVirtual == null)
      {
        PTSLog.e(this.TAG, "[addChild] failed, child is null.");
        return;
      }
      this.mChildren.add(paramPTSNodeVirtual);
      paramPTSNodeVirtual.setParent(this);
      localPTSScrollView = (PTSScrollView)getView();
    } while (localPTSScrollView == null);
    localPTSScrollView.addChild(paramPTSNodeVirtual.getView());
  }
  
  public void removeChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if (isLeafNode()) {
      PTSLog.e(this.TAG, "[removeChild] failed, can not remove child for leaf node, nodeInfo = \n" + getNodeInfo());
    }
    PTSScrollView localPTSScrollView;
    do
    {
      do
      {
        return;
      } while ((this.mChildren == null) || (paramPTSNodeVirtual == null));
      this.mChildren.remove(paramPTSNodeVirtual);
      paramPTSNodeVirtual.setParent(null);
      localPTSScrollView = (PTSScrollView)getView();
    } while (localPTSScrollView == null);
    localPTSScrollView.removeChild(paramPTSNodeVirtual.getView());
  }
  
  public void triggerItemViewExposure(int paramInt)
  {
    if (this.mChildren == null) {
      PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, mChildren is null.");
    }
    Object localObject;
    HashMap localHashMap;
    PTSLiteItemViewManager localPTSLiteItemViewManager;
    do
    {
      PTSAppInstance localPTSAppInstance;
      do
      {
        return;
        if ((paramInt < 0) || (paramInt >= this.mChildren.size()))
        {
          PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, index is not valid.");
          return;
        }
        localObject = ((PTSNodeVirtual)this.mChildren.get(paramInt)).getNodeInfo();
        localPTSAppInstance = getAppInstance();
        if ((localObject == null) || (localPTSAppInstance == null))
        {
          PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, nodeInfo is null or ptsAppInstance is null.");
          return;
        }
        if (PTSLog.isDebug()) {
          PTSLog.i(this.TAG, "[triggerItemViewExposure], childIndex = " + paramInt);
        }
      } while (!localPTSAppInstance.isLiteAppInstance());
      localHashMap = ((PTSNodeInfo)localObject).getEventInfo();
      localObject = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject).getAttributes().get("pts:on-scroll-item-exposure"));
      IPTSLiteEventListener localIPTSLiteEventListener = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteEventListener();
      localPTSLiteItemViewManager = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteItemViewManager();
      if (localIPTSLiteEventListener != null)
      {
        ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).triggerLiteEvent(5, (String)localObject, localHashMap, ((PTSScrollView)getView()).getChildAt(paramInt));
        return;
      }
    } while (localPTSLiteItemViewManager == null);
    localPTSLiteItemViewManager.triggerLiteEvent(5, (String)localObject, localHashMap, ((PTSScrollView)getView()).getChildAt(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeScrollView
 * JD-Core Version:    0.7.0.1
 */