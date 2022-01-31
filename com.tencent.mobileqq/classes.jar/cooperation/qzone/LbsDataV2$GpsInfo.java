package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfpa;

public class LbsDataV2$GpsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GpsInfo> CREATOR = new bfpa();
  public int accuracy;
  public int alt = -10000000;
  public int gpsType = 0;
  public int lat = LbsDataV2.GPS_DEFAULT_VALUE;
  public int lon = LbsDataV2.GPS_DEFAULT_VALUE;
  
  public LbsDataV2$GpsInfo()
  {
    reset();
  }
  
  public LbsDataV2$GpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.lat = paramInt1;
    this.lon = paramInt2;
    this.alt = paramInt3;
    this.gpsType = paramInt4;
    this.accuracy = paramInt5;
  }
  
  public GpsInfo clone()
  {
    return new GpsInfo(this.lat, this.lon, this.alt, this.gpsType, this.accuracy);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return (this.lat != LbsDataV2.GPS_DEFAULT_VALUE) && (this.lon != LbsDataV2.GPS_DEFAULT_VALUE);
  }
  
  public void reset()
  {
    this.lat = LbsDataV2.GPS_DEFAULT_VALUE;
    this.lon = LbsDataV2.GPS_DEFAULT_VALUE;
    this.alt = -10000000;
    this.gpsType = 0;
    this.accuracy = -1;
  }
  
  public String toString()
  {
    return "lat: " + this.lat + ", lon: " + this.lon + ", alt: " + this.alt + ", gpsType: " + this.gpsType + ", accuracy: " + this.accuracy;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.lat);
    paramParcel.writeInt(this.lon);
    paramParcel.writeInt(this.alt);
    paramParcel.writeInt(this.gpsType);
    paramParcel.writeInt(this.accuracy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GpsInfo
 * JD-Core Version:    0.7.0.1
 */