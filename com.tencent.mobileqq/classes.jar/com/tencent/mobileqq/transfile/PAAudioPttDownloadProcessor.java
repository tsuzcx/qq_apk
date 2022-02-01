package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class PAAudioPttDownloadProcessor
  extends BaseDownloadProcessor
{
  String mTempPath;
  
  public PAAudioPttDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private cmd0x346.ReqBody constructApplyDownSuccess()
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
  
  public static String getPttPath(AppRuntime paramAppRuntime, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(Utils.Crc64String(paramAppRuntime.getAccount()));
    localStringBuilder.append("/");
    localStringBuilder.append("ptt");
    localStringBuilder.append("/pa_audio_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".amr");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  private void sendPttDownSuccess()
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
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mServerPath;
    if ((str != null) && (!str.equals("")) && (!str.equals("null")) && (!FileUtils.isLocalPath(str)) && (!str.startsWith("http://")))
    {
      localObject = this.mUiRequest;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append(Utils.Crc64String(this.app.getAccount()));
      localStringBuilder.append("/");
      localStringBuilder.append("ptt");
      localStringBuilder.append("/pa_audio_");
      localStringBuilder.append(str);
      localStringBuilder.append(".amr");
      ((TransferRequest)localObject).mOutFilePath = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
      return 0;
    }
    Object localObject = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uuid illegal ");
    localStringBuilder.append(str);
    ((ProcessorReport)localObject).setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
    return -1;
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
          this.file.fileUrl = this.mRespUrl;
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
    label184:
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
            break label184;
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
    sendMessageToUpdate(2005);
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    onC2CPttSetSuccess(null, paramProtoResp.resp, paramProtoResp.resp.getWupBuffer());
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    this.mNetReq = null;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" result:");
    int i = paramNetResp.mResult;
    boolean bool2 = false;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    localObject = this.mProcessorReport;
    StepInfo localStepInfo = this.mProcessorReport.mStepTrans;
    boolean bool1 = bool2;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    }
    ((ProcessorReport)localObject).copyStaticsInfoFromNetResp(localStepInfo, paramNetResp, bool1);
    this.mTotolLen = paramNetResp.mTotalFileLen;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    if (paramNetResp.mResult == 0)
    {
      sendPttDownSuccess();
      onSuccess();
      return;
    }
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendGetUrlReq();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    sendMessageToUpdate(2003);
  }
  
  void recieveFile()
  {
    this.mProcessorReport.mStepTrans.logStartTime();
    String str2 = this.mRespUrl;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str2;
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
    String str1;
    if ((this.mIpList != null) && (!this.mIpList.isEmpty())) {
      str1 = Arrays.toString(this.mIpList.toArray());
    } else {
      str1 = null;
    }
    str2 = TransFileUtil.getIpOrDomainFromURL(str2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RespDomain: ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append(str1);
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
  
  void sendGetUrlReq()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    this.mStorageSource = "pttcenter";
    logRichMediaEvent("findDbRec", "not found");
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPttDownReq localC2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
    localC2CPttDownReq.selfUin = this.mUiRequest.mSelfUin;
    localC2CPttDownReq.peerUin = this.mUiRequest.mPeerUin;
    localC2CPttDownReq.secondUin = this.mUiRequest.mSecondId;
    localC2CPttDownReq.uinType = this.mUiRequest.mUinType;
    localC2CPttDownReq.uuid = this.mUiRequest.mServerPath;
    localC2CPttDownReq.storageSource = this.mStorageSource;
    localC2CPttDownReq.isSelfSend = this.mUiRequest.mIsSelfSend;
    localC2CPttDownReq.voiceType = 0;
    localC2CPttDownReq.busiType = 3;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "c2c_ptt_dw";
    localRichProtoReq.reqs.add(localC2CPttDownReq);
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
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCd", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    super.start();
    sendGetUrlReq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */