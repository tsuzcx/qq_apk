package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import bfut;
import bkys;
import bmjd;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<bfut> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, bfut parambfut)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambfut);
  }
  
  public void run()
  {
    bfut localbfut = (bfut)this.b.get();
    if (localbfut != null)
    {
      localbfut.d = bmjd.a(localbfut.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbfut;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */