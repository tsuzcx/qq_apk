package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GpsInfo4LocalImage$1
  implements Parcelable.Creator<GpsInfo4LocalImage>
{
  public GpsInfo4LocalImage createFromParcel(Parcel paramParcel)
  {
    return new GpsInfo4LocalImage(paramParcel.readFloat(), paramParcel.readFloat());
  }
  
  public GpsInfo4LocalImage[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.GpsInfo4LocalImage.1
 * JD-Core Version:    0.7.0.1
 */