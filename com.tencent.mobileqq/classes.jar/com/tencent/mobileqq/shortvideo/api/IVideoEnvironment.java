package com.tencent.mobileqq.shortvideo.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVideoEnvironment
  extends QRouteApi
{
  public abstract boolean checkAndLoadAVCodec();
  
  public abstract int getAVCodecVersion();
  
  public abstract String getShortVideoSoLibName();
  
  public abstract String getShortVideoSoPath(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.IVideoEnvironment
 * JD-Core Version:    0.7.0.1
 */