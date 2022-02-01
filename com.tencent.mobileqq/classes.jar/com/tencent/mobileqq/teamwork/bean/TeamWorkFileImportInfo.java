package com.tencent.mobileqq.teamwork.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new TeamWorkFileImportInfo.1();
  public int a;
  public long a;
  public String a;
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
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  
  public TeamWorkFileImportInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  protected TeamWorkFileImportInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    boolean bool2 = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_f_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_g_of_type_Boolean = bool1;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.k = paramParcel.readString();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.p = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_l_of_type_Int = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 8;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Int == 11;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int == 13;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Int == 7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TeamWorkFileImportInfo{peerType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", peerUin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileName='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgUniseq=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", nSessionId=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", troopFilePath='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopFileBusId=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", troopUin='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isNeedDownLoadUrl=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", entranceFrom=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", isFromAIO=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", isFromDataLine=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", isOpenTeamWork=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", isUserClick=");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append(", isMessageConvert=");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    localStringBuilder.append(", nFileType=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", folderId='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", retCode=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", errorString='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redirectUrl='");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSendUin='");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", traceId='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", importOption=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", urlType=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(", fileid='");
    localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filetype=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(", fileImportType=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", structUniseq=");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", editedUrl='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", srcUrl='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime='");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_d_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_e_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_f_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_g_of_type_Boolean);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_l_of_type_Int);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */