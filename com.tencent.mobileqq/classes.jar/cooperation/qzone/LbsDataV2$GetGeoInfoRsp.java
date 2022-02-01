package cooperation.qzone;

import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LbsDataV2$GetGeoInfoRsp
  implements Parcelable
{
  public static final Parcelable.Creator<GetGeoInfoRsp> CREATOR = new LbsDataV2.GetGeoInfoRsp.1();
  public LbsDataV2.GeoInfo stGeoInfo = null;
  public LbsDataV2.GpsInfo stGps = null;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetGeoInfoRsp:{");
    localStringBuilder.append(this.stGps);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.stGeoInfo);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.stGps, paramInt);
    paramParcel.writeParcelable(this.stGeoInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GetGeoInfoRsp
 * JD-Core Version:    0.7.0.1
 */