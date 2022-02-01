package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.ITroopFileTransferRetrySink;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.HostInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class TroopFileDownloader
  implements TroopFileTransferRetryController.ITroopFileTransferRetrySink, FtnDownloader.IHttpDownloadSink, ITroopFileDownloader
{
  protected long a = 0L;
  protected final long b;
  protected String c;
  protected String d;
  protected int e;
  protected int f;
  protected String g;
  protected boolean h = true;
  protected String i;
  protected long j = 0L;
  protected long k = 0L;
  protected final TroopFileTransferRetryController l;
  protected FileOutputStream m = null;
  protected ITroopFileDownloaderSink n;
  protected FtnDownloader o;
  protected boolean p = true;
  protected long q = 0L;
  protected long r = 0L;
  private boolean s = false;
  
  protected TroopFileDownloader(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.b = paramLong1;
    this.j = paramLong2;
    this.i = paramString1;
    this.l = new TroopFileTransferRetryController(paramQQAppInterface, paramList, paramString2, this.b, paramBoolean, this);
    this.c = this.l.a();
    paramString1 = TroopFileTransferUtil.d(this.c);
    if (paramString1 != null)
    {
      this.d = paramString1.a;
      this.e = paramString1.b;
      this.f = paramString1.c;
    }
    this.g = paramString3;
    this.o = new FtnDownloader(paramQQAppInterface, paramLong1, 1, 0, paramLong2, paramBoolean, paramString4);
    this.o.a(this);
  }
  
  public static ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    String str;
    if (paramString1 == null) {
      str = "strSavePath is null";
    } else if (paramString1.length() == 0) {
      str = "strSavePath is empty";
    } else if (paramList == null) {
      str = "lstUrl is null";
    } else if (paramList.size() == 0) {
      str = "lstUrl is empty";
    } else if (paramString2 == null) {
      str = "urlParams is null";
    } else if (paramString2.length() == 0) {
      str = "urlParams is empty";
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      int i1 = TroopFileTransferUtil.Log.b;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFileDownloader ");
      paramQQAppInterface.append(str);
      TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, paramQQAppInterface.toString());
      return null;
    }
    return new TroopFileDownloader(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  private boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717")));
  }
  
  private boolean d(String paramString)
  {
    return (paramString.indexOf("-29120") > 0) || (paramString.indexOf("-502") > 0) || (paramString.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString.indexOf("-21122") > 0) || (paramString.indexOf("-28123") > 0) || (paramString.indexOf("-25081") > 0) || (paramString.indexOf("-28126") > 0);
  }
  
  private boolean e(String paramString)
  {
    return (paramString.indexOf("-6101") > 0) || (paramString.indexOf("-7003") > 0) || (paramString.indexOf("-403") > 0) || (paramString.indexOf("-9006") > 0) || (paramString.indexOf("-9004") > 0) || (paramString.indexOf("-9017") > 0) || (paramString.indexOf("-29150") > 0) || (paramString.indexOf("-28137") > 0);
  }
  
  private void j()
  {
    if (this.h) {
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] reDownload mstrUrl:");
    ((StringBuilder)localObject).append(this.c);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, ((StringBuilder)localObject).toString());
    h();
    localObject = this.n;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).g();
    }
    this.k = FileManagerUtil.h(this.i);
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      a(true, 9004, "no net work", "");
      return;
    }
    d();
  }
  
  public long a()
  {
    return 100L;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    if (this.h) {
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, paramString1, paramString2);
      return;
    }
    if ((paramHttpMsg != null) && (paramHttpMsg.mConn != null) && (c(paramHttpMsg.mConn.getHeaderField("User-ReturnCode"))))
    {
      a(true, -5003, paramString1, paramString2);
      return;
    }
    if (e(paramString1))
    {
      a(true, 9042, paramString1, paramString2);
      return;
    }
    if (("content zero".equalsIgnoreCase(paramString1)) && (paramString2 != null) && (paramString2.indexOf("-31713") > 0))
    {
      a(true, 9042, paramString1, paramString2);
      return;
    }
    if (paramString1.contains("SSLPeerUnverifiedException"))
    {
      a(true, paramInt, paramString1, paramString2);
      return;
    }
    boolean bool;
    if (d(paramString1))
    {
      paramInt = 9042;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(true, 9004, paramString1, paramString2);
      return;
    }
    this.s = false;
    int i1 = TroopFileTransferUtil.Log.b;
    paramHttpMsg = new StringBuilder();
    paramHttpMsg.append("[");
    paramHttpMsg.append(this.b);
    paramHttpMsg.append("] onErr errCode:");
    paramHttpMsg.append(paramInt);
    paramHttpMsg.append(" errMsg:");
    paramHttpMsg.append(paramString1);
    paramHttpMsg.append(" rspHeader:");
    paramHttpMsg.append(paramString2);
    TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, paramHttpMsg.toString());
    if (this.l.a(this.c, paramInt, bool))
    {
      a(false, paramInt, paramString1, paramString2);
      return;
    }
    a(true, paramInt, paramString1, paramString2);
  }
  
  public void a(ITroopFileDownloaderSink paramITroopFileDownloaderSink)
  {
    this.n = paramITroopFileDownloaderSink;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(String paramString)
  {
    if (this.h)
    {
      i1 = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.b);
      paramString.append("] onRetry but stoped");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, paramString.toString());
      return;
    }
    int i1 = 0;
    if (!this.c.equalsIgnoreCase(paramString))
    {
      i1 = 1;
      int i2 = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] onRetry urlChanged");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i2, localStringBuilder.toString());
    }
    this.c = paramString;
    if (i1 != 0)
    {
      paramString = TroopFileTransferUtil.d(this.c);
      if (paramString != null)
      {
        this.d = paramString.a;
        this.e = paramString.b;
        this.f = paramString.c;
      }
      this.n.b(this.c);
    }
    j();
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    long l1;
    if (paramBoolean)
    {
      this.h = true;
      g();
      e();
      l1 = System.currentTimeMillis();
    }
    else
    {
      l1 = 0L;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] onErr errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bFinished:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" rspHeader:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" cost:");
    if (paramBoolean) {
      localObject = Long.valueOf(l1 - this.a);
    } else {
      localObject = "";
    }
    localStringBuilder.append(localObject);
    TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, localStringBuilder.toString());
    Object localObject = this.n;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).a(paramBoolean, this.k, paramInt, paramString1, paramString2, new Bundle());
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.h) {
      return;
    }
    if ((this.j == 0L) && (paramLong != 0L))
    {
      int i1 = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] onData getted filesize=");
      localStringBuilder.append(paramLong);
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, localStringBuilder.toString());
      this.j = paramLong;
    }
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      try
      {
        this.m.write(paramArrayOfByte);
        paramLong = paramArrayOfByte.length;
        this.k += paramLong;
        this.r += paramLong;
        if (!this.s)
        {
          this.s = true;
          this.l.a(this.c);
        }
        paramLong = this.k;
        long l1 = this.j;
        if (paramLong == l1)
        {
          i();
          return;
        }
        if (paramLong > l1)
        {
          a(true, -5001, "transfersize > filesize", paramString);
          return;
        }
        if (this.p)
        {
          paramLong = System.currentTimeMillis();
          l1 = this.q;
          if ((l1 == 0L) || (paramLong - l1 >= 1000L))
          {
            paramArrayOfByte = this.n;
            if (paramArrayOfByte != null) {
              paramArrayOfByte.a(this.k, this.j);
            }
          }
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.getMessage().contains("ENOSPC");
        a(true, 9301, "write exception", paramString);
      }
    }
  }
  
  public void b() {}
  
  public void b(HttpMsg paramHttpMsg)
  {
    paramHttpMsg.setRequestProperty("User-Agent", "TroopFile");
    if (!TextUtils.isEmpty(this.g))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FTN5K=");
      localStringBuilder.append(this.g);
      paramHttpMsg.setRequestProperty("Cookie", localStringBuilder.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (this.h) {
      return;
    }
    a(true, 9062, "net redirect", "");
  }
  
  protected boolean c()
  {
    if (!Common.d())
    {
      a(true, 9039, "no sdcard", null);
      return true;
    }
    Object localObject = new File(this.i);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      label50:
      long l1;
      int i1;
      long l2;
      break label50;
    }
    a(true, -5000, "create new file excption", null);
    return true;
    this.k = FileManagerUtil.h(this.i);
    l1 = this.j;
    if (l1 == 0L)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] checkexcpover fileSize=0");
      TroopFileTransferUtil.Log.b("TroopFileDownloader", i1, ((StringBuilder)localObject).toString());
      return false;
    }
    l2 = this.k;
    if (l2 > l1)
    {
      new File(this.i).delete();
      this.k = 0L;
      return false;
    }
    if (l2 == l1)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] checkexcpover tmpfilesize=filesize");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, ((StringBuilder)localObject).toString());
      i();
      return true;
    }
    if (FMSettings.a().getDefalutStorgeFreeSpace() < l1 - l2)
    {
      a(true, 9040, "no enugh space", null);
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    e();
    this.o.a(this.c, this.k);
  }
  
  protected void e()
  {
    this.o.a();
  }
  
  protected boolean f()
  {
    g();
    try
    {
      this.m = new FileOutputStream(this.i, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      int i1 = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] openOutputStream excp");
      TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, localStringBuilder.toString());
      this.m = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  protected void g()
  {
    FileOutputStream localFileOutputStream = this.m;
    if (localFileOutputStream != null)
    {
      try
      {
        localFileOutputStream.close();
      }
      catch (IOException localIOException)
      {
        int i1 = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] closeOutputStream excp");
        TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
      this.m = null;
    }
  }
  
  protected void h()
  {
    FileOutputStream localFileOutputStream = this.m;
    if (localFileOutputStream != null) {
      try
      {
        localFileOutputStream.flush();
      }
      catch (IOException localIOException)
      {
        int i1 = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] flushOutputStream excp");
        TroopFileTransferUtil.Log.a("TroopFileDownloader", i1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
    }
    this.r = 0L;
  }
  
  protected void i()
  {
    this.h = true;
    g();
    e();
    long l1 = System.currentTimeMillis();
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] onSuc. cost:");
    ((StringBuilder)localObject).append(l1 - this.a);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, ((StringBuilder)localObject).toString());
    localObject = this.n;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).a(this.i);
    }
  }
  
  public void k()
  {
    this.h = false;
    this.a = System.currentTimeMillis();
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] download url:");
    localStringBuilder.append(this.c);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, localStringBuilder.toString());
    ThreadManager.post(new TroopFileDownloader.1(this), 8, null, false);
  }
  
  public void l()
  {
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] cancelTask");
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i1, localStringBuilder.toString());
    this.h = true;
    g();
    e();
  }
  
  public int m()
  {
    return this.l.c();
  }
  
  public boolean n()
  {
    return this.l.d();
  }
  
  public String o()
  {
    return this.c;
  }
  
  public String p()
  {
    return this.d;
  }
  
  public int q()
  {
    return this.e;
  }
  
  public int r()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader
 * JD-Core Version:    0.7.0.1
 */