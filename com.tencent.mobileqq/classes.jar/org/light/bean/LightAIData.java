package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class LightAIData
  implements Parcelable
{
  public static final Parcelable.Creator<LightAIData> CREATOR = new LightAIData.1();
  List<LightAIClassifier> aiClassifiers;
  String aiDataStr;
  Object aiResult;
  int dataType = 6;
  List<LightAIKeyPoint> lightAIKeyPoints;
  
  public LightAIData() {}
  
  protected LightAIData(Parcel paramParcel)
  {
    this.aiResult = paramParcel.readParcelable(Object.class.getClassLoader());
    this.lightAIKeyPoints = paramParcel.createTypedArrayList(LightAIKeyPoint.CREATOR);
    this.aiClassifiers = paramParcel.createTypedArrayList(LightAIClassifier.CREATOR);
    this.aiDataStr = paramParcel.readString();
    this.aiResult = Integer.valueOf(paramParcel.readInt());
  }
  
  public LightAIData(Object paramObject, List<LightAIKeyPoint> paramList, List<LightAIClassifier> paramList1, String paramString, int paramInt)
  {
    this.aiResult = paramObject;
    this.lightAIKeyPoints = paramList;
    this.aiClassifiers = paramList1;
    this.aiDataStr = paramString;
    this.dataType = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<LightAIClassifier> getAiClassifiers()
  {
    return this.aiClassifiers;
  }
  
  public String getAiDataStr()
  {
    return this.aiDataStr;
  }
  
  public List<LightAIKeyPoint> getAiKeyPoints()
  {
    return this.lightAIKeyPoints;
  }
  
  public Object getAiResult()
  {
    return this.aiResult;
  }
  
  public int getDataType()
  {
    return this.dataType;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.aiResult = paramParcel.readParcelable(Object.class.getClassLoader());
    this.lightAIKeyPoints = paramParcel.createTypedArrayList(LightAIKeyPoint.CREATOR);
    this.aiClassifiers = paramParcel.createTypedArrayList(LightAIClassifier.CREATOR);
    this.aiDataStr = paramParcel.readString();
    this.dataType = paramParcel.readInt();
  }
  
  public void setAiClassifiers(List<LightAIClassifier> paramList)
  {
    this.aiClassifiers = paramList;
  }
  
  public void setAiDataStr(String paramString)
  {
    this.aiDataStr = paramString;
  }
  
  public void setAiResult(Object paramObject)
  {
    this.aiResult = paramObject;
  }
  
  public void setDataType(int paramInt)
  {
    this.dataType = paramInt;
  }
  
  public void setLightAIKeyPoints(List<LightAIKeyPoint> paramList)
  {
    this.lightAIKeyPoints = paramList;
  }
  
  public String toString()
  {
    if (this.dataType == 2) {
      return this.aiDataStr;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightAIData{aiResult=");
    localStringBuilder.append(this.aiResult);
    localStringBuilder.append(", lightAIKeyPoints=");
    localStringBuilder.append(this.lightAIKeyPoints);
    localStringBuilder.append(", aiClassifiers=");
    localStringBuilder.append(this.aiClassifiers);
    localStringBuilder.append(", aiDataStr='");
    localStringBuilder.append(this.aiDataStr);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dataType=");
    localStringBuilder.append(this.dataType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable((Parcelable)this.aiResult, paramInt);
    paramParcel.writeTypedList(this.lightAIKeyPoints);
    paramParcel.writeTypedList(this.aiClassifiers);
    paramParcel.writeString(this.aiDataStr);
    paramParcel.writeInt(this.dataType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightAIData
 * JD-Core Version:    0.7.0.1
 */