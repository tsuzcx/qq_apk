package com.tencent.mtt.abtestsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class FeatureEntity
  implements Parcelable
{
  public static final Parcelable.Creator<FeatureEntity> CREATOR = new FeatureEntity.1();
  public static final String KEY_FEATURE_GRAY_ID = "feature_policy_id";
  public static final String KEY_FEATURE_KEY = "feature_key";
  public static final String KEY_FEATURE_LIEF_TYPE = "life_type";
  public static final String KEY_FEATURE_PARAMS = "params";
  public static final String KEY_FEATURE_STATUS = "status";
  private String featureId = "-1";
  private String featureKey = "default";
  private String featureLifeType = "1";
  private Map<String, String> featureParams = new HashMap();
  private String featureStatus = "0";
  
  public FeatureEntity() {}
  
  protected FeatureEntity(Parcel paramParcel)
  {
    this.featureId = paramParcel.readString();
    this.featureKey = paramParcel.readString();
    this.featureStatus = paramParcel.readString();
    this.featureLifeType = paramParcel.readString();
    paramParcel.readMap(this.featureParams, getClass().getClassLoader());
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
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FeatureEntity)paramObject;
      return (this.featureId.equals(paramObject.featureId)) && (this.featureKey.equals(paramObject.featureKey)) && (this.featureStatus.equals(paramObject.featureStatus)) && (this.featureLifeType.equals(paramObject.featureLifeType)) && (this.featureParams.equals(paramObject.featureParams));
    }
    return false;
  }
  
  public String getFeatureId()
  {
    return this.featureId;
  }
  
  public String getFeatureKey()
  {
    return this.featureKey;
  }
  
  public String getFeatureLifeType()
  {
    return this.featureLifeType;
  }
  
  public Map<String, String> getFeatureParams()
  {
    return this.featureParams;
  }
  
  public String getFeatureStatus()
  {
    return this.featureStatus;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.featureId, this.featureKey, this.featureStatus, this.featureLifeType, this.featureParams });
  }
  
  public boolean isEmpty()
  {
    return ("-1".equals(this.featureId)) && ("default".equals(this.featureKey)) && ("1".equals(this.featureLifeType)) && ("0".equals(this.featureStatus));
  }
  
  public void readFeatureJson(JSONObject paramJSONObject)
  {
    this.featureId = paramJSONObject.optString("feature_policy_id");
    this.featureKey = paramJSONObject.optString("feature_key");
    this.featureStatus = paramJSONObject.optString("status");
    this.featureLifeType = paramJSONObject.optString("life_type");
    paramJSONObject = paramJSONObject.optJSONObject("params");
    this.featureParams.clear();
    if ((paramJSONObject != null) && (paramJSONObject.keys() != null))
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.optString(str1);
        this.featureParams.put(str1, str2);
      }
    }
  }
  
  public void setFeatureId(String paramString)
  {
    this.featureId = paramString;
  }
  
  public void setFeatureKey(String paramString)
  {
    this.featureKey = paramString;
  }
  
  public void setFeatureLifeType(String paramString)
  {
    this.featureLifeType = paramString;
  }
  
  public void setFeatureParams(Map<String, String> paramMap)
  {
    this.featureParams = paramMap;
  }
  
  public void setFeatureStatus(String paramString)
  {
    this.featureStatus = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeatureEntity{featureId='");
    localStringBuilder.append(this.featureId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", featureKey='");
    localStringBuilder.append(this.featureKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", featureStatus='");
    localStringBuilder.append(this.featureStatus);
    localStringBuilder.append('\'');
    localStringBuilder.append(", featureLifeType='");
    localStringBuilder.append(this.featureLifeType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", featureParams=");
    localStringBuilder.append(this.featureParams);
    localStringBuilder.append('}');
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.featureId);
    paramParcel.writeString(this.featureKey);
    paramParcel.writeString(this.featureStatus);
    paramParcel.writeString(this.featureLifeType);
    paramParcel.writeMap(this.featureParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.FeatureEntity
 * JD-Core Version:    0.7.0.1
 */