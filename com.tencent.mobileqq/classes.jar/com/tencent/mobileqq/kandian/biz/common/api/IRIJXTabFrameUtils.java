package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJXTabFrameUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getPreFrameClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "getTabFrame", "isKandianTabFrame", "", "frame", "className", "", "isNowInKanDianTab", "onTabClickSelf", "", "updateFrameStatus", "isShowKandianTab", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJXTabFrameUtils
  extends QRouteApi
{
  @NotNull
  public abstract Class<? extends Frame> getPreFrameClass(@NotNull KandianFrameStatus paramKandianFrameStatus);
  
  @NotNull
  public abstract Class<? extends Frame> getTabFrame();
  
  public abstract boolean isKandianTabFrame(@Nullable Frame paramFrame);
  
  public abstract boolean isKandianTabFrame(@Nullable String paramString);
  
  public abstract boolean isNowInKanDianTab();
  
  public abstract void onTabClickSelf(@Nullable Frame paramFrame);
  
  public abstract void updateFrameStatus(@NotNull KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils
 * JD-Core Version:    0.7.0.1
 */