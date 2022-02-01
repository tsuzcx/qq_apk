package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import azla;
import azlb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
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
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = buildRichProtoReq();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while ((!canDoNextStep()) || (localRichProtoReq == null));
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
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
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    return localRichProtoReq;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.mFileSize + " errorCode:" + this.errCode);
    }
    if (paramBoolean) {
      this.mReportInfo.put("param_succ_flag", "1");
    }
    for (;;)
    {
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_time_cost", String.valueOf(l));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWXUpload", paramBoolean, l, this.mFileSize, this.mReportInfo, null);
      return;
      this.mReportInfo.put("param_succ_flag", "0");
    }
  }
  
  public final void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("onBusiProtoResp", paramRichProtoReq.toString());
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.result);
        }
        if (paramRichProtoReq.result == 0)
        {
          this.mUkey = paramRichProtoReq.mUkey;
          this.file.orgiDownUrl = paramRichProtoReq.mOriginalDownPara;
          if (paramRichProtoReq.isExist)
          {
            this.file.closeInputStream();
            onSuccess();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.mUiRequest.mLocalPath);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.mStartOffset = paramRichProtoReq.startOffset;
          sendFileBDH();
          continue;
          onError();
        }
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      azlb localazlb = new azlb();
      localazlb.jdField_a_of_type_Int = 0;
      localazlb.jdField_a_of_type_Long = this.mFileSize;
      localazlb.d = this.mMd5Str;
      localazlb.e = this.file.orgiDownUrl;
      this.mUiRequest.mUpCallBack.onSend(localazlb);
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      return;
      updateMessageDataBaseContent(true);
    }
  }
  
  public final void sendFileBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "sendFileBDH");
    }
    this.mStepTrans.logStartTime();
    Object localObject = new ShareToWXUploadProcessor.1(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = HexUtil.hexStr2Bytes(this.mUkey);
    localObject = new Transaction(this.app.getCurrentAccountUin(), 73, this.mUiRequest.mLocalPath, (int)this.mStartOffset, arrayOfByte, this.mLocalMd5, (ITransactionCallback)localObject);
    int i = this.app.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mStepTrans);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShareToWXUploadProcessor
 * JD-Core Version:    0.7.0.1
 */