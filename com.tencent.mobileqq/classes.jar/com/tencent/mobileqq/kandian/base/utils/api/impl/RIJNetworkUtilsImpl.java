package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.utils.NetDebugUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJNetworkUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJNetworkUtils;", "()V", "debugReceivePb", "", "reply", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "debugSendPb", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "data", "", "cmd", "", "getWifiMacAddress", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJNetworkUtilsImpl
  implements IRIJNetworkUtils
{
  public void debugReceivePb(@Nullable FromServiceMsg paramFromServiceMsg)
  {
    NetDebugUtils.a(paramFromServiceMsg);
  }
  
  public void debugSendPb(@Nullable ToServiceMsg paramToServiceMsg)
  {
    NetDebugUtils.a(paramToServiceMsg);
  }
  
  public void debugSendPb(@Nullable byte[] paramArrayOfByte, @Nullable String paramString)
  {
    NetDebugUtils.a(paramArrayOfByte, paramString);
  }
  
  @Nullable
  public String getWifiMacAddress(@Nullable Context paramContext)
  {
    return RIJNetworkUtils.c(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.RIJNetworkUtilsImpl
 * JD-Core Version:    0.7.0.1
 */