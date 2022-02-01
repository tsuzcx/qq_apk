package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyUserInfoModuleImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule;", "()V", "getBatchKDUserInfo", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "uinList", "", "getDefaultNickName", "getResultFaceUrl", "readInJoyUserInfo", "getSingleKDUserInfo", "uin", "", "callBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "useRealTimeRead", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyUserInfoModuleImpl
  implements IReadInJoyUserInfoModule
{
  @Nullable
  public List<ReadInJoyUserInfo> getBatchKDUserInfo(@Nullable List<String> paramList)
  {
    return ReadInJoyUserInfoModule.a(paramList);
  }
  
  @Nullable
  public String getDefaultNickName()
  {
    return ReadInJoyUserInfoModule.a();
  }
  
  @Nullable
  public String getResultFaceUrl(@Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    return ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
  }
  
  @Nullable
  public ReadInJoyUserInfo getSingleKDUserInfo(long paramLong, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return ReadInJoyUserInfoModule.a(paramLong, paramRefreshUserInfoCallBack);
  }
  
  @Nullable
  public ReadInJoyUserInfo getSingleKDUserInfo(long paramLong, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    return ReadInJoyUserInfoModule.a(paramLong, paramRefreshUserInfoCallBack, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyUserInfoModuleImpl
 * JD-Core Version:    0.7.0.1
 */