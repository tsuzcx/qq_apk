package com.tencent.mobileqq.gesturelock;

import android.os.Parcel;
import android.view.View.BaseSavedState;

class LockPatternView$SavedState
  extends View.BaseSavedState
{
  private final String a;
  private final int b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeValue(Boolean.valueOf(this.c));
    paramParcel.writeValue(Boolean.valueOf(this.d));
    paramParcel.writeValue(Boolean.valueOf(this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView.SavedState
 * JD-Core Version:    0.7.0.1
 */