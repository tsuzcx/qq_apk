package com.tencent.youtu.sdkkitframework.liveness;

import java.util.ArrayList;

public class YtLivenessNetProtoHelper$LiveStyleRequester$SeleceData
{
  public YtLivenessNetProtoHelper.LiveStyleRequester.LiveStyleAndroidData android_data = new YtLivenessNetProtoHelper.LiveStyleRequester.LiveStyleAndroidData();
  public int change_point_num = 2;
  public String client_version;
  public String config;
  public int platform = 2;
  public int protocal = 1;
  public String reflect_param;
  public ArrayList<YtLivenessNetProtoHelper.SensorData> sensor_data;
  public String version = "3.6.8";
  
  public YtLivenessNetProtoHelper$LiveStyleRequester$SeleceData(float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.android_data.lux = paramFloat;
    this.change_point_num = paramInt;
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      this.reflect_param = paramString1;
    }
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      this.config = paramString3;
    }
    this.client_version = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData
 * JD-Core Version:    0.7.0.1
 */