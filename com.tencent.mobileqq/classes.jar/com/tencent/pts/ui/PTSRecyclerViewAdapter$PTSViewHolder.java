package com.tencent.pts.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import java.util.HashMap;
import java.util.List;

public class PTSRecyclerViewAdapter$PTSViewHolder
  extends RecyclerView.ViewHolder
{
  private HashMap<String, List<PTSNodeVirtual>> viewIdToNodeListMap;
  
  PTSRecyclerViewAdapter$PTSViewHolder(View paramView)
  {
    super(paramView);
  }
  
  PTSRecyclerViewAdapter$PTSViewHolder(PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    super(paramPTSNodeVirtual.getView());
    this.viewIdToNodeListMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSRecyclerViewAdapter.PTSViewHolder
 * JD-Core Version:    0.7.0.1
 */