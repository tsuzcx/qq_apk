package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;

class RvPolymericContainer$5
  implements PagerSnapHelper.PagerEventListener
{
  RvPolymericContainer$5(RvPolymericContainer paramRvPolymericContainer) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = RvPolymericContainer.f(this.a).a(RvPolymericContainer.d(this.a).i());
    paramViewHolder = RvPolymericContainer.f(this.a).getEventCallback();
    if (paramViewHolder != null) {
      paramViewHolder.onPagerChange(i);
    }
    this.a.a(i);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.5
 * JD-Core Version:    0.7.0.1
 */