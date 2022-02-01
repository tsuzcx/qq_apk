package com.tencent.mobileqq.flashshow.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFSJumpSelectPhotoUtils
  extends QRouteApi
{
  public abstract void jumpPublishMood(Context paramContext, Intent paramIntent);
  
  public abstract void jumpTakePhoto(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFSJumpSelectPhotoUtils
 * JD-Core Version:    0.7.0.1
 */