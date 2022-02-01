package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandlerImpl;", "Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "()V", "asAladdinConfigHandler", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "asClazz", "Lkotlin/reflect/KClass;", "getDefaultEnterTabId", "", "getRedDotExpireTimeInMin", "getTabList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "isXTabMode", "", "setTabList", "", "list", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandlerImpl
  implements IRIJXTabConfigHandler
{
  @NotNull
  public SimpleConfigHandler asAladdinConfigHandler()
  {
    return RIJXTabConfigHandler.Companion.a().asAladdinConfigHandler();
  }
  
  @NotNull
  public KClass<?> asClazz()
  {
    return RIJXTabConfigHandler.Companion.a().asClazz();
  }
  
  public int getDefaultEnterTabId()
  {
    return RIJXTabConfigHandler.Companion.a().getDefaultEnterTabId();
  }
  
  public int getRedDotExpireTimeInMin()
  {
    return RIJXTabConfigHandler.Companion.a().getRedDotExpireTimeInMin();
  }
  
  @NotNull
  public List<TabChannelCoverInfo> getTabList()
  {
    return RIJXTabConfigHandler.Companion.a().getTabList();
  }
  
  public boolean isXTabMode()
  {
    return RIJXTabConfigHandler.Companion.a().isXTabMode();
  }
  
  public void setTabList(@NotNull List<? extends TabChannelCoverInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    RIJXTabConfigHandler.Companion.a().setTabList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandlerImpl
 * JD-Core Version:    0.7.0.1
 */