package com.tencent.mobileqq.comment;

import amle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbbd;
import com.tencent.qphone.base.util.QLog;

public class DanmuItemBean
  implements Parcelable
{
  public static final Parcelable.Creator<DanmuItemBean> CREATOR = new amle();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  
  public DanmuItemBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public DanmuItemBean(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.d = paramLong3;
    this.jdField_c_of_type_Long = paramLong4;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DanmuItemBean{commentUin=" + this.jdField_a_of_type_Long + ", commentSeq=" + this.jdField_b_of_type_Long + ", createTime=" + this.d + ", location=" + this.jdField_c_of_type_Long + ", content=" + bbbd.a(this.jdField_a_of_type_JavaLangString) + ", nickName='" + this.jdField_b_of_type_JavaLangString + ", createTime=" + this.d + ", anonymousFlag=" + this.jdField_a_of_type_Boolean + ", anonymousNick=" + this.jdField_c_of_type_JavaLangString + ", anonymousHeadPortrait=" + this.jdField_a_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.d);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
        paramParcel.writeInt(this.jdField_a_of_type_Int);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      QLog.d("DanmuItemBean", 1, "writeToParcel failed, ", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuItemBean
 * JD-Core Version:    0.7.0.1
 */