package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PictureUrl$1
  implements Parcelable.Creator<PictureUrl>
{
  public PictureUrl createFromParcel(Parcel paramParcel)
  {
    PictureUrl localPictureUrl = new PictureUrl();
    localPictureUrl.url = paramParcel.readString();
    localPictureUrl.width = paramParcel.readInt();
    localPictureUrl.height = paramParcel.readInt();
    localPictureUrl.pictureType = paramParcel.readInt();
    localPictureUrl.pivotXRate = paramParcel.readFloat();
    localPictureUrl.pivotYRate = paramParcel.readFloat();
    localPictureUrl.enlarge_rate = paramParcel.readInt();
    return localPictureUrl;
  }
  
  public PictureUrl[] newArray(int paramInt)
  {
    return new PictureUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PictureUrl.1
 * JD-Core Version:    0.7.0.1
 */