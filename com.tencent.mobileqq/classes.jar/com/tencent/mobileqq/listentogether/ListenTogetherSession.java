package com.tencent.mobileqq.listentogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.together.TogetherSession;
import java.util.ArrayList;
import java.util.List;

public class ListenTogetherSession
  extends TogetherSession
  implements Parcelable
{
  public static final Parcelable.Creator<ListenTogetherSession> CREATOR = new ListenTogetherSession.1();
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  private ListenTogetherSession(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, MusicInfo.CREATOR);
    this.jdField_c_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.i = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.g = paramParcel.readString();
  }
  
  public MusicInfo a()
  {
    if (this.h == 3) {
      return null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      return (MusicInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ListenTogetherUtils.a(this.jdField_f_of_type_Int, paramInt1, paramInt2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public int c()
  {
    if (this.jdField_f_of_type_Int == 1) {
      return -1;
    }
    if (HardCodeUtil.a(2131693643).equals(this.jdField_a_of_type_JavaLangString)) {
      return 3;
    }
    if (HardCodeUtil.a(2131693654).equals(this.jdField_a_of_type_JavaLangString)) {
      return 2;
    }
    if (HardCodeUtil.a(2131693670).equals(this.jdField_a_of_type_JavaLangString)) {
      return 1;
    }
    return 4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ListenTogetherSession{type=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", musicList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", fold=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", joinedNum=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", creatorNick='");
    String str;
    if (this.g == null) {
      str = "null";
    } else {
      str = this.g;
    }
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playMode='");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinedType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", joinedUin='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinedIsCreator=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", themeId=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", bAlowMemberStart=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", bAlowMemberAddSong=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", identifyId=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.h);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherSession
 * JD-Core Version:    0.7.0.1
 */