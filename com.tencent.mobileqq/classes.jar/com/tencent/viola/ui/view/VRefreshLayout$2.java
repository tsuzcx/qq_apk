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
    Object localObject = VRefreshLayout.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRefreshMove offset:");
    localStringBuilder.append(paramInt);
    ViolaLogUtils.d((String)localObject, localStringBuilder.toString());
    if (VRefreshLayout.access$000(this.this$0) != null) {
      VRefreshLayout.access$000(this.this$0).onRefreshMove(paramInt);
    }
    if (VRefreshLayout.access$100(this.this$0) != null)
    {
      localObject = VRefreshLayout.access$100(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VRefreshLayout.OnHeaderStateChangeListener)((Iterator)localObject).next()).onRefreshMove(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */