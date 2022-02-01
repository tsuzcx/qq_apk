package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinPresentReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo;", "", "()V", "reportTaskCompleted", "", "rowKey", "", "type", "", "reportTaskProgressCallback", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo$IReportTaskProgressCallback;", "Companion", "IReportTaskProgressCallback", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskRemoteRepo
{
  public static final RIJRewardTaskRemoteRepo.Companion a;
  private static volatile RIJRewardTaskRemoteRepo a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskRemoteRepo$Companion = new RIJRewardTaskRemoteRepo.Companion(null);
  }
  
  @JvmStatic
  @NotNull
  public static final RIJRewardTaskRemoteRepo b()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskRemoteRepo$Companion.a();
  }
  
  public final void a(@NotNull String paramString, int paramInt, @Nullable RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    long l1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    paramString = RIJQQAppInterfaceUtil.a();
    Object localObject = new oidb_cmd0xed4.MetaData();
    ((oidb_cmd0xed4.MetaData)localObject).type.set(2);
    ((oidb_cmd0xed4.MetaData)localObject).timestamp.set(l2);
    oidb_cmd0xed4.CoinPresentReq localCoinPresentReq = new oidb_cmd0xed4.CoinPresentReq();
    localCoinPresentReq.uin.set(l1);
    oidb_cmd0xed4.ReqBody localReqBody = new oidb_cmd0xed4.ReqBody();
    localReqBody.meta.set((MessageMicro)localObject);
    localReqBody.present_req.set((MessageMicro)localCoinPresentReq);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report task completed --> uin: ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(", timestamp: ");
    ((StringBuilder)localObject).append(l2);
    QLog.i("RIJRewardTaskRemoteRepo", 1, ((StringBuilder)localObject).toString());
    ProtoUtils.a((AppRuntime)paramString, (ProtoUtils.TroopProtocolObserver)new RIJRewardTaskRemoteRepo.reportTaskCompleted.1(paramIReportTaskProgressCallback), localReqBody.toByteArray(), "OidbSvc.0xed4", 3796, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo
 * JD-Core Version:    0.7.0.1
 */