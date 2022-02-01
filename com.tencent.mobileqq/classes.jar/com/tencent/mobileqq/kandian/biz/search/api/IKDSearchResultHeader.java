package com.tencent.mobileqq.kandian.biz.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/search/api/IKDSearchResultHeader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "handleForHeader", "", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKDSearchResultHeader
  extends QRouteApi
{
  @NotNull
  public abstract Map<String, String> handleForHeader();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.api.IKDSearchResultHeader
 * JD-Core Version:    0.7.0.1
 */