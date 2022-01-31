package com.tencent.viola.ui.view.list;

import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.utils.ViolaLogUtils;

class VRecyclerView$1
  extends RefreshMoveOberver
{
  VRecyclerView$1(VRecyclerView paramVRecyclerView) {}
  
  public void onRefreshMove(int paramInt)
  {
    ViolaLogUtils.d("VRecyclerView", "onRefreshMove offset:" + paramInt);
    VRecyclerView.access$102(this.this$0, paramInt);
    this.this$0.performOnScroll(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */