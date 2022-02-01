package cooperation.qzone.util;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;

class AlbumLibDownloaderUtil$1
  implements Downloader.DownloadListener
{
  AlbumLibDownloaderUtil$1(AlbumLibDownloaderUtil paramAlbumLibDownloaderUtil, String paramString1, Downloader.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/tmp");
    ((StringBuilder)localObject).append(this.val$libName);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = this.val$listener;
    if (localObject != null) {
      ((Downloader.DownloadListener)localObject).onDownloadCanceled(paramString);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/tmp");
    ((StringBuilder)localObject).append(this.val$libName);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = this.val$listener;
    if (localObject != null) {
      ((Downloader.DownloadListener)localObject).onDownloadFailed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.val$libName);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/tmp");
    ((StringBuilder)localObject).append(this.val$libName);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append(this.val$libName);
      ((File)localObject).renameTo(new File(localStringBuilder.toString()));
    }
    LocalMultiProcConfig.putBool(this.val$url, true);
    localObject = this.val$listener;
    if (localObject != null) {
      ((Downloader.DownloadListener)localObject).onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil.1
 * JD-Core Version:    0.7.0.1
 */