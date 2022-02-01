package com.tencent.mobileqq.kandian.base.download;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.HashMap;
import java.util.Map;

class ReadInJoyDownloader$WrappedDownloadInfo
{
  private static int d = 5000;
  private final DownloadInfo a;
  private final Map<String, String> b = new HashMap();
  private int c = 3;
  
  private ReadInJoyDownloader$WrappedDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.a = paramDownloadInfo;
    this.b.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.c);
    this.b.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.e);
    this.b.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.n));
    this.b.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.h);
    this.b.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
    this.b.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    this.b.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.B);
    this.b.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.f);
    this.b.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.C));
    this.b.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.G));
    this.b.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.I));
  }
  
  private int c()
  {
    return this.c;
  }
  
  private void d()
  {
    this.c -= 1;
  }
  
  private Map<String, String> e()
  {
    return this.b;
  }
  
  public DownloadInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.download.ReadInJoyDownloader.WrappedDownloadInfo
 * JD-Core Version:    0.7.0.1
 */