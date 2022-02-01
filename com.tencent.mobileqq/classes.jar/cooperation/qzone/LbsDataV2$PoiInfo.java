package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LbsDataV2$PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiInfo> CREATOR = new LbsDataV2.PoiInfo.1();
  public String address;
  public String city = "";
  public String country = "";
  public String dianPingId = "";
  public int distance;
  public String district = "";
  public int districtCode = 0;
  public LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
  public int hotValue = 0;
  public boolean isRecomm = false;
  public String phoneNumber = "";
  public String poiDefaultName;
  public String poiId;
  public String poiName;
  public int poiNum;
  public int poiOrderType;
  public int poiType;
  public String poiTypeName;
  public String province = "";
  public int show_poi = 0;
  
  public static PoiInfo clone(PoiInfo paramPoiInfo)
  {
    LbsDataV2.GpsInfo localGpsInfo1 = null;
    if (paramPoiInfo == null) {
      return null;
    }
    PoiInfo localPoiInfo = new PoiInfo();
    localPoiInfo.address = paramPoiInfo.address;
    localPoiInfo.dianPingId = paramPoiInfo.dianPingId;
    localPoiInfo.distance = paramPoiInfo.distance;
    localPoiInfo.districtCode = paramPoiInfo.districtCode;
    LbsDataV2.GpsInfo localGpsInfo2 = paramPoiInfo.gpsInfo;
    if (localGpsInfo2 != null) {
      localGpsInfo1 = localGpsInfo2.clone();
    }
    localPoiInfo.gpsInfo = localGpsInfo1;
    localPoiInfo.hotValue = paramPoiInfo.hotValue;
    localPoiInfo.phoneNumber = paramPoiInfo.phoneNumber;
    localPoiInfo.poiDefaultName = paramPoiInfo.poiDefaultName;
    localPoiInfo.poiId = paramPoiInfo.poiId;
    localPoiInfo.poiName = paramPoiInfo.poiName;
    localPoiInfo.poiNum = paramPoiInfo.poiNum;
    localPoiInfo.poiOrderType = paramPoiInfo.poiOrderType;
    localPoiInfo.poiType = paramPoiInfo.poiType;
    localPoiInfo.poiTypeName = paramPoiInfo.poiTypeName;
    localPoiInfo.show_poi = paramPoiInfo.show_poi;
    localPoiInfo.city = paramPoiInfo.city;
    localPoiInfo.province = paramPoiInfo.province;
    localPoiInfo.country = paramPoiInfo.country;
    localPoiInfo.district = paramPoiInfo.district;
    localPoiInfo.isRecomm = paramPoiInfo.isRecomm;
    return localPoiInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return ((PoiInfo)paramObject).poiId.equals(this.poiId);
  }
  
  public String toString()
  {
    if (this.gpsInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" poiId: ");
      localStringBuilder.append(this.poiId);
      localStringBuilder.append(" poiName: ");
      localStringBuilder.append(this.poiName);
      localStringBuilder.append(" poiType: ");
      localStringBuilder.append(this.poiType);
      localStringBuilder.append(" poiTypeName: ");
      localStringBuilder.append(this.poiTypeName);
      localStringBuilder.append(" address: ");
      localStringBuilder.append(this.address);
      localStringBuilder.append(" districtCode: ");
      localStringBuilder.append(this.districtCode);
      localStringBuilder.append(" distance: ");
      localStringBuilder.append(this.distance);
      localStringBuilder.append(" phoneNumber: ");
      localStringBuilder.append(this.phoneNumber);
      localStringBuilder.append("poiOrderType: ");
      localStringBuilder.append(this.poiOrderType);
      localStringBuilder.append("poiNum: ");
      localStringBuilder.append(this.poiNum);
      localStringBuilder.append(" gpsInfo: ");
      localStringBuilder.append(this.gpsInfo.toString());
      localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poiId: ");
    localStringBuilder.append(this.poiId);
    localStringBuilder.append("poiName: ");
    localStringBuilder.append(this.poiName);
    localStringBuilder.append("poiType: ");
    localStringBuilder.append(this.poiType);
    localStringBuilder.append("poiTypeName: ");
    localStringBuilder.append(this.poiTypeName);
    localStringBuilder.append("address: ");
    localStringBuilder.append(this.address);
    localStringBuilder.append("districtCode: ");
    localStringBuilder.append(this.districtCode);
    localStringBuilder.append("distance: ");
    localStringBuilder.append(this.distance);
    localStringBuilder.append("phoneNumber: ");
    localStringBuilder.append(this.phoneNumber);
    localStringBuilder.append("poiOrderType: ");
    localStringBuilder.append(this.poiOrderType);
    localStringBuilder.append("poiNum: ");
    localStringBuilder.append(this.poiNum);
    localStringBuilder.append(" dianPingId:");
    localStringBuilder.append(this.dianPingId);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.poiId);
    paramParcel.writeString(this.poiName);
    paramParcel.writeInt(this.poiType);
    paramParcel.writeString(this.poiTypeName);
    paramParcel.writeString(this.poiDefaultName);
    paramParcel.writeString(this.address);
    paramParcel.writeInt(this.districtCode);
    paramParcel.writeInt(this.distance);
    paramParcel.writeInt(this.hotValue);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeInt(this.poiOrderType);
    paramParcel.writeInt(this.poiNum);
    paramParcel.writeString(this.dianPingId);
    paramParcel.writeParcelable(this.gpsInfo, paramInt);
    paramParcel.writeInt(this.show_poi);
    paramParcel.writeString(this.country);
    paramParcel.writeString(this.province);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.district);
    paramParcel.writeByte((byte)this.isRecomm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.PoiInfo
 * JD-Core Version:    0.7.0.1
 */