package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bnar;

public class VideoInfo$VideoRemark
  implements Parcelable
{
  public static final Parcelable.Creator<VideoRemark> CREATOR = new bnar();
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  
  public VideoInfo$VideoRemark()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.c;
    }
    return this.jdField_b_of_type_JavaLangString + " -- " + this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo.VideoRemark
 * JD-Core Version:    0.7.0.1
 */