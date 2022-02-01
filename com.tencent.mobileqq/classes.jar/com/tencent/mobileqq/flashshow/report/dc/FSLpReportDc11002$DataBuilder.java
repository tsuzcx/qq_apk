package com.tencent.mobileqq.flashshow.report.dc;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;

public class FSLpReportDc11002$DataBuilder
{
  private String A;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private String G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private String R;
  private String S;
  private byte[] T;
  private HashMap<String, String> U = new HashMap();
  private final FeedCloudMeta.StFeed V;
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  private String h;
  private int i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private int o;
  private int p;
  private long q;
  private long r;
  private String s;
  private boolean t = false;
  private int u;
  private int v;
  private int w;
  private int x;
  private String y;
  private long z;
  
  public FSLpReportDc11002$DataBuilder(FeedCloudMeta.StFeed paramStFeed, FSReportBean paramFSReportBean)
  {
    this.V = paramStFeed;
    a(paramFSReportBean);
  }
  
  private void a(FSReportBean paramFSReportBean)
  {
    if (paramFSReportBean != null)
    {
      d(paramFSReportBean.getPageId());
      e(paramFSReportBean.getFromPageId());
      return;
    }
    d("null");
    e("null");
  }
  
  public DataBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public DataBuilder a(long paramLong)
  {
    this.q = paramLong;
    return this;
  }
  
  public DataBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public DataBuilder a(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public DataBuilder a(byte[] paramArrayOfByte)
  {
    this.T = paramArrayOfByte;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public DataBuilder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public DataBuilder b(long paramLong)
  {
    this.r = paramLong;
    return this;
  }
  
  public DataBuilder b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  void b()
  {
    if (this.V == null)
    {
      QLog.e("FSLpReportDc11002", 1, "feed == null");
      return;
    }
    e();
    d();
    c();
  }
  
  public DataBuilder c(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public DataBuilder c(long paramLong)
  {
    this.z = paramLong;
    return this;
  }
  
  public DataBuilder c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  void c()
  {
    if (this.V.video != null)
    {
      h(this.V.video.duration.get());
      String str;
      if (FSReportUtils.b((FeedCloudMeta.StUser)this.V.poster.get())) {
        str = "2";
      } else {
        str = "1";
      }
      f(str);
      i(this.V.video.fileSize.get());
      j(this.V.video.width.get());
      k(this.V.video.height.get());
      l(this.V.video.videoRate.get());
      g(this.V.video.fileId.get());
      h(this.V.video.fileId.get());
      i(this.V.cover.picId.get());
      k(this.V.video.playUrl.get());
      m(this.V.video.playUrl.get());
      n(this.V.cover.picUrl.get());
    }
  }
  
  public DataBuilder d(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public DataBuilder d(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  void d()
  {
    if (TextUtils.isEmpty(a())) {
      a(this.V.poster.id.get());
    }
    b(this.V.id.get());
    c(this.V.poster.id.get());
    j(FSReportUtils.b(this.V));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.V.title.get());
    localStringBuilder.append(this.V.content.get());
    o(localStringBuilder.toString());
    c(System.currentTimeMillis());
    if (this.V.busiReport.has()) {
      a(this.V.busiReport.get().toByteArray());
    }
  }
  
  public DataBuilder e(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public DataBuilder e(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  void e()
  {
    int i1;
    if (this.V.reportInfoForClient.has())
    {
      QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      try
      {
        localStReportInfoForClient.mergeFrom(this.V.reportInfoForClient.get().toByteArray());
        c(localStReportInfoForClient.feedtype1.get());
        d(localStReportInfoForClient.feedtype2.get());
        e(localStReportInfoForClient.feedtype3.get());
        i1 = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0)
    {
      int[] arrayOfInt = FSReportUtils.a(this.V);
      c(arrayOfInt[0]);
      d(arrayOfInt[1]);
    }
  }
  
  public DataBuilder f(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public DataBuilder f(String paramString)
  {
    this.s = paramString;
    return this;
  }
  
  public DataBuilder g(int paramInt)
  {
    this.o = paramInt;
    return this;
  }
  
  public DataBuilder g(String paramString)
  {
    this.y = paramString;
    return this;
  }
  
  public DataBuilder h(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  public DataBuilder h(String paramString)
  {
    this.A = paramString;
    return this;
  }
  
  public DataBuilder i(int paramInt)
  {
    this.u = paramInt;
    return this;
  }
  
  public DataBuilder i(String paramString)
  {
    this.B = paramString;
    return this;
  }
  
  public DataBuilder j(int paramInt)
  {
    this.v = paramInt;
    return this;
  }
  
  public DataBuilder j(String paramString)
  {
    this.C = paramString;
    return this;
  }
  
  public DataBuilder k(int paramInt)
  {
    this.w = paramInt;
    return this;
  }
  
  public DataBuilder k(String paramString)
  {
    this.D = paramString;
    return this;
  }
  
  public DataBuilder l(int paramInt)
  {
    this.x = paramInt;
    return this;
  }
  
  public DataBuilder l(String paramString)
  {
    this.E = paramString;
    return this;
  }
  
  public DataBuilder m(String paramString)
  {
    this.F = paramString;
    return this;
  }
  
  public DataBuilder n(String paramString)
  {
    this.G = paramString;
    return this;
  }
  
  public DataBuilder o(String paramString)
  {
    this.H = paramString;
    return this;
  }
  
  public DataBuilder p(String paramString)
  {
    this.J = paramString;
    return this;
  }
  
  public DataBuilder q(String paramString)
  {
    this.K = paramString;
    return this;
  }
  
  public DataBuilder r(String paramString)
  {
    this.L = paramString;
    return this;
  }
  
  public DataBuilder s(String paramString)
  {
    this.M = paramString;
    return this;
  }
  
  public DataBuilder t(String paramString)
  {
    this.N = paramString;
    return this;
  }
  
  public DataBuilder u(String paramString)
  {
    this.S = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder
 * JD-Core Version:    0.7.0.1
 */