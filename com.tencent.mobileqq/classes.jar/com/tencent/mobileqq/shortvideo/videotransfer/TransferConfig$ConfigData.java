package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class TransferConfig$ConfigData
{
  public static final String KEY_COMMON_FLOAT_1 = "commonfloat1";
  public static final String KEY_COMMON_FLOAT_2 = "commonfloat2";
  public static final String KEY_COMMON_FLOAT_3 = "commonfloat3";
  public static final String KEY_COMMON_FLOAT_4 = "commonfloat4";
  public static final String KEY_DURATION = "duration";
  public static final String KEY_FRAGMENT_SHADER = "fsh";
  public static final String KEY_ID = "id";
  public static final String KEY_VERTEX_SHADER = "vsh";
  public TransferConfig.ExtendParamFloats mCommonFloat1;
  public TransferConfig.ExtendParamFloats mCommonFloat2;
  public TransferConfig.ExtendParamFloats mCommonFloat3;
  public TransferConfig.ExtendParamFloats mCommonFloat4;
  public long mDuration;
  public String mFragShader;
  public int mID;
  public boolean mLevelEffectShader = false;
  public String mVerShader;
  public List<HashMap<String, String>> shaderList = new ArrayList();
  
  public void addShaderToList(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vsh", paramString1);
    localHashMap.put("fsh", paramString2);
    this.shaderList.add(localHashMap);
  }
  
  public void fromJSONObject(String paramString)
  {
    reset();
    try
    {
      paramString = new JSONObject(paramString);
      this.mID = paramString.optInt("id");
      Object localObject = TransferConfig.getConfigData(this.mID);
      if (localObject != null)
      {
        this.mVerShader = ((ConfigData)localObject).mVerShader;
        this.mFragShader = ((ConfigData)localObject).mFragShader;
        HashMap localHashMap = new HashMap();
        localHashMap.put("vsh", this.mVerShader);
        localHashMap.put("fsh", this.mFragShader);
        this.shaderList.clear();
        this.shaderList.addAll(((ConfigData)localObject).shaderList);
      }
      this.mDuration = paramString.optLong("duration");
      localObject = paramString.optString("commonfloat1");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.mCommonFloat1 = new TransferConfig.ExtendParamFloats();
        this.mCommonFloat1.fromJSONObject((String)localObject);
      }
      else
      {
        this.mCommonFloat1 = null;
      }
      localObject = paramString.optString("commonfloat2");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.mCommonFloat2 = new TransferConfig.ExtendParamFloats();
        this.mCommonFloat2.fromJSONObject((String)localObject);
      }
      else
      {
        this.mCommonFloat2 = null;
      }
      localObject = paramString.optString("commonfloat3");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.mCommonFloat3 = new TransferConfig.ExtendParamFloats();
        this.mCommonFloat3.fromJSONObject((String)localObject);
      }
      else
      {
        this.mCommonFloat3 = null;
      }
      paramString = paramString.optString("commonfloat4");
      if (!TextUtils.isEmpty(paramString))
      {
        this.mCommonFloat4 = new TransferConfig.ExtendParamFloats();
        this.mCommonFloat4.fromJSONObject(paramString);
        return;
      }
      this.mCommonFloat4 = null;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean isValid()
  {
    return this.mID != -1;
  }
  
  public void reset()
  {
    this.mID = -1;
    this.mVerShader = null;
    this.mFragShader = null;
    this.shaderList.clear();
    this.mDuration = 0L;
    this.mCommonFloat1 = null;
    this.mCommonFloat2 = null;
    this.mCommonFloat3 = null;
    this.mCommonFloat4 = null;
  }
  
  public String toJSONObject()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", this.mID);
      ((JSONObject)localObject).put("duration", this.mDuration);
      String str;
      if (this.mCommonFloat1 != null)
      {
        str = this.mCommonFloat1.toJSONObject();
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject).put("commonfloat1", str);
        }
      }
      if (this.mCommonFloat2 != null)
      {
        str = this.mCommonFloat2.toJSONObject();
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject).put("commonfloat2", str);
        }
      }
      if (this.mCommonFloat3 != null)
      {
        str = this.mCommonFloat3.toJSONObject();
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject).put("commonfloat3", str);
        }
      }
      if (this.mCommonFloat4 != null)
      {
        str = this.mCommonFloat4.toJSONObject();
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject).put("commonfloat4", str);
        }
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData
 * JD-Core Version:    0.7.0.1
 */