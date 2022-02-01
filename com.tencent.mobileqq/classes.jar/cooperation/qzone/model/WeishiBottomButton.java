package cooperation.qzone.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bnau;
import java.util.HashMap;

public class WeishiBottomButton
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiBottomButton> CREATOR = new bnau();
  public int a;
  public String a;
  public HashMap<Integer, Integer> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  
  public WeishiBottomButton()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public WeishiBottomButton(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramParcel.readBundle().getSerializable("stMapABTest"));
  }
  
  public WeishiBottomButton(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<Integer, Integer> paramHashMap, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
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
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("stMapABTest", this.jdField_a_of_type_JavaUtilHashMap);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.WeishiBottomButton
 * JD-Core Version:    0.7.0.1
 */