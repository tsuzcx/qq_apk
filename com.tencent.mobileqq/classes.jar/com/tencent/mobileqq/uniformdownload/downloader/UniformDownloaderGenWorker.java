package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.HttpUrlProcessor;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;

public class UniformDownloaderGenWorker
  implements IHttpCommunicatorListener
{
  public static String a = "UniformDownloaderGenWorker";
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  long e = 0L;
  long f = 0L;
  private final long g;
  private final String h;
  private long i;
  private String j;
  private OutputStream k = null;
  private Object l = new Object();
  private long m = 0L;
  private Object n = new Object();
  private HttpMsg o;
  private Object p = new Object();
  private UniformDownloaderGen.IUniformDownloaderGenListener q = null;
  private Object r = new Object();
  private int s = c;
  private Object t = new Object();
  private HttpCommunicator u;
  private int v = 0;
  private int w = 0;
  private String x;
  
  public UniformDownloaderGenWorker(long paramLong1, AppRuntime paramAppRuntime, String paramString1, long paramLong2, String paramString2, UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    this.g = paramLong1;
    this.h = new HttpUrlProcessor(paramAppRuntime, paramString1).b();
    this.q = paramIUniformDownloaderGenListener;
    this.i = paramLong2;
    this.x = paramString2;
    this.u = ((HttpCommunicator)((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "")).getCommunicator());
    paramAppRuntime = a;
    paramString1 = new StringBuilder();
    paramString1.append("[UniformDL][HttpCommunicator]:");
    paramString1.append(this.u.toString());
    QLog.w(paramAppRuntime, 1, paramString1.toString());
  }
  
  private void a(int paramInt)
  {
    synchronized (this.t)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. setStatus: ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 1, localStringBuilder.toString());
      this.s = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    Object localObject = UniformDownloadMgr.a().b();
    if (localObject != null)
    {
      localObject = (BaseQQAppInterface)localObject;
      long l1 = this.g;
      long l2 = this.e;
      long l3 = paramInt;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramString1, this.f, this.m, this.i, this.h, "", this.v, paramString2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", l3, paramString1, this.f, this.m, this.i, this.h, "", this.v, paramString2, null);
    }
    else
    {
      paramString2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("].report failed - 3");
      QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    }
    paramString2 = k();
    if (paramString2 != null) {
      paramString2.a(paramInt, paramString1, null);
    }
  }
  
  private void a(UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    synchronized (this.r)
    {
      this.q = paramIUniformDownloaderGenListener;
      return;
    }
  }
  
  private void a(HttpMsg paramHttpMsg)
  {
    synchronized (this.p)
    {
      this.o = paramHttpMsg;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      b(paramLong);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bytes=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("-");
      Object localObject3 = ((StringBuilder)localObject1).toString();
      if ((this.h != null) && (!this.h.contains("?")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.h);
        ((StringBuilder)localObject1).append("?&range=");
        ((StringBuilder)localObject1).append(String.valueOf(paramLong));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.h);
        ((StringBuilder)localObject1).append("&range=");
        ((StringBuilder)localObject1).append(String.valueOf(paramLong));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      HttpMsg localHttpMsg = new HttpMsg((String)localObject1, null, this, true);
      localObject1 = "gprs";
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        localObject1 = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", (String)localObject1);
      localHttpMsg.setRequestProperty("Range", (String)localObject3);
      localHttpMsg.setPriority(1);
      if (!TextUtils.isEmpty(this.x)) {
        localHttpMsg.setRequestProperty("Cookie", this.x);
      }
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 5;
      localHttpMsg.busiType = 0;
      localHttpMsg.msgId = String.valueOf(System.currentTimeMillis());
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      a(localHttpMsg);
      if (UniformDownloadMgr.a().b() == null)
      {
        localObject1 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.g);
        ((StringBuilder)localObject3).append("]. downloadFile failed. APP=null. POS:");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(" PGR:");
        ((StringBuilder)localObject3).append((int)(paramLong / this.i));
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
        return false;
      }
      this.u.sendMsg(localHttpMsg);
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.g);
      ((StringBuilder)localObject3).append("]. >>>>>>>>>>downloadFile. POS:");
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" PGR:");
      ((StringBuilder)localObject3).append((int)(paramLong / this.i));
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return true;
    }
    finally {}
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.permitRetry();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.l)
    {
      try
      {
        if (this.k == null)
        {
          paramArrayOfByte = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[UniformDL][");
          localStringBuilder.append(this.g);
          localStringBuilder.append("]. writeFileStream: stream = null:");
          QLog.e(paramArrayOfByte, 1, localStringBuilder.toString());
          return false;
        }
        this.k.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
      throw paramArrayOfByte;
    }
  }
  
  private void b(long paramLong)
  {
    synchronized (this.n)
    {
      this.m = paramLong;
      return;
    }
  }
  
  private void c()
  {
    try
    {
      a(c);
      i();
      g();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean d()
  {
    return c == e();
  }
  
  private int e()
  {
    int i1 = c;
    synchronized (this.t)
    {
      i1 = this.s;
      return i1;
    }
  }
  
  private boolean f()
  {
    synchronized (this.l)
    {
      Object localObject2 = this.k;
      Object localObject4;
      if (localObject2 == null)
      {
        try
        {
          this.k = new FileOutputStream(this.j, true);
          localObject2 = a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[UniformDL][");
          ((StringBuilder)localObject4).append(this.g);
          ((StringBuilder)localObject4).append("]. openFileStream: filepath:");
          ((StringBuilder)localObject4).append(this.j);
          QLog.i((String)localObject2, 1, ((StringBuilder)localObject4).toString());
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localObject4 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[UniformDL][");
          localStringBuilder.append(this.g);
          localStringBuilder.append("]. openFileStream: exception");
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
          localFileNotFoundException.printStackTrace();
          return false;
        }
      }
      else
      {
        String str = a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[UniformDL][");
        ((StringBuilder)localObject4).append(this.g);
        ((StringBuilder)localObject4).append("]. openFileStream: had be opened");
        QLog.w(str, 1, ((StringBuilder)localObject4).toString());
      }
      return true;
    }
  }
  
  private boolean g()
  {
    synchronized (this.l)
    {
      try
      {
        String str;
        if (this.k != null)
        {
          this.k.close();
          this.k = null;
          str = a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[UniformDL][");
          ((StringBuilder)localObject3).append(this.g);
          ((StringBuilder)localObject3).append("]. closeFileStream: filepath:");
          ((StringBuilder)localObject3).append(this.j);
          QLog.i(str, 1, ((StringBuilder)localObject3).toString());
        }
        else
        {
          str = a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[UniformDL][");
          ((StringBuilder)localObject3).append(this.g);
          ((StringBuilder)localObject3).append("]. closeFileStream.had closed: stream = null:");
          QLog.w(str, 1, ((StringBuilder)localObject3).toString());
        }
        return true;
      }
      catch (IOException localIOException)
      {
        Object localObject3 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.g);
        localStringBuilder.append("]. closeFileStream: exception");
        QLog.e((String)localObject3, 1, localStringBuilder.toString());
        localIOException.printStackTrace();
        return false;
      }
      throw localIOException;
    }
  }
  
  private HttpMsg h()
  {
    synchronized (this.p)
    {
      HttpMsg localHttpMsg = this.o;
      return localHttpMsg;
    }
  }
  
  private void i()
  {
    Object localObject1 = h();
    if (localObject1 != null)
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. stopHttpRequest");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      a(null);
      if (UniformDownloadMgr.a().b() == null)
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append("]. stopHttpRequest failed.APP=null");
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      this.u.cancelMsg((HttpMsg)localObject1);
      return;
    }
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append("]. stopHttpRequest: no request");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  private long j()
  {
    synchronized (this.n)
    {
      long l1 = this.m;
      return l1;
    }
  }
  
  private UniformDownloaderGen.IUniformDownloaderGenListener k()
  {
    synchronized (this.r)
    {
      UniformDownloaderGen.IUniformDownloaderGenListener localIUniformDownloaderGenListener = this.q;
      return localIUniformDownloaderGenListener;
    }
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      paramString = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. start failed. filepath = null. POS:");
      localStringBuilder.append(paramLong);
      QLog.e(paramString, 1, localStringBuilder.toString());
      return false;
    }
    if (b == e())
    {
      paramString = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. start. is runing. POS:");
      localStringBuilder.append(paramLong);
      QLog.w(paramString, 1, localStringBuilder.toString());
      return true;
    }
    this.j = paramString;
    if (!f())
    {
      paramString = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. start failed. openFileStream failed. POS:");
      localStringBuilder.append(paramLong);
      QLog.w(paramString, 1, localStringBuilder.toString());
      paramString = UDConstants.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      paramString = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]. start download failed. POS:");
      localStringBuilder.append(paramLong);
      QLog.e(paramString, 1, localStringBuilder.toString());
      paramString = UDConstants.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(b);
    this.e = System.currentTimeMillis();
    paramString = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]. start to run download . POS:");
    localStringBuilder.append(paramLong);
    QLog.i(paramString, 1, localStringBuilder.toString());
    return true;
  }
  
  public void b()
  {
    a(d);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (d())
    {
      paramHttpMsg1 = a;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.g);
      paramHttpMsg2.append("]. decode. but had stoped");
      QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
      return;
    }
    try
    {
      if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
      {
        int i1;
        if (!a(paramHttpMsg2.getRecvData()))
        {
          i1 = 3;
          paramHttpMsg1 = UDConstants.a(3);
          l1 = 0L;
          if (SystemUtil.a()) {
            l1 = SystemUtil.b() * 1024L;
          }
          if (l1 < this.i - j())
          {
            paramHttpMsg1 = a;
            paramHttpMsg2 = new StringBuilder();
            paramHttpMsg2.append("[UniformDL][");
            paramHttpMsg2.append(this.g);
            paramHttpMsg2.append("] write file failed. sd card space is no enough:[");
            paramHttpMsg2.append(this.i);
            paramHttpMsg2.append(" ");
            paramHttpMsg2.append(j());
            paramHttpMsg2.append(" ");
            paramHttpMsg2.append(l1);
            paramHttpMsg2.append("]");
            QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
            i1 = 9;
            paramHttpMsg1 = UDConstants.a(9);
          }
          a(i1, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        long l1 = j() + paramHttpMsg2.getRecvData().length;
        long l2 = paramHttpMsg2.getTotalLen();
        if (this.i != l2) {
          this.i = l2;
        }
        b(l1);
        this.f += paramHttpMsg2.getRecvData().length;
        if (l1 >= this.i)
        {
          if (!g())
          {
            paramHttpMsg1 = a;
            paramHttpMsg2 = new StringBuilder();
            paramHttpMsg2.append("[UniformDL][");
            paramHttpMsg2.append(this.g);
            paramHttpMsg2.append("].closeFileStream falied.path=");
            paramHttpMsg2.append(this.j);
            QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
            paramHttpMsg1 = UDConstants.a(4);
            a(4, paramHttpMsg1, paramHttpMsg1);
            return;
          }
          paramHttpMsg1 = a;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("[UniformDL][");
          paramHttpMsg2.append(this.g);
          paramHttpMsg2.append("].decode >>>>>>>. SUCESSFUL!!!");
          QLog.i(paramHttpMsg1, 1, paramHttpMsg2.toString());
          paramHttpMsg1 = k();
          if (paramHttpMsg1 != null)
          {
            paramHttpMsg2 = new Bundle();
            paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.m);
            paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.f);
            paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.v);
            paramHttpMsg1.a(this.j, this.i, paramHttpMsg2);
          }
        }
        else
        {
          i1 = (int)((float)l1 / (float)this.i * 100.0F);
          paramHttpMsg1 = k();
          if (paramHttpMsg1 != null)
          {
            paramHttpMsg1.a(i1, null);
            return;
          }
        }
      }
    }
    catch (Exception paramHttpMsg1)
    {
      paramHttpMsg1.printStackTrace();
      paramHttpMsg1 = UDConstants.a(12);
      a(12, paramHttpMsg1, paramHttpMsg1);
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (d())
    {
      paramHttpMsg1 = a;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.g);
      paramHttpMsg2.append("]. handleError..user puase");
      QLog.i(paramHttpMsg1, 1, paramHttpMsg2.toString());
      return;
    }
    long l3;
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = a;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.g);
      paramHttpMsg2.append("]. handleError.. response=NULL:");
      QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
      c();
      paramHttpMsg1 = UDConstants.a(2);
      paramHttpMsg2 = UniformDownloadMgr.a().b();
      if (paramHttpMsg2 != null)
      {
        paramHttpMsg2 = (BaseQQAppInterface)paramHttpMsg2;
        l1 = this.g;
        l2 = this.e;
        l3 = 2;
        QQFileManagerUtil.a(paramHttpMsg2, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, this.h, "", 0, paramHttpMsg1, null);
        QQFileManagerUtil.a(paramHttpMsg2, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, this.h, "", 0, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg2 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append("].report failed - 111");
        QLog.w(paramHttpMsg2, 1, ((StringBuilder)localObject1).toString());
      }
      paramHttpMsg2 = k();
      if (paramHttpMsg2 != null) {
        paramHttpMsg2.a(2, paramHttpMsg1, null);
      }
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = a;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[UniformDL][");
    ((StringBuilder)localObject3).append(this.g);
    ((StringBuilder)localObject3).append("]. handleError.. errString:");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    if (d == e())
    {
      paramHttpMsg1 = a;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.g);
      paramHttpMsg2.append("]. handleError.. slience pause. may app destroy!!");
      QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
      g();
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = UDConstants.a(5);
      paramHttpMsg2 = UniformDownloadMgr.a().b();
      if (paramHttpMsg2 != null)
      {
        paramHttpMsg2 = (BaseQQAppInterface)paramHttpMsg2;
        l1 = this.g;
        l2 = this.e;
        l3 = 5;
        QQFileManagerUtil.a(paramHttpMsg2, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, this.h, "", 0, paramHttpMsg1, null);
        QQFileManagerUtil.a(paramHttpMsg2, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, this.h, "", 0, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg2 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append("].report failed - 11");
        QLog.w(paramHttpMsg2, 1, ((StringBuilder)localObject1).toString());
      }
      paramHttpMsg2 = k();
      if (paramHttpMsg2 != null) {
        paramHttpMsg2.a(5, paramHttpMsg1, null);
      }
      return;
    }
    long l2 = paramHttpMsg2.errCode;
    localObject3 = String.valueOf(paramHttpMsg2.getSerial());
    String str = paramHttpMsg2.getErrorString();
    long l1 = l2;
    localObject1 = localObject3;
    localObject2 = str;
    if (a(paramHttpMsg1, paramHttpMsg2))
    {
      int i1 = this.v;
      l1 = l2;
      localObject1 = localObject3;
      localObject2 = str;
      if (i1 < 3)
      {
        this.v = (i1 + 1);
        if ((this.w < 3) && (paramHttpMsg2.errCode == 9056))
        {
          this.w += 1;
          this.v -= 1;
        }
        else
        {
          this.w = 0;
        }
        paramHttpMsg1 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append("]. handleError. auto retry to download. autoRetry=");
        ((StringBuilder)localObject1).append(this.v);
        ((StringBuilder)localObject1).append(" eofRetry=");
        ((StringBuilder)localObject1).append(this.w);
        QLog.w(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
        i();
        if (!a(j()))
        {
          paramHttpMsg1 = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[UniformDL][");
          ((StringBuilder)localObject1).append(this.g);
          ((StringBuilder)localObject1).append("]. auto retry dowload failed.");
          QLog.e(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
          localObject1 = UDConstants.a((int)13L);
          localObject2 = localObject1;
          l1 = 13L;
        }
        else
        {
          paramHttpMsg1 = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[UniformDL][");
          ((StringBuilder)localObject1).append(this.g);
          ((StringBuilder)localObject1).append("]. auto retry dowload started.");
          QLog.i(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
          paramHttpMsg1 = UniformDownloadMgr.a().b();
          if (paramHttpMsg1 != null)
          {
            QQFileManagerUtil.a((BaseQQAppInterface)paramHttpMsg1, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.f, this.m, this.i, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.v, paramHttpMsg2.getErrorString(), null);
            return;
          }
          paramHttpMsg1 = a;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("[UniformDL][");
          paramHttpMsg2.append(this.g);
          paramHttpMsg2.append("].report failed - 1");
          QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
          return;
        }
      }
    }
    this.v = 0;
    this.w = 0;
    c();
    localObject3 = UniformDownloadMgr.a().b();
    if (localObject3 != null)
    {
      if (13L != l1)
      {
        paramHttpMsg1 = UDConstants.a((int)11L);
        l1 = 11L;
        localObject2 = paramHttpMsg1;
      }
      else
      {
        paramHttpMsg1 = (HttpMsg)localObject1;
      }
      localObject1 = (BaseQQAppInterface)localObject3;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.g, "actFileUfGenDownload", this.e, "", "", "", "", l1, paramHttpMsg1, this.f, this.m, this.i, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.v, (String)localObject2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.f, this.m, this.i, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.v, paramHttpMsg2.getErrorString(), null);
    }
    else
    {
      paramHttpMsg1 = a;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.g);
      paramHttpMsg2.append("].report failed - 2");
      QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
    }
    paramHttpMsg1 = k();
    if (paramHttpMsg1 != null) {
      paramHttpMsg1.a(6, "downloader fialed", null);
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    paramHttpMsg1 = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("]. HttpCommunicator statusChanged. status:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i(paramHttpMsg1, 1, ((StringBuilder)localObject).toString());
    if ((5 == paramInt) && (j() < this.i))
    {
      c();
      paramHttpMsg1 = UDConstants.a(14);
      localObject = UniformDownloadMgr.a().b();
      if (localObject != null)
      {
        localObject = (BaseQQAppInterface)localObject;
        long l1 = this.g;
        long l2 = this.e;
        long l3 = 14;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.v, paramHttpMsg1, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.g, "actFileUfGenDownloadDetail", this.e, "", "", "", "", l3, paramHttpMsg1, this.f, this.m, this.i, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.v, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg1 = a;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[UniformDL][");
        paramHttpMsg2.append(this.g);
        paramHttpMsg2.append("].report failed - 2");
        QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
      }
      paramHttpMsg1 = k();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGenWorker
 * JD-Core Version:    0.7.0.1
 */