package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay$fetchAvatar$1", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AvatarBadgeDisplay$fetchAvatar$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  AvatarBadgeDisplay$fetchAvatar$1(Function2 paramFunction2) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AvatarBadgeDisplay.fetchAvatar.1.onLoadUserInfoFailed.1(this, paramString1, paramString2));
  }
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AvatarBadgeDisplay.fetchAvatar.1.onLoadUserInfoSucceed.1(this, paramString, paramReadInJoyUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay.fetchAvatar.1
 * JD-Core Version:    0.7.0.1
 */