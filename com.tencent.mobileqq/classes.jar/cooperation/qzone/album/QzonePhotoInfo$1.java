package cooperation.qzone.album;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QzonePhotoInfo$1
  implements Parcelable.Creator<QzonePhotoInfo>
{
  public QzonePhotoInfo createFromParcel(Parcel paramParcel)
  {
    return new QzonePhotoInfo(paramParcel);
  }
  
  public QzonePhotoInfo[] newArray(int paramInt)
  {
    return new QzonePhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.album.QzonePhotoInfo.1
 * JD-Core Version:    0.7.0.1
 */