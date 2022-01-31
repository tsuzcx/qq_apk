package com.tencent.mobileqq.extendfriend.fragment;

import acir;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.Card;

public class ExtendFriendProfileEditFragment$ExtendFriendInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new acir();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo() {}
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      return;
    }
  }
  
  public ExtendFriendProfileEditFragment$ExtendFriendInfo(Card paramCard)
  {
    this.jdField_a_of_type_JavaLangString = paramCard.declaration;
    this.jdField_a_of_type_Int = paramCard.popularity;
    this.jdField_b_of_type_JavaLangString = paramCard.voiceUrl;
    this.jdField_a_of_type_Boolean = paramCard.isShowCard;
    this.jdField_b_of_type_Int = paramCard.extendFriendVoiceDuration;
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
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo
 * JD-Core Version:    0.7.0.1
 */