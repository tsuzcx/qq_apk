package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class RecycleViewAdapterHelper$5
  extends EventCallback
{
  RecycleViewAdapterHelper$5(RecycleViewAdapterHelper paramRecycleViewAdapterHelper) {}
  
  public void onPagerChange(int paramInt)
  {
    RecycleViewAdapterHelper.b(paramInt);
    if ((RecycleViewAdapterHelper.d() != null) && (!RecycleViewAdapterHelper.d().contains(Integer.valueOf(paramInt)))) {
      RecycleViewAdapterHelper.d().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.5
 * JD-Core Version:    0.7.0.1
 */