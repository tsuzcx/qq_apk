package com.tencent.mobileqq.transfile;

import aycx;
import aycy;
import azbx;
import azby;
import azck;
import bcef;
import bcmt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.IBreakDownFix, INetEngine.NetFailedListener, Runnable
{
  public static final int DIRECT_DOWNLOAD_FAIL = 3;
  public static final int DIRECT_DOWNLOAD_NO_IP = 2;
  public static final int DIRECT_DOWNLOAD_NO_URL = 1;
  public static final int DIRECT_DOWNLOAD_OUTOFTIME = 4;
  private String mDirectDownloadURL;
  private TransferRequest.PttDownExtraInfo mExtraInfo;
  String mFullLocalPath;
  long mGroupFileID;
  String mGroupFileKeyStr;
  boolean mIsGroup = true;
  byte[] mMsgFileMd5;
  private long mMsgRecTime;
  private long mMsgTime;
  private MessageForPtt mPtt;
  protected bcmt mSttManager = (bcmt)this.app.getManager(17);
  String mTempPath;
  private boolean useUrlIp;
  
  public GroupPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
  }
  
  private boolean isFailedByOverDue()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.errCode == -9527)
    {
      bool1 = bool2;
      if (this.errDesc != null) {
        if ((!this.errDesc.equals("T_203")) && (!this.errDesc.equals("H_400_-5103017")))
        {
          bool1 = bool2;
          if (!this.errDesc.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void reportDirectDownload(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.mUiRequest.mUinType == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localStatisticCollector.collectPerformance(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void requestUrlWhileDirectFailed(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.mDirectDownloadURL != null)
        {
          boolean bool = isFailedByOverDue();
          if (bool)
          {
            if (i != 0)
            {
              if (!this.useUrlIp) {
                continue;
              }
              FMTSrvAddrProvider.getInstance().getPttIpSaver().a(0);
            }
            this.mDirectDownloadURL = null;
            if (!paramBoolean) {
              break label139;
            }
            reportDirectDownload(4);
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "directDownloadIfCan error");
            }
            if (!bool) {
              break label147;
            }
            this.mPtt.fileSize = 2005L;
            updateMessageDataBaseContent(this.mPtt);
            onError();
          }
        }
        else
        {
          return;
        }
        if (this.errCode == 9366) {
          continue;
        }
        i = 1;
        continue;
        FMTSrvAddrProvider.getInstance().onFailed(16, this.mDirectDownloadURL);
        continue;
        reportDirectDownload(3);
      }
      finally {}
      label139:
      continue;
      label147:
      sendGetUrlReq();
    }
  }
  
  public int checkParam()
  {
    int i = 0;
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mServerPath;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.isLocalPath(str)) || (str.startsWith("http://")))
    {
      setError(9302, getExpStackString(new Exception("uuid illegal " + str)));
      onError();
      i = -1;
      return i;
    }
    this.mPtt = ((MessageForPtt)this.mUiRequest.mRec);
    this.mExtraInfo = ((TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj);
    this.mMsgTime = this.mPtt.msgTime;
    this.mMsgRecTime = this.mPtt.msgRecTime;
    int j = this.mPtt.voiceType;
    if ((this.mUiRequest.mOutFilePath == null) || (!FileUtils.isLocalPath(this.mUiRequest.mLocalPath)))
    {
      if ((this.mPtt.fullLocalPath == null) || (this.mPtt.fullLocalPath.equals("")))
      {
        this.mUiRequest.mOutFilePath = getPttStorePath("group", str, j);
        label235:
        this.mTempPath = (this.mUiRequest.mOutFilePath + "~tmp");
      }
    }
    else {
      if (1 != this.mUiRequest.mUinType) {
        break label416;
      }
    }
    label416:
    for (boolean bool = true;; bool = false)
    {
      this.mIsGroup = bool;
      this.mMsgFileMd5 = getMd5InBytesOfGroup(this.mUiRequest.mMd5, this.mUiRequest.mServerPath);
      this.mGroupFileID = this.mUiRequest.mGroupFileID;
      this.mGroupFileKeyStr = this.mUiRequest.mGroupFileKeyStr;
      if (this.mMsgFileMd5 != null) {
        break;
      }
      setError(9302, getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)));
      onError();
      return -1;
      this.mUiRequest.mOutFilePath = this.mPtt.fullLocalPath;
      break label235;
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {
      break label14;
    }
    label14:
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    label59:
    long l1;
    HashMap localHashMap;
    label264:
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      l1 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject = this.mStepDirectDown.getReportInfo(1) + ";" + this.mStepUrl.getReportInfo(2) + ";" + this.mStepTrans.getReportInfo(3) + ";" + this.mStepMsg.getReportInfo(4);
      this.mReportInfo.put("param_step", localObject);
      this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
      this.mReportInfo.put("param_pttOpt", String.valueOf(azby.a(this.app, this.useUrlIp)));
      localHashMap = this.mReportInfo;
      if (!this.mIsHttpsDownload) {
        break label442;
      }
      localObject = "1";
      localHashMap.put("param_isHttps", localObject);
      this.mReportInfo.put("param_trans_consume", String.valueOf(this.mStepTrans.getTimeConsume()));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.mDirectDownloadURL == null) {
          break label450;
        }
        bool = true;
        label348:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label456;
      }
      reportForIpv6(true, l1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l1, this.mTotolLen, this.mReportInfo, "");
    }
    label442:
    label450:
    label456:
    do
    {
      setReportFlag();
      if (this.mPtt == null) {
        break;
      }
      azck.a(this.app).a(paramBoolean, this.errCode, this.mExtraInfo, this.mPtt);
      return;
      i = 1;
      break label59;
      localObject = "0";
      break label264;
      bool = false;
      break label348;
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      if ((this.mNetReq instanceof HttpNetReq))
      {
        localObject = RichMediaUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
        if (localObject != null) {
          this.mReportInfo.put("param_reqIp", ((ServerAddr)localObject).mIp);
        }
      }
      reportForIpv6(false, l1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l1, 0L, this.mReportInfo, "");
    } while ((this.errCode != -9527) || (this.errDesc == null));
    int i = 0;
    if (this.errDesc.equals("T_203"))
    {
      i = 1;
      label619:
      if (i == 0) {
        break label862;
      }
      if (this.mMsgRecTime > this.mMsgTime) {
        if (!this.mIsGroup) {
          break label864;
        }
      }
    }
    label862:
    label864:
    for (Object localObject = "actGroupPTTOutOfTime";; localObject = "actDiscussionPTTOutOfTime")
    {
      localHashMap = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.mMsgRecTime - this.mMsgTime) / 86400L;
      long l2 = (l3 - this.mMsgTime) / 86400L;
      l3 = (l3 - this.mMsgRecTime) / 86400L;
      localHashMap.put("MsgOff", String.valueOf(l1));
      localHashMap.put("PttOff", String.valueOf(l3));
      localHashMap.put("OutOfTimeReason", String.valueOf(i));
      localHashMap.put("param_FailCode", String.valueOf(l2));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.mUiRequest.mExtraObj == null) {
        break;
      }
      localObject = (TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj;
      bcef.b(this.app, "CliOper", "", "", "0X80059B3", "0X80059B3", PttInfoCollector.mergeDownloadPTTFromType(((TransferRequest.PttDownExtraInfo)localObject).mFromType, ((TransferRequest.PttDownExtraInfo)localObject).mLayer), 0, "", "", "", "8.4.8");
      break;
      if (!this.errDesc.equals("H_400_-5103017")) {
        break label619;
      }
      i = 16;
      break label619;
      break;
    }
  }
  
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
    } while (0L != paramNetReq.mEndDownOffset);
    paramNetResp.mWrittenBlockLen = 0L;
    paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
    paramNetReq.mReqProperties.put("Range", paramNetResp);
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
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mDownDomain = paramRichProtoReq.domainV4V6;
          this.mUrlPath = paramRichProtoReq.urlPath;
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          if (this.mDownDomain != null)
          {
            ServerAddr localServerAddr = new ServerAddr();
            localServerAddr.isDomain = true;
            localServerAddr.mIp = this.mDownDomain;
            this.mIpList.add(localServerAddr);
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
      aycy localaycy = new aycy();
      localaycy.a = -1;
      this.mUiRequest.mDownCallBack.a(localaycy);
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
    Object localObject;
    FileMsg.StepTransInfo localStepTransInfo;
    boolean bool;
    if (this.mDirectDownloadURL != null)
    {
      localObject = this.mStepDirectDown;
      localStepTransInfo = this.file.stepMsgDirecDown;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramNetResp.mResult != 0) {
        break label234;
      }
      bool = true;
      label37:
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.mResult != 0) {
        break label239;
      }
      bool = true;
      label67:
      logRichMediaEvent("onHttpResp", bool);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mNetReq != null) {
        this.mNetReq.mCallback = null;
      }
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      localStepTransInfo.respHeader = ((String)paramNetResp.mRespProperties.get("param_rspHeader"));
      if (paramNetResp.mResult != 0) {
        break label244;
      }
      onSuccess();
      this.mRSMReporter.mFileSize = this.mRecvLen;
      reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
      if (this.mDirectDownloadURL != null) {
        reportDirectDownload(0);
      }
    }
    for (;;)
    {
      this.mNetReq = null;
      return;
      localObject = this.mStepTrans;
      localStepTransInfo = this.file.stepTrans;
      break;
      label234:
      bool = false;
      break label37;
      label239:
      bool = false;
      break label67;
      label244:
      if (this.mDirectDownloadURL != null)
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
    }
  }
  
  void onSuccess()
  {
    this.mPtt.url = MessageForPtt.getMsgFilePath(this.mPtt.voiceType, this.mUiRequest.mOutFilePath);
    this.mPtt.fileSize = this.mTotolLen;
    this.mPtt.urlAtServer = this.mUiRequest.mServerPath;
    super.onSuccess();
    Object localObject = updateMessageDataBaseContent(this.mPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.mUiRequest.mServerPath))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.mUiRequest.mOutFilePath;
    }
    if (this.mUiRequest.mDownCallBack != null)
    {
      localObject = new aycy();
      ((aycy)localObject).a = 0;
      this.mUiRequest.mDownCallBack.a((aycy)localObject);
      return;
    }
    sendMessageToUpdate(2003);
  }
  
  void recieveFile(String paramString, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.mPtt;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mFailedListener = this;
    localHttpNetReq.mReqUrl = ((String)localObject);
    localHttpNetReq.mIsHttps = paramBoolean;
    localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mBreakDownFix = this;
    localHttpNetReq.mTempPath = this.mTempPath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    if (this.mDirectDownloadURL != null)
    {
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      localHttpNetReq.mContinuErrorLimit = 0;
    }
    localHttpNetReq.mCanPrintUrl = true;
    localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.mIpList != null)
    {
      paramString = (String)localObject;
      if (!this.mIpList.isEmpty()) {
        paramString = Arrays.toString(this.mIpList.toArray());
      }
    }
    logRichMediaEvent("httpDown", "directMsgUrlDown:" + this.mDirectMsgUrlDown + " ipList:" + paramString + " uuid:" + this.mUiRequest.mServerPath + " FileID:" + this.mUiRequest.mGroupFileID + " downOffset:" + localHttpNetReq.mStartDownOffset);
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void recieveFile(boolean paramBoolean)
  {
    this.mStepTrans.logStartTime();
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    String str2;
    Object localObject;
    ServerAddr localServerAddr;
    String str1;
    if (paramBoolean)
    {
      str2 = "https://";
      localObject = null;
      if (this.isDomainTest)
      {
        this.mDownDomain = "grouptalk.c2c.qq.com";
        this.mIpList.clear();
      }
      if ((this.mIpList == null) || (this.mIpList.size() <= 0)) {
        break label248;
      }
      localServerAddr = (ServerAddr)this.mIpList.get(0);
      if ((!localServerAddr.isIpv6) || (localServerAddr.mIp.startsWith("["))) {
        break label239;
      }
      str1 = "[" + localServerAddr.mIp + "]";
      label135:
      localObject = str1;
      if (localServerAddr.port != 80) {
        localObject = str1 + ":" + localServerAddr.port;
      }
      this.mIpList.remove(0);
    }
    for (;;)
    {
      str1 = str2 + (String)localObject;
      recieveFile(str1 + this.mUrlPath, paramBoolean);
      return;
      str2 = "http://";
      break;
      label239:
      str1 = localServerAddr.mIp;
      break label135;
      label248:
      if (this.mDownDomain != null) {
        localObject = this.mDownDomain;
      }
    }
  }
  
  public void run()
  {
    if (this.mNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.mDirectDownloadURL);
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
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.selfUin = this.mUiRequest.mSelfUin;
    localGroupPttDownReq.peerUin = this.mUiRequest.mPeerUin;
    localGroupPttDownReq.secondUin = this.mUiRequest.mSecondId;
    localGroupPttDownReq.uinType = this.mUiRequest.mUinType;
    localGroupPttDownReq.groupFileID = this.mGroupFileID;
    logRichMediaEvent("SendRequest", " SendRequest GrpFileKey:" + this.mGroupFileKeyStr);
    localGroupPttDownReq.groupFileKey = this.mGroupFileKeyStr;
    localGroupPttDownReq.md5 = this.mMsgFileMd5;
    localGroupPttDownReq.voiceType = this.mPtt.voiceType;
    localGroupPttDownReq.downType = this.mUiRequest.mDownMode;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_ptt_dw";
    localRichProtoReq.reqs.add(localGroupPttDownReq);
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
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
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      if (this.mIsGroup) {
        ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttGd", ((HttpNetReq)this.mNetReq).mReqUrl);
      }
    }
    else {
      return;
    }
    ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttDd", ((HttpNetReq)this.mNetReq).mReqUrl);
  }
  
  public void start()
  {
    if (this.mPtt.extFlag == -1L) {
      this.mPtt.extFlag = 0L;
    }
    if (this.mExtraInfo.mFromType == 6)
    {
      localObject = this.mPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.start();
    sendMessageToUpdate(2001);
    Object localObject = this.app;
    if (this.mUiRequest.mUinType == 1) {}
    for (int i = 3;; i = 2)
    {
      PttInfoCollector.reportPTTPV((QQAppInterface)localObject, i, false, 2);
      if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath))
      {
        this.mPtt.fullLocalPath = this.mUiRequest.mOutFilePath;
        updateMessageDataBaseContent(this.mPtt);
      }
      sendGetUrlReq();
      return;
    }
  }
  
  public QQMessageFacade.Message updateMessageDataBaseContent(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.app.getMessageFacade().getLastMessage(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */