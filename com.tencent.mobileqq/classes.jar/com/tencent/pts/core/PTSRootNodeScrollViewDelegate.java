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
    if (localPTSNodeVirtual != null)
    {
      PTSAnimationUtil.playAnimation(paramAnimationInfo, localPTSNodeVirtual, localPTSNodeVirtual.getNodeInfo(), paramPTSNodeInfo);
      return true;
    }
    return false;
  }
  
  public View getRootView()
  {
    return this.mScrollView;
  }
  
  public boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    Object localObject = PTSNodeFactory.buildVirtualNode(paramPTSNodeInfo, this.mAppInstance);
    boolean bool2 = paramPTSNodeInfo.isRootNode();
    boolean bool1 = true;
    if (bool2)
    {
      clearNodeMap();
      this.mScrollView.addView(((PTSNodeVirtual)localObject).getView());
    }
    else if (paramPTSNodeInfo.hasParent())
    {
      getNodeVirtualByID(paramPTSNodeInfo.getParentID()).addChild((PTSNodeVirtual)localObject);
    }
    else
    {
      if (PTSLog.isDebug()) {
        break label131;
      }
      bool1 = false;
    }
    putNodeIntoMap(paramPTSNodeInfo, (PTSNodeVirtual)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insert node, opRes = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", nodeInfo = \n");
    ((StringBuilder)localObject).append(paramPTSNodeInfo);
    PTSLog.i("PTSRootNodeScrollViewDelegate", ((StringBuilder)localObject).toString());
    return bool1;
    label131:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insert exception, nodeInfo = \n");
    ((StringBuilder)localObject).append(paramPTSNodeInfo);
    PTSLog.e("PTSRootNodeScrollViewDelegate", ((StringBuilder)localObject).toString());
    throw new IllegalArgumentException("PTSRootNode insert exception, the node is not root node or has any parent node.");
  }
  
  public boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    PTSNodeVirtual localPTSNodeVirtual = getNodeVirtualByID(paramPTSNodeInfo.getUniqueID());
    boolean bool;
    if (localPTSNodeVirtual != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("modify node, \n old nodeInfo = \n");
      localStringBuilder.append(localPTSNodeVirtual.getNodeInfo());
      localStringBuilder.append("\n new nodeInfo = \n");
      localStringBuilder.append(paramPTSNodeInfo);
      PTSLog.i("PTSRootNodeScrollViewDelegate", localStringBuilder.toString());
      localPTSNodeVirtual.bindNodeInfo(paramPTSNodeInfo);
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramPTSNodeInfo = new StringBuilder();
    paramPTSNodeInfo.append("modify node, opRes = ");
    paramPTSNodeInfo.append(bool);
    PTSLog.i("PTSRootNodeScrollViewDelegate", paramPTSNodeInfo.toString());
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
    Object localObject = getNodeVirtualByID(String.valueOf(paramInt));
    PTSNodeInfo localPTSNodeInfo = ((PTSNodeVirtual)localObject).getNodeInfo();
    boolean bool2 = localPTSNodeInfo.isRootNode();
    boolean bool1 = true;
    if (bool2)
    {
      this.mScrollView.removeView(((PTSNodeVirtual)localObject).getView());
    }
    else
    {
      if (localPTSNodeInfo.hasParent())
      {
        PTSNodeVirtual localPTSNodeVirtual = ((PTSNodeVirtual)localObject).getParent();
        if (localPTSNodeVirtual != null)
        {
          localPTSNodeVirtual.removeChild((PTSNodeVirtual)localObject);
          break label82;
        }
      }
      else
      {
        if (PTSLog.isDebug()) {
          break label140;
        }
      }
      bool1 = false;
    }
    label82:
    removeNodeFromMap(localPTSNodeInfo);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("remove node, opRes = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", new nodeInfo = \n");
    ((StringBuilder)localObject).append(localPTSNodeInfo);
    PTSLog.i("PTSRootNodeScrollViewDelegate", ((StringBuilder)localObject).toString());
    return bool1;
    label140:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("remove exception, nodeInfo = \n");
    ((StringBuilder)localObject).append(localPTSNodeInfo);
    PTSLog.e("PTSRootNodeScrollViewDelegate", ((StringBuilder)localObject).toString());
    throw new IllegalArgumentException("PTSRootNode remove exception, the node is not root node or has any parent node.");
  }
  
  public void setRootView(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSRootNodeScrollViewDelegate
 * JD-Core Version:    0.7.0.1
 */