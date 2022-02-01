package com.yolo.esports.download.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.open.base.MD5;
import com.tencent.timi.game.utils.DeviceInfoManager;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ObjectsUtil;
import com.yolo.esports.download.util.DownloadUtils;
import java.io.File;

public class DownloadInfo
  implements Parcelable, Comparable<DownloadInfo>
{
  public static final Parcelable.Creator<DownloadInfo> CREATOR = new DownloadInfo.1();
  String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  public long i = 0L;
  public long j;
  public long k;
  public int l;
  public String m;
  public int n;
  public String o;
  public boolean p;
  public int q;
  public String r;
  public String s;
  public long t;
  public long u;
  public int v;
  public int w;
  public String x;
  
  public DownloadInfo()
  {
    this.l = 0;
    this.m = "";
    this.n = 1;
    this.o = "";
    this.p = false;
    this.q = 0;
    this.r = "";
    this.s = "";
    this.t = 0L;
    this.u = 0L;
    this.x = "unknown";
    f();
  }
  
  protected DownloadInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.l = 0;
    this.m = "";
    this.n = 1;
    this.o = "";
    this.p = false;
    this.q = 0;
    this.r = "";
    this.s = "";
    this.t = 0L;
    this.u = 0L;
    this.x = "unknown";
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readLong();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readString();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.p = bool;
    this.q = paramParcel.readInt();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.t = paramParcel.readLong();
    this.u = paramParcel.readLong();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.x = paramParcel.readString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return MD5.b(paramString);
  }
  
  private static String c(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(DeviceInfoManager.a().b());
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">genUniqueId ori=");
      localStringBuilder.append(paramString);
      Logger.a("DownloadInfo_", localStringBuilder.toString());
      paramString = MD5.b(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label82:
      break label82;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  private void f()
  {
    if (this.h == 0L) {
      this.h = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty(this.d)) {
      this.d = DownloadUtils.a();
    }
    if (!TextUtils.isEmpty(this.d))
    {
      File localFile = new File(this.d);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" exits:");
      localStringBuilder.append(localFile.exists());
      Logger.a("DownloadInfo_", localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    if ((!TextUtils.isEmpty(this.a)) && (TextUtils.isEmpty(this.s))) {
      this.s = c(this.a);
    }
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    long l1 = this.h;
    long l2 = paramDownloadInfo.h;
    if (l1 > l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = b(this.b);
    }
    g();
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean b()
  {
    if (TextUtils.isEmpty(this.e)) {
      return false;
    }
    return new File(this.e).exists();
  }
  
  public boolean c()
  {
    return (this.q == 4) && (b());
  }
  
  public void d()
  {
    this.s = "";
    a();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return (this.q != 4) || (b());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DownloadInfo)paramObject;
      return (this.f == paramObject.f) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (this.n == paramObject.n) && (this.p == paramObject.p) && (this.q == paramObject.q) && (this.t == paramObject.t) && (this.u == paramObject.u) && (this.v == paramObject.v) && (this.w == paramObject.w) && (ObjectsUtil.a(this.a, paramObject.a)) && (ObjectsUtil.a(this.b, paramObject.b)) && (ObjectsUtil.a(this.c, paramObject.c)) && (ObjectsUtil.a(this.d, paramObject.d)) && (ObjectsUtil.a(this.e, paramObject.e)) && (ObjectsUtil.a(this.g, paramObject.g)) && (ObjectsUtil.a(this.m, paramObject.m)) && (ObjectsUtil.a(this.o, paramObject.o)) && (ObjectsUtil.a(this.r, paramObject.r)) && (ObjectsUtil.a(this.s, paramObject.s)) && (ObjectsUtil.a(this.x, paramObject.x));
    }
    return false;
  }
  
  public int hashCode()
  {
    return ObjectsUtil.a(new Object[] { this.a, this.b, this.c, this.d, this.e, Long.valueOf(this.f), this.g, Long.valueOf(this.h), Long.valueOf(this.i), Long.valueOf(this.j), Long.valueOf(this.k), Integer.valueOf(this.l), this.m, Integer.valueOf(this.n), this.o, Boolean.valueOf(this.p), Integer.valueOf(this.q), this.r, this.s, Long.valueOf(this.t), Long.valueOf(this.u), Integer.valueOf(this.v), Integer.valueOf(this.w), this.x });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadInfo{downloadTicket='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadURL='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", fileMd5='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileAbsPath='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileRootDir='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", costTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", receivedLength=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", totalLength=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", scene='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pauseOnMobile=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", downloadState=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", extraInfo='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uniqueId='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastSaveTimeStamp=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", lastUpdateTimeStamp=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", averageSpeed=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", realTimeSpeed=");
    localStringBuilder.append(this.w);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeLong(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeByte((byte)this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeLong(this.t);
    paramParcel.writeLong(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.w);
    paramParcel.writeString(this.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.common.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */