package com.tencent.mobileqq.transfile;

public class HttpNetReq
  extends NetReq
{
  public static final int HTTP_GET = 0;
  public static final int HTTP_POST = 1;
  public HttpNetReq.IFlowDecoder decoder;
  public boolean mHaveIpConnect = false;
  public String mHostForHttpsVerify;
  public int mHttpMethod = 0;
  public boolean mIsHostIP;
  public boolean mIsHttps;
  public boolean mIsPreStructPic;
  public boolean mIsSync;
  public boolean mNeedIpConnect = false;
  public boolean mNeedNotReferer = false;
  public boolean mNeedRedirectCallback = false;
  public String mReqUrl;
  public TimeoutParam mTimeoutParam;
  public boolean mUseCmwapConnectionTypeFromDpc = false;
  public String[] mWhiteListContentType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpNetReq
 * JD-Core Version:    0.7.0.1
 */