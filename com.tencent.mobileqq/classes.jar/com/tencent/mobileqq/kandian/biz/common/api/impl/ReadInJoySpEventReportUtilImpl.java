package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySpEventReportUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoySpEventReportUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoySpEventReportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySpEventReportUtil;", "()V", "addLbsInfo", "", "json", "Lorg/json/JSONObject;", "init", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySpEventReportUtilImpl
  implements IReadInJoySpEventReportUtil
{
  public void addLbsInfo(@Nullable JSONObject paramJSONObject)
  {
    ReadInJoySpEventReportUtil.a(paramJSONObject);
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoySpEventReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */