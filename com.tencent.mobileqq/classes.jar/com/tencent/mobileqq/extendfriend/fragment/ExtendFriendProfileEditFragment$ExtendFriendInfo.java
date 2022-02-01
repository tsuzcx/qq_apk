package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asjl;
import com.tencent.mobileqq.data.Card;

public class ExtendFriendProfileEditFragment$ExtendFriendInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ExtendFriendInfo> CREATOR = new asjl();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo() {}
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label158;
      }
      bool1 = true;
      label93:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label163;
      }
    }
    label158:
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label93;
    }
  }
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo(Card paramCard)
  {
    this.jdField_a_of_type_JavaLangString = paramCard.declaration;
    this.jdField_a_of_type_Int = paramCard.popularity;
    this.jdField_b_of_type_JavaLangString = paramCard.voiceUrl;
    this.jdField_a_of_type_Boolean = paramCard.isShowCard;
    this.jdField_b_of_type_Int = paramCard.extendFriendVoiceDuration;
    this.jdField_c_of_type_Int = paramCard.fontId;
    this.jdField_d_of_type_Int = paramCard.clothesId;
    this.jdField_c_of_type_JavaLangString = paramCard.schoolId;
    this.jdField_d_of_type_JavaLangString = paramCard.schoolName;
    this.jdField_a_of_type_Long = paramCard.authState;
    this.g = paramCard.idx;
    this.h = paramCard.category;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      if (!this.jdField_b_of_type_Boolean) {
        break label156;
      }
      b1 = 1;
      label90:
      paramParcel.writeByte(b1);
      if (!this.jdField_c_of_type_Boolean) {
        break label161;
      }
    }
    label156:
    label161:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo
 * JD-Core Version:    0.7.0.1
 */