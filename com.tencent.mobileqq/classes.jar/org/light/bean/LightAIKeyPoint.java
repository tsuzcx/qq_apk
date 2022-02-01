package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LightAIKeyPoint
  implements Parcelable
{
  public static final Parcelable.Creator<LightAIKeyPoint> CREATOR = new LightAIKeyPoint.1();
  float[] aiPoints = new float[80];
  int traceId;
  
  public LightAIKeyPoint(int paramInt, float[] paramArrayOfFloat)
  {
    this.traceId = paramInt;
    this.aiPoints = paramArrayOfFloat;
  }
  
  protected LightAIKeyPoint(Parcel paramParcel)
  {
    this.traceId = paramParcel.readInt();
    this.aiPoints = paramParcel.createFloatArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float[] getAiPoints()
  {
    return this.aiPoints;
  }
  
  public int getTraceId()
  {
    return this.traceId;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.traceId = paramParcel.readInt();
    this.aiPoints = paramParcel.createFloatArray();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.traceId);
    paramParcel.writeFloatArray(this.aiPoints);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightAIKeyPoint
 * JD-Core Version:    0.7.0.1
 */