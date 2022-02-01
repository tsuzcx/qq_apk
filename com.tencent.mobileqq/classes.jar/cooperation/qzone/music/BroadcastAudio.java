package cooperation.qzone.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmaa;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastAudio
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastAudio> CREATOR = new bmaa();
  public BroadcastUrl masterUrl;
  public ArrayList<BroadcastUrl> slaveUrl;
  
  public BroadcastAudio() {}
  
  public BroadcastAudio(Parcel paramParcel)
  {
    this.masterUrl = ((BroadcastUrl)paramParcel.readParcelable(BroadcastUrl.class.getClassLoader()));
    this.slaveUrl = paramParcel.readArrayList(BroadcastUrl.class.getClassLoader());
  }
  
  public static BroadcastAudio createFromJce(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio paramBroadcastAudio)
  {
    BroadcastAudio localBroadcastAudio = new BroadcastAudio();
    localBroadcastAudio.masterUrl = BroadcastUrl.createFromJce(paramBroadcastAudio.masterUrl);
    localBroadcastAudio.slaveUrl = new ArrayList();
    if (paramBroadcastAudio.slaveUrl != null)
    {
      paramBroadcastAudio = paramBroadcastAudio.slaveUrl.iterator();
      while (paramBroadcastAudio.hasNext())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.createFromJce((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl)paramBroadcastAudio.next());
        localBroadcastAudio.slaveUrl.add(localBroadcastUrl);
      }
    }
    return localBroadcastAudio;
  }
  
  public static BroadcastAudio createFromJsonString(String paramString)
  {
    localBroadcastAudio = new BroadcastAudio();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastAudio.masterUrl = BroadcastUrl.createFromJsonString(paramString.getString("masterUrl"));
      paramString = paramString.getJSONArray("slaveUrl");
      localBroadcastAudio.slaveUrl = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastUrl localBroadcastUrl = BroadcastUrl.createFromJsonString(paramString.optString(i));
        localBroadcastAudio.slaveUrl.add(localBroadcastUrl);
        i += 1;
      }
      return localBroadcastAudio;
    }
    catch (Exception paramString) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.masterUrl, paramInt);
    paramParcel.writeList(this.slaveUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastAudio
 * JD-Core Version:    0.7.0.1
 */