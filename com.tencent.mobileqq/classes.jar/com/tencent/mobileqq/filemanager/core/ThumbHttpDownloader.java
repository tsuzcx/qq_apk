package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
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
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, ThumbHttpDownloader.DownloadTask> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<ThumbHttpDownloader.DownloadTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = FMSettings.a().getDefaultThumbPath();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] removeDowloadingTask,size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[downloadThumb]  ID[");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] runDownload...tmpname[");
      ((StringBuilder)localObject).append(String.valueOf(paramDownloadTask.jdField_d_of_type_JavaLangString));
      ((StringBuilder)localObject).append("]");
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramDownloadTask.jdField_d_of_type_JavaLangString, true);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      label86:
      HttpMsg localHttpMsg;
      break label86;
    }
    a(paramDownloadTask, true);
    if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramDownloadTask.jdField_a_of_type_Long, false, -2, null, paramDownloadTask);
    }
    a(paramDownloadTask.jdField_a_of_type_Long);
    a(paramDownloadTask.jdField_d_of_type_JavaLangString);
    b();
    return;
    localHttpMsg = new HttpMsg(paramDownloadTask.jdField_a_of_type_JavaLangString, null, this, true);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    localHttpMsg.setRequestProperty("Net-type", (String)localObject);
    localHttpMsg.setRequestProperty("Range", "bytes=0-");
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = 0;
    localHttpMsg.busiType = 0;
    localHttpMsg.msgId = String.valueOf(paramDownloadTask.jdField_a_of_type_Long);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb]  ID[");
    ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] start runDownload... , url[");
    ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] data RANGE[");
    ((StringBuilder)localObject).append("bytes=0-");
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(localHttpMsg.busiType));
    ((StringBuilder)localObject).append("]");
    QLog.d("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramDownloadTask.jdField_a_of_type_Long, localHttpMsg);
    }
    if (!TextUtils.isEmpty(paramDownloadTask.jdField_b_of_type_JavaLangString)) {
      localHttpMsg.setRequestProperty("Cookie", paramDownloadTask.jdField_b_of_type_JavaLangString);
    }
    if (paramDownloadTask.jdField_a_of_type_JavaLangString != null) {
      localObject = paramDownloadTask.jdField_a_of_type_JavaLangString.toLowerCase();
    } else {
      localObject = "";
    }
    if ((paramDownloadTask.jdField_a_of_type_Boolean) && (((String)localObject).startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = HttpUrlProcessor.a(paramDownloadTask.jdField_a_of_type_JavaLangString);
      localHttpMsg.mReqHost = paramDownloadTask.jdField_e_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cookie:");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_b_of_type_JavaLangString);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
    paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    if (paramDownloadTask == null) {
      return;
    }
    paramDownloadTask.jdField_c_of_type_Long = 0L;
    try
    {
      StringBuilder localStringBuilder1;
      if (paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.close();
        paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[downloadThumb][");
        localStringBuilder1.append(jdField_a_of_type_Long);
        localStringBuilder1.append("]. closeFileStream:");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[downloadThumb][");
        localStringBuilder1.append(jdField_a_of_type_Long);
        localStringBuilder1.append("]. closeFileStream.had closed: stream = null:");
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder1.toString());
      }
    }
    catch (IOException localIOException)
    {
      paramDownloadTask.jdField_a_of_type_JavaIoFileOutputStream = null;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[downloadThumb][");
      localStringBuilder2.append(jdField_a_of_type_Long);
      localStringBuilder2.append("]. closeFileStream: exception");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder2.toString());
      localIOException.printStackTrace();
    }
    if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    if (paramBoolean) {
      FileUtil.c(paramDownloadTask.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.b)
    {
      this.b.remove(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(jdField_a_of_type_Long);
      localStringBuilder.append("], Name[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] removeDowloadingList,size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717"));
  }
  
  private void b()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("[downloadThumb]  downloadNext ,mWaitDowloadTask.size(");
    ((StringBuilder)???).append(String.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    ((StringBuilder)???).append(")");
    QLog.i("ThumbHttpDownloader<FileAssistant>", 2, ((StringBuilder)???).toString());
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      Object localObject2;
      if (i >= 8)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[downloadThumb]  downloadNext ,but is have");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" task downloading, waiting....");
        QLog.w("ThumbHttpDownloader<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
          return;
        }
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        boolean bool = false;
        localObject2 = (ThumbHttpDownloader.DownloadTask)((List)localObject2).get(0);
        if (localObject2 == null)
        {
          QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
          this.jdField_a_of_type_JavaUtilList.remove(0);
          b();
          return;
        }
        this.jdField_a_of_type_JavaUtilList.remove(localObject2);
        b((ThumbHttpDownloader.DownloadTask)localObject2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[downloadThumb]  ID[");
        ((StringBuilder)???).append(((ThumbHttpDownloader.DownloadTask)localObject2).jdField_a_of_type_Long);
        ((StringBuilder)???).append("] downloadNext send cs get url. thumb task,");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)???).toString());
        ((ThumbHttpDownloader.DownloadTask)localObject2).jdField_d_of_type_Long = System.currentTimeMillis();
        if (((ThumbHttpDownloader.DownloadTask)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          bool = ((ThumbHttpDownloader.DownloadTask)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(((ThumbHttpDownloader.DownloadTask)localObject2).jdField_a_of_type_Long, (ThumbHttpDownloader.DownloadTask)localObject2);
        }
        if (!bool)
        {
          QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
          a(((ThumbHttpDownloader.DownloadTask)localObject2).jdField_a_of_type_Long);
          a(((ThumbHttpDownloader.DownloadTask)localObject2).jdField_d_of_type_JavaLangString);
          b();
        }
        return;
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Long);
      localStringBuilder.append("] addDowloadingTask,size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".tmp");
        localDownloadTask.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen = paramWhatHappen;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localDownloadTask.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localDownloadTask);
        paramString = new StringBuilder();
        paramString.append("[downloadThumb]  ID[");
        paramString.append(localDownloadTask.jdField_a_of_type_Long);
        paramString.append("] add WaitDowloadTask waiting...");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, paramString.toString());
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
      paramString1 = new StringBuilder();
      paramString1.append("[downloadThumb]  ID[");
      paramString1.append(paramLong);
      paramString1.append("] OnGetThumbInfo no this task");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, paramString1.toString());
      b();
      return;
    }
    if (!paramBoolean1)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downloadThumb]  ID[");
      paramString1.append(paramLong);
      paramString1.append("] onGetDownloadUrlCome failed");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, paramString1.toString());
      a(paramString3.jdField_a_of_type_Long);
      a(paramString3.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (paramBoolean2) {
      paramInt = paramShort;
    }
    paramString3.jdField_b_of_type_JavaLangString = paramString4;
    paramString4 = new StringBuilder();
    paramString4.append(paramString1);
    paramString4.append(":");
    paramString4.append(paramInt);
    paramString1 = paramString4.toString();
    paramString4 = new ArrayList(1);
    paramString4.add(paramString1);
    if (paramBundle != null)
    {
      paramBoolean1 = paramBundle.getBoolean("usemediaplatform", false);
      paramString1 = paramBundle.getStringArrayList("ipv6list");
    }
    else
    {
      paramString1 = null;
      paramBoolean1 = false;
    }
    if (paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null)
    {
      paramString1 = paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
      if ((paramString1 != null) && (paramString1.size() > 0))
      {
        if (FileIPv6StrateyController.a())
        {
          paramString6 = new StringBuilder();
          paramString6.append("[downloadThumb]  ID[");
          paramString6.append(paramLong);
          paramString6.append("] debugIsDisableIPv4OnDoubleStack");
          QLog.d("ThumbHttpDownloader<FileAssistant>", 1, paramString6.toString());
          paramString4.clear();
        }
        paramInt = paramString1.size() - 1;
        while (paramInt >= 0)
        {
          paramString4.add(0, (String)paramString1.get(paramInt));
          paramInt -= 1;
        }
        paramString1 = new StringBuilder();
        paramString1.append("[downloadThumb]  ID[");
        paramString1.append(paramLong);
        paramString1.append("] runDownload use IPv6");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, paramString1.toString());
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("[downloadThumb]  ID[");
    paramString1.append(paramLong);
    paramString1.append("] runDownload use IPList:");
    paramString1.append(paramString4.toString());
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, paramString1.toString());
    paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void decode(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    long l1 = Long.parseLong(???.msgId);
    ThumbHttpDownloader.DownloadTask localDownloadTask = a(l1);
    if (localDownloadTask == null)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode no this task ");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      return;
    }
    if (??? != localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode req not match");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      return;
    }
    localDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    if (paramHttpMsg2 == null)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode resp = null ");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -7, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    for (;;)
    {
      synchronized (localDownloadTask.jdField_a_of_type_ArrayOfInt)
      {
        i = paramHttpMsg2.getResponseCode();
        int j = 0;
        if (i != 206)
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
        try
        {
          localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.write(paramHttpMsg2.getRecvData());
          if (localDownloadTask.jdField_b_of_type_Long == 0L)
          {
            long l2 = paramHttpMsg2.getTotalLen();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[downloadThumb] ID[");
            localStringBuilder.append(l1);
            localStringBuilder.append("]  thumb Size[");
            localStringBuilder.append(String.valueOf(l2));
            localStringBuilder.append("]");
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
            localDownloadTask.jdField_b_of_type_Long = l2;
          }
          localDownloadTask.jdField_e_of_type_Long = paramHttpMsg2.getRecvData().length;
          localDownloadTask.jdField_c_of_type_Long += localDownloadTask.jdField_e_of_type_Long;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("recv packeg[");
          paramHttpMsg2.append(localDownloadTask.jdField_e_of_type_Long);
          paramHttpMsg2.append("],total[");
          paramHttpMsg2.append(String.valueOf(localDownloadTask.jdField_c_of_type_Long));
          paramHttpMsg2.append("] thumb Size[");
          paramHttpMsg2.append(String.valueOf(localDownloadTask.jdField_b_of_type_Long));
          paramHttpMsg2.append("]");
          QLog.d("ThumbHttpDownloader<FileAssistant>", 4, paramHttpMsg2.toString());
          if (localDownloadTask.jdField_c_of_type_Long >= localDownloadTask.jdField_b_of_type_Long)
          {
            localDownloadTask.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
            try
            {
              localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.flush();
              localDownloadTask.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
              a(localDownloadTask, false);
              if (FileUtils.renameFile(new File(localDownloadTask.jdField_d_of_type_JavaLangString), new File(localDownloadTask.jdField_c_of_type_JavaLangString))) {
                break label925;
              }
              paramHttpMsg2 = new StringBuilder();
              paramHttpMsg2.append("[downloadThumb] ID[");
              paramHttpMsg2.append(l1);
              paramHttpMsg2.append("] renameFile failed");
              QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg2.toString());
              bool = false;
              i = -9;
              if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
                localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, bool, i, localDownloadTask.jdField_c_of_type_JavaLangString, localDownloadTask);
              }
              a(localDownloadTask.jdField_a_of_type_Long);
              a(localDownloadTask.jdField_d_of_type_JavaLangString);
              i = 1;
            }
            catch (IOException paramHttpMsg2)
            {
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
          }
          else
          {
            int k = (int)((float)localDownloadTask.jdField_c_of_type_Long / (float)localDownloadTask.jdField_b_of_type_Long * 10000.0F);
            i = j;
            if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null)
            {
              localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, k, localDownloadTask);
              i = j;
            }
          }
          if (i != 0) {
            b();
          }
          return;
        }
        catch (Exception paramHttpMsg2)
        {
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
      }
      label925:
      boolean bool = true;
      int i = 0;
    }
  }
  
  public final void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.msgId);
    } else {
      l = -1L;
    }
    ThumbHttpDownloader.DownloadTask localDownloadTask = a(l);
    if (localDownloadTask == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("]get mMapDowloadingTask task fail, may be is success taskid[");
      paramHttpMsg1.append(String.valueOf(l));
      paramHttpMsg1.append("]");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      b();
      return;
    }
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] response is null");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      a(localDownloadTask, true);
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
        localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, -1, null, localDownloadTask);
      }
      a(localDownloadTask.jdField_a_of_type_Long);
      a(localDownloadTask.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    int i = paramHttpMsg2.errCode;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[downloadThumb]  ID[");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("] handleError retCode[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], retMsg[");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] net is broken");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
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
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] request = null. over");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      i = -6;
    }
    else if (!paramHttpMsg2.permitRetry())
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] response.permitRetry = false. over");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      i = -4;
    }
    else if ((paramHttpMsg2.mConn != null) && (a(paramHttpMsg2.mConn.getHeaderField("User-ReturnCode"))))
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] file over size and server can not create thumb. over");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      i = -10;
    }
    else
    {
      if (localDownloadTask.jdField_b_of_type_Int < 3)
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[downloadThumb] ID[");
        paramHttpMsg1.append(l);
        paramHttpMsg1.append("] try it. retryTimes:");
        paramHttpMsg1.append(localDownloadTask.jdField_b_of_type_Int);
        paramHttpMsg1.append(" eofRetry:");
        paramHttpMsg1.append(localDownloadTask.jdField_d_of_type_Int);
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
        localDownloadTask.jdField_b_of_type_Int += 1;
        if ((i == 9056) && (localDownloadTask.jdField_d_of_type_Int < 3))
        {
          paramHttpMsg1 = new StringBuilder();
          paramHttpMsg1.append("[downloadThumb] ID[");
          paramHttpMsg1.append(l);
          paramHttpMsg1.append("] .Error_Exp_Eof retryTimes:");
          paramHttpMsg1.append(localDownloadTask.jdField_b_of_type_Int);
          paramHttpMsg1.append(" eofRetry:");
          paramHttpMsg1.append(localDownloadTask.jdField_d_of_type_Int);
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
          localDownloadTask.jdField_b_of_type_Int -= 1;
          localDownloadTask.jdField_d_of_type_Int += 1;
        }
        else
        {
          localDownloadTask.jdField_d_of_type_Int = 0;
        }
        a(localDownloadTask, true);
        if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
          localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, localDownloadTask);
        }
        localDownloadTask.jdField_c_of_type_Int += 1;
        a(localDownloadTask);
        return;
      }
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] try it. retryTimes > ");
      paramHttpMsg1.append(3);
      paramHttpMsg1.append(" getNextUrl....");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      paramHttpMsg1 = null;
      if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null) {
        paramHttpMsg1 = localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      }
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
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] ID[");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append("] had not nextUrl, over....");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
      i = -5;
    }
    a(localDownloadTask, true);
    if (localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen != null) {
      localDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader$WhatHappen.a(localDownloadTask.jdField_a_of_type_Long, false, i, null, localDownloadTask);
    }
    a(localDownloadTask.jdField_a_of_type_Long);
    a(localDownloadTask.jdField_d_of_type_JavaLangString);
    b();
  }
  
  public void handleRedirect(String paramString) {}
  
  public final boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader
 * JD-Core Version:    0.7.0.1
 */