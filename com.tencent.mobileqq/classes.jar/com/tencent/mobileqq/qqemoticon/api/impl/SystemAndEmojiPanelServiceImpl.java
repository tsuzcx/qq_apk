package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.Builder;
import mqq.app.AppRuntime;

public class SystemAndEmojiPanelServiceImpl
  implements ISystemAndEmojiPanelService
{
  private AppRuntime mAppRuntime;
  
  public ISystemAndEmojiPanelService.Builder newBuilder()
  {
    return new SystemAndEmojiPanelServiceImpl.BuilderImpl(this);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mAppRuntime = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.SystemAndEmojiPanelServiceImpl
 * JD-Core Version:    0.7.0.1
 */