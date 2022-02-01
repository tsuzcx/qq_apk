package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.widget.AbsListView.OnScrollListener;

class FastWebActivity$HippyScrollListener
  implements RecyclerView.OnListScrollListener
{
  private FastWebActivity$HippyScrollListener(FastWebActivity paramFastWebActivity) {}
  
  public void onDragEnd()
  {
    this.a.a.onScrollStateChanged(FastWebActivity.a(this.a), 0);
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    paramInt1 = FastWebActivity.a(this.a).getFirstVisiblePosition();
    paramInt2 = FastWebActivity.a(this.a).getLastVisiblePosition();
    this.a.a.onScroll(FastWebActivity.a(this.a), paramInt1, paramInt2 - paramInt1 + 1, FastWebActivity.a(this.a).getCount());
  }
  
  public void onScrollEnd()
  {
    this.a.a.onScrollStateChanged(FastWebActivity.a(this.a), 0);
  }
  
  public void onStartDrag()
  {
    this.a.a.onScrollStateChanged(FastWebActivity.a(this.a), 1);
  }
  
  public void onStartFling()
  {
    this.a.a.onScrollStateChanged(FastWebActivity.a(this.a), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.HippyScrollListener
 * JD-Core Version:    0.7.0.1
 */