package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyNewRedDotManager;
import com.tencent.mobileqq.nearby.api.NearbyNewRedDotManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import java.util.List;

public class NearbyNewRedDotManagerImpl
  implements INearbyNewRedDotManager
{
  private static NearbyNewRedDotManager sNearbyNewRedDotManager = ;
  
  public void init(Object paramObject)
  {
    sNearbyNewRedDotManager.a((QQAppInterface)paramObject);
  }
  
  public void onDestroy(Object paramObject)
  {
    sNearbyNewRedDotManager.b((QQAppInterface)paramObject);
  }
  
  public void parsePushRedPointInfo(Object paramObject, List<NumRedMsg.NumMsgBusi> paramList)
  {
    sNearbyNewRedDotManager.b((QQAppInterface)paramObject, paramList);
  }
  
  public void queryNearbyMsgInfos(Object paramObject, List<BusinessInfoCheckUpdate.NumRedInfo> paramList)
  {
    sNearbyNewRedDotManager.a((QQAppInterface)paramObject, paramList);
  }
  
  public List<Object> queryNearbyNumRedBusiInfo(Object paramObject)
  {
    return sNearbyNewRedDotManager.a((QQAppInterface)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyNewRedDotManagerImpl
 * JD-Core Version:    0.7.0.1
 */