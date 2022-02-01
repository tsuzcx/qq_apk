package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QidianProfileCardActivity$QidianCompoundProfileItem$1
  implements Parcelable.Creator<QidianProfileCardActivity.QidianCompoundProfileItem>
{
  public QidianProfileCardActivity.QidianCompoundProfileItem a(Parcel paramParcel)
  {
    QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
    localQidianCompoundProfileItem.a = paramParcel.readString();
    localQidianCompoundProfileItem.b = paramParcel.readString();
    localQidianCompoundProfileItem.c = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localQidianCompoundProfileItem.d = bool1;
    localQidianCompoundProfileItem.e = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localQidianCompoundProfileItem.f = bool1;
    localQidianCompoundProfileItem.g = paramParcel.readString();
    localQidianCompoundProfileItem.h = paramParcel.readString();
    return localQidianCompoundProfileItem;
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianCompoundProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem.1
 * JD-Core Version:    0.7.0.1
 */