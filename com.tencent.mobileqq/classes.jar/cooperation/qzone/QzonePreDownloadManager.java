package cooperation.qzone;

import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;
import mqq.app.MobileQQ;

public class QzonePreDownloadManager
{
  private static QzonePreDownloadManager mInstance;
  private Context context = MobileQQ.getContext();
  private QzonePreDownloadManager.DownloadEnty currentEnty;
  private Vector<QzonePreDownloadManager.DownloadEnty> downloadList = new Vector();
  private boolean isDownloading;
  private Downloader mImageDownloader = null;
  
  private Downloader getDownloader()
  {
    try
    {
      if (this.mImageDownloader != null)
      {
        localObject1 = this.mImageDownloader;
        return localObject1;
      }
      Object localObject1 = null;
      try
      {
        Downloader localDownloader = DownloaderFactory.getInstance(this.context).getCommonDownloader();
        localObject1 = localDownloader;
        localDownloader.enableResumeTransfer();
        localObject1 = localDownloader;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.mImageDownloader = ((Downloader)localObject1);
      if (this.mImageDownloader != null)
      {
        localObject1 = this.mImageDownloader;
        return localObject1;
      }
      throw new RuntimeException("no downloader available");
    }
    finally {}
  }
  
  public static QzonePreDownloadManager getInstance()
  {
    if (mInstance == null) {
      try
      {
        mInstance = new QzonePreDownloadManager();
      }
      finally {}
    }
    return mInstance;
  }
  
  private boolean runTask(QzonePreDownloadManager.DownloadEnty paramDownloadEnty)
  {
    try
    {
      if (this.isDownloading)
      {
        if (paramDownloadEnty.startimmediately) {
          this.downloadList.add(0, paramDownloadEnty);
        } else {
          this.downloadList.add(paramDownloadEnty);
        }
        return true;
      }
      if (paramDownloadEnty.downloadRequest != null)
      {
        if (getDownloader().download(paramDownloadEnty.downloadRequest, paramDownloadEnty.priority))
        {
          this.currentEnty = paramDownloadEnty;
          this.isDownloading = true;
          return true;
        }
        return false;
      }
      if (getDownloader().download(paramDownloadEnty.url, paramDownloadEnty.path, paramDownloadEnty.priority, paramDownloadEnty.localListener))
      {
        this.currentEnty = paramDownloadEnty;
        this.isDownloading = true;
        return true;
      }
      return false;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePreDownloadManager
 * JD-Core Version:    0.7.0.1
 */