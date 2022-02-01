package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/aidl/RIJAidlClient$RIJServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class RIJAidlClient$RIJServiceConnection
  implements ServiceConnection
{
  public void onServiceConnected(@NotNull ComponentName paramComponentName, @NotNull IBinder paramIBinder)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
    Intrinsics.checkParameterIsNotNull(paramIBinder, "service");
    RIJAidlClient.a(RIJAidlClient.a, IRIJAidlInterface.Stub.a(paramIBinder));
    paramIBinder = new StringBuilder();
    paramIBinder.append("onServiceConnected: ");
    paramIBinder.append(paramComponentName);
    QLog.d("RIJAidlClient", 1, paramIBinder.toString());
  }
  
  public void onServiceDisconnected(@NotNull ComponentName paramComponentName)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
    RIJAidlClient.a(RIJAidlClient.a, (IRIJAidlInterface)null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceDisconnected: ");
    localStringBuilder.append(paramComponentName);
    QLog.d("RIJAidlClient", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClient.RIJServiceConnection
 * JD-Core Version:    0.7.0.1
 */