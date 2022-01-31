package com.tencent.open.appcommon.now.download;

import bdfv;
import bdfy;
import bdht;
import bdkp;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadCenterImpl$3
  implements Runnable
{
  public DownloadCenterImpl$3(bdfv parambdfv, ArrayList paramArrayList) {}
  
  public void run()
  {
    bdht.a("DownloadCenterImpl", "getQueryDownloadAction enter");
    ArrayList localArrayList = new ArrayList();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localObject = (DownloadInfo)this.a.get(i);
      if (bdkp.a().a((DownloadInfo)localObject)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = bdfv.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bdfy)((Iterator)localObject).next()).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.3
 * JD-Core Version:    0.7.0.1
 */