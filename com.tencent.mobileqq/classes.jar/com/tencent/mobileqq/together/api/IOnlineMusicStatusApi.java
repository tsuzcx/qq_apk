package com.tencent.mobileqq.together.api;

import com.tencent.mobileqq.onlinestatus.OnlineMusicStatus;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOnlineMusicStatusApi
  extends QRouteApi
{
  public static final int SOURCE_FROM_LEBA = 4;
  public static final int SOURCE_FROM_LISTEN_C2C = 2;
  public static final int SOURCE_FROM_LISTEN_GROUP = 3;
  public static final int SOURCE_FROM_STRUCT_MSG = 1;
  
  public abstract OnlineMusicStatus buildFromMusicInfo(boolean paramBoolean);
  
  public abstract OnlineMusicStatus buildFromSongInfo(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.api.IOnlineMusicStatusApi
 * JD-Core Version:    0.7.0.1
 */