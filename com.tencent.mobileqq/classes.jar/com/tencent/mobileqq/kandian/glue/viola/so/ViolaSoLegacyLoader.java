package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLegacyLoader;", "Lcom/tencent/mobileqq/kandian/glue/viola/so/IViolaSoLoader;", "()V", "isEngineReady", "", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "preLoadViola", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLegacyLoader
  implements IViolaSoLoader
{
  public void a() {}
  
  public void a(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback)
  {
    ReadInJoyWebRenderEngine.a(paramString, paramLoadLibCallback);
  }
  
  public boolean b()
  {
    return ReadInJoyWebRenderEngine.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLegacyLoader
 * JD-Core Version:    0.7.0.1
 */