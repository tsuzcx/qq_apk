package com.tencent.pts.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import java.util.ArrayList;
import java.util.Collection;
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
    HashMap localHashMap1 = PTSRecyclerViewAdapter.PTSViewHolder.access$000(paramPTSViewHolder);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    if (!localLinkedList.isEmpty())
    {
      paramPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
      String str = paramPTSNodeInfo.getAttributes().getViewID();
      paramPTSViewHolder = (PTSNodeVirtual)localHashMap1.get(str);
      localHashMap2.remove(str);
      if (paramPTSViewHolder == null)
      {
        paramPTSViewHolder = PTSNodeFactory.buildVirtualNodeBFS(paramPTSNodeInfo, paramPTSAppInstance, localHashMap1);
        if (paramPTSViewHolder != null) {
          paramPTSViewHolder.bindNodeInfo(paramPTSNodeInfo);
        }
        str = paramPTSNodeInfo.getParentID();
        Iterator localIterator = localHashMap1.values().iterator();
        while (localIterator.hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)localIterator.next();
          if ((localPTSNodeVirtual.getNodeInfo() != null) && (TextUtils.equals(localPTSNodeVirtual.getNodeInfo().getUniqueID(), str)))
          {
            localPTSNodeVirtual.addChild(paramPTSViewHolder);
            if (PTSLog.isDebug()) {
              PTSLog.d("PTSRecyclerViewAdapter", "[bindNodeInfo], has found parent node.");
            }
          }
        }
        if ((paramPTSViewHolder != null) && (!TextUtils.isEmpty(paramPTSViewHolder.getViewID()))) {
          localHashMap1.put(paramPTSViewHolder.getViewID(), paramPTSViewHolder);
        }
      }
      for (;;)
      {
        if (paramPTSViewHolder != null) {
          paramPTSViewHolder.showNode();
        }
        if (!paramPTSNodeInfo.isContainer()) {
          break;
        }
        localLinkedList.addAll(paramPTSNodeInfo.getChildren());
        break;
        PTSLog.e("PTSRecyclerViewAdapter", "[bindNodeInfo], currentNode is null or viewID is null.");
        continue;
        paramPTSViewHolder.bindNodeInfo(paramPTSNodeInfo);
      }
    }
    paramPTSViewHolder = localHashMap2.values().iterator();
    while (paramPTSViewHolder.hasNext()) {
      ((PTSNodeVirtual)paramPTSViewHolder.next()).hideNode();
    }
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    PTSTimeCostUtil.start("[saveUniqueIDToNodeInfoMap]");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addIDToNodeInfoMap((PTSNodeInfo)paramList.next());
    }
    PTSTimeCostUtil.end("[saveUniqueIDToNodeInfoMap]");
  }
  
  public void animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo) {}
  
  public int getItemCount()
  {
    if (this.mData != null) {
      return this.mData.size();
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
      for (;;)
      {
        paramInt = this.mData.size() + paramInt;
        PTSLog.e("PTSRecyclerViewAdapter", "[getItemViewType], e = " + localNumberFormatException + ", ptsCellType = " + paramInt);
      }
    }
    if (this.mViewTypeToNodeInfoMap.get(paramInt) == null) {
      this.mViewTypeToNodeInfoMap.put(paramInt, localPTSNodeInfo);
    }
    return paramInt;
  }
  
  public void insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    PTSNodeInfo localPTSNodeInfo = getNodeInfoByID(paramPTSNodeInfo.getParentID());
    if (localPTSNodeInfo != null) {
      localPTSNodeInfo.addChild(paramPTSNodeInfo);
    }
    for (;;)
    {
      addIDToNodeInfoMap(paramPTSNodeInfo);
      return;
      if (paramInt > this.mData.size())
      {
        PTSLog.e("PTSRecyclerViewAdapter", "[insert] insertIndex error, insertIndex = " + paramInt);
        this.mData.add(paramPTSNodeInfo);
      }
      else
      {
        this.mData.add(paramInt, paramPTSNodeInfo);
      }
    }
  }
  
  public void modify(PTSNodeInfo paramPTSNodeInfo)
  {
    PTSNodeInfo localPTSNodeInfo1 = getNodeInfoByID(paramPTSNodeInfo.getParentID());
    int i;
    if (localPTSNodeInfo1 != null)
    {
      List localList = localPTSNodeInfo1.getChildren();
      i = 0;
      if (i < localList.size())
      {
        PTSNodeInfo localPTSNodeInfo2 = (PTSNodeInfo)localList.get(i);
        if (!localPTSNodeInfo2.equals(paramPTSNodeInfo)) {
          break label83;
        }
        paramPTSNodeInfo.addChildren(localPTSNodeInfo2.getChildren());
        localPTSNodeInfo1.setChild(i, paramPTSNodeInfo);
        addIDToNodeInfoMap(paramPTSNodeInfo);
        PTSLog.d("PTSRecyclerViewAdapter", "[modify] update child.");
      }
    }
    for (;;)
    {
      return;
      label83:
      i += 1;
      break;
      i = 0;
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
  }
  
  public void onBindViewHolder(@NonNull PTSRecyclerViewAdapter.PTSViewHolder paramPTSViewHolder, int paramInt)
  {
    PTSTimeCostUtil.start("[onBindViewHolder], position = " + paramInt);
    PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)this.mData.get(paramInt);
    bindNodeInfo(paramPTSViewHolder, localPTSNodeInfo, this.mAppInstance);
    PTSLog.d("PTSRecyclerViewAdapter", "[onBindViewHolder] position = " + paramInt + ", nodeInfo = " + localPTSNodeInfo);
    PTSTimeCostUtil.end("[onBindViewHolder], position = " + paramInt);
  }
  
  @NonNull
  public PTSRecyclerViewAdapter.PTSViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    PTSTimeCostUtil.start("[onCreateViewHolder], viewType = " + paramInt);
    Object localObject = (PTSNodeInfo)this.mViewTypeToNodeInfoMap.get(paramInt);
    if (localObject == null) {
      throw new IllegalArgumentException("[onCreateViewHolder], no this viewType.");
    }
    paramViewGroup = new HashMap();
    localObject = PTSNodeFactory.buildVirtualNodeBFS((PTSNodeInfo)localObject, this.mAppInstance, paramViewGroup);
    if (localObject == null) {
      throw new IllegalArgumentException("[onCreateViewHolder], create null parent node.");
    }
    PTSTimeCostUtil.end("[onCreateViewHolder], viewType = " + paramInt);
    return new PTSRecyclerViewAdapter.PTSViewHolder((PTSNodeVirtual)localObject, paramViewGroup);
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
      if (localPTSNodeInfo2 == null) {
        break label37;
      }
      localPTSNodeInfo2.removeChild(localPTSNodeInfo1);
    }
    for (;;)
    {
      removeIDToNodeInfoMap(localPTSNodeInfo1);
      return;
      label37:
      this.mData.remove(localPTSNodeInfo1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */