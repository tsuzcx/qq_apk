package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface QCircleRecentDataInterface
{
  public abstract byte[] getGiftInfo();
  
  public abstract CharSequence getLastMsg();
  
  public abstract CharSequence getMsgExtraInfo();
  
  public abstract String getRecentUserUin();
  
  public abstract String getShowTime();
  
  public abstract String getTaskId();
  
  public abstract String getTitleName();
  
  public abstract int getUnreadNum();
  
  public abstract void setGiftInfo(byte[] paramArrayOfByte);
  
  public abstract void update();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
 * JD-Core Version:    0.7.0.1
 */