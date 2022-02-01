package com.tencent.mobileqq.multimsg.save;

import android.app.Activity;
import android.app.Dialog;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.app.QFileMultiControlManager;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class MultiRichMediaSaveManager
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected IAIOImageProviderCallBack a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QFileMultiControlManager jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager;
  private ISaveCallBack jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
  private ConcurrentHashMap<String, FileSaveResult> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  public MultiRichMediaSaveManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private long a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      this.jdField_a_of_type_Long = 0L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)) {
          switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
            }
            break;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "getTotalFileLength totalFileLength = " + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  private void a(int paramInt, FileSaveReq paramFileSaveReq)
  {
    FileSaveResult localFileSaveResult = new FileSaveResult();
    localFileSaveResult.jdField_a_of_type_Int = -1;
    localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
    localFileSaveResult.b = paramInt;
    localFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(paramInt);
    b(localFileSaveResult);
  }
  
  private void a(Activity paramActivity, Dialog paramDialog)
  {
    if ((paramDialog != null) && (paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiRichMediaSaveManager", 2, "showDialogSafe exception: " + paramActivity.getMessage());
    }
  }
  
  private void a(QFileMultiSaveReq paramQFileMultiSaveReq)
  {
    if (paramQFileMultiSaveReq != null) {
      paramQFileMultiSaveReq.a(paramQFileMultiSaveReq.b(), new MultiRichMediaSaveManager.10(this, paramQFileMultiSaveReq));
    }
  }
  
  private void a(FileSaveReq paramFileSaveReq, int paramInt)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null))
    {
      paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      FileSaveResult localFileSaveResult = a(paramFileSaveReq);
      if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localFileSaveResult.c = paramInt;
        a(paramFileSaveReq, localFileSaveResult);
        c(localFileSaveResult, paramInt);
      }
    }
  }
  
  private void a(FileSaveReq paramFileSaveReq, boolean paramBoolean)
  {
    String str;
    FileSaveResult localFileSaveResult;
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null))
    {
      str = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
      localFileSaveResult = a(str);
      if ((localFileSaveResult == null) || (localFileSaveResult.jdField_a_of_type_Boolean)) {
        break label105;
      }
      localFileSaveResult.jdField_a_of_type_Boolean = true;
      localFileSaveResult.c = 100;
      a(str, localFileSaveResult);
      if (!paramBoolean) {
        break label196;
      }
    }
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramFileSaveReq.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
    case 8: 
      label105:
      paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
      str = Utils.Crc64String(paramFileSaveReq + NetConnInfoCenter.getServerTime());
      localFileSaveResult.jdField_a_of_type_Int = 0;
      a(paramFileSaveReq, str, localFileSaveResult);
      return;
    }
    a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq);
    return;
    label196:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramFileSaveReq.jdField_a_of_type_Int);
    }
    localFileSaveResult.jdField_a_of_type_Int = -1;
    b(localFileSaveResult);
  }
  
  private void a(FileSaveResult paramFileSaveResult, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramFileSaveResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, FileSaveResult paramFileSaveResult)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "savePictureFile fail, errorCode = " + i);
        }
        if ((paramFileSaveResult != null) && (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
        {
          paramFileSaveResult.jdField_a_of_type_Int = -1;
          paramFileSaveResult.b = i;
          paramFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(i);
          b(paramFileSaveResult);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!FileUtils.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = FileUtils.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(AppConstants.SDCARD_IMG_SAVE, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramFileSaveResult, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<FileSaveReq> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((FileSaveReq)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult == null) || (!localFileSaveResult.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(FileSaveReq paramFileSaveReq)
  {
    String str;
    if (paramFileSaveReq != null)
    {
      str = "";
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
      {
        str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        continue;
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
        {
          str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
          continue;
          if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
            str = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
          }
        }
      }
    }
  }
  
  private void b(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    FileSaveResult localFileSaveResult;
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null))
    {
      String str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      localFileSaveResult = a(str);
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Boolean = true;
        localFileSaveResult.jdField_a_of_type_Int = paramInt1;
        localFileSaveResult.c = 100;
        a(str, localFileSaveResult);
        if (paramInt1 != 0) {
          break label136;
        }
        paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c();
        a(paramFileSaveReq, Utils.Crc64String(paramFileSaveReq + NetConnInfoCenter.getServerTime()), localFileSaveResult);
      }
    }
    return;
    label136:
    localFileSaveResult.b = paramInt2;
    localFileSaveResult.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localFileSaveResult);
  }
  
  private void b(FileSaveResult paramFileSaveResult)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramFileSaveResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(FileSaveResult paramFileSaveResult, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramFileSaveResult;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, FileSaveResult paramFileSaveResult)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "saveShortVideoFile fail, errorCode = " + i);
        }
        if ((paramFileSaveResult != null) && (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
        {
          paramFileSaveResult.jdField_a_of_type_Int = -1;
          paramFileSaveResult.b = i;
          paramFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(i);
          b(paramFileSaveResult);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!FileUtils.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (VersionUtils.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(AppConstants.SDCARD_VIDEO))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.getShortVideoSaveFileName(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramFileSaveResult, false));
          return;
        }
      }
      i = 0;
    }
  }
  
  private boolean b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.d == 1) && (!localFileSaveResult.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(FileSaveReq paramFileSaveReq)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramFileSaveReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label82:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof BaseDownloadProcessor)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label82;
      }
      localObject = (BaseDownloadProcessor)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((BaseDownloadProcessor)localObject).addDownCallback(new MultiRichMediaSaveManager.3(this, paramFileSaveReq));
      continue;
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label82;
      }
      bool2 = bool1;
      if (!(localObject instanceof BaseDownloadProcessor)) {
        break label82;
      }
      localObject = (BaseDownloadProcessor)localObject;
      if ((((BaseDownloadProcessor)localObject).mUiRequest != null) && ((((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 7) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 16) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 18)))
      {
        ((BaseDownloadProcessor)localObject).cancel();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((BaseDownloadProcessor)localObject).addDownCallback(new MultiRichMediaSaveManager.4(this, paramFileSaveReq));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq == null) {
        break label82;
      }
      bool2 = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
      bool1 = bool2;
      if (bool2)
      {
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(new MultiRichMediaSaveManager.5(this, paramFileSaveReq));
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new FileSaveReq());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramFileSaveReq.jdField_a_of_type_Int);
    }
    String str;
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
      {
        str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.a(new MultiRichMediaSaveManager.6(this, str, paramFileSaveReq));
        PicBusiManager.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 2: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
      {
        str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a(new MultiRichMediaSaveManager.7(this, str, paramFileSaveReq));
        ShortVideoBusiManager.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 3: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
      {
        str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Boolean = true;
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport$VideoDownCallback = new MultiRichMediaSaveManager.8(this, paramFileSaveReq, str);
        ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(paramFileSaveReq);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    }
    if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null)
    {
      str = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(new MultiRichMediaSaveManager.9(this, str, paramFileSaveReq));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
      }
      paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
      return;
    }
    a(10007, paramFileSaveReq);
  }
  
  private void c(FileSaveResult paramFileSaveResult)
  {
    HashMap localHashMap;
    if (paramFileSaveResult != null)
    {
      localHashMap = new HashMap();
      if (paramFileSaveResult.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramFileSaveResult.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramFileSaveResult.b));
      localHashMap.put("isSuccess", paramFileSaveResult.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (paramFileSaveResult != null)
    {
      paramFileSaveResult.c = paramInt;
      d(paramFileSaveResult, paramInt);
    }
  }
  
  private void d(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null) {}
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramFileSaveReq, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramFileSaveReq, 0, 0, "");
      return;
    }
    a(paramFileSaveReq, true);
  }
  
  private void d(FileSaveResult paramFileSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramFileSaveResult != null)
    {
      a(paramFileSaveResult);
      if ((paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Long, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Int, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.b, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.c, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_JavaLangString, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(FileSaveResult paramFileSaveResult, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)) {
        switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localFileSaveResult.jdField_a_of_type_Boolean)
          {
            l += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localFileSaveResult.c / 100.0F * f2 + f1);
            continue;
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localFileSaveResult.jdField_a_of_type_Boolean)
              {
                l += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localFileSaveResult.c / 100.0F * f2 + f1);
                continue;
                if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
                  if (localFileSaveResult.jdField_a_of_type_Boolean)
                  {
                    l += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
                    l = (localFileSaveResult.c / 100.0F * f2 + f1);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Long > 0L) {}
    for (paramInt = (int)(100L * l / this.jdField_a_of_type_Long);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "calculateWholeProgress totalProgress = " + paramInt);
      }
      paramFileSaveResult.d = 0;
      b(paramFileSaveResult, paramInt);
      return;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveBegin");
    }
    this.c = true;
    this.jdField_a_of_type_Long = a();
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack.a();
    }
  }
  
  private void e(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramFileSaveReq.hasNext()) {
        ((ISingleFileSaveCallBack)paramFileSaveReq.next()).a();
      }
    }
  }
  
  private void e(FileSaveResult paramFileSaveResult)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramFileSaveResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      FileSaveResult localFileSaveResult = (FileSaveResult)localEntry.getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (localFileSaveResult.d == 1))
      {
        Iterator localIterator2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((ISingleFileSaveCallBack)localIterator2.next()).a();
        }
        localFileSaveResult.d = 0;
        a((String)localEntry.getKey(), localFileSaveResult);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelDownloading");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    label39:
    FileSaveResult localFileSaveResult;
    IHttpCommunicatorListener localIHttpCommunicatorListener;
    while (localIterator.hasNext())
    {
      localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)) {
        switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localIHttpCommunicatorListener != null) {
              break label431;
            }
            localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label431:
    for (;;)
    {
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null)) {}
      localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) || (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
      break label39;
      if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq == null) {
        break label39;
      }
      localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
      break label39;
      break;
    }
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)) {
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public FileSaveResult a(String paramString)
  {
    return (FileSaveResult)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.frienduin + paramChatMessage.uniseq;
    }
    return "";
  }
  
  public String a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null) {
      return paramPicDownloadInfo.c + paramPicDownloadInfo.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null) {
      return paramShortVideoDownloadInfo.c + paramShortVideoDownloadInfo.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public void a()
  {
    i();
    d();
  }
  
  public void a(Activity paramActivity, List<FileSaveReq> paramList)
  {
    a(paramActivity, DialogUtil.a(paramActivity, 230, paramActivity.getString(2131718664), paramActivity.getString(2131718663), new MultiRichMediaSaveManager.1(this, paramList), new MultiRichMediaSaveManager.2(this)));
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = paramIAIOImageProviderCallBack;
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + paramLong);
    }
    if (paramInt2 != 24) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage type = " + paramInt2);
      }
    }
    do
    {
      return;
      try
      {
        PicReq localPicReq = PicBusiManager.a(7, 1);
        localPicReq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          FileSaveResult localFileSaveResult = new FileSaveResult();
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = FileSaveReq.a(paramMessageForPic);
          localFileSaveResult.d = 1;
          a(str2, localFileSaveResult);
        }
        localPicReq.a(new MultiRichMediaSaveManager.11(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        PicBusiManager.a(localPicReq);
        return;
      }
      catch (Exception paramMessageForPic) {}
    } while (!QLog.isColorLevel());
    QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage exception = " + paramMessageForPic.getMessage());
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + paramLong);
    }
    if (paramInt2 != 256) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo type = " + paramInt2);
      }
    }
    FileSaveReq localFileSaveReq;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localFileSaveReq = FileSaveReq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localFileSaveReq != null) && (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              FileSaveResult localFileSaveResult = new FileSaveResult();
              localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = localFileSaveReq;
              localFileSaveResult.d = 1;
              a(paramMessageForShortVideo, localFileSaveResult);
            }
            if ((!a(localFileSaveReq)) || (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.getShortVideoSavePath(localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Boolean = true;
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport$VideoDownCallback = new MultiRichMediaSaveManager.12(this, paramLong, localFileSaveReq, paramMessageForShortVideo, paramInt1, paramInt2);
    ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(localFileSaveReq);
  }
  
  public void a(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null) {
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null);
            localFileSaveResult = new FileSaveResult();
            localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
            paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
          } while (TextUtils.isEmpty(paramFileSaveReq));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq, localFileSaveResult);
          return;
        } while (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null);
        localFileSaveResult = new FileSaveResult();
        localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
        paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      } while (TextUtils.isEmpty(paramFileSaveReq));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq, localFileSaveResult);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = new QFileMultiControlManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.a();
      }
    } while (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq == null);
    FileSaveResult localFileSaveResult = new FileSaveResult();
    localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(), localFileSaveResult);
  }
  
  public void a(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    FileSaveResult localFileSaveResult;
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null))
    {
      String str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      localFileSaveResult = a(str);
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Boolean = true;
        localFileSaveResult.jdField_a_of_type_Int = paramInt1;
        localFileSaveResult.c = 100;
        a(str, localFileSaveResult);
        if (paramInt1 != 0) {
          break label196;
        }
        paramFileSaveReq = new File(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.h);
        if ((!paramFileSaveReq.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramFileSaveReq.getAbsolutePath(), new StringBuilder().append(paramFileSaveReq.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localFileSaveResult);
      }
    }
    return;
    label196:
    localFileSaveResult.b = paramInt2;
    localFileSaveResult.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localFileSaveResult);
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramFileSaveResult != null)
    {
      if (paramFileSaveResult.d == 1)
      {
        if (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)
        {
          Iterator localIterator = paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            ISingleFileSaveCallBack localISingleFileSaveCallBack = (ISingleFileSaveCallBack)localIterator.next();
            if (paramFileSaveResult.jdField_a_of_type_Int == 0) {
              localISingleFileSaveCallBack.a(paramFileSaveResult, 100);
            }
            localISingleFileSaveCallBack.a(paramFileSaveResult);
          }
        }
        b(paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
        c(paramFileSaveResult);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack.a(paramFileSaveResult);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramFileSaveResult);
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (paramFileSaveResult != null) {
      if (paramFileSaveResult.d == 1)
      {
        if (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)
        {
          Iterator localIterator = paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((ISingleFileSaveCallBack)localIterator.next()).a(paramFileSaveResult, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack.a(paramFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(ISaveCallBack paramISaveCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack = paramISaveCallBack;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MultiRichMediaSaveManager", 2, "removeFileSaveResult exception = " + paramString.getMessage());
    }
  }
  
  public void a(String paramString, FileSaveResult paramFileSaveResult)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramFileSaveResult);
    }
  }
  
  public void a(List<FileSaveReq> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile fileSaveReqList is empty!");
      }
    }
    label571:
    for (;;)
    {
      return;
      String str = "";
      int k;
      int j;
      int i;
      label74:
      int m;
      int n;
      switch (paramInt1)
      {
      default: 
        paramList = paramList.iterator();
        k = 0;
        j = 0;
        i = 0;
        paramInt1 = 0;
        if (paramList.hasNext()) {
          switch (((FileSaveReq)paramList.next()).jdField_a_of_type_Int)
          {
          default: 
            m = k;
            n = j;
            k = paramInt1;
            j = i;
            i = n;
            paramInt1 = m;
          }
        }
        break;
      case 1: 
      case 2: 
        for (;;)
        {
          m = j;
          n = k;
          k = paramInt1;
          j = i;
          i = m;
          paramInt1 = n;
          break label74;
          str = "0X8009F89";
          break;
          str = "0X8009F8A";
          break;
          m = i;
          n = paramInt1 + 1;
          paramInt1 = k;
          i = j;
          j = m;
          k = n;
          continue;
          n = i + 1;
          m = paramInt1;
          paramInt1 = k;
          i = j;
          j = n;
          k = m;
          continue;
          n = j + 1;
          j = i;
          m = paramInt1;
          paramInt1 = k;
          i = n;
          k = m;
          continue;
          n = k + 1;
          k = i;
          m = paramInt1;
          paramInt1 = n;
          i = j;
          j = k;
          k = m;
        }
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label571;
        }
        ReportController.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile reportTag = " + str + ", fromType = " + paramInt2 + ", picCount = " + paramInt1 + ", videoCount = " + i + ", filePicCount = " + j + ", fileVideoCount = " + k);
        return;
        paramInt2 = 1;
        continue;
        paramInt2 = 2;
        continue;
        paramInt2 = 3;
        continue;
        paramInt2 = 4;
      }
    }
  }
  
  public void a(List<FileSaveReq> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new FileSaveResult();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(10006);
      a(paramList);
    }
    for (;;)
    {
      return;
      if (b()) {
        h();
      }
      if ((paramBoolean) && (a(paramList)))
      {
        g();
        return;
      }
      a(paramList);
      e();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FileSaveReq localFileSaveReq = (FileSaveReq)paramList.next();
        if (a(localFileSaveReq)) {
          d(localFileSaveReq);
        } else if (!b(localFileSaveReq)) {
          c(localFileSaveReq);
        }
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      paramChatMessage = a(a(paramChatMessage));
      return (paramChatMessage != null) && (paramChatMessage.d == 1) && (!paramChatMessage.jdField_a_of_type_Boolean) && (paramChatMessage.c < 100);
    }
    return false;
  }
  
  public boolean a(FileSaveReq paramFileSaveReq)
  {
    boolean bool2 = true;
    if (paramFileSaveReq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((PicDownloadInfo)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
        {
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("MultiRichMediaSaveManager", 2, "isFileExist picture exists");
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) {
        break;
      }
      localObject = ShortVideoUtils.getShortVideoSavePath(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq == null) {
        break;
      }
      return paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
    }
  }
  
  public boolean a(List<FileSaveReq> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        FileSaveReq localFileSaveReq = (FileSaveReq)paramList.next();
        if (!a(localFileSaveReq))
        {
          switch (localFileSaveReq.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
                  l += localFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isSaveNeedTips totalSaveSize = " + l);
      }
      return l > 29360128L;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    FileSaveResult localFileSaveResult = a(paramMessageForPic);
    if (localFileSaveResult != null)
    {
      localFileSaveResult.jdField_a_of_type_Boolean = true;
      localFileSaveResult.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localFileSaveResult);
      e(localFileSaveResult);
      a(paramMessageForPic);
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo id = " + paramLong);
    }
    if (paramInt2 != 256)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo type = " + paramInt2);
      }
      return;
    }
    String str = a(paramMessageForShortVideo);
    FileSaveResult localFileSaveResult = a(str);
    if (localFileSaveResult != null)
    {
      localFileSaveResult.jdField_a_of_type_Boolean = true;
      localFileSaveResult.jdField_a_of_type_Int = -1;
      a(str, localFileSaveResult);
      e(localFileSaveResult);
    }
    ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(FileSaveReq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    FileSaveResult localFileSaveResult;
    if ((paramMessage.obj instanceof FileSaveResult))
    {
      localFileSaveResult = (FileSaveResult)paramMessage.obj;
      if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq == null) {}
    }
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return true;
          a(localFileSaveResult, paramMessage.arg1);
          return true;
        } while (localFileSaveResult.d != 1);
        e(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
        return true;
        if (localFileSaveResult.d == 1)
        {
          d(localFileSaveResult);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localFileSaveResult.b + ", errorMsg = " + localFileSaveResult.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((ISingleFileSaveCallBack)paramMessage.next()).a(localFileSaveResult);
          }
          this.b = true;
        }
      } while (!a());
      b(localFileSaveResult, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localFileSaveResult.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localFileSaveResult.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = null;
        }
        a(localFileSaveResult, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localFileSaveResult.jdField_a_of_type_Int = -1;
        } else {
          localFileSaveResult.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((ISingleFileSaveCallBack)paramMessage.next()).b(localFileSaveResult);
      }
    }
    a(localFileSaveResult);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "onDestroy");
    }
    f();
    i();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager
 * JD-Core Version:    0.7.0.1
 */