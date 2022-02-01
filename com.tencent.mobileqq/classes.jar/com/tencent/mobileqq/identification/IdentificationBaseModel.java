package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;

public class IdentificationBaseModel
{
  static String[] a = { "libopencv_tinyworld.so", "libYTFaceTracker.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  static String[] b = { "YTCommon" };
  protected IFaceController a;
  protected RequestListener a;
  
  @RequiresApi(api=18)
  public static IdentificationBaseModel a(int paramInt, Intent paramIntent, RequestListener paramRequestListener)
  {
    return new IdentificationPoseReflect(paramIntent, paramRequestListener);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, Activity paramActivity) {}
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    return false;
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationBaseModel
 * JD-Core Version:    0.7.0.1
 */