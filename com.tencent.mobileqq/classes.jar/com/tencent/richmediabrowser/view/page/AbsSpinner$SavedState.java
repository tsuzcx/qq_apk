package com.tencent.richmediabrowser.view.page;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AbsSpinner$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AbsSpinner.SavedState.1();
  int position;
  long selectedId;
  
  private AbsSpinner$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.selectedId = paramParcel.readLong();
    this.position = paramParcel.readInt();
  }
  
  AbsSpinner$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.selectedId);
    paramParcel.writeInt(this.position);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.AbsSpinner.SavedState
 * JD-Core Version:    0.7.0.1
 */