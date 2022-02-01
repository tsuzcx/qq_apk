package com.tencent.qzonehub.api.music;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneWebMusicJsPlugin
  extends QRouteApi
{
  public static final String METHOD_STOP_MUSIC_BOX = "stopMusicBox";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.music.IQzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */