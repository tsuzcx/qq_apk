package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface ISystemAndEmojiPanelService
  extends IRuntimeService
{
  public abstract ISystemAndEmojiPanelService.Builder newBuilder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService
 * JD-Core Version:    0.7.0.1
 */