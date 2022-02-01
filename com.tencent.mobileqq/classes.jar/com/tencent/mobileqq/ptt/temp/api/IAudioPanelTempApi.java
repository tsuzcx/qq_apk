package com.tencent.mobileqq.ptt.temp.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IAudioPanelTempApi
  extends QRouteApi
{
  public abstract void ListenPanel_startPlayAnimByType_RecordStopToPlayType(View paramView);
  
  public abstract boolean getAppIsVideoChatting(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi
 * JD-Core Version:    0.7.0.1
 */