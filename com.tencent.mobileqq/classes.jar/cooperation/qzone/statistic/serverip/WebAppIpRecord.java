package cooperation.qzone.statistic.serverip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebAppIpRecord
  implements Parcelable
{
  public static final Parcelable.Creator<WebAppIpRecord> CREATOR = new WebAppIpRecord.1();
  public long serverChangeTime;
  public WebAppIpRecord.FixedSizeLinkedHashMap<Integer, Long> serverIpMap;
  
  public WebAppIpRecord() {}
  
  public WebAppIpRecord(Parcel paramParcel)
  {
    this.serverChangeTime = paramParcel.readLong();
    paramParcel = paramParcel.readHashMap(getClass().getClassLoader());
    this.serverIpMap = new WebAppIpRecord.FixedSizeLinkedHashMap();
    this.serverIpMap.putAll(paramParcel);
  }
  
  public void addIpAdress(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (this.serverIpMap == null) {
      this.serverIpMap = new WebAppIpRecord.FixedSizeLinkedHashMap();
    }
    this.serverIpMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.serverChangeTime);
    paramParcel.writeMap(this.serverIpMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord
 * JD-Core Version:    0.7.0.1
 */