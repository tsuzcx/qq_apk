package com.tencent.mtt.supportui.views.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class BaseLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new BaseLayoutManager.SavedState.1();
  boolean mAnchorLayoutFromEnd;
  int mAnchorOffset;
  int mAnchorPosition;
  int mOrientation;
  boolean mReverseLayout;
  boolean mStackFromEnd;
  
  public BaseLayoutManager$SavedState() {}
  
  BaseLayoutManager$SavedState(Parcel paramParcel)
  {
    this.mOrientation = paramParcel.readInt();
    this.mAnchorPosition = paramParcel.readInt();
    this.mAnchorOffset = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.mReverseLayout = bool1;
      if (paramParcel.readInt() != 1) {
        break label81;
      }
      bool1 = true;
      label55:
      this.mStackFromEnd = bool1;
      if (paramParcel.readInt() != 1) {
        break label86;
      }
    }
    label81:
    label86:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mAnchorLayoutFromEnd = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label55;
    }
  }
  
  public BaseLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.mOrientation = paramSavedState.mOrientation;
    this.mAnchorPosition = paramSavedState.mAnchorPosition;
    this.mAnchorOffset = paramSavedState.mAnchorOffset;
    this.mReverseLayout = paramSavedState.mReverseLayout;
    this.mStackFromEnd = paramSavedState.mStackFromEnd;
    this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mOrientation);
    paramParcel.writeInt(this.mAnchorPosition);
    paramParcel.writeInt(this.mAnchorOffset);
    if (this.mReverseLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.mStackFromEnd) {
        break label74;
      }
      paramInt = 1;
      label49:
      paramParcel.writeInt(paramInt);
      if (!this.mAnchorLayoutFromEnd) {
        break label79;
      }
    }
    label74:
    label79:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */