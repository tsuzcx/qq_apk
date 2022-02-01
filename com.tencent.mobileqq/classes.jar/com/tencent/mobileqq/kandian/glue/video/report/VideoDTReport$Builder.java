package com.tencent.mobileqq.kandian.glue.video.report;

import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.RIJDtConstant;
import java.util.HashMap;

public class VideoDTReport$Builder
{
  private String a;
  private long b;
  private String c = "";
  private String d = "";
  private String e = "";
  private long f;
  private int g;
  private int h;
  private int i;
  private String j = "";
  private int k;
  private int l;
  private String m;
  private int n;
  private int o = -1;
  
  public static Builder a(VideoPlayParam paramVideoPlayParam)
  {
    Builder localBuilder = new Builder();
    if (paramVideoPlayParam == null) {
      return localBuilder;
    }
    localBuilder.e = paramVideoPlayParam.A;
    localBuilder.c = paramVideoPlayParam.d;
    if (paramVideoPlayParam.D != null)
    {
      localBuilder.b = paramVideoPlayParam.D.mChannelID;
      localBuilder.i = VideoDTReport.a(paramVideoPlayParam.D.videoReportInfo);
      localBuilder.m = paramVideoPlayParam.D.videoReportInfo;
    }
    if (paramVideoPlayParam.z != null)
    {
      localBuilder.d = paramVideoPlayParam.z.e;
      localBuilder.h = paramVideoPlayParam.z.P;
      localBuilder.g = paramVideoPlayParam.z.O;
    }
    return localBuilder;
  }
  
  public static Builder a(VideoInfo paramVideoInfo)
  {
    Builder localBuilder = new Builder();
    if (paramVideoInfo == null) {
      return localBuilder;
    }
    localBuilder.c = paramVideoInfo.b;
    localBuilder.e = paramVideoInfo.q;
    localBuilder.b = 409409L;
    localBuilder.i = VideoDTReport.a(paramVideoInfo.ao);
    localBuilder.d = paramVideoInfo.l;
    localBuilder.h = paramVideoInfo.j();
    localBuilder.g = paramVideoInfo.i();
    localBuilder.m = paramVideoInfo.ao;
    return localBuilder;
  }
  
  private boolean b()
  {
    return (this.m != null) || (this.o > 0);
  }
  
  public Builder a(int paramInt)
  {
    this.o = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.k = i1;
    return this;
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", RIJDtConstant.a);
    localHashMap.put("dt_pgid", VideoDTReport.b(this.a));
    localHashMap.put("channel_id", Long.valueOf(this.b));
    localHashMap.put("vid", VideoDTReport.b(this.c));
    localHashMap.put("rowkey", VideoDTReport.b(this.d));
    localHashMap.put("cid", "");
    localHashMap.put("cmsid", "");
    localHashMap.put("puin", VideoDTReport.b(this.e));
    localHashMap.put("video_height", Integer.valueOf(this.h));
    localHashMap.put("video_width", Integer.valueOf(this.g));
    localHashMap.put("is_short", Integer.valueOf(this.i));
    localHashMap.put("play_sessionid", VideoDTReport.b(this.j));
    localHashMap.put("play_type", Integer.valueOf(this.k));
    localHashMap.put("play_loop_type", Integer.valueOf(this.l));
    localHashMap.put("backend_info", VideoDTReport.b(this.m));
    return localHashMap;
  }
  
  public Builder b(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport.Builder
 * JD-Core Version:    0.7.0.1
 */