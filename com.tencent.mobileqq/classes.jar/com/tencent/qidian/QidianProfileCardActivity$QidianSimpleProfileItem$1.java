package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QidianProfileCardActivity$QidianSimpleProfileItem$1
  implements Parcelable.Creator<QidianProfileCardActivity.QidianSimpleProfileItem>
{
  public QidianProfileCardActivity.QidianSimpleProfileItem a(Parcel paramParcel)
  {
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.a = paramParcel.readString();
    localQidianSimpleProfileItem.b = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localQidianSimpleProfileItem.c = bool1;
    localQidianSimpleProfileItem.d = paramParcel.readInt();
    localQidianSimpleProfileItem.e = paramParcel.readInt();
    localQidianSimpleProfileItem.f = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localQidianSimpleProfileItem.g = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localQidianSimpleProfileItem.h = bool1;
    localQidianSimpleProfileItem.i = paramParcel.readInt();
    return localQidianSimpleProfileItem;
  }
  
  public QidianProfileCardActivity.QidianSimpleProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianSimpleProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem.1
 * JD-Core Version:    0.7.0.1
 */