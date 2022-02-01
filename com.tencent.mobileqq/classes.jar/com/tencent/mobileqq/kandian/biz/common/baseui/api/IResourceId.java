package com.tencent.mobileqq.kandian.biz.common.baseui.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IResourceId;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCommonMaskView", "", "getId", "name", "", "getLayoutId", "Id", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IResourceId
  extends QRouteApi
{
  public static final IResourceId.Id Id = IResourceId.Id.a;
  
  public abstract int getCommonMaskView();
  
  public abstract int getId(@NotNull String paramString);
  
  public abstract int getLayoutId(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId
 * JD-Core Version:    0.7.0.1
 */