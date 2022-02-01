package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;

public class ForwardFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ForwardFileInfo> CREATOR = new ForwardFileInfo.1();
  public int a;
  private int b;
  private int c;
  private String d;
  private long e;
  private long f;
  private long g;
  private String h;
  private String i;
  private int j;
  private String k;
  private long l;
  private String m;
  private String n;
  private WeiYunFileInfo o;
  private ArrayList<Long> p;
  private int q;
  
  public ForwardFileInfo()
  {
    a("");
    b("");
    d("");
    b(-1L);
    c("");
    b(this.b);
    e("");
  }
  
  private ForwardFileInfo(Parcel paramParcel)
  {
    b(paramParcel.readInt());
    b(paramParcel.readLong());
    d(paramParcel.readLong());
    a(paramParcel.readString());
    b(paramParcel.readString());
    c(paramParcel.readString());
    c(paramParcel.readInt());
    d(paramParcel.readString());
    a(paramParcel.readLong());
    d(paramParcel.readInt());
    c(paramParcel.readLong());
    e(paramParcel.readString());
    f(paramParcel.readString());
    a(paramParcel.readInt());
    a((WeiYunFileInfo)paramParcel.readParcelable(WeiYunFileInfo.class.getClassLoader()));
    a(paramParcel.readArrayList(Long.class.getClassLoader()));
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    return (i().equals(paramForwardFileInfo.i())) && (j() == paramForwardFileInfo.j()) && (c() == paramForwardFileInfo.c());
  }
  
  public int a()
  {
    return this.q;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.o = paramWeiYunFileInfo;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    this.p = ((ArrayList)localObject);
  }
  
  public long b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void c(String paramString)
  {
    this.i = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.m = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof ForwardFileInfo))) {
      return a((ForwardFileInfo)paramObject);
    }
    return false;
  }
  
  public long f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.n = paramString;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append(j());
    return localStringBuilder.toString().hashCode();
  }
  
  public String i()
  {
    return this.k;
  }
  
  public long j()
  {
    return this.l;
  }
  
  public String k()
  {
    return this.m;
  }
  
  public WeiYunFileInfo l()
  {
    return this.o;
  }
  
  public ArrayList<Long> m()
  {
    if (this.p == null) {
      this.p = new ArrayList();
    }
    return this.p;
  }
  
  public int n()
  {
    return this.j;
  }
  
  public int o()
  {
    return this.c;
  }
  
  public String p()
  {
    return this.n;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], cloudTYpe[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], uniseq[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], uuid[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], fileId[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("], weiYunSrcType[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], uuidTroopFile[");
    localStringBuilder.append(this.m);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(c());
    paramParcel.writeLong(e());
    paramParcel.writeLong(j());
    paramParcel.writeString(d());
    paramParcel.writeString(g());
    paramParcel.writeString(h());
    paramParcel.writeInt(n());
    paramParcel.writeString(i());
    paramParcel.writeLong(b());
    paramParcel.writeInt(o());
    paramParcel.writeLong(f());
    paramParcel.writeString(k());
    paramParcel.writeString(p());
    paramParcel.writeInt(a());
    paramParcel.writeParcelable(l(), paramInt);
    paramParcel.writeList(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.ForwardFileInfo
 * JD-Core Version:    0.7.0.1
 */