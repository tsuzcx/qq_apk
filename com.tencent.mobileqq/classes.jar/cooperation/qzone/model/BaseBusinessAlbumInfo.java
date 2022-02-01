package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseBusinessAlbumInfo
  implements Parcelable, Cloneable
{
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
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public BaseBusinessAlbumInfo()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public BaseBusinessAlbumInfo(String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public BaseBusinessAlbumInfo a()
  {
    BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo(this.jdField_a_of_type_JavaLangString);
    localBaseBusinessAlbumInfo.a(this);
    return localBaseBusinessAlbumInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramBaseBusinessAlbumInfo.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramBaseBusinessAlbumInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramBaseBusinessAlbumInfo.jdField_b_of_type_Int;
    this.jdField_b_of_type_Long = paramBaseBusinessAlbumInfo.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramBaseBusinessAlbumInfo.jdField_c_of_type_Int;
    this.jdField_c_of_type_Long = paramBaseBusinessAlbumInfo.jdField_c_of_type_Long;
    this.jdField_d_of_type_Int = paramBaseBusinessAlbumInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_Boolean = paramBaseBusinessAlbumInfo.jdField_a_of_type_Boolean;
    this.e = paramBaseBusinessAlbumInfo.e;
    this.f = paramBaseBusinessAlbumInfo.f;
    this.jdField_d_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_d_of_type_JavaLangString;
    this.g = paramBaseBusinessAlbumInfo.g;
    this.h = paramBaseBusinessAlbumInfo.h;
    this.i = paramBaseBusinessAlbumInfo.i;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BaseBusinessAlbumInfo)paramObject;
        if (this.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (paramObject.jdField_a_of_type_JavaLangString == null);
      return false;
    } while (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int j = 0;; j = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return j + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.BaseBusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */