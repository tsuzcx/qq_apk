package com.tencent.mobileqq.mini.api;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMiniAppFileMaterialService
  extends QRouteApi
{
  public static final String MIME_TYPE_IMAGE = "image/*";
  
  public abstract boolean isFileSupported(String paramString);
  
  public abstract boolean isMimeTypeSupported(@NonNull String paramString);
  
  public abstract void showSupportedAppList(@NonNull Activity paramActivity, String paramString);
  
  public abstract void showSupportedAppList(@NonNull Activity paramActivity, String paramString1, @NonNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService
 * JD-Core Version:    0.7.0.1
 */