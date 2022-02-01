package com.tencent.mobileqq.writetogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.List;

public class OpenDocParam
  implements Parcelable
{
  public static final Parcelable.Creator<OpenDocParam> CREATOR = new OpenDocParam.1();
  public int a;
  public long a;
  public String a;
  public List<EditUserHistory> a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public OpenDocParam()
  {
    this.jdField_g_of_type_Int = 1;
  }
  
  protected OpenDocParam(Parcel paramParcel)
  {
    this.jdField_g_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes_global_padid");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_doc_type");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_title");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextName");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextSubId");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextText");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextAttr");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextAPool");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_subid");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_baseRev");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_baseLen");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_meta");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_sheetPosLen");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_owner_appid");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_baseLen");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_sheetPosLen");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("ownerUin");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("maxLen");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_group_code");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n");
    localStringBuilder.append("launchType");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("showSoftInput");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.OpenDocParam
 * JD-Core Version:    0.7.0.1
 */