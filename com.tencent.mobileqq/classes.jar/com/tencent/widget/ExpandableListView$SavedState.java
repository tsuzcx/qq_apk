package com.tencent.widget;

import ambm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import java.util.ArrayList;

public class ExpandableListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new ambm();
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private ExpandableListView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_AndroidOsParcelable = paramParcel.readParcelable(getClass().getClassLoader());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, ExpandableListConnector.class.getClassLoader());
  }
  
  ExpandableListView$SavedState(Parcelable paramParcelable, ArrayList paramArrayList)
  {
    super(EMPTY_STATE);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidOsParcelable = paramParcelable;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidOsParcelable, paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView.SavedState
 * JD-Core Version:    0.7.0.1
 */