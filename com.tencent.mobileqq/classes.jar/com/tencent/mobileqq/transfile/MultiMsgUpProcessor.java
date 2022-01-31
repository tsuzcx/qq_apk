package com.tencent.mobileqq.transfile;

import aicf;
import aicg;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
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
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
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
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public class MultiMsgUpProcessor
  extends BaseUploadProcessor
{
  private static int jdField_c_of_type_Int;
  public int a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
  public boolean a;
  private int jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private SSCM jdField_b_of_type_ComTencentWsttSSCMSSCM = new SSCM();
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private byte[] g;
  
  public MultiMsgUpProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfByte = paramTransferRequest.jdField_b_of_type_ArrayOfByte;
    this.jdField_a_of_type_Int = paramTransferRequest.h;
    if (this.jdField_b_of_type_ArrayOfByte != null) {}
    for (this.jdField_q_of_type_Long = paramTransferRequest.jdField_b_of_type_ArrayOfByte.length;; this.jdField_q_of_type_Long = 0L) {
      try
      {
        this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
        return;
      }
      catch (Exception paramTransFileController)
      {
        paramTransFileController.printStackTrace();
        this.jdField_a_of_type_Long = 0L;
      }
    }
  }
  
  private static int d()
  {
    int i = jdField_c_of_type_Int;
    jdField_c_of_type_Int = i + 1;
    return i;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.MultiMsgUpReq localMultiMsgUpReq = new RichProto.RichProtoReq.MultiMsgUpReq();
    localMultiMsgUpReq.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localMultiMsgUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localMultiMsgUpReq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localMultiMsgUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localMultiMsgUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localMultiMsgUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localMultiMsgUpReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "multi_msg_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localMultiMsgUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  private boolean g()
  {
    Object localObject1 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject1).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.jdField_e_of_type_ArrayOfByte));
    ((LongMsg.MsgUpReq)localObject1).uint32_store_type.set(2);
    Object localObject2 = new LongMsg.ReqBody();
    ((LongMsg.ReqBody)localObject2).setHasFlag(true);
    ((LongMsg.ReqBody)localObject2).uint32_subcmd.set(1);
    ((LongMsg.ReqBody)localObject2).uint32_term_type.set(5);
    ((LongMsg.ReqBody)localObject2).uint32_platform_type.set(9);
    ((LongMsg.ReqBody)localObject2).rpt_msg_up_req.add((MessageMicro)localObject1);
    this.jdField_c_of_type_ArrayOfByte = ((LongMsg.ReqBody)localObject2).toByteArray();
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject2).toByteArray(), this.f);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.g));
    localObject1 = new String();
    int i = 0;
    while (i < "7.6.0".length())
    {
      localObject2 = localObject1;
      if ("7.6.0".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("7.6.0".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject2 = new im_msg_head.HttpConnHead();
    ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(this.jdField_a_of_type_Long);
    ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
    ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(1291);
    ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(d());
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
      this.jdField_c_of_type_ArrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsgUpProcessor", 2, localException.getMessage());
      }
      b(9360, "constructToSendData() dos.write()");
    }
    return false;
  }
  
  protected long a(long paramLong)
  {
    return this.jdField_c_of_type_ArrayOfByte.length;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localServerAddr.jdField_a_of_type_Int);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 416	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   5: aload_0
    //   6: getfield 419	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_o_of_type_Boolean	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 422	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_k_of_type_Boolean	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 425	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   25: aload_0
    //   26: ldc_w 427
    //   29: new 383	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 429
    //   39: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 432	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   46: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 434
    //   52: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 435	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   59: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 437
    //   65: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 438	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 159	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: getfield 432	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 441	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_l_of_type_Int	I
    //   93: aload_1
    //   94: getfield 444	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   97: ldc_w 446
    //   100: invokevirtual 451	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +162 -> 269
    //   110: aload_1
    //   111: getfield 444	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   114: ldc_w 446
    //   117: invokevirtual 451	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 273	java/lang/String
    //   123: invokestatic 318	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +10 -> 138
    //   131: iload_2
    //   132: ldc_w 452
    //   135: if_icmpne +141 -> 276
    //   138: iconst_1
    //   139: istore_3
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 454	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   145: aload_1
    //   146: iload_3
    //   147: invokevirtual 457	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   150: invokestatic 462	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 28	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_b_of_type_Long	J
    //   159: lstore 6
    //   161: iload_3
    //   162: ifeq +119 -> 281
    //   165: aload_0
    //   166: ldc_w 427
    //   169: new 383	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 464
    //   179: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 4
    //   184: lload 6
    //   186: lsub
    //   187: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 469
    //   193: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 472	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   200: getfield 475	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   203: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 477
    //   209: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 159	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 479	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:e	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: sipush 9343
    //   232: new 21	java/lang/Exception
    //   235: dup
    //   236: ldc_w 481
    //   239: invokespecial 484	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   242: invokestatic 489	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   245: ldc_w 491
    //   248: aload_0
    //   249: getfield 454	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   252: invokevirtual 143	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   255: aload_0
    //   256: invokevirtual 145	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:d	()V
    //   259: return
    //   260: astore 8
    //   262: ldc_w 492
    //   265: istore_2
    //   266: goto -139 -> 127
    //   269: ldc_w 452
    //   272: istore_2
    //   273: goto -146 -> 127
    //   276: iconst_0
    //   277: istore_3
    //   278: goto -138 -> 140
    //   281: aload_0
    //   282: iload_2
    //   283: ldc_w 494
    //   286: invokevirtual 379	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:b	(ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 145	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:d	()V
    //   293: return
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 454	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   299: aload_1
    //   300: iconst_0
    //   301: invokevirtual 457	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   304: aload_0
    //   305: aload_1
    //   306: getfield 435	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   309: aload_1
    //   310: getfield 438	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 379	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:b	(ILjava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 145	com/tencent/mobileqq/transfile/MultiMsgUpProcessor:d	()V
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if ((paramRichProtoResp == null) || (paramRichProtoResp.jdField_a_of_type_JavaUtilList == null) || (paramRichProtoResp.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      b(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      d();
    }
    for (;;)
    {
      return;
      paramRichProtoReq = paramRichProtoResp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramRichProtoReq.hasNext())
      {
        paramRichProtoResp = (RichProto.RichProtoResp.RespCommon)paramRichProtoReq.next();
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoResp.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoResp);
        paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgUpResp)paramRichProtoResp;
        if (paramRichProtoResp.jdField_c_of_type_Int != 0) {
          break label197;
        }
        this.jdField_d_of_type_ArrayOfByte = paramRichProtoResp.jdField_a_of_type_ArrayOfByte;
        this.jdField_e_of_type_ArrayOfByte = paramRichProtoResp.jdField_b_of_type_ArrayOfByte;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoResp.jdField_a_of_type_JavaUtilArrayList;
        this.f = paramRichProtoResp.jdField_c_of_type_ArrayOfByte;
        this.g = paramRichProtoResp.jdField_d_of_type_ArrayOfByte;
        try
        {
          this.jdField_b_of_type_JavaLangString = new String(this.jdField_d_of_type_ArrayOfByte, "utf-8");
          if (g()) {
            al_();
          }
        }
        catch (UnsupportedEncodingException paramRichProtoResp)
        {
          for (;;)
          {
            paramRichProtoResp.printStackTrace();
          }
          d();
        }
      }
    }
    label197:
    b(9007, "upResp.result=" + paramRichProtoResp.jdField_c_of_type_Int);
    d();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = 2;
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) || (this.i) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    long l;
    if (paramBoolean)
    {
      this.jdField_m_of_type_Int = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      if (!paramBoolean) {
        break label426;
      }
      if ((this.jdField_n_of_type_Long <= 0L) || (this.jdField_o_of_type_Long <= 0L)) {
        break label421;
      }
      i = 1;
      label245:
      if ((this.p) && (i != 0))
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_n_of_type_Int).append("_").append("tr").append(this.jdField_n_of_type_Long).append("_").append("ht").append(this.jdField_m_of_type_Long).append("_").append("pic").append(this.jdField_o_of_type_Long).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.jdField_n_of_type_Int));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label421:
      i = 0;
      break label245;
      label426:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public void al_()
  {
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l1 = this.jdField_s_of_type_Long;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      d();
    }
    do
    {
      int i;
      do
      {
        return;
        b("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = AbsDownloader.d(this.jdField_b_of_type_JavaLangString);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        FileUtils.a(this.jdField_c_of_type_ArrayOfByte, (String)localObject);
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i = this.jdField_a_of_type_JavaLangString;
        super.e();
        localObject = new aicf(this);
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 27, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject, null, false);
        i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.i("TAG_MultiMsg", 2, "Multimsg upload file by BDH and retCode = " + i);
        }
      } while (i == 0);
      a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.jdField_q_of_type_Long) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
    n();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
  }
  
  public void an_()
  {
    super.an_();
    d(1000);
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length == 0))
    {
      b(9042, "data is empty");
      d();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      d();
      return;
    }
    f();
  }
  
  public int b()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_o_of_type_Boolean = false;
      d(1002);
      this.jdField_s_of_type_Int = 0;
      this.r = 0;
      this.jdField_e_of_type_ArrayOfByte = null;
      this.jdField_q_of_type_Int = 0;
      this.jdField_s_of_type_Long = 0L;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new aicg(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (0L >= this.jdField_q_of_type_Long) || (0L == this.jdField_a_of_type_Long)) {
      return -1;
    }
    this.jdField_e_of_type_JavaLangString = "";
    return 0;
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localSendResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public void e()
  {
    super.e();
    UpCallBack.SendResult localSendResult;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_b_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    try
    {
      localSendResult.jdField_c_of_type_JavaLangString = new String(this.jdField_d_of_type_ArrayOfByte, "UTF-8");
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      d(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localSendResult.jdField_b_of_type_Int = -1;
        localSendResult.jdField_a_of_type_JavaLangString = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.jdField_d_of_type_ArrayOfByte.toString());
        b("onSuccess", localSendResult.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean e()
  {
    this.jdField_a_of_type_ArrayOfByte = MD5.toMD5Byte(this.jdField_b_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      b(9041, "getMd5 error");
      return false;
    }
    this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_d_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
    return true;
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.jdField_b_of_type_Int)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label56:
      if (this.jdField_b_of_type_Int == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgUpProcessor
 * JD-Core Version:    0.7.0.1
 */