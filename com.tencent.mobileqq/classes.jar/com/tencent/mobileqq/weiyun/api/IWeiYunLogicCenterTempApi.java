package com.tencent.mobileqq.weiyun.api;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IWeiYunLogicCenterTempApi
  extends IRuntimeService
{
  public abstract void saveAioMedia2Weiyun(ChatMessage paramChatMessage, WeiyunCallback paramWeiyunCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiYunLogicCenterTempApi
 * JD-Core Version:    0.7.0.1
 */