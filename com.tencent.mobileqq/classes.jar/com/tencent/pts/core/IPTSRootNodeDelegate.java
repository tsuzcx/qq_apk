package com.tencent.pts.core;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import java.util.List;

public abstract interface IPTSRootNodeDelegate
{
  public abstract boolean animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo);
  
  public abstract boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt);
  
  public abstract boolean modify(PTSNodeInfo paramPTSNodeInfo);
  
  public abstract View onCreateNativeView();
  
  public abstract void onLayoutTempPatchFinished();
  
  public abstract boolean refreshNodeList(List<PTSNodeInfo> paramList);
  
  public abstract boolean remove(int paramInt);
  
  public abstract void setRootView(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.IPTSRootNodeDelegate
 * JD-Core Version:    0.7.0.1
 */