package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuicReq$Builder
{
  int mBussinessId;
  DownloadListener mDownloadListener;
  int mFec;
  Map<String, String> mHeaders;
  String mIp;
  boolean mIsIpv6;
  boolean mIsQuicEncryption;
  String mPath;
  int mPort;
  String mRttHost;
  String mSavePath;
  String mTempPath;
  int mTimeOut = 10000;
  
  public QuicReq$Builder(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mIp = paramString1;
    this.mPort = paramInt;
    this.mPath = paramString2;
    this.mSavePath = paramString3;
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      QLog.e("quic", 4, "key/value is null. key: " + paramString1 + " value: " + paramString2);
    }
    do
    {
      return this;
      if (this.mHeaders == null) {
        this.mHeaders = new LinkedHashMap();
      }
      this.mHeaders.put(paramString1, paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("quic", 4, "key: " + paramString1 + " value: " + paramString2);
    return this;
  }
  
  public QuicReq build()
  {
    return new QuicReq(this, null);
  }
  
  public Builder businessId(int paramInt)
  {
    this.mBussinessId = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "bussinessId: " + paramInt);
    }
    return this;
  }
  
  public Builder fec(int paramInt)
  {
    this.mFec = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "fec: " + paramInt);
    }
    return this;
  }
  
  public Builder isIpv6(boolean paramBoolean)
  {
    this.mIsIpv6 = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "isIpv6: " + paramBoolean);
    }
    return this;
  }
  
  public Builder isQuicEncryption(boolean paramBoolean)
  {
    this.mIsQuicEncryption = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "isQuicEncryption: " + paramBoolean);
    }
    return this;
  }
  
  public Builder listener(DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
    return this;
  }
  
  public Builder path(String paramString)
  {
    this.mPath = paramString;
    return this;
  }
  
  public Builder rttHost(String paramString)
  {
    this.mRttHost = paramString;
    return this;
  }
  
  public Builder savePath(String paramString)
  {
    this.mSavePath = paramString;
    return this;
  }
  
  public Builder tempPath(String paramString)
  {
    this.mTempPath = paramString;
    return this;
  }
  
  public Builder timeOut(int paramInt)
  {
    if (this.mTimeOut <= 0) {}
    do
    {
      return this;
      this.mTimeOut = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("quic", 4, "mTimeOut: " + paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicReq.Builder
 * JD-Core Version:    0.7.0.1
 */