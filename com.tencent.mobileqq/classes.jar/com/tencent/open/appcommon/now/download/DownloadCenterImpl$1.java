package com.tencent.open.appcommon.now.download;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class DownloadCenterImpl$1
  implements INetEventHandler
{
  DownloadCenterImpl$1(DownloadCenterImpl paramDownloadCenterImpl) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.1
 * JD-Core Version:    0.7.0.1
 */