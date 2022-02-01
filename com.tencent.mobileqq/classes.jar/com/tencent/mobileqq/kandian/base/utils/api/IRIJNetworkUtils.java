package com.tencent.mobileqq.kandian.base.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJNetworkUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "debugReceivePb", "", "reply", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "debugSendPb", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "data", "", "cmd", "", "getWifiMacAddress", "context", "Landroid/content/Context;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJNetworkUtils
  extends QRouteApi
{
  public abstract void debugReceivePb(@Nullable FromServiceMsg paramFromServiceMsg);
  
  public abstract void debugSendPb(@Nullable ToServiceMsg paramToServiceMsg);
  
  public abstract void debugSendPb(@Nullable byte[] paramArrayOfByte, @Nullable String paramString);
  
  @Nullable
  public abstract String getWifiMacAddress(@Nullable Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils
 * JD-Core Version:    0.7.0.1
 */