package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class BroadcastOneShow
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastOneShow> CREATOR = new BroadcastOneShow.1();
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c = "";
  
  BroadcastOneShow()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public BroadcastOneShow(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public static BroadcastOneShow a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow paramBroadcastOneShow)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    localBroadcastOneShow.jdField_a_of_type_JavaLangString = paramBroadcastOneShow.bcShowId;
    localBroadcastOneShow.jdField_b_of_type_JavaLangString = paramBroadcastOneShow.bcShowName;
    localBroadcastOneShow.jdField_a_of_type_Long = paramBroadcastOneShow.startTime;
    localBroadcastOneShow.jdField_b_of_type_Long = paramBroadcastOneShow.endTime;
    localBroadcastOneShow.jdField_a_of_type_Int = paramBroadcastOneShow.singerId;
    localBroadcastOneShow.c = paramBroadcastOneShow.singerName;
    return localBroadcastOneShow;
  }
  
  public static BroadcastOneShow a(String paramString)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastOneShow.jdField_a_of_type_JavaLangString = paramString.optString("bcShowId");
      localBroadcastOneShow.jdField_b_of_type_JavaLangString = paramString.optString("bcShowName");
      localBroadcastOneShow.jdField_a_of_type_Long = paramString.optLong("startTime");
      localBroadcastOneShow.jdField_b_of_type_Long = paramString.optLong("endTime");
      localBroadcastOneShow.jdField_a_of_type_Int = paramString.optInt("singerId");
      localBroadcastOneShow.c = paramString.optString("singerName");
      return localBroadcastOneShow;
    }
    catch (Exception paramString) {}
    return localBroadcastOneShow;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastOneShow
 * JD-Core Version:    0.7.0.1
 */