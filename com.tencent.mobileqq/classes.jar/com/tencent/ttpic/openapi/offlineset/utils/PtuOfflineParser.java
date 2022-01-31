package com.tencent.ttpic.openapi.offlineset.utils;

import com.tencent.ttpic.offlineset.beans.AEKitDownSetting;
import com.tencent.ttpic.offlineset.beans.AEKitDownSetting.DownResInfo;
import com.tencent.ttpic.offlineset.beans.AIBeautyConfigJsonBean;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.DeviceDownConfigJsonBean;
import com.tencent.ttpic.util.GsonUtils;

public class PtuOfflineParser
{
  private static PtuOfflineParser sParser;
  
  public static PtuOfflineParser getInstance()
  {
    if (sParser == null) {
      sParser = new PtuOfflineParser();
    }
    return sParser;
  }
  
  public AIBeautyParamsJsonBean getDefaultAIBeautyParam()
  {
    return parseAIBeautyParam("camera/camera_video/configsetting/beauty.json", true);
  }
  
  public AEKitDownSetting parseAEKitDownSetting(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (AEKitDownSetting)GsonUtils.json2Obj(paramString, new PtuOfflineParser.4(this).getType());
  }
  
  public AIBeautyConfigJsonBean parseAIBeautyConfig(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (AIBeautyConfigJsonBean)GsonUtils.json2Obj(paramString, new PtuOfflineParser.2(this).getType());
  }
  
  public AIBeautyParamsJsonBean parseAIBeautyParam(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = FileOfflineUtil.readStringFromAssets(paramString); paramString == null; paramString = FileOfflineUtil.readJsonStringFromFile(paramString)) {
      return null;
    }
    return (AIBeautyParamsJsonBean)GsonUtils.json2Obj(paramString, new PtuOfflineParser.1(this).getType());
  }
  
  public DeviceDownConfigJsonBean parseDeviceDownConfig(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (DeviceDownConfigJsonBean)GsonUtils.json2Obj(paramString, new PtuOfflineParser.3(this).getType());
  }
  
  public AEKitDownSetting.DownResInfo parseDownResInfo(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (AEKitDownSetting.DownResInfo)GsonUtils.json2Obj(paramString, new PtuOfflineParser.5(this).getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser
 * JD-Core Version:    0.7.0.1
 */