package com.tencent.mobileqq.filemanager.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
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
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "----build Videoinfo---- fileid:" + str);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener.a(paramInt, paramString);
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
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader != null) && (this.jdField_a_of_type_Int > 0)) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "downloader exsited:" + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      b(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 109);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, this);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "start download task:" + this.jdField_a_of_type_Int);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
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
    if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadInfoListener.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
      }
      if (this.jdField_a_of_type_Int > 0) {
        return true;
      }
    }
    this.jdField_a_of_type_Int = 0;
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.b();
    if (l != FileManagerUtil.a(str)) {
      FileUtils.e(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(this);
    return true;
  }
  
  public String b()
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "isPlaying[" + this.jdField_a_of_type_Boolean + "], downloadSucc[" + this.jdField_b_of_type_Boolean + "]");
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return null;
    }
    String str = FileManagerUtil.b(FMSettings.a().b() + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.c());
    if (!FileUtil.b(this.jdField_b_of_type_JavaLangString))
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a() + "],File rename faild mybe renamed");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a() + "],File download over rename[" + str + "],src[" + this.jdField_b_of_type_JavaLangString + "]");
    }
    if (!FileUtils.b(new File(this.jdField_b_of_type_JavaLangString), new File(str)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(false);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a() + "],File download over. rename success!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(str);
    FileVideoDownloadManager.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
    FileVideoDownloadManager.b();
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "stop download:" + this.jdField_a_of_type_Int);
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
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadError(" + paramInt2 + "," + paramInt3 + "," + paramString + ")");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener.a(paramInt2, paramInt3, paramString);
  }
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "---------->   onDownloadFinish:" + this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
    String str = b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, str));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a() }));
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a(paramLong1);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener == null);
    if (QLog.isDebugVersion()) {
      QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProgressUpdate(playableDurationMS:" + paramInt2 + ", downloadSpeedKBs:" + paramInt3 + ", currentDownloadSizeByte: " + paramLong1 + ", totalFileSizeByte: " + paramLong2 + ",)");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloadListener.a(paramInt2, paramInt3, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProtocolUpdate(" + paramString1 + "," + paramString2 + ",)");
  }
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadStatusUpdate(" + paramInt2 + ",)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */