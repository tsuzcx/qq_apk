package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeGalleryBiu$1
  implements View.OnClickListener
{
  FeedItemCellTypeGalleryBiu$1(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.g == null) {
      return;
    }
    paramView = ((IReadInJoyModel)this.a.b).k();
    if (paramView == null) {
      return;
    }
    int i = ComponentContentGalleryBiu.a(paramView, this.a.g);
    OnGalleryImageClickListener localOnGalleryImageClickListener = this.a.g.y().d();
    if (localOnGalleryImageClickListener != null) {
      localOnGalleryImageClickListener.a(this.a.e, paramView, 0, paramView.innerUniqueID, i, this.a.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryBiu.1
 * JD-Core Version:    0.7.0.1
 */