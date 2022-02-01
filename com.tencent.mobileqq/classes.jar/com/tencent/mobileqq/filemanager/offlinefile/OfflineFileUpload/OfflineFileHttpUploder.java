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
  IHttpEngineService a;
  IOfflineFileHttpUploderSink b;
  String c;
  String d;
  SSCM e;
  long f;
  InputStream g;
  long h;
  String i;
  boolean j;
  int k;
  int l;
  int m;
  HttpNetReq n;
  long o;
  private HttpUrlProcessor p;
  
  public void a()
  {
    this.j = true;
    this.a.cancelReq(this.n);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]stop");
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).mCallback = this;
    ((HttpNetReq)localObject1).mReqUrl = this.c;
    ((HttpNetReq)localObject1).mHttpMethod = 1;
    ((HttpNetReq)localObject1).mReqProperties.put("Accept-Encoding", "identity");
    ((HttpNetReq)localObject1).mMsgId = this.i;
    try
    {
      localObject2 = b(paramLong);
      if (localObject2 == null)
      {
        this.b.b();
        return;
      }
      localObject2 = this.b.a((byte[])localObject2, paramLong);
      if (localObject2 == null)
      {
        this.b.b();
        return;
      }
      ((HttpNetReq)localObject1).mSendData = ((byte[])localObject2);
      this.n = ((HttpNetReq)localObject1);
      ((HttpNetReq)localObject1).mTimeoutParam = FileManagerUtil.h();
      this.a.sendReq((NetReq)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("logID[");
        ((StringBuilder)localObject1).append(this.i);
        ((StringBuilder)localObject1).append("]Send Http Request!");
        QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logID[");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append("] Exception:");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      this.b.b();
    }
  }
  
  byte[] b(long paramLong)
  {
    if (paramLong == 0L) {
      this.h = 0L;
    }
    if (this.g == null) {
      try
      {
        this.g = new FileInputStream(this.d);
        this.o = 0L;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        this.g = null;
        localFileNotFoundException1.printStackTrace();
        return null;
      }
    }
    if (paramLong == 0L)
    {
      if (this.o != 0L) {
        try
        {
          this.g = new FileInputStream(this.d);
          this.o = 0L;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          this.g = null;
          localFileNotFoundException2.printStackTrace();
          return null;
        }
      }
    }
    else
    {
      long l1 = this.o;
      if (paramLong > l1) {
        try
        {
          this.g.skip(paramLong - l1);
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return null;
        }
      } else if (paramLong < l1) {
        try
        {
          this.g = new FileInputStream(this.d);
          this.o = 0L;
          this.g.skip(paramLong);
        }
        catch (IOException localIOException2)
        {
          this.g = null;
          localIOException2.printStackTrace();
          return null;
        }
      }
    }
    this.o = paramLong;
    int i1 = OfflineFileHttpUtils.a(this.e, this.f, this.h, paramLong);
    byte[] arrayOfByte = new byte[i1];
    try
    {
      this.g.read(arrayOfByte, 0, i1);
      this.o += i1;
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
    if (this.j) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("logID[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("]onResp result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      ((StringBuilder)localObject).append(" errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject).append(" errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 4, ((StringBuilder)localObject).toString());
    }
    this.n = null;
    int i1 = paramNetResp.mHttpCode;
    if ((paramNetResp.mErrCode == 9364) && (this.k < 3))
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("logID[");
      paramNetResp.append(this.i);
      paramNetResp.append("]onNetChanged:mNetworkChangRetryCount[");
      paramNetResp.append(this.k);
      paramNetResp.append("] retry!");
      QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
      this.k += 1;
      this.e.a();
      paramNetResp = this.b;
      if (paramNetResp != null) {
        paramNetResp.a(true);
      }
      a(this.h);
      return;
    }
    if (FileHttpUtils.a(paramNetResp.mErrCode))
    {
      localObject = this.p;
      if (localObject != null)
      {
        localObject = ((HttpUrlProcessor)localObject).b();
        if (localObject != null)
        {
          this.c = ((String)localObject);
          a(this.h);
          return;
        }
      }
    }
    if ((i1 == 200) && (paramNetResp.mResult == 0))
    {
      this.m = 0;
      this.e.b();
      localObject = (String)paramNetResp.mRespProperties.get("User-ReturnCode");
      if (localObject != null) {
        l1 = Long.parseLong((String)localObject);
      } else {
        l1 = 0L;
      }
      if (l1 != 0L)
      {
        this.b.b();
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.i);
          paramNetResp.append("ResponCode[206]But UserCode[");
          paramNetResp.append(l1);
          paramNetResp.append("]");
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        }
        return;
      }
      long l1 = this.b.a(paramNetResp);
      if (l1 == -1L)
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("logID[");
        paramNetResp.append(this.i);
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
        paramNetResp.append(this.i);
        paramNetResp.append("server resp data read len 0");
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        return;
      }
      long l2 = this.f;
      if (l1 == l2)
      {
        this.b.a();
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.i);
          paramNetResp.append("miaochuan");
          QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
        }
      }
      else
      {
        if (l1 < this.h)
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("RangSizeError_rangError tSize[");
          paramNetResp.append(String.valueOf(l1));
          paramNetResp.append("]<=mSize[");
          paramNetResp.append(String.valueOf(this.h));
          paramNetResp.append("],reTryafter[");
          paramNetResp.append(String.valueOf(this.l));
          paramNetResp.append("]");
          paramNetResp = paramNetResp.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("nSessionId[");
          ((StringBuilder)localObject).append(this.i);
          ((StringBuilder)localObject).append("]");
          ((StringBuilder)localObject).append(paramNetResp);
          QLog.w("OfflineFileHttpUploder<FileAssistant>", 1, ((StringBuilder)localObject).toString());
          this.l += 1;
          if (this.l < 3)
          {
            paramNetResp = new StringBuilder();
            paramNetResp.append("logID[");
            paramNetResp.append(this.i);
            paramNetResp.append("server rang error retry,mmaxRangErrorRetryCount [");
            paramNetResp.append(this.l);
            paramNetResp.append("], maxRangErrorRetry[");
            paramNetResp.append(3);
            paramNetResp.append("]");
            QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
            a(l1);
            return;
          }
          paramNetResp = new StringBuilder();
          paramNetResp.append("logID[");
          paramNetResp.append(this.i);
          paramNetResp.append("]server rang error not retry,mmaxRangErrorRetryCount [");
          paramNetResp.append(this.l);
          paramNetResp.append("], maxRangErrorRetry[");
          paramNetResp.append(3);
          paramNetResp.append("]");
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, paramNetResp.toString());
          this.b.b();
          return;
        }
        this.l = 0;
        this.h = l1;
        this.b.a(this.h, l2);
        a(l1);
      }
      return;
    }
    if (paramNetResp.mResult == 9056)
    {
      int i2 = this.m;
      if (i2 < 5)
      {
        this.m = (i2 + 1);
        a(this.h);
        return;
      }
    }
    this.b.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("logID[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("]httpRetCode:");
      ((StringBuilder)localObject).append(i1);
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
      paramNetReq.append(this.i);
      paramNetReq.append("]onUpdateProgeress[");
      paramNetReq.append(paramLong1);
      paramNetReq.append("]/[");
      paramNetReq.append(paramLong2);
      paramNetReq.append("]");
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, paramNetReq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder
 * JD-Core Version:    0.7.0.1
 */