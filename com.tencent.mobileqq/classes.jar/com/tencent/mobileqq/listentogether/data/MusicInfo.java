package com.tencent.mobileqq.listentogether.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.player.IConst.Caller;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader;
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
  implements ISong, IConst.Caller
{
  public static final Parcelable.Creator<MusicInfo> CREATOR = new MusicInfo.1();
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
    if (paramInt != 1)
    {
      if (paramInt != 2) {}
      return 0;
    }
    return 2130840608;
  }
  
  public static MusicInfo a(aio_media.Song paramSong)
  {
    if (paramSong == null) {
      return null;
    }
    MusicInfo localMusicInfo = new MusicInfo();
    localMusicInfo.jdField_a_of_type_JavaLangString = paramSong.str_song_id.get();
    Object localObject1 = paramSong.bytes_name.get();
    String str = "";
    if (localObject1 != null) {
      localObject1 = paramSong.bytes_name.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    localMusicInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
    if (paramSong.bytes_sub_title.get() != null) {
      localObject1 = paramSong.bytes_sub_title.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    localMusicInfo.c = ((String)localObject1);
    localObject1 = paramSong.rpt_bytes_singer.get();
    localMusicInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
        localMusicInfo.jdField_a_of_type_JavaUtilList.add(((ByteStringMicro)localObject2).toStringUtf8());
      }
    }
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
    if (paramSong.bytes_lyric.get() != null) {
      localObject1 = paramSong.bytes_lyric.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = ((String)localObject1).replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }
    localMusicInfo.jdField_d_of_type_JavaLangString = ((String)localObject2);
    localObject1 = str;
    if (paramSong.bytes_cover.get() != null) {
      localObject1 = paramSong.bytes_cover.get().toStringUtf8();
    }
    localMusicInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
    localMusicInfo.jdField_d_of_type_Long = paramSong.uint32_duration.get();
    localMusicInfo.jdField_a_of_type_Int = paramSong.enum_song_source.get();
    localMusicInfo.jdField_e_of_type_Long = paramSong.uint64_sharer_uin.get();
    return localMusicInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "";
      }
      return HardCodeUtil.a(2131707061);
    }
    return "QQ音乐";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      if (paramLong < 0L) {
        return "";
      }
      if (paramInt == 2) {
        paramQQAppInterface = ContactUtils.a(paramQQAppInterface, String.valueOf(paramLong), true);
      } else {
        paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString, String.valueOf(paramLong));
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" getSourceStr() type = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" sessionUin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" shareUin =");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" nickName =");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("AioShareMusic", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return "";
      }
      paramString = new StringBuilder();
      paramString.append("来自");
      paramString.append(paramQQAppInterface);
      paramString.append("分享");
      return paramString.toString();
    }
    return "";
  }
  
  public int a()
  {
    long l = this.jdField_a_of_type_Long;
    if (l < 0L) {
      return 0;
    }
    return (int)l;
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
    List localList = this.jdField_b_of_type_JavaUtilList;
    return (localList != null) && (!localList.isEmpty());
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
    return ListenTogetherResDownloader.a(this.jdField_a_of_type_JavaLangString);
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
    boolean bool1 = paramObject instanceof MusicInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      paramObject = (MusicInfo)paramObject;
      bool1 = bool2;
      if (str.equals(paramObject.a()))
      {
        bool1 = bool2;
        if (c() == paramObject.c()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SongInfo{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singers=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", urls='");
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    localStringBuilder.append(i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lyric='");
    localObject = this.jdField_d_of_type_JavaLangString;
    if (localObject == null) {
      i = j;
    } else {
      i = ((String)localObject).length();
    }
    localStringBuilder.append(i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", album='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seek='");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append("ms, duration='");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUin='");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.data.MusicInfo
 * JD-Core Version:    0.7.0.1
 */