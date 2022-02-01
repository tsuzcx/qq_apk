package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import java.util.Map;

class FeedItemCell$1
  implements FeedItemCell.CellListener
{
  FeedItemCell$1(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, Map<String, Object> paramMap)
  {
    if (paramView.getId() == 2131449096)
    {
      this.a.b(paramView);
      return;
    }
    if (paramView == this.a.t)
    {
      paramView = this.a.g.y().a();
      if (paramView != null) {
        paramView.m();
      }
    }
    else
    {
      this.a.a(paramView, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.1
 * JD-Core Version:    0.7.0.1
 */