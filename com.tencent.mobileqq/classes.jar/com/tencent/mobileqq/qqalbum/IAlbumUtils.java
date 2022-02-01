package com.tencent.mobileqq.qqalbum;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IAlbumUtils
  extends QRouteApi
{
  public abstract String formatTimeToString(long paramLong);
  
  public abstract void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, HashMap<String, PhotoSendParams> paramHashMap, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.IAlbumUtils
 * JD-Core Version:    0.7.0.1
 */