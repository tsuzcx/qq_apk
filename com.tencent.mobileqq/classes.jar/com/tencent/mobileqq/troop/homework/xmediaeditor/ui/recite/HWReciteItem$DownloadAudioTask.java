package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import bfeo;
import bkgm;
import bmri;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<bfeo> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, bfeo parambfeo)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambfeo);
  }
  
  public void run()
  {
    bfeo localbfeo = (bfeo)this.b.get();
    if (localbfeo != null)
    {
      localbfeo.d = bmri.a(localbfeo.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbfeo;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */