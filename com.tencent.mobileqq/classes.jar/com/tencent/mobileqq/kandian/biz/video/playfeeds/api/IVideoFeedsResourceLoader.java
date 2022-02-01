package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsResourceLoader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "inflate", "Landroid/view/View;", "resid", "", "faultTolerant", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsResourceLoader
  extends QRouteApi
{
  @Nullable
  public abstract View inflate(int paramInt, boolean paramBoolean, @Nullable ViewGroup.LayoutParams paramLayoutParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsResourceLoader
 * JD-Core Version:    0.7.0.1
 */