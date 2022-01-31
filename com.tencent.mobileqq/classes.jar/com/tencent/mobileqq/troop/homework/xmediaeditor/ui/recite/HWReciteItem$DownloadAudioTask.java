package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.os.Message;
import babi;
import bfob;
import bhxg;
import java.lang.ref.WeakReference;

class HWReciteItem$DownloadAudioTask
  implements Runnable
{
  private final WeakReference<HWReciteItem> a;
  private final WeakReference<babi> b;
  
  HWReciteItem$DownloadAudioTask(HWReciteItem paramHWReciteItem, babi parambabi)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(parambabi);
  }
  
  public void run()
  {
    babi localbabi = (babi)this.b.get();
    if (localbabi != null)
    {
      localbabi.d = bhxg.a(localbabi.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localbabi;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.DownloadAudioTask
 * JD-Core Version:    0.7.0.1
 */