package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class LightAIDataWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<LightAIDataWrapper> CREATOR = new LightAIDataWrapper.1();
  public static final int DATA_TYPE_BOTH = 6;
  public static final int DATA_TYPE_NONE = 0;
  public static final int DATA_TYPE_OBJ = 4;
  public static final int DATA_TYPE_STR = 2;
  HashMap<String, LightAIData> aiDataMap;
  
  public LightAIDataWrapper()
  {
    this.aiDataMap = new HashMap();
  }
  
  protected LightAIDataWrapper(Parcel paramParcel)
  {
    this.aiDataMap = ((HashMap)paramParcel.readSerializable());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LightAIData getAIData(String paramString)
  {
    return (LightAIData)this.aiDataMap.get(paramString);
  }
  
  public HashMap<String, LightAIData> getAiDataMap()
  {
    return this.aiDataMap;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.aiDataMap = ((HashMap)paramParcel.readSerializable());
  }
  
  public void setAIData(String paramString, LightAIData paramLightAIData)
  {
    this.aiDataMap.put(paramString, paramLightAIData);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.aiDataMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightAIDataWrapper
 * JD-Core Version:    0.7.0.1
 */