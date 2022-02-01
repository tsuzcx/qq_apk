package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJUgcUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcUtils;", "()V", "needShowUploadVideoEntry", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUgcUtilsImpl
  implements IRIJUgcUtils
{
  public boolean needShowUploadVideoEntry()
  {
    return RIJUgcUtils.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJUgcUtilsImpl
 * JD-Core Version:    0.7.0.1
 */