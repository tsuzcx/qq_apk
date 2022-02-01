package com.tencent.mobileqq.vas.adv.common.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "T", "", "onResult", "", "result", "(Ljava/lang/Object;)V", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasResultCallback<T>
{
  public abstract void onResult(@Nullable T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback
 * JD-Core Version:    0.7.0.1
 */