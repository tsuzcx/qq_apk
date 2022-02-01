package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransferConfig$ExtendParamFloats
{
  public static final String KEY_RULE = "rule";
  public static final String KEY_VALUE = "value";
  public TransferConfig.ParamRule mRule = null;
  public float[] mValues = null;
  
  public TransferConfig$ExtendParamFloats() {}
  
  public TransferConfig$ExtendParamFloats(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mValues = paramArrayOfFloat;
    this.mRule = new TransferConfig.ParamRule(paramInt1, paramInt2, paramInt3);
  }
  
  public void fromJSONObject(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.optJSONArray("value");
      if ((localJSONArray != null) && (localJSONArray.length() != 0))
      {
        this.mValues = new float[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.mValues[i] = ((float)localJSONArray.optDouble(i));
          i += 1;
        }
        paramString = paramString.getString("rule");
        if (!TextUtils.isEmpty(paramString))
        {
          this.mRule = new TransferConfig.ParamRule();
          this.mRule.fromJSONObject(paramString);
          return;
        }
        this.mRule = null;
        return;
      }
      this.mRule = null;
      this.mValues = null;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String toJSONObject()
  {
    if (this.mValues == null) {
      return null;
    }
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2;
      if (this.mValues.length > 0)
      {
        localObject2 = new JSONArray();
        int i = 0;
        while (i < this.mValues.length)
        {
          ((JSONArray)localObject2).put(this.mValues[i]);
          i += 1;
        }
        ((JSONObject)localObject1).put("value", localObject2);
      }
      if (this.mRule != null)
      {
        localObject2 = this.mRule.toJSONObject();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("rule", localObject2);
        }
      }
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ExtendParamFloats
 * JD-Core Version:    0.7.0.1
 */