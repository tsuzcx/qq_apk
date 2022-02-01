package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyWebDataManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addLog", "", "content", "", "getCSRFToken", "skey", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyWebDataManager
  extends QRouteApi
{
  public abstract void addLog(@Nullable String paramString);
  
  @Nullable
  public abstract String getCSRFToken(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyWebDataManager
 * JD-Core Version:    0.7.0.1
 */