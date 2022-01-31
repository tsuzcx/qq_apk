package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bgxw;

public class LbsDataV2$GeoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GeoInfo> CREATOR = new bgxw();
  public String address;
  public LbsDataV2.GpsInfo gpsInfo;
  public int iDistrictCode;
  public int iRange = -1;
  public String strCity = "";
  public String strCountry = "";
  public String strDefaultName = "";
  public String strDistrict = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  public String strVillage = "";
  
  public LbsDataV2$GeoInfo() {}
  
  public LbsDataV2$GeoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.iDistrictCode = paramInt1;
    this.iRange = paramInt2;
    this.strCountry = paramString1;
    this.strProvince = paramString2;
    this.strCity = paramString3;
    this.strDistrict = paramString4;
    this.strTown = paramString5;
    this.strVillage = paramString6;
    this.strRoad = paramString7;
    this.strDefaultName = paramString8;
  }
  
  public GeoInfo clone()
  {
    GeoInfo localGeoInfo = new GeoInfo();
    localGeoInfo.address = this.address;
    localGeoInfo.iDistrictCode = this.iDistrictCode;
    localGeoInfo.iRange = this.iRange;
    localGeoInfo.strCountry = this.strCountry;
    localGeoInfo.strProvince = this.strProvince;
    localGeoInfo.strCity = this.strCity;
    localGeoInfo.strDistrict = this.strDistrict;
    localGeoInfo.strTown = this.strTown;
    localGeoInfo.strVillage = this.strVillage;
    localGeoInfo.strRoad = this.strRoad;
    localGeoInfo.strDefaultName = this.strDefaultName;
    if (this.gpsInfo != null) {
      localGeoInfo.gpsInfo = this.gpsInfo.clone();
    }
    return localGeoInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.strCountry)) || (!TextUtils.isEmpty(this.strProvince)) || (!TextUtils.isEmpty(this.strCity)) || (!TextUtils.isEmpty(this.strDistrict));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.address);
    paramParcel.writeInt(this.iDistrictCode);
    paramParcel.writeInt(this.iRange);
    paramParcel.writeString(this.strCountry);
    paramParcel.writeString(this.strProvince);
    paramParcel.writeString(this.strCity);
    paramParcel.writeString(this.strDistrict);
    paramParcel.writeString(this.strTown);
    paramParcel.writeString(this.strVillage);
    paramParcel.writeString(this.strRoad);
    paramParcel.writeString(this.strDefaultName);
    paramParcel.writeParcelable(this.gpsInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GeoInfo
 * JD-Core Version:    0.7.0.1
 */