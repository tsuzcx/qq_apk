package cooperation.qzone.statistic.serverip;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WebAppIpRecord$1
  implements Parcelable.Creator<WebAppIpRecord>
{
  public WebAppIpRecord createFromParcel(Parcel paramParcel)
  {
    return new WebAppIpRecord(paramParcel);
  }
  
  public WebAppIpRecord[] newArray(int paramInt)
  {
    return new WebAppIpRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord.1
 * JD-Core Version:    0.7.0.1
 */