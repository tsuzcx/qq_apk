package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/glue/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler$getUserInfo$1$1", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountNewBridgeInvokeHandler$getUserInfo$$inlined$also$lambda$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  PublicAccountNewBridgeInvokeHandler$getUserInfo$$inlined$also$lambda$1(String paramString1, PublicAccountNewBridgeInvokeHandler paramPublicAccountNewBridgeInvokeHandler, String paramString2) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgePublicAccountNewBridgeInvokeHandler.a(this.jdField_a_of_type_JavaLangString, ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramString2));
  }
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgePublicAccountNewBridgeInvokeHandler.a(this.jdField_a_of_type_JavaLangString, ReadInJoyLegacyUtils.a(paramReadInJoyUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler.getUserInfo..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */