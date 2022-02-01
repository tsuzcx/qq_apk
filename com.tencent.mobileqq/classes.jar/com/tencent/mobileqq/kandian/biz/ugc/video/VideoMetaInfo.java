package com.tencent.mobileqq.kandian.biz.ugc.video;

public class VideoMetaInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  private long e;
  private String f;
  private long g;
  
  private VideoMetaInfo(VideoMetaInfo.Builder paramBuilder)
  {
    this.a = VideoMetaInfo.Builder.a(paramBuilder);
    this.b = VideoMetaInfo.Builder.b(paramBuilder);
    this.c = VideoMetaInfo.Builder.c(paramBuilder);
    this.d = VideoMetaInfo.Builder.d(paramBuilder);
    this.e = VideoMetaInfo.Builder.e(paramBuilder);
    this.f = VideoMetaInfo.Builder.f(paramBuilder);
    this.g = VideoMetaInfo.Builder.g(paramBuilder);
  }
  
  public static VideoMetaInfo.Builder a()
  {
    return new VideoMetaInfo.Builder(null);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public long f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public long h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo
 * JD-Core Version:    0.7.0.1
 */