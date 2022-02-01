package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/impl/RIJUserProtoUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/account/api/IRIJUserProtoUtils;", "()V", "check", "", "context", "Landroid/content/Context;", "afterSuccess", "Ljava/lang/Runnable;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserProtoUtilsImpl
  implements IRIJUserProtoUtils
{
  public boolean check(@NotNull Context paramContext, @Nullable Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.check(paramContext, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */