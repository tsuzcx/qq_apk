package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamFileInfo;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttDownloadProcessor
  extends BasePttDownloaderProcessor
  implements NetFailedListener, Runnable
{
  String mDirectDownloadURL = null;
  private TransferRequest.PttDownExtraInfo mExtraInfo;
  private long mMsgRecTime;
  private long mMsgTime;
  String[] mProtoMsg = null;
  MessageForPtt mPtt;
  String mTempPath;
  private boolean useUrlIp = false;
  
  public C2CPttDownloadProcessor() {}
  
  public C2CPttDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private File getUnfinishedStreamFile(long paramLong1, long paramLong2)
  {
    Object localObject1 = ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).getStreamFileInfoEntryByMsg(paramLong1, paramLong2);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("try get stream info ");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("BaseTransProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      localObject2 = (StreamFileInfo)((Map.Entry)localObject1).getValue();
      if (localObject2 != null)
      {
        ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool((String)((Map.Entry)localObject1).getKey());
        ((StreamFileInfo)localObject2).a(false);
        localObject1 = ((StreamFileInfo)localObject2).c();
        if ((localObject1 != null) && (((File)localObject1).exists())) {
          return localObject1;
        }
      }
    }
    return null;
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mServerPath;
    Object localObject2 = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.mProcessorReport.mIsOldDbRec = true;
    }
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
          this.mUiRequest.mOutFilePath = getPttStorePath("c2c", (String)localObject1, i);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mUiRequest.mOutFilePath);
        ((StringBuilder)localObject1).append("~tmp");
        this.mTempPath = ((StringBuilder)localObject1).toString();
        localObject1 = getUnfinishedStreamFile(this.mUiRequest.mRec.msgUid, this.mUiRequest.mRec.shmsgseq);
        if (localObject1 != null)
        {
          localObject2 = new File(this.mTempPath);
          if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
            ((File)localObject2).delete();
          }
          ((File)localObject1).renameTo((File)localObject2);
        }
      }
      return 0;
    }
    localObject2 = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uuid illegal ");
    localStringBuilder.append((String)localObject1);
    ((ProcessorReport)localObject2).setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
    return -1;
  }
  
  cmd0x346.ReqBody constructApplyDownSuccess()
  {
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mServerPath));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    boolean bool = "ftn".equals(this.mStorageSource);
    int i = 17;
    if (bool) {
      i = 3;
    } else {
      "pttcenter".equals(this.mStorageSource);
    }
    localReqBody.uint32_business_id.set(i);
    localReqBody.uint32_client_type.set(104);
    localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
    return localReqBody;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    Object localObject1;
    long l1;
    Object localObject3;
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      localObject1 = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject1).mReportedFlag = (j | i);
      l1 = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepDirectDown.getReportInfo(1));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(2));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(3));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepMsg.getReportInfo(4));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject1);
      localObject3 = this.mProcessorReport.mReportInfo;
      if (this.mIsHttpsDownload) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ((HashMap)localObject3).put("param_isHttps", localObject1);
      this.mProcessorReport.mReportInfo.put("param_trans_consume", String.valueOf(this.mProcessorReport.mStepTrans.getTimeConsume()));
      this.mProcessorReport.mReportInfo.put("param_fromUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mProcessorReport.mReportInfo.put("param_writtenSize", String.valueOf(this.mRecvLen));
      this.mProcessorReport.mReportInfo.put("param_quickHttp", String.valueOf(this.mProcessorReport.mSendByQuickHttp));
      this.mProcessorReport.mReportInfo.put("param_pttOpt", String.valueOf(((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getOptString(this.app, this.useUrlIp)));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("totle=");
        ((StringBuilder)localObject1).append(this.mTotolLen);
        ((StringBuilder)localObject1).append(" written=");
        ((StringBuilder)localObject1).append(this.mRecvLen);
        QLog.d("BaseTransProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("C2cPttDownload success: ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(", cost: ");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(" directDownloadIfCan: ");
        boolean bool;
        if (this.mDirectDownloadURL != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject1).append(bool);
        QLog.d("SPD", 4, ((StringBuilder)localObject1).toString());
      }
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
        reportForIpv6(true, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l1, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
        continue;
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        if ((this.mNetReq instanceof HttpNetReq))
        {
          localObject1 = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
          if (localObject1 != null) {
            this.mProcessorReport.mReportInfo.put("param_reqIp", ((ServerAddr)localObject1).mIp);
          }
        }
        this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
        reportForIpv6(false, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l1, 0L, this.mProcessorReport.mReportInfo, "");
        if ((this.mProcessorReport.errCode == -9527) && (this.mProcessorReport.errDesc != null) && (this.mProcessorReport.errDesc.equals("H_400_-5103017")))
        {
          if (this.mMsgRecTime > this.mMsgTime)
          {
            localObject1 = new HashMap();
            long l3 = System.currentTimeMillis() / 1000L;
            l1 = (this.mMsgRecTime - this.mMsgTime) / 86400L;
            long l2 = (l3 - this.mMsgTime) / 86400L;
            l3 = (l3 - this.mMsgRecTime) / 86400L;
            ((HashMap)localObject1).put("MsgOff", String.valueOf(l1));
            ((HashMap)localObject1).put("PttOff", String.valueOf(l3));
            ((HashMap)localObject1).put("OutOfTimeReason", String.valueOf(256));
            ((HashMap)localObject1).put("param_FailCode", String.valueOf(l2));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject1, null);
          }
          if (this.mUiRequest.mExtraObj != null)
          {
            if (this.mUiRequest.mUinType != 0) {
              break label1190;
            }
            localObject1 = "0X80059B2";
            localObject3 = (TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj;
            ReportController.b(this.app, "CliOper", "", "", (String)localObject1, (String)localObject1, PttInfoCollectorImpl.mergeDownloadPTTFromType(((TransferRequest.PttDownExtraInfo)localObject3).mFromType, ((TransferRequest.PttDownExtraInfo)localObject3).mLayer), 0, "", "", "", "8.8.17");
          }
        }
        setReportFlag();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("report exception =");
          ((StringBuilder)localObject3).append(localException.toString());
          QLog.d("BaseTransProcessor", 2, ((StringBuilder)localObject3).toString());
        }
      }
      Object localObject2 = this.mPtt;
      if (localObject2 != null) {
        ((IPTTPreDownloader)this.app.getRuntimeService(IPTTPreDownloader.class, "all")).onDownloadFinish(paramBoolean, this.mProcessorReport.errCode, this.mExtraInfo, (MessageForPtt)localObject2);
      }
      return;
      label1190:
      localObject2 = "0X80059B4";
    }
  }
  
  public String getDomainRequest(String paramString)
  {
    Object localObject;
    if (paramString.startsWith("http://"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://");
      ((StringBuilder)localObject).append(this.mDownDomain);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramString.startsWith("https://"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(this.mDownDomain);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/");
    return TransFileUtil.replaceIp(paramString, localStringBuilder.toString());
  }
  
  protected String getReportTAG()
  {
    return "actC2CPttDownload";
  }
  
  boolean isFailedByOverDue()
  {
    return (this.mProcessorReport.errCode == -9527) && (this.mProcessorReport.errDesc != null) && ((this.mProcessorReport.errDesc.equals("H_400_-5103017")) || (this.mProcessorReport.errDesc.equals("H_400_-5103039")));
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=");
          localStringBuilder.append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, localStringBuilder.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mRespUrl = paramRichProtoReq.downloadUrl;
          if ((this.mRespUrl != null) && (this.mRespUrl.startsWith("https://")))
          {
            this.mIsHttpsDownload = true;
            this.mRSMReporter.mIsHttps = true;
          }
          this.file.fileUrl = this.mRespUrl;
          if ((paramRichProtoReq.domainV4V6 != null) && (paramRichProtoReq.domainV4V6.length() > 0)) {
            this.mDownDomain = paramRichProtoReq.domainV4V6;
          }
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          if (this.isDomainTest)
          {
            this.mDownDomain = "grouptalk.c2c.qq.com";
            this.mIpList.clear();
          }
          recieveFile();
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  protected void onC2CPttSetSuccess(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    logRichMediaEvent("setSuccess", "resp");
    int i;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      i = paramFromServiceMsg.getResultCode();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("error,code:");
      paramToServiceMsg.append(i);
      logRichMediaEvent("onC2CPttSetSuccess", paramToServiceMsg.toString());
      return;
    }
    label185:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new cmd0x346.RspBody();
        long l = -1L;
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom(paramArrayOfByte);
          if (!paramToServiceMsg.uint32_cmd.has()) {
            break label185;
          }
          l = paramToServiceMsg.uint32_cmd.get();
          if (l == 1010L)
          {
            if (!paramToServiceMsg.msg_download_succ_rsp.has()) {
              return;
            }
            i = ((cmd0x346.DownloadSuccRsp)paramToServiceMsg.msg_download_succ_rsp.get()).int32_ret_code.get();
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("retcode:");
              paramToServiceMsg.append(i);
              logRichMediaEvent("onC2CPttSetSuccess", paramToServiceMsg.toString());
            }
          }
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          return;
        }
        paramToServiceMsg = paramToServiceMsg;
        paramToServiceMsg.printStackTrace();
        return;
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
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    onC2CPttSetSuccess(null, paramProtoResp.resp, paramProtoResp.resp.getWupBuffer());
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    StepInfo localStepInfo;
    if (this.mDirectDownloadURL != null)
    {
      localStepInfo = this.mProcessorReport.mStepDirectDown;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    else
    {
      localStepInfo = this.mProcessorReport.mStepTrans;
    }
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
    if (paramNetResp.mResult == 0)
    {
      sendPttDownSuccess();
      onSuccess();
      this.mRSMReporter.mFileSize = this.mRecvLen;
      reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
      if (this.mDirectDownloadURL != null) {
        reportDirectDownload(0);
      }
    }
    else
    {
      if (this.mDirectDownloadURL != null)
      {
        requestUrlWhileDirectFailed(false);
        return;
      }
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
    super.onSuccess();
    Object localObject = this.mPtt;
    ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.mUiRequest.mOutFilePath);
    this.mPtt.fileSize = this.mTotolLen;
    this.mPtt.urlAtServer = this.mUiRequest.mServerPath;
    localObject = updateMessageDataBaseContent(this.mPtt);
    if ((localObject != null) && (this.mUiRequest.mServerPath != null) && (this.mUiRequest.mServerPath.equals(((Message)localObject).pttUrl))) {
      ((Message)localObject).pttUrl = this.mUiRequest.mOutFilePath;
    }
    if ((this.app != null) && (((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(this.mPtt)))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      ((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class, "all")).translate(this.mPtt, 2);
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
  
  void recieveFile()
  {
    this.mProcessorReport.mStepTrans.logStartTime();
    String str = this.mRespUrl;
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "grouptalk.c2c.qq.com";
    }
    if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      str = TransFileUtil.replaceIp(str, ((ServerAddr)this.mIpList.get(0)).getServerUrl(str));
      this.mIpList.remove(0);
    }
    else
    {
      str = getDomainRequest(str);
    }
    TransFileUtil.addDomainToList(this.mIpList, this.mDownDomain);
    recieveFile(str);
  }
  
  void recieveFile(String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mFailedListener = this;
    localHttpNetReq.mReqUrl = paramString;
    if (paramString.startsWith("https://")) {
      localHttpNetReq.mIsHttps = true;
    }
    localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localHttpNetReq.mCanPrintUrl = true;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mTempPath = this.mTempPath;
    localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
    if (this.mDirectDownloadURL != null)
    {
      localHttpNetReq.mExcuteTimeLimit = 120000L;
      localHttpNetReq.mContinuErrorLimit = 0;
    }
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (this.mIpList != null)
    {
      localObject = localStringBuilder;
      if (!this.mIpList.isEmpty()) {
        localObject = Arrays.toString(this.mIpList.toArray());
      }
    }
    paramString = TransFileUtil.getIpOrDomainFromURL(paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("RespDomain: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(this.mUiRequest.mServerPath);
    localStringBuilder.append(" downOffset:");
    localStringBuilder.append(localHttpNetReq.mStartDownOffset);
    logRichMediaEvent("httpDown", localStringBuilder.toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void reportDirectDownload(int paramInt)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(paramInt));
        StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (paramInt == 0)
        {
          bool = true;
          localStatisticCollector.collectPerformance(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
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
  
  void requestUrlWhileDirectFailed(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mDirectDownloadURL != null)
        {
          i = 0;
          if ((this.mProcessorReport.errCode != -9527) || (this.mProcessorReport.errDesc == null) || (!this.mProcessorReport.errDesc.equals("H_400_-5103017"))) {
            if (this.mProcessorReport.errCode != 9366) {
              break label180;
            }
          }
          if (i != 0) {
            ((IPttTempApi)QRoute.api(IPttTempApi.class)).doOnPttSrvAddressError(this.useUrlIp, this.mDirectDownloadURL);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "c2c directDownloadIfCan error");
          }
          if (paramBoolean) {
            reportDirectDownload(4);
          } else {
            reportDirectDownload(3);
          }
          if (isFailedByOverDue())
          {
            this.mPtt.fileSize = 2005L;
            updateMessageDataBaseContent(this.mPtt);
            onError();
          }
          else
          {
            sendGetUrlReq();
          }
          this.mDirectDownloadURL = null;
        }
        else
        {
          return;
        }
      }
      finally {}
      label180:
      int i = 1;
    }
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
    this.mProcessorReport.mStepUrl.logStartTime();
    Object localObject = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.mStorageSource = ((MessageForPtt)localObject).storageSource;
    }
    else
    {
      this.mStorageSource = "pttcenter";
      logRichMediaEvent("findDbRec", "not found");
    }
    localObject = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPttDownReq localC2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
    localC2CPttDownReq.selfUin = this.mUiRequest.mSelfUin;
    localC2CPttDownReq.peerUin = this.mUiRequest.mPeerUin;
    localC2CPttDownReq.secondUin = this.mUiRequest.mSecondId;
    localC2CPttDownReq.uinType = this.mUiRequest.mUinType;
    localC2CPttDownReq.uuid = this.mUiRequest.mServerPath;
    localC2CPttDownReq.storageSource = this.mStorageSource;
    localC2CPttDownReq.isSelfSend = this.mUiRequest.mIsSelfSend;
    MessageForPtt localMessageForPtt = this.mPtt;
    localC2CPttDownReq.voiceType = localMessageForPtt.voiceType;
    localC2CPttDownReq.autoToText = localMessageForPtt.autoToText;
    if (1008 == localC2CPttDownReq.uinType) {
      localC2CPttDownReq.busiType = this.mPtt.busiType;
    }
    localC2CPttDownReq.downType = this.mUiRequest.mDownMode;
    ((RichProto.RichProtoReq)localObject).callback = this;
    ((RichProto.RichProtoReq)localObject).protoKey = "c2c_ptt_dw";
    ((RichProto.RichProtoReq)localObject).reqs.add(localC2CPttDownReq);
    ((RichProto.RichProtoReq)localObject).protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", ((RichProto.RichProtoReq)localObject).toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = ((RichProto.RichProtoReq)localObject);
    RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject);
  }
  
  void sendPttDownSuccess()
  {
    logRichMediaEvent("setSuccess", "req");
    boolean bool = "pttcenter".equals(this.mStorageSource);
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ((!bool) && ("ftn".equals(this.mStorageSource))) {
      str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    cmd0x346.ReqBody localReqBody = constructApplyDownSuccess();
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = str;
    localProtoReq.reqBody = localReqBody.toByteArray();
    localProtoReq.fixScheduleCount = 1;
    localProtoReq.tryTime = 30000;
    localProtoReq.tryCount = 1;
    localProtoReq.callback = this;
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCd", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
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
    Object localObject = (IPttInfoCollector)QRoute.api(IPttInfoCollector.class);
    AppInterface localAppInterface = this.app;
    int i;
    if (this.mUiRequest.mUinType == 0) {
      i = 1;
    } else {
      i = 4;
    }
    ((IPttInfoCollector)localObject).reportPTTPV(localAppInterface, i, false, 2);
    if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath))
    {
      this.mPtt.fullLocalPath = this.mUiRequest.mOutFilePath;
      updateMessageDataBaseContent(this.mPtt);
    }
    sendGetUrlReq();
  }
  
  Message updateMessageDataBaseContent(MessageForPtt paramMessageForPtt)
  {
    try
    {
      paramMessageForPtt.serial();
      ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getLastMessage(this.app, this.mUiRequest.mPeerUin, 0);
      return paramMessageForPtt;
    }
    catch (Exception paramMessageForPtt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "updatedb", paramMessageForPtt);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */