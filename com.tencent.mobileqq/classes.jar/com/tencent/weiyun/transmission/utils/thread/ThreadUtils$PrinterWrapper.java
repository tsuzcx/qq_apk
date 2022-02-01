package com.tencent.weiyun.transmission.utils.thread;

import android.util.Printer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class ThreadUtils$PrinterWrapper
  implements Printer
{
  private final AtomicBoolean mHasPendingPrinter = new AtomicBoolean(false);
  private final List<Printer> mPendingPrinters = new LinkedList();
  private final List<Printer> mWrappedPrinters = new ArrayList();
  
  public void add(Printer paramPrinter)
  {
    synchronized (this.mPendingPrinters)
    {
      this.mPendingPrinters.add(paramPrinter);
      this.mHasPendingPrinter.set(true);
      return;
    }
  }
  
  public void println(String paramString)
  {
    if (this.mHasPendingPrinter.getAndSet(false)) {}
    synchronized (this.mPendingPrinters)
    {
      this.mWrappedPrinters.addAll(this.mPendingPrinters);
      this.mPendingPrinters.clear();
      ??? = this.mWrappedPrinters.iterator();
      if (((Iterator)???).hasNext()) {
        ((Printer)((Iterator)???).next()).println(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.ThreadUtils.PrinterWrapper
 * JD-Core Version:    0.7.0.1
 */