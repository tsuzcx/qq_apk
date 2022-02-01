package com.tencent.mobileqq.kandian.glue.router.msgbox.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/router/msgbox/api/IRIJMsgBoxUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMsgBoxUIMode", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJMsgBoxUtils
  extends QRouteApi
{
  public abstract int getMsgBoxUIMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.msgbox.api.IRIJMsgBoxUtils
 * JD-Core Version:    0.7.0.1
 */