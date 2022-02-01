package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class VideoData
  implements Parcelable
{
  public static final Parcelable.Creator<VideoData> CREATOR = new VideoData.1();
  public static final int a;
  public long a;
  public LocationInfo a;
  public TopicInfo a;
  public String a;
  public ArrayList<ImageData> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public int h;
  public long h;
  public String h;
  public int i;
  public long i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public int m;
  public int n;
  
  static
  {
    jdField_a_of_type_Int = ((IModelUtil)QRoute.api(IModelUtil.class)).getFeedsProtocolMediaInfoTextFeeds();
  }
  
  public VideoData()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public VideoData(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_Long = paramParcel.readLong();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    return (str == null) || (str.equals(""));
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoData{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headerUrl='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorNickName='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_h_of_type_Long);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.VideoData
 * JD-Core Version:    0.7.0.1
 */