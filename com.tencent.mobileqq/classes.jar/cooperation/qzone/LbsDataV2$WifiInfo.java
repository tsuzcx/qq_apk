package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import biyx;

public class LbsDataV2$WifiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WifiInfo> CREATOR = new biyx();
  public String mac = "";
  public int rssi;
  
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
    return "WifiInfo [mac=" + this.mac + ", rssi=" + this.rssi + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mac);
    paramParcel.writeInt(this.rssi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.WifiInfo
 * JD-Core Version:    0.7.0.1
 */