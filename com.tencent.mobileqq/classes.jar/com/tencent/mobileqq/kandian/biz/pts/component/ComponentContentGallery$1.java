package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentContentGallery$1
  implements View.OnClickListener
{
  ComponentContentGallery$1(ComponentContentGallery paramComponentContentGallery, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGallery.a(this.e) == null) {
      return;
    }
    paramView = ComponentContentGallery.a(this.e).y().d();
    if (paramView != null) {
      paramView.a(this.e.getContext(), this.a, this.b, this.c, 1, ComponentContentGallery.b(this.e), this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGallery.1
 * JD-Core Version:    0.7.0.1
 */