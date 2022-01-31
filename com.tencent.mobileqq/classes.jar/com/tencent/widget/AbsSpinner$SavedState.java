package com.tencent.widget;

import alkp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class AbsSpinner$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new alkp();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  
  private AbsSpinner$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  AbsSpinner$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.jdField_a_of_type_Long + " position=" + this.jdField_a_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner.SavedState
 * JD-Core Version:    0.7.0.1
 */