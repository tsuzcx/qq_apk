package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import azpp;
import azpq;
import balx;
import baly;
import bamk;
import bdll;
import bdmc;
import bdoc;
import bdod;
import bduh;
import berj;
import berr;
import besx;
import beum;
import beuo;
import beup;
import beur;
import bevl;
import bevm;
import bevx;
import bevy;
import bewa;
import bewk;
import bews;
import bewy;
import beyb;
import beyg;
import beyl;
import bfau;
import bfaw;
import bfbj;
import bfbm;
import bfca;
import bhmi;
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
  extends berj
  implements beup, beur, Runnable
{
  protected bduh a;
  private beyl jdField_a_of_type_Beyl;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long c;
  private long d;
  String e;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  
  public C2CPttDownloadProcessor() {}
  
  public C2CPttDownloadProcessor(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bduh = ((bduh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = bdoc.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      bdod localbdod = (bdod)((Map.Entry)localObject).getValue();
      if (localbdod != null)
      {
        bdoc.a((String)((Map.Entry)localObject).getKey());
        localbdod.a(false);
        localObject = localbdod.a();
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
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString));
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
    if (this.jdField_k_of_type_Int == -9527)
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
          if ((this.jdField_k_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.jdField_f_of_type_Boolean) {
                continue;
              }
              besx.a().a().a(0);
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
        if (this.jdField_k_of_type_Int == 9366) {
          continue;
        }
        i = 1;
        continue;
        besx.a().a(16, this.jdField_f_of_type_JavaLangString);
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
      bdmc localbdmc = bdmc.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localbdmc.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
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
    bevx localbevx;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = str;
      localbevx.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbevx.jdField_c_of_type_Int = 1;
      localbevx.jdField_a_of_type_Int = 30000;
      localbevx.jdField_b_of_type_Int = 1;
      localbevx.jdField_a_of_type_Bevw = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
      return;
      if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbevx);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, 0);
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
      return bews.a(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambevl instanceof beum));
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.jdField_c_of_type_Long;
    } while (0L != parambevl.jdField_b_of_type_Long);
    parambevm.jdField_c_of_type_Long = 0L;
    parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
    parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    a(null, parambevy.a, parambevy.a.getWupBuffer());
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      while (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbm)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.jdField_k_of_type_Boolean = parambfau.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
          if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.startsWith("https://")))
          {
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_Bfci.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_Bete.i = this.jdField_c_of_type_JavaLangString;
          if ((parambfau.jdField_b_of_type_JavaLangString != null) && (parambfau.jdField_b_of_type_JavaLangString.length() > 0)) {
            this.jdField_b_of_type_JavaLangString = parambfau.jdField_b_of_type_JavaLangString;
          }
          this.jdField_a_of_type_JavaUtilArrayList = a(parambfau.jdField_b_of_type_JavaUtilArrayList, parambfau.jdField_a_of_type_JavaUtilArrayList);
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambfau = bews.a(this.jdField_c_of_type_JavaLangString);
            if (parambfau != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambfau);
            }
          }
          if (this.l)
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
    //   1: ldc_w 293
    //   4: ldc_w 519
    //   7: invokevirtual 298	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 522	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 522	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 524
    //   30: new 70	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 526
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 298	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 531	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 532	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 536	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 537	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 540	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 537	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 542	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 543
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 548	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 551	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 548	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 554	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 550	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 558	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 561	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 524
    //   136: new 70	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 563
    //   146: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 298	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 566	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 567
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
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {
      break label17;
    }
    label17:
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    label62:
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject1 = this.jdField_d_of_type_Berr.a(1) + ";" + this.jdField_a_of_type_Berr.a(2) + ";" + this.jdField_b_of_type_Berr.a(3) + ";" + this.jdField_c_of_type_Berr.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label511;
      }
      localObject1 = "1";
      label188:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_trans_consume", String.valueOf(this.jdField_b_of_type_Berr.a()));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(baly.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_Boolean)));
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
        bdmc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, c(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      bamk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_k_of_type_Int, this.jdField_a_of_type_Beyl, (MessageForPtt)localObject1);
      return;
      i = 1;
      break label62;
      localObject1 = "0";
      break label188;
      bool = false;
      break label414;
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bevl instanceof beum))
      {
        localObject1 = bews.a(((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bewy)localObject1).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      bdmc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, c(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.jdField_k_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
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
          bdmc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject1, null);
        }
        if (this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject1 = "0X80059B2";
          localObject2 = (beyl)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, bewa.a(((beyl)localObject2).jdField_a_of_type_Int, ((beyl)localObject2).jdField_b_of_type_Int), 0, "", "", "", "8.4.5");
        }
      }
    }
  }
  
  public void aN_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Beyl.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aN_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 4)
    {
      bewa.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Beyg.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Beyg.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  void b(String paramString)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_Beur = this;
    localbeum.jdField_a_of_type_JavaLangString = paramString;
    if (paramString.startsWith("https://")) {
      localbeum.jdField_f_of_type_Boolean = true;
    }
    localbeum.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbeum.jdField_a_of_type_Long = 0L;
    localbeum.l = true;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbeum.m = true;
    localbeum.jdField_a_of_type_Beup = this;
    localbeum.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbeum.jdField_d_of_type_Boolean = true;
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      localbeum.jdField_c_of_type_Long = 120000L;
      localbeum.jdField_b_of_type_Int = 0;
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
    paramString = bews.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + " downOffset:" + localbeum.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bevl = localbeum;
    o();
    this.jdField_a_of_type_Beuo.a(localbeum);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    Object localObject1 = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.jdField_j_of_type_Boolean = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (bhmi.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Beyl = ((beyl)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Beyg.h == null) || (!bhmi.c(this.jdField_a_of_type_Beyg.i))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_Beyg.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_Beyg.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Beyg.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
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
  
  public void c(bevm parambevm)
  {
    this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambevm, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp != null)
    {
      azpq localazpq = new azpq();
      localazpq.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp.a(localazpq);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Beyg.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Beyg.h;
    }
    if (this.jdField_a_of_type_Bduh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      bdll.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bduh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, 2);
    }
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp != null)
    {
      localObject = new azpq();
      ((azpq)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp.a((azpq)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Berr.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPtt)localObject).storageSource;
      localObject = new bfau();
      bfaw localbfaw = new bfaw();
      localbfaw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
      localbfaw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
      localbfaw.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
      localbfaw.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
      localbfaw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
      localbfaw.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbfaw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Beyg.jdField_c_of_type_Boolean;
      MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localbfaw.jdField_a_of_type_Int = localMessageForPtt.voiceType;
      localbfaw.jdField_c_of_type_Int = localMessageForPtt.autoToText;
      if (1008 == localbfaw.jdField_f_of_type_Int) {
        localbfaw.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localbfaw.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.g;
      ((bfau)localObject).jdField_a_of_type_Bfcb = this;
      ((bfau)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((bfau)localObject).jdField_a_of_type_JavaUtilList.add(localbfaw);
      ((bfau)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
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
        b("requestStart", ((bfau)localObject).toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = ((bfau)localObject);
    bfca.a((bfau)localObject);
  }
  
  void g()
  {
    this.jdField_b_of_type_Berr.a();
    String str = this.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      str = bews.a(str, ((bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(str));
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
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum))) {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    super.onResp(parambevm);
    berr localberr;
    boolean bool;
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      localberr = this.jdField_d_of_type_Berr;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label194;
      }
      bool = true;
      label48:
      b("onHttpResp", bool);
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label199;
      }
      bool = true;
      label73:
      a(localberr, parambevm, bool);
      this.jdField_a_of_type_Long = parambevm.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambevm.jdField_b_of_type_Long + parambevm.jdField_a_of_type_Bevl.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambevm.jdField_c_of_type_Long;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label204;
      }
      h();
      e();
      this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambevm, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      if (this.jdField_f_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bevl = null;
      return;
      localberr = this.jdField_b_of_type_Berr;
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
      if ((parambevm.jdField_b_of_type_Int == 9364) && (this.m < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Bevl = null;
        this.m += 1;
        n();
        f();
        return;
      }
      d();
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bevl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
      this.jdField_a_of_type_Bevl = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */