package com.tencent.mobileqq.listentogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anvx;
import awfp;
import awfq;
import bekh;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.ArrayList;
import java.util.List;

public class ListenTogetherSession
  extends bekh
  implements Parcelable
{
  public static final Parcelable.Creator<ListenTogetherSession> CREATOR = new awfp();
  public int a;
  public String a;
  public List<MusicInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  
  public ListenTogetherSession(int paramInt, String paramString)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  private ListenTogetherSession(Parcel paramParcel)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, MusicInfo.CREATOR);
    this.jdField_c_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.i = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label178;
      }
    }
    label178:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.g = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public MusicInfo a()
  {
    if (this.h == 3) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    return (MusicInfo)this.jdField_a_of_type_JavaUtilList.get(0);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return awfq.a(this.jdField_f_of_type_Int, paramInt1, paramInt2);
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    this.h = paramListenTogetherSession.h;
    this.i = paramListenTogetherSession.i;
    this.jdField_a_of_type_JavaLangString = paramListenTogetherSession.jdField_a_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = paramListenTogetherSession.jdField_f_of_type_JavaLangString;
    this.g = paramListenTogetherSession.g;
    this.jdField_a_of_type_Int = paramListenTogetherSession.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramListenTogetherSession.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_Boolean = paramListenTogetherSession.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_Long = paramListenTogetherSession.jdField_c_of_type_Long;
    this.jdField_a_of_type_JavaUtilList = paramListenTogetherSession.jdField_a_of_type_JavaUtilList;
    this.jdField_b_of_type_Int = paramListenTogetherSession.jdField_b_of_type_Int;
    this.jdField_c_of_type_Boolean = paramListenTogetherSession.jdField_c_of_type_Boolean;
    this.jdField_d_of_type_Boolean = paramListenTogetherSession.jdField_d_of_type_Boolean;
    this.jdField_c_of_type_Int = paramListenTogetherSession.jdField_c_of_type_Int;
    this.jdField_d_of_type_Long = paramListenTogetherSession.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_f_of_type_Int + "_" + this.jdField_e_of_type_JavaLangString;
  }
  
  public int c()
  {
    int i = 1;
    if (this.jdField_f_of_type_Int == 1) {
      i = -1;
    }
    do
    {
      return i;
      if (anvx.a(2131693534).equals(this.jdField_a_of_type_JavaLangString)) {
        return 3;
      }
      if (anvx.a(2131693545).equals(this.jdField_a_of_type_JavaLangString)) {
        return 2;
      }
    } while (anvx.a(2131693561).equals(this.jdField_a_of_type_JavaLangString));
    return 4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ListenTogetherSession{type=").append(this.jdField_f_of_type_Int).append(", uin='").append(this.jdField_e_of_type_JavaLangString).append('\'').append(", status=").append(this.h).append(", musicList=").append(this.jdField_a_of_type_JavaUtilList).append(", timeStamp=").append(this.jdField_c_of_type_Long).append(", fold=").append(this.jdField_a_of_type_Boolean).append(", userState=").append(this.i).append(", joinedNum=").append(this.jdField_a_of_type_JavaLangString).append(", creator='").append(this.jdField_f_of_type_JavaLangString).append('\'').append(", creatorNick='");
    if (this.g == null) {}
    for (String str = "null";; str = this.g) {
      return str + '\'' + ", playMode='" + this.jdField_c_of_type_Int + '\'' + ", joinedType=" + this.jdField_a_of_type_Int + ", joinedUin='" + this.jdField_b_of_type_JavaLangString + '\'' + ", joinedIsCreator=" + this.jdField_b_of_type_Boolean + ", themeId=" + this.jdField_b_of_type_Int + ", bAlowMemberStart=" + this.jdField_c_of_type_Boolean + ", bAlowMemberAddSong=" + this.jdField_d_of_type_Boolean + ", identifyId=" + this.jdField_d_of_type_Long + '}';
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.h);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.i);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label150;
      }
    }
    label150:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeString(this.g);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherSession
 * JD-Core Version:    0.7.0.1
 */