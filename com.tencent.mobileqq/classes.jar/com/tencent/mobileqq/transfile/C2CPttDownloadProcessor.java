package com.tencent.mobileqq.transfile;

import atpa;
import atpb;
import auco;
import aucp;
import audb;
import awqx;
import awrn;
import awuc;
import awud;
import axaf;
import axoo;
import axow;
import axpy;
import axro;
import axrr;
import axrs;
import axsp;
import axsq;
import axtb;
import axtc;
import axte;
import axtt;
import axub;
import axuh;
import axvo;
import axvt;
import axvy;
import axyg;
import axyi;
import axyv;
import axyy;
import axzm;
import bace;
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
  extends axoo
  implements axrs, Runnable
{
  protected axaf a;
  private axvy jdField_a_of_type_Axvy;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  String e;
  private String f;
  
  public C2CPttDownloadProcessor(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Axaf = ((axaf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = awuc.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      awud localawud = (awud)((Map.Entry)localObject).getValue();
      if (localawud != null)
      {
        awuc.a((String)((Map.Entry)localObject).getKey());
        localawud.a(false);
        localObject = localawud.a();
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
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Axvt.e));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.jdField_d_of_type_JavaLangString)) {
        i = j;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_j_of_type_Int == -9527)
    {
      bool1 = bool2;
      if (this.jdField_i_of_type_JavaLangString != null) {
        if (!this.jdField_i_of_type_JavaLangString.equals("H_400_-5103017"))
        {
          bool1 = bool2;
          if (!this.jdField_i_of_type_JavaLangString.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.f != null)
        {
          if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_i_of_type_JavaLangString != null) && (this.jdField_i_of_type_JavaLangString.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              axpy.a().a().a(0);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "c2c directDownloadIfCan error");
            }
            if (!paramBoolean) {
              break label160;
            }
            f(4);
            if (!a()) {
              break label168;
            }
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = 2005L;
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
            d();
            this.f = null;
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
        axpy.a().a(16, this.f);
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
  
  private void f(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      awrn localawrn = awrn.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localawrn.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void h()
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
      label149:
      label288:
      while (j != 0)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan for c2c pttUrl: " + localMessageForPtt.directUrl);
        }
        Object localObject2 = axpy.a().a();
        Object localObject1 = localObject2;
        boolean bool;
        if (localObject2 == null)
        {
          localObject1 = axpy.a().a().a(0);
          if (localObject1 != null)
          {
            bool = true;
            this.jdField_c_of_type_Boolean = bool;
          }
        }
        else
        {
          if (!this.jdField_j_of_type_Boolean) {
            break label288;
          }
        }
        for (localObject2 = "http://grouptalk.c2c.qq.com/";; localObject2 = localObject1)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for c2c ipStr: " + (String)localObject1);
          }
          localObject1 = axub.a(localMessageForPtt.directUrl, (String)localObject2);
          this.f = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for c2c: " + (String)localObject1);
          }
          this.jdField_d_of_type_Axow.a();
          b((String)localObject1);
          ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
          j = 1;
          i = 1;
          break;
          bool = false;
          break label149;
          if (localObject1 == null)
          {
            if (!QLog.isDevelopLevel()) {
              break label351;
            }
            QLog.e("SPD", 4, "directDownloadIfCan for c2c no ip error " + localMessageForPtt.directUrl);
            i = 1;
            break;
          }
        }
      }
      f(2);
      return;
      label351:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  private void o()
  {
    b("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.jdField_d_of_type_JavaLangString)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    axtb localaxtb;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = str;
      localaxtb.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localaxtb.jdField_c_of_type_Int = 1;
      localaxtb.jdField_a_of_type_Int = 30000;
      localaxtb.jdField_b_of_type_Int = 1;
      localaxtb.jdField_a_of_type_Axta = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
      return;
      if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localaxtb);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, 0);
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
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaxsp instanceof axro));
      paramaxsp = (axro)paramaxsp;
      paramaxsp.jdField_a_of_type_Long += paramaxsq.jdField_c_of_type_Long;
    } while (0L != paramaxsp.jdField_b_of_type_Long);
    paramaxsq.jdField_c_of_type_Long = 0L;
    paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
    paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
  }
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    a(null, paramaxtc.a, paramaxtc.a.getWupBuffer());
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axyy)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.jdField_i_of_type_Boolean = paramaxyg.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_i_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Axqf.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          if ((paramaxyg.jdField_b_of_type_JavaLangString != null) && (paramaxyg.jdField_b_of_type_JavaLangString.length() > 0)) {
            this.jdField_b_of_type_JavaLangString = paramaxyg.jdField_b_of_type_JavaLangString;
          }
          if ((g()) && (paramaxyg.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramaxyg.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              paramaxyg = axub.a(this.jdField_c_of_type_JavaLangString);
              if (paramaxyg != null) {
                this.jdField_a_of_type_JavaUtilArrayList.add(paramaxyg);
              }
            }
            if (this.jdField_j_of_type_Boolean)
            {
              this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
              this.jdField_a_of_type_JavaUtilArrayList.clear();
            }
            g();
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        d();
      }
    }
  }
  
  /* Error */
  protected void a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 351
    //   4: ldc_w 547
    //   7: invokevirtual 356	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 550	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 550	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 552
    //   30: new 65	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 554
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 356	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 559	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 560	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 564	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 565	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 565	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 570	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 571
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 576	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 579	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 576	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 582	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 578	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 586	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 589	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 552
    //   136: new 65	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 591
    //   146: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 356	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 594	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 595
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
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (axtt.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    label59:
    long l1;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject = this.jdField_d_of_type_Axow.a(1) + ";" + this.jdField_a_of_type_Axow.a(2) + ";" + this.jdField_b_of_type_Axow.a(3) + ";" + this.jdField_c_of_type_Axow.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Axvt.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(aucp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Boolean)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.jdField_a_of_type_Long + " written=" + this.jdField_b_of_type_Long);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.f == null) {
          break label461;
        }
        bool = true;
        label364:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label467;
      }
    }
    for (;;)
    {
      try
      {
        awrn.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        b(paramBoolean, l1);
        l();
      }
      catch (Exception localException)
      {
        label461:
        label467:
        long l4;
        long l2;
        long l3;
        axvy localaxvy;
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
      audb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Axvy, (MessageForPtt)localObject);
      return;
      i = 1;
      break label59;
      bool = false;
      break label364;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_i_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Axsp instanceof axro))
      {
        localObject = axub.a(((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((axuh)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      awrn.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_i_of_type_JavaLangString != null) && (this.jdField_i_of_type_JavaLangString.equals("H_400_-5103017")))
      {
        if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)
        {
          localObject = new HashMap();
          l4 = System.currentTimeMillis() / 1000L;
          l2 = (this.jdField_d_of_type_Long - this.jdField_c_of_type_Long) / 86400L;
          l3 = (l4 - this.jdField_c_of_type_Long) / 86400L;
          l4 = (l4 - this.jdField_d_of_type_Long) / 86400L;
          ((HashMap)localObject).put("MsgOff", String.valueOf(l2));
          ((HashMap)localObject).put("PttOff", String.valueOf(l4));
          ((HashMap)localObject).put("OutOfTimeReason", String.valueOf(256));
          ((HashMap)localObject).put("param_FailCode", String.valueOf(l3));
          awrn.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
        }
        if (this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject = "0X80059B2";
          localaxvy = (axvy)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, axte.a(localaxvy.jdField_a_of_type_Int, localaxvy.jdField_b_of_type_Int), 0, "", "", "", "8.2.6");
        }
      }
    }
  }
  
  public void aU_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Axvy.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aU_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 0)
    {
      i = 1;
      axte.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Axvt.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Axvt.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      if (!g()) {
        break label137;
      }
      f();
    }
    label137:
    do
    {
      return;
      i = 4;
      break;
      if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 0) && (aucp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        h();
      }
    } while (this.f != null);
    f();
  }
  
  public String b()
  {
    return "actC2CPttDownload";
  }
  
  void b(String paramString)
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = this;
    localaxro.jdField_a_of_type_JavaLangString = paramString;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localaxro.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
    localaxro.e = String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    localaxro.g = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxro.f = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
    localaxro.jdField_a_of_type_Long = 0L;
    localaxro.k = true;
    localaxro.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localaxro.l = true;
    localaxro.jdField_a_of_type_Axrs = this;
    localaxro.jdField_d_of_type_JavaLangString = this.e;
    localaxro.jdField_d_of_type_Boolean = true;
    if (this.f != null)
    {
      localaxro.jdField_c_of_type_Long = 120000L;
      localaxro.jdField_c_of_type_Int = 0;
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
    paramString = axub.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Axvt.e + " downOffset:" + localaxro.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Axsp = localaxro;
    n();
    this.jdField_a_of_type_Axrr.a(localaxro);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    Object localObject1 = this.jdField_a_of_type_Axvt.e;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.h = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (bace.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Axvy = ((axvy)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Axvt.h == null) || (!bace.c(this.jdField_a_of_type_Axvt.jdField_i_of_type_JavaLangString))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_Axvt.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_Axvt.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.e = (this.jdField_a_of_type_Axvt.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      if (localObject1 != null)
      {
        localObject2 = new File(this.e);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        ((File)localObject1).renameTo((File)localObject2);
      }
      return 0;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa != null)
    {
      atpb localatpb = new atpb();
      localatpb.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa.a(localatpb);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Axvt.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Axvt.e;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_Axvt.e != null) && (this.jdField_a_of_type_Axvt.e.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Axvt.h;
    }
    if (this.jdField_a_of_type_Axaf.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      awqx.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Axaf.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, 2);
    }
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa != null)
    {
      localObject = new atpb();
      ((atpb)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa.a((atpb)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Axow.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPtt)localObject).storageSource;
      localObject = new axyg();
      axyi localaxyi = new axyi();
      localaxyi.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
      localaxyi.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
      localaxyi.e = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
      localaxyi.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
      localaxyi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Axvt.e;
      localaxyi.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localaxyi.jdField_a_of_type_Boolean = this.jdField_a_of_type_Axvt.jdField_b_of_type_Boolean;
      MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localaxyi.jdField_a_of_type_Int = localMessageForPtt.voiceType;
      localaxyi.jdField_c_of_type_Int = localMessageForPtt.autoToText;
      if (1008 == localaxyi.f) {
        localaxyi.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localaxyi.jdField_d_of_type_Int = this.jdField_a_of_type_Axvt.g;
      ((axyg)localObject).jdField_a_of_type_Axzn = this;
      ((axyg)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((axyg)localObject).jdField_a_of_type_JavaUtilList.add(localaxyi);
      ((axyg)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    label284:
    do
    {
      return;
      this.jdField_d_of_type_JavaLangString = "pttcenter";
      b("findDbRec", "not found");
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", ((axyg)localObject).toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = ((axyg)localObject);
    axzm.a((axyg)localObject);
  }
  
  void g()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    this.jdField_b_of_type_Axow.a();
    String str = this.jdField_c_of_type_JavaLangString;
    axuh localaxuh;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (str.startsWith("http://")) {
        if ((localaxuh.jdField_a_of_type_Boolean) && (!localaxuh.jdField_a_of_type_JavaLangString.startsWith("[")))
        {
          localObject1 = "http://[" + localaxuh.jdField_a_of_type_JavaLangString + "]";
          if (localaxuh.jdField_a_of_type_Int == 80) {
            break label315;
          }
          localObject1 = (String)localObject1 + ":" + localaxuh.jdField_a_of_type_Int + "/";
          label154:
          localObject1 = axub.a(str, (String)localObject1);
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
      }
    }
    for (;;)
    {
      b((String)localObject1);
      axpy.a().a().a(axub.a((String)localObject1), 0);
      return;
      localObject1 = "http://" + localaxuh.jdField_a_of_type_JavaLangString;
      break;
      localObject1 = localObject2;
      if (!str.startsWith("https://")) {
        break;
      }
      localObject1 = localObject2;
      if (localaxuh.jdField_a_of_type_JavaLangString.startsWith("[")) {
        break;
      }
      if (localaxuh.jdField_a_of_type_Boolean)
      {
        localObject1 = "https://[" + localaxuh.jdField_a_of_type_JavaLangString + "]";
        break;
      }
      localObject1 = "https://" + localaxuh.jdField_a_of_type_JavaLangString;
      break;
      label315:
      localObject1 = (String)localObject1 + "/";
      break label154;
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        if (str.startsWith("http://")) {
          localObject1 = "http://" + this.jdField_b_of_type_JavaLangString;
        }
        for (;;)
        {
          localObject1 = axub.a(str, (String)localObject1 + "/");
          break;
          if (str.startsWith("https://")) {
            localObject1 = "https://" + this.jdField_b_of_type_JavaLangString;
          }
        }
      }
      localObject1 = str;
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Axsp != null) && ((this.jdField_a_of_type_Axsp instanceof axro))) {
      ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool2 = true;
    super.onResp(paramaxsq);
    axow localaxow;
    boolean bool1;
    if (this.f != null)
    {
      localaxow = this.jdField_d_of_type_Axow;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label172;
      }
      bool1 = true;
      label51:
      b("onHttpResp", bool1);
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label177;
      }
      bool1 = bool2;
      label76:
      a(localaxow, paramaxsq, bool1);
      this.jdField_a_of_type_Long = paramaxsq.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaxsq.jdField_b_of_type_Long + paramaxsq.jdField_a_of_type_Axsp.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramaxsq.jdField_c_of_type_Long;
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label182;
      }
      o();
      e();
      if (this.f != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axsp = null;
      return;
      localaxow = this.jdField_b_of_type_Axow;
      break;
      label172:
      bool1 = false;
      break label51;
      label177:
      bool1 = false;
      break label76;
      label182:
      if (this.f != null)
      {
        b(false);
        return;
      }
      if ((paramaxsq.jdField_b_of_type_Int == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Axsp = null;
        this.l += 1;
        m();
        f();
        return;
      }
      d();
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Axsp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.f);
      }
      this.jdField_a_of_type_Axrr.b(this.jdField_a_of_type_Axsp);
      this.jdField_a_of_type_Axsp = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */