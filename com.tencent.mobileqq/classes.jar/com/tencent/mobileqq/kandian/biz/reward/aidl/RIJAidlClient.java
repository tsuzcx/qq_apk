package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlClient;", "", "()V", "TAG", "", "<set-?>", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/mobileqq/kandian/biz/reward/aidl/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClient
{
  @Nullable
  private static IRIJAidlInterface jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlIRIJAidlInterface;
  private static final RIJAidlClient.RIJServiceConnection jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlRIJAidlClient$RIJServiceConnection = new RIJAidlClient.RIJServiceConnection();
  public static final RIJAidlClient a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlRIJAidlClient = new RIJAidlClient();
  }
  
  @Nullable
  public final IRIJAidlInterface a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlIRIJAidlInterface;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlRIJAidlClient$RIJServiceConnection, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
  
  public final void b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext.unbindService((ServiceConnection)jdField_a_of_type_ComTencentMobileqqKandianBizRewardAidlRIJAidlClient$RIJServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClient
 * JD-Core Version:    0.7.0.1
 */