package cooperation.qzone.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhgc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class BroadcastUrl
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastUrl> CREATOR = new bhgc();
  public Map<Byte, String> mapBroadcastUrl;
  
  public BroadcastUrl() {}
  
  public BroadcastUrl(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (j > 0)
    {
      if (this.mapBroadcastUrl == null) {
        this.mapBroadcastUrl = new HashMap();
      }
      int i = 0;
      while (i < j)
      {
        byte b = paramParcel.readByte();
        String str = paramParcel.readString();
        this.mapBroadcastUrl.put(Byte.valueOf(b), str);
        i += 1;
      }
    }
  }
  
  public static BroadcastUrl createFromJce(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl paramBroadcastUrl)
  {
    BroadcastUrl localBroadcastUrl = new BroadcastUrl();
    localBroadcastUrl.mapBroadcastUrl = paramBroadcastUrl.mapBroadcastUrl;
    return localBroadcastUrl;
  }
  
  public static BroadcastUrl createFromJsonString(String paramString)
  {
    localBroadcastUrl = new BroadcastUrl();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastUrl.mapBroadcastUrl = new HashMap();
      paramString = paramString.getJSONObject("mapBroadcastUrl");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        byte b = (byte)Integer.parseInt(str);
        str = paramString.getString(str);
        localBroadcastUrl.mapBroadcastUrl.put(Byte.valueOf(b), str);
      }
      return localBroadcastUrl;
    }
    catch (Exception paramString) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mapBroadcastUrl != null)
    {
      paramParcel.writeInt(this.mapBroadcastUrl.size());
      Iterator localIterator = this.mapBroadcastUrl.keySet().iterator();
      while (localIterator.hasNext())
      {
        Byte localByte = (Byte)localIterator.next();
        paramParcel.writeByte(localByte.byteValue());
        paramParcel.writeString((String)this.mapBroadcastUrl.get(localByte));
      }
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastUrl
 * JD-Core Version:    0.7.0.1
 */