package dov.com.qq.im.setting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmhj;

public class QIMSelectEffectParams
  implements Parcelable
{
  public static final Parcelable.Creator<QIMSelectEffectParams> CREATOR = new bmhj();
  public int a;
  public String a;
  public int b;
  public String b;
  
  public QIMSelectEffectParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.setting.QIMSelectEffectParams
 * JD-Core Version:    0.7.0.1
 */