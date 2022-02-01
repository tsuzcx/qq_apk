package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmuc;
import java.util.ArrayList;
import java.util.Map;

public class QZoneShareData
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneShareData> CREATOR = new bmuc();
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public Map<String, String> a;
  public int b;
  public long b;
  public String b;
  public Map<String, String> b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public QZoneShareData() {}
  
  private QZoneShareData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilArrayList);
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilMap = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "appid:" + this.jdField_a_of_type_Long + " openId:" + this.jdField_a_of_type_JavaLangString + " mTitle:" + this.jdField_b_of_type_JavaLangString + " mSummary:" + this.jdField_c_of_type_JavaLangString + " targetUrl:" + this.d + " mImageUrl:" + this.jdField_a_of_type_JavaUtilArrayList.toString() + " appName:" + this.e + " shareUin:" + this.f + " extString:" + this.g + " from:" + this.jdField_b_of_type_Int + " action:" + this.h + " pkgname:" + this.i + " iUrlInfoFrm" + this.jdField_a_of_type_Int + " mWebUrl:" + this.m;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeMap(this.jdField_b_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneShareData
 * JD-Core Version:    0.7.0.1
 */