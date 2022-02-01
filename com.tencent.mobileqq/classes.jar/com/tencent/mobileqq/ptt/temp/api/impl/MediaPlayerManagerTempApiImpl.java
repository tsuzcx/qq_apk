package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi;
import mqq.app.AppRuntime;

public class MediaPlayerManagerTempApiImpl
  implements IMediaPlayerManagerTempApi
{
  public void mediaPlayer_doStop(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      paramAppRuntime = (MediaPlayerManager)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
      if (paramAppRuntime != null) {
        paramAppRuntime.a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.MediaPlayerManagerTempApiImpl
 * JD-Core Version:    0.7.0.1
 */