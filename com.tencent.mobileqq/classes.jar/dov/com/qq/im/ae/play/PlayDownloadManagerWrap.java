package dov.com.qq.im.ae.play;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
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
  private final Map<String, AEMaterialDownloader.MaterialDownloadListener> downloadingMap = new HashMap();
  private String finalDownloadId = "";
  private WeakReference<VideoStoryCapturePartManager> mPartManager;
  private final Map<String, List<IProgressObserver>> observerMap = new HashMap();
  
  private void addDownloadListener(String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    synchronized (this.downloadingMap)
    {
      this.downloadingMap.put(paramString, paramMaterialDownloadListener);
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
  
  public Map<String, AEMaterialDownloader.MaterialDownloadListener> getDownloadingMap()
  {
    return this.downloadingMap;
  }
  
  public String getFinalDownloadId()
  {
    return this.finalDownloadId;
  }
  
  public void notifyDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    if (paramAEMaterialMetaData == null) {}
    for (;;)
    {
      return;
      String str;
      List localList;
      try
      {
        str = paramAEMaterialMetaData.a;
        localList = (List)this.observerMap.get(str);
        if ((this.finalDownloadId != null) && (this.finalDownloadId.equals(str)) && (paramBoolean) && (paramAEMaterialMetaData.equals(AEPlayShowGridAdapter.selectedMaterial))) {
          ThreadManager.getUIHandler().post(new PlayDownloadManagerWrap.2(this, paramAEMaterialMetaData));
        }
        if (localList == null)
        {
          this.observerMap.remove(str);
          continue;
        }
      }
      finally {}
      paramAEMaterialMetaData = localList.iterator();
      while (paramAEMaterialMetaData.hasNext()) {
        ((IProgressObserver)paramAEMaterialMetaData.next()).onDownloadFinish(str, paramBoolean);
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
  
  public void startDownload(VideoStoryCapturePartManager paramVideoStoryCapturePartManager, @NonNull AEMaterialManager paramAEMaterialManager, @NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (isListenerExits(paramAEMaterialMetaData.a)) {
      return;
    }
    if ((this.mPartManager == null) || (this.mPartManager.get() == null)) {
      this.mPartManager = new WeakReference(paramVideoStoryCapturePartManager);
    }
    paramVideoStoryCapturePartManager = new PlayDownloadManagerWrap.DownloadProcessListener(null);
    addDownloadListener(paramAEMaterialMetaData.a, paramVideoStoryCapturePartManager);
    this.finalDownloadId = paramAEMaterialMetaData.a;
    ThreadManager.excute(new PlayDownloadManagerWrap.1(this, paramAEMaterialManager, paramAEMaterialMetaData, paramVideoStoryCapturePartManager), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap
 * JD-Core Version:    0.7.0.1
 */