package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfwu;

public class WeishiPictureUrl
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiPictureUrl> CREATOR = new bfwu();
  public int a;
  public PictureUrl a;
  
  public WeishiPictureUrl() {}
  
  public WeishiPictureUrl(int paramInt, PictureUrl paramPictureUrl)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationQzoneModelPictureUrl = paramPictureUrl;
  }
  
  public WeishiPictureUrl(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(PictureUrl.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelPictureUrl, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiPictureUrl
 * JD-Core Version:    0.7.0.1
 */