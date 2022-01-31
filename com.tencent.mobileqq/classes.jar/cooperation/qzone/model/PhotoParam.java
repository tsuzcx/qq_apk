package cooperation.qzone.model;

import amep;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class PhotoParam
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amep();
  public int a;
  public long a;
  public String a;
  public Map a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public String k = "";
  
  public PhotoParam()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = 4;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_j_of_type_Int = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label372;
      }
      paramInt = 1;
      label201:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label377;
      }
      paramInt = 1;
      label223:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      if (!this.jdField_d_of_type_Boolean) {
        break label382;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label387;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label392;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_g_of_type_Boolean) {
        break label397;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_h_of_type_Boolean) {
        break label402;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_i_of_type_Boolean) {
        break label407;
      }
      paramInt = 1;
      label315:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.k);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      if (!this.jdField_j_of_type_Boolean) {
        break label412;
      }
    }
    label387:
    label392:
    label397:
    label402:
    label407:
    label412:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      label372:
      paramInt = 0;
      break label201;
      label377:
      paramInt = 0;
      break label223;
      label382:
      paramInt = 0;
      break label245;
      paramInt = 0;
      break label259;
      paramInt = 0;
      break label273;
      paramInt = 0;
      break label287;
      paramInt = 0;
      break label301;
      paramInt = 0;
      break label315;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */