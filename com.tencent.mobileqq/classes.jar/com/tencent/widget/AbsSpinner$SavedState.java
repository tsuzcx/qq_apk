package com.tencent.widget;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AbsSpinner.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" selectedId=");
    localStringBuilder.append(this.selectedId);
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.selectedId);
    paramParcel.writeInt(this.position);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner.SavedState
 * JD-Core Version:    0.7.0.1
 */