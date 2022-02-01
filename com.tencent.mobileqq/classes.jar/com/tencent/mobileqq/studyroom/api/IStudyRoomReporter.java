package com.tencent.mobileqq.studyroom.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStudyRoomReporter
  extends QRouteApi
{
  public static final String ACTION = "action";
  public static final String MODULE = "module";
  public static final String PAGE = "page";
  
  public abstract void reportForExpandEntry();
  
  public abstract void reportForTroopEntry(long paramLong, String paramString);
  
  public abstract void reportWithBundle(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.IStudyRoomReporter
 * JD-Core Version:    0.7.0.1
 */