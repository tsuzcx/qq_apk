package com.tencent.mobileqq.transfile;

public class HttpNetReq
  extends NetReq
{
  public static final int HTTP_GET = 0;
  public static final int HTTP_POST = 1;
  public HttpNetReq.IFlowDecoder decoder;
  public boolean mHaveIpConnect;
  public String mHostForHttpsVerify;
  public int mHttpMethod = 0;
  public boolean mIsHostIP;
  public boolean mIsHttps;
  public boolean mIsPreStructPic;
  public boolean mIsSync;
  public boolean mNeedIpConnect;
  public boolean mNeedNotReferer;
  public boolean mNeedRedirectCallback;
  public String mReqUrl;
  public RichMediaStrategy.OldEngineDPCProfile.TimeoutParam mTimeoutParam;
  public boolean mUseCmwapConnectionTypeFromDpc;
  public String[] mWhiteListContentType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpNetReq
 * JD-Core Version:    0.7.0.1
 */