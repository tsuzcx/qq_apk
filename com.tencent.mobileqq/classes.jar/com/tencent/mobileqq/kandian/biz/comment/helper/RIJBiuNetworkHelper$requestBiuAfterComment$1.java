package com.tencent.mobileqq.kandian.biz.comment.helper;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJBiuNetworkHelper$requestBiuAfterComment$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBiuNetworkHelper$requestBiuAfterComment$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJBiuNetworkHelper$requestBiuAfterComment$1(Function2 paramFunction2) {}
  
  public boolean onError(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    this.a.invoke(Boolean.valueOf(false), Integer.valueOf(paramInt));
    return true;
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.a.invoke(Boolean.valueOf(true), Integer.valueOf(paramInt));
      return;
    }
    this.a.invoke(Boolean.valueOf(false), Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJBiuNetworkHelper.requestBiuAfterComment.1
 * JD-Core Version:    0.7.0.1
 */