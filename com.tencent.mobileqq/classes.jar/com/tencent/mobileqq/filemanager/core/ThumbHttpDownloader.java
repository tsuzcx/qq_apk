package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbHttpDownloader
  implements IHttpCommunicatorListener
{
  private static long jdField_a_of_type_Long = 0L;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, ThumbHttpDownloader.DownloadTask> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<ThumbHttpDownloader.DownloadTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = FMSettings.a().d();
  }
  
  public ThumbHttpDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ThumbHttpDownloader.DownloadTask a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      ThumbHttpDownloader.DownloadTask localDownloadTask = (ThumbHttpDownloader.DownloadTask)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localDownloadTask;
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] removeDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramDownloadTask.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramDownloadTask.jdField_d_of_type_JavaLangString) + "]");
      paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramDownloadTask.jdField_d_of_type_JavaLangString, true);
      HttpMsg localHttpMsg = new HttpMsg(paramDownloadTask.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", str);
      localHttpMsg.setRequestProperty("Range", "bytes=0-");
      localHttpMsg.setPriority(5);
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 0;
      localHttpMsg.busiType = 0;
      localHttpMsg.msgId = String.valueOf(paramDownloadTask.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramDownloadTask.jdField_a_of_type_Long + "] start runDownload... , url[" + paramDownloadTask.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localHttpMsg.busiType) + "]");
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramDownloadTask.jdField_a_of_type_Long, localHttpMsg);
      }
      if (!TextUtils.isEmpty(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
        localHttpMsg.setRequestProperty("Cookie", paramDownloadTask.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramDownloadTask.jdField_a_of_type_JavaLangString != null) {
        str = paramDownloadTask.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramDownloadTask.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localHttpMsg.mIsHttps = true;
        localHttpMsg.mIsHostIP = HttpUrlProcessor.a(paramDownloadTask.jdField_a_of_type_JavaLangString);
        localHttpMsg.mReqHost = paramDownloadTask.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramDownloadTask.jdField_b_of_type_JavaLangString);
      }
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramDownloadTask, true);
      if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramDownloadTask.jdField_a_of_type_Long, false, -2, null, paramDownloadTask);
      }
      a(paramDownloadTask.jdField_a_of_type_Long);
      a(paramDownloadTask.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    if (paramDownloadTask == null) {}
    for (;;)
    {
      return;
      paramDownloadTask.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
            ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          }
          if (!paramBoolean) {
            break;
          }
          FileUtil.c(paramDownloadTask.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream: exception");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.b)
    {
      this.b.remove(paramString);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + jdField_a_of_type_Long + "], Name[" + paramString + "] removeDowloadingList,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("-441")) && (!paramString.equals("-443")) && (!paramString.equals("-447")) && (!paramString.equals("-29224")) && (!paramString.equals("-31717"))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    boolean bool = false;
    QLog.i("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,mWaitDowloadTask.size(" + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) + ")");
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i >= 8)
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,but is have" + i + " task downloading, waiting....");
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
          return;
        }
      }
    }
    ThumbHttpDownloader.DownloadTask localDownloadTask = (ThumbHttpDownloader.DownloadTask)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localDownloadTask == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localDownloadTask);
    b(localDownloadTask);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localDownloadTask.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localDownloadTask.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
      bool = localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, localDownloadTask);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramDownloadTask.jdField_a_of_type_Long), paramDownloadTask);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramDownloadTask.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  public long a(String paramString, ThumbHttpDownloader.WhatHappen paramWhatHappen)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ThumbHttpDownloader.DownloadTask localDownloadTask = new ThumbHttpDownloader.DownloadTask();
        localDownloadTask.jdField_c_of_type_JavaLangString = paramString;
        localDownloadTask.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen = paramWhatHappen;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localDownloadTask.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localDownloadTask);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localDownloadTask.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localDownloadTask.jdField_a_of_type_Long;
        return l;
      }
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6, Bundle paramBundle)
  {
    paramString3 = a(paramLong);
    if (paramString3 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetThumbInfo no this task");
      b();
      return;
    }
    if (!paramBoolean1)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlCome failed");
      a(paramString3.jdField_a_of_type_Long);
      a(paramString3.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (paramBoolean2) {
      paramInt = paramShort;
    }
    for (;;)
    {
      paramString3.jdField_b_of_type_JavaLangString = paramString4;
      paramString1 = paramString1 + ":" + paramInt;
      paramString4 = new ArrayList(1);
      paramString4.add(paramString1);
      paramBoolean1 = false;
      paramString1 = null;
      if (paramBundle != null)
      {
        paramBoolean1 = paramBundle.getBoolean("usemediaplatform", false);
        paramString1 = paramBundle.getStringArrayList("ipv6list");
      }
      if (paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null)
      {
        paramString1 = paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] debugIsDisableIPv4OnDoubleStack");
            paramString4.clear();
          }
          paramInt = paramString1.size() - 1;
          while (paramInt >= 0)
          {
            paramString4.add(0, (String)paramString1.get(paramInt));
            paramInt -= 1;
          }
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPv6");
        }
      }
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPList:" + paramString4.toString());
      paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
      if (paramBoolean2) {
        paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
      }
      paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      paramString3.jdField_a_of_type_Boolean = paramBoolean2;
      paramString3.jdField_e_of_type_JavaLangString = paramString5;
      paramString3.jdField_a_of_type_Short = paramShort;
      ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
      return;
    }
  }
  
  public final void decode(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    long l1 = Long.parseLong(???.msgId);
    int j = 0;
    ThumbHttpDownloader.DownloadTask localDownloadTask = a(l1);
    if (localDownloadTask == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    if (paramHttpMsg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -7, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localDownloadTask.jdField_a_of_type_ArrayOfInt)
    {
      if (paramHttpMsg2.getResponseCode() != 206)
      {
        i = j;
        if (paramHttpMsg2.getResponseCode() != 200) {}
      }
      else if (localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localDownloadTask, true);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -8, null, localDownloadTask);
        }
        a(localDownloadTask.jdField_a_of_type_Long);
        a(localDownloadTask.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.write(paramHttpMsg2.getRecvData());
        if (localDownloadTask.jdField_b_of_type_Long == 0L)
        {
          long l2 = paramHttpMsg2.getTotalLen();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localDownloadTask.jdField_b_of_type_Long = l2;
        }
        localDownloadTask.jdField_e_of_type_Long = paramHttpMsg2.getRecvData().length;
        localDownloadTask.jdField_c_of_type_Long += localDownloadTask.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localDownloadTask.jdField_e_of_type_Long + "],total[" + String.valueOf(localDownloadTask.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localDownloadTask.jdField_b_of_type_Long) + "]");
        if (localDownloadTask.jdField_c_of_type_Long >= localDownloadTask.jdField_b_of_type_Long) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        }
      }
      catch (Exception paramHttpMsg2)
      {
        try
        {
          localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localDownloadTask, false);
          boolean bool = true;
          i = 0;
          if (!FileUtils.b(new File(localDownloadTask.jdField_d_of_type_JavaLangString), new File(localDownloadTask.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
            localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, bool, i, localDownloadTask.jdField_c_of_type_JavaLangString, localDownloadTask);
          }
          a(localDownloadTask.jdField_a_of_type_Long);
          a(localDownloadTask.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException paramHttpMsg2)
        {
          paramHttpMsg2.printStackTrace();
          a(localDownloadTask, true);
          if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen == null) {
            break label777;
          }
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -8, null, localDownloadTask);
          a(localDownloadTask.jdField_a_of_type_Long);
          a(localDownloadTask.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        paramHttpMsg2 = paramHttpMsg2;
        paramHttpMsg2.printStackTrace();
        a(localDownloadTask, true);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -8, null, localDownloadTask);
        }
        a(localDownloadTask.jdField_a_of_type_Long);
        a(localDownloadTask.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localDownloadTask.jdField_c_of_type_Long / (float)localDownloadTask.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null)
      {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, k, localDownloadTask);
        i = j;
      }
    }
  }
  
  public final void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l = -1L;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.msgId);
    }
    ThumbHttpDownloader.DownloadTask localDownloadTask = a(l);
    if (localDownloadTask == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (paramHttpMsg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -1, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = paramHttpMsg2.getErrorString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    int i = paramHttpMsg2.errCode;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -3, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (paramHttpMsg1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, i, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!paramHttpMsg2.permitRetry())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if ((paramHttpMsg2.mConn == null) || (!a(paramHttpMsg2.mConn.getHeaderField("User-ReturnCode")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localDownloadTask.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localDownloadTask.jdField_b_of_type_Int + " eofRetry:" + localDownloadTask.jdField_d_of_type_Int);
      localDownloadTask.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localDownloadTask.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localDownloadTask.jdField_b_of_type_Int + " eofRetry:" + localDownloadTask.jdField_d_of_type_Int);
        localDownloadTask.jdField_b_of_type_Int -= 1;
      }
      for (localDownloadTask.jdField_d_of_type_Int += 1;; localDownloadTask.jdField_d_of_type_Int = 0)
      {
        a(localDownloadTask, true);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, localDownloadTask);
        }
        localDownloadTask.jdField_c_of_type_Int += 1;
        a(localDownloadTask);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null) {}
    for (paramHttpMsg1 = localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();; paramHttpMsg1 = null)
    {
      if (paramHttpMsg1 != null)
      {
        localDownloadTask.jdField_b_of_type_Int = 0;
        localDownloadTask.jdField_d_of_type_Int = 0;
        localDownloadTask.jdField_a_of_type_JavaLangString = paramHttpMsg1;
        a(localDownloadTask, true);
        ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.b(localDownloadTask.jdField_a_of_type_Long, localDownloadTask);
        }
        localDownloadTask.jdField_c_of_type_Int += 1;
        a(localDownloadTask);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public final boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader
 * JD-Core Version:    0.7.0.1
 */