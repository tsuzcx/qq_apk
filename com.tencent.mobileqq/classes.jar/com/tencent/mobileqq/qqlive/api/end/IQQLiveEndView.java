package com.tencent.mobileqq.qqlive.api.end;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;

public abstract interface IQQLiveEndView
{
  public abstract View getView();
  
  public abstract void setFollow(int paramInt);
  
  public abstract void setFollowVisible(boolean paramBoolean);
  
  public abstract void setHeadIcon(String paramString);
  
  public abstract void setLeftRecommend(QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo);
  
  public abstract void setLiveTime(long paramLong);
  
  public abstract void setNick(String paramString);
  
  public abstract void setPopularity(String paramString);
  
  public abstract void setRightRecommend(QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
 * JD-Core Version:    0.7.0.1
 */