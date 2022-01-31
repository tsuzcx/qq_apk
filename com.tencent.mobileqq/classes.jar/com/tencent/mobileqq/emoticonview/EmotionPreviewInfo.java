package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apst;

public class EmotionPreviewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionPreviewInfo> CREATOR = new apst();
  public String a;
  public boolean a;
  
  public EmotionPreviewInfo() {}
  
  public EmotionPreviewInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" path: ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewInfo
 * JD-Core Version:    0.7.0.1
 */