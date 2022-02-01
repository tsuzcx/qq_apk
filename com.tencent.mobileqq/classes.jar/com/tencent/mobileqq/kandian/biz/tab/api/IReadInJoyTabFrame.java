package com.tencent.mobileqq.kandian.biz.tab.api;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/api/IReadInJoyTabFrame;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getReadInJoyTabFrameName", "", "isReadInJoyTabFrame", "", "frame", "Lcom/tencent/mobileqq/app/Frame;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyTabFrame
  extends QRouteApi
{
  @NotNull
  public abstract String getReadInJoyTabFrameName();
  
  public abstract boolean isReadInJoyTabFrame(@NotNull Frame paramFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.api.IReadInJoyTabFrame
 * JD-Core Version:    0.7.0.1
 */