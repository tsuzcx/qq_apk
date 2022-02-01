package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IReadInJoyFixPosArticleManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getFixPosArticleInfos", "", "Ljava/lang/Integer;", "channelID", "", "register", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "registerReommendADListener", "unRegister", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyFixPosArticleManager
  extends QRouteApi
{
  @Nullable
  public abstract List<Integer> getFixPosArticleInfos(int paramInt);
  
  public abstract void register(int paramInt, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract void registerReommendADListener(int paramInt);
  
  public abstract void unRegister(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager
 * JD-Core Version:    0.7.0.1
 */