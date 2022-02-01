package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$GetGeoInfoRsp$1
  implements Parcelable.Creator<LbsDataV2.GetGeoInfoRsp>
{
  public LbsDataV2.GetGeoInfoRsp createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.GetGeoInfoRsp localGetGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
    if (paramParcel != null)
    {
      localGetGeoInfoRsp.stGps = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localGetGeoInfoRsp.stGeoInfo = ((LbsDataV2.GeoInfo)paramParcel.readParcelable(LbsDataV2.GeoInfo.class.getClassLoader()));
    }
    return localGetGeoInfoRsp;
  }
  
  public LbsDataV2.GetGeoInfoRsp[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GetGeoInfoRsp.1
 * JD-Core Version:    0.7.0.1
 */