package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LightAIKeyPoint$1
  implements Parcelable.Creator<LightAIKeyPoint>
{
  public LightAIKeyPoint createFromParcel(Parcel paramParcel)
  {
    return new LightAIKeyPoint(paramParcel);
  }
  
  public LightAIKeyPoint[] newArray(int paramInt)
  {
    return new LightAIKeyPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightAIKeyPoint.1
 * JD-Core Version:    0.7.0.1
 */