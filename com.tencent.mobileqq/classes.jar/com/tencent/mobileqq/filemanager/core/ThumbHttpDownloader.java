package com.tencent.mobileqq.filemanager.core;

import aczc;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbHttpDownloader
  implements IHttpCommunicatorListener
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private List b = new ArrayList();
  
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
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
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
      localHttpMsg.a("Net-type", str);
      localHttpMsg.a("Range", "bytes=0-");
      localHttpMsg.b(5);
      localHttpMsg.a(true);
      localHttpMsg.jdField_b_of_type_Int = 0;
      localHttpMsg.jdField_c_of_type_Int = 0;
      localHttpMsg.jdField_a_of_type_JavaLangString = String.valueOf(paramDownloadTask.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramDownloadTask.jdField_a_of_type_Long + "] start runDownload... , url[" + paramDownloadTask.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localHttpMsg.jdField_c_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramDownloadTask.jdField_a_of_type_Long, localHttpMsg);
      }
      if (!TextUtils.isEmpty(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
        localHttpMsg.a("Cookie", paramDownloadTask.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramDownloadTask.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localHttpMsg);
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
      b(paramDownloadTask.jdField_d_of_type_JavaLangString);
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
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
      b(localDownloadTask.jdField_d_of_type_JavaLangString);
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
  
  private void b(String paramString)
  {
    synchronized (this.b)
    {
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] call removeDowloadingList [" + paramString + "] in mListDownloadTask:" + str);
        }
      }
    }
    this.b.remove(paramString);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + jdField_a_of_type_Long + "], Name[" + paramString + "] removeDowloadingList,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public void a(long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    paramString3 = a(paramLong);
    if (paramString3 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetThumbInfo no this task");
      b();
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlCome failed");
      a(paramString3.jdField_a_of_type_Long);
      b(paramString3.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    paramString3.jdField_b_of_type_JavaLangString = paramString4;
    paramString1 = paramString1 + ":" + paramInt;
    paramString4 = new ArrayList(1);
    paramString4.add(paramString1);
    paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    ThreadManager.post(new aczc(this, paramString3), 8, null, false);
  }
  
  public final void a(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
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
      b(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localDownloadTask.jdField_a_of_type_ArrayOfInt)
    {
      if (paramHttpMsg2.c() != 206)
      {
        i = j;
        if (paramHttpMsg2.c() != 200) {}
      }
      else if (localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localDownloadTask, true);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -8, null, localDownloadTask);
        }
        a(localDownloadTask.jdField_a_of_type_Long);
        b(localDownloadTask.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.write(paramHttpMsg2.a());
        if (localDownloadTask.jdField_b_of_type_Long == 0L)
        {
          long l2 = paramHttpMsg2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localDownloadTask.jdField_b_of_type_Long = l2;
        }
        localDownloadTask.e = paramHttpMsg2.a().length;
        localDownloadTask.jdField_c_of_type_Long += localDownloadTask.e;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localDownloadTask.e + "],total[" + String.valueOf(localDownloadTask.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localDownloadTask.jdField_b_of_type_Long) + "]");
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
          b(localDownloadTask.jdField_d_of_type_JavaLangString);
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
          b(localDownloadTask.jdField_d_of_type_JavaLangString);
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
        b(localDownloadTask.jdField_d_of_type_JavaLangString);
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
  
  public void a(String paramString) {}
  
  public final boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public final void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l = -1L;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.jdField_a_of_type_JavaLangString);
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
      b(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = paramHttpMsg2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    int i = paramHttpMsg2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -3, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      b(localDownloadTask.jdField_d_of_type_JavaLangString);
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
      b(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (paramHttpMsg2.d()) {
        break;
      }
      i = -4;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader
 * JD-Core Version:    0.7.0.1
 */