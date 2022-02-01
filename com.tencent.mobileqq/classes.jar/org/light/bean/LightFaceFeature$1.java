package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LightFaceFeature$1
  implements Parcelable.Creator<LightFaceFeature>
{
  public LightFaceFeature createFromParcel(Parcel paramParcel)
  {
    return new LightFaceFeature(paramParcel);
  }
  
  public LightFaceFeature[] newArray(int paramInt)
  {
    return new LightFaceFeature[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightFaceFeature.1
 * JD-Core Version:    0.7.0.1
 */