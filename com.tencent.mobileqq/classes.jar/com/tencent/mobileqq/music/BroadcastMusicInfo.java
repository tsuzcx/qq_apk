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
  public BroadcastAudio a;
  public String a;
  public ArrayList<BroadcastOneShow> a;
  public String b;
  public String c = "";
  
  public BroadcastMusicInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public BroadcastMusicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio = ((BroadcastAudio)paramParcel.readParcelable(BroadcastAudio.class.getClassLoader()));
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(BroadcastOneShow.class.getClassLoader());
  }
  
  public static BroadcastMusicInfo a(BroadcastForQzone paramBroadcastForQzone)
  {
    BroadcastMusicInfo localBroadcastMusicInfo = new BroadcastMusicInfo();
    localBroadcastMusicInfo.jdField_a_of_type_JavaLangString = paramBroadcastForQzone.broadcastID;
    localBroadcastMusicInfo.jdField_b_of_type_JavaLangString = paramBroadcastForQzone.broadcastName;
    localBroadcastMusicInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio = BroadcastAudio.a(paramBroadcastForQzone.broadcastAudioUrl);
    localBroadcastMusicInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramBroadcastForQzone.showList != null)
    {
      paramBroadcastForQzone = paramBroadcastForQzone.showList.iterator();
      while (paramBroadcastForQzone.hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.a((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow)paramBroadcastForQzone.next());
        localBroadcastMusicInfo.jdField_a_of_type_JavaUtilArrayList.add(localBroadcastOneShow);
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
      localBroadcastMusicInfo.jdField_a_of_type_JavaLangString = paramString.optString("broadcastID");
      localBroadcastMusicInfo.jdField_b_of_type_JavaLangString = paramString.optString("broadcastName");
      localBroadcastMusicInfo.c = paramString.optString("detailUrl");
      localBroadcastMusicInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio = BroadcastAudio.a(paramString.getString("broadcastAudioUrl"));
      paramString = paramString.getJSONArray("showList");
      localBroadcastMusicInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.a(paramString.optString(i));
        localBroadcastMusicInfo.jdField_a_of_type_JavaUtilArrayList.add(localBroadcastOneShow);
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = (BroadcastOneShow)((Iterator)localObject).next();
        if (localBroadcastOneShow.jdField_a_of_type_Long > l) {
          return localBroadcastOneShow.jdField_a_of_type_Long;
        }
        if (localBroadcastOneShow.jdField_b_of_type_Long > l) {
          return localBroadcastOneShow.jdField_b_of_type_Long;
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
      localSongInfo.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      localSongInfo.c = a();
      localSongInfo.jdField_b_of_type_Int = 9;
      localSongInfo.f = this.c;
      localSongInfo.jdField_b_of_type_JavaLangString = a(paramBoolean);
      localSongInfo.jdField_a_of_type_ComTencentMobileqqMusicBroadcastMusicInfo = this;
      return localSongInfo;
    }
    catch (Exception localException)
    {
      label57:
      break label57;
    }
    return null;
  }
  
  public String a()
  {
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (BroadcastOneShow)((Iterator)localObject2).next();
        if ((((BroadcastOneShow)localObject1).jdField_a_of_type_Long <= l) && (((BroadcastOneShow)localObject1).jdField_b_of_type_Long > l))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("：");
          ((StringBuilder)localObject2).append(((BroadcastOneShow)localObject1).jdField_b_of_type_JavaLangString);
          localObject1 = ((StringBuilder)localObject2).toString();
          break label111;
        }
      }
    }
    localObject1 = "";
    label111:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131701425);
    }
    return localObject2;
  }
  
  public String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio.a.a.get(Byte.valueOf((byte)0));
    }
    return (String)this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio.a.a.get(Byte.valueOf((byte)1));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqMusicBroadcastAudio, paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.BroadcastMusicInfo
 * JD-Core Version:    0.7.0.1
 */