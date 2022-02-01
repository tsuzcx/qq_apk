package com.tencent.tkd.comment.panel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EmotionTab
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionTab> CREATOR = new EmotionTab.1();
  public int a;
  public int b;
  
  public EmotionTab() {}
  
  protected EmotionTab(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.model.EmotionTab
 * JD-Core Version:    0.7.0.1
 */