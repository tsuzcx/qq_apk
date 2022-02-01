package com.tencent.viola.ui.adapter;

import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.onSpecialRemoveAnimationListener;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.List;

class VRecyclerViewAdapter$2
  implements DefaultRecycleItemAnimator.onSpecialRemoveAnimationListener
{
  VRecyclerViewAdapter$2(VRecyclerViewAdapter paramVRecyclerViewAdapter, int paramInt) {}
  
  public void onAnimFinash()
  {
    if (this.val$index != -1) {
      VRecyclerViewAdapter.access$100(this.this$0).remove(this.val$index);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doNotifyItemDeleteWithAnim  startSpecialRemoveAnimation finish,index:");
    localStringBuilder.append(this.val$index);
    ViolaLogUtils.d("VRecyclerViewAdapter", localStringBuilder.toString());
    this.this$0.notifyItemRemoved(this.val$index);
    VRecyclerViewAdapter.access$000(this.this$0).onAnimFinish();
  }
  
  public void onAnimStart()
  {
    VRecyclerViewAdapter.access$000(this.this$0).onAnimFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VRecyclerViewAdapter.2
 * JD-Core Version:    0.7.0.1
 */