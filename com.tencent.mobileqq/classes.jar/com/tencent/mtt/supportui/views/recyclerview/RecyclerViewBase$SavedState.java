package com.tencent.mtt.supportui.views.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class RecyclerViewBase$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new RecyclerViewBase.SavedState.1();
  Parcelable mLayoutState;
  
  RecyclerViewBase$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mLayoutState = paramParcel.readParcelable(RecyclerViewBase.LayoutManager.class.getClassLoader());
  }
  
  RecyclerViewBase$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  void copyFrom(SavedState paramSavedState)
  {
    this.mLayoutState = paramSavedState.mLayoutState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mLayoutState, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SavedState
 * JD-Core Version:    0.7.0.1
 */