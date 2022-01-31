package com.tencent.theme;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SkinnableColorStateList$1
  implements Parcelable.Creator<ColorStateList>
{
  public ColorStateList a(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int[][] arrayOfInt = new int[j][];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramParcel.createIntArray();
      i += 1;
    }
    return new ColorStateList(arrayOfInt, paramParcel.createIntArray());
  }
  
  public ColorStateList[] a(int paramInt)
  {
    return new ColorStateList[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableColorStateList.1
 * JD-Core Version:    0.7.0.1
 */