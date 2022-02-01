package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$GpsInfo$1
  implements Parcelable.Creator<LbsDataV2.GpsInfo>
{
  public LbsDataV2.GpsInfo createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramParcel != null)
    {
      localGpsInfo.lat = paramParcel.readInt();
      localGpsInfo.lon = paramParcel.readInt();
      localGpsInfo.alt = paramParcel.readInt();
      localGpsInfo.gpsType = paramParcel.readInt();
      localGpsInfo.accuracy = paramParcel.readInt();
    }
    return localGpsInfo;
  }
  
  public LbsDataV2.GpsInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GpsInfo.1
 * JD-Core Version:    0.7.0.1
 */