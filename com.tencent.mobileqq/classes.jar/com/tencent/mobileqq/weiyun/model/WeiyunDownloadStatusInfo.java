package com.tencent.mobileqq.weiyun.model;

public final class WeiyunDownloadStatusInfo
  implements Cloneable
{
  public volatile int a = 0;
  public int b = 0;
  public String c = "";
  public long d = 0L;
  public long e = 0L;
  public String f = "";
  public String g = "";
  public String h = "";
  public DownloadJobContext i;
  
  public boolean a()
  {
    int j = this.a;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (this.a != 5)
      {
        bool1 = bool2;
        if (this.a != 3)
        {
          if (this.a == 1)
          {
            j = this.b;
            bool1 = bool2;
            if (j == 1810003) {
              return bool1;
            }
            if (j == 1810004) {
              return true;
            }
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    int j = this.a;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (this.a != 1)
      {
        if (this.a == 2) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    if (this.a == 1)
    {
      int j = this.b;
      if ((j != 1810003) && (j != 1810004)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    int j = this.a;
    boolean bool = true;
    if (j == 1)
    {
      j = this.b;
      if (j == 1810003) {
        return bool;
      }
      if (j == 1810004) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public WeiyunDownloadStatusInfo e()
  {
    try
    {
      WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = (WeiyunDownloadStatusInfo)super.clone();
      return localWeiyunDownloadStatusInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo
 * JD-Core Version:    0.7.0.1
 */