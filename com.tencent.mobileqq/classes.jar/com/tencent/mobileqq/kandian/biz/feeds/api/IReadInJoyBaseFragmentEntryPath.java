package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IReadInJoyBaseFragmentEntryPath;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clear", "", "get", "", "key", "(I)Ljava/lang/Integer;", "put", "value", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyBaseFragmentEntryPath
  extends QRouteApi
{
  public abstract void clear();
  
  @Nullable
  public abstract Integer get(int paramInt);
  
  public abstract void put(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyBaseFragmentEntryPath
 * JD-Core Version:    0.7.0.1
 */