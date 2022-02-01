package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class BroadcastUrl
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastUrl> CREATOR = new BroadcastUrl.1();
  public Map<Byte, String> a = null;
  
  public BroadcastUrl() {}
  
  public BroadcastUrl(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (j > 0)
    {
      if (this.a == null) {
        this.a = new HashMap();
      }
      int i = 0;
      while (i < j)
      {
        byte b = paramParcel.readByte();
        String str = paramParcel.readString();
        this.a.put(Byte.valueOf(b), str);
        i += 1;
      }
    }
  }
  
  public static BroadcastUrl a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl paramBroadcastUrl)
  {
    BroadcastUrl localBroadcastUrl = new BroadcastUrl();
    localBroadcastUrl.a = paramBroadcastUrl.mapBroadcastUrl;
    return localBroadcastUrl;
  }
  
  public static BroadcastUrl a(String paramString)
  {
    BroadcastUrl localBroadcastUrl = new BroadcastUrl();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastUrl.a = new HashMap();
      paramString = paramString.getJSONObject("mapBroadcastUrl");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        byte b = (byte)Integer.parseInt(str);
        str = paramString.getString(str);
        localBroadcastUrl.a.put(Byte.valueOf(b), str);
      }
      return localBroadcastUrl;
    }
    catch (Exception paramString) {}
    return localBroadcastUrl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      paramParcel.writeInt(((Map)localObject).size());
      localObject = this.a.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Byte localByte = (Byte)((Iterator)localObject).next();
        paramParcel.writeByte(localByte.byteValue());
        paramParcel.writeString((String)this.a.get(localByte));
      }
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastUrl
 * JD-Core Version:    0.7.0.1
 */