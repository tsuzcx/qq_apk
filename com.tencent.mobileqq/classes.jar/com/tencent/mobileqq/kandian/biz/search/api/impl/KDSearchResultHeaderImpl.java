package com.tencent.mobileqq.kandian.biz.search.api.impl;

import com.tencent.mobileqq.kandian.biz.search.api.IKDSearchResultHeader;
import com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultHeader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/search/api/impl/KDSearchResultHeaderImpl;", "Lcom/tencent/mobileqq/kandian/biz/search/api/IKDSearchResultHeader;", "()V", "handleForHeader", "", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDSearchResultHeaderImpl
  implements IKDSearchResultHeader
{
  @NotNull
  public Map<String, String> handleForHeader()
  {
    Map localMap = KDSearchResultHeader.a();
    Intrinsics.checkExpressionValueIsNotNull(localMap, "KDSearchResultHeader.handleForHeader()");
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.api.impl.KDSearchResultHeaderImpl
 * JD-Core Version:    0.7.0.1
 */