package com.tencent.ttpic.offlineset.beans;

import com.tencent.ttpic.util.GsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AEKitDownSetting$DownResInfo
{
  public String maxAppVer;
  public String md5;
  public String minAppVer;
  public String res_id;
  public String url;
  public String ver;
  
  public AEKitDownSetting$DownResInfo(AEKitDownSetting paramAEKitDownSetting) {}
  
  public String getDownResInfoString(String paramString)
  {
    if (!AEKitDownSetting.access$000(paramString, this)) {
      return null;
    }
    return GsonUtils.obj2Json(this, new AEKitDownSetting.DownResInfo.1(this).getType());
  }
  
  public String getResInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!AEKitDownSetting.access$000(paramString1, this)) {
      return null;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put(paramString2, this.url);
      paramString1.put(paramString3, this.md5);
      paramString1.put(paramString4, this.ver);
      return paramString1.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.AEKitDownSetting.DownResInfo
 * JD-Core Version:    0.7.0.1
 */