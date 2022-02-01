package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.qphone.base.util.BaseApplication;

public class WatchTogetherSession
  extends TogetherSession
  implements Parcelable
{
  public static final Parcelable.Creator<WatchTogetherSession> CREATOR = new WatchTogetherSession.1();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  protected WatchTogetherSession(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readLong();
  }
  
  public WatchTogetherSession(String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 2;
    this.jdField_f_of_type_Int = 1;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.j == 1) {
      return paramQQAppInterface.getApp().getString(2131699339) + this.b;
    }
    return this.b;
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return paramQQAppInterface.getApp().getString(2131699331);
    }
    return a(paramQQAppInterface, 2131699343, 2131699341, 2131699338);
  }
  
  public int b()
  {
    return 2130844964;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 2131699342, 2131699340);
  }
  
  protected Object clone()
  {
    WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)super.clone();
    localWatchTogetherSession.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localWatchTogetherSession.jdField_f_of_type_Int = this.jdField_f_of_type_Int;
    localWatchTogetherSession.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localWatchTogetherSession.g = this.g;
    localWatchTogetherSession.jdField_h_of_type_Int = this.jdField_h_of_type_Int;
    localWatchTogetherSession.i = this.i;
    localWatchTogetherSession.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localWatchTogetherSession.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
    localWatchTogetherSession.j = this.j;
    localWatchTogetherSession.k = this.k;
    localWatchTogetherSession.jdField_h_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    localWatchTogetherSession.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localWatchTogetherSession.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localWatchTogetherSession.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localWatchTogetherSession.b = this.b;
    localWatchTogetherSession.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localWatchTogetherSession.d = this.d;
    return localWatchTogetherSession;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WatchTogetherSession{roomType=" + this.jdField_a_of_type_Int + ", jumpurl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", roomId=" + this.jdField_a_of_type_Long + ", roomName='" + this.b + '\'' + ", roomCover='" + this.jdField_c_of_type_JavaLangString + '\'' + ", serviceType=" + this.jdField_e_of_type_Int + ", type=" + this.jdField_f_of_type_Int + ", uin='" + this.jdField_e_of_type_JavaLangString + '\'' + ", joinNum=" + this.g + ", status=" + this.jdField_h_of_type_Int + ", userState=" + this.i + ", creator='" + this.jdField_f_of_type_JavaLangString + '\'' + ", timeStamp=" + this.jdField_c_of_type_Long + ", videoType=" + this.j + ", videoJumpType=" + this.k + ", videoJumpURL='" + this.jdField_h_of_type_JavaLangString + '\'' + ", identifyId=" + this.d + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession
 * JD-Core Version:    0.7.0.1
 */