package cooperation.qzone.model;

import LBS_V2_PROTOCOL.GPS_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import common.config.service.QzoneLbsConfig;

public class GpsInfo4LocalImage
  implements Parcelable
{
  public static final Parcelable.Creator<GpsInfo4LocalImage> CREATOR = new GpsInfo4LocalImage.1();
  public int gpsType;
  public float latitude;
  public float longtitude;
  
  public GpsInfo4LocalImage() {}
  
  public GpsInfo4LocalImage(float paramFloat1, float paramFloat2)
  {
    this.latitude = paramFloat1;
    this.longtitude = paramFloat2;
    this.gpsType = 0;
  }
  
  public GpsInfo4LocalImage(Parcel paramParcel)
  {
    this.latitude = paramParcel.readFloat();
    this.longtitude = paramParcel.readFloat();
  }
  
  public static GpsInfo4LocalImage copyFrom(GpsInfo4LocalImage paramGpsInfo4LocalImage)
  {
    if (paramGpsInfo4LocalImage == null) {
      return null;
    }
    float f = paramGpsInfo4LocalImage.latitude;
    paramGpsInfo4LocalImage = new GpsInfo4LocalImage(f, f);
    paramGpsInfo4LocalImage.gpsType = 0;
    return paramGpsInfo4LocalImage;
  }
  
  public static GpsInfo4LocalImage createFrom(GPS_V2 paramGPS_V2)
  {
    if (paramGPS_V2 == null) {
      return null;
    }
    double d = paramGPS_V2.iLat;
    Double.isNaN(d);
    float f = (float)(d / 1000000.0D);
    d = paramGPS_V2.iLon;
    Double.isNaN(d);
    paramGPS_V2 = new GpsInfo4LocalImage(f, (float)(d / 1000000.0D));
    paramGPS_V2.gpsType = 0;
    return paramGPS_V2;
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = rad(paramDouble1 / 1000000.0D);
    paramDouble3 = rad(paramDouble3 / 1000000.0D);
    paramDouble2 = rad(paramDouble2 / 1000000.0D);
    paramDouble4 = rad(paramDouble4 / 1000000.0D);
    return Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6378.1369999999997D * 1000.0D;
  }
  
  private static double rad(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof GpsInfo4LocalImage)) {
      return false;
    }
    paramObject = (GpsInfo4LocalImage)paramObject;
    boolean bool1 = bool2;
    if (this.gpsType == paramObject.gpsType)
    {
      bool1 = bool2;
      if (getDistance(this.latitude * 1000000.0F, this.longtitude * 1000000.0F, paramObject.latitude * 1000000.0F, paramObject.longtitude * 1000000.0F) <= QzoneLbsConfig.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lat: ");
    localStringBuilder.append(this.latitude);
    localStringBuilder.append(",lon: ");
    localStringBuilder.append(this.longtitude);
    localStringBuilder.append(",alt: ,gpsType: ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.latitude);
    paramParcel.writeFloat(this.longtitude);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.GpsInfo4LocalImage
 * JD-Core Version:    0.7.0.1
 */