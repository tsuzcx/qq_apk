package com.tencent.viola.ui.view.list;

import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.utils.ViolaLogUtils;

class VRecyclerView$1
  extends RefreshMoveOberver
{
  VRecyclerView$1(VRecyclerView paramVRecyclerView) {}
  
  public void onRefreshMove(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRefreshMove offset:");
    localStringBuilder.append(paramInt);
    ViolaLogUtils.d("VRecyclerView", localStringBuilder.toString());
    if (VRecyclerView.access$100(this.this$0) != null) {
      VRecyclerView.access$100(this.this$0).onVerticalScroll(this.this$0, paramInt);
    }
    VRecyclerView.access$202(this.this$0, paramInt);
    this.this$0.performOnScroll(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */