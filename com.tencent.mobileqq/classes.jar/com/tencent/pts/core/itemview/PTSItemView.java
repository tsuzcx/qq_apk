package com.tencent.pts.core.itemview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSRootNode;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PTSItemView
  extends FrameLayout
{
  public final String TAG = "PTSItemView";
  private PTSAppInstance appInstance;
  private HashMap<String, List<PTSNodeVirtual>> viewIdToNodeListMap = new HashMap();
  
  public PTSItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void attachRootNode(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if (paramPTSNodeVirtual != null)
    {
      if (paramPTSNodeVirtual.getView() == null) {
        return;
      }
      if (paramPTSNodeVirtual.getView().getParent() == null) {
        addView(paramPTSNodeVirtual.getView());
      } else {
        PTSLog.d("PTSItemView", "[attachRootNode], do not attach again.");
      }
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        paramPTSNodeVirtual = new ViewGroup.LayoutParams(paramPTSNodeVirtual.getWidth(), paramPTSNodeVirtual.getHeight());
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).width = paramPTSNodeVirtual.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = paramPTSNodeVirtual.getHeight();
        paramPTSNodeVirtual = (PTSNodeVirtual)localObject;
      }
      if (PTSLog.isDebug())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[attachRootNode], lp.width = ");
        ((StringBuilder)localObject).append(paramPTSNodeVirtual.width);
        ((StringBuilder)localObject).append(", lp.height = ");
        ((StringBuilder)localObject).append(paramPTSNodeVirtual.height);
        PTSLog.i("PTSItemView", ((StringBuilder)localObject).toString());
      }
      setLayoutParams(paramPTSNodeVirtual);
    }
  }
  
  private void bindDataImpl(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    attachRootNode(PTSNodeFactory.bindData(paramPTSAppInstance, paramPTSNodeInfo, paramHashMap));
  }
  
  private void updateAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    this.appInstance = paramPTSAppInstance;
    this.appInstance.getRootNode().setRootView(this);
    Iterator localIterator = this.viewIdToNodeListMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.setPTSAppInstance(paramPTSAppInstance);
          }
        }
      }
    }
  }
  
  public void bindData(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null)
    {
      PTSLog.e("PTSItemView", "[bindData], appInstance is null.");
      return;
    }
    if (paramPTSAppInstance.getRootNode() == null)
    {
      PTSLog.e("PTSItemView", "[bindData], appInstance.getRootNode is null.");
      return;
    }
    updateAppInstance(paramPTSAppInstance);
    PTSNodeInfo localPTSNodeInfo = paramPTSAppInstance.getRootNode().getRootNodeInfo();
    if (localPTSNodeInfo == null)
    {
      PTSLog.i("PTSItemView", "[bindData], rootNodeInfo is null.");
      return;
    }
    bindDataImpl(paramPTSAppInstance, localPTSNodeInfo, this.viewIdToNodeListMap);
  }
  
  public PTSAppInstance getAppInstance()
  {
    return this.appInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemView
 * JD-Core Version:    0.7.0.1
 */