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
  protected static final String a = FMSettings.a().getDefaultThumbPath();
  private static long c;
  private QQAppInterface b;
  private final int d = 3;
  private LinkedHashMap<Long, ThumbHttpDownloader.DownloadTask> e = new LinkedHashMap();
  private List<ThumbHttpDownloader.DownloadTask> f = new ArrayList();
  private List<String> g = new ArrayList();
  
  public ThumbHttpDownloader(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private void a(long paramLong)
  {
    synchronized (this.e)
    {
      this.e.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] removeDowloadingTask,size:");
      localStringBuilder.append(this.e.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.g == null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[downloadThumb]  ID[");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      ((StringBuilder)localObject).append("] runDownload...tmpname[");
      ((StringBuilder)localObject).append(String.valueOf(paramDownloadTask.e));
      ((StringBuilder)localObject).append("]");
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      paramDownloadTask.g = new FileOutputStream(paramDownloadTask.e, true);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      label86:
      HttpMsg localHttpMsg;
      break label86;
    }
    a(paramDownloadTask, true);
    if (paramDownloadTask.r != null) {
      paramDownloadTask.r.a(paramDownloadTask.a, false, -2, null, paramDownloadTask);
    }
    a(paramDownloadTask.a);
    a(paramDownloadTask.e);
    b();
    return;
    localHttpMsg = new HttpMsg(paramDownloadTask.b, null, this, true);
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
    localHttpMsg.msgId = String.valueOf(paramDownloadTask.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb]  ID[");
    ((StringBuilder)localObject).append(paramDownloadTask.a);
    ((StringBuilder)localObject).append("] start runDownload... , url[");
    ((StringBuilder)localObject).append(paramDownloadTask.b);
    ((StringBuilder)localObject).append("] data RANGE[");
    ((StringBuilder)localObject).append("bytes=0-");
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(localHttpMsg.busiType));
    ((StringBuilder)localObject).append("]");
    QLog.d("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (paramDownloadTask.r != null) {
      paramDownloadTask.r.a(paramDownloadTask.a, localHttpMsg);
    }
    if (!TextUtils.isEmpty(paramDownloadTask.c)) {
      localHttpMsg.setRequestProperty("Cookie", paramDownloadTask.c);
    }
    if (paramDownloadTask.b != null) {
      localObject = paramDownloadTask.b.toLowerCase();
    } else {
      localObject = "";
    }
    if ((paramDownloadTask.u) && (((String)localObject).startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = HttpUrlProcessor.a(paramDownloadTask.b);
      localHttpMsg.mReqHost = paramDownloadTask.v;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cookie:");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
    paramDownloadTask.f = localHttpMsg;
  }
  
  private void a(ThumbHttpDownloader.DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    if (paramDownloadTask == null) {
      return;
    }
    paramDownloadTask.j = 0L;
    try
    {
      StringBuilder localStringBuilder1;
      if (paramDownloadTask.g != null)
      {
        paramDownloadTask.g.close();
        paramDownloadTask.g = null;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[downloadThumb][");
        localStringBuilder1.append(c);
        localStringBuilder1.append("]. closeFileStream:");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[downloadThumb][");
        localStringBuilder1.append(c);
        localStringBuilder1.append("]. closeFileStream.had closed: stream = null:");
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder1.toString());
      }
    }
    catch (IOException localIOException)
    {
      paramDownloadTask.g = null;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[downloadThumb][");
      localStringBuilder2.append(c);
      localStringBuilder2.append("]. closeFileStream: exception");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder2.toString());
      localIOException.printStackTrace();
    }
    if (paramDownloadTask.f != null) {
      ((HttpCommunicator)((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(paramDownloadTask.f);
    }
    if (paramBoolean) {
      FileUtil.e(paramDownloadTask.e);
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.g)
    {
      this.g.remove(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(c);
      localStringBuilder.append("], Name[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] removeDowloadingList,size:");
      localStringBuilder.append(this.e.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  private ThumbHttpDownloader.DownloadTask b(long paramLong)
  {
    synchronized (this.e)
    {
      ThumbHttpDownloader.DownloadTask localDownloadTask = (ThumbHttpDownloader.DownloadTask)this.e.get(Long.valueOf(paramLong));
      return localDownloadTask;
    }
  }
  
  private void b()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("[downloadThumb]  downloadNext ,mWaitDowloadTask.size(");
    ((StringBuilder)???).append(String.valueOf(this.f.size()));
    ((StringBuilder)???).append(")");
    QLog.i("ThumbHttpDownloader<FileAssistant>", 2, ((StringBuilder)???).toString());
    synchronized (this.e)
    {
      int i = this.e.size();
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
      synchronized (this.f)
      {
        if (this.f.size() == 0)
        {
          QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
          return;
        }
        localObject2 = this.f;
        boolean bool = false;
        localObject2 = (ThumbHttpDownloader.DownloadTask)((List)localObject2).get(0);
        if (localObject2 == null)
        {
          QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
          this.f.remove(0);
          b();
          return;
        }
        this.f.remove(localObject2);
        b((ThumbHttpDownloader.DownloadTask)localObject2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[downloadThumb]  ID[");
        ((StringBuilder)???).append(((ThumbHttpDownloader.DownloadTask)localObject2).a);
        ((StringBuilder)???).append("] downloadNext send cs get url. thumb task,");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, ((StringBuilder)???).toString());
        ((ThumbHttpDownloader.DownloadTask)localObject2).p = System.currentTimeMillis();
        if (((ThumbHttpDownloader.DownloadTask)localObject2).r != null) {
          bool = ((ThumbHttpDownloader.DownloadTask)localObject2).r.a(((ThumbHttpDownloader.DownloadTask)localObject2).a, (ThumbHttpDownloader.DownloadTask)localObject2);
        }
        if (!bool)
        {
          QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
          a(((ThumbHttpDownloader.DownloadTask)localObject2).a);
          a(((ThumbHttpDownloader.DownloadTask)localObject2).e);
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
    synchronized (this.e)
    {
      this.e.put(Long.valueOf(paramDownloadTask.a), paramDownloadTask);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb]  ID[");
      localStringBuilder.append(paramDownloadTask.a);
      localStringBuilder.append("] addDowloadingTask,size:");
      localStringBuilder.append(this.e.size());
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717"));
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 404)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadThumb] ID[");
      localStringBuilder.append(c);
      localStringBuilder.append("] had not found error 404, over....");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
      return -11;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[downloadThumb] ID[");
    localStringBuilder.append(c);
    localStringBuilder.append("] had not nextUrl, over....");
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
    return -5;
  }
  
  public long a(String paramString, ThumbHttpDownloader.WhatHappen paramWhatHappen, boolean paramBoolean)
  {
    synchronized (this.g)
    {
      if (this.g.contains(paramString)) {
        return -1L;
      }
      this.g.add(paramString);
      synchronized (this.f)
      {
        ThumbHttpDownloader.DownloadTask localDownloadTask = new ThumbHttpDownloader.DownloadTask();
        localDownloadTask.d = paramString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".tmp");
        localDownloadTask.e = localStringBuilder.toString();
        localDownloadTask.r = paramWhatHappen;
        long l = c;
        c = 1L + l;
        localDownloadTask.a = l;
        localDownloadTask.m = paramBoolean;
        this.f.add(localDownloadTask);
        paramString = new StringBuilder();
        paramString.append("[downloadThumb]  ID[");
        paramString.append(localDownloadTask.a);
        paramString.append("] add WaitDowloadTask waiting...");
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, paramString.toString());
        l = localDownloadTask.a;
        return l;
      }
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString)
  {
    ThumbHttpDownloader.DownloadTask localDownloadTask = b(paramLong);
    if (localDownloadTask == null)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] OnGetThumbInfo no this task");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, paramString.toString());
      b();
      return;
    }
    if (!paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] onGetDownloadUrlCome failed");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, paramString.toString());
      a(localDownloadTask.a);
      a(localDownloadTask.e);
      b();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[downloadThumb]  ID[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] runDownload use IPList:");
    localStringBuilder.append(paramString.toString());
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
    localDownloadTask.b = paramString;
    ThreadManager.post(new ThumbHttpDownloader.2(this, localDownloadTask), 8, null, false);
  }
  
  public void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6, Bundle paramBundle)
  {
    paramString3 = b(paramLong);
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
      a(paramString3.a);
      a(paramString3.e);
      b();
      return;
    }
    if (paramBoolean2) {
      paramInt = paramShort;
    }
    paramString3.c = paramString4;
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
    if (paramString3.r != null)
    {
      paramString1 = paramString3.r.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
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
    paramString3.q = new HttpUrlProcessor(this.b, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.q.a(true);
    }
    paramString3.b = paramString3.q.b();
    paramString3.u = paramBoolean2;
    paramString3.v = paramString5;
    paramString3.w = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void decode(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    long l1 = Long.parseLong(???.msgId);
    ThumbHttpDownloader.DownloadTask localDownloadTask = b(l1);
    if (localDownloadTask == null)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode no this task ");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      return;
    }
    if (??? != localDownloadTask.f)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode req not match");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      return;
    }
    localDownloadTask.s = paramHttpMsg2;
    if (paramHttpMsg2 == null)
    {
      ??? = new StringBuilder();
      ???.append("[downloadThumb] ID[");
      ???.append(l1);
      ???.append("] decode resp = null ");
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, ???.toString());
      a(localDownloadTask, true);
      if (localDownloadTask.r != null) {
        localDownloadTask.r.a(localDownloadTask.a, false, -7, null, localDownloadTask);
      }
      a(localDownloadTask.a);
      a(localDownloadTask.e);
      b();
      return;
    }
    for (;;)
    {
      synchronized (localDownloadTask.h)
      {
        i = paramHttpMsg2.getResponseCode();
        int j = 0;
        if (i != 206)
        {
          i = j;
          if (paramHttpMsg2.getResponseCode() != 200) {}
        }
        else if (localDownloadTask.g == null)
        {
          a(localDownloadTask, true);
          if (localDownloadTask.r != null) {
            localDownloadTask.r.a(localDownloadTask.a, false, -8, null, localDownloadTask);
          }
          a(localDownloadTask.a);
          a(localDownloadTask.e);
          b();
          return;
        }
        try
        {
          localDownloadTask.g.write(paramHttpMsg2.getRecvData());
          if (localDownloadTask.i == 0L)
          {
            long l2 = paramHttpMsg2.getTotalLen();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[downloadThumb] ID[");
            localStringBuilder.append(l1);
            localStringBuilder.append("]  thumb Size[");
            localStringBuilder.append(String.valueOf(l2));
            localStringBuilder.append("]");
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, localStringBuilder.toString());
            localDownloadTask.i = l2;
          }
          localDownloadTask.t = paramHttpMsg2.getRecvData().length;
          localDownloadTask.j += localDownloadTask.t;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("recv packeg[");
          paramHttpMsg2.append(localDownloadTask.t);
          paramHttpMsg2.append("],total[");
          paramHttpMsg2.append(String.valueOf(localDownloadTask.j));
          paramHttpMsg2.append("] thumb Size[");
          paramHttpMsg2.append(String.valueOf(localDownloadTask.i));
          paramHttpMsg2.append("]");
          QLog.d("ThumbHttpDownloader<FileAssistant>", 4, paramHttpMsg2.toString());
          if (localDownloadTask.j >= localDownloadTask.i)
          {
            localDownloadTask.f = null;
            try
            {
              localDownloadTask.g.flush();
              localDownloadTask.g.getFD().sync();
              a(localDownloadTask, false);
              if (FileUtils.renameFile(new File(localDownloadTask.e), new File(localDownloadTask.d))) {
                break label925;
              }
              paramHttpMsg2 = new StringBuilder();
              paramHttpMsg2.append("[downloadThumb] ID[");
              paramHttpMsg2.append(l1);
              paramHttpMsg2.append("] renameFile failed");
              QLog.e("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg2.toString());
              bool = false;
              i = -9;
              if (localDownloadTask.r != null) {
                localDownloadTask.r.a(localDownloadTask.a, bool, i, localDownloadTask.d, localDownloadTask);
              }
              a(localDownloadTask.a);
              a(localDownloadTask.e);
              i = 1;
            }
            catch (IOException paramHttpMsg2)
            {
              paramHttpMsg2.printStackTrace();
              a(localDownloadTask, true);
              if (localDownloadTask.r != null) {
                localDownloadTask.r.a(localDownloadTask.a, false, -8, null, localDownloadTask);
              }
              a(localDownloadTask.a);
              a(localDownloadTask.e);
              b();
              return;
            }
          }
          else
          {
            int k = (int)((float)localDownloadTask.j / (float)localDownloadTask.i * 10000.0F);
            i = j;
            if (localDownloadTask.r != null)
            {
              localDownloadTask.r.a(localDownloadTask.a, k, localDownloadTask);
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
          if (localDownloadTask.r != null) {
            localDownloadTask.r.a(localDownloadTask.a, false, -8, null, localDownloadTask);
          }
          a(localDownloadTask.a);
          a(localDownloadTask.e);
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
    ThumbHttpDownloader.DownloadTask localDownloadTask = b(l);
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
      if (localDownloadTask.r != null) {
        localDownloadTask.r.a(localDownloadTask.a, false, -1, null, localDownloadTask);
      }
      a(localDownloadTask.a);
      a(localDownloadTask.e);
      b();
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localDownloadTask.s = paramHttpMsg2;
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
      if (localDownloadTask.r != null) {
        localDownloadTask.r.a(localDownloadTask.a, false, -3, null, localDownloadTask);
      }
      a(localDownloadTask.a);
      a(localDownloadTask.e);
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
    else if ((paramHttpMsg2.mConn != null) && (b(paramHttpMsg2.mConn.getHeaderField("User-ReturnCode"))))
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
      if ((localDownloadTask.l < 3) && (localDownloadTask.m))
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[downloadThumb] ID[");
        paramHttpMsg1.append(l);
        paramHttpMsg1.append("] try it. retryTimes:");
        paramHttpMsg1.append(localDownloadTask.l);
        paramHttpMsg1.append(" eofRetry:");
        paramHttpMsg1.append(localDownloadTask.o);
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
        localDownloadTask.l += 1;
        if ((i == 9056) && (localDownloadTask.o < 3))
        {
          paramHttpMsg1 = new StringBuilder();
          paramHttpMsg1.append("[downloadThumb] ID[");
          paramHttpMsg1.append(l);
          paramHttpMsg1.append("] .Error_Exp_Eof retryTimes:");
          paramHttpMsg1.append(localDownloadTask.l);
          paramHttpMsg1.append(" eofRetry:");
          paramHttpMsg1.append(localDownloadTask.o);
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg1.toString());
          localDownloadTask.l -= 1;
          localDownloadTask.o += 1;
        }
        else
        {
          localDownloadTask.o = 0;
        }
        a(localDownloadTask, true);
        if (localDownloadTask.r != null) {
          localDownloadTask.r.b(localDownloadTask.a, localDownloadTask);
        }
        localDownloadTask.n += 1;
        a(localDownloadTask);
        return;
      }
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[downloadThumb] ID[");
      paramHttpMsg2.append(l);
      paramHttpMsg2.append("] try it. retryTimes > ");
      paramHttpMsg2.append(3);
      paramHttpMsg2.append(" getNextUrl....");
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, paramHttpMsg2.toString());
      paramHttpMsg2 = null;
      if (localDownloadTask.q != null) {
        paramHttpMsg2 = localDownloadTask.q.b();
      }
      if (paramHttpMsg2 != null)
      {
        localDownloadTask.l = 0;
        localDownloadTask.o = 0;
        localDownloadTask.b = paramHttpMsg2;
        a(localDownloadTask, true);
        ((HttpCommunicator)((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(localDownloadTask.f);
        if (localDownloadTask.r != null) {
          localDownloadTask.r.c(localDownloadTask.a, localDownloadTask);
        }
        localDownloadTask.n += 1;
        a(localDownloadTask);
        return;
      }
      i = a(paramHttpMsg1.getResponseCode());
    }
    a(localDownloadTask, true);
    if (localDownloadTask.r != null) {
      localDownloadTask.r.a(localDownloadTask.a, false, i, null, localDownloadTask);
    }
    a(localDownloadTask.a);
    a(localDownloadTask.e);
    b();
  }
  
  public void handleRedirect(String paramString) {}
  
  public final boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader
 * JD-Core Version:    0.7.0.1
 */