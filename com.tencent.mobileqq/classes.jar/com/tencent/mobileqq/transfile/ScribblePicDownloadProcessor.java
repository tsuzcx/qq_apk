package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleDownloader;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ScribblePicDownloadProcessor
  extends BaseDownloadProcessor
{
  public static final String TAG = "ScribblePicDownloadProcessor";
  private ArrayList<String> ipListFromInnerDns;
  private int mIpIndex = 0;
  MessageForScribble mMsg;
  private int mTotalRetryTime = 0;
  String url = "";
  
  public ScribblePicDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
  }
  
  private void spliteCombineFile()
  {
    if (this.mMsg == null) {
      return;
    }
    String str = ScribbleUtils.a(this.mUiRequest.mOutFilePath);
    if (str.equalsIgnoreCase(this.mMsg.combineFileMd5))
    {
      if (this.mMsg != null) {
        this.mMsg.mExistInfo.mCombineFileExist = true;
      }
      int i = ScribbleMsgUtils.b(this.mMsg);
      if (i == ScribbleMsgUtils.d)
      {
        if (this.mMsg != null)
        {
          this.mMsg.mExistInfo.mDataFileExist = true;
          this.mMsg.mExistInfo.mInit = true;
        }
        onSuccess();
        return;
      }
      if (this.mMsg != null)
      {
        this.mMsg.mExistInfo.mDataFileExist = false;
        this.mMsg.mExistInfo.mInit = true;
      }
      setError(9303, getExpStackString(new Exception("SpliteCombineFile illegal result: " + i)));
      onError();
      return;
    }
    if (this.mMsg != null)
    {
      this.mMsg.mExistInfo.mDataFileExist = false;
      this.mMsg.mExistInfo.mCombineFileExist = false;
      this.mMsg.mExistInfo.mInit = true;
    }
    setError(9041, getExpStackString(new Exception("SpliteCombineFile illegal md5String: " + str + "  msg.combineFileMd5:  " + this.mMsg.combineFileMd5)));
    onError();
  }
  
  private void updateMsg(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.app.getMessageFacade().a(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForScribble)))
    {
      this.mMsg = ((MessageForScribble)this.mUiRequest.mRec);
      this.url = this.mMsg.combineFileUrl;
    }
    if ((this.mMsg == null) || (this.mMsg.combineFileUrl.equals("")) || (!this.mMsg.combineFileUrl.startsWith("http")))
    {
      setError(9302, getExpStackString(new Exception("combineFileUrl illegal " + this.url)));
      onError();
      return -1;
    }
    this.mUiRequest.mOutFilePath = ScribbleMsgUtils.a(this.mMsg);
    if (TextUtils.isEmpty(this.mUiRequest.mOutFilePath))
    {
      setError(9302, getExpStackString(new Exception("combineFileMd5 illegal " + this.mMsg.combineFileMd5)));
      onError();
      return -1;
    }
    return 0;
  }
  
  void onError()
  {
    super.onError();
    if (this.mMsg != null) {
      this.mMsg.fileDownloadStatus = 2;
    }
    updateMsg(this.mMsg);
    sendMessageToUpdate(2005);
    ScribbleDownloader localScribbleDownloader = this.app.getScribbleDownloader();
    if (localScribbleDownloader != null)
    {
      if (this.mMsg == null) {
        break label90;
      }
      localScribbleDownloader.a(this.mMsg);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label90:
      localScribbleDownloader.a(null);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    this.mNetReq = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramNetResp.mResult == 0)
    {
      bool = true;
      logRichMediaEvent("onHttpResp", bool);
      localObject = this.mStepTrans;
      if (paramNetResp.mResult != 0) {
        break label177;
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + paramNetResp.mResult);
      if (paramNetResp.mResult != 0) {
        break label182;
      }
      if (this.mMsg != null) {
        this.mMsg.mExistInfo.mCombineFileExist = true;
      }
      spliteCombineFile();
      return;
      bool = false;
      break;
    }
    label182:
    if (this.mMsg != null)
    {
      this.mMsg.mExistInfo.mCombineFileExist = false;
      this.mMsg.mExistInfo.mDataFileExist = false;
      this.mMsg.mExistInfo.mInit = true;
    }
    if (this.mTotalRetryTime < 5)
    {
      this.mTotalRetryTime += 1;
      if ((this.ipListFromInnerDns != null) && (!this.ipListFromInnerDns.isEmpty()) && (this.mIpIndex < this.ipListFromInnerDns.size()))
      {
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry by changeIp");
        clearReprotInfo();
        paramNetResp = InnerDns.getHostFromUrl(this.url);
        InnerDns.getInstance().reportBadIp(paramNetResp, (String)this.ipListFromInnerDns.get(this.mIpIndex), 1018);
        this.mIpIndex += 1;
        recieveFile();
        return;
      }
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry");
        this.mNetworkChgRetryCount += 1;
        clearReprotInfo();
        recieveFile();
        return;
      }
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mMsg != null) {
      this.mMsg.fileDownloadStatus = 1;
    }
    updateMsg(this.mMsg);
    sendMessageToUpdate(2003);
    ScribbleDownloader localScribbleDownloader = this.app.getScribbleDownloader();
    if (localScribbleDownloader != null)
    {
      if (this.mMsg == null) {
        break label92;
      }
      localScribbleDownloader.a(this.mMsg);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label92:
      localScribbleDownloader.a(null);
    }
  }
  
  void recieveFile()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.mStepTrans.logStartTime();
    String str1 = this.url;
    sendMessageToUpdate(2001);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mCanPrintUrl = true;
    String str2;
    if ((this.ipListFromInnerDns != null) && (!this.ipListFromInnerDns.isEmpty()) && (this.mIpIndex < this.ipListFromInnerDns.size()))
    {
      str2 = (String)this.ipListFromInnerDns.get(this.mIpIndex);
      str2 = InnerDns.replaceDomainWithIp(localHttpNetReq.mReqUrl, str2);
      if ((str2 != null) && (!str2.equals(localHttpNetReq.mReqUrl))) {
        localHttpNetReq.mReqUrl = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = TransFileUtil.getIpOrDomainFromURL(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localHttpNetReq.mReqUrl + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + localHttpNetReq.mStartDownOffset);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.mIpIndex + str1);
        if (canDoNextStep()) {
          break;
        }
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.mNetReq = localHttpNetReq;
      setMtype();
      this.mNetEngine.sendReq(localHttpNetReq);
      return;
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribblePicDownloadProcessor", 2, "resume()");
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      this.errCode = 0;
      this.errDesc = "";
      this.mController.mHandler.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public void start()
  {
    super.start();
    if (this.mMsg != null) {
      this.mMsg.fileDownloadStatus = 3;
    }
    String str;
    if ((this.url != null) && (!this.url.startsWith("https")))
    {
      str = InnerDns.getHostFromUrl(this.url);
      this.ipListFromInnerDns = InnerDns.getInstance().reqDnsForIpList(str, 1018);
    }
    if ((this.ipListFromInnerDns != null) && (!this.ipListFromInnerDns.isEmpty()))
    {
      str = "ipListFromInnerDns : ";
      int i = 0;
      while (i < this.ipListFromInnerDns.size())
      {
        str = str + " " + (String)this.ipListFromInnerDns.get(i);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScribblePicDownloadProcessor", 2, str);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
    recieveFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */