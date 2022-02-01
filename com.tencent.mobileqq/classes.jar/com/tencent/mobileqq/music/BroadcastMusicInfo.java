package com.tencent.mobileqq.music;

import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastMusicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastMusicInfo> CREATOR = new BroadcastMusicInfo.1();
  public String a = "";
  public String b = "";
  public String c = "";
  public BroadcastAudio d = null;
  public ArrayList<BroadcastOneShow> e = null;
  
  public BroadcastMusicInfo() {}
  
  public BroadcastMusicInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((BroadcastAudio)paramParcel.readParcelable(BroadcastAudio.class.getClassLoader()));
    this.e = paramParcel.readArrayList(BroadcastOneShow.class.getClassLoader());
  }
  
  public static BroadcastMusicInfo a(BroadcastForQzone paramBroadcastForQzone)
  {
    BroadcastMusicInfo localBroadcastMusicInfo = new BroadcastMusicInfo();
    localBroadcastMusicInfo.a = paramBroadcastForQzone.broadcastID;
    localBroadcastMusicInfo.b = paramBroadcastForQzone.broadcastName;
    localBroadcastMusicInfo.d = BroadcastAudio.a(paramBroadcastForQzone.broadcastAudioUrl);
    localBroadcastMusicInfo.e = new ArrayList();
    if (paramBroadcastForQzone.showList != null)
    {
      paramBroadcastForQzone = paramBroadcastForQzone.showList.iterator();
      while (paramBroadcastForQzone.hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.a((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow)paramBroadcastForQzone.next());
        localBroadcastMusicInfo.e.add(localBroadcastOneShow);
      }
    }
    return localBroadcastMusicInfo;
  }
  
  public static BroadcastMusicInfo a(String paramString)
  {
    BroadcastMusicInfo localBroadcastMusicInfo = new BroadcastMusicInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastMusicInfo.a = paramString.optString("broadcastID");
      localBroadcastMusicInfo.b = paramString.optString("broadcastName");
      localBroadcastMusicInfo.c = paramString.optString("detailUrl");
      localBroadcastMusicInfo.d = BroadcastAudio.a(paramString.getString("broadcastAudioUrl"));
      paramString = paramString.getJSONArray("showList");
      localBroadcastMusicInfo.e = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.a(paramString.optString(i));
        localBroadcastMusicInfo.e.add(localBroadcastOneShow);
        i += 1;
      }
      return localBroadcastMusicInfo;
    }
    catch (Exception paramString) {}
    return localBroadcastMusicInfo;
  }
  
  public static List<SongInfo> a(List<BroadcastMusicInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SongInfo localSongInfo = ((BroadcastMusicInfo)paramList.next()).a(paramBoolean);
        if (localSongInfo != null) {
          localArrayList.add(localSongInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public long a()
  {
    long l = System.currentTimeMillis() / 1000L;
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = (BroadcastOneShow)((Iterator)localObject).next();
        if (localBroadcastOneShow.c > l) {
          return localBroadcastOneShow.c;
        }
        if (localBroadcastOneShow.d > l) {
          return localBroadcastOneShow.d;
        }
      }
    }
    return -1L;
  }
  
  public SongInfo a(boolean paramBoolean)
  {
    SongInfo localSongInfo = new SongInfo();
    try
    {
      localSongInfo.a = Long.parseLong(this.a);
      localSongInfo.e = b();
      localSongInfo.m = 9;
      localSongInfo.h = this.c;
      localSongInfo.d = b(paramBoolean);
      localSongInfo.o = this;
      return localSongInfo;
    }
    catch (Exception localException)
    {
      label57:
      break label57;
    }
    return null;
  }
  
  public String b()
  {
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (BroadcastOneShow)((Iterator)localObject2).next();
        if ((((BroadcastOneShow)localObject1).c <= l) && (((BroadcastOneShow)localObject1).d > l))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append("：");
          ((StringBuilder)localObject2).append(((BroadcastOneShow)localObject1).b);
          localObject1 = ((StringBuilder)localObject2).toString();
          break label111;
        }
      }
    }
    localObject1 = "";
    label111:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131899450);
    }
    return localObject2;
  }
  
  public String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return (String)this.d.a.a.get(Byte.valueOf((byte)0));
    }
    return (String)this.d.a.a.get(Byte.valueOf((byte)1));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, paramInt);
    paramParcel.writeList(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastMusicInfo
 * JD-Core Version:    0.7.0.1
 */