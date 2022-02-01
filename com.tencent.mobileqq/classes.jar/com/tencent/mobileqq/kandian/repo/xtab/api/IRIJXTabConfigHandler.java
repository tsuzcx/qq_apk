package com.tencent.mobileqq.kandian.repo.xtab.api;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "asAladdinConfigHandler", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "asClazz", "Lkotlin/reflect/KClass;", "getDefaultEnterTabId", "", "getRedDotExpireTimeInMin", "getTabList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "isXTabMode", "", "setTabList", "", "list", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJXTabConfigHandler
  extends QRouteApi
{
  @NotNull
  public abstract SimpleConfigHandler asAladdinConfigHandler();
  
  @NotNull
  public abstract KClass<?> asClazz();
  
  public abstract int getDefaultEnterTabId();
  
  public abstract int getRedDotExpireTimeInMin();
  
  @NotNull
  public abstract List<TabChannelCoverInfo> getTabList();
  
  public abstract boolean isXTabMode();
  
  public abstract void setTabList(@NotNull List<? extends TabChannelCoverInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler
 * JD-Core Version:    0.7.0.1
 */