package com.tencent.mobileqq.kandian.biz.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoyConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isEnterMultiMode", "", "videoFrom", "", "videoWidth", "videoHeight", "duration", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyConfig
  extends QRouteApi
{
  public static final int CONFIG_ID = 92;
  public static final IReadInJoyConfig.Companion Companion = IReadInJoyConfig.Companion.a;
  
  public abstract boolean isEnterMultiMode(int paramInt);
  
  public abstract boolean isEnterMultiMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.api.IReadInJoyConfig
 * JD-Core Version:    0.7.0.1
 */