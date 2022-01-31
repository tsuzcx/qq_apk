package com.tencent.pts.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import java.util.HashMap;

public class PTSRecyclerViewAdapter$PTSViewHolder
  extends RecyclerView.ViewHolder
{
  private HashMap<String, PTSNodeVirtual> viewIDToNodeMap;
  
  PTSRecyclerViewAdapter$PTSViewHolder(PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, PTSNodeVirtual> paramHashMap)
  {
    super(paramPTSNodeVirtual.getView());
    this.viewIDToNodeMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSRecyclerViewAdapter.PTSViewHolder
 * JD-Core Version:    0.7.0.1
 */