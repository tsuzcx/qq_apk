package com.tencent.mobileqq.dinifly;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class DiniFlyAnimationView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new DiniFlyAnimationView.SavedState.1();
  String animationName;
  int animationResId;
  String imageAssetsFolder;
  boolean isAnimating;
  float progress;
  int repeatCount;
  int repeatMode;
  
  private DiniFlyAnimationView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.animationName = paramParcel.readString();
    this.progress = paramParcel.readFloat();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isAnimating = bool;
      this.imageAssetsFolder = paramParcel.readString();
      this.repeatMode = paramParcel.readInt();
      this.repeatCount = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  DiniFlyAnimationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.animationName);
    paramParcel.writeFloat(this.progress);
    if (this.isAnimating) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.imageAssetsFolder);
      paramParcel.writeInt(this.repeatMode);
      paramParcel.writeInt(this.repeatCount);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView.SavedState
 * JD-Core Version:    0.7.0.1
 */