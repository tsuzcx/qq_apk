package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentContentGalleryBiu$2
  implements View.OnClickListener
{
  ComponentContentGalleryBiu$2(ComponentContentGalleryBiu paramComponentContentGalleryBiu, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGalleryBiu.a(this.e) == null) {
      return;
    }
    int i = ComponentContentGalleryBiu.a(this.a, ComponentContentGalleryBiu.a(this.e));
    paramView = ComponentContentGalleryBiu.a(this.e).y().d();
    if (paramView != null) {
      paramView.a(this.e.getContext(), this.a, (int)this.b, this.c, i, ComponentContentGalleryBiu.b(this.e), this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGalleryBiu.2
 * JD-Core Version:    0.7.0.1
 */