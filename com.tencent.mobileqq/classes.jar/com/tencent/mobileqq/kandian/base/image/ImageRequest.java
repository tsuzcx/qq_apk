package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap.Config;
import java.net.URL;

public class ImageRequest
{
  public static int v = 2;
  public URL a;
  public int b;
  public int c;
  public volatile boolean d = false;
  public boolean e;
  Bitmap.Config f = Bitmap.Config.ARGB_8888;
  public int g = 0;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public int p = 0;
  public int q = -2;
  public String r;
  public String s;
  public long t;
  public int u = 0;
  public String w = "";
  public boolean x = false;
  public boolean y = false;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_zimage_image_req_");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ImageRequest)paramObject;
      if (this.b != paramObject.b) {
        return false;
      }
      if (this.c != paramObject.c) {
        return false;
      }
      if (this.g != paramObject.g) {
        return false;
      }
      URL localURL = this.a;
      if (localURL != null)
      {
        if (!localURL.equals(paramObject.a)) {
          return false;
        }
      }
      else if (paramObject.a != null) {
        return false;
      }
      return this.f == paramObject.f;
    }
    return false;
  }
  
  public int hashCode()
  {
    URL localURL = this.a;
    int i1;
    if (localURL != null) {
      i1 = localURL.hashCode();
    } else {
      i1 = 0;
    }
    return ((i1 * 31 + this.b) * 31 + this.c) * 31 + this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("x");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" isPreload:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" isCancel:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" startTime: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" enterSubThreadTime: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" enterThreadPoolTime: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" startThreadPoolTime: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" downloadAndWriteFileTime: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" decodeTime: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" enterMainThreadTime: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" endTime: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" failCode: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" errMsg: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" supportInnerIp: ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(" useIpConnect:");
    localStringBuilder.append(this.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.ImageRequest
 * JD-Core Version:    0.7.0.1
 */