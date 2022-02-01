package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NowEntry$3
  implements Runnable
{
  NowEntry$3(NowEntry paramNowEntry, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.this$0.a.b("download_cover").c("2").b();
    if (!this.a.get())
    {
      QLog.i("DynamicNow | NowEntry", 1, "download cover pic timeout!");
      this.a.set(true);
      NowEntry.a(this.this$0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.3
 * JD-Core Version:    0.7.0.1
 */