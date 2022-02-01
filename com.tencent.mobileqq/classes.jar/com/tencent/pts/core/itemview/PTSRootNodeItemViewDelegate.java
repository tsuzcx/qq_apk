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
    if ((this.mRootView == null) || (this.mAppInstance == null)) {}
    while (this.mAppInstance != this.mRootView.getAppInstance()) {
      return false;
    }
    return true;
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
    if (PTSLog.isDebug()) {
      PTSLog.d("PTSRootNodeItemViewDelegate", "[insert] insertIndex = " + paramInt + ", nodeInfo = " + paramPTSNodeInfo);
    }
    if (paramPTSNodeInfo == null) {
      return false;
    }
    if (paramPTSNodeInfo.isRootNode())
    {
      this.mRootNodeInfo = paramPTSNodeInfo;
      clearNodeInfoMap();
    }
    for (;;)
    {
      addToNodeInfoMap(paramPTSNodeInfo);
      return true;
      if (paramPTSNodeInfo.hasParent())
      {
        PTSNodeInfo localPTSNodeInfo = getNodeInfoByID(paramPTSNodeInfo.getParentID());
        if (localPTSNodeInfo != null) {
          localPTSNodeInfo.addChild(paramInt, paramPTSNodeInfo);
        } else {
          PTSLog.e("PTSRootNodeItemViewDelegate", "[insert] error, can not find parent nodeInfo, nodeInfo = " + paramPTSNodeInfo);
        }
      }
      else
      {
        PTSLog.e("PTSRootNodeItemViewDelegate", "[insert] error, index = " + paramInt + ", nodeInfo = \n" + paramPTSNodeInfo);
      }
    }
  }
  
  public boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    if (PTSLog.isDebug()) {
      PTSLog.d("PTSRootNodeItemViewDelegate", "[modify] nodeInfo = " + paramPTSNodeInfo);
    }
    if (paramPTSNodeInfo == null) {
      return false;
    }
    if (paramPTSNodeInfo.isRootNode())
    {
      if (this.mRootNodeInfo != null) {
        paramPTSNodeInfo.addChildren(this.mRootNodeInfo.getChildren());
      }
      this.mRootNodeInfo = paramPTSNodeInfo;
    }
    for (;;)
    {
      addToNodeInfoMap(paramPTSNodeInfo);
      return true;
      if (paramPTSNodeInfo.hasParent())
      {
        PTSNodeInfo localPTSNodeInfo1 = getNodeInfoByID(paramPTSNodeInfo.getParentID());
        if (localPTSNodeInfo1 != null)
        {
          List localList = localPTSNodeInfo1.getChildren();
          int i = 0;
          for (;;)
          {
            if (i >= localList.size()) {
              break label157;
            }
            PTSNodeInfo localPTSNodeInfo2 = (PTSNodeInfo)localList.get(i);
            if (localPTSNodeInfo2.equals(paramPTSNodeInfo))
            {
              paramPTSNodeInfo.addChildren(localPTSNodeInfo2.getChildren());
              localPTSNodeInfo1.setChild(i, paramPTSNodeInfo);
              break;
            }
            i += 1;
          }
        }
        else
        {
          label157:
          PTSLog.e("PTSRootNodeItemViewDelegate", "[modify] error, can not find parent nodeInfo, nodeInfo = " + paramPTSNodeInfo);
        }
      }
      else
      {
        PTSLog.e("PTSRootNodeItemViewDelegate", "[modify] error, nodeInfo does not have parent, nodeInfo = " + paramPTSNodeInfo);
      }
    }
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
    PTSNodeInfo localPTSNodeInfo1 = getNodeInfoByID(String.valueOf(paramInt));
    if (PTSLog.isDebug()) {
      PTSLog.d("PTSRootNodeItemViewDelegate", "[remove] nodeUniqueID = " + paramInt + ", nodeInfo = " + localPTSNodeInfo1);
    }
    if (localPTSNodeInfo1 == null)
    {
      PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] nodeInfo does not exists, nodeUniqueID = " + paramInt);
      return false;
    }
    if (localPTSNodeInfo1.isRootNode())
    {
      this.mRootNodeInfo = null;
      clearNodeInfoMap();
    }
    for (;;)
    {
      removeFromNodeInfoMap(localPTSNodeInfo1);
      return true;
      if (localPTSNodeInfo1.hasParent())
      {
        PTSNodeInfo localPTSNodeInfo2 = getNodeInfoByID(localPTSNodeInfo1.getParentID());
        if (localPTSNodeInfo2 != null) {
          localPTSNodeInfo2.removeChild(localPTSNodeInfo1);
        } else {
          PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] error, can not find parent nodeInfo, nodeUniqueID = " + paramInt);
        }
      }
      else
      {
        PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] error, nodeUniqueID = " + paramInt);
      }
    }
  }
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof PTSItemView)) {
      this.mRootView = ((PTSItemView)paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSRootNodeItemViewDelegate
 * JD-Core Version:    0.7.0.1
 */