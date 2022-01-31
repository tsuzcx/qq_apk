package com.tencent.open.appcommon.now.download;

import bdgk;
import bdgn;
import bdii;
import bdle;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadCenterImpl$3
  implements Runnable
{
  public DownloadCenterImpl$3(bdgk parambdgk, ArrayList paramArrayList) {}
  
  public void run()
  {
    bdii.a("DownloadCenterImpl", "getQueryDownloadAction enter");
    ArrayList localArrayList = new ArrayList();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localObject = (DownloadInfo)this.a.get(i);
      if (bdle.a().a((DownloadInfo)localObject)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = bdgk.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bdgn)((Iterator)localObject).next()).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.3
 * JD-Core Version:    0.7.0.1
 */