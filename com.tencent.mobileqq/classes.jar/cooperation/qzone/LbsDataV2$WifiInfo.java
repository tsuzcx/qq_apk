package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LbsDataV2$WifiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WifiInfo> CREATOR = new LbsDataV2.WifiInfo.1();
  public String mac = "";
  public int rssi = 0;
  
  public LbsDataV2$WifiInfo() {}
  
  public LbsDataV2$WifiInfo(String paramString, int paramInt)
  {
    this.mac = paramString;
    this.rssi = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WifiInfo [mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(this.rssi);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mac);
    paramParcel.writeInt(this.rssi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.WifiInfo
 * JD-Core Version:    0.7.0.1
 */