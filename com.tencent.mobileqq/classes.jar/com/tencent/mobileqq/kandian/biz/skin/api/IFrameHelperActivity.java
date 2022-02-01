package com.tencent.mobileqq.kandian.biz.skin.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/IFrameHelperActivity;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "setDrawerFrameEnable", "", "enabled", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFrameHelperActivity
  extends QRouteApi
{
  public abstract void setDrawerFrameEnable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.IFrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */