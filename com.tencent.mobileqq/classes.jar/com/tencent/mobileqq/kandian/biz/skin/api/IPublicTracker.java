package com.tencent.mobileqq.kandian.biz.skin.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/IPublicTracker;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "trackAIO", "", "last", "", "next", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublicTracker
  extends QRouteApi
{
  public static final IPublicTracker.Companion Companion = IPublicTracker.Companion.a;
  @NotNull
  public static final String KANDIAN_NEW_FEEDS_LISTVIEW_MEASURE_LAYOUT_DRAW = "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW";
  @NotNull
  public static final String KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE = "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE";
  
  public abstract void trackAIO(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.IPublicTracker
 * JD-Core Version:    0.7.0.1
 */