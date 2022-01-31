package cooperation.qzone.model;

import ancj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoUrl
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ancj();
  public int a;
  public String a;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VideoUrl [url=" + this.jdField_a_of_type_JavaLangString + ", decorderType=" + this.jdField_a_of_type_Int + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.VideoUrl
 * JD-Core Version:    0.7.0.1
 */