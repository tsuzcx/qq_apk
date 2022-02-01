package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;

public final class IteApkInfoReq$Builder
{
  public String Fh = "";
  public String ig = "";
  public String jg = "";
  public long kg = 0L;
  public String mg = "";
  public String ng = "";
  public String og = "";
  public int pg = 0;
  public ArrayList<String> qg;
  public String rg = "";
  public ArrayList<String> sg;
  public ArrayList<String> tg;
  
  public final Builder apkFrom(int paramInt)
  {
    this.pg = paramInt;
    return this;
  }
  
  public IteApkInfoReq build()
  {
    return new IteApkInfoReq(this, null);
  }
  
  public final Builder certMd5(String paramString)
  {
    this.jg = paramString;
    return this;
  }
  
  public final Builder chatContent(ArrayList<String> paramArrayList)
  {
    this.qg = paramArrayList;
    return this;
  }
  
  public final Builder chattingQQ(ArrayList<String> paramArrayList)
  {
    this.sg = paramArrayList;
    return this;
  }
  
  public final Builder chattingRoomQQ(ArrayList<String> paramArrayList)
  {
    this.tg = paramArrayList;
    return this;
  }
  
  public final Builder fileFieleId(String paramString)
  {
    this.Fh = paramString;
    return this;
  }
  
  public final Builder fileMd5(String paramString)
  {
    this.ng = paramString;
    return this;
  }
  
  public final Builder fileName(String paramString)
  {
    this.og = paramString;
    return this;
  }
  
  public final Builder fileSha1(String paramString)
  {
    this.mg = paramString;
    return this;
  }
  
  public final Builder fileSize(long paramLong)
  {
    this.kg = paramLong;
    return this;
  }
  
  public final Builder localQQ(String paramString)
  {
    this.rg = paramString;
    return this;
  }
  
  public final Builder pkgName(String paramString)
  {
    this.ig = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.IteApkInfoReq.Builder
 * JD-Core Version:    0.7.0.1
 */