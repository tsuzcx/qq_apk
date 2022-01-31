package com.tencent.mobileqq.music;

import aesq;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastMusicInfo;

public class SongInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aesq();
  public int a;
  public long a;
  public BroadcastMusicInfo a;
  public String a;
  public long b;
  public String b;
  public String c;
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
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo = ((BroadcastMusicInfo)paramParcel.readParcelable(BroadcastMusicInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.music.SongInfo
 * JD-Core Version:    0.7.0.1
 */