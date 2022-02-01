package com.tencent.mobileqq.qqalbum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"peak"})
public abstract interface IPhotoTempUtils
  extends QRouteApi
{
  public abstract void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean);
  
  public abstract Intent toCropActivity(Activity paramActivity, Intent paramIntent);
  
  public abstract Intent toEditPicActivityIntent(Activity paramActivity, Intent paramIntent, String paramString, int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.IPhotoTempUtils
 * JD-Core Version:    0.7.0.1
 */