package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

@PluginInterface
public abstract interface QCircleRecentDataInterface
{
  public abstract QQCirclePrivateMsgShow.UserPMGiftInfo getGiftInfo();
  
  public abstract CharSequence getLastMsg();
  
  public abstract CharSequence getMsgExtraInfo();
  
  public abstract String getRecentUserUin();
  
  public abstract String getShowTime();
  
  public abstract String getTaskId();
  
  public abstract String getTitleName();
  
  public abstract int getUnreadNum();
  
  public abstract void setGiftInfo(QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo);
  
  public abstract void update();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
 * JD-Core Version:    0.7.0.1
 */