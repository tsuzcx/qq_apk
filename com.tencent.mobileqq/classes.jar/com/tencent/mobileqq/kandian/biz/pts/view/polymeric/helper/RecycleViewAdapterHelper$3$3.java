package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.List;

class RecycleViewAdapterHelper$3$3
  implements ViewBase.OnClickListener
{
  RecycleViewAdapterHelper$3$3(RecycleViewAdapterHelper.3 param3) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.c.e != null) && (this.a.c.e.k() != null)) {
      ProteusSupportUtil.a(this.a.c.e.k(), this.a.b, paramViewBase);
    }
    ProteusSupportUtil.a(this.a.b, paramViewBase);
    if ((RecycleViewAdapterHelper.c(this.a.c) != null) && (this.a.a < RecycleViewAdapterHelper.c(this.a.c).size()))
    {
      RIJJumpUtils.a(RecycleViewAdapterHelper.d(this.a.c).getContext(), (AbsBaseArticleInfo)RecycleViewAdapterHelper.c(this.a.c).get(this.a.a), paramViewBase.getEventAttachedData());
      return;
    }
    ReadInJoyUtils.a(RecycleViewAdapterHelper.d(this.a.c).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.3.3
 * JD-Core Version:    0.7.0.1
 */