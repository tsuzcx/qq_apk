package com.tencent.mtt.abtestsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RomaExpEntity
  implements Parcelable
{
  public static final Parcelable.Creator<RomaExpEntity> CREATOR = new RomaExpEntity.1();
  public static final String KEY_EXPERIMENTS_ASSIGNMENT = "assignment";
  public static final String KEY_EXPERIMENTS_BUCKET = "bucket";
  public static final String KEY_EXPERIMENTS_ENDTIME = "endTime";
  public static final String KEY_EXPERIMENTS_GRAY_ID = "sGrayPolicyId";
  public static final String KEY_EXPERIMENTS_NAME = "expName";
  public static final String KEY_EXPERIMENTS_PARAMS = "params";
  public static final String KEY_EXPERIMENTS_PERCENTAGE = "percentage";
  private String assignment = "default";
  private String bucket = "0";
  private String endTime;
  private String expName;
  private String grayId = "-1";
  private String layerCode = "default";
  private Map<String, String> params = new HashMap();
  private String percentage = "0";
  
  protected RomaExpEntity(Parcel paramParcel)
  {
    this.grayId = paramParcel.readString();
    this.bucket = paramParcel.readString();
    this.percentage = paramParcel.readString();
    this.assignment = paramParcel.readString();
    this.layerCode = paramParcel.readString();
    this.expName = paramParcel.readString();
    this.endTime = paramParcel.readString();
    paramParcel.readMap(this.params, getClass().getClassLoader());
  }
  
  public RomaExpEntity(String paramString)
  {
    this.expName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RomaExpEntity)))
    {
      paramObject = (RomaExpEntity)paramObject;
      if (this.grayId == null) {
        return false;
      }
      return paramObject.grayId.equals(this.grayId);
    }
    return super.equals(paramObject);
  }
  
  public String getAssignment()
  {
    return this.assignment;
  }
  
  public String getBucket()
  {
    return this.bucket;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getExpName()
  {
    return this.expName;
  }
  
  public String getGrayId()
  {
    return this.grayId;
  }
  
  public String getLayerCode()
  {
    return this.layerCode;
  }
  
  public Map<String, String> getParams()
  {
    return this.params;
  }
  
  public String getPercentage()
  {
    return this.percentage;
  }
  
  public boolean isDefaultRomaExp()
  {
    return (TextUtils.equals("-1", this.grayId)) && (TextUtils.equals("default", this.assignment)) && (TextUtils.equals("default", this.layerCode));
  }
  
  public void readJson(JSONObject paramJSONObject)
  {
    try
    {
      this.grayId = paramJSONObject.getString("sGrayPolicyId");
      this.bucket = paramJSONObject.getString("bucket");
      this.percentage = paramJSONObject.getString("percentage");
      this.assignment = paramJSONObject.getString("assignment");
      this.endTime = paramJSONObject.getString("endTime");
      this.expName = paramJSONObject.getString("expName");
      paramJSONObject = paramJSONObject.getJSONObject("params");
      this.params.clear();
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramJSONObject.getString(str1);
          this.params.put(str1, str2);
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void setAssignment(String paramString)
  {
    this.assignment = paramString;
  }
  
  public void setBucket(String paramString)
  {
    this.bucket = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setExpName(String paramString)
  {
    this.expName = paramString;
  }
  
  public void setGrayId(String paramString)
  {
    this.grayId = paramString;
  }
  
  public void setLayerCode(String paramString)
  {
    this.layerCode = paramString;
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    this.params = paramMap;
  }
  
  public void setPercentage(String paramString)
  {
    this.percentage = paramString;
  }
  
  public String toString()
  {
    return "layerCode:" + this.layerCode + "  assignment:" + this.assignment + " sGrayPolicyId:" + this.grayId + " bucket:" + this.bucket + " percentage:" + this.percentage + " endTime:" + this.endTime + " expName:" + this.expName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.grayId);
    paramParcel.writeString(this.bucket);
    paramParcel.writeString(this.percentage);
    paramParcel.writeString(this.assignment);
    paramParcel.writeString(this.layerCode);
    paramParcel.writeString(this.expName);
    paramParcel.writeString(this.endTime);
    paramParcel.writeMap(this.params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.RomaExpEntity
 * JD-Core Version:    0.7.0.1
 */