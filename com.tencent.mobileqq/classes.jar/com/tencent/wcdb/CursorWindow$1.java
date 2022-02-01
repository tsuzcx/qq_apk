package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CursorWindow$1
  implements Parcelable.Creator<CursorWindow>
{
  public CursorWindow a(Parcel paramParcel)
  {
    return new CursorWindow(paramParcel, null);
  }
  
  public CursorWindow[] a(int paramInt)
  {
    return new CursorWindow[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow.1
 * JD-Core Version:    0.7.0.1
 */