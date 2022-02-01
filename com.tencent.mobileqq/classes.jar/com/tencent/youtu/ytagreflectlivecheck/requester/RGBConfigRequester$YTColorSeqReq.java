package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;

public class RGBConfigRequester$YTColorSeqReq
{
  public String android_apilevel;
  public String android_version;
  public String app_id;
  public String build_brand = Build.BRAND;
  public String build_device = Build.DEVICE;
  public String build_display = Build.DISPLAY;
  public String build_hardware = Build.HARDWARE;
  public String build_id = Build.ID;
  public String build_model = Build.MODEL;
  public String build_product = Build.PRODUCT;
  public String build_serial = Build.SERIAL;
  public String build_test = null;
  public String business_name;
  public String person_id;
  public int platform;
  
  public RGBConfigRequester$YTColorSeqReq(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    this.android_apilevel = localStringBuilder.toString();
    this.android_version = Build.VERSION.RELEASE;
    this.app_id = paramString1;
    this.business_name = paramString2;
    this.person_id = paramString3;
    this.platform = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq
 * JD-Core Version:    0.7.0.1
 */