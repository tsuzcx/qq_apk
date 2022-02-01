package cooperation.qzone.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QzoneVerticalVideoTopicInfo$1
  implements Parcelable.Creator<QzoneVerticalVideoTopicInfo>
{
  public QzoneVerticalVideoTopicInfo createFromParcel(Parcel paramParcel)
  {
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = new QzoneVerticalVideoTopicInfo();
    QzoneVerticalVideoTopicInfo.access$002(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$102(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$202(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$302(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$402(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$502(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$602(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    QzoneVerticalVideoTopicInfo.access$702(localQzoneVerticalVideoTopicInfo, paramParcel.readString());
    return localQzoneVerticalVideoTopicInfo;
  }
  
  public QzoneVerticalVideoTopicInfo[] newArray(int paramInt)
  {
    return new QzoneVerticalVideoTopicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoTopicInfo.1
 * JD-Core Version:    0.7.0.1
 */