package org.light.report.avreport;

import java.util.HashMap;
import org.light.utils.GsonUtils;

public class LightSDKRecord
{
  private HashMap<String, String> firstInfos;
  private HashMap<String, String> frameInfos;
  private HashMap<String, String> gLFinishInfos;
  private String mMateriaID;
  
  public LightSDKRecord(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, HashMap<String, String> paramHashMap3)
  {
    this.mMateriaID = paramString;
    this.firstInfos = paramHashMap3;
    this.gLFinishInfos = paramHashMap2;
    this.frameInfos = paramHashMap1;
  }
  
  public HashMap<String, String> getFirstInfo()
  {
    return this.firstInfos;
  }
  
  public HashMap<String, String> getFrameInfo()
  {
    return this.frameInfos;
  }
  
  public HashMap<String, String> getGlFinishInfo()
  {
    return this.gLFinishInfos;
  }
  
  public String getJsonStr()
  {
    return GsonUtils.obj2Json(this, new LightSDKRecord.1(this).getType());
  }
  
  public String getMateriaID()
  {
    return this.mMateriaID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.report.avreport.LightSDKRecord
 * JD-Core Version:    0.7.0.1
 */