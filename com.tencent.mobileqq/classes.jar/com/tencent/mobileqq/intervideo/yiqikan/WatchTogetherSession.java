package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import atgf;
import bapt;
import bapu;
import com.tencent.mobileqq.app.QQAppInterface;

public class WatchTogetherSession
  extends bapt
  implements Parcelable
{
  public static final Parcelable.Creator<WatchTogetherSession> CREATOR = new atgf();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  public WatchTogetherSession(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
  }
  
  public WatchTogetherSession(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 2;
    this.jdField_e_of_type_Int = 1;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.i == 1) {
      return "[直播间] " + this.b;
    }
    return this.b;
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return "收起";
    }
    return b(paramQQAppInterface);
  }
  
  public int b()
  {
    return 2130844447;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    String str = "";
    if (this.g != 3)
    {
      if (this.jdField_f_of_type_Int != 0) {
        break label90;
      }
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        break label84;
      }
      paramQQAppInterface = a(paramQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break label78;
      }
      paramQQAppInterface = bapu.a(16, paramQQAppInterface);
    }
    for (;;)
    {
      str = paramQQAppInterface + "发起一起看";
      return str;
      label78:
      paramQQAppInterface = "群友";
      continue;
      label84:
      paramQQAppInterface = "群友";
    }
    label90:
    if (this.jdField_f_of_type_Int == 1) {
      return "1人正在看";
    }
    return this.jdField_f_of_type_Int + "人正在一起看";
  }
  
  protected Object clone()
  {
    WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)super.clone();
    localWatchTogetherSession.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
    localWatchTogetherSession.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localWatchTogetherSession.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localWatchTogetherSession.jdField_f_of_type_Int = this.jdField_f_of_type_Int;
    localWatchTogetherSession.g = this.g;
    localWatchTogetherSession.jdField_h_of_type_Int = this.jdField_h_of_type_Int;
    localWatchTogetherSession.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localWatchTogetherSession.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
    localWatchTogetherSession.i = this.i;
    localWatchTogetherSession.j = this.j;
    localWatchTogetherSession.jdField_h_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    localWatchTogetherSession.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localWatchTogetherSession.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localWatchTogetherSession.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localWatchTogetherSession.b = this.b;
    localWatchTogetherSession.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localWatchTogetherSession.jdField_d_of_type_Long = this.jdField_d_of_type_Long;
    return localWatchTogetherSession;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WatchTogetherSession{roomType=" + this.jdField_a_of_type_Int + ", jumpurl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", roomId=" + this.jdField_a_of_type_Long + ", roomName='" + this.b + '\'' + ", roomCover='" + this.jdField_c_of_type_JavaLangString + '\'' + ", serviceType=" + this.jdField_d_of_type_Int + ", type=" + this.jdField_e_of_type_Int + ", uin='" + this.jdField_e_of_type_JavaLangString + '\'' + ", joinNum=" + this.jdField_f_of_type_Int + ", status=" + this.g + ", userState=" + this.jdField_h_of_type_Int + ", creator='" + this.jdField_f_of_type_JavaLangString + '\'' + ", timeStamp=" + this.jdField_c_of_type_Long + ", videoType=" + this.i + ", videoJumpType=" + this.j + ", videoJumpURL='" + this.jdField_h_of_type_JavaLangString + '\'' + ", identifyId=" + this.jdField_d_of_type_Long + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession
 * JD-Core Version:    0.7.0.1
 */