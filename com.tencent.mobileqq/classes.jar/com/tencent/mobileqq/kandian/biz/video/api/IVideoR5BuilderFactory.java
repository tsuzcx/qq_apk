package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5BuilderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "create", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5Builder;", "md5", "", "puin", "vid", "aid", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoR5BuilderFactory
  extends QRouteApi
{
  @NotNull
  public abstract IVideoR5Builder create(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory
 * JD-Core Version:    0.7.0.1
 */