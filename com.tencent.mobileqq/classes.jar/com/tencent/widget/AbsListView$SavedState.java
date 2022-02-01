package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.View.BaseSavedState;

public class AbsListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AbsListView.SavedState.1();
  LongSparseArray<Integer> checkIdState;
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
    int j = paramParcel.readByte();
    int i = 0;
    boolean bool;
    if (j != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.inActionMode = bool;
    this.checkedItemCount = paramParcel.readInt();
    this.checkState = paramParcel.readSparseBooleanArray();
    j = paramParcel.readInt();
    if (j > 0)
    {
      this.checkIdState = new LongSparseArray();
      while (i < j)
      {
        long l = paramParcel.readLong();
        int k = paramParcel.readInt();
        this.checkIdState.put(l, Integer.valueOf(k));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AbsListView.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" selectedId=");
    localStringBuilder.append(this.selectedId);
    localStringBuilder.append(" firstId=");
    localStringBuilder.append(this.firstId);
    localStringBuilder.append(" viewTop=");
    localStringBuilder.append(this.viewTop);
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(" height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.filter);
    localStringBuilder.append(" checkState=");
    localStringBuilder.append(this.checkState);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.selectedId);
    paramParcel.writeLong(this.firstId);
    paramParcel.writeInt(this.viewTop);
    paramParcel.writeInt(this.position);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.filter);
    paramParcel.writeByte((byte)this.inActionMode);
    paramParcel.writeInt(this.checkedItemCount);
    paramParcel.writeSparseBooleanArray(this.checkState);
    LongSparseArray localLongSparseArray = this.checkIdState;
    int i = 0;
    if (localLongSparseArray != null) {
      paramInt = localLongSparseArray.size();
    } else {
      paramInt = 0;
    }
    paramParcel.writeInt(paramInt);
    while (i < paramInt)
    {
      paramParcel.writeLong(this.checkIdState.keyAt(i));
      paramParcel.writeInt(((Integer)this.checkIdState.valueAt(i)).intValue());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.SavedState
 * JD-Core Version:    0.7.0.1
 */