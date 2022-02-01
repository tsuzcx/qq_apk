package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import java.util.List;

@QAPI(process={"all"})
public abstract interface INearbyNewRedDotManager
  extends QRouteApi
{
  public abstract void init(Object paramObject);
  
  public abstract void onDestroy(Object paramObject);
  
  public abstract void parsePushRedPointInfo(Object paramObject, List<NumRedMsg.NumMsgBusi> paramList);
  
  public abstract void queryNearbyMsgInfos(Object paramObject, List<BusinessInfoCheckUpdate.NumRedInfo> paramList);
  
  public abstract List<Object> queryNearbyNumRedBusiInfo(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyNewRedDotManager
 * JD-Core Version:    0.7.0.1
 */