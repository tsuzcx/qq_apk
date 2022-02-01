package com.tencent.mobileqq.uftransfer.common.transfer.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTTransferUtil;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTTransferUtil.HostInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.IUFTRetryCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UFTFtnFileDownloader
  extends UFTFileDownloaderCbWrapper
  implements IUFTFileDownloader, IUFTFtnDownloaderCallback, IUFTRetryCallback
{
  protected int a;
  protected final long a;
  protected UFTFtnDownloader a;
  private final UFTUrlProvider a;
  protected FileOutputStream a;
  protected String a;
  protected boolean a;
  protected int b;
  protected long b;
  protected String b;
  protected long c;
  protected String c;
  private boolean d;
  protected long e;
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717")));
  }
  
  private long b()
  {
    long l;
    if (SystemUtil.a()) {
      l = SystemUtil.a();
    } else {
      l = SystemUtil.b();
    }
    return l * 1024L;
  }
  
  private boolean b(String paramString)
  {
    return (paramString.indexOf("-29120") > 0) || (paramString.indexOf("-502") > 0) || (paramString.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString.indexOf("-21122") > 0) || (paramString.indexOf("-28123") > 0) || (paramString.indexOf("-25081") > 0) || (paramString.indexOf("-28126") > 0);
  }
  
  private boolean c(String paramString)
  {
    return (paramString.indexOf("-6101") > 0) || (paramString.indexOf("-7003") > 0) || (paramString.indexOf("-403") > 0) || (paramString.indexOf("-9006") > 0) || (paramString.indexOf("-9004") > 0) || (paramString.indexOf("-9017") > 0) || (paramString.indexOf("-29150") > 0) || (paramString.indexOf("-28137") > 0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] reDownload mstrUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
    c();
    b(this.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
    if (!UFTDependFeatureApi.a())
    {
      a(true, 9004, this.jdField_c_of_type_Long, "no net work", "", null);
      return;
    }
    if (!c()) {
      a(true, 9049, this.jdField_c_of_type_Long, "download filedata fail", "", null);
    }
  }
  
  public long a()
  {
    return 6000L;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader.a();
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] onDownloadErr.errcode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" rspHeader:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, (String)localObject);
    if (!UFTDependFeatureApi.a())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Id[");
      paramBundle.append(this.jdField_a_of_type_Long);
      paramBundle.append("] onDownloadErr. no network");
      UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, paramBundle.toString());
      a(true, 9004, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("User-ReturnCode");
    } else {
      paramBundle = "";
    }
    if (a(paramBundle))
    {
      a(true, -5003, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (c(paramString1))
    {
      a(true, 9042, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (("content zero".equalsIgnoreCase(paramString1)) && (paramString2 != null) && (paramString2.indexOf("-31713") > 0))
    {
      a(true, 9042, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (paramString1.contains("SSLPeerUnverifiedException"))
    {
      a(true, paramInt, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    if (b(paramString1)) {
      paramInt = 9042;
    } else {
      bool = false;
    }
    this.d = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a(this.jdField_a_of_type_JavaLangString, paramInt, bool))
    {
      a(false, paramInt, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    a(true, paramInt, this.jdField_c_of_type_Long, paramString1, paramString2, null);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_b_of_type_Long == 0L) && (paramLong != 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] onData getted filesize=");
      localStringBuilder.append(paramLong);
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      this.jdField_b_of_type_Long = paramLong;
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
        this.jdField_c_of_type_Long += paramLong;
        this.e += paramLong;
        if (!this.d)
        {
          this.d = true;
          this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a(this.jdField_a_of_type_JavaLangString);
        }
        paramLong = this.jdField_c_of_type_Long;
        long l = this.jdField_b_of_type_Long;
        if (paramLong == l)
        {
          a(this.jdField_c_of_type_JavaLangString, null);
          return;
        }
        if (paramLong > l)
        {
          a(true, -5001, paramLong, "transfersize > filesize", paramString, null);
          return;
        }
        a(paramLong, l);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.getMessage().contains("ENOSPC");
        a(true, 9301, this.jdField_c_of_type_Long, "write exception", paramString, null);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("] closeOutputStream excp");
        UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
    }
  }
  
  protected boolean b()
  {
    Object localObject = new File(this.jdField_c_of_type_JavaLangString);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException1)
    {
      label30:
      long l1;
      long l2;
      break label30;
    }
    a(true, -5000, this.jdField_c_of_type_Long, "create new file excption", null, null);
    return true;
    this.jdField_c_of_type_Long = ((File)localObject).length();
    l1 = this.jdField_b_of_type_Long;
    if (l1 == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] checkexcpover fileSize=0");
      UFTLog.c("[UFTTransfer] UFTFtnFileDownloader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    l2 = this.jdField_c_of_type_Long;
    if (l2 > l1) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      this.jdField_c_of_type_Long = 0L;
      return false;
    }
    catch (IOException localIOException2)
    {
      label148:
      break label148;
    }
    a(true, -5000, this.jdField_c_of_type_Long, "create new file excption", null, null);
    return true;
    if (l2 == l1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] checkexcpover tmpfilesize=filesize");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, ((StringBuilder)localObject).toString());
      a(this.jdField_c_of_type_JavaLangString, null);
      return true;
    }
    if (b() < l1 - l2)
    {
      a(true, 9040, this.jdField_c_of_type_Long, "no enugh space", null, null);
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    FileOutputStream localFileOutputStream = this.jdField_a_of_type_JavaIoFileOutputStream;
    if (localFileOutputStream != null) {
      try
      {
        localFileOutputStream.flush();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("] flushOutputStream excp");
        UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
    }
    this.e = 0L;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append("] onRetry but stoped");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, paramString.toString());
      return;
    }
    int i = 0;
    if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] onRetry urlChanged");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = UFTTransferUtil.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      a(this.jdField_a_of_type_JavaLangString);
    }
    d();
  }
  
  protected boolean c()
  {
    a();
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long);
  }
  
  protected boolean d()
  {
    b();
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_c_of_type_JavaLangString, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] openOutputStream excp");
      UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public void f_(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, 9062, this.jdField_c_of_type_Long, "net redirect", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFtnFileDownloader
 * JD-Core Version:    0.7.0.1
 */