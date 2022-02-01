package cooperation.qzone;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

public class QzonePreDownloadManager
{
  private static QzonePreDownloadManager mInstance = null;
  private Context context = BaseApplicationImpl.getContext();
  private QzonePreDownloadManager.DownloadEnty currentEnty;
  private Vector<QzonePreDownloadManager.DownloadEnty> downloadList = new Vector();
  private boolean isDownloading;
  private Downloader mImageDownloader = null;
  
  /* Error */
  private Downloader getDownloader()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	cooperation/qzone/QzonePreDownloadManager:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 27	cooperation/qzone/QzonePreDownloadManager:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 35	cooperation/qzone/QzonePreDownloadManager:context	Landroid/content/Context;
    //   24: invokestatic 62	com/tencent/component/network/DownloaderFactory:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/DownloaderFactory;
    //   27: invokevirtual 65	com/tencent/component/network/DownloaderFactory:getCommonDownloader	()Lcom/tencent/component/network/downloader/Downloader;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 70	com/tencent/component/network/downloader/Downloader:enableResumeTransfer	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 27	cooperation/qzone/QzonePreDownloadManager:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   44: aload_0
    //   45: getfield 27	cooperation/qzone/QzonePreDownloadManager:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   48: ifnonnull +26 -> 74
    //   51: new 72	java/lang/RuntimeException
    //   54: dup
    //   55: ldc 74
    //   57: invokespecial 77	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   71: goto -32 -> 39
    //   74: aload_0
    //   75: getfield 27	cooperation/qzone/QzonePreDownloadManager:mImageDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   78: astore_1
    //   79: goto -65 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	QzonePreDownloadManager
    //   13	28	1	localObject1	Object
    //   61	4	1	localObject2	Object
    //   78	1	1	localDownloader1	Downloader
    //   30	8	2	localDownloader2	Downloader
    //   66	2	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   20	31	61	finally
    //   33	37	61	finally
    //   39	61	61	finally
    //   67	71	61	finally
    //   74	79	61	finally
    //   20	31	66	java/lang/Throwable
    //   33	37	66	java/lang/Throwable
  }
  
  public static QzonePreDownloadManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      mInstance = new QzonePreDownloadManager();
      return mInstance;
    }
    finally {}
  }
  
  private boolean runTask(QzonePreDownloadManager.DownloadEnty paramDownloadEnty)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.isDownloading)
        {
          if (paramDownloadEnty.startimmediately)
          {
            this.downloadList.add(0, paramDownloadEnty);
            return bool;
          }
          this.downloadList.add(paramDownloadEnty);
          continue;
        }
        if (paramDownloadEnty.downloadRequest == null) {
          break label86;
        }
      }
      finally {}
      if (getDownloader().download(paramDownloadEnty.downloadRequest, paramDownloadEnty.priority))
      {
        this.currentEnty = paramDownloadEnty;
        this.isDownloading = true;
        continue;
        label86:
        if (getDownloader().download(paramDownloadEnty.url, paramDownloadEnty.path, paramDownloadEnty.priority, paramDownloadEnty.localListener))
        {
          this.currentEnty = paramDownloadEnty;
          this.isDownloading = true;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    getDownloader().abort(paramString, paramDownloadListener);
    if (this.downloadList.size() > 0)
    {
      paramString = (QzonePreDownloadManager.DownloadEnty)this.downloadList.get(0);
      this.downloadList.remove(0);
      this.isDownloading = false;
      runTask(paramString);
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    getDownloader().cancel(paramString, paramDownloadListener);
    if (this.downloadList.size() > 0)
    {
      paramString = (QzonePreDownloadManager.DownloadEnty)this.downloadList.get(0);
      this.downloadList.remove(0);
      this.isDownloading = false;
      runTask(paramString);
    }
  }
  
  public final boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    return download(null, null, paramBoolean, false, paramDownloadRequest, paramDownloadRequest.getListener());
  }
  
  public final boolean download(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, paramBoolean, false, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    QzonePreDownloadManager.DownloadEnty localDownloadEnty = new QzonePreDownloadManager.DownloadEnty(this);
    localDownloadEnty.path = paramString2;
    localDownloadEnty.url = paramString1;
    localDownloadEnty.priority = paramBoolean1;
    localDownloadEnty.startimmediately = paramBoolean2;
    localDownloadEnty.oridownloadListener = paramDownloadListener;
    localDownloadEnty.localListener = new QzonePreDownloadManager.1(this, localDownloadEnty);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(localDownloadEnty.localListener);
      localDownloadEnty.downloadRequest = paramDownloadRequest;
    }
    return runTask(localDownloadEnty);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePreDownloadManager
 * JD-Core Version:    0.7.0.1
 */