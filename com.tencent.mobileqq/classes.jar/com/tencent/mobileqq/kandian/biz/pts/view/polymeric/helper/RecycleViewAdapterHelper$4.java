package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils.RIJFollowPackData;

class RecycleViewAdapterHelper$4
  implements ViewBase.OnClickListener
{
  RecycleViewAdapterHelper$4(RecycleViewAdapterHelper paramRecycleViewAdapterHelper, int paramInt1, int paramInt2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((RecycleViewAdapterHelper.e(this.c) instanceof RIJFollowPackUtils.RIJFollowPackData)) {
      RIJFollowPackUtils.a.a(this.a, this.b, (RIJFollowPackUtils.RIJFollowPackData)RecycleViewAdapterHelper.e(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.4
 * JD-Core Version:    0.7.0.1
 */