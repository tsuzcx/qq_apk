package com.tencent.pts.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSRecyclerViewAdapter;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.ArrayList;
import java.util.List;

public class PTSRootNodeRecyclerViewDelegate
  implements IPTSRootNodeDelegate
{
  private final String TAG = "PTSRootNodeRecyclerViewDelegate";
  private PTSRecyclerViewAdapter mAdapter;
  private PTSAppInstance mAppInstance;
  private List<PTSNodeInfo> mDataList;
  private RecyclerView mRecyclerView;
  
  PTSRootNodeRecyclerViewDelegate(PTSAppInstance paramPTSAppInstance)
  {
    this.mAppInstance = paramPTSAppInstance;
    this.mDataList = new ArrayList();
  }
  
  public void addOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.mRecyclerView.addOnScrollListener(paramOnScrollListener);
  }
  
  public boolean animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[animation] nodeInfo = " + paramPTSNodeInfo);
    this.mAdapter.animation(paramPTSNodeInfo, paramAnimationInfo);
    return true;
  }
  
  public boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[insert] insertIndex = " + paramInt + ", nodeInfo = " + paramPTSNodeInfo);
    this.mAdapter.insert(paramPTSNodeInfo, paramInt);
    return true;
  }
  
  public boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[modify] nodeInfo = " + paramPTSNodeInfo);
    this.mAdapter.modify(paramPTSNodeInfo);
    return true;
  }
  
  public View onCreateNativeView()
  {
    this.mRecyclerView = new RecyclerView(this.mAppInstance.getContext());
    this.mRecyclerView.setHasFixedSize(true);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mAppInstance.getContext());
    this.mRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.mAdapter = new PTSRecyclerViewAdapter(this.mAppInstance);
    this.mRecyclerView.setAdapter(this.mAdapter);
    return this.mRecyclerView;
  }
  
  public void onLayoutTempPatchFinished()
  {
    this.mAdapter.onLayoutTempPatchFinished();
  }
  
  public boolean refreshNodeList(List<PTSNodeInfo> paramList)
  {
    this.mDataList.clear();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
    this.mAdapter.setData(this.mDataList);
    if (PTSLog.isDebug())
    {
      PTSLog.d("PTSRootNodeRecyclerViewDelegate", "refreshNodeList, list count = " + this.mDataList.size());
      paramList = new StringBuilder();
      int i = 0;
      while (i < this.mDataList.size())
      {
        paramList.append("mDataList [").append(i).append("] = ").append(this.mDataList.get(i)).append("\n");
        i += 1;
      }
      PTSLog.d("PTSRootNodeRecyclerViewDelegate", paramList.toString());
    }
    return true;
  }
  
  public boolean remove(int paramInt)
  {
    PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[remove] nodeUniqueID = " + paramInt);
    this.mAdapter.remove(paramInt);
    return true;
  }
  
  public void setRootView(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.PTSRootNodeRecyclerViewDelegate
 * JD-Core Version:    0.7.0.1
 */