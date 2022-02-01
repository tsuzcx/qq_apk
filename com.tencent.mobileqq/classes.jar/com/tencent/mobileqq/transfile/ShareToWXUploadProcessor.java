package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class ShareToWXUploadProcessor
  extends BaseUploadProcessor
{
  public static final int COMMAND_ID_SHARE_TO_WX = 73;
  private static final String TAG = "ShareToWXUploadProcessor";
  
  public ShareToWXUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private final void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = buildRichProtoReq();
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    if (localRichProtoReq != null)
    {
      this.mRichProtoReq = localRichProtoReq;
      RichProtoProc.procRichProtoReq(localRichProtoReq);
    }
  }
  
  protected RichProto.RichProtoReq buildRichProtoReq()
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.selfUin = this.app.getCurrentAccountUin();
    localPicUpReq.isSnapChat = this.mUiRequest.mIsSecSnapChatPic;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "share_pic_to_wx";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = getProtoReqManager();
    return localRichProtoReq;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.mProcessorReport.mStartTime;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doReport, timeCost:");
      localStringBuilder.append(l);
      localStringBuilder.append(" mFileSize:");
      localStringBuilder.append(this.mFileSize);
      localStringBuilder.append(" errorCode:");
      localStringBuilder.append(this.mProcessorReport.errCode);
      QLog.d("ShareToWXUploadProcessor", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.mProcessorReport.mReportInfo.put("param_succ_flag", "1");
    } else {
      this.mProcessorReport.mReportInfo.put("param_succ_flag", "0");
    }
    this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
    this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
    this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
    this.mProcessorReport.mReportInfo.put("param_time_cost", String.valueOf(l));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWXUpload", paramBoolean, l, this.mFileSize, this.mProcessorReport.mReportInfo, null);
  }
  
  public final void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("onBusiProtoResp", paramRichProtoReq.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onBusiProtoResp()------response.result = ");
          localStringBuilder.append(paramRichProtoReq.result);
          QLog.d("ShareToWXUploadProcessor", 2, localStringBuilder.toString());
        }
        if (paramRichProtoReq.result == 0)
        {
          this.mUkey = paramRichProtoReq.mUkey;
          this.file.orgiDownUrl = paramRichProtoReq.mOriginalDownPara;
          if (paramRichProtoReq.isExist)
          {
            this.file.closeInputStream();
            onSuccess();
            if (QLog.isColorLevel())
            {
              paramRichProtoReq = new StringBuilder();
              paramRichProtoReq.append("onBusiProtoResp()---- file is Exsit! ");
              paramRichProtoReq.append(this.mUiRequest.mLocalPath);
              QLog.d("ShareToWXUploadProcessor", 2, paramRichProtoReq.toString());
            }
          }
          else
          {
            this.mStartOffset = paramRichProtoReq.startOffset;
            sendFileBDH();
          }
        }
        else
        {
          onError();
        }
        i += 1;
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.mFileSize;
      localSendResult.d = this.mMd5Str;
      localSendResult.e = this.file.orgiDownUrl;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
    if (this.mRichProtoReq != null)
    {
      RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
      this.mRichProtoReq = null;
    }
  }
  
  public final void sendFileBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "sendFileBDH");
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject1 = new ShareToWXUploadProcessor.1(this, SystemClock.uptimeMillis());
    Object localObject2 = HexUtil.hexStr2Bytes(this.mUkey);
    localObject1 = new Transaction(this.app.getCurrentAccountUin(), 73, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject2, this.mLocalMd5, (ITransactionCallback)localObject1);
    int i = this.app.getHwEngine().submitTransactionTask((Transaction)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<BDH_LOG> Transaction submit RetCode:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" T_ID:");
      ((StringBuilder)localObject2).append(((Transaction)localObject1).getTransationId());
      ((StringBuilder)localObject2).append(" UniSeq:");
      ((StringBuilder)localObject2).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject2).append(" MD5:");
      ((StringBuilder)localObject2).append(this.mMd5Str);
      ((StringBuilder)localObject2).append(" Path:");
      ((StringBuilder)localObject2).append(((Transaction)localObject1).filePath);
      ((StringBuilder)localObject2).append(" Cmd:");
      ((StringBuilder)localObject2).append(73);
      QLog.d("ShareToWXUploadProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  public final void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    String str = this.mUiRequest.mLocalPath;
    long l = new File(str).length();
    this.file.fileSize = l;
    this.mFileSize = l;
    str = FileUtils.estimateFileType(str);
    if (!TextUtils.isEmpty(str)) {
      this.mExtName = str;
    }
    sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShareToWXUploadProcessor
 * JD-Core Version:    0.7.0.1
 */