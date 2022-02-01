package cooperation.qzone.model;

import LBS_V2_PROTOCOL.GPS_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bkzd;
import blze;

public class GpsInfo4LocalImage
  implements Parcelable
{
  public static final Parcelable.Creator<GpsInfo4LocalImage> CREATOR = new blze();
  public float a;
  public int a;
  public float b;
  
  public GpsInfo4LocalImage() {}
  
  public GpsInfo4LocalImage(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_Int = 0;
  }
  
  public GpsInfo4LocalImage(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1 / 1000000.0D);
    paramDouble3 = a(paramDouble3 / 1000000.0D);
    paramDouble2 = a(paramDouble2 / 1000000.0D);
    paramDouble4 = a(paramDouble4 / 1000000.0D);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 1000.0D;
  }
  
  public static GpsInfo4LocalImage a(GPS_V2 paramGPS_V2)
  {
    if (paramGPS_V2 == null) {
      return null;
    }
    paramGPS_V2 = new GpsInfo4LocalImage((float)(paramGPS_V2.iLat / 1000000.0D), (float)(paramGPS_V2.iLon / 1000000.0D));
    paramGPS_V2.jdField_a_of_type_Int = 0;
    return paramGPS_V2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof GpsInfo4LocalImage));
    paramObject = (GpsInfo4LocalImage)paramObject;
    if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (a(this.jdField_a_of_type_Float * 1000000.0F, this.b * 1000000.0F, paramObject.jdField_a_of_type_Float * 1000000.0F, paramObject.b * 1000000.0F) <= bkzd.a().a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    return "lat: " + this.jdField_a_of_type_Float + ",lon: " + this.b + ",alt: ,gpsType: ";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.GpsInfo4LocalImage
 * JD-Core Version:    0.7.0.1
 */