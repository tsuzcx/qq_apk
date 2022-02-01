package com.tencent.mobileqq.kandian.biz.push;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/push/RIJPushNotifyModule$requestUpdatePushStatus$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyModule$requestUpdatePushStatus$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJPushNotifyModule$requestUpdatePushStatus$1(Function1 paramFunction1) {}
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("requestUpdatePushStatus response errorCode: ");
    paramArrayOfByte.append(paramInt);
    QLog.i("RIJPushNotifyModule", 1, paramArrayOfByte.toString());
    this.a.invoke(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyModule.requestUpdatePushStatus.1
 * JD-Core Version:    0.7.0.1
 */