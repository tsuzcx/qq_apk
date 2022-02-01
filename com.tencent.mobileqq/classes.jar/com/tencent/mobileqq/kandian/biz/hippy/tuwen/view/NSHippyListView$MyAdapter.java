package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.ContainerPosition;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.IContainerPositionGetter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

final class NSHippyListView$MyAdapter
  extends HippyTKDListViewAdapter
  implements HippyTKDListViewAdapter.IContainerPositionGetter
{
  private final HippyTKDListViewAdapter.ContainerPosition containerPosition = new HippyTKDListViewAdapter.ContainerPosition();
  
  public NSHippyListView$MyAdapter(NSHippyListView paramNSHippyListView, RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    super(paramRecyclerView, paramHippyEngineContext);
    setContainerPositionGetter(this);
  }
  
  private int getOffset()
  {
    this.this$0.ensureHippyRootLayout();
    Object localObject = this.this$0.hippyRootLayout;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      int k = this.this$0.hippyRootLayout.getBottom();
      localObject = this.this$0.hippyRootLayout.getParent();
      i = j;
      if ((localObject instanceof View))
      {
        i = k - ((View)localObject).getHeight();
        if (i < 0) {
          return 0;
        }
      }
    }
    return i;
  }
  
  public HippyTKDListViewAdapter.ContainerPosition getContainerPosition()
  {
    this.this$0.ensureHippyRootLayout();
    this.containerPosition.offset = getOffset();
    return this.containerPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView.MyAdapter
 * JD-Core Version:    0.7.0.1
 */