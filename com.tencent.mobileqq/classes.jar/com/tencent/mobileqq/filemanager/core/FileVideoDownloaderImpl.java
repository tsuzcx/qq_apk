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
  private int jdField_a_of_type_Int = -1;
  private IFileVideoDownloadInfoListener jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener;
  private IFileVideoDownloadListener jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener;
  private BaseVideoBiz jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz = null;
  private ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private SuperPlayerVideoInfo jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  
  public FileVideoDownloaderImpl(BaseVideoBiz paramBaseVideoBiz)
  {
    this.jdField_a_of_type_JavaLangString = paramBaseVideoBiz.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz = paramBaseVideoBiz;
  }
  
  private void b(String paramString1, String paramString2)
  {
    String str = Md5Utils.getMD5(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("----build Videoinfo---- fileid:");
    localStringBuilder.append(str);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, localStringBuilder.toString());
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.b();
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, str, this.jdField_b_of_type_JavaLangString);
    if (paramString2 != null)
    {
      paramString1 = new ArrayList();
      paramString1.add(paramString2);
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.setCookies(paramString1);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.setFormat(104);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a();
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    IFileVideoDownloadInfoListener localIFileVideoDownloadInfoListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener;
    if (localIFileVideoDownloadInfoListener != null) {
      localIFileVideoDownloadInfoListener.a(paramInt, paramString);
    }
  }
  
  public void a(IFileVideoDownloadInfoListener paramIFileVideoDownloadInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener = paramIFileVideoDownloadInfoListener;
  }
  
  public void a(IFileVideoDownloadListener paramIFileVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener = paramIFileVideoDownloadListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader != null) && (this.jdField_a_of_type_Int > 0))
    {
      paramString1 = new StringBuilder();
      paramString1.append("downloader exsited:");
      paramString1.append(this.jdField_a_of_type_Int);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, paramString1.toString());
      return;
    }
    b(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 109);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, this);
    paramString1 = new StringBuilder();
    paramString1.append("start download task:");
    paramString1.append(this.jdField_a_of_type_Int);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, paramString1.toString());
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener;
    if (paramString1 != null) {
      paramString1.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener = null;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
    if (localObject != null)
    {
      IFileVideoDownloadInfoListener localIFileVideoDownloadInfoListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener;
      if (localIFileVideoDownloadInfoListener != null) {
        localIFileVideoDownloadInfoListener.a((SuperPlayerVideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Int > 0) {
        return true;
      }
    }
    this.jdField_a_of_type_Int = 0;
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.b();
    if (l != FileManagerUtil.a((String)localObject)) {
      FileUtils.deleteFile((String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(this);
    return true;
  }
  
  public String b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isPlaying[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append("], downloadSucc[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FMSettings.a().getDefaultRecvPath());
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.c());
      localObject = FileManagerUtil.b(((StringBuilder)localObject).toString());
      if (!FileUtil.a(this.jdField_b_of_type_JavaLangString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
        ((StringBuilder)localObject).append("],File rename faild mybe renamed");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
        localStringBuilder.append("],File download over rename[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("],src[");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, localStringBuilder.toString());
      }
      if (!FileUtils.renameFile(new File(this.jdField_b_of_type_JavaLangString), new File((String)localObject)))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(false);
        return null;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
        localStringBuilder.append("],File download over. rename success!");
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a((String)localObject);
      FileVideoDownloadManager.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
      FileVideoDownloadManager.b();
      return localObject;
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop download:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != -1;
  }
  
  public void c()
  {
    b();
    onDownloadFinish(0);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener;
    if (localObject == null) {
      return;
    }
    ((IFileVideoDownloadListener)localObject).a(paramInt2, paramInt3, paramString);
  }
  
  public void onDownloadFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------->   onDownloadFinish:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Boolean = true;
    localObject = b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, (String)localObject));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a() }));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(paramLong1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener == null) {
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener.a(paramInt2, paramInt3, paramLong1, paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */