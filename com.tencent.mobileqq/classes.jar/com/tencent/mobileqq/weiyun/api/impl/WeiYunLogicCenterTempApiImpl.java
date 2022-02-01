package com.tencent.mobileqq.weiyun.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiYunLogicCenterTempApi;
import mqq.app.AppRuntime;

public class WeiYunLogicCenterTempApiImpl
  implements IWeiYunLogicCenterTempApi
{
  private AppRuntime mAppRuntime;
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void saveAioMedia2Weiyun(ChatMessage paramChatMessage, WeiyunCallback paramWeiyunCallback)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.getFileManagerEngine().d().a(paramChatMessage, paramWeiyunCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiYunLogicCenterTempApiImpl
 * JD-Core Version:    0.7.0.1
 */