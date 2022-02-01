package com.tencent.mobileqq.transfile;

import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class PAAudioPttDownloadProcessor
  extends BaseDownloadProcessor
{
  String mTempPath;
  
  public PAAudioPttDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
  }
  
  private cmd0x346.ReqBody constructApplyDownSuccess()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mServerPath));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.mStorageSource)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.mStorageSource)) {
        i = j;
      }
    }
  }
  
  public static String getPttPath(QQAppInterface paramQQAppInterface, String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + Utils.Crc64String(paramQQAppInterface.getAccount()) + "/" + "ptt" + "/pa_audio_" + paramString + ".amr");
  }
  
  private void sendPttDownSuccess()
  {
    logRichMediaEvent("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.mStorageSource)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    ProtoReqManagerImpl.ProtoReq localProtoReq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = constructApplyDownSuccess();
      localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = str;
      localProtoReq.reqBody = localReqBody.toByteArray();
      localProtoReq.fixScheduleCount = 1;
      localProtoReq.tryTime = 30000;
      localProtoReq.tryCount = 1;
      localProtoReq.callback = this;
      if (isAppValid()) {
        break;
      }
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
      return;
      if ("ftn".equals(this.mStorageSource)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mServerPath;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http://")))
    {
      setError(9302, getExpStackString(new Exception("uuid illegal " + str)));
      onError();
      return -1;
    }
    this.mUiRequest.mOutFilePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + Utils.Crc64String(this.app.getAccount()) + "/" + "ptt" + "/pa_audio_" + str + ".amr");
    return 0;
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
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mRespUrl = paramRichProtoReq.downloadUrl;
          this.file.fileUrl = this.mRespUrl;
          if ((this.mProxyIpList != null) && (!this.mProxyIpList.isEmpty()))
          {
            paramRichProtoReq = TransFileUtil.getIpAndPortFromUrl(this.mRespUrl);
            if (paramRichProtoReq != null) {
              this.mIpList.add(paramRichProtoReq);
            }
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
  
  /* Error */
  protected void onC2CPttSetSuccess(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 165
    //   3: ldc_w 366
    //   6: invokevirtual 171	com/tencent/mobileqq/transfile/PAAudioPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 371	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 371	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 372
    //   29: new 126	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 374
    //   39: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 171	com/tencent/mobileqq/transfile/PAAudioPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 379	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 380	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 384	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 385	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 385	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 390	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 391
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 396	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 399	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 396	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 402	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 398	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 406	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 409	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 372
    //   135: new 126	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 411
    //   145: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 171	com/tencent/mobileqq/transfile/PAAudioPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 415
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	PAAudioPttDownloadProcessor
    //   0	176	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	176	2	paramFromServiceMsg	FromServiceMsg
    //   0	176	3	paramArrayOfByte	byte[]
    //   23	126	4	i	int
    //   86	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   54	62	160	java/lang/Exception
    //   68	88	160	java/lang/Exception
    //   97	159	160	java/lang/Exception
    //   62	68	174	java/lang/Exception
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
    boolean bool2 = true;
    super.onResp(paramNetResp);
    this.mNetReq = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      logRichMediaEvent("onHttpResp", bool1);
      localObject = this.mStepTrans;
      if (paramNetResp.mResult != 0) {
        break label142;
      }
    }
    label142:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      if (paramNetResp.mResult != 0) {
        break label147;
      }
      sendPttDownSuccess();
      onSuccess();
      return;
      bool1 = false;
      break;
    }
    label147:
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
    this.mStepTrans.logStartTime();
    String str3 = replaceUrlWithProxyIp(this.mRespUrl, this.mIpList);
    BaseTransProcessor.addProxyIpToList(this.mProxyIpList, this.mIpList);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str3;
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
    String str2 = null;
    String str1 = str2;
    if (this.mIpList != null)
    {
      str1 = str2;
      if (!this.mIpList.isEmpty()) {
        str1 = Arrays.toString(this.mIpList.toArray());
      }
    }
    str2 = TransFileUtil.getIpOrDomainFromURL(str3);
    logRichMediaEvent("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + localHttpNetReq.mStartDownOffset);
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void sendGetUrlReq()
  {
    this.mStepUrl.logStartTime();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */