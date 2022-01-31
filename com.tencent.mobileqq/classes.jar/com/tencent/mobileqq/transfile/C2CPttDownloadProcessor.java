package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import awiq;
import awir;
import awxs;
import awxt;
import awyf;
import azqs;
import azri;
import azuj;
import azuk;
import baam;
import bara;
import barh;
import basl;
import baub;
import baue;
import bauf;
import bauh;
import bave;
import bavf;
import bavq;
import bavr;
import bavt;
import bawk;
import baws;
import bawy;
import bayf;
import bayk;
import bayp;
import bbax;
import bbaz;
import bbbm;
import bbbp;
import bbcd;
import bdhb;
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
  extends bara
  implements bauf, bauh, Runnable
{
  protected baam a;
  private bayp jdField_a_of_type_Bayp;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  String e;
  private String f;
  
  public C2CPttDownloadProcessor(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Baam = ((baam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = azuj.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      azuk localazuk = (azuk)((Map.Entry)localObject).getValue();
      if (localazuk != null)
      {
        azuj.a((String)((Map.Entry)localObject).getKey());
        localazuk.a(false);
        localObject = localazuk.a();
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
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bayk.e));
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
        if (this.f != null)
        {
          if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              basl.a().a().a(0);
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
        basl.a().a(16, this.f);
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
      azri localazri = azri.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localazri.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
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
    bavq localbavq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = str;
      localbavq.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbavq.jdField_c_of_type_Int = 1;
      localbavq.jdField_a_of_type_Int = 30000;
      localbavq.jdField_b_of_type_Int = 1;
      localbavq.jdField_a_of_type_Bavp = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
      return;
      if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbavq);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, 0);
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
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambave instanceof baub));
      parambave = (baub)parambave;
      parambave.jdField_a_of_type_Long += parambavf.jdField_c_of_type_Long;
    } while (0L != parambave.jdField_b_of_type_Long);
    parambavf.jdField_c_of_type_Long = 0L;
    parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
    parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
  }
  
  public void a(bavf parambavf)
  {
    this.jdField_a_of_type_Bawi.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambavf, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bayk.e);
  }
  
  public void a(bavr parambavr, bavq parambavq)
  {
    a(null, parambavr.a, parambavr.a.getWupBuffer());
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      while (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbp)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.i = parambbax.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = parambbax.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bass.i = this.jdField_c_of_type_JavaLangString;
          if ((parambbax.jdField_b_of_type_JavaLangString != null) && (parambbax.jdField_b_of_type_JavaLangString.length() > 0)) {
            this.jdField_b_of_type_JavaLangString = parambbax.jdField_b_of_type_JavaLangString;
          }
          this.jdField_a_of_type_JavaUtilArrayList = a(parambbax.jdField_b_of_type_JavaUtilArrayList, parambbax.jdField_a_of_type_JavaUtilArrayList);
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambbax = baws.a(this.jdField_c_of_type_JavaLangString);
            if (parambbax != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambbax);
            }
          }
          if (this.jdField_j_of_type_Boolean)
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
    //   4: ldc_w 507
    //   7: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 512
    //   30: new 67	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 514
    //   40: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 519	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 520	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 524	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 525	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 528	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 525	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 530	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 531
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 536	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 539	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 536	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 542	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 538	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 546	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 549	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 512
    //   136: new 67	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 551
    //   146: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 296	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 554	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 555
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
    if ((!paramBoolean) && (bawk.b(this.jdField_j_of_type_Int))) {
      break label17;
    }
    label17:
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
      localObject = this.jdField_d_of_type_Barh.a(1) + ";" + this.jdField_a_of_type_Barh.a(2) + ";" + this.jdField_b_of_type_Barh.a(3) + ";" + this.jdField_c_of_type_Barh.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bayk.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(awxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Boolean)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.jdField_a_of_type_Long + " written=" + this.jdField_b_of_type_Long);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.f == null) {
          break label461;
        }
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
        b(true, l1);
        azri.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        l();
      }
      catch (Exception localException)
      {
        label461:
        label467:
        long l3;
        long l2;
        bayp localbayp;
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
      awyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Bayp, (MessageForPtt)localObject);
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
      if ((this.jdField_a_of_type_Bave instanceof baub))
      {
        localObject = baws.a(((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bawy)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      azri.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
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
          azri.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
        }
        if (this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject = "0X80059B2";
          localbayp = (bayp)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, bavt.a(localbayp.jdField_a_of_type_Int, localbayp.jdField_b_of_type_Int), 0, "", "", "", "8.3.5");
        }
      }
    }
  }
  
  public void aP_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Bayp.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aP_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 4)
    {
      bavt.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Bayk.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Bayk.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  public String b()
  {
    return "actC2CPttDownload";
  }
  
  void b(String paramString)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_Bauh = this;
    localbaub.jdField_a_of_type_JavaLangString = paramString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbaub.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
    localbaub.e = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbaub.g = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbaub.f = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = 0L;
    localbaub.k = true;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbaub.l = true;
    localbaub.jdField_a_of_type_Bauf = this;
    localbaub.jdField_d_of_type_JavaLangString = this.e;
    localbaub.jdField_d_of_type_Boolean = true;
    if (this.f != null)
    {
      localbaub.jdField_c_of_type_Long = 120000L;
      localbaub.jdField_c_of_type_Int = 0;
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
    paramString = baws.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Bayk.e + " downOffset:" + localbaub.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bave = localbaub;
    n();
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    Object localObject1 = this.jdField_a_of_type_Bayk.e;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.h = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (bdhb.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Bayp = ((bayp)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Bayk.h == null) || (!bdhb.c(this.jdField_a_of_type_Bayk.i))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_Bayk.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_Bayk.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.e = (this.jdField_a_of_type_Bayk.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
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
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq != null)
    {
      awir localawir = new awir();
      localawir.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq.a(localawir);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Bayk.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Bayk.e;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_Bayk.e != null) && (this.jdField_a_of_type_Bayk.e.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Bayk.h;
    }
    if (this.jdField_a_of_type_Baam.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      azqs.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Baam.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, 2);
    }
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq != null)
    {
      localObject = new awir();
      ((awir)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq.a((awir)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Barh.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPtt)localObject).storageSource;
      localObject = new bbax();
      bbaz localbbaz = new bbaz();
      localbbaz.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
      localbbaz.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
      localbbaz.e = this.jdField_a_of_type_Bayk.jdField_d_of_type_JavaLangString;
      localbbaz.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
      localbbaz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bayk.e;
      localbbaz.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbbaz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bayk.jdField_b_of_type_Boolean;
      MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localbbaz.jdField_a_of_type_Int = localMessageForPtt.voiceType;
      localbbaz.jdField_c_of_type_Int = localMessageForPtt.autoToText;
      if (1008 == localbbaz.f) {
        localbbaz.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localbbaz.jdField_d_of_type_Int = this.jdField_a_of_type_Bayk.g;
      ((bbax)localObject).jdField_a_of_type_Bbce = this;
      ((bbax)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((bbax)localObject).jdField_a_of_type_JavaUtilList.add(localbbaz);
      ((bbax)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
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
        b("requestStart", ((bbax)localObject).toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = ((bbax)localObject);
    bbcd.a((bbax)localObject);
  }
  
  void g()
  {
    this.jdField_b_of_type_Barh.a();
    String str = this.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      str = baws.a(str, ((bawy)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(str));
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      b(str);
      basl.a().a().a(baws.a(str), 0);
      return;
      str = a(str);
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bave != null) && ((this.jdField_a_of_type_Bave instanceof baub))) {
      ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bavf parambavf)
  {
    super.onResp(parambavf);
    barh localbarh;
    boolean bool;
    if (this.f != null)
    {
      localbarh = this.jdField_d_of_type_Barh;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label194;
      }
      bool = true;
      label48:
      b("onHttpResp", bool);
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label199;
      }
      bool = true;
      label73:
      a(localbarh, parambavf, bool);
      this.jdField_a_of_type_Long = parambavf.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambavf.jdField_b_of_type_Long + parambavf.jdField_a_of_type_Bave.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambavf.jdField_c_of_type_Long;
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label204;
      }
      h();
      e();
      this.jdField_a_of_type_Bawi.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambavf, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bayk.e);
      if (this.f != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bave = null;
      return;
      localbarh = this.jdField_b_of_type_Barh;
      break;
      label194:
      bool = false;
      break label48;
      label199:
      bool = false;
      break label73;
      label204:
      if (this.f != null)
      {
        b(false);
        return;
      }
      if ((parambavf.jdField_b_of_type_Int == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Bave = null;
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
    if (this.jdField_a_of_type_Bave != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.f);
      }
      this.jdField_a_of_type_Baue.b(this.jdField_a_of_type_Bave);
      this.jdField_a_of_type_Bave = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */