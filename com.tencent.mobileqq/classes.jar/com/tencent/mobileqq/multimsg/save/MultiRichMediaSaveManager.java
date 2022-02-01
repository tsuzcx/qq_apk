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
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
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
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      this.jdField_a_of_type_Long = 0L;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)) {
          switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
            }
            break;
          case 2: 
          case 3: 
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 1: 
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTotalFileLength totalFileLength = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
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
    if ((paramDialog != null) && (paramActivity != null) && (!paramActivity.isFinishing())) {
      try
      {
        paramDialog.show();
        return;
      }
      catch (Throwable paramActivity)
      {
        if (QLog.isColorLevel())
        {
          paramDialog = new StringBuilder();
          paramDialog.append("showDialogSafe exception: ");
          paramDialog.append(paramActivity.getMessage());
          QLog.d("MultiRichMediaSaveManager", 2, paramDialog.toString());
        }
      }
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
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null))
    {
      Object localObject2 = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
      Object localObject1 = a((String)localObject2);
      if ((localObject1 != null) && (!((FileSaveResult)localObject1).jdField_a_of_type_Boolean))
      {
        ((FileSaveResult)localObject1).jdField_a_of_type_Boolean = true;
        ((FileSaveResult)localObject1).c = 100;
        a((String)localObject2, (FileSaveResult)localObject1);
        if (paramBoolean)
        {
          switch (paramFileSaveReq.jdField_a_of_type_Int)
          {
          default: 
            return;
          case 5: 
          case 7: 
          case 9: 
            a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq);
            return;
          }
          paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramFileSaveReq);
          ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTime());
          localObject2 = Utils.Crc64String(((StringBuilder)localObject2).toString());
          ((FileSaveResult)localObject1).jdField_a_of_type_Int = 0;
          a(paramFileSaveReq, (String)localObject2, (FileSaveResult)localObject1);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dealFileMultilDownloadComplete errorType= ");
          ((StringBuilder)localObject2).append(paramFileSaveReq.jdField_a_of_type_Int);
          QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject2).toString());
        }
        ((FileSaveResult)localObject1).jdField_a_of_type_Int = -1;
        b((FileSaveResult)localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dealFileMultilDownloadComplete fileType= ");
        ((StringBuilder)localObject1).append(paramFileSaveReq.jdField_a_of_type_Int);
        QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
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
    } else if (TextUtils.isEmpty(paramString2)) {
      i = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      i = 10003;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("savePictureFile fail, errorCode = ");
        paramString1.append(i);
        QLog.e("MultiRichMediaSaveManager", 2, paramString1.toString());
      }
      if ((paramFileSaveResult != null) && (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
      {
        paramFileSaveResult.jdField_a_of_type_Int = -1;
        paramFileSaveResult.b = i;
        paramFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(i);
        b(paramFileSaveResult);
      }
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    String str = paramString2;
    if (!paramString2.contains("."))
    {
      str = FileUtils.estimateFileType(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    paramString2 = new File(AppConstants.SDCARD_IMG_SAVE, str);
    ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramFileSaveResult, false));
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
    if (paramFileSaveReq != null)
    {
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
          paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
        }
        break;
      case 2: 
      case 3: 
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) {
          paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
        }
        break;
      case 1: 
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) {
          paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
        }
        break;
      }
      paramFileSaveReq = "";
      a(paramFileSaveReq);
    }
  }
  
  private void b(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null))
    {
      String str = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      FileSaveResult localFileSaveResult = a(str);
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Boolean = true;
        localFileSaveResult.jdField_a_of_type_Int = paramInt1;
        localFileSaveResult.c = 100;
        a(str, localFileSaveResult);
        if (paramInt1 == 0)
        {
          paramFileSaveReq = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c();
          paramString = new StringBuilder();
          paramString.append(paramFileSaveReq);
          paramString.append(NetConnInfoCenter.getServerTime());
          a(paramFileSaveReq, Utils.Crc64String(paramString.toString()), localFileSaveResult);
          return;
        }
        localFileSaveResult.b = paramInt2;
        localFileSaveResult.jdField_a_of_type_JavaLangString = paramString;
        if (QLog.isColorLevel())
        {
          paramFileSaveReq = new StringBuilder();
          paramFileSaveReq.append("dealPicDownloadComplete errorCode= ");
          paramFileSaveReq.append(paramInt2);
          paramFileSaveReq.append(", errorDec= ");
          paramFileSaveReq.append(paramString);
          QLog.d("MultiRichMediaSaveManager", 2, paramFileSaveReq.toString());
        }
        b(localFileSaveResult);
      }
    }
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
    } else if (TextUtils.isEmpty(paramString2)) {
      i = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      i = 10003;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("saveShortVideoFile fail, errorCode = ");
        paramString1.append(i);
        QLog.e("MultiRichMediaSaveManager", 2, paramString1.toString());
      }
      if ((paramFileSaveResult != null) && (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
      {
        paramFileSaveResult.jdField_a_of_type_Int = -1;
        paramFileSaveResult.b = i;
        paramFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(i);
        b(paramFileSaveResult);
      }
      return;
    }
    File localFile;
    if (VersionUtils.b()) {
      localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
    } else {
      localFile = new File(AppConstants.SDCARD_VIDEO);
    }
    localFile.mkdirs();
    paramString2 = new File(localFile, ShortVideoUtils.getShortVideoSaveFileName(paramString2));
    ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramFileSaveResult, false));
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
    boolean bool3 = false;
    if (paramFileSaveReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    boolean bool1 = bool2;
    Object localObject;
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      bool1 = bool2;
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null)
      {
        bool2 = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
        bool1 = bool2;
        if (bool2)
        {
          paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(new MultiRichMediaSaveManager.5(this, paramFileSaveReq));
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager;
          bool1 = bool2;
          if (localObject != null)
          {
            ((QFileMultiControlManager)localObject).a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
            return bool2;
          }
        }
      }
      break;
    case 2: 
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null))
      {
        localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if ((localObject instanceof BaseDownloadProcessor))
          {
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
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        }
        return false;
      }
      break;
    case 1: 
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
      {
        if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
          return false;
        }
        localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
        bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if ((localObject instanceof BaseDownloadProcessor)) {
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (bool2)
        {
          localObject = (BaseDownloadProcessor)localObject;
          if (QLog.isColorLevel()) {
            QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
          }
          ((BaseDownloadProcessor)localObject).addDownCallback(new MultiRichMediaSaveManager.3(this, paramFileSaveReq));
          return bool2;
        }
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
          bool1 = bool2;
        }
      }
      break;
    }
    return bool1;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadFile fileType = ");
      ((StringBuilder)localObject).append(paramFileSaveReq.jdField_a_of_type_Int);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder;
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null)
      {
        localObject = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadFile key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(new MultiRichMediaSaveManager.9(this, (String)localObject, paramFileSaveReq));
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager;
        if (localObject != null) {
          ((QFileMultiControlManager)localObject).a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 3: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
      {
        localObject = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadVideo key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Boolean = true;
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback = new MultiRichMediaSaveManager.8(this, paramFileSaveReq, (String)localObject);
        ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(paramFileSaveReq);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 2: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
      {
        localObject = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadShortVideo key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a(new MultiRichMediaSaveManager.7(this, (String)localObject, paramFileSaveReq));
        ShortVideoBusiManager.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    }
    if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
    {
      localObject = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadPic key = ");
        localStringBuilder.append((String)localObject);
        QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
      }
      paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.a(new MultiRichMediaSaveManager.6(this, (String)localObject, paramFileSaveReq));
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq);
      return;
    }
    a(10007, paramFileSaveReq);
  }
  
  private void c(FileSaveResult paramFileSaveResult)
  {
    if (paramFileSaveResult != null)
    {
      HashMap localHashMap = new HashMap();
      if (paramFileSaveResult.d == 1) {
        localHashMap.put("isMultiSave", "1");
      } else {
        localHashMap.put("isMultiSave", "0");
      }
      if (paramFileSaveResult.jdField_a_of_type_Int == 0)
      {
        localHashMap.put("isSuccess", "0");
      }
      else
      {
        localHashMap.put("isSuccess", "1");
        localHashMap.put("errorCode", String.valueOf(paramFileSaveResult.b));
        localHashMap.put("isSuccess", paramFileSaveResult.jdField_a_of_type_JavaLangString);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
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
    if (paramFileSaveReq != null)
    {
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        a(paramFileSaveReq, true);
        return;
      case 2: 
      case 3: 
        a(paramFileSaveReq, 0, 0, "");
        return;
      }
      b(paramFileSaveReq, 0, 0, "");
    }
  }
  
  private void d(FileSaveResult paramFileSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramFileSaveResult != null)
    {
      a(paramFileSaveResult);
      if (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo != null)
      {
        IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localIAIOImageProviderCallBack != null) {
          localIAIOImageProviderCallBack.a(paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Long, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Int, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.b, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.c, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_JavaLangString, paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo.jdField_a_of_type_Boolean);
        }
      }
    }
  }
  
  private void d(FileSaveResult paramFileSaveResult, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
      {
        label155:
        float f1;
        float f2;
        switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
            if (localFileSaveResult.jdField_a_of_type_Boolean)
            {
              l2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
              l1 += l2;
            }
            else
            {
              f1 = (float)l1;
              f2 = (float)localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
              paramInt = localFileSaveResult.c;
            }
          }
          break;
        case 2: 
        case 3: 
        case 1: 
          for (;;)
          {
            l1 = (f1 + f2 * (paramInt / 100.0F));
            break;
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) || (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
              break;
            }
            if (localFileSaveResult.jdField_a_of_type_Boolean)
            {
              l2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              break label155;
            }
            f1 = (float)l1;
            f2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            paramInt = localFileSaveResult.c;
            continue;
            if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)) {
              break;
            }
            if (localFileSaveResult.jdField_a_of_type_Boolean)
            {
              l2 = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              break label155;
            }
            f1 = (float)l1;
            f2 = (float)localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            paramInt = localFileSaveResult.c;
          }
        }
      }
    }
    long l2 = this.jdField_a_of_type_Long;
    if (l2 > 0L) {
      paramInt = (int)(l1 * 100L / l2);
    } else {
      paramInt = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculateWholeProgress totalProgress = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    paramFileSaveResult.d = 0;
    b(paramFileSaveResult, paramInt);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveBegin");
    }
    this.c = true;
    this.jdField_a_of_type_Long = a();
    ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.a();
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
    ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.c();
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
    while (localIterator.hasNext())
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
      {
        Object localObject;
        switch (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
          if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
            localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.b();
          }
          break;
        case 3: 
          if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
          }
          break;
        case 2: 
          if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) {
            localObject = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo;
          }
          localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
          if ((localObject instanceof BaseDownloadProcessor)) {
            ((BaseDownloadProcessor)localObject).cancel();
          }
          break;
        case 1: 
          if ((localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            localObject = localIHttpCommunicatorListener;
            if (localIHttpCommunicatorListener == null) {
              localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
            }
            if ((localObject instanceof BaseDownloadProcessor)) {
              ((BaseDownloadProcessor)localObject).cancel();
            }
          }
          break;
        }
      }
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
    if (paramChatMessage != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramChatMessage.frienduin);
      localStringBuilder.append(paramChatMessage.uniseq);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPicDownloadInfo.c);
      localStringBuilder.append(paramPicDownloadInfo.jdField_a_of_type_Long);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramShortVideoDownloadInfo.c);
      localStringBuilder.append(paramShortVideoDownloadInfo.jdField_a_of_type_Long);
      return localStringBuilder.toString();
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
    a(paramActivity, DialogUtil.a(paramActivity, 230, paramActivity.getString(2131718382), paramActivity.getString(2131718381), new MultiRichMediaSaveManager.1(this, paramList), new MultiRichMediaSaveManager.2(this)));
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = paramIAIOImageProviderCallBack;
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadRawImage id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 != 24)
    {
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("downloadRawImage type = ");
        paramMessageForPic.append(paramInt2);
        QLog.i("MultiRichMediaSaveManager", 2, paramMessageForPic.toString());
      }
      return;
    }
    try
    {
      localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(7, 1);
      ((PicReq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
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
      ((PicReq)localObject).a(new MultiRichMediaSaveManager.11(this, paramLong, paramInt1, paramInt2, l, str2, str1));
      ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
      return;
    }
    catch (Exception paramMessageForPic)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadRawImage exception = ");
        ((StringBuilder)localObject).append(paramMessageForPic.getMessage());
        QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadVideo id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 != 256)
    {
      if (QLog.isColorLevel())
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("downloadVideo type = ");
        paramMessageForShortVideo.append(paramInt2);
        QLog.i("MultiRichMediaSaveManager", 2, paramMessageForShortVideo.toString());
      }
      return;
    }
    try
    {
      localObject = FileSaveReq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
      if ((localObject != null) && (((FileSaveReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null))
      {
        paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
        if (a(paramMessageForShortVideo) == null)
        {
          FileSaveResult localFileSaveResult = new FileSaveResult();
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = ((FileSaveReq)localObject);
          localFileSaveResult.d = 1;
          a(paramMessageForShortVideo, localFileSaveResult);
        }
        if ((a((FileSaveReq)localObject)) && (((FileSaveReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null))
        {
          paramMessageForShortVideo = SVUtils.a(((FileSaveReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
          return;
        }
        ((FileSaveReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Boolean = true;
        ((FileSaveReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback = new MultiRichMediaSaveManager.12(this, paramLong, (FileSaveReq)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
        ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a((FileSaveReq)localObject);
        return;
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dealSaveVideo exception: ");
        ((StringBuilder)localObject).append(paramMessageForShortVideo.getMessage());
        QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      FileSaveResult localFileSaveResult;
      switch (paramFileSaveReq.jdField_a_of_type_Int)
      {
      default: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = new QFileMultiControlManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager.a();
        }
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a(), localFileSaveResult);
          return;
        }
        break;
      case 2: 
      case 3: 
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
          paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
          if (!TextUtils.isEmpty(paramFileSaveReq))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq, localFileSaveResult);
            return;
          }
        }
        break;
      case 1: 
        if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq = paramFileSaveReq;
          paramFileSaveReq = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
          if (!TextUtils.isEmpty(paramFileSaveReq)) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFileSaveReq, localFileSaveResult);
          }
        }
        break;
      }
    }
  }
  
  public void a(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo != null))
    {
      Object localObject = a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      FileSaveResult localFileSaveResult = a((String)localObject);
      if ((localFileSaveResult != null) && (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Boolean = true;
        localFileSaveResult.jdField_a_of_type_Int = paramInt1;
        localFileSaveResult.c = 100;
        a((String)localObject, localFileSaveResult);
        if (paramInt1 == 0)
        {
          paramFileSaveReq = new File(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.h);
          if ((!paramFileSaveReq.exists()) && (QLog.isColorLevel())) {
            QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
          }
          paramString = paramFileSaveReq.getAbsolutePath();
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFileSaveReq.getParentFile().getName());
          localStringBuilder.append(NetConnInfoCenter.getServerTime());
          ((StringBuilder)localObject).append(localStringBuilder.toString().toLowerCase(Locale.US));
          ((StringBuilder)localObject).append(".mp4");
          b(paramString, ((StringBuilder)localObject).toString(), localFileSaveResult);
          return;
        }
        localFileSaveResult.b = paramInt2;
        localFileSaveResult.jdField_a_of_type_JavaLangString = paramString;
        if (QLog.isColorLevel())
        {
          paramFileSaveReq = new StringBuilder();
          paramFileSaveReq.append("dealShortVideoDownloadComplete errorCode= ");
          paramFileSaveReq.append(paramInt2);
          paramFileSaveReq.append(", errorDec= ");
          paramFileSaveReq.append(paramString);
          QLog.d("MultiRichMediaSaveManager", 2, paramFileSaveReq.toString());
        }
        b(localFileSaveResult);
      }
    }
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
          localObject = paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ISingleFileSaveCallBack localISingleFileSaveCallBack = (ISingleFileSaveCallBack)((Iterator)localObject).next();
            if (paramFileSaveResult.jdField_a_of_type_Int == 0) {
              localISingleFileSaveCallBack.a(paramFileSaveResult, 100);
            }
            localISingleFileSaveCallBack.a(paramFileSaveResult);
          }
        }
        b(paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
        c(paramFileSaveResult);
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
      if (localObject != null) {
        ((ISaveCallBack)localObject).a(paramFileSaveResult);
      }
      this.c = false;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      c(paramFileSaveResult);
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (paramFileSaveResult != null)
    {
      Object localObject;
      if (paramFileSaveResult.d == 1)
      {
        if (paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null)
        {
          localObject = paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((ISingleFileSaveCallBack)((Iterator)localObject).next()).a(paramFileSaveResult, paramInt);
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack;
        if (localObject != null) {
          ((ISaveCallBack)localObject).a(paramFileSaveResult, paramInt);
        }
      }
    }
  }
  
  public void a(ISaveCallBack paramISaveCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack = paramISaveCallBack;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeFileSaveResult exception = ");
          localStringBuilder.append(paramString.getMessage());
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
      }
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
    int j = paramInt2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      String str;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          str = "";
        } else {
          str = "0X8009F8A";
        }
      }
      else {
        str = "0X8009F89";
      }
      paramList = paramList.iterator();
      int m = 0;
      int k = 0;
      int i = 0;
      paramInt2 = 0;
      while (paramList.hasNext()) {
        switch (((FileSaveReq)paramList.next()).jdField_a_of_type_Int)
        {
        default: 
          break;
        case 5: 
        case 7: 
          m += 1;
          break;
        case 4: 
        case 6: 
          k += 1;
          break;
        case 2: 
        case 3: 
          i += 1;
          break;
        case 1: 
          paramInt2 += 1;
        }
      }
      if (j != 0)
      {
        if (j != 1)
        {
          if ((j != 1008) && (j != 2016)) {
            if (j != 3000) {
              if ((j == 1010) || (j == 1011)) {
                break label267;
              }
            }
          }
          switch (j)
          {
          default: 
            paramInt1 = j;
            break;
            paramInt1 = 3;
            break;
          case 1020: 
          case 1021: 
          case 1022: 
          case 1023: 
          case 1024: 
            label267:
            paramInt1 = 4;
            break;
          }
        }
        else
        {
          paramInt1 = 2;
        }
      }
      else {
        paramInt1 = 1;
      }
      if (!TextUtils.isEmpty(str))
      {
        ReportController.b(null, "dc00898", "", "", str, str, paramInt1, 0, String.valueOf(paramInt2), String.valueOf(i), String.valueOf(k), String.valueOf(m));
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("reportSaveMultiFile reportTag = ");
          paramList.append(str);
          paramList.append(", fromType = ");
          paramList.append(paramInt1);
          paramList.append(", picCount = ");
          paramList.append(paramInt2);
          paramList.append(", videoCount = ");
          paramList.append(i);
          paramList.append(", filePicCount = ");
          paramList.append(k);
          paramList.append(", fileVideoCount = ");
          paramList.append(m);
          QLog.d("MultiRichMediaSaveManager", 2, paramList.toString());
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile fileSaveReqList is empty!");
    }
  }
  
  public void a(List<FileSaveReq> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
    }
    paramList = new FileSaveResult();
    paramList.jdField_a_of_type_Int = -1;
    paramList.b = 10006;
    paramList.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(10006);
    a(paramList);
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      paramChatMessage = a(a(paramChatMessage));
      bool1 = bool2;
      if (paramChatMessage != null)
      {
        bool1 = bool2;
        if (paramChatMessage.d == 1)
        {
          bool1 = bool2;
          if (!paramChatMessage.jdField_a_of_type_Boolean)
          {
            bool1 = bool2;
            if (paramChatMessage.c < 100) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
      return false;
    }
    Object localObject;
    switch (paramFileSaveReq.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq == null) {
        break label276;
      }
      return paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
    case 2: 
    case 3: 
      if (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) {
        break label276;
      }
      localObject = SVUtils.a(paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break label276;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break label276;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      break;
    }
    for (;;)
    {
      return true;
      if ((paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)) {
        break;
      }
      localObject = paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
      if (localObject == null) {
        break;
      }
      localObject = ((PicDownloadInfo)localObject).c();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (((File)localObject).length() != paramFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist picture exists");
      }
    }
    label276:
    return false;
  }
  
  public boolean a(List<FileSaveReq> paramList)
  {
    boolean bool3 = AppNetConnInfo.isWifiConn();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (!paramList.isEmpty())
        {
          long l2 = 0L;
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            FileSaveReq localFileSaveReq = (FileSaveReq)paramList.next();
            if (!a(localFileSaveReq))
            {
              long l1;
              switch (localFileSaveReq.jdField_a_of_type_Int)
              {
              default: 
                break;
              case 4: 
              case 5: 
              case 6: 
              case 7: 
                if (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq != null) {
                  l1 = localFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a();
                }
                break;
              case 2: 
              case 3: 
              case 1: 
                for (;;)
                {
                  l2 += l1;
                  break;
                  if ((localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq == null) || (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
                    break;
                  }
                  l1 = localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                  continue;
                  if ((localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || (localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)) {
                    break;
                  }
                  l1 = localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("isSaveNeedTips totalSaveSize = ");
            paramList.append(l2);
            QLog.d("MultiRichMediaSaveManager", 2, paramList.toString());
          }
          bool1 = bool2;
          if (l2 > 29360128L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveISaveCallBack = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelSavePic id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    paramMessageForPic = a(paramMessageForPic);
    Object localObject = a(paramMessageForPic);
    if (localObject != null)
    {
      ((FileSaveResult)localObject).jdField_a_of_type_Boolean = true;
      ((FileSaveResult)localObject).jdField_a_of_type_Int = -1;
      a(paramMessageForPic, (FileSaveResult)localObject);
      e((FileSaveResult)localObject);
      a(paramMessageForPic);
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelSaveVideo id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 != 256)
    {
      if (QLog.isColorLevel())
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("cancelSaveVideo type = ");
        paramMessageForShortVideo.append(paramInt2);
        QLog.i("MultiRichMediaSaveManager", 2, paramMessageForShortVideo.toString());
      }
      return;
    }
    Object localObject = a(paramMessageForShortVideo);
    FileSaveResult localFileSaveResult = a((String)localObject);
    if (localFileSaveResult != null)
    {
      localFileSaveResult.jdField_a_of_type_Boolean = true;
      localFileSaveResult.jdField_a_of_type_Int = -1;
      a((String)localObject, localFileSaveResult);
      e(localFileSaveResult);
    }
    ((ShortVideoPreDownloaderWithSdkSupport)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(FileSaveReq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a((String)localObject);
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
    QFileMultiControlManager localQFileMultiControlManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager;
    if (localQFileMultiControlManager != null)
    {
      localQFileMultiControlManager.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof FileSaveResult))
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)paramMessage.obj;
      if (localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) {
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 6: 
          a(localFileSaveResult, paramMessage.arg1);
          return true;
        case 5: 
          if (localFileSaveResult.d == 1)
          {
            e(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq);
            return true;
          }
          break;
        case 4: 
          a(localFileSaveResult);
          return true;
        case 3: 
          paramMessage = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        case 1: 
        case 2: 
          while (paramMessage.hasNext())
          {
            ((ISingleFileSaveCallBack)paramMessage.next()).b(localFileSaveResult);
            continue;
            if (localFileSaveResult.d == 1)
            {
              d(localFileSaveResult);
              return true;
            }
            if (paramMessage.what == 2)
            {
              this.jdField_a_of_type_Boolean = true;
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("MSG_TYPE_SAVE_FAIL errorCode = ");
                paramMessage.append(localFileSaveResult.b);
                paramMessage.append(", errorMsg = ");
                paramMessage.append(localFileSaveResult.jdField_a_of_type_JavaLangString);
                QLog.i("MultiRichMediaSaveManager", 2, paramMessage.toString());
              }
            }
            else
            {
              this.b = true;
            }
            paramMessage = localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            while (paramMessage.hasNext()) {
              ((ISingleFileSaveCallBack)paramMessage.next()).a(localFileSaveResult);
            }
            if (a())
            {
              b(localFileSaveResult, 100);
              if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
                localFileSaveResult.jdField_a_of_type_Int = 0;
              } else if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
                localFileSaveResult.jdField_a_of_type_Int = -1;
              } else {
                localFileSaveResult.jdField_a_of_type_Int = 3;
              }
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("last result = ");
                paramMessage.append(localFileSaveResult.jdField_a_of_type_Int);
                QLog.i("MultiRichMediaSaveManager", 2, paramMessage.toString());
              }
              this.jdField_a_of_type_Boolean = false;
              this.b = false;
              paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager;
              if (paramMessage != null)
              {
                paramMessage.b();
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMultiControlManager = null;
              }
              a(localFileSaveResult, 200L);
            }
          }
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager
 * JD-Core Version:    0.7.0.1
 */