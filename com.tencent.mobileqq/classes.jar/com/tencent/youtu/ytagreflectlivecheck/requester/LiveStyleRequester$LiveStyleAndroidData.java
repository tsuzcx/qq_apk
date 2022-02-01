package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;

public class LiveStyleRequester$LiveStyleAndroidData
{
  public String android_apilevel;
  public String android_version;
  public String build_brand = Build.BRAND;
  public String build_device = Build.DEVICE;
  public String build_display = Build.DISPLAY;
  public String build_hardware = Build.HARDWARE;
  public String build_model = Build.MODEL;
  public String build_product = Build.PRODUCT;
  public float lux = 0.0F;
  
  public LiveStyleRequester$LiveStyleAndroidData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    this.android_apilevel = localStringBuilder.toString();
    this.android_version = Build.VERSION.RELEASE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData
 * JD-Core Version:    0.7.0.1
 */