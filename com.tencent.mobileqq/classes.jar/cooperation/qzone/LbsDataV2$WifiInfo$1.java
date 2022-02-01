package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$WifiInfo$1
  implements Parcelable.Creator<LbsDataV2.WifiInfo>
{
  public LbsDataV2.WifiInfo createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.WifiInfo localWifiInfo = new LbsDataV2.WifiInfo();
    if (paramParcel != null)
    {
      localWifiInfo.mac = paramParcel.readString();
      localWifiInfo.rssi = paramParcel.readInt();
    }
    return localWifiInfo;
  }
  
  public LbsDataV2.WifiInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.WifiInfo.1
 * JD-Core Version:    0.7.0.1
 */