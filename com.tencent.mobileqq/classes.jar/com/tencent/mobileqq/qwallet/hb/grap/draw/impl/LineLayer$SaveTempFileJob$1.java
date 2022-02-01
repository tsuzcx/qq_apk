package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    if (LineLayer.SaveTempFileJob.a(this.b) != null)
    {
      SaveTempFileJobListener localSaveTempFileJobListener = (SaveTempFileJobListener)LineLayer.SaveTempFileJob.a(this.b).get();
      if (localSaveTempFileJobListener != null) {
        localSaveTempFileJobListener.a(TextUtils.isEmpty(this.a) ^ true, LineLayer.SaveTempFileJob.b(this.b), LineLayer.SaveTempFileJob.c(this.b), this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */