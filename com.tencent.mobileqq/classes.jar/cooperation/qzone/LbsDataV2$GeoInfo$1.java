package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LbsDataV2$GeoInfo$1
  implements Parcelable.Creator<LbsDataV2.GeoInfo>
{
  public LbsDataV2.GeoInfo createFromParcel(Parcel paramParcel)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramParcel != null)
    {
      localGeoInfo.address = paramParcel.readString();
      localGeoInfo.iDistrictCode = paramParcel.readInt();
      localGeoInfo.iRange = paramParcel.readInt();
      localGeoInfo.strCountry = paramParcel.readString();
      localGeoInfo.strProvince = paramParcel.readString();
      localGeoInfo.strCity = paramParcel.readString();
      localGeoInfo.strDistrict = paramParcel.readString();
      localGeoInfo.strTown = paramParcel.readString();
      localGeoInfo.strVillage = paramParcel.readString();
      localGeoInfo.strRoad = paramParcel.readString();
      localGeoInfo.strDefaultName = paramParcel.readString();
      localGeoInfo.gpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
    }
    return localGeoInfo;
  }
  
  public LbsDataV2.GeoInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GeoInfo.1
 * JD-Core Version:    0.7.0.1
 */