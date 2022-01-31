package com.tencent.widget;

import amhl;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import android.view.View.BaseSavedState;
import com.tencent.util.LongSparseArray;

public class AbsListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new amhl();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public int b;
  long b;
  int c;
  int d;
  
  private AbsListView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.d = paramParcel.readInt();
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray = paramParcel.readSparseBooleanArray();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
      while (i < j)
      {
        long l = paramParcel.readLong();
        int k = paramParcel.readInt();
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l, Integer.valueOf(k));
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
    return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.jdField_a_of_type_Long + " firstId=" + this.jdField_b_of_type_Long + " viewTop=" + this.jdField_a_of_type_Int + " position=" + this.jdField_b_of_type_Int + " height=" + this.c + " filter=" + this.jdField_a_of_type_JavaLangString + " checkState=" + this.jdField_a_of_type_AndroidUtilSparseBooleanArray + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.d);
      paramParcel.writeSparseBooleanArray(this.jdField_a_of_type_AndroidUtilSparseBooleanArray);
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) {
        break label154;
      }
    }
    label154:
    for (paramInt = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      while (i < paramInt)
      {
        paramParcel.writeLong(this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i));
        paramParcel.writeInt(((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i)).intValue());
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