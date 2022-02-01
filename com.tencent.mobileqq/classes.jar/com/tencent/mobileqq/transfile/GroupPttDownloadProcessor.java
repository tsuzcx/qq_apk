package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends BasePttDownloaderProcessor
  implements NetFailedListener, Runnable
{
  public static final int DIRECT_DOWNLOAD_FAIL = 3;
  public static final int DIRECT_DOWNLOAD_NO_IP = 2;
  public static final int DIRECT_DOWNLOAD_NO_URL = 1;
  public static final int DIRECT_DOWNLOAD_OUTOFTIME = 4;
  String mDirectDownloadURL = null;
  TransferRequest.PttDownExtraInfo mExtraInfo;
  String mFullLocalPath;
  long mGroupFileID;
  String mGroupFileKeyStr;
  boolean mIsGroup = true;
  byte[] mMsgFileMd5;
  private long mMsgRecTime;
  private long mMsgTime;
  MessageForPtt mPtt;
  String mTempPath;
  private boolean useUrlIp = false;
  
  public GroupPttDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private boolean isFailedByOverDue()
  {
    return (this.mProcessorReport.errCode == -9527) && (this.mProcessorReport.errDesc != null) && ((this.mProcessorReport.errDesc.equals("T_203")) || (this.mProcessorReport.errDesc.equals("H_400_-5103017")) || (this.mProcessorReport.errDesc.equals("H_400_-5103039")));
  }
  
  private void reportDirectDownload(int paramInt)
  {
    String str = "DiscussPTTDirectUrl";
    for (;;)
    {
      try
      {
        if (this.mUiRequest.mUinType == 1) {
          str = "GroupPTTDirectUrl";
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(paramInt));
        StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (paramInt == 0)
        {
          bool = true;
          localStatisticCollector.collectPerformance(null, str, bool, 0L, 0L, localHashMap, null);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool = false;
    }
  }
  
  private void requestUrlWhileDirectFailed(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mDirectDownloadURL != null)
        {
          i = 0;
          boolean bool = isFailedByOverDue();
          if (!bool) {
            if (this.mProcessorReport.errCode != 9366) {
              break label147;
            }
          }
          if (i != 0) {
            ((IPttTempApi)QRoute.api(IPttTempApi.class)).doOnPttSrvAddressError(this.useUrlIp, this.mDirectDownloadURL);
          }
          this.mDirectDownloadURL = null;
          if (paramBoolean) {
            reportDirectDownload(4);
          } else {
            reportDirectDownload(3);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan error");
          }
          if (bool)
          {
            this.mPtt.fileSize = 2005L;
            updateMessageDataBaseContent(this.mPtt);
            onError();
          }
          else
          {
            sendGetUrlReq();
          }
        }
        return;
      }
      finally {}
      label147:
      int i = 1;
    }
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mServerPath;
    if ((localObject1 != null) && (!((String)localObject1).equals("")) && (!((String)localObject1).equals("null")) && (!FileUtils.isLocalPath((String)localObject1)) && (!((String)localObject1).startsWith("http://")))
    {
      this.mPtt = ((MessageForPtt)this.mUiRequest.mRec);
      this.mExtraInfo = ((TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj);
      this.mMsgTime = this.mPtt.msgTime;
      this.mMsgRecTime = this.mPtt.msgRecTime;
      int i = this.mPtt.voiceType;
      if ((this.mUiRequest.mOutFilePath == null) || (!FileUtils.isLocalPath(this.mUiRequest.mLocalPath)))
      {
        if ((this.mPtt.fullLocalPath != null) && (!this.mPtt.fullLocalPath.equals(""))) {
          this.mUiRequest.mOutFilePath = this.mPtt.fullLocalPath;
        } else {
          this.mUiRequest.mOutFilePath = getPttStorePath("group", (String)localObject1, i);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mUiRequest.mOutFilePath);
        ((StringBuilder)localObject1).append("~tmp");
        this.mTempPath = ((StringBuilder)localObject1).toString();
      }
      i = this.mUiRequest.mUinType;
      boolean bool = true;
      if (1 != i) {
        bool = false;
      }
      this.mIsGroup = bool;
      this.mMsgFileMd5 = getMd5InBytesOfGroup(this.mUiRequest.mMd5, this.mUiRequest.mServerPath);
      this.mGroupFileID = this.mUiRequest.mGroupFileID;
      this.mGroupFileKeyStr = this.mUiRequest.mGroupFileKeyStr;
      if (this.mMsgFileMd5 == null)
      {
        localObject1 = this.mProcessorReport;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("convert md5 error,md5:");
        ((StringBuilder)localObject2).append(this.mUiRequest.mMd5);
        ((StringBuilder)localObject2).append("  uuid:");
        ((StringBuilder)localObject2).append(this.mUiRequest.mServerPath);
        ((ProcessorReport)localObject1).setError(9302, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
        onError();
        return -1;
      }
      return 0;
    }
    Object localObject2 = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uuid illegal ");
    localStringBuilder.append((String)localObject1);
    ((ProcessorReport)localObject2).setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      int j = 1;
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject = this.mProcessorReport;
      int k = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject).mReportedFlag = (k | i);
      long l1 = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepDirectDown.getReportInfo(1));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepUrl.getReportInfo(2));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepTrans.getReportInfo(3));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepMsg.getReportInfo(4));
      localObject = ((StringBuilder)localObject).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject);
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mProcessorReport.mReportInfo.put("param_quickHttp", String.valueOf(this.mProcessorReport.mSendByQuickHttp));
      this.mProcessorReport.mReportInfo.put("param_pttOpt", String.valueOf(((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getOptString(this.app, this.useUrlIp)));
      HashMap localHashMap = this.mProcessorReport.mReportInfo;
      if (this.mIsHttpsDownload) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("param_isHttps", localObject);
      this.mProcessorReport.mReportInfo.put("param_trans_consume", String.valueOf(this.mProcessorReport.mStepTrans.getTimeConsume()));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GroupPttDownload success: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", cost: ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" directDownloadIfCan: ");
        boolean bool;
        if (this.mDirectDownloadURL != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("SPD", 4, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
        reportForIpv6(true, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l1, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        if ((this.mNetReq instanceof HttpNetReq))
        {
          localObject = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
          if (localObject != null) {
            this.mProcessorReport.mReportInfo.put("param_reqIp", ((ServerAddr)localObject).mIp);
          }
        }
        this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
        reportForIpv6(false, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l1, 0L, this.mProcessorReport.mReportInfo, "");
        if ((this.mProcessorReport.errCode == -9527) && (this.mProcessorReport.errDesc != null))
        {
          if (this.mProcessorReport.errDesc.equals("T_203")) {
            i = j;
          } else if (this.mProcessorReport.errDesc.equals("H_400_-5103017")) {
            i = 16;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.mMsgRecTime > this.mMsgTime)
            {
              if (this.mIsGroup) {
                localObject = "actGroupPTTOutOfTime";
              } else {
                localObject = "actDiscussionPTTOutOfTime";
              }
              localHashMap = new HashMap();
              long l2 = System.currentTimeMillis() / 1000L;
              long l3 = this.mMsgRecTime;
              long l4 = this.mMsgTime;
              l1 = (l3 - l4) / 86400L;
              l4 = (l2 - l4) / 86400L;
              l2 = (l2 - l3) / 86400L;
              localHashMap.put("MsgOff", String.valueOf(l1));
              localHashMap.put("PttOff", String.valueOf(l2));
              localHashMap.put("OutOfTimeReason", String.valueOf(i));
              localHashMap.put("param_FailCode", String.valueOf(l4));
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, false, 0L, 0L, localHashMap, null);
            }
            if (this.mUiRequest.mExtraObj != null)
            {
              localObject = (TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj;
              ReportController.b(this.app, "CliOper", "", "", "0X80059B3", "0X80059B3", PttInfoCollectorImpl.mergeDownloadPTTFromType(((TransferRequest.PttDownExtraInfo)localObject).mFromType, ((TransferRequest.PttDownExtraInfo)localObject).mLayer), 0, "", "", "", "8.8.17");
            }
          }
        }
      }
      setReportFlag();
      if (this.mPtt != null) {
        ((IPTTPreDownloader)this.app.getRuntimeService(IPTTPreDownloader.class, "all")).onDownloadFinish(paramBoolean, this.mProcessorReport.errCode, this.mExtraInfo, this.mPtt);
      }
    }
  }
  
  protected String getReportTAG()
  {
    if (this.mUiRequest.mUinType == 1) {
      return "actGrpPttDown";
    }
    return "actDisscusPttDown";
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=");
          ((StringBuilder)localObject).append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, ((StringBuilder)localObject).toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mDownDomain = paramRichProtoReq.domainV4V6;
          this.mUrlPath = paramRichProtoReq.urlPath;
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          if (this.mDownDomain != null)
          {
            localObject = new ServerAddr();
            ((ServerAddr)localObject).isDomain = true;
            ((ServerAddr)localObject).mIp = this.mDownDomain;
            this.mIpList.add(localObject);
          }
          recieveFile(paramRichProtoReq.mIsHttps);
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.mUiRequest.mDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.a = -1;
      this.mUiRequest.mDownCallBack.a(localDownResult);
      return;
    }
    sendMessageToUpdate(2005);
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    this.mRSMReporter.mFileSize = this.mRecvLen;
    reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    FileMsg.StepTransInfo localStepTransInfo;
    if (this.mDirectDownloadURL != null)
    {
      localObject = this.mProcessorReport.mStepDirectDown;
      localStepTransInfo = this.file.stepMsgDirecDown;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    else
    {
      localObject = this.mProcessorReport.mStepTrans;
      localStepTransInfo = this.file.stepTrans;
    }
    ProcessorReport localProcessorReport = this.mProcessorReport;
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localProcessorReport.copyStaticsInfoFromNetResp((StepInfo)localObject, paramNetResp, bool);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" result:");
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    this.mTotolLen = paramNetResp.mTotalFileLen;
    if (this.mNetReq != null) {
      this.mNetReq.mCallback = null;
    }
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    localStepTransInfo.respHeader = ((String)paramNetResp.mRespProperties.get("param_rspHeader"));
    if (paramNetResp.mResult == 0)
    {
      onSuccess();
      this.mRSMReporter.mFileSize = this.mRecvLen;
      reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
      if (this.mDirectDownloadURL != null) {
        reportDirectDownload(0);
      }
    }
    else if (this.mDirectDownloadURL != null)
    {
      requestUrlWhileDirectFailed(false);
    }
    else
    {
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
        this.mNetReq = null;
        this.mNetworkChgRetryCount += 1;
        clearReprotInfo();
        sendGetUrlReq();
        return;
      }
      onError();
    }
    this.mNetReq = null;
  }
  
  void onSuccess()
  {
    Object localObject = this.mPtt;
    ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.mUiRequest.mOutFilePath);
    this.mPtt.fileSize = this.mTotolLen;
    this.mPtt.urlAtServer = this.mUiRequest.mServerPath;
    super.onSuccess();
    localObject = updateMessageDataBaseContent(this.mPtt);
    if ((localObject != null) && (((Message)localObject).pttUrl != null) && (((Message)localObject).pttUrl.equals(this.mUiRequest.mServerPath))) {
      ((Message)localObject).pttUrl = this.mUiRequest.mOutFilePath;
    }
    if (this.mUiRequest.mDownCallBack != null)
    {
      localObject = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject).a = 0;
      this.mUiRequest.mDownCallBack.a((DownCallBack.DownResult)localObject);
      return;
    }
    sendMessageToUpdate(2003);
  }
  
  void recieveFile(String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject1 = this.mPtt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("&voice_codec=");
      ((StringBuilder)localObject2).append(((MessageForPtt)localObject1).voiceType);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = this;
    ((HttpNetReq)localObject2).mFailedListener = this;
    ((HttpNetReq)localObject2).mReqUrl = ((String)localObject1);
    ((HttpNetReq)localObject2).mIsHttps = paramBoolean;
    ((HttpNetReq)localObject2).mHostForHttpsVerify = this.mDownDomain;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    ((HttpNetReq)localObject2).mServerList = this.mIpList;
    ((HttpNetReq)localObject2).mOutPath = this.mUiRequest.mOutFilePath;
    ((HttpNetReq)localObject2).mSupportBreakResume = true;
    ((HttpNetReq)localObject2).mTempPath = this.mTempPath;
    ((HttpNetReq)localObject2).mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    ((HttpNetReq)localObject2).mBusiProtoType = this.mUiRequest.mUinType;
    ((HttpNetReq)localObject2).mFileType = this.mUiRequest.mFileType;
    ((HttpNetReq)localObject2).mStartDownOffset = 0L;
    ((HttpNetReq)localObject2).mIsNetChgAsError = true;
    ((HttpNetReq)localObject2).mReqProperties.put("Accept-Encoding", "identity");
    if (this.mDirectDownloadURL != null)
    {
      ((HttpNetReq)localObject2).mExcuteTimeLimit = 60000L;
      ((HttpNetReq)localObject2).mContinuErrorLimit = 0;
    }
    ((HttpNetReq)localObject2).mCanPrintUrl = true;
    ((HttpNetReq)localObject2).mUseCmwapConnectionTypeFromDpc = true;
    localObject1 = null;
    paramString = (String)localObject1;
    if (this.mIpList != null)
    {
      paramString = (String)localObject1;
      if (!this.mIpList.isEmpty()) {
        paramString = Arrays.toString(this.mIpList.toArray());
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("directMsgUrlDown:");
    ((StringBuilder)localObject1).append(this.mDirectMsgUrlDown);
    ((StringBuilder)localObject1).append(" ipList:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" uuid:");
    ((StringBuilder)localObject1).append(this.mUiRequest.mServerPath);
    ((StringBuilder)localObject1).append(" FileID:");
    ((StringBuilder)localObject1).append(this.mUiRequest.mGroupFileID);
    ((StringBuilder)localObject1).append(" downOffset:");
    ((StringBuilder)localObject1).append(((HttpNetReq)localObject2).mStartDownOffset);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject1).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = ((NetReq)localObject2);
    setMtype();
    this.mNetEngine.sendReq((NetReq)localObject2);
  }
  
  void recieveFile(boolean paramBoolean)
  {
    this.mProcessorReport.mStepTrans.logStartTime();
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    if (paramBoolean) {
      localObject2 = "https://";
    } else {
      localObject2 = "http://";
    }
    Object localObject1 = null;
    if (this.isDomainTest)
    {
      this.mDownDomain = "grouptalk.c2c.qq.com";
      this.mIpList.clear();
    }
    if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      localObject3 = (ServerAddr)this.mIpList.get(0);
      if ((((ServerAddr)localObject3).isIpv6) && (!((ServerAddr)localObject3).mIp.startsWith("[")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(((ServerAddr)localObject3).mIp);
        ((StringBuilder)localObject1).append("]");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = ((ServerAddr)localObject3).mIp;
      }
      if (((ServerAddr)localObject3).port != 80)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(":");
        localStringBuilder.append(((ServerAddr)localObject3).port);
        localObject1 = localStringBuilder.toString();
      }
      this.mIpList.remove(0);
    }
    else if (this.mDownDomain != null)
    {
      localObject1 = this.mDownDomain;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject3).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mUrlPath);
    recieveFile(((StringBuilder)localObject2).toString(), paramBoolean);
  }
  
  protected void reportPttPV(int paramInt)
  {
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPTTPV(this.app, paramInt, false, 2);
  }
  
  public void run()
  {
    if (this.mNetReq != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Direct download failed overtime = ");
        localStringBuilder.append(this.mDirectDownloadURL);
        QLog.e("SPD", 2, localStringBuilder.toString());
      }
      this.mNetEngine.cancelReq(this.mNetReq);
      this.mNetReq = null;
    }
    requestUrlWhileDirectFailed(true);
  }
  
  void sendGetUrlReq()
  {
    sendMessageToUpdate(2001);
    sendRequest_pb();
  }
  
  void sendRequest_pb()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.selfUin = this.mUiRequest.mSelfUin;
    localGroupPttDownReq.peerUin = this.mUiRequest.mPeerUin;
    localGroupPttDownReq.secondUin = this.mUiRequest.mSecondId;
    localGroupPttDownReq.uinType = this.mUiRequest.mUinType;
    localGroupPttDownReq.groupFileID = this.mGroupFileID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" SendRequest GrpFileKey:");
    localStringBuilder.append(this.mGroupFileKeyStr);
    logRichMediaEvent("SendRequest", localStringBuilder.toString());
    localGroupPttDownReq.groupFileKey = this.mGroupFileKeyStr;
    localGroupPttDownReq.md5 = this.mMsgFileMd5;
    localGroupPttDownReq.voiceType = this.mPtt.voiceType;
    localGroupPttDownReq.downType = this.mUiRequest.mDownMode;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_ptt_dw";
    localRichProtoReq.reqs.add(localGroupPttDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
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
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      if (this.mIsGroup)
      {
        ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttGd", ((HttpNetReq)this.mNetReq).mReqUrl);
        return;
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttDd", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    if (this.mPtt.extFlag == -1L) {
      this.mPtt.extFlag = 0L;
    }
    if (this.mExtraInfo.mFromType == 6)
    {
      MessageForPtt localMessageForPtt = this.mPtt;
      localMessageForPtt.extFlag |= 1L;
    }
    super.start();
    sendMessageToUpdate(2001);
    int i;
    if (this.mUiRequest.mUinType == 1) {
      i = 3;
    } else {
      i = 2;
    }
    reportPttPV(i);
    if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath))
    {
      this.mPtt.fullLocalPath = this.mUiRequest.mOutFilePath;
      updateMessageDataBaseContent(this.mPtt);
    }
    sendGetUrlReq();
  }
  
  public Message updateMessageDataBaseContent(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return ((IPttTempApi)QRoute.api(IPttTempApi.class)).getLastMessage(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */