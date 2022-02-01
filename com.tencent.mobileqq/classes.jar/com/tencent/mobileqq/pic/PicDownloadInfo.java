package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

public class PicDownloadInfo
  extends PicBaseInfo
{
  public long A;
  public String B;
  public int C;
  public String D;
  public int E;
  public ReportInfo F;
  public boolean G = false;
  public String n;
  public long o;
  public String p;
  public String q;
  public String r;
  public String s;
  public int t;
  public long u;
  public int v;
  public long w;
  public boolean x;
  public boolean y;
  public String z;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicDownloadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("groupFileID:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uinType:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("subMsgId:");
    localStringBuilder.append(this.C);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("subVersion:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("protocol:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSizeFlag:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbMsgUrl:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("bigthumbMsgUrl:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("bigMsgUrl:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rawMsgUrl:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isMixed:");
    localStringBuilder.append(this.x);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("shareAppID:");
    localStringBuilder.append(this.A);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("action:");
    localStringBuilder.append(this.z);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("actMsgContentValue:");
    localStringBuilder.append(this.y);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("picExtraFlag:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("picExtraObject:");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.n))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uuid invaid:");
      localStringBuilder.append(this.n);
      a("PicDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.d == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("selfUin invalid,selfUin:");
      localStringBuilder.append(this.d);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if ((this.x) && (this.A == 0L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupFileID invaid:");
      localStringBuilder.append(this.A);
      a("PicDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    return super.b();
  }
  
  String c()
  {
    boolean bool = "chatthumb".equals(this.l);
    int i = 65537;
    if (!bool) {
      if ("chatimg".equals(this.l)) {
        i = 1;
      } else if ("chatraw".equals(this.l)) {
        i = 131075;
      }
    }
    Object localObject;
    if (this.k)
    {
      localObject = new PicUploadInfo();
      ((PicUploadInfo)localObject).c = this.c;
      ((PicUploadInfo)localObject).j = this.j;
      ((PicUploadInfo)localObject).a = this.a;
      ((PicUploadInfo)localObject).m = this.m;
      localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((PicUploadInfo)localObject, i, null);
      if (localObject != null) {
        return ((URL)localObject).toString();
      }
    }
    else
    {
      localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(this, i, null);
      if (localObject != null) {
        return ((URL)localObject).toString();
      }
    }
    return null;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f());
    localStringBuilder.append("_dp");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicDownloadInfo
 * JD-Core Version:    0.7.0.1
 */