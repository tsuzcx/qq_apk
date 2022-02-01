package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class Light3DMMData
  implements Parcelable
{
  public static final Parcelable.Creator<Light3DMMData> CREATOR = new Light3DMMData.1();
  List<Light3DMMFeature> light3DMMFeatures;
  
  protected Light3DMMData(Parcel paramParcel)
  {
    this.light3DMMFeatures = paramParcel.createTypedArrayList(Light3DMMFeature.CREATOR);
  }
  
  public Light3DMMData(List<Light3DMMFeature> paramList)
  {
    this.light3DMMFeatures = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<Light3DMMFeature> getLight3dmmFeatures()
  {
    return this.light3DMMFeatures;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.light3DMMFeatures = paramParcel.createTypedArrayList(Light3DMMFeature.CREATOR);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.light3DMMFeatures);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.Light3DMMData
 * JD-Core Version:    0.7.0.1
 */