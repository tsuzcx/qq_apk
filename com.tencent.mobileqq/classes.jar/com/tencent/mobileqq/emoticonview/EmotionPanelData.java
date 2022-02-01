package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EmotionPanelData
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionPanelData> CREATOR = new EmotionPanelData.1();
  
  public EmotionPanelData() {}
  
  protected EmotionPanelData(Parcel paramParcel) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelData
 * JD-Core Version:    0.7.0.1
 */