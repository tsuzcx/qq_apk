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
  public String a;
  public String b;
  public String c;
  public List<String> d;
  public List<String> e;
  public String f;
  public String g;
  public long h;
  public long i;
  public long j;
  public long k;
  public int l;
  public long m;
  
  public MusicInfo() {}
  
  private MusicInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.e = new ArrayList();
    paramParcel.readStringList(this.e);
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.d = new ArrayList();
    paramParcel.readStringList(this.d);
    this.k = paramParcel.readLong();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readLong();
  }
  
  public static MusicInfo a(aio_media.Song paramSong)
  {
    if (paramSong == null) {
      return null;
    }
    MusicInfo localMusicInfo = new MusicInfo();
    localMusicInfo.a = paramSong.str_song_id.get();
    Object localObject1 = paramSong.bytes_name.get();
    String str = "";
    if (localObject1 != null) {
      localObject1 = paramSong.bytes_name.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    localMusicInfo.b = ((String)localObject1);
    if (paramSong.bytes_sub_title.get() != null) {
      localObject1 = paramSong.bytes_sub_title.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    localMusicInfo.c = ((String)localObject1);
    localObject1 = paramSong.rpt_bytes_singer.get();
    localMusicInfo.d = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
        localMusicInfo.d.add(((ByteStringMicro)localObject2).toStringUtf8());
      }
    }
    localMusicInfo.e = new ArrayList();
    if (paramSong.rpt_bytes_download_url.get() != null)
    {
      localObject1 = paramSong.rpt_bytes_download_url.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
          localMusicInfo.e.add(((ByteStringMicro)localObject2).toStringUtf8());
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
    localMusicInfo.f = ((String)localObject2);
    localObject1 = str;
    if (paramSong.bytes_cover.get() != null) {
      localObject1 = paramSong.bytes_cover.get().toStringUtf8();
    }
    localMusicInfo.g = ((String)localObject1);
    localMusicInfo.k = paramSong.uint32_duration.get();
    localMusicInfo.l = paramSong.enum_song_source.get();
    localMusicInfo.m = paramSong.uint64_sharer_uin.get();
    return localMusicInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "";
      }
      return HardCodeUtil.a(2131904901);
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
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {}
      return 0;
    }
    return 2130841381;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public List<String> c()
  {
    return this.e;
  }
  
  public String d()
  {
    return ListenTogetherResDownloader.b(this.a);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    long l1 = this.h;
    if (l1 < 0L) {
      return 0;
    }
    return (int)l1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MusicInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(this.a))
    {
      String str = this.a;
      paramObject = (MusicInfo)paramObject;
      bool1 = bool2;
      if (str.equals(paramObject.a()))
      {
        bool1 = bool2;
        if (i() == paramObject.i()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public long h()
  {
    return this.m;
  }
  
  public int i()
  {
    return 1;
  }
  
  public boolean j()
  {
    List localList = this.e;
    return (localList != null) && (!localList.isEmpty());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SongInfo{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singers=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", urls='");
    Object localObject = this.e;
    int i1 = 0;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((List)localObject).size();
    }
    localStringBuilder.append(n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lyric='");
    localObject = this.f;
    if (localObject == null) {
      n = i1;
    } else {
      n = ((String)localObject).length();
    }
    localStringBuilder.append(n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", album='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seek='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append("ms, duration='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUin='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeStringList(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeStringList(this.d);
    paramParcel.writeLong(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeLong(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.data.MusicInfo
 * JD-Core Version:    0.7.0.1
 */