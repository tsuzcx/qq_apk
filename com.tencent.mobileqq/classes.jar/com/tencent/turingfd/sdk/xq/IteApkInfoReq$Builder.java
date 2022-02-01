package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;

public final class IteApkInfoReq$Builder
{
  public String Cg = "";
  public String Dg = "";
  public long Eg = 0L;
  public String Gg = "";
  public String Hg = "";
  public String Ig = "";
  public int Jg = 0;
  public ArrayList<String> Kg;
  public String Lg = "";
  public ArrayList<String> Mg;
  public ArrayList<String> Ng;
  public String yi = "";
  
  public final Builder apkFrom(int paramInt)
  {
    this.Jg = paramInt;
    return this;
  }
  
  public IteApkInfoReq build()
  {
    return new IteApkInfoReq(this, null);
  }
  
  public final Builder certMd5(String paramString)
  {
    this.Dg = paramString;
    return this;
  }
  
  public final Builder chatContent(ArrayList<String> paramArrayList)
  {
    this.Kg = paramArrayList;
    return this;
  }
  
  public final Builder chattingQQ(ArrayList<String> paramArrayList)
  {
    this.Mg = paramArrayList;
    return this;
  }
  
  public final Builder chattingRoomQQ(ArrayList<String> paramArrayList)
  {
    this.Ng = paramArrayList;
    return this;
  }
  
  public final Builder fileFieleId(String paramString)
  {
    this.yi = paramString;
    return this;
  }
  
  public final Builder fileMd5(String paramString)
  {
    this.Hg = paramString;
    return this;
  }
  
  public final Builder fileName(String paramString)
  {
    this.Ig = paramString;
    return this;
  }
  
  public final Builder fileSha1(String paramString)
  {
    this.Gg = paramString;
    return this;
  }
  
  public final Builder fileSize(long paramLong)
  {
    this.Eg = paramLong;
    return this;
  }
  
  public final Builder localQQ(String paramString)
  {
    this.Lg = paramString;
    return this;
  }
  
  public final Builder pkgName(String paramString)
  {
    this.Cg = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.IteApkInfoReq.Builder
 * JD-Core Version:    0.7.0.1
 */