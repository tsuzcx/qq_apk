package cooperation.qqreader.js;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bmpq;
import java.util.Arrays;

public class JsCallParams
  implements Parcelable
{
  public static final Parcelable.Creator<JsCallParams> CREATOR = new bmpq();
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String b;
  private String c;
  
  private JsCallParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfJavaLangString = paramParcel.createStringArray();
  }
  
  public JsCallParams(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(JsCallParams paramJsCallParams)
  {
    return (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramJsCallParams.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.c, paramJsCallParams.c)) && (TextUtils.equals(this.b, paramJsCallParams.b)) && (Arrays.equals(this.jdField_a_of_type_ArrayOfJavaLangString, paramJsCallParams.jdField_a_of_type_ArrayOfJavaLangString));
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.js.JsCallParams
 * JD-Core Version:    0.7.0.1
 */