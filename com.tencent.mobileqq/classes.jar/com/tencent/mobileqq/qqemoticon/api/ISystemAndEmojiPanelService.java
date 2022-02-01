package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.api.IRuntimeService;

@QAPI(process={"all"})
public abstract interface ISystemAndEmojiPanelService
  extends IRuntimeService
{
  public abstract ISystemAndEmojiPanelService.Builder newBuilder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService
 * JD-Core Version:    0.7.0.1
 */