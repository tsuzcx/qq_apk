package com.tencent.pts.core.itemview;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.pts.core.IPTSRootNodeDelegate;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

public class PTSRootNodeItemViewDelegate
  implements IPTSRootNodeDelegate
{
  public final String TAG = "PTSRootNodeItemViewDelegate";
  private PTSAppInstance mAppInstance;
  private HashMap<String, PTSNodeInfo> mIDToNodeInfoMap;
  private PTSNodeInfo mRootNodeInfo;
  private PTSItemView mRootView;
  
  public PTSRootNodeItemViewDelegate(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
    this.mIDToNodeInfoMap = new HashMap();
  }
  
  private void addToNodeInfoMap(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo == null) {
      return;
    }
    this.mIDToNodeInfoMap.put(paramPTSNodeInfo.getUniqueID(), paramPTSNodeInfo);
  }
  
  private void clearNodeInfoMap()
  {
    this.mIDToNodeInfoMap.clear();
  }
  
  private PTSNodeInfo getNodeInfoByID(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (PTSNodeInfo)this.mIDToNodeInfoMap.get(paramString);
  }
  
  private boolean isSameAppInstance()
  {
    PTSItemView localPTSItemView = this.mRootView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPTSItemView != null)
    {
      PTSAppInstance localPTSAppInstance = this.mAppInstance;
      if (localPTSAppInstance == null) {
        return false;
      }
      bool1 = bool2;
      if (localPTSAppInstance == localPTSItemView.getAppInstance()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void removeFromNodeInfoMap(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo == null) {
      return;
    }
    this.mIDToNodeInfoMap.remove(paramPTSNodeInfo.getUniqueID());
  }
  
  public boolean animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    return true;
  }
  
  public PTSNodeInfo getRootNodeInfo()
  {
    return this.mRootNodeInfo;
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    Object localObject;
    if (PTSLog.isDebug())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[insert] insertIndex = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", nodeInfo = ");
      ((StringBuilder)localObject).append(paramPTSNodeInfo);
      PTSLog.d("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
    }
    if (paramPTSNodeInfo == null) {
      return false;
    }
    if (paramPTSNodeInfo.isRootNode())
    {
      this.mRootNodeInfo = paramPTSNodeInfo;
      clearNodeInfoMap();
    }
    else if (paramPTSNodeInfo.hasParent())
    {
      localObject = getNodeInfoByID(paramPTSNodeInfo.getParentID());
      if (localObject != null)
      {
        ((PTSNodeInfo)localObject).addChild(paramInt, paramPTSNodeInfo);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[insert] error, can not find parent nodeInfo, nodeInfo = ");
        ((StringBuilder)localObject).append(paramPTSNodeInfo);
        PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[insert] error, index = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", nodeInfo = \n");
      ((StringBuilder)localObject).append(paramPTSNodeInfo);
      PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
    }
    addToNodeInfoMap(paramPTSNodeInfo);
    return true;
  }
  
  public boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    Object localObject;
    if (PTSLog.isDebug())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[modify] nodeInfo = ");
      ((StringBuilder)localObject).append(paramPTSNodeInfo);
      PTSLog.d("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
    }
    int i = 0;
    if (paramPTSNodeInfo == null) {
      return false;
    }
    if (paramPTSNodeInfo.isRootNode())
    {
      localObject = this.mRootNodeInfo;
      if (localObject != null) {
        paramPTSNodeInfo.addChildren(((PTSNodeInfo)localObject).getChildren());
      }
      this.mRootNodeInfo = paramPTSNodeInfo;
    }
    else if (paramPTSNodeInfo.hasParent())
    {
      localObject = getNodeInfoByID(paramPTSNodeInfo.getParentID());
      if (localObject != null)
      {
        List localList = ((PTSNodeInfo)localObject).getChildren();
        while (i < localList.size())
        {
          PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localList.get(i);
          if (localPTSNodeInfo.equals(paramPTSNodeInfo))
          {
            paramPTSNodeInfo.addChildren(localPTSNodeInfo.getChildren());
            ((PTSNodeInfo)localObject).setChild(i, paramPTSNodeInfo);
            break;
          }
          i += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[modify] error, can not find parent nodeInfo, nodeInfo = ");
      ((StringBuilder)localObject).append(paramPTSNodeInfo);
      PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[modify] error, nodeInfo does not have parent, nodeInfo = ");
      ((StringBuilder)localObject).append(paramPTSNodeInfo);
      PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject).toString());
    }
    addToNodeInfoMap(paramPTSNodeInfo);
    return true;
  }
  
  public View onCreateNativeView()
  {
    return null;
  }
  
  public void onLayoutTempPatchFinished()
  {
    if (isSameAppInstance())
    {
      this.mRootView.bindData(this.mAppInstance);
      return;
    }
    PTSLog.i("PTSRootNodeItemViewDelegate", "[onLayoutTempPatchFinished], do not update, not the valid appInstance or the rootView is null.");
  }
  
  public boolean refreshNodeList(List<PTSNodeInfo> paramList)
  {
    return false;
  }
  
  public boolean remove(int paramInt)
  {
    Object localObject1 = getNodeInfoByID(String.valueOf(paramInt));
    Object localObject2;
    if (PTSLog.isDebug())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[remove] nodeUniqueID = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", nodeInfo = ");
      ((StringBuilder)localObject2).append(localObject1);
      PTSLog.d("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[remove] nodeInfo does not exists, nodeUniqueID = ");
      ((StringBuilder)localObject1).append(paramInt);
      PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject1).toString());
      return false;
    }
    if (((PTSNodeInfo)localObject1).isRootNode())
    {
      this.mRootNodeInfo = null;
      clearNodeInfoMap();
    }
    else if (((PTSNodeInfo)localObject1).hasParent())
    {
      localObject2 = getNodeInfoByID(((PTSNodeInfo)localObject1).getParentID());
      if (localObject2 != null)
      {
        ((PTSNodeInfo)localObject2).removeChild((PTSNodeInfo)localObject1);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[remove] error, can not find parent nodeInfo, nodeUniqueID = ");
        ((StringBuilder)localObject2).append(paramInt);
        PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[remove] error, nodeUniqueID = ");
      ((StringBuilder)localObject2).append(paramInt);
      PTSLog.e("PTSRootNodeItemViewDelegate", ((StringBuilder)localObject2).toString());
    }
    removeFromNodeInfoMap((PTSNodeInfo)localObject1);
    return true;
  }
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof PTSItemView)) {
      this.mRootView = ((PTSItemView)paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSRootNodeItemViewDelegate
 * JD-Core Version:    0.7.0.1
 */