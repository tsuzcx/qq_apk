package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import java.util.Map;

public class QuicReq
{
  public int mBussinessId;
  public DownloadListener mDownloadListener;
  public long mExcuteTime;
  public int mFec;
  public Map<String, String> mHeaders;
  public String mIp;
  public boolean mIsIpv6;
  public boolean mIsQuicEncryption;
  public String mPath;
  public int mPort;
  public String mRttHost;
  public String mSavePath;
  public String mTempPath;
  public int mTimeOut = 10000;
  
  private QuicReq(QuicReq.Builder paramBuilder)
  {
    this.mPath = paramBuilder.mPath;
    this.mSavePath = paramBuilder.mSavePath;
    this.mTempPath = paramBuilder.mTempPath;
    this.mIsQuicEncryption = paramBuilder.mIsQuicEncryption;
    this.mHeaders = paramBuilder.mHeaders;
    this.mDownloadListener = paramBuilder.mDownloadListener;
    this.mBussinessId = paramBuilder.mBussinessId;
    this.mFec = paramBuilder.mFec;
    this.mTimeOut = paramBuilder.mTimeOut;
    this.mIp = paramBuilder.mIp;
    this.mPort = paramBuilder.mPort;
    this.mIsIpv6 = paramBuilder.mIsIpv6;
    this.mRttHost = paramBuilder.mRttHost;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicReq
 * JD-Core Version:    0.7.0.1
 */