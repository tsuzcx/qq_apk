package cooperation.qzone.model;

import amuu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PictureUrl
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amuu();
  public float a;
  public int a;
  public String a;
  public float b;
  public int b;
  public int c;
  public int d;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PictureUrl [url=" + this.jdField_a_of_type_JavaLangString + ", width=" + this.jdField_a_of_type_Int + ", height=" + this.jdField_b_of_type_Int + ", pictureType=" + this.c + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.PictureUrl
 * JD-Core Version:    0.7.0.1
 */