package com.tencent.mobileqq.transfile;

import aumy;
import aumz;
import avbu;
import avbv;
import avch;
import axqw;
import axrl;
import axue;
import axuf;
import ayah;
import ayou;
import aypb;
import ayqf;
import ayrv;
import ayry;
import ayrz;
import aysb;
import aysw;
import aysx;
import ayti;
import aytj;
import aytl;
import ayua;
import ayui;
import ayuo;
import ayvv;
import aywa;
import aywf;
import ayyn;
import ayyp;
import ayzc;
import ayzf;
import ayzt;
import bbdj;
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
  extends ayou
  implements ayrz, aysb, Runnable
{
  protected ayah a;
  private aywf jdField_a_of_type_Aywf;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  String e;
  private String f;
  
  public C2CPttDownloadProcessor(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Ayah = ((ayah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private File a(long paramLong1, long paramLong2)
  {
    Object localObject = axue.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      axuf localaxuf = (axuf)((Map.Entry)localObject).getValue();
      if (localaxuf != null)
      {
        axue.a((String)((Map.Entry)localObject).getKey());
        localaxuf.a(false);
        localObject = localaxuf.a();
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
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Aywa.e));
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
              ayqf.a().a().a(0);
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
        ayqf.a().a(16, this.f);
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
      axrl localaxrl = axrl.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localaxrl.a(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
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
        Object localObject2 = ayqf.a().a();
        Object localObject1 = localObject2;
        boolean bool;
        if (localObject2 == null)
        {
          localObject1 = ayqf.a().a().a(0);
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
          localObject1 = ayui.a(localMessageForPtt.directUrl, (String)localObject2);
          this.f = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for c2c: " + (String)localObject1);
          }
          this.jdField_d_of_type_Aypb.a();
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
    ayti localayti;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = str;
      localayti.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localayti.jdField_c_of_type_Int = 1;
      localayti.jdField_a_of_type_Int = 30000;
      localayti.jdField_b_of_type_Int = 1;
      localayti.jdField_a_of_type_Ayth = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
      return;
      if ("ftn".equals(this.jdField_d_of_type_JavaLangString)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localayti);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, 0);
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
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysw instanceof ayrv));
      paramaysw = (ayrv)paramaysw;
      paramaysw.jdField_a_of_type_Long += paramaysx.jdField_c_of_type_Long;
    } while (0L != paramaysw.jdField_b_of_type_Long);
    paramaysx.jdField_c_of_type_Long = 0L;
    paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
    paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
  }
  
  public void a(aysx paramaysx)
  {
    a(paramaysx, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywa.f, this.jdField_a_of_type_Aywa.e);
  }
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    a(null, paramaytj.a, paramaytj.a.getWupBuffer());
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayzf)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (paramayyn.jdField_c_of_type_Int == 0)
        {
          this.jdField_c_of_type_JavaLangString = paramayyn.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Ayqm.i = this.jdField_c_of_type_JavaLangString;
          if ((paramayyn.jdField_b_of_type_JavaLangString != null) && (paramayyn.jdField_b_of_type_JavaLangString.length() > 0)) {
            this.jdField_b_of_type_JavaLangString = paramayyn.jdField_b_of_type_JavaLangString;
          }
          if ((g()) && (paramayyn.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramayyn.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (;;)
          {
            if (this.jdField_b_of_type_JavaLangString != null)
            {
              paramayyn = new ayuo();
              paramayyn.jdField_b_of_type_Boolean = true;
              paramayyn.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
            }
            if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              paramayyn = ayui.a(this.jdField_c_of_type_JavaLangString);
              if (paramayyn != null) {
                this.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
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
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_a_of_type_JavaUtilArrayList;
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
    //   1: ldc_w 352
    //   4: ldc_w 563
    //   7: invokevirtual 357	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 566	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 566	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 568
    //   30: new 67	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 570
    //   40: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 357	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 575	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 576	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 580	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 581	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 584	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 581	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 586	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 587
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 592	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 595	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 592	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 598	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 594	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 602	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 605	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 568
    //   136: new 67	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 607
    //   146: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 357	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 610	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 611
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
    if ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int))) {
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
      localObject = this.jdField_d_of_type_Aypb.a(1) + ";" + this.jdField_a_of_type_Aypb.a(2) + ";" + this.jdField_b_of_type_Aypb.a(3) + ";" + this.jdField_c_of_type_Aypb.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Aywa.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Boolean)));
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
        axrl.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
        aywf localaywf;
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
      avch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Aywf, (MessageForPtt)localObject);
      return;
      i = 1;
      break label59;
      bool = false;
      break label364;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Aysw instanceof ayrv))
      {
        localObject = ayui.a(((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ayuo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      axrl.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.jdField_j_of_type_Int == -9527) && (this.jdField_j_of_type_JavaLangString != null) && (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
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
          axrl.a(com.tencent.qphone.base.util.BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
        }
        if (this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject != null)
        {
          if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int != 0) {
            continue;
          }
          localObject = "0X80059B2";
          localaywf = (aywf)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, aytl.a(localaywf.jdField_a_of_type_Int, localaywf.jdField_b_of_type_Int), 0, "", "", "", "8.2.8");
        }
      }
    }
  }
  
  public void aR_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Aywf.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aR_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 0)
    {
      i = 1;
      aytl.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Aywa.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Aywa.h;
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
      if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 0) && (avbv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
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
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_Aysb = this;
    localayrv.jdField_a_of_type_JavaLangString = paramString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localayrv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.h;
    localayrv.e = String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    localayrv.g = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayrv.f = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
    localayrv.jdField_a_of_type_Long = 0L;
    localayrv.k = true;
    localayrv.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localayrv.l = true;
    localayrv.jdField_a_of_type_Ayrz = this;
    localayrv.jdField_d_of_type_JavaLangString = this.e;
    localayrv.jdField_d_of_type_Boolean = true;
    if (this.f != null)
    {
      localayrv.jdField_c_of_type_Long = 120000L;
      localayrv.jdField_c_of_type_Int = 0;
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
    paramString = ayui.a(paramString);
    b("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Aywa.e + " downOffset:" + localayrv.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Aysw = localayrv;
    n();
    this.jdField_a_of_type_Ayry.a(localayrv);
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    Object localObject1 = this.jdField_a_of_type_Aywa.e;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.h = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (bbdj.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + (String)localObject1)));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Aywf = ((aywf)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Aywa.h == null) || (!bbdj.c(this.jdField_a_of_type_Aywa.i))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.jdField_a_of_type_Aywa.h = a("c2c", (String)localObject1, i);; this.jdField_a_of_type_Aywa.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath)
    {
      this.e = (this.jdField_a_of_type_Aywa.h + "~tmp");
      localObject1 = a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid, this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
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
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy != null)
    {
      aumz localaumz = new aumz();
      localaumz.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy.a(localaumz);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Aywa.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Aywa.e;
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (this.jdField_a_of_type_Aywa.e != null) && (this.jdField_a_of_type_Aywa.e.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Aywa.h;
    }
    if (this.jdField_a_of_type_Ayah.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt))
    {
      axqw.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Ayah.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, 2);
    }
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy != null)
    {
      localObject = new aumz();
      ((aumz)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy.a((aumz)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Aypb.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPtt)localObject).storageSource;
      localObject = new ayyn();
      ayyp localayyp = new ayyp();
      localayyp.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
      localayyp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
      localayyp.e = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
      localayyp.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
      localayyp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aywa.e;
      localayyp.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localayyp.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aywa.jdField_b_of_type_Boolean;
      MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localayyp.jdField_a_of_type_Int = localMessageForPtt.voiceType;
      localayyp.jdField_c_of_type_Int = localMessageForPtt.autoToText;
      if (1008 == localayyp.f) {
        localayyp.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.busiType;
      }
      localayyp.jdField_d_of_type_Int = this.jdField_a_of_type_Aywa.g;
      ((ayyn)localObject).jdField_a_of_type_Ayzu = this;
      ((ayyn)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((ayyn)localObject).jdField_a_of_type_JavaUtilList.add(localayyp);
      ((ayyn)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
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
        b("requestStart", ((ayyn)localObject).toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = ((ayyn)localObject);
    ayzt.a((ayyn)localObject);
  }
  
  void g()
  {
    this.jdField_b_of_type_Aypb.a();
    String str = this.jdField_c_of_type_JavaLangString;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      str = ayui.a(str, ((ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(str));
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    for (;;)
    {
      b(str);
      ayqf.a().a().a(ayui.a(str), 0);
      return;
      if (this.jdField_b_of_type_JavaLangString != null) {
        str = a(str);
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Aysw != null) && ((this.jdField_a_of_type_Aysw instanceof ayrv))) {
      ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    super.onResp(paramaysx);
    aypb localaypb;
    boolean bool;
    if (this.f != null)
    {
      localaypb = this.jdField_d_of_type_Aypb;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label190;
      }
      bool = true;
      label48:
      b("onHttpResp", bool);
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label195;
      }
      bool = true;
      label73:
      a(localaypb, paramaysx, bool);
      this.jdField_a_of_type_Long = paramaysx.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaysx.jdField_b_of_type_Long + paramaysx.jdField_a_of_type_Aysw.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramaysx.jdField_c_of_type_Long;
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label200;
      }
      o();
      e();
      a(paramaysx, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywa.f, this.jdField_a_of_type_Aywa.e);
      if (this.f != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aysw = null;
      return;
      localaypb = this.jdField_b_of_type_Aypb;
      break;
      label190:
      bool = false;
      break label48;
      label195:
      bool = false;
      break label73;
      label200:
      if (this.f != null)
      {
        b(false);
        return;
      }
      if ((paramaysx.jdField_b_of_type_Int == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Aysw = null;
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
    if (this.jdField_a_of_type_Aysw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.f);
      }
      this.jdField_a_of_type_Ayry.b(this.jdField_a_of_type_Aysw);
      this.jdField_a_of_type_Aysw = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */