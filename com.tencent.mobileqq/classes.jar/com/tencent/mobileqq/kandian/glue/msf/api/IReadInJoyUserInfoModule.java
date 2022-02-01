package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBatchKDUserInfo", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "uinList", "", "getDefaultNickName", "getResultFaceUrl", "readInJoyUserInfo", "getSingleKDUserInfo", "uin", "", "callBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "useRealTimeRead", "", "RefreshUserInfoCallBack", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyUserInfoModule
  extends QRouteApi
{
  @Nullable
  public abstract List<ReadInJoyUserInfo> getBatchKDUserInfo(@Nullable List<String> paramList);
  
  @Nullable
  public abstract String getDefaultNickName();
  
  @Nullable
  public abstract String getResultFaceUrl(@Nullable ReadInJoyUserInfo paramReadInJoyUserInfo);
  
  @Nullable
  public abstract ReadInJoyUserInfo getSingleKDUserInfo(long paramLong, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  @Nullable
  public abstract ReadInJoyUserInfo getSingleKDUserInfo(long paramLong, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */