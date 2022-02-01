package com.tencent.mobileqq.ptt.temp.api.impl;

import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi;
import mqq.app.AppRuntime;

public class AudioPanelTempApiImpl
  implements IAudioPanelTempApi
{
  public void ListenPanel_startPlayAnimByType_RecordStopToPlayType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ((ListenPanel)paramView.getParent().getParent()).b(201);
  }
  
  public boolean getAppIsVideoChatting(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)paramAppRuntime).isVideoChatting();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.AudioPanelTempApiImpl
 * JD-Core Version:    0.7.0.1
 */