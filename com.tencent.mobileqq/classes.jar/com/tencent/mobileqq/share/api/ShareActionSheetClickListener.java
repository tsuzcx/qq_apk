package com.tencent.mobileqq.share.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface ShareActionSheetClickListener
{
  public abstract void delete();
  
  public abstract void deleteHasPush();
  
  public abstract void hideHim();
  
  public abstract void hideThisWork();
  
  public abstract void jumpQcirclePrivateMessage();
  
  public abstract void miniAppDebugOn();
  
  public abstract void report();
  
  public abstract void save();
  
  public abstract void shareToQQ();
  
  public abstract void shareToQZone();
  
  public abstract void shareToSpecifiedFriend(String paramString, int paramInt);
  
  public abstract void shareToWeChat();
  
  public abstract void shareToWeChatCircle();
  
  public abstract void showReportDisLike();
  
  public abstract void switchBarrageClose();
  
  public abstract void switchBarrageOpen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.ShareActionSheetClickListener
 * JD-Core Version:    0.7.0.1
 */