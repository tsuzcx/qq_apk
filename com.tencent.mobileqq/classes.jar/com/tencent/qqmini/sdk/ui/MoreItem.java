package com.tencent.qqmini.sdk.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bffy;

public class MoreItem
  implements Parcelable
{
  public static final Parcelable.Creator<MoreItem> CREATOR = new bffy();
  public int a;
  public String a;
  public boolean a;
  public int b;
  
  public MoreItem()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public MoreItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.b = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.b);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreItem
 * JD-Core Version:    0.7.0.1
 */