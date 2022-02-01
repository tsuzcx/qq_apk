package com.tencent.mobileqq.multiaio.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.AbsSavedState;
import axff;

public class MultiAIOBaseViewPager$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new axff();
  int jdField_a_of_type_Int;
  Parcelable jdField_a_of_type_AndroidOsParcelable;
  ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public MultiAIOBaseViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidOsParcelable = paramParcel.readParcelable(localClassLoader);
    this.jdField_a_of_type_JavaLangClassLoader = localClassLoader;
  }
  
  public MultiAIOBaseViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.jdField_a_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidOsParcelable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SavedState
 * JD-Core Version:    0.7.0.1
 */