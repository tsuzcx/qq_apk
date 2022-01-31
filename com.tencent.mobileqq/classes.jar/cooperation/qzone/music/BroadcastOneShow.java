package cooperation.qzone.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfwz;
import org.json.JSONObject;

public class BroadcastOneShow
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastOneShow> CREATOR = new bfwz();
  public String bcShowId = "";
  public String bcShowName = "";
  public long endTime;
  public int singerId;
  public String singerName = "";
  public long startTime;
  
  BroadcastOneShow() {}
  
  public BroadcastOneShow(Parcel paramParcel)
  {
    this.bcShowId = paramParcel.readString();
    this.bcShowName = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.singerId = paramParcel.readInt();
    this.singerName = paramParcel.readString();
  }
  
  public static BroadcastOneShow createFromJce(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow paramBroadcastOneShow)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    localBroadcastOneShow.bcShowId = paramBroadcastOneShow.bcShowId;
    localBroadcastOneShow.bcShowName = paramBroadcastOneShow.bcShowName;
    localBroadcastOneShow.startTime = paramBroadcastOneShow.startTime;
    localBroadcastOneShow.endTime = paramBroadcastOneShow.endTime;
    localBroadcastOneShow.singerId = paramBroadcastOneShow.singerId;
    localBroadcastOneShow.singerName = paramBroadcastOneShow.singerName;
    return localBroadcastOneShow;
  }
  
  public static BroadcastOneShow createFromJsonString(String paramString)
  {
    BroadcastOneShow localBroadcastOneShow = new BroadcastOneShow();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastOneShow.bcShowId = paramString.optString("bcShowId");
      localBroadcastOneShow.bcShowName = paramString.optString("bcShowName");
      localBroadcastOneShow.startTime = paramString.optLong("startTime");
      localBroadcastOneShow.endTime = paramString.optLong("endTime");
      localBroadcastOneShow.singerId = paramString.optInt("singerId");
      localBroadcastOneShow.singerName = paramString.optString("singerName");
      return localBroadcastOneShow;
    }
    catch (Exception paramString) {}
    return localBroadcastOneShow;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bcShowId);
    paramParcel.writeString(this.bcShowName);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeInt(this.singerId);
    paramParcel.writeString(this.singerName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastOneShow
 * JD-Core Version:    0.7.0.1
 */