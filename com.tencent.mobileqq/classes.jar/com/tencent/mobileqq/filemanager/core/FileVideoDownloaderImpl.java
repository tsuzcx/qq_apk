package com.tencent.mobileqq.filemanager.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class FileVideoDownloaderImpl
  implements FileVideoDownloadManager.FileVideoManagerCallback, IFileVideoDownloader, ISPlayerDownloader.Listener
{
  private ISPlayerDownloader a;
  private int b = -1;
  private SuperPlayerVideoInfo c = null;
  private String d;
  private IFileVideoDownloadListener e;
  private IFileVideoDownloadInfoListener f;
  private BaseVideoBiz g = null;
  private String h = null;
  private boolean i = false;
  private boolean j = false;
  
  public FileVideoDownloaderImpl(BaseVideoBiz paramBaseVideoBiz)
  {
    this.d = paramBaseVideoBiz.a();
    this.g = paramBaseVideoBiz;
  }
  
  private void b(String paramString1, String paramString2)
  {
    String str = Md5Utils.getMD5(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("----build Videoinfo---- fileid:");
    localStringBuilder.append(str);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, localStringBuilder.toString());
    this.h = this.g.c();
    this.c = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, str, this.h);
    if (paramString2 != null)
    {
      paramString1 = new ArrayList();
      paramString1.add(paramString2);
      this.c.setCookies(paramString1);
    }
    this.c.setFormat(104);
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt, String paramString)
  {
    IFileVideoDownloadInfoListener localIFileVideoDownloadInfoListener = this.f;
    if (localIFileVideoDownloadInfoListener != null) {
      localIFileVideoDownloadInfoListener.a(paramInt, paramString);
    }
  }
  
  public void a(IFileVideoDownloadInfoListener paramIFileVideoDownloadInfoListener)
  {
    this.f = paramIFileVideoDownloadInfoListener;
  }
  
  public void a(IFileVideoDownloadListener paramIFileVideoDownloadListener)
  {
    this.e = paramIFileVideoDownloadListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.a != null) && (this.b > 0))
    {
      paramString1 = new StringBuilder();
      paramString1.append("downloader exsited:");
      paramString1.append(this.b);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, paramString1.toString());
      return;
    }
    b(paramString1, paramString2);
    this.a = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 109);
    this.b = this.a.startOfflineDownload(this.c, this);
    paramString1 = new StringBuilder();
    paramString1.append("start download task:");
    paramString1.append(this.b);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, paramString1.toString());
    paramString1 = this.f;
    if (paramString1 != null) {
      paramString1.a(this.c);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!this.i)
    {
      g();
      this.f = null;
    }
  }
  
  public String b()
  {
    return this.g.a();
  }
  
  public boolean c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      IFileVideoDownloadInfoListener localIFileVideoDownloadInfoListener = this.f;
      if (localIFileVideoDownloadInfoListener != null) {
        localIFileVideoDownloadInfoListener.a((SuperPlayerVideoInfo)localObject);
      }
      if (this.b > 0) {
        return true;
      }
    }
    this.b = 0;
    long l = this.g.b();
    localObject = this.g.c();
    if (l != FileManagerUtil.h((String)localObject)) {
      FileUtils.deleteFile((String)localObject);
    }
    this.g.a(this);
    return true;
  }
  
  public void d()
  {
    if (this.b > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop download:");
      localStringBuilder.append(this.b);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, localStringBuilder.toString());
      this.a.stopOfflineDownload(this.b);
    }
    this.c = null;
    this.b = -1;
  }
  
  public boolean e()
  {
    return this.b != -1;
  }
  
  public void f()
  {
    d();
    onDownloadFinish(0);
  }
  
  public String g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isPlaying[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("], downloadSucc[");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    if (!this.i)
    {
      if (!this.j) {
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FMSettings.a().getDefaultRecvPath());
      ((StringBuilder)localObject).append(this.g.d());
      localObject = FileManagerUtil.b(((StringBuilder)localObject).toString());
      if (!FileUtil.b(this.h))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.g.a());
        ((StringBuilder)localObject).append("],File rename faild mybe renamed");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.g.a());
        localStringBuilder.append("],File download over rename[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("],src[");
        localStringBuilder.append(this.h);
        localStringBuilder.append("]");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, localStringBuilder.toString());
      }
      if (!FileUtils.renameFile(new File(this.h), new File((String)localObject)))
      {
        this.g.a(false);
        return null;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.g.a());
        localStringBuilder.append("],File download over. rename success!");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, localStringBuilder.toString());
      }
      this.g.a((String)localObject);
      FileVideoDownloadManager.d(this.g.a());
      FileVideoDownloadManager.b();
      return localObject;
    }
    return null;
  }
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadError(");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(")");
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    this.g.a(false);
    localObject = this.e;
    if (localObject == null) {
      return;
    }
    ((IFileVideoDownloadListener)localObject).a(paramInt2, paramInt3, paramString);
  }
  
  public void onDownloadFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------->   onDownloadFinish:");
    ((StringBuilder)localObject).append(this.d);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    this.j = true;
    localObject = g();
    if (this.e == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, (String)localObject));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.g.a() }));
      }
      return;
    }
    this.g.a(paramLong1);
    if (this.e == null) {
      return;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadProgressUpdate(playableDurationMS:");
      paramString.append(paramInt2);
      paramString.append(", downloadSpeedKBs:");
      paramString.append(paramInt3);
      paramString.append(", currentDownloadSizeByte: ");
      paramString.append(paramLong1);
      paramString.append(", totalFileSizeByte: ");
      paramString.append(paramLong2);
      paramString.append(",)");
      QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, paramString.toString());
    }
    this.e.a(paramInt2, paramInt3, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProtocolUpdate(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",)");
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, localStringBuilder.toString());
  }
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadStatusUpdate(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",)");
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */