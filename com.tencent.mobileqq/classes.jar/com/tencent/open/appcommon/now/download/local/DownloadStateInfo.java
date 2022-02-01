package com.tencent.open.appcommon.now.download.local;

import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadStateInfo
{
  public String a;
  public String b;
  public int c;
  public int d;
  public long e;
  public long f;
  public int g = 0;
  public String h = "";
  
  public int a(int paramInt)
  {
    int i = 4;
    if (paramInt != -2)
    {
      if (paramInt != 6)
      {
        if (paramInt != 10)
        {
          if (paramInt != 13)
          {
            if (paramInt != 20)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3)
                {
                  if (paramInt != 4) {
                    return 0;
                  }
                  return 3;
                }
                return 2;
              }
              return 1;
            }
          }
          else {
            return 9;
          }
        }
        else {
          return 5;
        }
      }
      else {
        return 7;
      }
    }
    else {
      i = 6;
    }
    return i;
  }
  
  public DownloadStateInfo a(DownloadInfo paramDownloadInfo)
  {
    this.a = paramDownloadInfo.c;
    this.b = paramDownloadInfo.e;
    this.c = a(paramDownloadInfo.a());
    this.d = paramDownloadInfo.t;
    this.e = paramDownloadInfo.E;
    this.f = 0L;
    return this;
  }
  
  public int b(int paramInt)
  {
    int i = -24;
    if ((paramInt != -50) && (paramInt != -40) && (paramInt != -30))
    {
      if (paramInt == -24) {
        return i;
      }
      if (paramInt != -20) {
        if (paramInt != -10)
        {
          if (paramInt != -1)
          {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3)
                {
                  if (paramInt != 4)
                  {
                    if (paramInt != 5)
                    {
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            return 700;
                          }
                        case 709: 
                          return 401;
                        case 708: 
                          return 400;
                        }
                      case 607: 
                        return 300;
                      }
                      return 203;
                    }
                    return 101;
                  }
                  return 100;
                }
                return 102;
              }
              return 201;
            }
            return 202;
          }
        }
        else {
          return 600;
        }
      }
    }
    i = 500;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadStateInfo
 * JD-Core Version:    0.7.0.1
 */