package cooperation.qzone.model;

import ameg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CoverCacheData$GameCoverInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ameg();
  public double a;
  public int a;
  public String a;
  public double b;
  public String b;
  public double c;
  public double d;
  
  public CoverCacheData$GameCoverInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
    paramParcel.writeDouble(this.c);
    paramParcel.writeDouble(this.d);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.GameCoverInfo
 * JD-Core Version:    0.7.0.1
 */