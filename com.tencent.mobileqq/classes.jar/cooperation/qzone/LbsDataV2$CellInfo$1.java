package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$CellInfo$1
  implements Parcelable.Creator<LbsDataV2.CellInfo>
{
  public LbsDataV2.CellInfo createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    if (paramParcel != null)
    {
      localCellInfo.mcc = paramParcel.readInt();
      localCellInfo.mnc = paramParcel.readInt();
      localCellInfo.lac = paramParcel.readInt();
      localCellInfo.cellId = paramParcel.readInt();
      localCellInfo.rssi = paramParcel.readInt();
      localCellInfo.stationLat = paramParcel.readDouble();
      localCellInfo.stationLon = paramParcel.readDouble();
    }
    return localCellInfo;
  }
  
  public LbsDataV2.CellInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.CellInfo.1
 * JD-Core Version:    0.7.0.1
 */