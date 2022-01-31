package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjwv;

public final class EditVideoGame$GameResultItem
  implements Parcelable
{
  public static final Parcelable.Creator<GameResultItem> CREATOR = new bjwv();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public EditVideoGame$GameResultItem() {}
  
  public EditVideoGame$GameResultItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "GameResultItem{type=" + this.jdField_a_of_type_Int + ", gameId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", score=" + this.jdField_b_of_type_Int + ", extraListJSON=" + this.jdField_b_of_type_JavaLangString + ", feedId='" + this.jdField_c_of_type_JavaLangString + '\'' + ", vid='" + this.d + '\'' + ", gameResult='" + this.e + '\'' + ", pbType='" + this.jdField_c_of_type_Int + '\'' + ", resultStyleJSON='" + this.f + '\'' + ", gameLinkInfoJSON='" + this.g + '\'' + ", pkResultPicPath='" + this.h + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGame.GameResultItem
 * JD-Core Version:    0.7.0.1
 */