package com.tencent.pts.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PTSRecyclerViewAdapter
  extends RecyclerView.Adapter<PTSRecyclerViewAdapter.PTSViewHolder>
{
  private final String TAG = "PTSRecyclerViewAdapter";
  private PTSAppInstance mAppInstance;
  private List<PTSNodeInfo> mData = new ArrayList();
  private HashMap<String, PTSNodeInfo> mUniqueIDToNodeInfoMap = new HashMap();
  private SparseArray<PTSNodeInfo> mViewTypeToNodeInfoMap = new SparseArray();
  
  public PTSRecyclerViewAdapter(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
  }
  
  private void addIDToNodeInfoMap(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      while (!localLinkedList.isEmpty())
      {
        paramPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        this.mUniqueIDToNodeInfoMap.put(paramPTSNodeInfo.getUniqueID(), paramPTSNodeInfo);
        if (paramPTSNodeInfo.hasChildren()) {
          localLinkedList.addAll(paramPTSNodeInfo.getChildren());
        }
      }
    }
    PTSLog.i("PTSRecyclerViewAdapter", "[addIDToNodeInfoMap], nodeInfo is null.");
  }
  
  private void bindNodeInfo(PTSRecyclerViewAdapter.PTSViewHolder paramPTSViewHolder, PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    PTSNodeFactory.bindData(paramPTSAppInstance, paramPTSNodeInfo, PTSRecyclerViewAdapter.PTSViewHolder.access$000(paramPTSViewHolder));
  }
  
  private PTSNodeInfo getNodeInfoByID(String paramString)
  {
    return (PTSNodeInfo)this.mUniqueIDToNodeInfoMap.get(paramString);
  }
  
  private void removeIDToNodeInfoMap(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo != null)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      while (!localLinkedList.isEmpty())
      {
        paramPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        this.mUniqueIDToNodeInfoMap.remove(paramPTSNodeInfo.getUniqueID());
        if (paramPTSNodeInfo.hasChildren()) {
          localLinkedList.addAll(paramPTSNodeInfo.getChildren());
        }
      }
    }
    PTSLog.i("PTSRecyclerViewAdapter", "[removeIDToNodeInfoMap], nodeInfo is null.");
  }
  
  private void saveUniqueIDToNodeInfoMap(List<PTSNodeInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      PTSTimeCostUtil.start("[saveUniqueIDToNodeInfoMap]");
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addIDToNodeInfoMap((PTSNodeInfo)paramList.next());
      }
      PTSTimeCostUtil.end("[saveUniqueIDToNodeInfoMap]");
    }
  }
  
  public void animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo) {}
  
  public int getItemCount()
  {
    List localList = this.mData;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)this.mData.get(paramInt);
    try
    {
      int i = Integer.valueOf(localPTSNodeInfo.getAttributes().getPTSCellType()).intValue();
      paramInt = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramInt += this.mData.size();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getItemViewType], e = ");
      localStringBuilder.append(localNumberFormatException);
      localStringBuilder.append(", ptsCellType = ");
      localStringBuilder.append(paramInt);
      PTSLog.e("PTSRecyclerViewAdapter", localStringBuilder.toString());
    }
    if (this.mViewTypeToNodeInfoMap.get(paramInt) == null) {
      this.mViewTypeToNodeInfoMap.put(paramInt, localPTSNodeInfo);
    }
    return paramInt;
  }
  
  public void insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    Object localObject = getNodeInfoByID(paramPTSNodeInfo.getParentID());
    if (localObject != null)
    {
      ((PTSNodeInfo)localObject).addChild(paramPTSNodeInfo);
    }
    else if (paramInt > this.mData.size())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[insert] insertIndex error, insertIndex = ");
      ((StringBuilder)localObject).append(paramInt);
      PTSLog.e("PTSRecyclerViewAdapter", ((StringBuilder)localObject).toString());
      this.mData.add(paramPTSNodeInfo);
    }
    else
    {
      this.mData.add(paramInt, paramPTSNodeInfo);
    }
    addIDToNodeInfoMap(paramPTSNodeInfo);
  }
  
  public void modify(PTSNodeInfo paramPTSNodeInfo)
  {
    PTSNodeInfo localPTSNodeInfo1 = getNodeInfoByID(paramPTSNodeInfo.getParentID());
    int i = 0;
    int j = 0;
    if (localPTSNodeInfo1 != null)
    {
      List localList = localPTSNodeInfo1.getChildren();
      i = j;
      while (i < localList.size())
      {
        PTSNodeInfo localPTSNodeInfo2 = (PTSNodeInfo)localList.get(i);
        if (localPTSNodeInfo2.equals(paramPTSNodeInfo))
        {
          paramPTSNodeInfo.addChildren(localPTSNodeInfo2.getChildren());
          localPTSNodeInfo1.setChild(i, paramPTSNodeInfo);
          addIDToNodeInfoMap(paramPTSNodeInfo);
          PTSLog.d("PTSRecyclerViewAdapter", "[modify] update child.");
          return;
        }
        i += 1;
      }
    }
    while (i < this.mData.size())
    {
      localPTSNodeInfo1 = (PTSNodeInfo)this.mData.get(i);
      if (localPTSNodeInfo1.equals(paramPTSNodeInfo))
      {
        paramPTSNodeInfo.addChildren(localPTSNodeInfo1.getChildren());
        this.mData.set(i, paramPTSNodeInfo);
        addIDToNodeInfoMap(paramPTSNodeInfo);
        PTSLog.d("PTSRecyclerViewAdapter", "[modify] update mData child.");
        return;
      }
      i += 1;
    }
  }
  
  public void onBindViewHolder(@NonNull PTSRecyclerViewAdapter.PTSViewHolder paramPTSViewHolder, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onBindViewHolder], position = ");
    ((StringBuilder)localObject).append(paramInt);
    PTSTimeCostUtil.start(((StringBuilder)localObject).toString());
    localObject = (PTSNodeInfo)this.mData.get(paramInt);
    bindNodeInfo(paramPTSViewHolder, (PTSNodeInfo)localObject, this.mAppInstance);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onBindViewHolder] position = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", nodeInfo = ");
    localStringBuilder.append(localObject);
    PTSLog.d("PTSRecyclerViewAdapter", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onBindViewHolder], position = ");
    ((StringBuilder)localObject).append(paramInt);
    PTSTimeCostUtil.end(((StringBuilder)localObject).toString());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramPTSViewHolder, paramInt, getItemId(paramInt));
  }
  
  @NonNull
  public PTSRecyclerViewAdapter.PTSViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onCreateViewHolder], viewType = ");
    ((StringBuilder)localObject1).append(paramInt);
    PTSTimeCostUtil.start(((StringBuilder)localObject1).toString());
    localObject1 = (PTSNodeInfo)this.mViewTypeToNodeInfoMap.get(paramInt);
    if (localObject1 == null)
    {
      PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], no this viewType.");
      if (PTSLog.isDebug()) {
        throw new IllegalArgumentException("[onCreateViewHolder], no this viewType.");
      }
    }
    Object localObject5 = new HashMap();
    Object localObject4 = PTSNodeFactory.buildVirtualNodeBFS((PTSNodeInfo)localObject1, this.mAppInstance, (HashMap)localObject5);
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], create null parent node.");
      if (!PTSLog.isDebug()) {
        localObject1 = new PTSNodeView(this.mAppInstance);
      } else {
        throw new IllegalArgumentException("[onCreateViewHolder], create null parent node.");
      }
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("[onCreateViewHolder], viewType = ");
    ((StringBuilder)localObject4).append(paramInt);
    PTSTimeCostUtil.end(((StringBuilder)localObject4).toString());
    localObject4 = null;
    Object localObject3;
    try
    {
      localObject1 = new PTSRecyclerViewAdapter.PTSViewHolder((PTSNodeVirtual)localObject1, (HashMap)localObject5);
    }
    catch (Exception localException)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("[onCreateViewHolder], viewType = ");
      ((StringBuilder)localObject5).append(paramInt);
      ((StringBuilder)localObject5).append(", e = ");
      ((StringBuilder)localObject5).append(localException);
      PTSLog.e("PTSRecyclerViewAdapter", ((StringBuilder)localObject5).toString());
      Object localObject2 = localObject4;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("[onCreateViewHolder], viewType = ");
      ((StringBuilder)localObject5).append(paramInt);
      ((StringBuilder)localObject5).append(", e = ");
      ((StringBuilder)localObject5).append(localIllegalArgumentException);
      PTSLog.e("PTSRecyclerViewAdapter", ((StringBuilder)localObject5).toString());
      localObject3 = localObject4;
    }
    localObject4 = localObject3;
    if (localObject3 == null)
    {
      paramViewGroup = new FrameLayout(paramViewGroup.getContext());
      paramViewGroup.setVisibility(8);
      localObject4 = new PTSRecyclerViewAdapter.PTSViewHolder(paramViewGroup);
      PTSLog.i("PTSRecyclerViewAdapter", "[onCreateViewHolder], use empty container.");
    }
    return localObject4;
  }
  
  public void onLayoutTempPatchFinished()
  {
    notifyDataSetChanged();
  }
  
  public void remove(int paramInt)
  {
    PTSNodeInfo localPTSNodeInfo1 = getNodeInfoByID(String.valueOf(paramInt));
    if (localPTSNodeInfo1 != null)
    {
      PTSNodeInfo localPTSNodeInfo2 = getNodeInfoByID(localPTSNodeInfo1.getParentID());
      if (localPTSNodeInfo2 != null) {
        localPTSNodeInfo2.removeChild(localPTSNodeInfo1);
      } else {
        this.mData.remove(localPTSNodeInfo1);
      }
      removeIDToNodeInfoMap(localPTSNodeInfo1);
    }
  }
  
  public void setData(List<PTSNodeInfo> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    notifyDataSetChanged();
    saveUniqueIDToNodeInfoMap(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */