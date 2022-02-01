package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastAudio
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastAudio> CREATOR = new BroadcastAudio.1();
  public BroadcastUrl a = null;
  public ArrayList<BroadcastUrl> b = null;
  
  public BroadcastAudio() {}
  
  public BroadcastAudio(Parcel paramParcel)
  {
    this.a = ((BroadcastUrl)paramParcel.readParcelable(BroadcastUrl.class.getClassLoader()));
    this.b = paramParcel.readArrayList(BroadcastUrl.class.getClassLoader());
  }
  
  public static BroadcastAudio a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio paramBroadcastAudio)
  {
    BroadcastAudio localBroadcastAudio = new BroadcastAudio();
    localBroadcastAudio.a = BroadcastUrl.a(paramBroadcastAudio.masterUrl);
    localBroadcastAudio.b = new ArrayList();
    if (paramBroadcastAudio.slaveUrl != null)
    {
      paramBroadcastAudio = paramBroadcastAudio.slaveUrl.iterator();
      while (paramBroadcastAudio.hasNext())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.a((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl)paramBroadcastAudio.next());
        localBroadcastAudio.b.add(localBroadcastUrl);
      }
    }
    return localBroadcastAudio;
  }
  
  public static BroadcastAudio a(String paramString)
  {
    BroadcastAudio localBroadcastAudio = new BroadcastAudio();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastAudio.a = BroadcastUrl.a(paramString.getString("masterUrl"));
      paramString = paramString.getJSONArray("slaveUrl");
      localBroadcastAudio.b = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.a(paramString.optString(i));
        localBroadcastAudio.b.add(localBroadcastUrl);
        i += 1;
      }
      return localBroadcastAudio;
    }
    catch (Exception paramString) {}
    return localBroadcastAudio;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeList(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastAudio
 * JD-Core Version:    0.7.0.1
 */