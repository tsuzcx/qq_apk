package com.tencent.mobileqq.kandian.biz.viola.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView$ViolaViewListener;", "", "onError", "", "err", "", "onProcess", "code", "onScroll", "contentOffsetY", "firstVisibleItem", "visibleItemCount", "totalItemCount", "scrollPositionState", "isVertical", "", "onScrollStateChanged", "s", "", "i", "onSucc", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaBaseView$ViolaViewListener
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract void a(@Nullable String paramString, int paramInt);
  
  public abstract void b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener
 * JD-Core Version:    0.7.0.1
 */