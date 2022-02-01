package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.List;
import mqq.app.MobileQQ;

class PreloadImgApiImpl$1$1
  implements Runnable
{
  PreloadImgApiImpl$1$1(PreloadImgApiImpl.1 param1, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    int j = this.a.f.size();
    Bundle localBundle = this.a.b();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.a.f.get(i);
      PreloadImgApiImpl.access$000(this.b.a, MobileQQ.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.1.1
 * JD-Core Version:    0.7.0.1
 */