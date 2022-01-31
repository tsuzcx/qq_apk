package com.tencent.mobileqq.filemanager.core;

import acwc;
import acwd;
import acwe;
import acwg;
import acwh;
import acwi;
import acwj;
import acwk;
import acwl;
import acwo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileVideoManager$VideoControl
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new acwi(this);
  public FileManagerEntity a;
  public TVK_IDownloadMgr a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public String a;
  public WeakReference a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d = -1;
  
  public FileVideoManager$VideoControl()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private int a(long paramLong)
  {
    int i = 32;
    if (paramLong <= 2097152) {}
    for (;;)
    {
      return i * 1024;
      if (paramLong > 20971520) {
        if (paramLong <= 209715200) {
          i = 128;
        } else if (paramLong <= 524288000) {
          i = 512;
        } else if (paramLong <= 1073741824) {
          i = 1024;
        } else if (paramLong <= -50331648) {
          i = 2048;
        } else {
          i = 4096;
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]getc2cPlayData");
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(paramFileManagerEntity.Uuid, paramFileManagerEntity.bSend, new acwg(this, paramFileManagerEntity, paramFileVideoManagerCallback));
    }
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "initDownloadMgr");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getDownloadMgr(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160714, "");
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "set new Download Callback");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, new acwe(this, localQQAppInterface));
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCookie(20160714, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]getdiscPlayData");
    }
    if (TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      paramFileVideoManagerCallback.a(-6101, BaseApplication.getContext().getResources().getString(2131428190));
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.fileName, Long.parseLong(paramFileManagerEntity.peerUin), paramFileManagerEntity.Uuid, new acwh(this, paramFileManagerEntity, localQQAppInterface, paramFileVideoManagerCallback));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]##########DownloadComplete########### bDownloading = false");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)) {
      localQQAppInterface.a().a(localQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (FileVideoManager.FileVideoManagerCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((FileVideoManager.FileVideoManagerCallback)localObject).af_();
      }
    }
    Object localObject = Looper.getMainLooper();
    if (((Looper)localObject).getThread() != Thread.currentThread())
    {
      new Handler((Looper)localObject).post(new acwj(this, localQQAppInterface));
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      e();
      a();
      localQQAppInterface.a().a(true, 3, null);
    }
    FileVideoManager.a(this);
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = FileManagerUtil.b(FMSettings.a().b() + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (!FileUtil.b(this.jdField_b_of_type_JavaLangString)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],File rename faild mybe renamed");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { str, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],File download over rename[" + str + "],src[" + this.jdField_b_of_type_JavaLangString + "]");
        }
        if (FileUtils.b(new File(this.jdField_b_of_type_JavaLangString), new File(str))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 12, null);
      } while (!QLog.isDevelopLevel());
      QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],File download over. rename faild!");
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],File download over. rename success!");
      }
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "VC Free");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]video control free, stop download playid[" + this.jdField_a_of_type_Int + "]");
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]video control free, stop download downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.d);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "][" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]##########Free########### bDownloading = false");
      }
      this.jdField_b_of_type_Boolean = false;
    }
    try
    {
      FileVideoManager.a(FileVideoManager.a).remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isDevelopLevel())
      {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Long + "]removed for map");
        Iterator localIterator = FileVideoManager.a(FileVideoManager.a).keySet().iterator();
        while (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + l + "]in map");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
        e();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public View a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(paramContext);
  }
  
  public TVK_IMediaPlayer a(Context paramContext, View paramView, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFileVideoManagerCallback);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)paramView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new acwc(this));
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public TVK_IProxyFactory a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  }
  
  public void a()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acwo(this));
      return;
    }
    f();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (paramFileManagerEntity.sendCloudUnsuccessful())
    {
      if (QLog.isDevelopLevel()) {
        FMToastUtil.a("此处状态有问题，请检查！！！");
      }
      return;
    }
    new Handler(Looper.getMainLooper()).post(new acwl(this, paramFileManagerEntity, paramFileVideoManagerCallback));
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "StartDownload,Entity is null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]StartDownload");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16)
      {
        FileVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return;
      }
      String str = FMSettings.a().c() + MD5.toMD5(paramFileManagerEntity.Uuid);
      this.jdField_b_of_type_JavaLangString = str;
      if (FileManagerUtil.a(str) != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) {
        break;
      }
      d();
    } while (!QLog.isDevelopLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramFileManagerEntity.nSessionId + "]download success return");
    return;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramFileManagerEntity.nSessionId + "]url is null ,get it!");
      }
      a(paramFileManagerEntity, new acwk(this, paramFileManagerEntity, paramBoolean));
      return;
    }
    c();
    int i;
    if (paramBoolean)
    {
      if (this.d > 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],startDownloadBlock stop first!downloadId[" + this.d + "]");
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.d);
      }
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160714, this.jdField_a_of_type_JavaLangString, FileManagerUtil.a(this.jdField_b_of_type_JavaLangString), 0L, 0, this.jdField_b_of_type_JavaLangString, 0);
      if (!paramBoolean) {
        break label577;
      }
      this.d = i;
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]@@@@@startDownloadBlockId downloadId[" + this.d + "]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, i, 6);
      return;
      if (this.jdField_c_of_type_Int <= 0) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],startDownload stop first!downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      break;
      label577:
      this.jdField_c_of_type_Int = i;
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]@@@@@startDownloadId downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, "", "当前网络不稳定，无法播放及下载视频，请稍后重试。", null, "我知道了", new acwd(this), null);
      if (!localQQCustomDialog.isShowing()) {
        localQQCustomDialog.show();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QQCustomDialog localQQCustomDialog;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl
 * JD-Core Version:    0.7.0.1
 */