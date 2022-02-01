package com.tencent.mobileqq.vas.adv.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "T", "Lcom/tencent/mobileqq/pb/MessageMicro;", "", "onError", "", "code", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "", "e", "", "onSucceed", "rsp", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvBizCallback<T extends MessageMicro<T>>
{
  public abstract void a(@NotNull T paramT);
  
  public abstract void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback
 * JD-Core Version:    0.7.0.1
 */