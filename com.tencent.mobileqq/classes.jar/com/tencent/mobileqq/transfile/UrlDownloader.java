package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo mPicDownExtra;
  
  public UrlDownloader(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.mRecvLen = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj).mStartDownOffset;
  }
  
  void onError()
  {
    super.onError();
    this.mController.removeProcessor(TransFileController.makeReceiveKey(this.mUiRequest));
    TransferResult localTransferResult = this.mUiRequest.mResult;
    if (localTransferResult != null)
    {
      localTransferResult.mResult = -1;
      localTransferResult.mErrCode = this.errCode;
      localTransferResult.mErrDesc = this.errDesc;
      localTransferResult.mOrigReq = this.mUiRequest;
    }
    try
    {
      logRichMediaEvent("notify", "start");
      notifyAll();
      logRichMediaEvent("notify", "end");
      return;
    }
    finally {}
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramNetResp.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      logRichMediaEvent("onHttpResp", bool);
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      if (paramNetResp.mResult != 0) {
        break;
      }
      onSuccess();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    TransferResult localTransferResult = this.mUiRequest.mResult;
    this.mController.removeProcessor(TransFileController.makeReceiveKey(this.mUiRequest));
    if (localTransferResult != null)
    {
      localTransferResult.mResult = 0;
      localTransferResult.mOrigReq = this.mUiRequest;
    }
    try
    {
      logRichMediaEvent("notify", "start");
      notifyAll();
      logRichMediaEvent("notify", "end");
      return;
    }
    finally {}
  }
  
  void receiveFile()
  {
    String str = this.mUiRequest.mServerPath;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutStream = this.mUiRequest.mOut;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = this.mRecvLen;
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localHttpNetReq.mPrioty = this.mUiRequest.mPrioty;
    if (this.mUiRequest.mSupportRangeBreakDown)
    {
      localHttpNetReq.mReqProperties.put("Range", "bytes=" + localHttpNetReq.mStartDownOffset + "-");
      localHttpNetReq.mBreakDownFix = mPicBreakDownFixForOldHttpEngine;
    }
    localHttpNetReq.mContinuErrorLimit = 4;
    localHttpNetReq.mExcuteTimeLimit = 90000L;
    logRichMediaEvent("httpDown", " url:" + str + ",downOffset:" + localHttpNetReq.mStartDownOffset);
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  public void start()
  {
    receiveFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.UrlDownloader
 * JD-Core Version:    0.7.0.1
 */