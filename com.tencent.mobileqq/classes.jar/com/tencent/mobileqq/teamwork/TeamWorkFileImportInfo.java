package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bebn;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new bebn();
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
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  public TeamWorkFileImportInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
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
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_d_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label377;
      }
      bool1 = true;
      label128:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label382;
      }
      bool1 = true;
      label142:
      this.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label387;
      }
      bool1 = true;
      label156:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label392;
      }
      bool1 = true;
      label170:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label397;
      }
      bool1 = true;
      label184:
      this.jdField_f_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label402;
      }
    }
    label387:
    label392:
    label397:
    label402:
    for (boolean bool1 = bool2;; bool1 = false)
    {
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
      return;
      bool1 = false;
      break;
      label377:
      bool1 = false;
      break label128;
      label382:
      bool1 = false;
      break label142;
      bool1 = false;
      break label156;
      bool1 = false;
      break label170;
      bool1 = false;
      break label184;
    }
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
    return "TeamWorkFileImportInfo{peerType=" + this.jdField_a_of_type_Int + ", peerUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", fileName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", filePath='" + this.jdField_c_of_type_JavaLangString + '\'' + ", msgUniseq=" + this.jdField_a_of_type_Long + ", nSessionId=" + this.jdField_b_of_type_Long + ", troopFilePath='" + this.jdField_d_of_type_JavaLangString + '\'' + ", troopFileBusId=" + this.jdField_b_of_type_Int + ", device=" + this.jdField_c_of_type_Int + ", troopUin='" + this.jdField_e_of_type_JavaLangString + '\'' + ", isNeedDownLoadUrl=" + this.jdField_a_of_type_Boolean + ", entranceFrom=" + this.jdField_d_of_type_Int + ", isFromAIO=" + this.jdField_b_of_type_Boolean + ", isFromDataLine=" + this.jdField_c_of_type_Boolean + ", isOpenTeamWork=" + this.jdField_d_of_type_Boolean + ", isUserClick=" + this.jdField_e_of_type_Boolean + ", isMessageConvert=" + this.jdField_f_of_type_Boolean + ", nFileType=" + this.jdField_e_of_type_Int + ", folderId='" + this.jdField_g_of_type_JavaLangString + '\'' + ", retCode=" + this.jdField_f_of_type_Int + ", errorString='" + this.jdField_h_of_type_JavaLangString + '\'' + ", redirectUrl='" + this.jdField_i_of_type_JavaLangString + '\'' + ", strSendUin='" + this.jdField_j_of_type_JavaLangString + '\'' + ", traceId='" + this.k + '\'' + ", importOption=" + this.jdField_g_of_type_Int + ", urlType=" + this.jdField_h_of_type_Int + ", fileid='" + this.jdField_l_of_type_JavaLangString + '\'' + ", filetype=" + this.jdField_i_of_type_Int + ", fileImportType=" + this.jdField_j_of_type_Int + ", fileSize=" + this.jdField_d_of_type_Long + ", structUniseq=" + this.jdField_e_of_type_Long + ", editedUrl='" + this.p + '\'' + ", srcUrl='" + this.jdField_f_of_type_JavaLangString + '\'' + ", createTime='" + this.jdField_c_of_type_Long + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
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
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label369;
      }
      paramInt = 1;
      label114:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label374;
      }
      paramInt = 1;
      label129:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_d_of_type_Boolean) {
        break label379;
      }
      paramInt = 1;
      label144:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label384;
      }
      paramInt = 1;
      label159:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label389;
      }
      paramInt = 1;
      label174:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_g_of_type_Boolean) {
        break label394;
      }
    }
    label384:
    label389:
    label394:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
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
      return;
      paramInt = 0;
      break;
      label369:
      paramInt = 0;
      break label114;
      label374:
      paramInt = 0;
      break label129;
      label379:
      paramInt = 0;
      break label144;
      paramInt = 0;
      break label159;
      paramInt = 0;
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */