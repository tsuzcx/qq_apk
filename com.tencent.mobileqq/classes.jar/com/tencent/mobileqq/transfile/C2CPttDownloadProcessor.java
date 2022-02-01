package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import ayxc;
import ayxd;
import azth;
import azti;
import aztu;
import bcst;
import bctj;
import bcvj;
import bcvk;
import bdbq;
import bdsr;
import bdsz;
import bdud;
import bdvs;
import bdvu;
import bdvv;
import bdvx;
import bdws;
import bdwt;
import bdxe;
import bdxf;
import bdxh;
import bdxr;
import bdxz;
import bdyf;
import bdzi;
import bdzn;
import bdzs;
import bebv;
import bebx;
import beck;
import becn;
import bedb;
import bgmg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
  extends bdsr
  implements bdvv, bdvx, Runnable
{
  protected bdbq a;
  private bdzs jdField_a_of_type_Bdzs;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long c;
  private long d;
  String e;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  
  public C2CPttDownloadProcessor(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bdbq = ((bdbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = bcvj.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      bcvk localbcvk = (bcvk)((Map.Entry)localObject).getValue();
      if (localbcvk != null)
      {
        bcvj.a((String)((Map.Entry)localObject).getKey());
        localbcvk.a(false);
        localObject = localbcvk.a();
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
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString));
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
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_f_of_type_JavaLangString != null)
        {
          if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.jdField_f_of_type_Boolean) {
                continue;
              }
              bdud.a().a().a(0);
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
            this.jdField_f_of_type_JavaLangString = null;
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
        bdud.a().a(16, this.jdField_f_of_type_JavaLangString);
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
      bctj localbctj = bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localbctj.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void h()
  {
    b("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.jdField_d_of_type_JavaLangString)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    bdxe localbdxe;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = str;
      localbdxe.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbdxe.jdField_c_of_type_Int = 1;
      localbdxe.jdField_a_of_type_Int = 30000;
      localbdxe.jdField_b_of_type_Int = 1;
      localbdxe.jdField_a_of_type_Bdxd = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
      return;
      if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbdxe);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, 0);
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
  
  public String a(String paramString)
  {
    String str = null;
    if (paramString.startsWith("http://")) {
      str = "http://" + this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      return bdxz.a(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambdws instanceof bdvs));
      parambdws = (bdvs)parambdws;
      parambdws.jdField_a_of_type_Long += parambdwt.jdField_c_of_type_Long;
    } while (0L != parambdws.jdField_b_of_type_Long);
    parambdwt.jdField_c_of_type_Long = 0L;
    parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
    parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    a(null, parambdxf.a, parambdxf.a.getWupBuffer());
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      while (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becn)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
          if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.startsWith("https://")))
          {
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_Bedj.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_Bduk.i = this.jdField_c_of_type_JavaLangString;
          if ((parambebv.jdField_b_of_type_JavaLangString != null) && (parambebv.jdField_b_of_type_JavaLangString.length() > 0)) {
            this.jdField_b_of_type_JavaLangString = parambebv.jdField_b_of_type_JavaLangString;
          }
          this.jdField_a_of_type_JavaUtilArrayList = a(parambebv.jdField_b_of_type_JavaUtilArrayList, parambebv.jdField_a_of_type_JavaUtilArrayList);
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambebv = bdxz.a(this.jdField_c_of_type_JavaLangString);
            if (parambebv != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambebv);
            }
          }
          if (this.jdField_l_of_type_Boolean)
          {
            this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          g();
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
    //   1: ldc_w 291
    //   4: ldc_w 518
    //   7: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 521	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 521	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 523
    //   30: new 67	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 525
    //   40: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 528	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 530	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 531	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 535	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 536	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 539	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 536	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 541	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 542
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 547	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 550	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 547	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 553	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 549	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 557	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 560	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 523
    //   136: new 67	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 562
    //   146: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 528	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 565	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 566
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
    boolean bool = true;
    if ((!paramBoolean) && (bdxr.a(this.jdField_j_of_type_Int))) {
      break label17;
    }
    label17:
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    label62:
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject1 = this.jdField_d_of_type_Bdsz.a(1) + ";" + this.jdField_a_of_type_Bdsz.a(2) + ";" + this.jdField_b_of_type_Bdsz.a(3) + ";" + this.jdField_c_of_type_Bdsz.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label511;
      }
      localObject1 = "1";
      label188:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_trans_consume", String.valueOf(this.jdField_b_of_type_Bdsz.a()));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(azti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_Boolean)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.jdField_a_of_type_Long + " written=" + this.jdField_b_of_type_Long);
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_f_of_type_JavaLangString == null) {
          break label519;
        }
        label414:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label525;
      }
    }
    for (;;)
    {
      try
      {
        b(true, l1);
        bctj.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, c(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        m();
      }
      catch (Exception localException)
      {
        label511:
        long l3;
        label519:
        label525:
        long l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BaseTransProcessor", 2, "report exception =" + localException.toString());
        continue;
        String str = "0X80059B4";
        continue;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      if (localObject1 == null) {
        break;
      }
      aztu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Bdzs, (MessageForPtt)localObject1);
      return;
      i = 1;
      break label62;
      localObject1 = "0";
      break label188;
      bool = false;
      break label414;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bdws instanceof bdvs))
      {
        localObject1 = bdxz.a(((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bdyf)localObject1).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      bctj.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, c(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
      {
        if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)
        {
          localObject1 = new HashMap();
          l3 = System.currentTimeMillis() / 1000L;
          l1 = (this.jdField_d_of_type_Long - this.jdField_c_of_type_Long) / 86400L;
          l2 = (l3 - this.jdField_c_of_type_Long) / 86400L;
          l3 = (l3 - this.jdField_d_of_type_Long) / 86400L;
          ((HashMap)localObject1).put("MsgOff", String.valueOf(l1));
          ((HashMap)localObject1).put("PttOff", String.valueOf(l3));
          ((HashMap)localObject1).put("OutOfTimeReason", String.valueOf(256));
          ((HashMap)localObject1).put("param_FailCode", String.valueOf(l2));
          bctj.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject1, null);
        }
        if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject1 = "0X80059B2";
          localObject2 = (bdzs)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, bdxh.a(((bdzs)localObject2).jdField_a_of_type_Int, ((bdzs)localObject2).jdField_b_of_type_Int), 0, "", "", "", "8.4.1");
        }
      }
    }
  }
  
  public void aN_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Bdzs.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aN_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 4)
    {
      bdxh.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Bdzn.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Bdzn.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  void b(String paramString)
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_Bdvx = this;
    localbdvs.jdField_a_of_type_JavaLangString = paramString;
    if (paramString.startsWith("https://")) {
      localbdvs.jdField_f_of_type_Boolean = true;
    }
    localbdvs.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
    localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    localbdvs.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    localbdvs.jdField_a_of_type_Long = 0L;
    localbdvs.jdField_l_of_type_Boolean = true;
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbdvs.m = true;
    localbdvs.jdField_a_of_type_Bdvv = this;
    localbdvs.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbdvs.jdField_d_of_type_Boolean = true;
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      localbdvs.jdField_c_of_type_Long = 120000L;
      localbdvs.jdField_b_of_type_Int = 0;
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
    paramString = bdxz.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString + " downOffset:" + localbdvs.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bdws = localbdvs;
    o();
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    Object localObject1 = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.jdField_j_of_type_Boolean = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (bgmg.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Bdzs = ((bdzs)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Bdzn.h == null) || (!bgmg.c(this.jdField_a_of_type_Bdzn.i))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_Bdzn.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_Bdzn.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Bdzn.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      if (localObject1 != null)
      {
        localObject2 = new File(this.jdField_e_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        ((File)localObject1).renameTo((File)localObject2);
      }
      return 0;
    }
  }
  
  public String c()
  {
    return "actC2CPttDownload";
  }
  
  public void c(bdwt parambdwt)
  {
    this.jdField_a_of_type_Bedj.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambdwt, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc != null)
    {
      ayxd localayxd = new ayxd();
      localayxd.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc.a(localayxd);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Bdzn.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Bdzn.h;
    }
    if (this.jdField_a_of_type_Bdbq.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      bcst.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bdbq.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, 2);
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc != null)
    {
      localObject = new ayxd();
      ((ayxd)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc.a((ayxd)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Bdsz.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPtt)localObject).storageSource;
      localObject = new bebv();
      bebx localbebx = new bebx();
      localbebx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
      localbebx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
      localbebx.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
      localbebx.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
      localbebx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
      localbebx.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbebx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Boolean;
      MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localbebx.jdField_a_of_type_Int = localMessageForPtt.voiceType;
      localbebx.jdField_c_of_type_Int = localMessageForPtt.autoToText;
      if (1008 == localbebx.jdField_f_of_type_Int) {
        localbebx.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localbebx.jdField_d_of_type_Int = this.jdField_a_of_type_Bdzn.g;
      ((bebv)localObject).jdField_a_of_type_Bedc = this;
      ((bebv)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((bebv)localObject).jdField_a_of_type_JavaUtilList.add(localbebx);
      ((bebv)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
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
        b("requestStart", ((bebv)localObject).toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = ((bebv)localObject);
    bedb.a((bebv)localObject);
  }
  
  void g()
  {
    this.jdField_b_of_type_Bdsz.a();
    String str = this.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      str = bdxz.a(str, ((bdyf)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(str));
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      b(str);
      return;
      str = a(str);
    }
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bdws != null) && ((this.jdField_a_of_type_Bdws instanceof bdvs))) {
      ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    super.onResp(parambdwt);
    bdsz localbdsz;
    boolean bool;
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      localbdsz = this.jdField_d_of_type_Bdsz;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label194;
      }
      bool = true;
      label48:
      b("onHttpResp", bool);
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label199;
      }
      bool = true;
      label73:
      a(localbdsz, parambdwt, bool);
      this.jdField_a_of_type_Long = parambdwt.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambdwt.jdField_b_of_type_Long + parambdwt.jdField_a_of_type_Bdws.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambdwt.jdField_c_of_type_Long;
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label204;
      }
      h();
      e();
      this.jdField_a_of_type_Bedj.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambdwt, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      if (this.jdField_f_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdws = null;
      return;
      localbdsz = this.jdField_b_of_type_Bdsz;
      break;
      label194:
      bool = false;
      break label48;
      label199:
      bool = false;
      break label73;
      label204:
      if (this.jdField_f_of_type_JavaLangString != null)
      {
        b(false);
        return;
      }
      if ((parambdwt.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Bdws = null;
        this.jdField_l_of_type_Int += 1;
        n();
        f();
        return;
      }
      d();
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bdws != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Bdvu.b(this.jdField_a_of_type_Bdws);
      this.jdField_a_of_type_Bdws = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */