package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public class MultiMsgUpProcessor
  extends BaseUploadProcessor
{
  private static final String TAG = "MultiMsgUpProcessor";
  public static ExcitingTransferHostInfo mBDHIpv4;
  public static ExcitingTransferHostInfo mBDHIpv6;
  public static boolean mIsBDHImmediately = true;
  private static int seq;
  public boolean mIsByBDH = true;
  private String mLocalPath = this.mUiRequest.mLocalPath;
  private byte[] mMsgKey;
  private byte[] mResId;
  private boolean mSSCMSpanned = false;
  private byte[] mSig;
  private String mUUID;
  private int mUinType = this.mUiRequest.mUinType;
  private byte[] mUkey;
  public int multiMsgType;
  private long selfUin;
  private SSCM sscmObject = new SSCM();
  private long startTime = -1L;
  private byte[] toSendData;
  private byte[] toSendPBData;
  
  public MultiMsgUpProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.toSendData = paramTransferRequest.toSendData;
    this.multiMsgType = paramTransferRequest.multiMsgType;
    if (this.toSendData != null) {
      this.mFileSize = paramTransferRequest.toSendData.length;
    } else {
      this.mFileSize = 0L;
    }
    try
    {
      this.selfUin = Long.parseLong(this.mUiRequest.mSelfUin);
      return;
    }
    catch (Exception paramTransFileControllerImpl)
    {
      paramTransFileControllerImpl.printStackTrace();
      this.selfUin = 0L;
    }
  }
  
  private boolean constructToSendData()
  {
    Object localObject2 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject2).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject2).uint64_dst_uin.set(Long.valueOf(this.mUiRequest.mPeerUin).longValue());
    ((LongMsg.MsgUpReq)localObject2).bytes_msg_content.set(ByteStringMicro.copyFrom(this.toSendData));
    if (!mIsBDHImmediately) {
      ((LongMsg.MsgUpReq)localObject2).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.mUkey));
    }
    ((LongMsg.MsgUpReq)localObject2).uint32_store_type.set(2);
    if (this.mUiRequest.isJubaoMsgType) {
      ((LongMsg.MsgUpReq)localObject2).uint32_msg_type.set(17);
    } else {
      ((LongMsg.MsgUpReq)localObject2).uint32_msg_type.set(convertMsgType(this.mUinType));
    }
    Object localObject1 = new LongMsg.ReqBody();
    ((LongMsg.ReqBody)localObject1).setHasFlag(true);
    ((LongMsg.ReqBody)localObject1).uint32_subcmd.set(1);
    ((LongMsg.ReqBody)localObject1).uint32_term_type.set(5);
    ((LongMsg.ReqBody)localObject1).uint32_platform_type.set(9);
    ((LongMsg.ReqBody)localObject1).rpt_msg_up_req.add((MessageMicro)localObject2);
    ((LongMsg.ReqBody)localObject1).uint32_busi_type.set(this.mUiRequest.upMsgBusiType);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("constructToSendData called(). upMsgBusiType = ");
      ((StringBuilder)localObject2).append(this.mUiRequest.upMsgBusiType);
      QLog.d("MultiMsgUpProcessor", 4, ((StringBuilder)localObject2).toString());
    }
    if ((this.mIsByBDH) && (this.multiMsgType == 0)) {
      ((LongMsg.ReqBody)localObject1).uint32_agent_type.set(1);
    }
    this.toSendPBData = ((LongMsg.ReqBody)localObject1).toByteArray();
    if (this.mIsByBDH) {
      return true;
    }
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject1).toByteArray(), this.mMsgKey);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.mSig));
    localObject1 = new String();
    int i = 0;
    while (i < 6)
    {
      localObject2 = localObject1;
      if ("8.8.17".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("8.8.17".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject2 = new im_msg_head.HttpConnHead();
    ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(this.selfUin);
    ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
    ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(1291);
    ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(getSeq());
    ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
    ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
    ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
    localObject1 = new im_msg_head.Head();
    ((im_msg_head.Head)localObject1).uint32_head_type.set(4);
    ((im_msg_head.Head)localObject1).msg_login_sig.set((MessageMicro)localObject3);
    ((im_msg_head.Head)localObject1).msg_httpconn_head.set((MessageMicro)localObject2);
    localObject1 = ((im_msg_head.Head)localObject1).toByteArray();
    localObject2 = new ByteArrayOutputStream();
    try
    {
      localObject3 = new DataOutputStream((OutputStream)localObject2);
      ((DataOutputStream)localObject3).write(40);
      ((DataOutputStream)localObject3).writeInt(localObject1.length);
      ((DataOutputStream)localObject3).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject3).write((byte[])localObject1);
      ((DataOutputStream)localObject3).write(arrayOfByte);
      ((DataOutputStream)localObject3).write(41);
      ((DataOutputStream)localObject3).flush();
      this.toSendPBData = ((ByteArrayOutputStream)localObject2).toByteArray();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsgUpProcessor", 2, localException.getMessage());
      }
      this.mProcessorReport.setError(9360, "constructToSendData() dos.write()", null, null);
    }
    return false;
  }
  
  public static int convertMsgType(int paramInt)
  {
    int j = 3;
    int i = j;
    if (paramInt != 1)
    {
      i = j;
      if (paramInt != 3000)
      {
        if (paramInt != 1039)
        {
          if (paramInt != 1040) {
            return 1;
          }
          return 15;
        }
        i = 255;
      }
    }
    return i;
  }
  
  private static int getSeq()
  {
    int i = seq;
    seq = i + 1;
    return i;
  }
  
  private void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq.MultiMsgUpReq localMultiMsgUpReq = new RichProto.RichProtoReq.MultiMsgUpReq();
    localMultiMsgUpReq.size = this.mFileSize;
    localMultiMsgUpReq.md5 = this.mLocalMd5;
    localMultiMsgUpReq.multiMsgType = this.multiMsgType;
    localMultiMsgUpReq.selfUin = this.mUiRequest.mSelfUin;
    localMultiMsgUpReq.peerUin = this.mUiRequest.mPeerUin;
    localMultiMsgUpReq.secondUin = this.mUiRequest.mSecondId;
    localMultiMsgUpReq.uinType = this.mUiRequest.mUinType;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "multi_msg_up";
    localRichProtoReq.reqs.add(localMultiMsgUpReq);
    localRichProtoReq.protoReqMgr = getProtoReqManager();
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
    if (mIsBDHImmediately)
    {
      if (constructToSendData())
      {
        sendFile();
        return;
      }
      onError();
    }
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    if ((this.toSendData != null) && (0L < this.mFileSize) && (0L != this.selfUin))
    {
      this.mExtName = "";
      return 0;
    }
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.mProcessorReport.mStepUrl;
    int j = 1;
    ((StringBuilder)localObject1).append(((StepInfo)localObject2).getReportInfo(1));
    ((StringBuilder)localObject1).append(";");
    localObject2 = this.mProcessorReport.mStepTrans;
    int i = 2;
    ((StringBuilder)localObject1).append(((StepInfo)localObject2).getReportInfo(2));
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDSReport : GroupPic doReport : result:");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("MultiMsgUpProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mUiRequest.mBusiType == 1030) {
      return;
    }
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      localObject2 = this.mProcessorReport;
      int k = this.mProcessorReport.mReportedFlag;
      if (!paramBoolean) {
        i = 1;
      }
      ((ProcessorReport)localObject2).mReportedFlag = (i | k);
      this.mProcessorReport.mEndTime = System.currentTimeMillis();
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      this.mProcessorReport.mReportInfo.put("param_step", localObject1);
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      if (paramBoolean)
      {
        if ((this.reportTimeTrans > 0L) && (this.reportTimePicCache > 0L)) {
          i = j;
        } else {
          i = 0;
        }
        if ((this.isReportValid) && (i != 0))
        {
          this.costReport = new StringBuilder();
          localObject1 = this.costReport;
          ((StringBuilder)localObject1).append("s");
          ((StringBuilder)localObject1).append(this.segmentNum);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append("tr");
          ((StringBuilder)localObject1).append(this.reportTimeTrans);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append("ht");
          ((StringBuilder)localObject1).append(this.reportTimeHt);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append("pic");
          ((StringBuilder)localObject1).append(this.reportTimePicCache);
          ((StringBuilder)localObject1).append(";");
          this.mProcessorReport.mReportInfo.put("param_CostEach", this.costReport.toString());
          this.mProcessorReport.mReportInfo.put("param_sliceNum", String.valueOf(this.segmentNum));
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.remove("param_url");
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        this.mProcessorReport.mReportInfo.put("param_picmd5", this.mFileName);
        this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
        this.mProcessorReport.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
        this.mProcessorReport.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
        this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
    }
  }
  
  protected long getBlockSize(long paramLong)
  {
    return this.toSendPBData.length;
  }
  
  protected String getConnUrl(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.mIpList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localServerAddr.mIp);
    if (localServerAddr.port != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localServerAddr.port);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
  
  public boolean getMd5()
  {
    this.mLocalMd5 = MD5.toMD5Byte(this.toSendData);
    if (this.mLocalMd5 == null)
    {
      this.mProcessorReport.setError(9041, "getMd5 error", null, null);
      return false;
    }
    this.mFileName = HexUtil.bytes2HexStr(this.mLocalMd5);
    this.mMd5Str = this.mFileName;
    this.file.fileMd5 = this.mFileName;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mFileName);
    localStringBuilder.append(".");
    localStringBuilder.append(this.mExtName);
    this.mFileName = localStringBuilder.toString();
    return true;
  }
  
  public byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return this.toSendPBData;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if ((paramRichProtoResp != null) && (paramRichProtoResp.resps != null) && (paramRichProtoResp.resps.size() != 0))
    {
      paramRichProtoReq = paramRichProtoResp.resps.iterator();
      while (paramRichProtoReq.hasNext())
      {
        paramRichProtoResp = (RichProto.RichProtoResp.RespCommon)paramRichProtoReq.next();
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoResp.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoResp);
        paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgUpResp)paramRichProtoResp;
        if (paramRichProtoResp.result == 0)
        {
          this.mResId = paramRichProtoResp.resId;
          this.mUkey = paramRichProtoResp.ukey;
          this.mIpList = paramRichProtoResp.ipList;
          this.mMsgKey = paramRichProtoResp.msgKey;
          this.mSig = paramRichProtoResp.msgSig;
          try
          {
            this.mUUID = new String(this.mResId, "utf-8");
          }
          catch (UnsupportedEncodingException paramRichProtoResp)
          {
            paramRichProtoResp.printStackTrace();
          }
          if (constructToSendData()) {
            sendFile();
          } else {
            onError();
          }
        }
        else
        {
          paramRichProtoReq = this.mProcessorReport;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("upResp.result=");
          localStringBuilder.append(paramRichProtoResp.result);
          paramRichProtoReq.setError(9007, localStringBuilder.toString(), null, null);
          onError();
        }
      }
      return;
    }
    this.mProcessorReport.setError(9006, "resp == null || resp.resps == null || resp.resps.size() == 0", null, null);
    onError();
  }
  
  public void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      localSendResult.b = this.mProcessorReport.errCode;
      localSendResult.c = this.mProcessorReport.errDesc;
      localSendResult.l = Long.valueOf(this.mUiRequest.mUniseq);
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    if (!this.mIsCancel)
    {
      if (this.mIsPause) {
        return;
      }
      this.mNetReq = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      ((StringBuilder)localObject).append(" errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject).append(" errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      logRichMediaEvent("onResp", ((StringBuilder)localObject).toString());
    }
    try
    {
      i = paramNetResp.mResult;
      bool = false;
      if (i == 0)
      {
        this.mNetworkChgRetryCount = 0;
        localObject = paramNetResp.mRespProperties.get("User-ReturnCode");
        if (localObject == null) {}
      }
    }
    catch (Exception paramNetResp)
    {
      int i;
      boolean bool;
      label156:
      long l1;
      long l2;
      break label343;
    }
    try
    {
      i = Integer.parseInt((String)paramNetResp.mRespProperties.get("User-ReturnCode"));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label156;
    }
    i = -2147483648;
    break label167;
    i = 2147483647;
    label167:
    if ((i == 0) || (i == 2147483647)) {
      bool = true;
    }
    this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, bool);
    l1 = SystemClock.uptimeMillis();
    l2 = this.startTime;
    if (bool)
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("Success. SendTotalCost:");
      paramNetResp.append(l1 - l2);
      paramNetResp.append("ms ,fileSize:");
      paramNetResp.append(this.file.fileSize);
      paramNetResp.append(" ,code:");
      paramNetResp.append(i);
      logRichMediaEvent("onResp", paramNetResp.toString());
      onSuccess();
      return;
    }
    this.mProcessorReport.setError(i, "user return code error", null, null);
    onError();
    return;
    this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, false);
    this.mProcessorReport.setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, null, null);
    onError();
    return;
    label343:
    paramNetResp = this.mProcessorReport;
    Object localObject = this.mProcessorReport;
    paramNetResp.setError(9343, ProcessorReport.getExceptionMessage(new Exception("decode unknown exception")), "", this.mProcessorReport.mStepTrans);
    onError();
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    UpCallBack.SendResult localSendResult;
    if (this.mUiRequest.mUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.b = 0;
      localSendResult.e = this.mFileSize;
      localSendResult.g = this.mMd5Str;
      localSendResult.l = Long.valueOf(this.mUiRequest.mUniseq);
    }
    try
    {
      localSendResult.f = new String(this.mResId, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label78:
      StringBuilder localStringBuilder;
      break label78;
    }
    localSendResult.b = -1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed. Convert ResID to UTF-8 string failed, resID = ");
    localStringBuilder.append(this.mResId.toString());
    localSendResult.c = localStringBuilder.toString();
    logRichMediaEvent("onSuccess", localSendResult.c);
    this.mUiRequest.mUpCallBack.b(localSendResult);
    sendMessageToUpdate(1003);
  }
  
  public int resume()
  {
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(1002);
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mUkey = null;
      this.mReqUrlCount = 0;
      this.mTransferedSize = 0L;
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      this.sscmObject.a();
      this.mController.mHandler.post(new MultiMsgUpProcessor.2(this));
    }
    return 0;
  }
  
  public void sendFile()
  {
    if (this.startTime == -1L) {
      this.startTime = SystemClock.uptimeMillis();
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    long l1 = this.mTransferedSize;
    long l2 = getBlockSize(l1);
    Object localObject1 = getStreamData((int)l1, (int)l2);
    if (localObject1 == null)
    {
      onError();
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("pos:");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("  transferData len:");
    ((StringBuilder)localObject2).append(localObject1.length);
    logRichMediaEvent("sendingdata", ((StringBuilder)localObject2).toString());
    if (this.mIsByBDH)
    {
      this.mUUID = UUID.randomUUID().toString();
      localObject1 = AbsDownloader.getFilePath(this.mUUID);
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      FileUtils.writeFile(this.toSendPBData, (String)localObject1);
      this.mLocalPath = ((String)localObject1);
      this.mUiRequest.mLocalPath = this.mLocalPath;
      super.getMd5();
      localObject1 = new MultiMsgUpProcessor.1(this);
      if (!mIsBDHImmediately) {
        i = 27;
      } else {
        i = 77;
      }
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, this.mLocalPath, 0, this.mLocalMd5, (ITransactionCallback)localObject1, null, false);
      int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Multimsg upload file by BDH and retCode = ");
        ((StringBuilder)localObject1).append(i);
        QLog.i("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        this.mProcessorReport.setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
        onError();
      }
    }
    else
    {
      localObject1 = constructHttpNetReq((byte[])localObject1);
      if (l1 + l2 >= this.mFileSize) {
        ((HttpNetReq)localObject1).mReqProperties.put("Connection", "close");
      }
      if (!canDoNextStep()) {
        return;
      }
      this.mNetReq = ((NetReq)localObject1);
      setMtype();
      this.mNetEngine.sendReq((NetReq)localObject1);
    }
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      String str;
      if (UinTypeUtil.b(this.mUinType)) {
        str = "multimsgCu";
      } else if (this.mUinType == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    super.start();
    sendMessageToUpdate(1000);
    byte[] arrayOfByte = this.toSendData;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      if ((this.mLocalMd5 == null) && (!getMd5()))
      {
        onError();
        return;
      }
      sendRequest();
      return;
    }
    this.mProcessorReport.setError(9042, "data is empty", null, null);
    onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgUpProcessor
 * JD-Core Version:    0.7.0.1
 */