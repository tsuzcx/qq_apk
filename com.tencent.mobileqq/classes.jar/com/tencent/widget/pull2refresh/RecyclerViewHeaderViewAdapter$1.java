package com.tencent.widget.pull2refresh;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class RecyclerViewHeaderViewAdapter$1
  extends RecyclerView.AdapterDataObserver
{
  RecyclerViewHeaderViewAdapter$1(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter) {}
  
  public void onChanged()
  {
    this.this$0.notifyDataSetChanged();
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.this$0;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeChanged(paramInt1 + RecyclerViewHeaderViewAdapter.access$200(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.this$0;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeChanged(paramInt1 + RecyclerViewHeaderViewAdapter.access$200(localRecyclerViewHeaderViewAdapter).size(), paramInt2, paramObject);
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.this$0;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeInserted(paramInt1 + RecyclerViewHeaderViewAdapter.access$200(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.this$0;
    localRecyclerViewHeaderViewAdapter.notifyItemMoved(paramInt1 + RecyclerViewHeaderViewAdapter.access$200(localRecyclerViewHeaderViewAdapter).size(), paramInt2 + RecyclerViewHeaderViewAdapter.access$200(this.this$0).size());
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.this$0;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeRemoved(paramInt1 + RecyclerViewHeaderViewAdapter.access$200(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.access$000(this.this$0) != null) {
      RecyclerViewHeaderViewAdapter.access$000(this.this$0).contentDataChange(RecyclerViewHeaderViewAdapter.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */