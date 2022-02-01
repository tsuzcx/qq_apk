package com.tencent.mobileqq.comment;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DanmuItemBean$1
  implements Parcelable.Creator<DanmuItemBean>
{
  public DanmuItemBean a(Parcel paramParcel)
  {
    boolean bool = true;
    DanmuItemBean localDanmuItemBean = new DanmuItemBean();
    localDanmuItemBean.jdField_a_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.jdField_b_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.d = paramParcel.readLong();
    localDanmuItemBean.jdField_c_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localDanmuItemBean.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localDanmuItemBean.jdField_a_of_type_Boolean = bool;
      localDanmuItemBean.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localDanmuItemBean.jdField_a_of_type_Int = paramParcel.readInt();
      return localDanmuItemBean;
      bool = false;
    }
  }
  
  public DanmuItemBean[] a(int paramInt)
  {
    return new DanmuItemBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuItemBean.1
 * JD-Core Version:    0.7.0.1
 */