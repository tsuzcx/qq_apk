package com.tencent.mobileqq.kandian.base.ktx;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ACCOUNT_SCOPE", "Lkotlin/Function0;", "", "getACCOUNT_SCOPE", "()Lkotlin/jvm/functions/Function0;", "accountCache", "Lkotlin/Lazy;", "T", "initializer", "cache", "scope", "", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class CacheDelegateKt
{
  @NotNull
  private static final Function0<String> a = (Function0)CacheDelegateKt.ACCOUNT_SCOPE.1.INSTANCE;
  
  @NotNull
  public static final Function0<String> a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.CacheDelegateKt
 * JD-Core Version:    0.7.0.1
 */