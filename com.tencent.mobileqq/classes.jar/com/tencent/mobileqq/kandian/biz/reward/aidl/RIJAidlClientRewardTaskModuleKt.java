package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"runRPC", "R", "block", "Lkotlin/Function0;", "defaultValueWhenException", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)Ljava/lang/Object;", "", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class RIJAidlClientRewardTaskModuleKt
{
  private static final <R> R b(Function0<? extends R> paramFunction0, R paramR)
  {
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    catch (RemoteException paramFunction0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramFunction0));
      }
    }
    return paramR;
  }
  
  private static final void b(Function0<Unit> paramFunction0)
  {
    try
    {
      paramFunction0.invoke();
      return;
    }
    catch (RemoteException paramFunction0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramFunction0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRewardTaskModuleKt
 * JD-Core Version:    0.7.0.1
 */