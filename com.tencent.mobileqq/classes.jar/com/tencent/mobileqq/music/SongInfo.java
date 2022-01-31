package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asvx;
import cooperation.qzone.music.BroadcastMusicInfo;

public class SongInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SongInfo> CREATOR = new asvx();
  public int a;
  public long a;
  public BroadcastMusicInfo a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public SongInfo() {}
  
  public SongInfo(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.f = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo = null;
  }
  
  private SongInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo = ((BroadcastMusicInfo)paramParcel.readParcelable(BroadcastMusicInfo.class.getClassLoader()));
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readFloat() != 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      paramParcel.writeFloat(f1);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.SongInfo
 * JD-Core Version:    0.7.0.1
 */