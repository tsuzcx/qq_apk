package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamFileInfo;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class C2CPttDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.IBreakDownFix, Runnable
{
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private TransferRequest.PttDownExtraInfo jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  String f;
  private String g;
  
  public C2CPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = StreamDataManager.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      StreamFileInfo localStreamFileInfo = (StreamFileInfo)((Map.Entry)localObject).getValue();
      if (localStreamFileInfo != null)
      {
        StreamDataManager.a((String)((Map.Entry)localObject).getKey());
        localStreamFileInfo.a(false);
        localObject = localStreamFileInfo.a();
        if ((localObject != null) && (((File)localObject).exists())) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.e)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.e)) {
        i = j;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.g != null)
        {
          if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              FMTSrvAddrProvider.a().a().a(0);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "c2c directDownloadIfCan error");
            }
            if (!paramBoolean) {
              break label160;
            }
            f(4);
            if (!e()) {
              break label168;
            }
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = 2005L;
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
            d();
            this.g = null;
          }
        }
        else {
          return;
        }
        if (this.jdField_j_of_type_Int == 9366) {
          continue;
        }
        i = 1;
        continue;
        FMTSrvAddrProvider.a().a(16, this.g);
        continue;
        f(3);
      }
      finally {}
      label160:
      continue;
      label168:
      f();
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_j_of_type_Int == -9527)
    {
      bool1 = bool2;
      if (this.jdField_j_of_type_JavaLangString != null) {
        if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017"))
        {
          bool1 = bool2;
          if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector localStatisticCollector = StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localStatisticCollector.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void p()
  {
    int k = 1;
    int j = 0;
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    int i;
    if (localMessageForPtt.directUrl != null) {
      if (localMessageForPtt.directUrl.length() == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        i = k;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSendFromLocal()) {
          i = 11;
        }
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getPttStreamFlag() == 10001) {
          j = i + 100;
        }
        f(j);
      }
      label201:
      label207:
      while (j != 0)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan for c2c pttUrl: " + localMessageForPtt.directUrl);
        }
        String str2 = FMTSrvAddrProvider.a().a();
        String str1 = str2;
        if (str2 == null)
        {
          str1 = FMTSrvAddrProvider.a().a().a(0);
          if (str1 == null) {
            break label201;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.jdField_c_of_type_Boolean = bool;
          if (str1 != null) {
            break label207;
          }
          if (!QLog.isDevelopLevel()) {
            break label332;
          }
          QLog.e("SPD", 4, "directDownloadIfCan for c2c no ip error " + localMessageForPtt.directUrl);
          i = 1;
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan for c2c ipStr: " + str1);
        }
        str1 = RichMediaUtil.a(localMessageForPtt.directUrl, str1);
        this.g = str1;
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan for c2c: " + str1);
        }
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        b(str1);
        ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
        j = 1;
        i = 1;
        break;
      }
      f(2);
      return;
      label332:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  private void q()
  {
    b("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.e)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    ProtoReqManager.ProtoReq localProtoReq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = str;
      localProtoReq.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localProtoReq.jdField_c_of_type_Int = 1;
      localProtoReq.jdField_a_of_type_Int = 30000;
      localProtoReq.jdField_b_of_type_Int = 1;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      if (c()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if ("ftn".equals(this.e)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localProtoReq);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, 0);
      return paramMessageForPtt;
    }
    catch (Exception localException)
    {
      do
      {
        paramMessageForPtt = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("BaseTransProcessor", 2, "updatedb", localException);
    }
    return null;
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.jdField_c_of_type_Long;
    } while (0L != paramNetReq.jdField_b_of_type_Long);
    paramNetResp.jdField_c_of_type_Long = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.a(paramNetResp);
    BaseTransProcessor.StepInfo localStepInfo;
    boolean bool1;
    if (this.g != null)
    {
      localStepInfo = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label172;
      }
      bool1 = true;
      label51:
      b("onHttpResp", bool1);
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label177;
      }
      bool1 = bool2;
      label76:
      a(localStepInfo, paramNetResp, bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramNetResp.jdField_c_of_type_Long;
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label182;
      }
      q();
      e();
      if (this.g != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
      localStepInfo = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      break;
      label172:
      bool1 = false;
      break label51;
      label177:
      bool1 = false;
      break label76;
      label182:
      if (this.g != null)
      {
        b(false);
        return;
      }
      if ((paramNetResp.jdField_b_of_type_Int == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
        this.l += 1;
        m();
        f();
        return;
      }
      d();
    }
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    a(null, paramProtoResp.a, paramProtoResp.a.getWupBuffer());
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.e;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = this.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            paramRichProtoReq = RichMediaUtil.a(this.jdField_c_of_type_JavaLangString);
            if (paramRichProtoReq != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(paramRichProtoReq);
            }
          }
          o();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  /* Error */
  protected void a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 341
    //   4: ldc_w 566
    //   7: invokevirtual 346	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 569	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 569	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 571
    //   30: new 60	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 573
    //   40: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 576	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 346	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 578	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 579	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 583	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 584	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 587	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 584	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 589	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 590
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 595	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 598	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 595	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 601	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 597	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 605	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 608	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 571
    //   136: new 60	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 610
    //   146: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 576	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 346	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 613	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 614
    //   170: lstore 5
    //   172: goto -83 -> 89
    //   175: astore_1
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	C2CPttDownloadProcessor
    //   0	177	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	177	2	paramFromServiceMsg	FromServiceMsg
    //   0	177	3	paramArrayOfByte	byte[]
    //   24	126	4	i	int
    //   87	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   55	63	161	java/lang/Exception
    //   69	89	161	java/lang/Exception
    //   98	160	161	java/lang/Exception
    //   63	69	175	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {
      break label17;
    }
    label17:
    while ((this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    label62:
    long l1;
    Object localObject;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Boolean)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.jdField_a_of_type_Long + " written=" + this.jdField_b_of_type_Long);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.g == null) {
          break label453;
        }
        label364:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label459;
      }
    }
    for (;;)
    {
      try
      {
        StatisticCollector.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPttDownload", true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        l();
      }
      catch (Exception localException)
      {
        label453:
        label459:
        long l3;
        long l2;
        TransferRequest.PttDownExtraInfo localPttDownExtraInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BaseTransProcessor", 2, "report exception =" + localException.toString());
        continue;
        String str = "0X80059B4";
        continue;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      if (localObject == null) {
        break;
      }
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo, (MessageForPtt)localObject);
      return;
      i = 1;
      break label62;
      bool = false;
      break label364;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
      {
        localObject = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ServerAddr)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      StatisticCollector.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPttDownload", false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
      {
        if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)
        {
          localObject = new HashMap();
          l3 = System.currentTimeMillis() / 1000L;
          l1 = (this.jdField_d_of_type_Long - this.jdField_c_of_type_Long) / 86400L;
          l2 = (l3 - this.jdField_c_of_type_Long) / 86400L;
          l3 = (l3 - this.jdField_d_of_type_Long) / 86400L;
          ((HashMap)localObject).put("MsgOff", String.valueOf(l1));
          ((HashMap)localObject).put("PttOff", String.valueOf(l3));
          ((HashMap)localObject).put("OutOfTimeReason", String.valueOf(256));
          ((HashMap)localObject).put("param_FailCode", String.valueOf(l2));
          StatisticCollector.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject = "0X80059B2";
          localPttDownExtraInfo = (TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, PttInfoCollector.a(localPttDownExtraInfo.jdField_a_of_type_Int, localPttDownExtraInfo.jdField_b_of_type_Int), 0, "", "", "", "7.6.0");
        }
      }
    }
  }
  
  public void an_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.an_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 4)
    {
      PttInfoCollector.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 0) && (PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        p();
      }
      if (this.g == null) {
        f();
      }
      return;
    }
  }
  
  void b(String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localHttpNetReq.e = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.g = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    localHttpNetReq.k = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.l = false;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_d_of_type_JavaLangString = this.f;
    localHttpNetReq.jdField_d_of_type_Boolean = true;
    if (this.g != null)
    {
      localHttpNetReq.jdField_c_of_type_Long = 120000L;
      localHttpNetReq.jdField_c_of_type_Int = 0;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        localObject1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    paramString = RichMediaUtil.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!d()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    n();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.i = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (FileUtils.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo = ((TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.f = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      if (localObject1 != null)
      {
        localObject2 = new File(this.f);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        ((File)localObject1).renameTo((File)localObject2);
      }
      return 0;
    }
  }
  
  void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
      return;
    }
    d(2005);
  }
  
  void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      localObject = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a((DownCallBack.DownResult)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.e = ((MessageForPtt)localObject).storageSource;
      localObject = new RichProto.RichProtoReq();
      RichProto.RichProtoReq.C2CPttDownReq localC2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
      localC2CPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      localC2CPttDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      localC2CPttDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
      localC2CPttDownReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localC2CPttDownReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
      localC2CPttDownReq.jdField_b_of_type_JavaLangString = this.e;
      localC2CPttDownReq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Boolean;
      localC2CPttDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
      if (1008 == localC2CPttDownReq.f) {
        localC2CPttDownReq.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localC2CPttDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_JavaUtilList.add(localC2CPttDownReq);
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (c()) {
        break label274;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label274:
    do
    {
      return;
      this.e = "pttcenter";
      b("findDbRec", "not found");
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", ((RichProto.RichProtoReq)localObject).toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = ((RichProto.RichProtoReq)localObject);
    RichProtoProc.a((RichProto.RichProtoReq)localObject);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
  }
  
  void o()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str = a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    b(str);
    FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(str), 0);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.g);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */