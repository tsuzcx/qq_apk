package com.tencent.mobileqq.teamwork.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new TeamWorkFileImportInfo.1();
  public String A;
  public int B;
  public int C;
  public String D;
  public int E;
  public String F;
  public String G;
  public String H;
  public boolean I;
  public int J;
  public long K;
  public long L;
  public String M;
  public int N;
  public int O;
  public String P;
  public int a = -1;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public String g;
  public int h;
  public int i;
  public String j;
  public String k;
  public long l;
  public boolean m;
  public int n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  public boolean t;
  public int u;
  public String v;
  public int w;
  public String x;
  public String y;
  public String z;
  
  public TeamWorkFileImportInfo()
  {
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = false;
    this.v = "";
  }
  
  protected TeamWorkFileImportInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = false;
    this.v = "";
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    this.n = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.o = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.p = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.q = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.r = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.t = bool1;
    this.u = paramParcel.readInt();
    this.v = paramParcel.readString();
    this.w = paramParcel.readInt();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
    this.z = paramParcel.readString();
    this.A = paramParcel.readString();
    this.B = paramParcel.readInt();
    this.C = paramParcel.readInt();
    this.D = paramParcel.readString();
    this.E = paramParcel.readInt();
    this.J = paramParcel.readInt();
    this.K = paramParcel.readLong();
    this.L = paramParcel.readLong();
    this.M = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readLong();
    this.O = paramParcel.readInt();
    this.P = paramParcel.readString();
    this.G = paramParcel.readString();
    this.H = paramParcel.readString();
  }
  
  public boolean a()
  {
    return this.n == 8;
  }
  
  public boolean b()
  {
    return this.n == 11;
  }
  
  public boolean c()
  {
    return this.n == 13;
  }
  
  public boolean d()
  {
    return this.n == 7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TeamWorkFileImportInfo{peerType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", peerUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgUniseq=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", nSessionId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", troopFilePath='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopFileBusId=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", troopUin='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isNeedDownLoadUrl=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", entranceFrom=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", isFromAIO=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", isFromDataLine=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", isOpenTeamWork=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", isUserClick=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", isMessageConvert=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", nFileType=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", folderId='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", retCode=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", errorString='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redirectUrl='");
    localStringBuilder.append(this.y);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSendUin='");
    localStringBuilder.append(this.z);
    localStringBuilder.append('\'');
    localStringBuilder.append(", traceId='");
    localStringBuilder.append(this.A);
    localStringBuilder.append('\'');
    localStringBuilder.append(", importOption=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", urlType=");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", fileid='");
    localStringBuilder.append(this.D);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filetype=");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", fileImportType=");
    localStringBuilder.append(this.J);
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.K);
    localStringBuilder.append(", structUniseq=");
    localStringBuilder.append(this.L);
    localStringBuilder.append(", editedUrl='");
    localStringBuilder.append(this.M);
    localStringBuilder.append('\'');
    localStringBuilder.append(", srcUrl='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeByte((byte)this.o);
    paramParcel.writeByte((byte)this.p);
    paramParcel.writeByte((byte)this.q);
    paramParcel.writeByte((byte)this.r);
    paramParcel.writeByte((byte)this.s);
    paramParcel.writeByte((byte)this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeInt(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeInt(this.B);
    paramParcel.writeInt(this.C);
    paramParcel.writeString(this.D);
    paramParcel.writeInt(this.E);
    paramParcel.writeInt(this.J);
    paramParcel.writeLong(this.K);
    paramParcel.writeLong(this.L);
    paramParcel.writeString(this.M);
    paramParcel.writeString(this.k);
    paramParcel.writeLong(this.l);
    paramParcel.writeInt(this.O);
    paramParcel.writeString(this.P);
    paramParcel.writeString(this.G);
    paramParcel.writeString(this.H);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */