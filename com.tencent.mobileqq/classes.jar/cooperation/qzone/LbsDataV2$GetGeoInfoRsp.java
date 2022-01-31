package cooperation.qzone;

import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjdb;

public class LbsDataV2$GetGeoInfoRsp
  implements Parcelable
{
  public static final Parcelable.Creator<GetGeoInfoRsp> CREATOR = new bjdb();
  public LbsDataV2.GeoInfo stGeoInfo;
  public LbsDataV2.GpsInfo stGps;
  
  public LbsDataV2$GetGeoInfoRsp() {}
  
  public LbsDataV2$GetGeoInfoRsp(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo)
  {
    this.stGps = paramGpsInfo;
    this.stGeoInfo = paramGeoInfo;
  }
  
  public static GetGeoInfoRsp_V2 convertTo(GetGeoInfoRsp paramGetGeoInfoRsp)
  {
    GetGeoInfoRsp_V2 localGetGeoInfoRsp_V2 = new GetGeoInfoRsp_V2();
    if (paramGetGeoInfoRsp != null)
    {
      localGetGeoInfoRsp_V2.stGeoInfo = LbsDataV2.convertToGeoInfo_V2(paramGetGeoInfoRsp.stGeoInfo);
      localGetGeoInfoRsp_V2.stGps = LbsDataV2.convertToGPS_V2(paramGetGeoInfoRsp.stGps);
    }
    return localGetGeoInfoRsp_V2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "GetGeoInfoRsp:{" + this.stGps + ", " + this.stGeoInfo + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.stGps, paramInt);
    paramParcel.writeParcelable(this.stGeoInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GetGeoInfoRsp
 * JD-Core Version:    0.7.0.1
 */