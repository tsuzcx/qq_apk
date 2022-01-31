package com.tencent.qqmini.sdk.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhid;

public class MoreItem
  implements Parcelable
{
  public static final Parcelable.Creator<MoreItem> CREATOR = new bhid();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public MoreItem()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public MoreItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 200);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label60;
      }
    }
    label60:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreItem
 * JD-Core Version:    0.7.0.1
 */