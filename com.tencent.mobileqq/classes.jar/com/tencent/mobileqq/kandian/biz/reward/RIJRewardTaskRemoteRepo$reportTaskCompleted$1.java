package com.tencent.mobileqq.kandian.biz.reward;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo$reportTaskCompleted$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskRemoteRepo$reportTaskCompleted$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJRewardTaskRemoteRepo$reportTaskCompleted$1(RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback) {}
  
  public boolean onError(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("report task completed onError() <-- errorCode: ");
    paramBundle.append(paramInt);
    paramBundle.append(", errorMsg: ");
    paramBundle.append(paramString);
    QLog.e("RIJRewardTaskRemoteRepo", 1, paramBundle.toString());
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.a(paramInt, paramString);
    }
    return true;
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("report task completed onResult() <-- errorCode: ");
    paramBundle.append(paramInt);
    QLog.i("RIJRewardTaskRemoteRepo", 1, paramBundle.toString());
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a();
      }
    }
    else
    {
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */