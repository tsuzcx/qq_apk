package com.tencent.mobileqq.troop.troopcard;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.troop.activity.troopactivity.ActSSORsp;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

class TroopMoreDetailView$GetTroopActivityObserver
  implements BusinessObserver
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public TroopMoreDetailView$GetTroopActivityObserver(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = (TroopMoreDetailView)this.a.get();
    if (localObject1 == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: !isSuccess || mTroopInfoData == null");
      }
      return;
    }
    try
    {
      Object localObject2 = paramBundle.getByteArray("data");
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: data == null");
        }
      }
      else
      {
        paramBundle = new troopactivity.ActSSORsp();
        paramBundle.mergeFrom((byte[])localObject2);
        if (paramBundle.err_code.get() != 10000)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mGetTroopActivityObserver: errorcode:");
          ((StringBuilder)localObject1).append(paramBundle.err_code.get());
          ((StringBuilder)localObject1).append(", msg:");
          ((StringBuilder)localObject1).append(paramBundle.err_msg.get());
          QLog.w("TroopMoreDetailView", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        paramBundle = paramBundle.body.get().toByteArray();
        localObject2 = new troopactivity.GroupInfoCardResp();
        ((troopactivity.GroupInfoCardResp)localObject2).mergeFrom(paramBundle);
        TroopMoreDetailView.a((TroopMoreDetailView)localObject1, (troopactivity.GroupInfoCardResp)localObject2);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mGetTroopActivityObserver: InvalidProtocolBufferMicroException:");
        ((StringBuilder)localObject1).append(paramBundle.getMessage());
        QLog.w("TroopMoreDetailView", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailView.GetTroopActivityObserver
 * JD-Core Version:    0.7.0.1
 */