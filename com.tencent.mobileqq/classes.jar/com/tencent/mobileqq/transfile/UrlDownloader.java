package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo mPicDownExtra;
  
  public UrlDownloader() {}
  
  public UrlDownloader(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mRecvLen = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj).mStartDownOffset;
  }
  
  void onError()
  {
    super.onError();
    this.mController.removeProcessor(BaseTransFileController.makeReceiveKey(this.mUiRequest));
    TransferResult localTransferResult = this.mUiRequest.mResult;
    if (localTransferResult != null)
    {
      localTransferResult.mResult = -1;
      localTransferResult.mErrCode = this.mProcessorReport.errCode;
      localTransferResult.mErrDesc = this.mProcessorReport.errDesc;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" result:");
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    logRichMediaEvent("onHttpResp", localStringBuilder.toString());
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    if (paramNetResp.mResult == 0)
    {
      onSuccess();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    TransferResult localTransferResult = this.mUiRequest.mResult;
    this.mController.removeProcessor(BaseTransFileController.makeReceiveKey(this.mUiRequest));
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
      localObject = localHttpNetReq.mReqProperties;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bytes=");
      localStringBuilder.append(localHttpNetReq.mStartDownOffset);
      localStringBuilder.append("-");
      ((HashMap)localObject).put("Range", localStringBuilder.toString());
      localHttpNetReq.mSupportBreakResume = true;
    }
    localHttpNetReq.mContinuErrorLimit = 4;
    localHttpNetReq.mExcuteTimeLimit = 90000L;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(",downOffset:");
    ((StringBuilder)localObject).append(localHttpNetReq.mStartDownOffset);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject).toString());
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  public void start()
  {
    receiveFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.UrlDownloader
 * JD-Core Version:    0.7.0.1
 */