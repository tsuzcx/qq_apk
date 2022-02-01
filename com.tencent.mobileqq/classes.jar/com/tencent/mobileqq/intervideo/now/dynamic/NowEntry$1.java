package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NowEntry$1
  implements URLDrawable.URLDrawableListener
{
  NowEntry$1(NowEntry paramNowEntry, long paramLong, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    System.currentTimeMillis();
    long l = this.a;
    if (!this.b.get())
    {
      this.b.set(true);
      NowEntry.a(this.d, this.c);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("DynamicNow | NowEntry", 1, "download cover pic failed!");
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    this.d.a.b("download_cover").c("1").d(paramThrowable.getMessage()).i(String.valueOf(l1 - l2)).b();
    if (!this.b.get())
    {
      this.b.set(true);
      NowEntry.a(this.d, this.c);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l = System.currentTimeMillis() - this.a;
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append(" download cover pic  success  timeconsume = ");
    paramURLDrawable.append(l);
    QLog.i("DynamicNow | NowEntry", 1, paramURLDrawable.toString());
    this.d.a.b("download_cover").c("0").i(String.valueOf(l)).b();
    if (!this.b.get())
    {
      this.b.set(true);
      NowEntry.a(this.d, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.1
 * JD-Core Version:    0.7.0.1
 */