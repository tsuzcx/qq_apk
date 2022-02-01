package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperPropV1;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.IUFTRetryCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTSmartUrlProvider;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.depend.UFTSscm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.AppRuntime;

public class UFTFtnFileUploader
  extends UFTFileUploaderCbWrapper
  implements IUFTFileUploader, IUFTFtnUploaderCallback, IUFTRetryCallback
{
  private int jdField_a_of_type_Int = 0;
  private final long jdField_a_of_type_Long;
  private IUFTFtnUploader jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader;
  private final UFTUrlProvider jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider;
  private UFTSscm jdField_a_of_type_ComTencentMobileqqUftransferDependUFTSscm = new UFTSscm();
  private InputStream jdField_a_of_type_JavaIoInputStream = null;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  
  private UFTFtnFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperProp paramFtnMoreUrlFUperProp)
  {
    this.jdField_a_of_type_Long = paramFtnMoreUrlFUperProp.a();
    this.jdField_a_of_type_JavaLangString = paramFtnMoreUrlFUperProp.b();
    this.jdField_b_of_type_Long = new File(this.jdField_a_of_type_JavaLangString).length();
    if (paramFtnMoreUrlFUperProp.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider = new UFTSmartUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperProp.a(), paramFtnMoreUrlFUperProp.f(), this.jdField_a_of_type_Long, paramFtnMoreUrlFUperProp.c(), this);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider = new UFTUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperProp.a(), paramFtnMoreUrlFUperProp.f(), this.jdField_a_of_type_Long, paramFtnMoreUrlFUperProp.c(), this);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a();
    UFTFtnUploader.UperProp localUperProp = new UFTFtnUploader.UperProp();
    localUperProp.a(this.jdField_b_of_type_Long);
    localUperProp.a(paramFtnMoreUrlFUperProp.a());
    localUperProp.b(0);
    localUperProp.a(paramFtnMoreUrlFUperProp.c());
    localUperProp.b(paramFtnMoreUrlFUperProp.d());
    localUperProp.a(paramFtnMoreUrlFUperProp.c());
    localUperProp.c(paramFtnMoreUrlFUperProp.g());
    localUperProp.d(paramFtnMoreUrlFUperProp.e());
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader = UFTFtnUploader.a(paramAppRuntime, this.jdField_a_of_type_Long, localUperProp);
    paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader;
    if (paramAppRuntime != null) {
      paramAppRuntime.a(this);
    }
  }
  
  private UFTFtnFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperPropV1 paramFtnMoreUrlFUperPropV1)
  {
    this.jdField_a_of_type_Long = paramFtnMoreUrlFUperPropV1.a();
    this.jdField_a_of_type_JavaLangString = paramFtnMoreUrlFUperPropV1.b();
    this.jdField_b_of_type_Long = new File(this.jdField_a_of_type_JavaLangString).length();
    if (paramFtnMoreUrlFUperPropV1.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider = new UFTSmartUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperPropV1.a(), paramFtnMoreUrlFUperPropV1.f(), this.jdField_a_of_type_Long, paramFtnMoreUrlFUperPropV1.c(), this);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider = new UFTUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperPropV1.a(), paramFtnMoreUrlFUperPropV1.f(), this.jdField_a_of_type_Long, paramFtnMoreUrlFUperPropV1.c(), this);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader = UFTFtnV1Uploader.a(paramAppRuntime, this.jdField_a_of_type_Long, paramFtnMoreUrlFUperPropV1.a(), 0, paramFtnMoreUrlFUperPropV1.c(), paramFtnMoreUrlFUperPropV1.g());
    paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader;
    if (paramAppRuntime != null) {
      paramAppRuntime.a(this);
    }
  }
  
  public static UFTFtnFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperProp paramFtnMoreUrlFUperProp)
  {
    if ((paramAppRuntime != null) && (paramFtnMoreUrlFUperProp != null))
    {
      if (!paramFtnMoreUrlFUperProp.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramFtnMoreUrlFUperProp.a());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      }
      return new UFTFtnFileUploader(paramAppRuntime, paramFtnMoreUrlFUperProp);
    }
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
    return null;
  }
  
  public static UFTFtnFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperPropV1 paramFtnMoreUrlFUperPropV1)
  {
    if ((paramAppRuntime != null) && (paramFtnMoreUrlFUperPropV1 != null))
    {
      if (!paramFtnMoreUrlFUperPropV1.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramFtnMoreUrlFUperPropV1.a());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      }
      return new UFTFtnFileUploader(paramAppRuntime, paramFtnMoreUrlFUperPropV1);
    }
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
    return null;
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    d();
    c();
    a(true, paramInt, paramLong, paramString1, paramString2, null);
  }
  
  private void a(long paramLong)
  {
    Object localObject = a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] getSendStreamSlice return null");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      UFTLogicThread.a().a(new UFTFtnFileUploader.1(this));
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader.a(this.jdField_b_of_type_JavaLangString, paramLong, (byte[])localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] upload file data fail");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      UFTLogicThread.a().a(new UFTFtnFileUploader.2(this));
    }
  }
  
  private byte[] a(long paramLong)
  {
    if (paramLong == 0L) {}
    try
    {
      if (!b())
      {
        return null;
        long l = this.jdField_d_of_type_Long;
        if (paramLong > l)
        {
          try
          {
            this.jdField_a_of_type_JavaIoInputStream.skip(paramLong - this.jdField_d_of_type_Long);
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            return null;
          }
        }
        else if (paramLong < this.jdField_d_of_type_Long)
        {
          boolean bool = b();
          if (!bool) {
            return null;
          }
          try
          {
            this.jdField_a_of_type_JavaIoInputStream.skip(paramLong);
          }
          catch (IOException localIOException2)
          {
            this.jdField_a_of_type_JavaIoInputStream = null;
            localIOException2.printStackTrace();
            return null;
          }
        }
      }
      this.jdField_d_of_type_Long = paramLong;
      int i = this.jdField_a_of_type_ComTencentMobileqqUftransferDependUFTSscm.a(this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
      byte[] arrayOfByte = new byte[i];
      try
      {
        this.jdField_a_of_type_JavaIoInputStream.read(arrayOfByte, 0, i);
        this.jdField_d_of_type_Long += i;
        return arrayOfByte;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Id[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("] getSendStreamSlice exception:");
        localStringBuilder.append(localException1.toString());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
        return null;
      }
      return null;
    }
    catch (Exception localException2) {}
  }
  
  private void b(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RangSizeError_rangError tSize[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]<=mSize[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("], lastRoolbackSize[");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("], retry[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    if (paramLong <= this.h)
    {
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i > 6)
      {
        a(9009, paramLong, (String)localObject, paramString);
        return;
      }
    }
    this.h = paramLong;
    this.jdField_c_of_type_Long = paramLong;
    UFTLogicThread.a().a(new UFTFtnFileUploader.3(this), 6000L);
    a(paramLong, (String)localObject, paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    d();
    a(paramBoolean, null);
  }
  
  private boolean b()
  {
    InputStream localInputStream = this.jdField_a_of_type_JavaIoInputStream;
    if (localInputStream != null)
    {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    try
    {
      this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      this.jdField_a_of_type_JavaIoInputStream = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    IUFTFtnUploader localIUFTFtnUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader;
    if (localIUFTFtnUploader != null) {
      localIUFTFtnUploader.a();
    }
  }
  
  private void d()
  {
    InputStream localInputStream = this.jdField_a_of_type_JavaIoInputStream;
    if (localInputStream != null) {}
    try
    {
      localInputStream.close();
      label13:
      this.jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a();
  }
  
  public long a()
  {
    return 6000L;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    a(true);
    d();
    c();
    this.jdField_a_of_type_Boolean = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] cancel");
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(9343, this.jdField_c_of_type_Long, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onUploadErr.errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString1);
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
    if (!UFTDependFeatureApi.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] onUploadErr. no network");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      a(9004, this.jdField_c_of_type_Long, paramString1, paramString2);
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        a(-29602, this.jdField_c_of_type_Long, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        a(9042, this.jdField_c_of_type_Long, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        aS_();
        return;
      }
      if ((paramString1.indexOf("-38006") > 0) || (paramString1.indexOf("-38007") > 0) || (paramString1.indexOf("-38020") > 0))
      {
        a(paramInt, this.jdField_c_of_type_Long, paramString1, paramString2);
        return;
      }
    }
    if ((paramString1 != null) && (paramString1.contains("SSLPeerUnverifiedException")))
    {
      a(paramInt, this.jdField_c_of_type_Long, paramString1, paramString2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a(this.jdField_b_of_type_JavaLangString, paramInt, false))
    {
      a(false, paramInt, this.jdField_c_of_type_Long, paramString1, paramString2, null);
      return;
    }
    a(paramInt, this.jdField_c_of_type_Long, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferDependUFTSscm.a();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (paramLong == this.g) {
        this.f = 0L;
      } else {
        this.f = paramLong;
      }
    }
    long l = this.jdField_c_of_type_Long;
    if (paramLong <= l)
    {
      b(paramLong, paramString);
      return;
    }
    if (l == 0L)
    {
      l = this.jdField_b_of_type_Long;
      if (paramLong == l)
      {
        this.f = 0L;
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_Boolean = true;
        b(true);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    if (UFTLog.a())
    {
      paramString = new StringBuilder();
      paramString.append("send http data size[");
      paramString.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString.append("] fileSize[");
      paramString.append(this.jdField_b_of_type_Long);
      paramString.append("] success!");
      UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 4, paramString.toString());
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      a(paramLong, this.f, 0L);
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a(this.jdField_b_of_type_JavaLangString);
      a(this.jdField_c_of_type_Long);
      return;
    }
    b(false);
  }
  
  public void a(IUFTFileUploaderCallback paramIUFTFileUploaderCallback)
  {
    b(paramIUFTFileUploaderCallback);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider.a();
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]uploadFile fail. uploader is null");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("]uploadFile url:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" pos:");
    ((StringBuilder)localObject).append(paramLong);
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    localObject = a(paramLong);
    if (localObject != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploader.a(this.jdField_b_of_type_JavaLangString, paramLong, (byte[])localObject);
    }
    if (bool)
    {
      long l = this.jdField_d_of_type_Long;
      if (l > paramLong)
      {
        this.g = (l - paramLong);
        break label213;
      }
    }
    this.g = 0L;
    label213:
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]uploadFile return fail");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Boolean = true;
    }
    return bool;
  }
  
  public long b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = this.jdField_b_of_type_Long;
    this.jdField_c_of_type_Long = l;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.f = l;
      this.jdField_d_of_type_Boolean = true;
    }
    b(this.jdField_d_of_type_Boolean);
  }
  
  public long b_()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramString.equals(this.jdField_b_of_type_JavaLangString)) {
      a(paramString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqUftransferDependUFTSscm = new UFTSscm();
    this.jdField_c_of_type_Long = 0L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onRetry. url:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
    b(this.jdField_b_of_type_JavaLangString);
    a(0L);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g_(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(9062, this.jdField_c_of_type_Long, "UrlOver", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader
 * JD-Core Version:    0.7.0.1
 */