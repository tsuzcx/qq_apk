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
  extends PTSNodeVirtual
{
  public PTSNodeScrollView(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance, "view", "scroll-view");
  }
  
  public void addChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if (isLeafNode())
    {
      paramPTSNodeVirtual = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[addChild] failed, can not add child for leaf node, nodeInfo = \n");
      ((StringBuilder)localObject).append(getNodeInfo());
      PTSLog.e(paramPTSNodeVirtual, ((StringBuilder)localObject).toString());
      return;
    }
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
    Object localObject = (PTSScrollView)getView();
    if (localObject != null) {
      ((PTSScrollView)localObject).addChild(paramPTSNodeVirtual.getView());
    }
  }
  
  public void removeChild(PTSNodeVirtual paramPTSNodeVirtual)
  {
    Object localObject;
    if (isLeafNode())
    {
      paramPTSNodeVirtual = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[removeChild] failed, can not remove child for leaf node, nodeInfo = \n");
      ((StringBuilder)localObject).append(getNodeInfo());
      PTSLog.e(paramPTSNodeVirtual, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.mChildren != null)
    {
      if (paramPTSNodeVirtual == null) {
        return;
      }
      this.mChildren.remove(paramPTSNodeVirtual);
      paramPTSNodeVirtual.setParent(null);
      localObject = (PTSScrollView)getView();
      if (localObject != null) {
        ((PTSScrollView)localObject).removeChild(paramPTSNodeVirtual.getView());
      }
    }
  }
  
  public void triggerItemViewExposure(int paramInt)
  {
    if (this.mChildren == null)
    {
      PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, mChildren is null.");
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.mChildren.size()))
    {
      Object localObject2 = ((PTSNodeVirtual)this.mChildren.get(paramInt)).getNodeInfo();
      PTSAppInstance localPTSAppInstance = getAppInstance();
      if ((localObject2 != null) && (localPTSAppInstance != null))
      {
        Object localObject1;
        Object localObject3;
        if (PTSLog.isDebug())
        {
          localObject1 = this.TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[triggerItemViewExposure], childIndex = ");
          ((StringBuilder)localObject3).append(paramInt);
          PTSLog.i((String)localObject1, ((StringBuilder)localObject3).toString());
        }
        if (localPTSAppInstance.isLiteAppInstance())
        {
          localObject1 = ((PTSNodeInfo)localObject2).getEventInfo();
          localObject2 = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject2).getAttributes().get("pts:on-scroll-item-exposure"));
          localObject3 = (PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance;
          IPTSLiteEventListener localIPTSLiteEventListener = ((PTSAppInstance.PTSLiteAppInstance)localObject3).getLiteEventListener();
          PTSLiteItemViewManager localPTSLiteItemViewManager = ((PTSAppInstance.PTSLiteAppInstance)localObject3).getLiteItemViewManager();
          if (localIPTSLiteEventListener != null)
          {
            ((PTSAppInstance.PTSLiteAppInstance)localObject3).triggerLiteEvent(5, (String)localObject2, (HashMap)localObject1, ((PTSScrollView)getView()).getChildAt(paramInt), localPTSAppInstance.getPtsComposer());
            return;
          }
          if (localPTSLiteItemViewManager != null) {
            localPTSLiteItemViewManager.triggerLiteEvent(5, (String)localObject2, (HashMap)localObject1, ((PTSScrollView)getView()).getChildAt(paramInt));
          }
        }
        return;
      }
      PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, nodeInfo is null or ptsAppInstance is null.");
      return;
    }
    PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, index is not valid.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeScrollView
 * JD-Core Version:    0.7.0.1
 */