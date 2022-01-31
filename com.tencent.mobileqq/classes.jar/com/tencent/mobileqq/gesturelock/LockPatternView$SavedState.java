package com.tencent.mobileqq.gesturelock;

import android.os.Parcel;
import android.view.View.BaseSavedState;

class LockPatternView$SavedState
  extends View.BaseSavedState
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeValue(Boolean.valueOf(this.jdField_a_of_type_Boolean));
    paramParcel.writeValue(Boolean.valueOf(this.b));
    paramParcel.writeValue(Boolean.valueOf(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView.SavedState
 * JD-Core Version:    0.7.0.1
 */