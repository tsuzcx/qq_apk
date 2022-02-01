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
    if (this.j == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getApp().getString(2131699444));
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
    return this.b;
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return paramQQAppInterface.getApp().getString(2131699436);
    }
    return a(paramQQAppInterface, 2131699448, 2131699446, 2131699443);
  }
  
  public int b()
  {
    return 2130844840;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 2131699447, 2131699445);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherSession{roomType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", jumpurl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", roomName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomCover='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceType=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinNum=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", videoJumpType=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", videoJumpURL='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", identifyId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession
 * JD-Core Version:    0.7.0.1
 */