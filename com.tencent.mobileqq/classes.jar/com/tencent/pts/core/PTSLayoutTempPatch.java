package com.tencent.pts.core;

import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PTSLayoutTempPatch
{
  public static final int PTS_LAYOUT_PATCH_INSERT_CHILD = 2;
  public static final int PTS_LAYOUT_PATCH_MODIFY = 1;
  public static final int PTS_LAYOUT_PATCH_NONE = 0;
  public static final int PTS_LAYOUT_PATCH_REMOVE_CHILD = 4;
  public static final int PTS_LAYOUT_PATCH_REORDER_CHILD = 8;
  public List<PTSLayoutTempPatch.PTSAnimationSet> animationNodeList = new ArrayList();
  public int layoutPatchType;
  public List<PTSLayoutTempPatch.PTSNodeInfoInsert> newNodeInfoList = new ArrayList();
  public PTSNodeInfo nodeInfo;
  public List<Integer> removeNodeIDList = new ArrayList();
  
  static void applyLayoutTempPatchList(List<PTSLayoutTempPatch> paramList, PTSAppInstance paramPTSAppInstance)
  {
    if ((paramPTSAppInstance == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (PTSLayoutTempPatch)paramList.get(i);
      Object localObject2;
      Object localObject3;
      if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x2) > 0) && (((PTSLayoutTempPatch)localObject1).newNodeInfoList != null))
      {
        localObject2 = ((PTSLayoutTempPatch)localObject1).newNodeInfoList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PTSLayoutTempPatch.PTSNodeInfoInsert)((Iterator)localObject2).next();
          paramPTSAppInstance.getRootNode().insert(((PTSLayoutTempPatch.PTSNodeInfoInsert)localObject3).nodeInfo, ((PTSLayoutTempPatch.PTSNodeInfoInsert)localObject3).insertIndex);
        }
      }
      if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x4) > 0) && (((PTSLayoutTempPatch)localObject1).removeNodeIDList != null))
      {
        localObject2 = ((PTSLayoutTempPatch)localObject1).removeNodeIDList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          paramPTSAppInstance.getRootNode().remove(((Integer)localObject3).intValue());
        }
      }
      if ((((PTSLayoutTempPatch)localObject1).animationNodeList != null) && (!((PTSLayoutTempPatch)localObject1).animationNodeList.isEmpty())) {
        localObject1 = ((PTSLayoutTempPatch)localObject1).animationNodeList.iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PTSLayoutTempPatch.PTSAnimationSet)((Iterator)localObject1).next();
        paramPTSAppInstance.getRootNode().animation(PTSLayoutTempPatch.PTSAnimationSet.access$000((PTSLayoutTempPatch.PTSAnimationSet)localObject2), PTSLayoutTempPatch.PTSAnimationSet.access$100((PTSLayoutTempPatch.PTSAnimationSet)localObject2));
        continue;
        if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x1) > 0) && (((PTSLayoutTempPatch)localObject1).nodeInfo != null)) {
          paramPTSAppInstance.getRootNode().modify(((PTSLayoutTempPatch)localObject1).nodeInfo);
        }
      }
      i += 1;
    }
    paramPTSAppInstance.getRootNode().onLayoutTempPatchFinished();
  }
  
  public void appendAnimation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    PTSLayoutTempPatch.PTSAnimationSet localPTSAnimationSet = new PTSLayoutTempPatch.PTSAnimationSet();
    PTSLayoutTempPatch.PTSAnimationSet.access$002(localPTSAnimationSet, paramPTSNodeInfo);
    PTSLayoutTempPatch.PTSAnimationSet.access$102(localPTSAnimationSet, paramAnimationInfo);
    this.animationNodeList.add(localPTSAnimationSet);
  }
  
  public void appendNewNodeInfo(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    PTSLayoutTempPatch.PTSNodeInfoInsert localPTSNodeInfoInsert = new PTSLayoutTempPatch.PTSNodeInfoInsert();
    localPTSNodeInfoInsert.nodeInfo = paramPTSNodeInfo;
    localPTSNodeInfoInsert.insertIndex = paramInt;
    this.newNodeInfoList.add(localPTSNodeInfoInsert);
  }
  
  public void appendRemoveNodeID(int paramInt)
  {
    this.removeNodeIDList.add(Integer.valueOf(paramInt));
  }
  
  public void setLayoutPatchType(int paramInt)
  {
    this.layoutPatchType = paramInt;
  }
  
  public void setNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.nodeInfo = paramPTSNodeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSLayoutTempPatch
 * JD-Core Version:    0.7.0.1
 */