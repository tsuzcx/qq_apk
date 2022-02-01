package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabConfigHandler$_tabsList$2
  extends Lambda
  implements Function0<List<? extends TabChannelCoverInfo>>
{
  public static final 2 INSTANCE = new 2();
  
  RIJXTabConfigHandler$_tabsList$2()
  {
    super(0);
  }
  
  @NotNull
  public final List<TabChannelCoverInfo> invoke()
  {
    Object localObject2 = RIJXTabConfigHandler.access$get_config$p(RIJXTabConfigHandler.INSTANCE).getString("tabs_info", "{\n    \"tabs_info\":[\n        {\n            \"name\":\"关注\",\n            \"id\":70,\n            \"immersive\":0,\n            \"url\":\"http://viola.qq.com/channel/newFollow.js?_rij_violaUrl=1&v_tid=48&v_bid=4441&v_bundleName=newFollow\"\n        },\n        {\n            \"name\":\"好友\",\n            \"id\":41655,\n            \"immersive\":0,\n            \"url\":\"http://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&v_nav_immer=1&statusBarStyle=0&v_bid=3811&_cache_bunle=1&v_content_full=1&channel_id=41655&kandian_mode_new=4\"\n        },\n        {\n            \"name\":\"推荐\",\n            \"id\":0,\n            \"immersive\":0\n        },\n        {\n            \"name\":\"小区\",\n            \"id\":41729,\n            \"immersive\":1,\n            \"url\":\"https://viola.qq.com/js/home.js?_rij_violaUrl=1&v_bid=4636&v_tid=54&v_bundleName=home&hideNav=1&v_nav_immer=1\"\n        }\n    ]\n}");
    Object localObject1 = RIJXTabConfigHandler.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "tabsJson");
    localObject1 = RIJXTabConfigHandler.access$parseTabsInfoFromJson((RIJXTabConfigHandler)localObject1, (String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_tabsList: tabJson:");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", list:");
    localObject2 = ((Collection)localObject1).toArray(new TabChannelCoverInfo[0]);
    if (localObject2 != null)
    {
      localObject2 = Arrays.toString((Object[])localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.util.Arrays.toString(this)");
      localStringBuilder.append((String)localObject2);
      QLog.d("RIJXTabConfigHandler", 1, localStringBuilder.toString());
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler._tabsList.2
 * JD-Core Version:    0.7.0.1
 */