package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackVideoInfo
  implements Cloneable
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public long f;
  public String g;
  public String h;
  public long i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  protected Object clone()
  {
    try
    {
      PackVideoInfo localPackVideoInfo = (PackVideoInfo)super.clone();
      return localPackVideoInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PackVideoInfo item clone failed. exception = ");
      localStringBuilder.append(localCloneNotSupportedException);
      QLog.e("NewPolymericInfo", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PackVideoInfo{businessType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", xgFileSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", thirdUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdUin=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", thirdUinName='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdName='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdIcon='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdAction='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo
 * JD-Core Version:    0.7.0.1
 */