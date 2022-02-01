package com.tencent.mobileqq.tts.data;

public class TtsNetStreamParam$Builder
{
  private String a;
  private Long b;
  private Long c;
  private String d;
  private String e;
  private String f;
  private int g;
  private int h;
  private String i;
  
  public Builder a(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.b = Long.valueOf(paramLong);
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public TtsNetStreamParam a()
  {
    TtsNetStreamParam localTtsNetStreamParam = new TtsNetStreamParam();
    localTtsNetStreamParam.appId = this.a;
    localTtsNetStreamParam.uin = this.b;
    localTtsNetStreamParam.sendUin = this.c;
    localTtsNetStreamParam.text = this.d;
    localTtsNetStreamParam.textMd5 = this.e;
    localTtsNetStreamParam.seq = Long.valueOf(TtsNetStreamParam.access$008());
    localTtsNetStreamParam.clientVersion = this.f;
    localTtsNetStreamParam.net = this.g;
    localTtsNetStreamParam.businessID = this.h;
    localTtsNetStreamParam.sKey = this.i;
    return localTtsNetStreamParam;
  }
  
  public Builder b(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.c = Long.valueOf(paramLong);
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsNetStreamParam.Builder
 * JD-Core Version:    0.7.0.1
 */