package com.tencent.mobileqq.kandian.repo.xtab.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDefaultEnterTabId", "", "getDefaultEnterTabInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "getRedDotExpireTimeInMin", "getTabList", "", "isXTabMode", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJXTabConfigHandler
  extends QRouteApi
{
  public abstract int getDefaultEnterTabId();
  
  @Nullable
  public abstract TabChannelCoverInfo getDefaultEnterTabInfo();
  
  public abstract int getRedDotExpireTimeInMin();
  
  @NotNull
  public abstract List<TabChannelCoverInfo> getTabList();
  
  public abstract boolean isXTabMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler
 * JD-Core Version:    0.7.0.1
 */