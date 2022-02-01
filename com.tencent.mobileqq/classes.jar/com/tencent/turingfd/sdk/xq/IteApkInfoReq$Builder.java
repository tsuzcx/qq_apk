package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;

public final class IteApkInfoReq$Builder
{
  public String a = "";
  public String b = "";
  public long c = 0L;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 0;
  public ArrayList<String> i;
  public String j = "";
  public ArrayList<String> k;
  public ArrayList<String> l;
  
  public final Builder apkFrom(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public IteApkInfoReq build()
  {
    return new IteApkInfoReq(this);
  }
  
  public final Builder certMd5(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final Builder chatContent(ArrayList<String> paramArrayList)
  {
    this.i = paramArrayList;
    return this;
  }
  
  public final Builder chattingQQ(ArrayList<String> paramArrayList)
  {
    this.k = paramArrayList;
    return this;
  }
  
  public final Builder chattingRoomQQ(ArrayList<String> paramArrayList)
  {
    this.l = paramArrayList;
    return this;
  }
  
  public final Builder fileFieleId(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public final Builder fileMd5(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public final Builder fileName(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public final Builder fileSha1(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public final Builder fileSize(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public final Builder localQQ(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final Builder pkgName(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.IteApkInfoReq.Builder
 * JD-Core Version:    0.7.0.1
 */