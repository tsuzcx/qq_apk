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
  private static int seq = 0;
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
    if (this.toSendData != null) {}
    for (this.mFileSize = paramTransferRequest.toSendData.length;; this.mFileSize = 0L) {
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
  }
  
  private boolean constructToSendData()
  {
    Object localObject1 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject1).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.mUiRequest.mPeerUin).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.toSendData));
    if (!mIsBDHImmediately) {
      ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.mUkey));
    }
    ((LongMsg.MsgUpReq)localObject1).uint32_store_type.set(2);
    if (this.mUiRequest.isJubaoMsgType) {
      ((LongMsg.MsgUpReq)localObject1).uint32_msg_type.set(17);
    }
    for (;;)
    {
      localObject2 = new LongMsg.ReqBody();
      ((LongMsg.ReqBody)localObject2).setHasFlag(true);
      ((LongMsg.ReqBody)localObject2).uint32_subcmd.set(1);
      ((LongMsg.ReqBody)localObject2).uint32_term_type.set(5);
      ((LongMsg.ReqBody)localObject2).uint32_platform_type.set(9);
      ((LongMsg.ReqBody)localObject2).rpt_msg_up_req.add((MessageMicro)localObject1);
      ((LongMsg.ReqBody)localObject2).uint32_busi_type.set(this.mUiRequest.upMsgBusiType);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsgUpProcessor", 4, "constructToSendData called(). upMsgBusiType = " + this.mUiRequest.upMsgBusiType);
      }
      if ((this.mIsByBDH) && (this.multiMsgType == 0)) {
        ((LongMsg.ReqBody)localObject2).uint32_agent_type.set(1);
      }
      this.toSendPBData = ((LongMsg.ReqBody)localObject2).toByteArray();
      if (!this.mIsByBDH) {
        break;
      }
      return true;
      ((LongMsg.MsgUpReq)localObject1).uint32_msg_type.set(convertMsgType(this.mUinType));
    }
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject2).toByteArray(), this.mMsgKey);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.mSig));
    localObject1 = new String();
    int i = 0;
    while (i < "8.5.5".length())
    {
      localObject2 = localObject1;
      if ("8.5.5".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("8.5.5".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = new im_msg_head.HttpConnHead();
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
      setError(9360, "constructToSendData() dos.write()");
    }
    return false;
  }
  
  public static int convertMsgType(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 1: 
    case 3000: 
      return i;
    case 1040: 
      return 15;
    }
    return 255;
  }
  
  private static int getSeq()
  {
    int i = seq;
    seq = i + 1;
    return i;
  }
  
  private void sendRequest()
  {
    this.mStepUrl.logStartTime();
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
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          logRichMediaEvent("requestStart", localRichProtoReq.toString());
        }
      } while (!canDoNextStep());
      this.mRichProtoReq = localRichProtoReq;
    } while (!mIsBDHImmediately);
    if (constructToSendData())
    {
      sendFile();
      return;
    }
    onError();
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    if ((this.toSendData == null) || (0L >= this.mFileSize) || (0L == this.selfUin)) {
      return -1;
    }
    this.mExtName = "";
    return 0;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    int i = 2;
    String str = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.mUiRequest.mBusiType == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) || (this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    long l;
    if (paramBoolean)
    {
      this.mReportedFlag = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mReportInfo.put("param_step", str);
      this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      if (!paramBoolean) {
        break label425;
      }
      if ((this.reportTimeTrans <= 0L) || (this.reportTimePicCache <= 0L)) {
        break label420;
      }
      i = 1;
      label244:
      if ((this.isReportValid) && (i != 0))
      {
        this.costReport = new StringBuilder();
        this.costReport.append("s").append(this.segmentNum).append("_").append("tr").append(this.reportTimeTrans).append("_").append("ht").append(this.reportTimeHt).append("_").append("pic").append(this.reportTimePicCache).append(";");
        this.mReportInfo.put("param_CostEach", this.costReport.toString());
        this.mReportInfo.put("param_sliceNum", String.valueOf(this.segmentNum));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label420:
      i = 0;
      break label244;
      label425:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.remove("param_url");
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picmd5", this.mFileName);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", false, l, this.mFileSize, this.mReportInfo, "");
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
      setError(9041, "getMd5 error");
      return false;
    }
    this.mFileName = HexUtil.bytes2HexStr(this.mLocalMd5);
    this.mMd5Str = this.mFileName;
    this.file.fileMd5 = this.mFileName;
    this.mFileName = (this.mFileName + "." + this.mExtName);
    return true;
  }
  
  public byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return this.toSendPBData;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if ((paramRichProtoResp == null) || (paramRichProtoResp.resps == null) || (paramRichProtoResp.resps.size() == 0))
    {
      setError(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      onError();
    }
    for (;;)
    {
      return;
      paramRichProtoReq = paramRichProtoResp.resps.iterator();
      while (paramRichProtoReq.hasNext())
      {
        paramRichProtoResp = (RichProto.RichProtoResp.RespCommon)paramRichProtoReq.next();
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoResp.toString());
        }
        copyRespCommon(this.mStepUrl, paramRichProtoResp);
        paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgUpResp)paramRichProtoResp;
        if (paramRichProtoResp.result != 0) {
          break label197;
        }
        this.mResId = paramRichProtoResp.resId;
        this.mUkey = paramRichProtoResp.ukey;
        this.mIpList = paramRichProtoResp.ipList;
        this.mMsgKey = paramRichProtoResp.msgKey;
        this.mSig = paramRichProtoResp.msgSig;
        try
        {
          this.mUUID = new String(this.mResId, "utf-8");
          if (constructToSendData()) {
            sendFile();
          }
        }
        catch (UnsupportedEncodingException paramRichProtoResp)
        {
          for (;;)
          {
            paramRichProtoResp.printStackTrace();
          }
          onError();
        }
      }
    }
    label197:
    setError(9007, "upResp.result=" + paramRichProtoResp.result);
    onError();
  }
  
  public void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.errCode;
      localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
      localSendResult.jdField_a_of_type_JavaLangObject = Long.valueOf(this.mUiRequest.mUniseq);
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  /* Error */
  public void onResp(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 790	com/tencent/mobileqq/transfile/BaseUploadProcessor:onResp	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   5: aload_0
    //   6: getfield 793	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mIsCancel	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 796	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mIsPause	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 800	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   25: aload_0
    //   26: ldc_w 801
    //   29: new 207	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 803
    //   39: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 808	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   46: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 810
    //   52: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 813	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   59: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 815
    //   65: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 818	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   72: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 451	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: getfield 808	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 821	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mNetworkChgRetryCount	I
    //   93: aload_1
    //   94: getfield 824	com/tencent/mobileqq/transfile/NetResp:mRespProperties	Ljava/util/HashMap;
    //   97: ldc_w 826
    //   100: invokevirtual 828	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +162 -> 269
    //   110: aload_1
    //   111: getfield 824	com/tencent/mobileqq/transfile/NetResp:mRespProperties	Ljava/util/HashMap;
    //   114: ldc_w 826
    //   117: invokevirtual 828	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 260	java/lang/String
    //   123: invokestatic 307	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +10 -> 138
    //   131: iload_2
    //   132: ldc_w 829
    //   135: if_icmpne +141 -> 276
    //   138: iconst_1
    //   139: istore_3
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 484	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mStepTrans	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   145: aload_1
    //   146: iload_3
    //   147: invokevirtual 833	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:copyStatisInfoFromNetResp	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   150: invokestatic 838	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 51	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:startTime	J
    //   159: lstore 6
    //   161: iload_3
    //   162: ifeq +119 -> 281
    //   165: aload_0
    //   166: ldc_w 801
    //   169: new 207	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 840
    //   179: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 4
    //   184: lload 6
    //   186: lsub
    //   187: invokevirtual 565	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 842
    //   193: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 682	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   200: getfield 845	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   203: invokevirtual 565	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 847
    //   209: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 451	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 850	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:onSuccess	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: sipush 9343
    //   232: new 44	java/lang/Exception
    //   235: dup
    //   236: ldc_w 852
    //   239: invokespecial 855	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   242: invokestatic 861	com/tencent/mobileqq/transfile/BaseTransProcessor:getExceptionMessage	(Ljava/lang/Exception;)Ljava/lang/String;
    //   245: ldc_w 471
    //   248: aload_0
    //   249: getfield 484	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mStepTrans	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   252: invokevirtual 441	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:setError	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   255: aload_0
    //   256: invokevirtual 444	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:onError	()V
    //   259: return
    //   260: astore 8
    //   262: ldc_w 862
    //   265: istore_2
    //   266: goto -139 -> 127
    //   269: ldc_w 829
    //   272: istore_2
    //   273: goto -146 -> 127
    //   276: iconst_0
    //   277: istore_3
    //   278: goto -138 -> 140
    //   281: aload_0
    //   282: iload_2
    //   283: ldc_w 864
    //   286: invokevirtual 367	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:setError	(ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 444	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:onError	()V
    //   293: return
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 484	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:mStepTrans	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   299: aload_1
    //   300: iconst_0
    //   301: invokevirtual 833	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:copyStatisInfoFromNetResp	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   304: aload_0
    //   305: aload_1
    //   306: getfield 813	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   309: aload_1
    //   310: getfield 818	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   313: invokevirtual 367	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:setError	(ILjava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 444	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:onError	()V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	MultiMsgUpProcessor
    //   0	321	1	paramNetResp	NetResp
    //   126	157	2	i	int
    //   139	139	3	bool	boolean
    //   153	30	4	l1	long
    //   159	26	6	l2	long
    //   103	3	8	localObject	Object
    //   260	1	8	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   81	105	227	java/lang/Exception
    //   110	127	227	java/lang/Exception
    //   140	161	227	java/lang/Exception
    //   165	226	227	java/lang/Exception
    //   281	293	227	java/lang/Exception
    //   294	320	227	java/lang/Exception
    //   110	127	260	java/lang/NumberFormatException
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    UpCallBack.SendResult localSendResult;
    if (this.mUiRequest.mUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.b = 0;
      localSendResult.jdField_a_of_type_Long = this.mFileSize;
      localSendResult.d = this.mMd5Str;
      localSendResult.jdField_a_of_type_JavaLangObject = Long.valueOf(this.mUiRequest.mUniseq);
    }
    try
    {
      localSendResult.c = new String(this.mResId, "UTF-8");
      this.mUiRequest.mUpCallBack.b(localSendResult);
      sendMessageToUpdate(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localSendResult.b = -1;
        localSendResult.jdField_a_of_type_JavaLangString = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.mResId.toString());
        logRichMediaEvent("onSuccess", localSendResult.jdField_a_of_type_JavaLangString);
      }
    }
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
      this.errCode = 0;
      this.errDesc = "";
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
    this.mStepTrans.logStartTime();
    long l1 = this.mTransferedSize;
    long l2 = getBlockSize(l1);
    Object localObject = getStreamData((int)l1, (int)l2);
    if (localObject == null) {
      onError();
    }
    do
    {
      int i;
      do
      {
        return;
        logRichMediaEvent("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
        if (!this.mIsByBDH) {
          break;
        }
        this.mUUID = UUID.randomUUID().toString();
        localObject = AbsDownloader.getFilePath(this.mUUID);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        FileUtils.a(this.toSendPBData, (String)localObject);
        this.mLocalPath = ((String)localObject);
        this.mUiRequest.mLocalPath = this.mLocalPath;
        super.getMd5();
        localObject = new MultiMsgUpProcessor.1(this);
        i = 77;
        if (!mIsBDHImmediately) {
          i = 27;
        }
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, this.mLocalPath, 0, this.mLocalMd5, (ITransactionCallback)localObject, null, false);
        i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
          QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and retCode = " + i);
        }
      } while (i == 0);
      setError(i, "SubmitError.", "", this.mStepTrans);
      onError();
      return;
      localObject = constructHttpNetReq((byte[])localObject);
      if (l1 + l2 >= this.mFileSize) {
        ((HttpNetReq)localObject).mReqProperties.put("Connection", "close");
      }
    } while (!canDoNextStep());
    this.mNetReq = ((NetReq)localObject);
    setMtype();
    this.mNetEngine.sendReq((NetReq)localObject);
  }
  
  protected void setMtype()
  {
    String str;
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      if (!UinTypeUtil.b(this.mUinType)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
      return;
      label56:
      if (this.mUinType == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
    }
  }
  
  public void start()
  {
    super.start();
    sendMessageToUpdate(1000);
    if ((this.toSendData == null) || (this.toSendData.length == 0))
    {
      setError(9042, "data is empty");
      onError();
      return;
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgUpProcessor
 * JD-Core Version:    0.7.0.1
 */