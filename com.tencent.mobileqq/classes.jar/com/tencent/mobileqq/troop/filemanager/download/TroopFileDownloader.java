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
  protected int a;
  protected long a;
  protected final TroopFileTransferRetryController a;
  protected FtnDownloader a;
  protected ITroopFileDownloaderSink a;
  protected FileOutputStream a;
  protected String a;
  protected boolean a;
  protected int b;
  protected final long b;
  protected String b;
  protected boolean b;
  protected long c;
  protected String c;
  private boolean c;
  protected long d;
  protected String d;
  protected long e = 0L;
  protected long f = 0L;
  
  protected TroopFileDownloader(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaIoFileOutputStream = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController = new TroopFileTransferRetryController(paramQQAppInterface, paramList, paramString2, this.jdField_b_of_type_Long, paramBoolean, this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
    paramString1 = TroopFileTransferUtil.a(this.jdField_a_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader = new FtnDownloader(paramQQAppInterface, paramLong1, 1, 0, paramLong2, paramBoolean, paramString4);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader.a(this);
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
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFileDownloader ");
      paramQQAppInterface.append(str);
      TroopFileTransferUtil.Log.a("TroopFileDownloader", i, paramQQAppInterface.toString());
      return null;
    }
    return new TroopFileDownloader(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717")));
  }
  
  private boolean b(String paramString)
  {
    return (paramString.indexOf("-29120") > 0) || (paramString.indexOf("-502") > 0) || (paramString.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString.indexOf("-21122") > 0) || (paramString.indexOf("-28123") > 0) || (paramString.indexOf("-25081") > 0) || (paramString.indexOf("-28126") > 0);
  }
  
  private boolean c(String paramString)
  {
    return (paramString.indexOf("-6101") > 0) || (paramString.indexOf("-7003") > 0) || (paramString.indexOf("-403") > 0) || (paramString.indexOf("-9006") > 0) || (paramString.indexOf("-9004") > 0) || (paramString.indexOf("-9017") > 0) || (paramString.indexOf("-29150") > 0) || (paramString.indexOf("-28137") > 0);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append("] reDownload mstrUrl:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i, ((StringBuilder)localObject).toString());
    g();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).d();
    }
    this.jdField_d_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
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
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, paramString1, paramString2);
      return;
    }
    if ((paramHttpMsg != null) && (paramHttpMsg.mConn != null) && (a(paramHttpMsg.mConn.getHeaderField("User-ReturnCode"))))
    {
      a(true, -5003, paramString1, paramString2);
      return;
    }
    if (c(paramString1))
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
    if (b(paramString1))
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
    this.jdField_c_of_type_Boolean = false;
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramHttpMsg = new StringBuilder();
    paramHttpMsg.append("[");
    paramHttpMsg.append(this.jdField_b_of_type_Long);
    paramHttpMsg.append("] onErr errCode:");
    paramHttpMsg.append(paramInt);
    paramHttpMsg.append(" errMsg:");
    paramHttpMsg.append(paramString1);
    paramHttpMsg.append(" rspHeader:");
    paramHttpMsg.append(paramString2);
    TroopFileTransferUtil.Log.a("TroopFileDownloader", i, paramHttpMsg.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a(this.jdField_a_of_type_JavaLangString, paramInt, bool))
    {
      a(false, paramInt, paramString1, paramString2);
      return;
    }
    a(true, paramInt, paramString1, paramString2);
  }
  
  public void a(ITroopFileDownloaderSink paramITroopFileDownloaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink = paramITroopFileDownloaderSink;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_b_of_type_Long);
      paramString.append("] onRetry but stoped");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i, paramString.toString());
      return;
    }
    int i = 0;
    if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      i = 1;
      int j = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("] onRetry urlChanged");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", j, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = TroopFileTransferUtil.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink.b(this.jdField_a_of_type_JavaLangString);
    }
    i();
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    long l;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      f();
      e();
      l = System.currentTimeMillis();
    }
    else
    {
      l = 0L;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
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
      localObject = Long.valueOf(l - this.jdField_a_of_type_Long);
    } else {
      localObject = "";
    }
    localStringBuilder.append(localObject);
    TroopFileTransferUtil.Log.a("TroopFileDownloader", i, localStringBuilder.toString());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).a(paramBoolean, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2, new Bundle());
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_c_of_type_Long == 0L) && (paramLong != 0L))
    {
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("] onData getted filesize=");
      localStringBuilder.append(paramLong);
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i, localStringBuilder.toString());
      this.jdField_c_of_type_Long = paramLong;
    }
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte);
        paramLong = paramArrayOfByte.length;
        this.jdField_d_of_type_Long += paramLong;
        this.f += paramLong;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a(this.jdField_a_of_type_JavaLangString);
        }
        paramLong = this.jdField_d_of_type_Long;
        long l = this.jdField_c_of_type_Long;
        if (paramLong == l)
        {
          h();
          return;
        }
        if (paramLong > l)
        {
          a(true, -5001, "transfersize > filesize", paramString);
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          paramLong = System.currentTimeMillis();
          l = this.e;
          if ((l == 0L) || (paramLong - l >= 1000L))
          {
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink;
            if (paramArrayOfByte != null) {
              paramArrayOfByte.a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
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
  
  protected boolean a()
  {
    if (!Common.a())
    {
      a(true, 9039, "no sdcard", null);
      return true;
    }
    Object localObject = new File(this.jdField_d_of_type_JavaLangString);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      label50:
      long l1;
      int i;
      long l2;
      break label50;
    }
    a(true, -5000, "create new file excption", null);
    return true;
    this.jdField_d_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    l1 = this.jdField_c_of_type_Long;
    if (l1 == 0L)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("] checkexcpover fileSize=0");
      TroopFileTransferUtil.Log.b("TroopFileDownloader", i, ((StringBuilder)localObject).toString());
      return false;
    }
    l2 = this.jdField_d_of_type_Long;
    if (l2 > l1)
    {
      new File(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_d_of_type_Long = 0L;
      return false;
    }
    if (l2 == l1)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("] checkexcpover tmpfilesize=filesize");
      TroopFileTransferUtil.Log.c("TroopFileDownloader", i, ((StringBuilder)localObject).toString());
      h();
      return true;
    }
    if (FMSettings.a().getDefalutStorgeFreeSpace() < l1 - l2)
    {
      a(true, 9040, "no enugh space", null);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("] download url:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i, localStringBuilder.toString());
    ThreadManager.post(new TroopFileDownloader.1(this), 8, null, false);
  }
  
  public void b(HttpMsg paramHttpMsg)
  {
    paramHttpMsg.setRequestProperty("User-Agent", "TroopFile");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FTN5K=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      paramHttpMsg.setRequestProperty("Cookie", localStringBuilder.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, 9062, "net redirect", "");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("] cancelTask");
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    f();
    e();
  }
  
  protected boolean c()
  {
    f();
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("] openOutputStream excp");
      TroopFileTransferUtil.Log.a("TroopFileDownloader", i, localStringBuilder.toString());
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void d()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader.a(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Long);
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader.a();
  }
  
  protected void f()
  {
    FileOutputStream localFileOutputStream = this.jdField_a_of_type_JavaIoFileOutputStream;
    if (localFileOutputStream != null)
    {
      try
      {
        localFileOutputStream.close();
      }
      catch (IOException localIOException)
      {
        int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        localStringBuilder.append("] closeOutputStream excp");
        TroopFileTransferUtil.Log.a("TroopFileDownloader", i, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
    }
  }
  
  protected void g()
  {
    FileOutputStream localFileOutputStream = this.jdField_a_of_type_JavaIoFileOutputStream;
    if (localFileOutputStream != null) {
      try
      {
        localFileOutputStream.flush();
      }
      catch (IOException localIOException)
      {
        int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        localStringBuilder.append("] flushOutputStream excp");
        TroopFileTransferUtil.Log.a("TroopFileDownloader", i, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
    }
    this.f = 0L;
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = true;
    f();
    e();
    long l = System.currentTimeMillis();
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append("] onSuc. cost:");
    ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
    TroopFileTransferUtil.Log.c("TroopFileDownloader", i, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink;
    if (localObject != null) {
      ((ITroopFileDownloaderSink)localObject).a(this.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader
 * JD-Core Version:    0.7.0.1
 */