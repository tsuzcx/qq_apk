package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyUserInfoModule$RefreshUserInfoCallBack
{
  public abstract void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack
 * JD-Core Version:    0.7.0.1
 */