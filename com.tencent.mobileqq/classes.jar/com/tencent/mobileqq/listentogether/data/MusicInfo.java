package com.tencent.mobileqq.listentogether.data;

import amtj;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import auzt;
import avbv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.aio.media.aio_media.Song;

public class MusicInfo
  implements ISong
{
  public static final Parcelable.Creator<MusicInfo> CREATOR = new auzt();
  public int a;
  public long a;
  public String a;
  public List<String> a;
  public long b;
  public String b;
  public List<String> b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  
  public MusicInfo() {}
  
  private MusicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramParcel.readStringList(this.jdField_b_of_type_JavaUtilList);
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilList);
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Long = paramParcel.readLong();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    }
    return 2130840563;
  }
  
  public static MusicInfo a(aio_media.Song paramSong)
  {
    if (paramSong == null) {
      return null;
    }
    MusicInfo localMusicInfo = new MusicInfo();
    localMusicInfo.jdField_a_of_type_JavaLangString = paramSong.str_song_id.get();
    if (paramSong.bytes_name.get() != null)
    {
      localObject1 = paramSong.bytes_name.get().toStringUtf8();
      localMusicInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (paramSong.bytes_sub_title.get() == null) {
        break label149;
      }
    }
    Object localObject2;
    label149:
    for (Object localObject1 = paramSong.bytes_sub_title.get().toStringUtf8();; localObject1 = "")
    {
      localMusicInfo.c = ((String)localObject1);
      localObject1 = paramSong.rpt_bytes_singer.get();
      localMusicInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (localObject1 == null) {
        break label155;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
        localMusicInfo.jdField_a_of_type_JavaUtilList.add(((ByteStringMicro)localObject2).toStringUtf8());
      }
      localObject1 = "";
      break;
    }
    label155:
    localMusicInfo.jdField_b_of_type_JavaUtilList = new ArrayList();
    if (paramSong.rpt_bytes_download_url.get() != null)
    {
      localObject1 = paramSong.rpt_bytes_download_url.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
          localMusicInfo.jdField_b_of_type_JavaUtilList.add(((ByteStringMicro)localObject2).toStringUtf8());
        }
      }
    }
    if (paramSong.bytes_lyric.get() != null)
    {
      localObject1 = paramSong.bytes_lyric.get().toStringUtf8();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((String)localObject1).replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
      }
      localMusicInfo.jdField_d_of_type_JavaLangString = ((String)localObject2);
      if (paramSong.bytes_cover.get() == null) {
        break label387;
      }
    }
    label387:
    for (localObject1 = paramSong.bytes_cover.get().toStringUtf8();; localObject1 = "")
    {
      localMusicInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
      localMusicInfo.jdField_d_of_type_Long = paramSong.uint32_duration.get();
      localMusicInfo.jdField_a_of_type_Int = paramSong.enum_song_source.get();
      localMusicInfo.jdField_e_of_type_Long = paramSong.uint64_sharer_uin.get();
      return localMusicInfo;
      localObject1 = "";
      break;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "QQ音乐";
    }
    return amtj.a(2131706146);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramLong < 0L)) {
      return "";
    }
    if (paramInt == 2) {}
    for (paramQQAppInterface = ContactUtils.getBuddyName(paramQQAppInterface, String.valueOf(paramLong), true);; paramQQAppInterface = ContactUtils.getTroopMemberName(paramQQAppInterface, paramString, String.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic", 2, " getSourceStr() type = " + paramInt + " sessionUin = " + paramString + " shareUin =" + paramLong + " nickName =" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break;
      }
      return "";
    }
    paramString = new StringBuilder();
    paramString.append("来自").append(paramQQAppInterface).append("分享");
    return paramString.toString();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Long < 0L) {
      return 0;
    }
    return (int)this.jdField_a_of_type_Long;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return avbv.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public String d()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MusicInfo)) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(((MusicInfo)paramObject).a())) && (c() == ((MusicInfo)paramObject).c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("SongInfo{id='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", name='").append(this.jdField_b_of_type_JavaLangString).append('\'').append(", subTitle='").append(this.c).append('\'').append(", singers=").append(this.jdField_a_of_type_JavaUtilList).append(", urls='");
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append('\'').append(", lyric='");
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label240;
      }
    }
    label240:
    for (int i = j;; i = this.jdField_d_of_type_JavaLangString.length())
    {
      return i + '\'' + ", album='" + this.jdField_e_of_type_JavaLangString + '\'' + ", seek='" + this.jdField_a_of_type_Long + '\'' + "ms, duration='" + this.jdField_d_of_type_Long + '\'' + ", source='" + this.jdField_a_of_type_Int + '\'' + ", shareUin='" + this.jdField_e_of_type_Long + '\'' + '}';
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilList);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.data.MusicInfo
 * JD-Core Version:    0.7.0.1
 */