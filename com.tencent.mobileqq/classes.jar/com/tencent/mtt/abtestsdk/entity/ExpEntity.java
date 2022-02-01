package com.tencent.mtt.abtestsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpEntity
  implements Parcelable
{
  public static final Parcelable.Creator<ExpEntity> CREATOR = new ExpEntity.1();
  public static final String KEY_EXPERIMENTS_ASSIGNMENT = "assignment";
  public static final String KEY_EXPERIMENTS_BUCKET = "bucket";
  public static final String KEY_EXPERIMENTS_ENDTIME = "endTime";
  public static final String KEY_EXPERIMENTS_GRAY_ID = "sGrayPolicyId";
  public static final String KEY_EXPERIMENTS_NAME = "expName";
  public static final String KEY_EXPERIMENTS_PARAMS = "params";
  public static final String KEY_EXPERIMENTS_PERCENTAGE = "percentage";
  private String assignment = "default";
  private String bucket = "0";
  private String endTime = "";
  private String expName = "";
  private String grayId = "-1";
  private String layerCode = "default";
  private Map<String, String> params = new HashMap();
  private String percentage = "0";
  
  protected ExpEntity(Parcel paramParcel)
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
  
  public ExpEntity(String paramString)
  {
    this.expName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ExpEntity))
    {
      paramObject = (ExpEntity)paramObject;
      if (TextUtils.isEmpty(this.grayId)) {
        return false;
      }
      return this.grayId.equals(paramObject.grayId);
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
  
  @RequiresApi(api=19)
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.grayId, this.bucket, this.percentage, this.assignment, this.layerCode, this.expName, this.endTime, this.params });
  }
  
  public boolean isDefaultRomaExp()
  {
    return (TextUtils.equals("-1", this.grayId)) && (TextUtils.equals("default", this.assignment)) && (TextUtils.equals("default", this.layerCode));
  }
  
  public void readJson(JSONObject paramJSONObject)
  {
    try
    {
      this.grayId = paramJSONObject.optString("sGrayPolicyId");
      this.bucket = paramJSONObject.optString("bucket");
      this.percentage = paramJSONObject.optString("percentage");
      this.assignment = paramJSONObject.optString("assignment");
      this.expName = paramJSONObject.optString("expName");
      this.endTime = paramJSONObject.optString("endTime");
      paramJSONObject = paramJSONObject.optJSONObject("params");
      this.params.clear();
      Object localObject;
      if (paramJSONObject != null)
      {
        localObject = paramJSONObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = paramJSONObject.getString(str1);
          this.params.put(str1, str2);
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid exp data json format: ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      ABTestLog.error(((StringBuilder)localObject).toString(), new Object[0]);
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerCode:");
    localStringBuilder.append(this.layerCode);
    localStringBuilder.append("  assignment:");
    localStringBuilder.append(this.assignment);
    localStringBuilder.append(" sGrayPolicyId:");
    localStringBuilder.append(this.grayId);
    localStringBuilder.append(" bucket:");
    localStringBuilder.append(this.bucket);
    localStringBuilder.append(" percentage:");
    localStringBuilder.append(this.percentage);
    localStringBuilder.append(" endTime:");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(" expName:");
    localStringBuilder.append(this.expName);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ExpEntity
 * JD-Core Version:    0.7.0.1
 */