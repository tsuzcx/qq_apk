package com.tencent.mobileqq.weiyun.model;

import android.text.TextUtils;

public class DownloadFile
  implements Cloneable
{
  public final int a;
  public final String b;
  public final String c;
  public final String d;
  public final long e;
  public final int f;
  public final String g;
  public final String h;
  public String i;
  public final String j;
  public DownloadFile.DownloadServerInfo k;
  
  private DownloadFile(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramLong;
    this.f = paramInt2;
    this.g = paramString4;
    this.h = paramString5;
    this.j = paramString6;
  }
  
  public static DownloadFile a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString5)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramLong >= 0L)) {
      return new DownloadFile(paramInt1, paramString1, paramString2, paramString3.toLowerCase(), paramLong, paramInt2, paramString4, paramString5, paramString6);
    }
    throw new IllegalArgumentException("The params fileName, pDirKey, fileId, sha and fileSize should be valid.");
  }
  
  public DownloadFile a()
  {
    try
    {
      DownloadFile localDownloadFile = (DownloadFile)super.clone();
      return localDownloadFile;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4))) {
      return;
    }
    this.k = new DownloadFile.DownloadServerInfo(this, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.DownloadFile
 * JD-Core Version:    0.7.0.1
 */