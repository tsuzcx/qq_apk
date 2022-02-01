package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/TemplateFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/ITemplateFactory;", "()V", "getTemplateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "serviceId", "", "autoCreate", "", "data", "Lorg/json/JSONObject;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateFactoryImpl
  implements ITemplateFactory
{
  @Nullable
  public TemplateBean getTemplateBean(@NotNull String paramString, boolean paramBoolean, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "serviceId");
    paramString = TemplateFactory.a(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.getTemplateBean(paramJSONObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.TemplateFactoryImpl
 * JD-Core Version:    0.7.0.1
 */