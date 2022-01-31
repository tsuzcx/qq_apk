package com.tencent.mobileqq.triton.sdk;

import android.app.Activity;
import android.content.Context;

public abstract interface APIProxy
{
  public abstract void doAddFriend(Context paramContext, String paramString, APICallback paramAPICallback);
  
  public abstract void getUserInfo(boolean paramBoolean, String paramString, APICallback paramAPICallback);
  
  public abstract void gotoPermissionSetting(Activity paramActivity);
  
  public abstract void httpRequestForImage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract void loadSubPackage(long paramLong1, long paramLong2, String paramString, ITSubPackage paramITSubPackage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.APIProxy
 * JD-Core Version:    0.7.0.1
 */