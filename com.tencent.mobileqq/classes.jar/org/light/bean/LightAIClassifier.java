package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class LightAIClassifier
  implements Parcelable
{
  public static final Parcelable.Creator<LightAIClassifier> CREATOR = new LightAIClassifier.1();
  List<String> classifiers;
  int traceId;
  
  public LightAIClassifier(int paramInt, List<String> paramList)
  {
    this.traceId = paramInt;
    this.classifiers = paramList;
  }
  
  protected LightAIClassifier(Parcel paramParcel)
  {
    this.traceId = paramParcel.readInt();
    this.classifiers = paramParcel.createStringArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<String> getClassifiers()
  {
    return this.classifiers;
  }
  
  public int getTraceId()
  {
    return this.traceId;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.traceId = paramParcel.readInt();
    this.classifiers = paramParcel.createStringArrayList();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.traceId);
    paramParcel.writeStringList(this.classifiers);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightAIClassifier
 * JD-Core Version:    0.7.0.1
 */