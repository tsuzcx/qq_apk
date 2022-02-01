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
  protected IAIOImageProviderCallBack a;
  private QQAppInterface b;
  private ConcurrentHashMap<String, FileSaveResult> c = new ConcurrentHashMap();
  private ISaveCallBack d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private long h = 0L;
  private QFileMultiControlManager i;
  private Handler j;
  
  public MultiRichMediaSaveManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.j = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt, FileSaveReq paramFileSaveReq)
  {
    FileSaveResult localFileSaveResult = new FileSaveResult();
    localFileSaveResult.b = -1;
    localFileSaveResult.g = paramFileSaveReq;
    localFileSaveResult.c = paramInt;
    localFileSaveResult.d = FileSaveErrorInfo.a(paramInt);
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
      paramQFileMultiSaveReq.a(paramQFileMultiSaveReq.d(), new MultiRichMediaSaveManager.10(this, paramQFileMultiSaveReq));
    }
  }
  
  private void a(FileSaveReq paramFileSaveReq, int paramInt)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.b != null))
    {
      paramFileSaveReq = a(paramFileSaveReq.b.f);
      FileSaveResult localFileSaveResult = a(paramFileSaveReq);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        paramInt /= 100;
        localFileSaveResult.e = paramInt;
        a(paramFileSaveReq, localFileSaveResult);
        c(localFileSaveResult, paramInt);
      }
    }
  }
  
  private void a(FileSaveReq paramFileSaveReq, boolean paramBoolean)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.d != null))
    {
      Object localObject2 = paramFileSaveReq.d.b();
      Object localObject1 = a((String)localObject2);
      if ((localObject1 != null) && (!((FileSaveResult)localObject1).a))
      {
        ((FileSaveResult)localObject1).a = true;
        ((FileSaveResult)localObject1).e = 100;
        a((String)localObject2, (FileSaveResult)localObject1);
        if (paramBoolean)
        {
          switch (paramFileSaveReq.a)
          {
          default: 
            return;
          case 5: 
          case 7: 
          case 9: 
            a(paramFileSaveReq.d);
            return;
          }
          paramFileSaveReq = paramFileSaveReq.d.d();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramFileSaveReq);
          ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTime());
          localObject2 = Utils.Crc64String(((StringBuilder)localObject2).toString());
          ((FileSaveResult)localObject1).b = 0;
          a(paramFileSaveReq, (String)localObject2, (FileSaveResult)localObject1);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dealFileMultilDownloadComplete errorType= ");
          ((StringBuilder)localObject2).append(paramFileSaveReq.a);
          QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject2).toString());
        }
        ((FileSaveResult)localObject1).b = -1;
        b((FileSaveResult)localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dealFileMultilDownloadComplete fileType= ");
        ((StringBuilder)localObject1).append(paramFileSaveReq.a);
        QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void a(FileSaveResult paramFileSaveResult, long paramLong)
  {
    Message localMessage = this.j.obtainMessage(4);
    localMessage.obj = paramFileSaveResult;
    this.j.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, FileSaveResult paramFileSaveResult)
  {
    int k;
    if (TextUtils.isEmpty(paramString1)) {
      k = 10001;
    } else if (TextUtils.isEmpty(paramString2)) {
      k = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      k = 10003;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("savePictureFile fail, errorCode = ");
        paramString1.append(k);
        QLog.e("MultiRichMediaSaveManager", 2, paramString1.toString());
      }
      if ((paramFileSaveResult != null) && (paramFileSaveResult.g != null))
      {
        paramFileSaveResult.b = -1;
        paramFileSaveResult.c = k;
        paramFileSaveResult.d = FileSaveErrorInfo.a(k);
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
    ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.j, paramFileSaveResult, false));
  }
  
  private void b(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.b != null) && (paramFileSaveReq.b.f != null))
    {
      String str = a(paramFileSaveReq.b.f);
      FileSaveResult localFileSaveResult = a(str);
      if ((localFileSaveResult != null) && (localFileSaveResult.g != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.a = true;
        localFileSaveResult.b = paramInt1;
        localFileSaveResult.e = 100;
        a(str, localFileSaveResult);
        if (paramInt1 == 0)
        {
          paramFileSaveReq = paramFileSaveReq.b.f.f();
          paramString = new StringBuilder();
          paramString.append(paramFileSaveReq);
          paramString.append(NetConnInfoCenter.getServerTime());
          a(paramFileSaveReq, Utils.Crc64String(paramString.toString()), localFileSaveResult);
          return;
        }
        localFileSaveResult.c = paramInt2;
        localFileSaveResult.d = paramString;
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
    Message localMessage = this.j.obtainMessage(2);
    localMessage.obj = paramFileSaveResult;
    this.j.sendMessage(localMessage);
  }
  
  private void b(FileSaveResult paramFileSaveResult, int paramInt)
  {
    Message localMessage = this.j.obtainMessage(6);
    localMessage.obj = paramFileSaveResult;
    localMessage.arg1 = paramInt;
    this.j.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, FileSaveResult paramFileSaveResult)
  {
    int k;
    if (TextUtils.isEmpty(paramString1)) {
      k = 10001;
    } else if (TextUtils.isEmpty(paramString2)) {
      k = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      k = 10003;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("saveShortVideoFile fail, errorCode = ");
        paramString1.append(k);
        QLog.e("MultiRichMediaSaveManager", 2, paramString1.toString());
      }
      if ((paramFileSaveResult != null) && (paramFileSaveResult.g != null))
      {
        paramFileSaveResult.b = -1;
        paramFileSaveResult.c = k;
        paramFileSaveResult.d = FileSaveErrorInfo.a(k);
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
    ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.j, paramFileSaveResult, false));
  }
  
  private void b(List<FileSaveReq> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((FileSaveReq)paramList.next());
    }
  }
  
  private void c(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      switch (paramFileSaveReq.a)
      {
      default: 
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        if (paramFileSaveReq.d != null) {
          paramFileSaveReq = paramFileSaveReq.d.b();
        }
        break;
      case 2: 
      case 3: 
        if (paramFileSaveReq.c != null) {
          paramFileSaveReq = a(paramFileSaveReq.c.e);
        }
        break;
      case 1: 
        if (paramFileSaveReq.b != null) {
          paramFileSaveReq = a(paramFileSaveReq.b.f);
        }
        break;
      }
      paramFileSaveReq = "";
      b(paramFileSaveReq);
    }
  }
  
  private void c(FileSaveResult paramFileSaveResult)
  {
    if (paramFileSaveResult != null)
    {
      HashMap localHashMap = new HashMap();
      if (paramFileSaveResult.f == 1) {
        localHashMap.put("isMultiSave", "1");
      } else {
        localHashMap.put("isMultiSave", "0");
      }
      if (paramFileSaveResult.b == 0)
      {
        localHashMap.put("isSuccess", "0");
      }
      else
      {
        localHashMap.put("isSuccess", "1");
        localHashMap.put("errorCode", String.valueOf(paramFileSaveResult.c));
        localHashMap.put("isSuccess", paramFileSaveResult.d);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
    }
  }
  
  private void c(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (paramFileSaveResult != null)
    {
      paramFileSaveResult.e = paramInt;
      d(paramFileSaveResult, paramInt);
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
      if (paramFileSaveResult.h != null)
      {
        IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a;
        if (localIAIOImageProviderCallBack != null) {
          localIAIOImageProviderCallBack.a(paramFileSaveResult.h.a, paramFileSaveResult.h.b, paramFileSaveResult.h.c, paramFileSaveResult.h.d, paramFileSaveResult.h.e, paramFileSaveResult.h.f);
        }
      }
    }
  }
  
  private void d(FileSaveResult paramFileSaveResult, int paramInt)
  {
    Object localObject = this.c.entrySet().iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.g != null))
      {
        label155:
        float f1;
        float f2;
        switch (localFileSaveResult.g.a)
        {
        default: 
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          if (localFileSaveResult.g.d != null) {
            if (localFileSaveResult.a)
            {
              l2 = localFileSaveResult.g.d.a();
              l1 += l2;
            }
            else
            {
              f1 = (float)l1;
              f2 = (float)localFileSaveResult.g.d.a();
              paramInt = localFileSaveResult.e;
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
            if ((localFileSaveResult.g.c == null) || (localFileSaveResult.g.c.j == null)) {
              break;
            }
            if (localFileSaveResult.a)
            {
              l2 = localFileSaveResult.g.c.j.videoFileSize;
              break label155;
            }
            f1 = (float)l1;
            f2 = localFileSaveResult.g.c.j.videoFileSize;
            paramInt = localFileSaveResult.e;
            continue;
            if ((localFileSaveResult.g.b == null) || (localFileSaveResult.g.b.l == null)) {
              break;
            }
            if (localFileSaveResult.a)
            {
              l2 = localFileSaveResult.g.b.l.size;
              break label155;
            }
            f1 = (float)l1;
            f2 = (float)localFileSaveResult.g.b.l.size;
            paramInt = localFileSaveResult.e;
          }
        }
      }
    }
    long l2 = this.h;
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
    paramFileSaveResult.f = 0;
    b(paramFileSaveResult, paramInt);
  }
  
  private boolean d(FileSaveReq paramFileSaveReq)
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
    switch (paramFileSaveReq.a)
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
      if (paramFileSaveReq.d != null)
      {
        bool2 = paramFileSaveReq.d.f();
        bool1 = bool2;
        if (bool2)
        {
          paramFileSaveReq.d.a(new MultiRichMediaSaveManager.5(this, paramFileSaveReq));
          localObject = this.i;
          bool1 = bool2;
          if (localObject != null)
          {
            ((QFileMultiControlManager)localObject).a(paramFileSaveReq.d.c());
            return bool2;
          }
        }
      }
      break;
    case 2: 
      if ((paramFileSaveReq.c != null) && (paramFileSaveReq.c.e != null))
      {
        localObject = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(paramFileSaveReq.c.e.e, paramFileSaveReq.c.e.g);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if ((localObject instanceof BaseDownloadProcessor))
          {
            localObject = (BaseDownloadProcessor)localObject;
            if ((((BaseDownloadProcessor)localObject).mUiRequest != null) && ((((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 7) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 16) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 18) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 68)))
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
      if ((paramFileSaveReq.b != null) && (paramFileSaveReq.b.f != null) && (paramFileSaveReq.b.l != null))
      {
        if ((paramFileSaveReq.b.l != null) && (paramFileSaveReq.b.l.fileSizeFlag == 1)) {
          return false;
        }
        localObject = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramFileSaveReq.b.l.md5, paramFileSaveReq.b.l.uuid, 1));
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
  
  private void e(FileSaveReq paramFileSaveReq)
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
      ((StringBuilder)localObject).append(paramFileSaveReq.a);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder;
    switch (paramFileSaveReq.a)
    {
    default: 
      return;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      if (paramFileSaveReq.d != null)
      {
        localObject = paramFileSaveReq.d.b();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadFile key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.d.a(new MultiRichMediaSaveManager.9(this, (String)localObject, paramFileSaveReq));
        localObject = this.i;
        if (localObject != null) {
          ((QFileMultiControlManager)localObject).a(paramFileSaveReq.d.c());
        }
        paramFileSaveReq.d.g();
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 3: 
      if (paramFileSaveReq.c != null)
      {
        localObject = a(paramFileSaveReq.c.e);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadVideo key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.c.n = true;
        paramFileSaveReq.c.o = new MultiRichMediaSaveManager.8(this, paramFileSaveReq, (String)localObject);
        ((ShortVideoPreDownloaderWithSdkSupport)this.b.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(paramFileSaveReq);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    case 2: 
      if (paramFileSaveReq.c != null)
      {
        localObject = a(paramFileSaveReq.c.e);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadShortVideo key = ");
          localStringBuilder.append((String)localObject);
          QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
        }
        paramFileSaveReq.c.a(new MultiRichMediaSaveManager.7(this, (String)localObject, paramFileSaveReq));
        ShortVideoBusiManager.a(paramFileSaveReq.c, this.b);
        return;
      }
      a(10007, paramFileSaveReq);
      return;
    }
    if (paramFileSaveReq.b != null)
    {
      localObject = a(paramFileSaveReq.b.f);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadPic key = ");
        localStringBuilder.append((String)localObject);
        QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
      }
      paramFileSaveReq.b.a(new MultiRichMediaSaveManager.6(this, (String)localObject, paramFileSaveReq));
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramFileSaveReq.b);
      return;
    }
    a(10007, paramFileSaveReq);
  }
  
  private void e(FileSaveResult paramFileSaveResult)
  {
    Message localMessage = this.j.obtainMessage(5);
    localMessage.obj = paramFileSaveResult;
    this.j.sendMessage(localMessage);
  }
  
  private boolean e()
  {
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult == null) || (!localFileSaveResult.a)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void f(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      switch (paramFileSaveReq.a)
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
  
  private boolean f()
  {
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.f == 1) && (!localFileSaveResult.a)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private long g()
  {
    Object localObject;
    if (!this.c.isEmpty())
    {
      this.h = 0L;
      localObject = this.c.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.g != null)) {
          switch (localFileSaveResult.g.a)
          {
          default: 
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localFileSaveResult.g.d != null) {
              this.h += localFileSaveResult.g.d.a();
            }
            break;
          case 2: 
          case 3: 
            if ((localFileSaveResult.g.c != null) && (localFileSaveResult.g.c.j != null)) {
              this.h += localFileSaveResult.g.c.j.videoFileSize;
            }
            break;
          case 1: 
            if ((localFileSaveResult.g.b != null) && (localFileSaveResult.g.b.l != null)) {
              this.h += localFileSaveResult.g.b.l.size;
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
      ((StringBuilder)localObject).append(this.h);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    return this.h;
  }
  
  private void g(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      paramFileSaveReq = paramFileSaveReq.e.iterator();
      while (paramFileSaveReq.hasNext()) {
        ((ISingleFileSaveCallBack)paramFileSaveReq.next()).a();
      }
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveBegin");
    }
    this.g = true;
    this.h = g();
    ISaveCallBack localISaveCallBack = this.d;
    if (localISaveCallBack != null) {
      localISaveCallBack.a();
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    ISaveCallBack localISaveCallBack = this.d;
    if (localISaveCallBack != null) {
      localISaveCallBack.b();
    }
    this.g = false;
    this.h = 0L;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    ISaveCallBack localISaveCallBack = this.d;
    if (localISaveCallBack != null) {
      localISaveCallBack.c();
    }
  }
  
  private void k()
  {
    Iterator localIterator1 = this.c.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      FileSaveResult localFileSaveResult = (FileSaveResult)localEntry.getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.g != null) && (localFileSaveResult.f == 1))
      {
        Iterator localIterator2 = localFileSaveResult.g.e.iterator();
        while (localIterator2.hasNext()) {
          ((ISingleFileSaveCallBack)localIterator2.next()).a();
        }
        localFileSaveResult.f = 0;
        a((String)localEntry.getKey(), localFileSaveResult);
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelDownloading");
    }
    if (this.c.isEmpty()) {
      return;
    }
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
      if ((localFileSaveResult != null) && (localFileSaveResult.g != null))
      {
        Object localObject;
        switch (localFileSaveResult.g.a)
        {
        default: 
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
          if (localFileSaveResult.g.d != null) {
            localFileSaveResult.g.d.h();
          }
          break;
        case 3: 
          if ((localFileSaveResult.g.c != null) && (localFileSaveResult.g.c.j != null)) {
            ((ShortVideoPreDownloaderWithSdkSupport)this.b.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(localFileSaveResult.g);
          }
          break;
        case 2: 
          if (localFileSaveResult.g.c != null) {
            localObject = localFileSaveResult.g.c.e;
          }
          localObject = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(localFileSaveResult.g.c.e.e, localFileSaveResult.g.c.e.g);
          if ((localObject instanceof BaseDownloadProcessor)) {
            ((BaseDownloadProcessor)localObject).cancel();
          }
          break;
        case 1: 
          if ((localFileSaveResult.g.b != null) && (localFileSaveResult.g.b.l != null))
          {
            IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.g.b.l.md5, localFileSaveResult.g.b.l.uuid, 131075));
            localObject = localIHttpCommunicatorListener;
            if (localIHttpCommunicatorListener == null) {
              localObject = ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(localFileSaveResult.g.b.l.md5, localFileSaveResult.g.b.l.uuid, 1));
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
  
  private void m()
  {
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        FileSaveResult localFileSaveResult = (FileSaveResult)((Map.Entry)localIterator.next()).getValue();
        if ((localFileSaveResult != null) && (localFileSaveResult.g != null)) {
          localFileSaveResult.g.e.clear();
        }
      }
    }
  }
  
  public FileSaveResult a(String paramString)
  {
    return (FileSaveResult)this.c.get(paramString);
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
      localStringBuilder.append(paramPicDownloadInfo.e);
      localStringBuilder.append(paramPicDownloadInfo.g);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramShortVideoDownloadInfo.e);
      localStringBuilder.append(paramShortVideoDownloadInfo.g);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a()
  {
    l();
    d();
  }
  
  public void a(Activity paramActivity, List<FileSaveReq> paramList)
  {
    a(paramActivity, DialogUtil.a(paramActivity, 230, paramActivity.getString(2131915874), paramActivity.getString(2131915873), new MultiRichMediaSaveManager.1(this, paramList), new MultiRichMediaSaveManager.2(this)));
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    this.a = paramIAIOImageProviderCallBack;
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
        localFileSaveResult.g = FileSaveReq.a(paramMessageForPic);
        localFileSaveResult.f = 1;
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
      localObject = FileSaveReq.b(this.b, paramMessageForShortVideo);
      if ((localObject != null) && (((FileSaveReq)localObject).c != null))
      {
        paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
        if (a(paramMessageForShortVideo) == null)
        {
          FileSaveResult localFileSaveResult = new FileSaveResult();
          localFileSaveResult.g = ((FileSaveReq)localObject);
          localFileSaveResult.f = 1;
          a(paramMessageForShortVideo, localFileSaveResult);
        }
        if ((a((FileSaveReq)localObject)) && (((FileSaveReq)localObject).c.j != null) && (this.a != null))
        {
          paramMessageForShortVideo = SVUtils.a(((FileSaveReq)localObject).c.j, "mp4");
          this.a.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
          return;
        }
        ((FileSaveReq)localObject).c.n = true;
        ((FileSaveReq)localObject).c.o = new MultiRichMediaSaveManager.12(this, paramLong, (FileSaveReq)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
        ((ShortVideoPreDownloaderWithSdkSupport)this.b.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a((FileSaveReq)localObject);
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
  
  public void a(FileSaveReq paramFileSaveReq, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramFileSaveReq != null) && (paramFileSaveReq.c != null) && (paramFileSaveReq.c.e != null))
    {
      Object localObject = a(paramFileSaveReq.c.e);
      FileSaveResult localFileSaveResult = a((String)localObject);
      if ((localFileSaveResult != null) && (localFileSaveResult.g != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.a = true;
        localFileSaveResult.b = paramInt1;
        localFileSaveResult.e = 100;
        a((String)localObject, localFileSaveResult);
        if (paramInt1 == 0)
        {
          paramFileSaveReq = new File(paramFileSaveReq.c.e.o);
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
        localFileSaveResult.c = paramInt2;
        localFileSaveResult.d = paramString;
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
      if (paramFileSaveResult.f == 1)
      {
        if (paramFileSaveResult.g != null)
        {
          localObject = paramFileSaveResult.g.e.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ISingleFileSaveCallBack localISingleFileSaveCallBack = (ISingleFileSaveCallBack)((Iterator)localObject).next();
            if (paramFileSaveResult.b == 0) {
              localISingleFileSaveCallBack.a(paramFileSaveResult, 100);
            }
            localISingleFileSaveCallBack.a(paramFileSaveResult);
          }
        }
        c(paramFileSaveResult.g);
        c(paramFileSaveResult);
        return;
      }
      Object localObject = this.d;
      if (localObject != null) {
        ((ISaveCallBack)localObject).a(paramFileSaveResult);
      }
      this.g = false;
      this.h = 0L;
      this.c.clear();
      c(paramFileSaveResult);
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (paramFileSaveResult != null)
    {
      Object localObject;
      if (paramFileSaveResult.f == 1)
      {
        if (paramFileSaveResult.g != null)
        {
          localObject = paramFileSaveResult.g.e.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((ISingleFileSaveCallBack)((Iterator)localObject).next()).a(paramFileSaveResult, paramInt);
          }
        }
      }
      else
      {
        localObject = this.d;
        if (localObject != null) {
          ((ISaveCallBack)localObject).a(paramFileSaveResult, paramInt);
        }
      }
    }
  }
  
  public void a(ISaveCallBack paramISaveCallBack)
  {
    this.d = paramISaveCallBack;
  }
  
  public void a(String paramString, FileSaveResult paramFileSaveResult)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.put(paramString, paramFileSaveResult);
    }
  }
  
  public void a(List<FileSaveReq> paramList, int paramInt1, int paramInt2)
  {
    int m = paramInt2;
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
      int i1 = 0;
      int n = 0;
      int k = 0;
      paramInt2 = 0;
      while (paramList.hasNext()) {
        switch (((FileSaveReq)paramList.next()).a)
        {
        default: 
          break;
        case 5: 
        case 7: 
          i1 += 1;
          break;
        case 4: 
        case 6: 
          n += 1;
          break;
        case 2: 
        case 3: 
          k += 1;
          break;
        case 1: 
          paramInt2 += 1;
        }
      }
      if (m != 0)
      {
        if (m != 1)
        {
          if ((m != 1008) && (m != 2016)) {
            if (m != 3000) {
              if ((m == 1010) || (m == 1011)) {
                break label267;
              }
            }
          }
          switch (m)
          {
          default: 
            paramInt1 = m;
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
        ReportController.b(null, "dc00898", "", "", str, str, paramInt1, 0, String.valueOf(paramInt2), String.valueOf(k), String.valueOf(n), String.valueOf(i1));
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
          paramList.append(k);
          paramList.append(", filePicCount = ");
          paramList.append(n);
          paramList.append(", fileVideoCount = ");
          paramList.append(i1);
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
      if (f()) {
        k();
      }
      if ((paramBoolean) && (a(paramList)))
      {
        j();
        return;
      }
      b(paramList);
      h();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FileSaveReq localFileSaveReq = (FileSaveReq)paramList.next();
        if (a(localFileSaveReq)) {
          f(localFileSaveReq);
        } else if (!d(localFileSaveReq)) {
          e(localFileSaveReq);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
    }
    paramList = new FileSaveResult();
    paramList.b = -1;
    paramList.c = 10006;
    paramList.d = FileSaveErrorInfo.a(10006);
    a(paramList);
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
    switch (paramFileSaveReq.a)
    {
    default: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      if (paramFileSaveReq.d == null) {
        break label276;
      }
      return paramFileSaveReq.d.e();
    case 2: 
    case 3: 
      if (paramFileSaveReq.c == null) {
        break label276;
      }
      localObject = SVUtils.a(paramFileSaveReq.c.j, "mp4");
      if (localObject == null) {
        break label276;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramFileSaveReq.c.j == null) || (((File)localObject).length() != paramFileSaveReq.c.j.videoFileSize)) {
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
      if ((paramFileSaveReq.b == null) || (paramFileSaveReq.b.l == null)) {
        break;
      }
      localObject = paramFileSaveReq.b.l.getPicDownloadInfo();
      if (localObject == null) {
        break;
      }
      localObject = ((PicDownloadInfo)localObject).f();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (((File)localObject).length() != paramFileSaveReq.b.l.size)) {
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
              switch (localFileSaveReq.a)
              {
              default: 
                break;
              case 4: 
              case 5: 
              case 6: 
              case 7: 
                if (localFileSaveReq.d != null) {
                  l1 = localFileSaveReq.d.a();
                }
                break;
              case 2: 
              case 3: 
              case 1: 
                for (;;)
                {
                  l2 += l1;
                  break;
                  if ((localFileSaveReq.c == null) || (localFileSaveReq.c.j == null)) {
                    break;
                  }
                  l1 = localFileSaveReq.c.j.videoFileSize;
                  continue;
                  if ((localFileSaveReq.b == null) || (localFileSaveReq.b.l == null)) {
                    break;
                  }
                  l1 = localFileSaveReq.b.l.size;
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
    this.d = null;
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
      ((FileSaveResult)localObject).a = true;
      ((FileSaveResult)localObject).b = -1;
      a(paramMessageForPic, (FileSaveResult)localObject);
      e((FileSaveResult)localObject);
      b(paramMessageForPic);
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
      localFileSaveResult.a = true;
      localFileSaveResult.b = -1;
      a((String)localObject, localFileSaveResult);
      e(localFileSaveResult);
    }
    ((ShortVideoPreDownloaderWithSdkSupport)this.b.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(FileSaveReq.b(this.b, paramMessageForShortVideo));
    b((String)localObject);
  }
  
  public void b(FileSaveReq paramFileSaveReq)
  {
    if (paramFileSaveReq != null)
    {
      FileSaveResult localFileSaveResult;
      switch (paramFileSaveReq.a)
      {
      default: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        if (this.i == null)
        {
          this.i = new QFileMultiControlManager(this.b);
          this.i.a();
        }
        if (paramFileSaveReq.d != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.g = paramFileSaveReq;
          this.c.put(paramFileSaveReq.d.b(), localFileSaveResult);
          return;
        }
        break;
      case 2: 
      case 3: 
        if (paramFileSaveReq.c != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.g = paramFileSaveReq;
          paramFileSaveReq = a(paramFileSaveReq.c.e);
          if (!TextUtils.isEmpty(paramFileSaveReq))
          {
            this.c.put(paramFileSaveReq, localFileSaveResult);
            return;
          }
        }
        break;
      case 1: 
        if (paramFileSaveReq.b != null)
        {
          localFileSaveResult = new FileSaveResult();
          localFileSaveResult.g = paramFileSaveReq;
          paramFileSaveReq = a(paramFileSaveReq.b.f);
          if (!TextUtils.isEmpty(paramFileSaveReq)) {
            this.c.put(paramFileSaveReq, localFileSaveResult);
          }
        }
        break;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.c.remove(paramString);
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
  
  public boolean b(ChatMessage paramChatMessage)
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
        if (paramChatMessage.f == 1)
        {
          bool1 = bool2;
          if (!paramChatMessage.a)
          {
            bool1 = bool2;
            if (paramChatMessage.e < 100) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void c()
  {
    this.a = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    m();
    this.c.clear();
    this.d = null;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = 0L;
    QFileMultiControlManager localQFileMultiControlManager = this.i;
    if (localQFileMultiControlManager != null)
    {
      localQFileMultiControlManager.b();
      this.i = null;
    }
    this.j.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof FileSaveResult))
    {
      FileSaveResult localFileSaveResult = (FileSaveResult)paramMessage.obj;
      if (localFileSaveResult.g != null) {
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 6: 
          a(localFileSaveResult, paramMessage.arg1);
          return true;
        case 5: 
          if (localFileSaveResult.f == 1)
          {
            g(localFileSaveResult.g);
            return true;
          }
          break;
        case 4: 
          a(localFileSaveResult);
          return true;
        case 3: 
          paramMessage = localFileSaveResult.g.e.iterator();
        case 1: 
        case 2: 
          while (paramMessage.hasNext())
          {
            ((ISingleFileSaveCallBack)paramMessage.next()).b(localFileSaveResult);
            continue;
            if (localFileSaveResult.f == 1)
            {
              d(localFileSaveResult);
              return true;
            }
            if (paramMessage.what == 2)
            {
              this.e = true;
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("MSG_TYPE_SAVE_FAIL errorCode = ");
                paramMessage.append(localFileSaveResult.c);
                paramMessage.append(", errorMsg = ");
                paramMessage.append(localFileSaveResult.d);
                QLog.i("MultiRichMediaSaveManager", 2, paramMessage.toString());
              }
            }
            else
            {
              this.f = true;
            }
            paramMessage = localFileSaveResult.g.e.iterator();
            while (paramMessage.hasNext()) {
              ((ISingleFileSaveCallBack)paramMessage.next()).a(localFileSaveResult);
            }
            if (e())
            {
              b(localFileSaveResult, 100);
              if ((this.f) && (!this.e)) {
                localFileSaveResult.b = 0;
              } else if ((this.e) && (!this.f)) {
                localFileSaveResult.b = -1;
              } else {
                localFileSaveResult.b = 3;
              }
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("last result = ");
                paramMessage.append(localFileSaveResult.b);
                QLog.i("MultiRichMediaSaveManager", 2, paramMessage.toString());
              }
              this.e = false;
              this.f = false;
              paramMessage = this.i;
              if (paramMessage != null)
              {
                paramMessage.b();
                this.i = null;
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
    i();
    l();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager
 * JD-Core Version:    0.7.0.1
 */