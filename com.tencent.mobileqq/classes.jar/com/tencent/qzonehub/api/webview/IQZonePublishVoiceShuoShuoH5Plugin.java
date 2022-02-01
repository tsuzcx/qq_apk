package com.tencent.qzonehub.api.webview;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZonePublishVoiceShuoShuoH5Plugin
  extends QRouteApi
{
  public abstract void onDeleteAudioVoice(String paramString);
  
  public abstract void onNotifyH5CutCancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.webview.IQZonePublishVoiceShuoShuoH5Plugin
 * JD-Core Version:    0.7.0.1
 */