package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.HashMap;

final class QCirclePublishPictureTagInfo$1
  implements Parcelable.Creator<QCirclePublishPictureTagInfo>
{
  public QCirclePublishPictureTagInfo createFromParcel(Parcel paramParcel)
  {
    QCirclePublishPictureTagInfo localQCirclePublishPictureTagInfo = new QCirclePublishPictureTagInfo();
    localQCirclePublishPictureTagInfo.picId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.picTags = paramParcel.readArrayList(String.class.getClassLoader());
    localQCirclePublishPictureTagInfo.materialId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.filterId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.exif = ((HashMap)paramParcel.readSerializable());
    return localQCirclePublishPictureTagInfo;
  }
  
  public QCirclePublishPictureTagInfo[] newArray(int paramInt)
  {
    return new QCirclePublishPictureTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.QCirclePublishPictureTagInfo.1
 * JD-Core Version:    0.7.0.1
 */