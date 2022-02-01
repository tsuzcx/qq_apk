package com.tencent.mobileqq.kandian.biz.viola.api;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaSoLoaderManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaSoLoaderManager
  extends QRouteApi
{
  public abstract void loadLibrary(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaSoLoaderManager
 * JD-Core Version:    0.7.0.1
 */