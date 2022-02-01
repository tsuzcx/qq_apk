package com.tencent.mobileqq.studyroom.api;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStudyRoomConfig
  extends QRouteApi
{
  public abstract Class<? extends IQConfigProcessor> getConfigClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.IStudyRoomConfig
 * JD-Core Version:    0.7.0.1
 */