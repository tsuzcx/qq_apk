package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$PoiInfo$1
  implements Parcelable.Creator<LbsDataV2.PoiInfo>
{
  public LbsDataV2.PoiInfo createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramParcel != null)
    {
      localPoiInfo.poiId = paramParcel.readString();
      localPoiInfo.poiName = paramParcel.readString();
      localPoiInfo.poiType = paramParcel.readInt();
      localPoiInfo.poiTypeName = paramParcel.readString();
      localPoiInfo.poiDefaultName = paramParcel.readString();
      localPoiInfo.address = paramParcel.readString();
      localPoiInfo.districtCode = paramParcel.readInt();
      localPoiInfo.distance = paramParcel.readInt();
      localPoiInfo.hotValue = paramParcel.readInt();
      localPoiInfo.phoneNumber = paramParcel.readString();
      localPoiInfo.poiOrderType = paramParcel.readInt();
      localPoiInfo.poiNum = paramParcel.readInt();
      localPoiInfo.dianPingId = paramParcel.readString();
      localPoiInfo.gpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localPoiInfo.show_poi = paramParcel.readInt();
      localPoiInfo.country = paramParcel.readString();
      localPoiInfo.province = paramParcel.readString();
      localPoiInfo.city = paramParcel.readString();
      localPoiInfo.district = paramParcel.readString();
      int i = paramParcel.readByte();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localPoiInfo.isRecomm = bool;
    }
    return localPoiInfo;
  }
  
  public LbsDataV2.PoiInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.PoiInfo.1
 * JD-Core Version:    0.7.0.1
 */