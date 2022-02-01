package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/ITemplateFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getTemplateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "serviceId", "", "autoCreate", "", "data", "Lorg/json/JSONObject;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITemplateFactory
  extends QRouteApi
{
  @Nullable
  public abstract TemplateBean getTemplateBean(@NotNull String paramString, boolean paramBoolean, @Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory
 * JD-Core Version:    0.7.0.1
 */