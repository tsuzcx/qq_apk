package com.tencent.tmdownloader;

import com.tencent.tmassistant.aidl.b;
import com.tencent.tmassistantbase.util.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class r
  extends b
{
  r(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ab.c("TMAssistantDownloadSDKClient", "clientKey:" + paramString1 + ",state:" + paramInt1 + ", errorcode:" + paramInt2 + ",url:" + paramString2);
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)localWeakReference.get();
      if (localITMAssistantDownloadClientListener != null) {
        ab.c("TMAssistantDownloadSDKClient", " listener : " + localITMAssistantDownloadClientListener + "   linstenerWeakReference :" + localWeakReference);
      }
      t.a().a(this.a, localITMAssistantDownloadClientListener, paramString2, paramInt1, paramInt2, paramString3);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)((WeakReference)paramString1.next()).get();
      if (localITMAssistantDownloadClientListener != null) {}
      t.a().a(this.a, localITMAssistantDownloadClientListener, paramString2, paramLong1, paramLong2);
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.r
 * JD-Core Version:    0.7.0.1
 */