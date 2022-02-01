package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.requests.QCircleDoFollowRequest;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleFollowApiImpl
  implements IQCircleFollowApi
{
  private static final String TAG = "QCircleConfigApiImpl";
  
  public ArrayList<Entity> getFollowUserList()
  {
    return QCircleDoubleFollowUserHepler.getInstance().getFollowUserList();
  }
  
  public BaseRequest getQCircleFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    return new QCircleDoFollowRequest(paramStUser, paramInt, paramStCommonExt);
  }
  
  public int getUinFollowed(String paramString)
  {
    return QCircleFollowManager.getInstance().getUinFollowed(paramString).intValue();
  }
  
  public boolean hasUin(String paramString)
  {
    return QCircleFollowManager.getInstance().hasUin(paramString);
  }
  
  public void setUinFollowed(String paramString, int paramInt)
  {
    QCircleFollowManager.getInstance().setUinFollowed(paramString, paramInt);
  }
  
  public void updateFollowUser(String paramString1, String paramString2, boolean paramBoolean)
  {
    QCircleDoubleFollowUserHepler.getInstance().updateFollowUser(paramString1, paramString2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleFollowApiImpl
 * JD-Core Version:    0.7.0.1
 */