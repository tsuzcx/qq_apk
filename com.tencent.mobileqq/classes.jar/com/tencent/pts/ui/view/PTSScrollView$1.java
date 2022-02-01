package com.tencent.pts.ui.view;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import java.util.Iterator;
import java.util.List;

class PTSScrollView$1
  implements Runnable
{
  PTSScrollView$1(PTSScrollView paramPTSScrollView) {}
  
  public void run()
  {
    PTSTimeCostUtil.start("PTSScrollView-triggerItemViewExposureImp");
    if (PTSScrollView.access$000(this.this$0) == null)
    {
      PTSLog.e("PTSScrollView", "[triggerItemViewExposureImp] container is null.");
      return;
    }
    Object localObject = this.this$0;
    ((PTSScrollView)localObject).getHitRect(PTSScrollView.access$100((PTSScrollView)localObject));
    int j = PTSScrollView.access$000(this.this$0).getChildCount();
    PTSScrollView.access$200(this.this$0).clear();
    int i = 0;
    while (i < j)
    {
      if (PTSScrollView.access$000(this.this$0).getChildAt(i).getLocalVisibleRect(PTSScrollView.access$100(this.this$0))) {
        PTSScrollView.access$200(this.this$0).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject = PTSScrollView.access$200(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      if (!PTSScrollView.access$300(this.this$0).contains(Integer.valueOf(i))) {
        PTSScrollView.access$400(this.this$0).triggerItemViewExposure(i);
      }
    }
    PTSScrollView.access$300(this.this$0).clear();
    PTSScrollView.access$300(this.this$0).addAll(PTSScrollView.access$200(this.this$0));
    PTSTimeCostUtil.end("PTSScrollView-triggerItemViewExposureImp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSScrollView.1
 * JD-Core Version:    0.7.0.1
 */