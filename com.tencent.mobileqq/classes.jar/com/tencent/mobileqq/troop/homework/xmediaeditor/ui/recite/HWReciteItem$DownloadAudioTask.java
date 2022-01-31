package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import baau;
import bfnk;
import bhwp;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<baau> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, baau parambaau)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambaau);
  }
  
  public void run()
  {
    baau localbaau = (baau)this.b.get();
    if (localbaau != null)
    {
      localbaau.d = bhwp.a(localbaau.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbaau;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */