package com.tencent.mobileqq.qcircle.api;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import java.util.Map;

@QAPI(process={""})
public abstract interface IQCircleFollowApi
  extends QRouteApi
{
  public abstract Map<String, List<Entity>> getCircleFriendMap();
  
  public abstract BaseRequest getQCircleFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt);
  
  public abstract int getUinFollowed(String paramString);
  
  public abstract boolean hasUin(String paramString);
  
  public abstract void setUinFollowed(String paramString, int paramInt);
  
  public abstract void updateFollowUser(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleFollowApi
 * JD-Core Version:    0.7.0.1
 */