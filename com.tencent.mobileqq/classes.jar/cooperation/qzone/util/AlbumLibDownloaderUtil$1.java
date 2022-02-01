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
    File localFile = new File(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath() + "/tmp" + this.val$libName);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.val$listener != null) {
      this.val$listener.onDownloadCanceled(paramString);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath() + "/tmp" + this.val$libName);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.val$listener != null) {
      this.val$listener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath() + "/" + this.val$libName);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath() + "/tmp" + this.val$libName);
    if (localFile.exists()) {
      localFile.renameTo(new File(AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath() + "/" + this.val$libName));
    }
    LocalMultiProcConfig.putBool(this.val$url, true);
    if (this.val$listener != null) {
      this.val$listener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.GIF_SO_LIB_NAME.equals(this.val$libName)) {
      this.this$0.mDownloadState[AlbumLibDownloaderUtil.access$000(this.this$0)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil.1
 * JD-Core Version:    0.7.0.1
 */