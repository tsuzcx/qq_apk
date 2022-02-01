package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LbsDataV2$CellInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CellInfo> CREATOR = new LbsDataV2.CellInfo.1();
  public int cellId = -1;
  public int lac = -1;
  public int mcc = -1;
  public int mnc = -1;
  public int rssi = 0;
  public double stationLat = 0.0D;
  public double stationLon = 0.0D;
  
  public LbsDataV2$CellInfo() {}
  
  public LbsDataV2$CellInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2)
  {
    this.mcc = paramInt1;
    this.mnc = paramInt2;
    this.lac = paramInt3;
    this.cellId = paramInt4;
    this.rssi = paramInt5;
    this.stationLat = paramDouble1;
    this.stationLon = paramDouble2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return this.cellId != -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CellInfo [mcc=");
    localStringBuilder.append(this.mcc);
    localStringBuilder.append(", mnc=");
    localStringBuilder.append(this.mnc);
    localStringBuilder.append(", lac=");
    localStringBuilder.append(this.lac);
    localStringBuilder.append(", cellId=");
    localStringBuilder.append(this.cellId);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(this.rssi);
    localStringBuilder.append(", stationLat=");
    localStringBuilder.append(this.stationLat);
    localStringBuilder.append(", stationLon=");
    localStringBuilder.append(this.stationLon);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mcc);
    paramParcel.writeInt(this.mnc);
    paramParcel.writeInt(this.lac);
    paramParcel.writeInt(this.cellId);
    paramParcel.writeInt(this.rssi);
    paramParcel.writeDouble(this.stationLat);
    paramParcel.writeDouble(this.stationLon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.CellInfo
 * JD-Core Version:    0.7.0.1
 */