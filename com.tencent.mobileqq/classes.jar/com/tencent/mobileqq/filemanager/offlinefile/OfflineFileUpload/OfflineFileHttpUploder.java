package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class OfflineFileHttpUploder
  implements INetEngineListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  IOfflineFileHttpUploderSink jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  InputStream jdField_a_of_type_JavaIoInputStream;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("]stop");
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).mCallback = this;
    ((HttpNetReq)localObject1).mReqUrl = this.jdField_a_of_type_JavaLangString;
    ((HttpNetReq)localObject1).mHttpMethod = 1;
    ((HttpNetReq)localObject1).mReqProperties.put("Accept-Encoding", "identity");
    ((HttpNetReq)localObject1).mMsgId = this.jdField_c_of_type_JavaLangString;
    try
    {
      localObject2 = a(paramLong);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a((byte[])localObject2, paramLong);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
        return;
      }
      ((HttpNetReq)localObject1).mSendData = ((byte[])localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject1);
      ((HttpNetReq)localObject1).mTimeoutParam = FileManagerUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq((NetReq)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("logID[");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("]Send Http Request!");
        QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logID[");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("] Exception:");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
    }
  }
  
  byte[] a(long paramLong)
  {
    if (paramLong == 0L) {
      this.jdField_b_of_type_Long = 0L;
    }
    if (this.jdField_a_of_type_JavaIoInputStream == null) {
      try
      {
        this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_Long = 0L;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
        localFileNotFoundException1.printStackTrace();
        return null;
      }
    }
    if (paramLong == 0L)
    {
      if (this.jdField_c_of_type_Long != 0L) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          this.jdField_c_of_type_Long = 0L;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException2.printStackTrace();
          return null;
        }
      }
    }
    else
    {
      long l = this.jdField_c_of_type_Long;
      if (paramLong > l) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream.skip(paramLong - l);
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return null;
        }
      } else if (paramLong < l) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          this.jdField_c_of_type_Long = 0L;
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
    this.jdField_c_of_type_Long = paramLong;
    int i = OfflineFileHttpUtils.a(this.jdField_a_of_type_ComTencentWsttSSCMSSCM, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, paramLong);
    byte[] arrayOfByte = new byte[i];
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.read(arrayOfByte, 0, i);
      this.jdField_c_of_type_Long += i;
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      label250:
      break label250;
    }
    return null;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("logID[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]onResp result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      ((StringBuilder)localObject).append(" errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject).append(" errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    int i = paramNetResp.mHttpCode;
    if ((paramNetResp.mErrCode == 9364) && (this.jdField_a_of_type_Int < 3))
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("logID[");
      paramNetResp.append(this.jdField_c_of_type_JavaLangString);
      paramNetResp.append("]onNetChanged:mNetworkChangRetryCount[");
      paramNetResp.append(this.jdField_a_of_type_Int);
      paramNetResp.append("] retry!");
      QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      paramNetResp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink;
      if (paramNetResp != null) {
        paramNetResp.a(true);
      }
      a(this.jdField_b_of_type_Long);
      return;
    }
    if (FileHttpUtils.a(paramNetResp.mErrCode))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
      if (localObject != null)
      {
        localObject = ((HttpUrlProcessor)localObject).a();
        if (localObject != null)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localObject);
          a(this.jdField_b_of_type_Long);
          return;
        }
      }
    }
    if ((i == 200) && (paramNetResp.mResult == 0))
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
      localObject = (String)paramNetResp.mRespProperties.get("User-ReturnCode");
      if (localObject != null) {
        l1 = Long.parseLong((String)localObject);
      } else {
        l1 = 0L;
      }
      if (l1 != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.jdField_c_of_type_JavaLangString);
          paramNetResp.append("ResponCode[206]But UserCode[");
          paramNetResp.append(l1);
          paramNetResp.append("]");
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        }
        return;
      }
      long l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(paramNetResp);
      if (l1 == -1L)
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("logID[");
        paramNetResp.append(this.jdField_c_of_type_JavaLangString);
        paramNetResp.append("server resp data read len -1");
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        if (QLog.isDevelopLevel()) {
          throw new IllegalArgumentException();
        }
      }
      if (l1 == 0L)
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("logID[");
        paramNetResp.append(this.jdField_c_of_type_JavaLangString);
        paramNetResp.append("server resp data read len 0");
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        return;
      }
      long l2 = this.jdField_a_of_type_Long;
      if (l1 == l2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a();
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.jdField_c_of_type_JavaLangString);
          paramNetResp.append("miaochuan");
          QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        }
      }
      else
      {
        if (l1 < this.jdField_b_of_type_Long)
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("RangSizeError_rangError tSize[");
          paramNetResp.append(String.valueOf(l1));
          paramNetResp.append("]<=mSize[");
          paramNetResp.append(String.valueOf(this.jdField_b_of_type_Long));
          paramNetResp.append("],reTryafter[");
          paramNetResp.append(String.valueOf(this.jdField_b_of_type_Int));
          paramNetResp.append("]");
          paramNetResp = paramNetResp.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("nSessionId[");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject).append("]");
          ((StringBuilder)localObject).append(paramNetResp);
          QLog.w("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject).toString());
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 3)
          {
            paramNetResp = new StringBuilder();
            paramNetResp.append("logID[");
            paramNetResp.append(this.jdField_c_of_type_JavaLangString);
            paramNetResp.append("server rang error retry,mmaxRangErrorRetryCount [");
            paramNetResp.append(this.jdField_b_of_type_Int);
            paramNetResp.append("], maxRangErrorRetry[");
            paramNetResp.append(3);
            paramNetResp.append("]");
            QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
            a(l1);
            return;
          }
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.jdField_c_of_type_JavaLangString);
          paramNetResp.append("]server rang error not retry,mmaxRangErrorRetryCount [");
          paramNetResp.append(this.jdField_b_of_type_Int);
          paramNetResp.append("], maxRangErrorRetry[");
          paramNetResp.append(3);
          paramNetResp.append("]");
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
          return;
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_b_of_type_Long = l1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.a(this.jdField_b_of_type_Long, l2);
        a(l1);
      }
      return;
    }
    if (paramNetResp.mResult == 9056)
    {
      int j = this.jdField_c_of_type_Int;
      if (j < 5)
      {
        this.jdField_c_of_type_Int = (j + 1);
        a(this.jdField_b_of_type_Long);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadIOfflineFileHttpUploderSink.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("logID[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]httpRetCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]onResp result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      ((StringBuilder)localObject).append(" errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject).append(" errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("nID[");
      paramNetReq.append(this.jdField_c_of_type_JavaLangString);
      paramNetReq.append("]onUpdateProgeress[");
      paramNetReq.append(paramLong1);
      paramNetReq.append("]/[");
      paramNetReq.append(paramLong2);
      paramNetReq.append("]");
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, paramNetReq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder
 * JD-Core Version:    0.7.0.1
 */