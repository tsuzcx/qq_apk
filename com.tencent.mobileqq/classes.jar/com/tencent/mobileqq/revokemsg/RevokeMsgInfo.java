package com.tencent.mobileqq.revokemsg;

import agsf;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RevokeMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new agsf();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public RevokeMsgInfo() {}
  
  public RevokeMsgInfo(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_Int = paramMessageRecord.istroop;
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    this.jdField_a_of_type_Long = paramMessageRecord.shmsgseq;
    this.jdField_b_of_type_Long = paramMessageRecord.msgUid;
    this.jdField_c_of_type_Long = paramMessageRecord.time;
    this.jdField_c_of_type_JavaLangString = paramMessageRecord.senderuin;
    this.jdField_b_of_type_Int = paramMessageRecord.longMsgId;
    this.jdField_c_of_type_Int = paramMessageRecord.longMsgCount;
    this.jdField_d_of_type_Int = paramMessageRecord.longMsgIndex;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("RevokeMsgInfo[istroop= %d, shmsgseq= %d, frienduin= %s, fromuin= %s msguid= %d, time= %d, senduin= %s, longmsgid= %d, longmsgcount=%d longmsgindex=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long), this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeInt(this.e);
      return;
    }
    catch (Exception paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("revokeMsg", 2, "revokeMsgInfo writeToParcel failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.revokemsg.RevokeMsgInfo
 * JD-Core Version:    0.7.0.1
 */