package com.tencent.mobileqq.kandian.biz.ugc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needShowCreateColumnEntry", "", "needShowUploadVideoEntry", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJUgcUtils
  extends QRouteApi
{
  public abstract boolean needShowCreateColumnEntry();
  
  public abstract boolean needShowUploadVideoEntry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcUtils
 * JD-Core Version:    0.7.0.1
 */