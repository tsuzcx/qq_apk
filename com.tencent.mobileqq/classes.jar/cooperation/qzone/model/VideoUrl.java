package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhfp;

public class VideoUrl
  implements Parcelable
{
  public static final Parcelable.Creator<VideoUrl> CREATOR = new bhfp();
  public int a;
  public String a;
  public int b;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VideoUrl [url=" + this.jdField_a_of_type_JavaLangString + ", decoderType=" + this.jdField_a_of_type_Int + ", videoRate=" + this.b + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.VideoUrl
 * JD-Core Version:    0.7.0.1
 */