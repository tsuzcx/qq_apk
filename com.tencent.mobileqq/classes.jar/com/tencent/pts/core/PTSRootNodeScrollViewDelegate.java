package com.tencent.pts.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

public class PTSRootNodeScrollViewDelegate
  implements IPTSRootNodeDelegate
{
  private final String TAG = "PTSRootNodeScrollViewDelegate";
  private PTSAppInstance mAppInstance;
  private HashMap<String, PTSNodeVirtual> mNodeMap = new HashMap();
  private ScrollView mScrollView;
  
  PTSRootNodeScrollViewDelegate(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
  }
  
  private void clearNodeMap()
  {
    if (this.mScrollView.getChildCount() > 0) {
      this.mScrollView.removeAllViews();
    }
  }
  
  private PTSNodeVirtual getNodeVirtualByID(String paramString)
  {
    return (PTSNodeVirtual)this.mNodeMap.get(paramString);
  }
  
  private void putNodeIntoMap(PTSNodeInfo paramPTSNodeInfo, PTSNodeVirtual paramPTSNodeVirtual)
  {
    this.mNodeMap.put(paramPTSNodeInfo.getUniqueID(), paramPTSNodeVirtual);
  }
  
  private void removeNodeFromMap(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mNodeMap.remove(paramPTSNodeInfo.getUniqueID());
  }
  
  public boolean animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    PTSNodeVirtual localPTSNodeVirtual = getNodeVirtualByID(paramPTSNodeInfo.getUniqueID());
    boolean bool = false;
    if (localPTSNodeVirtual != null)
    {
      PTSAnimationUtil.playAnimation(paramAnimationInfo, localPTSNodeVirtual, localPTSNodeVirtual.getNodeInfo(), paramPTSNodeInfo);
      bool = true;
    }
    return bool;
  }
  
  public View getRootView()
  {
    return this.mScrollView;
  }
  
  public boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    boolean bool = true;
    PTSNodeVirtual localPTSNodeVirtual = PTSNodeFactory.buildVirtualNode(paramPTSNodeInfo, this.mAppInstance);
    if (paramPTSNodeInfo.isRootNode())
    {
      clearNodeMap();
      this.mScrollView.addView(localPTSNodeVirtual.getView());
    }
    for (;;)
    {
      putNodeIntoMap(paramPTSNodeInfo, localPTSNodeVirtual);
      PTSLog.i("PTSRootNodeScrollViewDelegate", "insert node, opRes = " + bool + ", nodeInfo = \n" + paramPTSNodeInfo);
      return bool;
      if (paramPTSNodeInfo.hasParent())
      {
        getNodeVirtualByID(paramPTSNodeInfo.getParentID()).addChild(localPTSNodeVirtual);
      }
      else
      {
        if (PTSLog.isDebug())
        {
          PTSLog.e("PTSRootNodeScrollViewDelegate", "insert exception, nodeInfo = \n" + paramPTSNodeInfo);
          throw new IllegalArgumentException("PTSRootNode insert exception, the node is not root node or has any parent node.");
        }
        bool = false;
      }
    }
  }
  
  public boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    PTSNodeVirtual localPTSNodeVirtual = getNodeVirtualByID(paramPTSNodeInfo.getUniqueID());
    boolean bool = false;
    if (localPTSNodeVirtual != null)
    {
      PTSLog.i("PTSRootNodeScrollViewDelegate", "modify node, \n old nodeInfo = \n" + localPTSNodeVirtual.getNodeInfo() + "\n new nodeInfo = \n" + paramPTSNodeInfo);
      localPTSNodeVirtual.bindNodeInfo(paramPTSNodeInfo);
      bool = true;
    }
    PTSLog.i("PTSRootNodeScrollViewDelegate", "modify node, opRes = " + bool);
    return bool;
  }
  
  public View onCreateNativeView()
  {
    this.mScrollView = new ScrollView(this.mAppInstance.getContext());
    return this.mScrollView;
  }
  
  public void onLayoutTempPatchFinished() {}
  
  public boolean refreshNodeList(List<PTSNodeInfo> paramList)
  {
    return false;
  }
  
  public boolean remove(int paramInt)
  {
    boolean bool = true;
    PTSNodeVirtual localPTSNodeVirtual1 = getNodeVirtualByID(String.valueOf(paramInt));
    PTSNodeInfo localPTSNodeInfo = localPTSNodeVirtual1.getNodeInfo();
    if (localPTSNodeInfo.isRootNode()) {
      this.mScrollView.removeView(localPTSNodeVirtual1.getView());
    }
    for (;;)
    {
      removeNodeFromMap(localPTSNodeInfo);
      PTSLog.i("PTSRootNodeScrollViewDelegate", "remove node, opRes = " + bool + ", new nodeInfo = \n" + localPTSNodeInfo);
      return bool;
      if (localPTSNodeInfo.hasParent())
      {
        PTSNodeVirtual localPTSNodeVirtual2 = localPTSNodeVirtual1.getParent();
        if (localPTSNodeVirtual2 != null) {
          localPTSNodeVirtual2.removeChild(localPTSNodeVirtual1);
        }
      }
      else if (PTSLog.isDebug())
      {
        PTSLog.e("PTSRootNodeScrollViewDelegate", "remove exception, nodeInfo = \n" + localPTSNodeInfo);
        throw new IllegalArgumentException("PTSRootNode remove exception, the node is not root node or has any parent node.");
      }
      bool = false;
    }
  }
  
  public void setRootView(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSRootNodeScrollViewDelegate
 * JD-Core Version:    0.7.0.1
 */