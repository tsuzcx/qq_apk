package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyOidbHelperImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyOidbHelper;", "()V", "createToServiceMsg", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "cmd", "", "makeOIDBPkg", "command", "", "serviceType", "bodyByte", "", "parseOIDBPkg", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "Ljava/lang/Object;", "msg", "Lcom/tencent/mobileqq/pb/MessageMicro;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyOidbHelperImpl
  implements IReadInJoyOidbHelper
{
  @Nullable
  public ToServiceMsg createToServiceMsg(@Nullable String paramString)
  {
    return ReadInJoyOidbHelper.a(paramString);
  }
  
  @Nullable
  public ToServiceMsg makeOIDBPkg(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte)
  {
    return ReadInJoyOidbHelper.a(paramString, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public int parseOIDBPkg(@Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject, @Nullable MessageMicro<? extends MessageMicro<?>> paramMessageMicro)
  {
    return ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramMessageMicro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ReadInJoyOidbHelperImpl
 * JD-Core Version:    0.7.0.1
 */