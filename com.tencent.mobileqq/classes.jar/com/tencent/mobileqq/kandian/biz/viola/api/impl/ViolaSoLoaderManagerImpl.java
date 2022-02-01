package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaSoLoaderManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaSoLoaderManager;", "()V", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManagerImpl
  implements IViolaSoLoaderManager
{
  public void loadLibrary(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback)
  {
    ViolaSoLoaderManager.a.a().a(paramString, paramLoadLibCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaSoLoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */