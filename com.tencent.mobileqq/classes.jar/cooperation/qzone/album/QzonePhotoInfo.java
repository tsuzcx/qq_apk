package cooperation.qzone.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfsx;
import java.util.HashMap;
import java.util.Map;

public class QzonePhotoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzonePhotoInfo> CREATOR = new bfsx();
  public int a;
  public long a;
  public String a;
  public Map<Integer, String> a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  
  public QzonePhotoInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public QzonePhotoInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(Map.class.getClassLoader());
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.album.QzonePhotoInfo
 * JD-Core Version:    0.7.0.1
 */