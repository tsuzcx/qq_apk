package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class r
  implements h
{
  r(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
  
  public void a(List<String> paramList)
  {
    if (this.a.mWeakLogListenerArrayList != null)
    {
      Iterator localIterator = this.a.mWeakLogListenerArrayList.iterator();
      while (localIterator.hasNext())
      {
        ITMAssistantDownloadLogListener localITMAssistantDownloadLogListener = (ITMAssistantDownloadLogListener)((WeakReference)localIterator.next()).get();
        if (localITMAssistantDownloadLogListener != null) {
          localITMAssistantDownloadLogListener.onLog(TMAssistantDownloadClient.access$000(this.a, paramList));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.r
 * JD-Core Version:    0.7.0.1
 */