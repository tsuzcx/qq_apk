package com.tencent.viola.ui.view;

import com.tencent.viola.ui.view.refresh.RefreshMoveOberver;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;

class VRefreshLayout$2
  extends RefreshMoveOberver
{
  VRefreshLayout$2(VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    ViolaLogUtils.d(VRefreshLayout.TAG, "onRefreshMove offset:" + paramInt);
    if (VRefreshLayout.access$000(this.this$0) != null) {
      VRefreshLayout.access$000(this.this$0).onRefreshMove(paramInt);
    }
    if (VRefreshLayout.access$100(this.this$0) != null)
    {
      Iterator localIterator = VRefreshLayout.access$100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((VRefreshLayout.OnHeaderStateChangeListener)localIterator.next()).onRefreshMove(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */