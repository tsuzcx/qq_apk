package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import bcea;
import bhtd;
import bkcy;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<bcea> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, bcea parambcea)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambcea);
  }
  
  public void run()
  {
    bcea localbcea = (bcea)this.b.get();
    if (localbcea != null)
    {
      localbcea.d = bkcy.a(localbcea.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbcea;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */