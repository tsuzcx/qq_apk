package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySpEventReportUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addLbsInfo", "", "json", "Lorg/json/JSONObject;", "init", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySpEventReportUtil
  extends QRouteApi
{
  public abstract void addLbsInfo(@Nullable JSONObject paramJSONObject);
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySpEventReportUtil
 * JD-Core Version:    0.7.0.1
 */