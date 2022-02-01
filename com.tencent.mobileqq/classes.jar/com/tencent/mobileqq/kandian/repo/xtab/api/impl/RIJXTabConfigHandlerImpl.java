package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandlerImpl;", "Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "()V", "getDefaultEnterTabId", "", "getDefaultEnterTabInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "getRedDotExpireTimeInMin", "getTabList", "", "isXTabMode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandlerImpl
  implements IRIJXTabConfigHandler
{
  public int getDefaultEnterTabId()
  {
    return this.$$delegate_0.getDefaultEnterTabId();
  }
  
  @Nullable
  public TabChannelCoverInfo getDefaultEnterTabInfo()
  {
    return this.$$delegate_0.getDefaultEnterTabInfo();
  }
  
  public int getRedDotExpireTimeInMin()
  {
    return this.$$delegate_0.getRedDotExpireTimeInMin();
  }
  
  @NotNull
  public List<TabChannelCoverInfo> getTabList()
  {
    return this.$$delegate_0.getTabList();
  }
  
  public boolean isXTabMode()
  {
    return this.$$delegate_0.isXTabMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandlerImpl
 * JD-Core Version:    0.7.0.1
 */