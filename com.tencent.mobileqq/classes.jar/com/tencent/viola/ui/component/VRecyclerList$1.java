package com.tencent.viola.ui.component;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaLogUtils;

class VRecyclerList$1
  implements View.OnLayoutChangeListener
{
  VRecyclerList$1(VRecyclerList paramVRecyclerList, VRecyclerView paramVRecyclerView, float paramFloat) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.val$recyclerView.removeOnLayoutChangeListener(this);
    this.this$0.scrollByDistance((int)this.val$initContentOffset);
    paramView = new StringBuilder();
    paramView.append("initContentOffsetIfNeed :");
    paramView.append(this.val$initContentOffset);
    ViolaLogUtils.d("VRecyclerList", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.1
 * JD-Core Version:    0.7.0.1
 */