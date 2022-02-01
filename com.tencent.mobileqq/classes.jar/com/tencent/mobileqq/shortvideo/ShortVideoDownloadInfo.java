package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;

public class ShortVideoDownloadInfo
  extends ShortVideoBaseInfo
{
  public int l;
  public int m;
  public long n;
  public String o;
  public String p;
  public int q;
  public int r;
  public int s;
  public boolean t = false;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileType:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("format:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mRequestType:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mSceneType:");
    localStringBuilder.append(this.s);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if ((paramInt1 != 0) && (paramInt1 != 1008))
      {
        if (paramInt1 == 3000)
        {
          this.q = 1005;
          return;
        }
        if (paramInt1 == 1)
        {
          this.q = 1003;
          return;
        }
        if (paramInt1 == 10014) {
          this.q = 1007;
        }
      }
      else
      {
        this.q = 1001;
      }
    }
    else if (1 == paramInt2) {
      if ((paramInt1 != 0) && (paramInt1 != 1008))
      {
        if (paramInt1 == 3000)
        {
          this.q = 1006;
          return;
        }
        if (paramInt1 == 1)
        {
          this.q = 1004;
          return;
        }
        if (paramInt1 == 10014) {
          this.q = 1008;
        }
      }
      else
      {
        this.q = 1002;
      }
    }
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uuid invaid:");
      localStringBuilder.append(this.a);
      a("ShortVideoDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.d == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("selfUin invalid,selfUin:");
      localStringBuilder.append(this.d);
      a("ShortVideoDownloadInfo", localStringBuilder.toString());
      return false;
    }
    return super.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo
 * JD-Core Version:    0.7.0.1
 */