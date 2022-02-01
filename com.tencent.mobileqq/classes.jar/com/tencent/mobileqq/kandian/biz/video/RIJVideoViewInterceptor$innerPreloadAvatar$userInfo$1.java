package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadUserInfoFailed uin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString2);
    QLog.e("RIJVideoViewInterceptor", 2, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    RIJVideoViewInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoRIJVideoViewInterceptor, paramReadInJoyUserInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor.innerPreloadAvatar.userInfo.1
 * JD-Core Version:    0.7.0.1
 */