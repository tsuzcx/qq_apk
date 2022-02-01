package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import android.view.View.BaseSavedState;
import bkyb;

public class AbsListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AbsListView.SavedState.1();
  bkyb<Integer> checkIdState;
  SparseBooleanArray checkState;
  int checkedItemCount;
  String filter;
  long firstId;
  int height;
  boolean inActionMode;
  public int position;
  long selectedId = -1L;
  int viewTop;
  
  private AbsListView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.selectedId = paramParcel.readLong();
    this.firstId = paramParcel.readLong();
    this.viewTop = paramParcel.readInt();
    this.position = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.filter = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.inActionMode = bool;
      this.checkedItemCount = paramParcel.readInt();
      this.checkState = paramParcel.readSparseBooleanArray();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.checkIdState = new bkyb();
      while (i < j)
      {
        long l = paramParcel.readLong();
        int k = paramParcel.readInt();
        this.checkIdState.a(l, Integer.valueOf(k));
        i += 1;
      }
    }
  }
  
  AbsListView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewTop=" + this.viewTop + " position=" + this.position + " height=" + this.height + " filter=" + this.filter + " checkState=" + this.checkState + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.selectedId);
    paramParcel.writeLong(this.firstId);
    paramParcel.writeInt(this.viewTop);
    paramParcel.writeInt(this.position);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.filter);
    if (this.inActionMode)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.checkedItemCount);
      paramParcel.writeSparseBooleanArray(this.checkState);
      if (this.checkIdState == null) {
        break label154;
      }
    }
    label154:
    for (paramInt = this.checkIdState.a();; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      while (i < paramInt)
      {
        paramParcel.writeLong(this.checkIdState.a(i));
        paramParcel.writeInt(((Integer)this.checkIdState.a(i)).intValue());
        i += 1;
      }
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.SavedState
 * JD-Core Version:    0.7.0.1
 */