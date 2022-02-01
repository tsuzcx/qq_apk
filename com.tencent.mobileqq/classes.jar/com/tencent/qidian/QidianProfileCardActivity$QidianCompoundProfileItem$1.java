package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QidianProfileCardActivity$QidianCompoundProfileItem$1
  implements Parcelable.Creator<QidianProfileCardActivity.QidianCompoundProfileItem>
{
  public QidianProfileCardActivity.QidianCompoundProfileItem a(Parcel paramParcel)
  {
    QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
    localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.c = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool1;
    localQidianCompoundProfileItem.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localQidianCompoundProfileItem.jdField_b_of_type_Boolean = bool1;
    localQidianCompoundProfileItem.d = paramParcel.readString();
    localQidianCompoundProfileItem.e = paramParcel.readString();
    return localQidianCompoundProfileItem;
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianCompoundProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem.1
 * JD-Core Version:    0.7.0.1
 */