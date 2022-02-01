package com.tencent.mobileqq.pttview;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqaudio.IAudioFocusLossProcessor;
import mqq.app.AppRuntime;

public class QQPttAudioFocusLossProcessor
  implements IAudioFocusLossProcessor
{
  public void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      MediaPlayerManager.a((QQAppInterface)localAppRuntime).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttview.QQPttAudioFocusLossProcessor
 * JD-Core Version:    0.7.0.1
 */