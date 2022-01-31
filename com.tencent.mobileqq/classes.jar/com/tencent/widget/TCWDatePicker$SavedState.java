package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import bfwl;

public class TCWDatePicker$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new bfwl();
  private final int a;
  private final int b;
  private final int c;
  
  private TCWDatePicker$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  private TCWDatePicker$SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParcelable);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.TCWDatePicker.SavedState
 * JD-Core Version:    0.7.0.1
 */