package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelperFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "create", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelper;", "root", "Landroid/view/View;", "listener", "Landroid/view/View$OnClickListener;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IMsgLayoutHelperFactory
  extends QRouteApi
{
  @NotNull
  public abstract IMsgLayoutHelper create(@NotNull View paramView, @Nullable View.OnClickListener paramOnClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelperFactory
 * JD-Core Version:    0.7.0.1
 */