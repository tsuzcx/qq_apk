package com.tencent.pts.core.itemview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSRootNode;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class PTSItemView
  extends FrameLayout
{
  public final String TAG = "PTSItemView";
  private PTSAppInstance mAppInstance;
  private HashMap<String, PTSNodeVirtual> mViewIDToNodeMap = new HashMap();
  
  PTSItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void attachRootNode(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if ((paramPTSNodeVirtual == null) || (paramPTSNodeVirtual.getView() == null)) {
      return;
    }
    if (paramPTSNodeVirtual.getView().getParent() == null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      addView(paramPTSNodeVirtual.getView(), localLayoutParams);
      return;
    }
    PTSLog.d("PTSItemView", "[attachRootNode], do not attach again.");
  }
  
  private void bindDataImpl(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo)
  {
    HashMap localHashMap1 = this.mViewIDToNodeMap;
    HashMap localHashMap2 = new HashMap(localHashMap1);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    paramPTSNodeInfo = null;
    label321:
    for (;;)
    {
      PTSNodeInfo localPTSNodeInfo;
      Object localObject2;
      Object localObject1;
      if (!localLinkedList.isEmpty())
      {
        localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        localObject2 = localPTSNodeInfo.getAttributes().getViewID();
        localObject1 = (PTSNodeVirtual)localHashMap1.get(localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localHashMap2.remove(localObject2);
        }
        if (localObject1 == null)
        {
          localObject1 = PTSNodeFactory.buildVirtualNodeBFS(localPTSNodeInfo, paramPTSAppInstance, localHashMap1);
          if (localObject1 != null) {
            ((PTSNodeVirtual)localObject1).bindNodeInfo(localPTSNodeInfo);
          }
          if (localPTSNodeInfo.isRootNode())
          {
            paramPTSNodeInfo = (PTSNodeInfo)localObject1;
            localObject2 = localObject1;
            localObject1 = paramPTSNodeInfo;
            paramPTSNodeInfo = (PTSNodeInfo)localObject2;
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          ((PTSNodeVirtual)localObject1).showNode();
        }
        if (!localPTSNodeInfo.isContainer()) {
          break label321;
        }
        localLinkedList.addAll(localPTSNodeInfo.getChildren());
        break;
        if (localPTSNodeInfo.hasParent())
        {
          localObject2 = localPTSNodeInfo.getParentID();
          Iterator localIterator = localHashMap1.values().iterator();
          while (localIterator.hasNext())
          {
            PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)localIterator.next();
            if ((localPTSNodeVirtual.getNodeInfo() != null) && (TextUtils.equals(localPTSNodeVirtual.getNodeInfo().getUniqueID(), (CharSequence)localObject2)))
            {
              localPTSNodeVirtual.addChild((PTSNodeVirtual)localObject1);
              PTSLog.d("PTSItemView", "[bindDataImpl] has find parent node, currentNodeInfo = " + localPTSNodeInfo);
            }
          }
          continue;
          ((PTSNodeVirtual)localObject1).bindNodeInfo(localPTSNodeInfo);
          continue;
          paramPTSAppInstance = localHashMap2.values().iterator();
          while (paramPTSAppInstance.hasNext()) {
            ((PTSNodeVirtual)paramPTSAppInstance.next()).hideNode();
          }
          attachRootNode(paramPTSNodeInfo);
          return;
        }
      }
    }
  }
  
  private void updateAppInstance(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
    this.mAppInstance.getRootNode().setRootView(this);
    Iterator localIterator = this.mViewIDToNodeMap.values().iterator();
    while (localIterator.hasNext()) {
      ((PTSNodeVirtual)localIterator.next()).setPTSAppInstance(paramPTSAppInstance);
    }
  }
  
  void bindData(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null)
    {
      PTSLog.e("PTSItemView", "[bindData], appInstance is null.");
      return;
    }
    updateAppInstance(paramPTSAppInstance);
    PTSNodeInfo localPTSNodeInfo = paramPTSAppInstance.getRootNode().getRootNodeInfo();
    if (localPTSNodeInfo == null)
    {
      PTSLog.i("PTSItemView", "[bindData], rootNodeInfo is null.");
      return;
    }
    bindDataImpl(paramPTSAppInstance, localPTSNodeInfo);
  }
  
  public PTSAppInstance getAppInstance()
  {
    return this.mAppInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemView
 * JD-Core Version:    0.7.0.1
 */