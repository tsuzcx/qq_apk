package com.tencent.mobileqq.kandian.repo.video.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class VideoColumnInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoColumnInfo> CREATOR = new VideoColumnInfo.1();
  public static final String a = "VideoColumnInfo";
  public int b;
  public String c;
  public String d;
  public long e;
  public int f;
  public int g;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public UrlJumpInfo n;
  public UrlJumpInfo o;
  public UrlJumpInfo p;
  public UrlJumpInfo q;
  public int r;
  public String s;
  public String t;
  public int u;
  public int v;
  
  public VideoColumnInfo() {}
  
  protected VideoColumnInfo(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.o = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.p = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.q = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.r = paramParcel.readInt();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
  }
  
  public static VideoColumnInfo a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    if ((paramVideoColumnInfo != null) && (paramVideoColumnInfo.has()) && (paramVideoColumnInfo.get() != null))
    {
      VideoColumnInfo localVideoColumnInfo = new VideoColumnInfo();
      localVideoColumnInfo.b = paramVideoColumnInfo.uint32_column_id.get();
      localVideoColumnInfo.c = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_name);
      localVideoColumnInfo.d = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_icon_url);
      localVideoColumnInfo.e = paramVideoColumnInfo.uint64_last_update_time.get();
      localVideoColumnInfo.f = paramVideoColumnInfo.uint32_video_count.get();
      localVideoColumnInfo.g = paramVideoColumnInfo.uint32_subscribe_count.get();
      boolean bool;
      if (paramVideoColumnInfo.uint32_is_subscribed.get() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localVideoColumnInfo.h = bool;
      localVideoColumnInfo.i = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_card_bg_url);
      localVideoColumnInfo.j = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_card_bg_color);
      localVideoColumnInfo.k = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_card_icon_url);
      localVideoColumnInfo.l = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_app_name);
      localVideoColumnInfo.m = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_app_icon_url);
      localVideoColumnInfo.n = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
      localVideoColumnInfo.o = UrlJumpInfo.a(paramVideoColumnInfo.video_jump_info);
      localVideoColumnInfo.p = UrlJumpInfo.a(paramVideoColumnInfo.subscribe_jump_info);
      localVideoColumnInfo.q = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
      localVideoColumnInfo.r = paramVideoColumnInfo.uin32_column_card_bg_style.get();
      localVideoColumnInfo.s = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_from_txt);
      localVideoColumnInfo.t = RIJPBFieldUtils.d(paramVideoColumnInfo.bytes_column_name_color);
      return localVideoColumnInfo;
    }
    return null;
  }
  
  public static List<VideoColumnInfo> a(@NonNull PBRepeatMessageField<articlesummary.VideoColumnInfo> paramPBRepeatMessageField)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramPBRepeatMessageField.size())
    {
      VideoColumnInfo localVideoColumnInfo = a((articlesummary.VideoColumnInfo)paramPBRepeatMessageField.get(i1));
      if (localVideoColumnInfo != null) {
        localArrayList.add(localVideoColumnInfo);
      }
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertArticleInfo(): convertPBToInfo Muilt:");
        localStringBuilder.append(localVideoColumnInfo);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public articlesummary.VideoColumnInfo a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public byte[] b()
  {
    return a().toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoColumnInfo{columnId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", columnName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnIconUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastUpdateTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subscribeCount='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSubscribed='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgUrl=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgColor=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardIconUrl=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", appIconUrl='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", defaultJumpInfo=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", videoJumpInfo=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", subscribeJumpInfo=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", appJumpInfo='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgStyle='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromText='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnNameColor='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnStyle='");
    localStringBuilder.append(this.u);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeParcelable(this.n, paramInt);
    paramParcel.writeParcelable(this.o, paramInt);
    paramParcel.writeParcelable(this.p, paramInt);
    paramParcel.writeParcelable(this.q, paramInt);
    paramParcel.writeInt(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */