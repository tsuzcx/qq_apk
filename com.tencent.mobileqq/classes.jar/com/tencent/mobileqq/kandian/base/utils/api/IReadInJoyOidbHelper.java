package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyOidbHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createToServiceMsg", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "cmd", "", "makeOIDBPkg", "command", "", "serviceType", "bodyByte", "", "parseOIDBPkg", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "Ljava/lang/Object;", "msg", "Lcom/tencent/mobileqq/pb/MessageMicro;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyOidbHelper
  extends QRouteApi
{
  @Nullable
  public abstract ToServiceMsg createToServiceMsg(@Nullable String paramString);
  
  @Nullable
  public abstract ToServiceMsg makeOIDBPkg(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte);
  
  public abstract int parseOIDBPkg(@Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject, @Nullable MessageMicro<? extends MessageMicro<?>> paramMessageMicro);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper
 * JD-Core Version:    0.7.0.1
 */