package dov.com.qq.im.ae.play;

import android.support.annotation.NonNull;
import bluy;
import blvb;
import blvj;
import bmas;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap
{
  private static final String TAG = "PlayDownloadManagerWrap";
  private final Map<String, blvj> downloadingMap = new HashMap();
  private String finalDownloadId = "";
  private WeakReference<bmas> mPartManager;
  private final Map<String, List<IProgressObserver>> observerMap = new HashMap();
  
  private void addDownloadListener(String paramString, blvj paramblvj)
  {
    synchronized (this.downloadingMap)
    {
      this.downloadingMap.put(paramString, paramblvj);
      return;
    }
  }
  
  private void deleteDownloadListener(String paramString)
  {
    synchronized (this.downloadingMap)
    {
      this.downloadingMap.remove(paramString);
      return;
    }
  }
  
  public static PlayDownloadManagerWrap getInstance()
  {
    return PlayDownloadManagerWrap.InstanceHolder.multiDownloadManager;
  }
  
  private boolean isListenerExits(String paramString)
  {
    for (;;)
    {
      synchronized (this.downloadingMap)
      {
        if (this.downloadingMap.get(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void addProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    if (paramIProgressObserver != null) {}
    try
    {
      List localList = (List)this.observerMap.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (!((List)localObject).contains(paramIProgressObserver))
      {
        ((List)localObject).add(paramIProgressObserver);
        this.observerMap.put(paramString, localObject);
      }
      return;
    }
    finally {}
  }
  
  public void clearObserver()
  {
    this.mPartManager = null;
    this.observerMap.clear();
  }
  
  public Map<String, blvj> getDownloadingMap()
  {
    return this.downloadingMap;
  }
  
  public String getFinalDownloadId()
  {
    return this.finalDownloadId;
  }
  
  public void notifyDownloadFinish(blvb paramblvb, boolean paramBoolean)
  {
    if (paramblvb == null) {}
    for (;;)
    {
      return;
      String str;
      List localList;
      try
      {
        str = paramblvb.a;
        localList = (List)this.observerMap.get(str);
        if ((this.finalDownloadId != null) && (this.finalDownloadId.equals(str)) && (paramBoolean) && (paramblvb.equals(AEPlayShowGridAdapter.selectedMaterial))) {
          ThreadManager.getUIHandler().post(new PlayDownloadManagerWrap.2(this, paramblvb));
        }
        if (localList == null)
        {
          this.observerMap.remove(str);
          continue;
        }
      }
      finally {}
      paramblvb = localList.iterator();
      while (paramblvb.hasNext()) {
        ((IProgressObserver)paramblvb.next()).onDownloadFinish(str, paramBoolean);
      }
      this.observerMap.remove(str);
    }
  }
  
  /* Error */
  public void notifyDownloadProgress(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	dov/com/qq/im/ae/play/PlayDownloadManagerWrap:observerMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 70 2 0
    //   12: checkcast 74	java/util/List
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +17 -> 34
    //   20: aload_0
    //   21: getfield 28	dov/com/qq/im/ae/play/PlayDownloadManagerWrap:observerMap	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 57 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_3
    //   35: invokeinterface 134 1 0
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface 140 1 0
    //   47: ifeq -16 -> 31
    //   50: aload_3
    //   51: invokeinterface 144 1 0
    //   56: checkcast 146	dov/com/qq/im/ae/play/IProgressObserver
    //   59: aload_1
    //   60: iload_2
    //   61: invokeinterface 155 3 0
    //   66: goto -25 -> 41
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	PlayDownloadManagerWrap
    //   0	74	1	paramString	String
    //   0	74	2	paramInt	int
    //   15	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	69	finally
    //   20	31	69	finally
    //   34	41	69	finally
    //   41	66	69	finally
  }
  
  public void removeProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    List localList;
    try
    {
      localList = (List)this.observerMap.get(paramString);
      if ((localList != null) && (localList.size() > 1))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if ((IProgressObserver)localIterator.next() == paramIProgressObserver) {
            localIterator.remove();
          }
        }
      }
      if (localList == null) {
        break label91;
      }
    }
    finally {}
    if (localList.size() < 1) {
      label91:
      this.observerMap.remove(paramString);
    }
  }
  
  public void startDownload(bmas parambmas, @NonNull bluy parambluy, @NonNull blvb paramblvb)
  {
    if (isListenerExits(paramblvb.a)) {
      return;
    }
    if ((this.mPartManager == null) || (this.mPartManager.get() == null)) {
      this.mPartManager = new WeakReference(parambmas);
    }
    parambmas = new PlayDownloadManagerWrap.DownloadProcessListener(null);
    addDownloadListener(paramblvb.a, parambmas);
    this.finalDownloadId = paramblvb.a;
    ThreadManager.excute(new PlayDownloadManagerWrap.1(this, parambluy, paramblvb, parambmas), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap
 * JD-Core Version:    0.7.0.1
 */