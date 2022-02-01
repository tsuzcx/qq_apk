package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
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
  
  public ScribblePicDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private void spliteCombineFile()
  {
    if (this.mMsg == null) {
      return;
    }
    Object localObject1 = ScribbleUtils.b(this.mUiRequest.mOutFilePath);
    if (((String)localObject1).equalsIgnoreCase(this.mMsg.combineFileMd5))
    {
      localObject1 = this.mMsg;
      if (localObject1 != null) {
        ((MessageForScribble)localObject1).mExistInfo.mCombineFileExist = true;
      }
      int i = ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).splitPureDataFromCombineFile(this.mMsg);
      if (i == ScribbleMsgConstants.d)
      {
        localObject1 = this.mMsg;
        if (localObject1 != null)
        {
          ((MessageForScribble)localObject1).mExistInfo.mDataFileExist = true;
          this.mMsg.mExistInfo.mInit = true;
        }
        onSuccess();
        return;
      }
      localObject1 = this.mMsg;
      if (localObject1 != null)
      {
        ((MessageForScribble)localObject1).mExistInfo.mDataFileExist = false;
        this.mMsg.mExistInfo.mInit = true;
      }
      localObject1 = this.mProcessorReport;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SpliteCombineFile illegal result: ");
      ((StringBuilder)localObject2).append(i);
      ((ProcessorReport)localObject1).setError(9303, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
      onError();
      return;
    }
    Object localObject2 = this.mMsg;
    if (localObject2 != null)
    {
      ((MessageForScribble)localObject2).mExistInfo.mDataFileExist = false;
      this.mMsg.mExistInfo.mCombineFileExist = false;
      this.mMsg.mExistInfo.mInit = true;
    }
    localObject2 = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpliteCombineFile illegal md5String: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("  msg.combineFileMd5:  ");
    localStringBuilder.append(this.mMsg.combineFileMd5);
    ((ProcessorReport)localObject2).setError(9041, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
  }
  
  private void updateMsg(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
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
    Object localObject = this.mMsg;
    if ((localObject != null) && (!((MessageForScribble)localObject).combineFileUrl.equals("")) && (this.mMsg.combineFileUrl.startsWith("http")))
    {
      this.mUiRequest.mOutFilePath = ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleCombineFile(this.mMsg);
      if (TextUtils.isEmpty(this.mUiRequest.mOutFilePath))
      {
        localObject = this.mProcessorReport;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("combineFileMd5 illegal ");
        localStringBuilder.append(this.mMsg.combineFileMd5);
        ((ProcessorReport)localObject).setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
        onError();
        return -1;
      }
      return 0;
    }
    localObject = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("combineFileUrl illegal ");
    localStringBuilder.append(this.url);
    ((ProcessorReport)localObject).setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
    return -1;
  }
  
  void onError()
  {
    super.onError();
    Object localObject = this.mMsg;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileDownloadStatus = 2;
    }
    updateMsg(this.mMsg);
    sendMessageToUpdate(2005);
    localObject = (IScribbleDownloader)this.app.getRuntimeService(IScribbleDownloader.class, "");
    if (localObject != null)
    {
      MessageForScribble localMessageForScribble = this.mMsg;
      if (localMessageForScribble != null) {
        ((IScribbleDownloader)localObject).removeDownloadedMsg(localMessageForScribble);
      } else {
        ((IScribbleDownloader)localObject).removeDownloadedMsg(null);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    this.mNetReq = null;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" result:");
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    localObject = this.mProcessorReport;
    StepInfo localStepInfo = this.mProcessorReport.mStepTrans;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ProcessorReport)localObject).copyStaticsInfoFromNetResp(localStepInfo, paramNetResp, bool);
    this.mTotolLen = paramNetResp.mTotalFileLen;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scribble download onResp resp.mResult = ");
    ((StringBuilder)localObject).append(paramNetResp.mResult);
    QLog.i("ScribblePicDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = this.mMsg;
      if (paramNetResp != null) {
        paramNetResp.mExistInfo.mCombineFileExist = true;
      }
      spliteCombineFile();
      return;
    }
    localObject = this.mMsg;
    if (localObject != null)
    {
      ((MessageForScribble)localObject).mExistInfo.mCombineFileExist = false;
      this.mMsg.mExistInfo.mDataFileExist = false;
      this.mMsg.mExistInfo.mInit = true;
    }
    int i = this.mTotalRetryTime;
    if (i < 5)
    {
      this.mTotalRetryTime = (i + 1);
      localObject = this.ipListFromInnerDns;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (this.mIpIndex < this.ipListFromInnerDns.size()))
      {
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry by changeIp");
        clearReprotInfo();
        paramNetResp = BaseInnerDns.getHostFromUrl(this.url);
        BaseInnerDns.getInstance().reportBadIp(paramNetResp, (String)this.ipListFromInnerDns.get(this.mIpIndex), 1018);
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
    Object localObject = this.mMsg;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileDownloadStatus = 1;
    }
    updateMsg(this.mMsg);
    sendMessageToUpdate(2003);
    localObject = (IScribbleDownloader)this.app.getRuntimeService(IScribbleDownloader.class, "");
    if (localObject != null)
    {
      MessageForScribble localMessageForScribble = this.mMsg;
      if (localMessageForScribble != null) {
        ((IScribbleDownloader)localObject).removeDownloadedMsg(localMessageForScribble);
      } else {
        ((IScribbleDownloader)localObject).removeDownloadedMsg(null);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
  }
  
  void recieveFile()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.mProcessorReport.mStepTrans.logStartTime();
    String str = this.url;
    sendMessageToUpdate(2001);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str;
    int j = 0;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mCanPrintUrl = true;
    Object localObject = this.ipListFromInnerDns;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((ArrayList)localObject).isEmpty())
      {
        i = j;
        if (this.mIpIndex < this.ipListFromInnerDns.size())
        {
          localObject = (String)this.ipListFromInnerDns.get(this.mIpIndex);
          localObject = BaseInnerDns.replaceDomainWithIp(localHttpNetReq.mReqUrl, (String)localObject);
          i = j;
          if (localObject != null)
          {
            i = j;
            if (!((String)localObject).equals(localHttpNetReq.mReqUrl))
            {
              localHttpNetReq.mReqUrl = ((String)localObject);
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.app, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
    }
    localObject = TransFileUtil.getIpOrDomainFromURL(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpDownRespDomain: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("reqUrl : ");
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(localHttpNetReq.mReqUrl);
      localStringBuilder.append(" uuid:");
      localStringBuilder.append(this.mUiRequest.mServerPath);
      localStringBuilder.append(" downOffset:");
      localStringBuilder.append(localHttpNetReq.mStartDownOffset);
      QLog.i("ScribblePicDownloadProcessor", 2, localStringBuilder.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index:");
    ((StringBuilder)localObject).append(this.mIpIndex);
    ((StringBuilder)localObject).append(str);
    QLog.i("ScribblePicDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
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
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      this.mController.mHandler.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public void start()
  {
    super.start();
    Object localObject = this.mMsg;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileDownloadStatus = 3;
    }
    localObject = this.url;
    if ((localObject != null) && (!((String)localObject).startsWith("https")))
    {
      localObject = BaseInnerDns.getHostFromUrl(this.url);
      this.ipListFromInnerDns = BaseInnerDns.getInstance().reqDnsForIpList((String)localObject, 1018);
    }
    localObject = this.ipListFromInnerDns;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      int i = 0;
      localObject = "ipListFromInnerDns : ";
      while (i < this.ipListFromInnerDns.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" ");
        localStringBuilder.append((String)this.ipListFromInnerDns.get(i));
        localObject = localStringBuilder.toString();
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScribblePicDownloadProcessor", 2, (String)localObject);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
    recieveFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */