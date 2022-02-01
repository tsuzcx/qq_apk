package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUGCDianDian;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJUGCDianDianImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUGCDianDian;", "()V", "getVideoUploadTaskSize", "", "secondClassDeliverOperationReport", "", "tabSource", "", "releaseType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUGCDianDianImpl
  implements IRIJUGCDianDian
{
  public int getVideoUploadTaskSize()
  {
    return RIJUGCDianDian.b();
  }
  
  public void secondClassDeliverOperationReport(@Nullable String paramString1, @Nullable String paramString2)
  {
    RIJUGCDianDian.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJUGCDianDianImpl
 * JD-Core Version:    0.7.0.1
 */