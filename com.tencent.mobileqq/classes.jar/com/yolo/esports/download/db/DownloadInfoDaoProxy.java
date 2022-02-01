package com.yolo.esports.download.db;

import com.tencent.qphone.base.util.BaseApplication;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.List;

public class DownloadInfoDaoProxy
{
  private static volatile DownloadInfoDaoProxy a;
  private DownloadInfoDBHelper b = new DownloadInfoDBHelper(BaseApplication.getContext());
  
  public static DownloadInfoDaoProxy a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DownloadInfoDaoProxy();
        }
      }
      finally {}
    }
    return a;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    return this.b.a(paramDownloadInfo);
  }
  
  public List<DownloadInfo> b()
  {
    return this.b.a();
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    this.b.a(paramDownloadInfo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.db.DownloadInfoDaoProxy
 * JD-Core Version:    0.7.0.1
 */