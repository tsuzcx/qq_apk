package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/IViolaSoLoader;", "", "isEngineReady", "", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "preLoadViola", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaSoLoader
{
  public abstract void a();
  
  public abstract void a(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.IViolaSoLoader
 * JD-Core Version:    0.7.0.1
 */