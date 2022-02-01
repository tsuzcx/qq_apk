package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

public class HttpThumbDownloader
  implements IHttpCommunicatorListener
{
  private final int a = 3;
  private QQAppInterface b;
  private long c = -1L;
  private String d;
  private String e;
  private String f;
  private String g;
  private HttpMsg h;
  private long i = 0L;
  private long j = 0L;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private long n = 0L;
  private FileOutputStream o = null;
  private HttpThumbDownloader.ThumbEventCallback p;
  private long q = 0L;
  
  public HttpThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.o == null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[downloadThumb]  ID[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] runDownload...tmpname[");
      ((StringBuilder)localObject).append(String.valueOf(this.g));
      ((StringBuilder)localObject).append("]");
      QLog.i("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
      this.o = new FileOutputStream(this.g, true);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      label86:
      HttpMsg localHttpMsg;
      break label86;
    }
    a(true);
    localObject = this.p;
    if (localObject != null) {
      ((HttpThumbDownloader.ThumbEventCallback)localObject).a(this.d, false, -2, null, this.c);
    }
    return;
    localHttpMsg = new HttpMsg(this.d, null, this, true);
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
    localHttpMsg.msgId = String.valueOf(this.c);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb]  ID[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] start runDownload... , url[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] data RANGE[");
    ((StringBuilder)localObject).append("bytes=0-");
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(localHttpMsg.busiType));
    ((StringBuilder)localObject).append("]");
    QLog.d("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (!TextUtils.isEmpty(this.e)) {
      localHttpMsg.setRequestProperty("Cookie", this.e);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cookie:");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
    this.h = localHttpMsg;
  }
  
  private void a(boolean paramBoolean)
  {
    this.j = 0L;
    try
    {
      StringBuilder localStringBuilder1;
      if (this.o != null)
      {
        this.o.close();
        this.o = null;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("stopDownload : [thumbtaskId] = ");
        localStringBuilder1.append(this.c);
        localStringBuilder1.append(" closeFileStream");
        QLog.i("ZipThumbDownloader", 1, localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("stopDownload : [thumbtaskId] = ");
        localStringBuilder1.append(this.c);
        localStringBuilder1.append(" closeFileStream had closed: stream = null");
        QLog.w("ZipThumbDownloader", 1, localStringBuilder1.toString());
      }
    }
    catch (IOException localIOException)
    {
      this.o = null;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("stopDownload : [thumbtaskId] = ");
      localStringBuilder2.append(this.c);
      localStringBuilder2.append(" closeFileStream");
      QLog.e("ZipThumbDownloader", 1, localStringBuilder2.toString());
      localIOException.printStackTrace();
    }
    if (this.h != null) {
      ((HttpCommunicator)((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(this.h);
    }
    if (paramBoolean) {
      FileUtil.e(this.g);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, HttpThumbDownloader.ThumbEventCallback paramThumbEventCallback)
  {
    this.c = paramLong;
    this.d = paramString2;
    this.f = paramString1;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(".tmp");
    this.g = paramString2.toString();
    this.p = paramThumbEventCallback;
    paramString1 = new StringBuilder();
    paramString1.append("[downloadThumb]  ID[");
    paramString1.append(this.c);
    paramString1.append("] add WaitDowloadTask waiting...");
    QLog.i("ZipThumbDownloader", 1, paramString1.toString());
    this.n = System.currentTimeMillis();
    ThreadManager.post(new HttpThumbDownloader.1(this), 8, null, false);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l1;
    if (paramHttpMsg2 != null) {
      l1 = Long.parseLong(paramHttpMsg2.msgId);
    } else {
      l1 = -1L;
    }
    if (l1 != this.c)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : [thumbId] = ");
      paramHttpMsg1.append(l1);
      paramHttpMsg1.append(" but [currentTaskId] = ");
      paramHttpMsg1.append(this.c);
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      return;
    }
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : [thumbId] = ");
      paramHttpMsg1.append(l1);
      paramHttpMsg1.append("] decode resp = null ");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.p;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.d, false, -7, null, this.c);
      }
      return;
    }
    if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
    {
      paramHttpMsg1 = this.o;
      if (paramHttpMsg1 == null)
      {
        a(true);
        paramHttpMsg1 = this.p;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.d, false, -8, null, this.c);
        }
        return;
      }
    }
    try
    {
      paramHttpMsg1.write(paramHttpMsg2.getRecvData());
      if (0L == this.i)
      {
        l2 = paramHttpMsg2.getTotalLen();
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("decode : [thumbId] = ");
        paramHttpMsg1.append(l1);
        paramHttpMsg1.append("]  [thumb Size] = ");
        paramHttpMsg1.append(String.valueOf(l2));
        QLog.i("ZipThumbDownloader", 1, paramHttpMsg1.toString());
        this.i = l2;
      }
      this.q = paramHttpMsg2.getRecvData().length;
      this.j += this.q;
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : recv packeg[");
      paramHttpMsg1.append(this.q);
      paramHttpMsg1.append("],total[");
      paramHttpMsg1.append(String.valueOf(this.j));
      paramHttpMsg1.append("] thumb Size[");
      paramHttpMsg1.append(String.valueOf(this.i));
      paramHttpMsg1.append("]");
      QLog.d("ZipThumbDownloader", 4, paramHttpMsg1.toString());
      l1 = this.j;
      long l2 = this.i;
      int i1;
      if (l1 >= l2)
      {
        this.h = null;
        try
        {
          this.o.flush();
          this.o.getFD().sync();
          a(false);
          boolean bool;
          if (!FileUtils.renameFile(new File(this.g), new File(this.f)))
          {
            paramHttpMsg1 = new StringBuilder();
            paramHttpMsg1.append("decode : [downloadThumb] = ");
            paramHttpMsg1.append(this.c);
            paramHttpMsg1.append(" renameFile failed");
            QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
            bool = false;
            i1 = -9;
          }
          else
          {
            bool = true;
            i1 = 0;
          }
          paramHttpMsg1 = this.p;
          if (paramHttpMsg1 == null) {
            break label641;
          }
          paramHttpMsg1.a(this.d, bool, i1, this.f, this.c);
          return;
        }
        catch (IOException paramHttpMsg1)
        {
          paramHttpMsg1.printStackTrace();
          a(true);
          paramHttpMsg1 = this.p;
          if (paramHttpMsg1 != null) {
            paramHttpMsg1.a(this.d, false, -8, null, this.c);
          }
          return;
        }
      }
      else
      {
        i1 = (int)((float)l1 / (float)l2 * 10000.0F);
        paramHttpMsg1 = this.p;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.d, i1);
        }
      }
      label641:
      return;
    }
    catch (Exception paramHttpMsg1)
    {
      paramHttpMsg1.printStackTrace();
      a(true);
      paramHttpMsg1 = this.p;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.d, false, -8, null, this.c);
      }
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l1;
    if (paramHttpMsg1 != null) {
      l1 = Long.parseLong(paramHttpMsg1.msgId);
    } else {
      l1 = -1L;
    }
    if (l1 != this.c)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("handleError : [thumbId] = ");
      paramHttpMsg1.append(l1);
      paramHttpMsg1.append(" but [currentTaskId] = ");
      paramHttpMsg1.append(this.c);
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      return;
    }
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.c);
      paramHttpMsg1.append(" response is null");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.p;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.d, false, -1, null, this.c);
      }
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    int i1 = paramHttpMsg2.errCode;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[downloadThumb] = ");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(" handleError retCode [errCode] = ");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(", [retMsg] = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("ZipThumbDownloader", 1, ((StringBuilder)localObject2).toString());
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.c);
      paramHttpMsg1.append(" net is broken");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.p;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.d, false, -3, null, this.c);
      }
      return;
    }
    if (paramHttpMsg1 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.c);
      paramHttpMsg1.append(" request = null. over");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i1 = -6;
    }
    else if (!paramHttpMsg2.permitRetry())
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.c);
      paramHttpMsg1.append(" response.permitRetry = false. over");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i1 = -4;
    }
    else
    {
      if (this.k < 3)
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[downloadThumb] = ");
        paramHttpMsg1.append(this.c);
        paramHttpMsg1.append(" try it. [retryTimes] = ");
        paramHttpMsg1.append(this.k);
        paramHttpMsg1.append(" [eofRetry] = ");
        paramHttpMsg1.append(this.m);
        QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
        this.k += 1;
        if ((i1 == 9056) && (this.m < 3))
        {
          paramHttpMsg1 = new StringBuilder();
          paramHttpMsg1.append("[downloadThumb] = ");
          paramHttpMsg1.append(this.c);
          paramHttpMsg1.append(" [Error_Exp_Eof retryTimes] = ");
          paramHttpMsg1.append(this.k);
          paramHttpMsg1.append(" [eofRetry] = ");
          paramHttpMsg1.append(this.m);
          QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
          this.k -= 1;
          this.m += 1;
        }
        else
        {
          this.m = 0;
        }
        a(true);
        paramHttpMsg1 = this.p;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.d);
        }
        this.l += 1;
        a();
        return;
      }
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.c);
      paramHttpMsg1.append(" try it. retryTimes > ");
      paramHttpMsg1.append(3);
      paramHttpMsg1.append(" download over....");
      QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i1 = -1;
    }
    a(true);
    paramHttpMsg1 = this.p;
    if (paramHttpMsg1 != null) {
      paramHttpMsg1.a(this.d, false, i1, null, this.c);
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.HttpThumbDownloader
 * JD-Core Version:    0.7.0.1
 */