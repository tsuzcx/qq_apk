package com.tencent.mobileqq.transfile;

import aiqx;
import aiqy;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.NetFailedListener
{
  static HashSet a;
  private INetEngine.IBreakDownFix b;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private String f;
  private String g;
  private String l;
  int o;
  private int p;
  private int q;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ShortVideoDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aiqy(this);
    paramTransFileController = paramTransferRequest.i;
    if (paramTransFileController != null)
    {
      String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramTransferRequest.h = arrayOfString[0];
      this.g = arrayOfString[1];
      this.f = (this.g + paramTransferRequest.jdField_b_of_type_Int + paramTransferRequest.jdField_a_of_type_Long);
      this.p = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.q = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean e()
  {
    if ((ProgressiveUtils.a.get()) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.supportProgressive)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "isSupportProgressive() : " + bool);
      }
      return bool;
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.f);
    return super.a();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      paramNetReq = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramNetReq.hasNext()) {
        ((DownCallBack)paramNetReq.next()).a(i, false);
      }
    }
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 219	com/tencent/mobileqq/transfile/BaseDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   11: new 79	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   18: ldc 221
    //   20: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 223	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: ldc 225
    //   32: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore 9
    //   37: aload_1
    //   38: getfield 229	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   41: ifne +589 -> 630
    //   44: iconst_1
    //   45: istore 4
    //   47: aload_0
    //   48: ldc 231
    //   50: aload 9
    //   52: iload 4
    //   54: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 234	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +87 -> 153
    //   69: ldc 77
    //   71: iconst_2
    //   72: new 79	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   79: ldc 236
    //   81: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: getfield 229	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   88: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: ldc 77
    //   99: iconst_2
    //   100: new 79	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   107: ldc 238
    //   109: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: getfield 239	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   116: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: ldc 77
    //   127: iconst_2
    //   128: new 79	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   135: ldc 241
    //   137: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: getfield 243	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +35 -> 191
    //   159: ldc 77
    //   161: iconst_2
    //   162: new 79	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   169: ldc 245
    //   171: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: getfield 248	com/tencent/mobileqq/transfile/NetResp:j	J
    //   178: ldc2_w 249
    //   181: ldiv
    //   182: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: getfield 223	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Boolean	Z
    //   195: ifeq +441 -> 636
    //   198: aload_0
    //   199: getfield 253	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   202: astore 9
    //   204: aload_1
    //   205: getfield 229	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   208: ifne +437 -> 645
    //   211: iconst_1
    //   212: istore 4
    //   214: aload_0
    //   215: aload 9
    //   217: aload_1
    //   218: iload 4
    //   220: invokevirtual 256	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   223: aload_0
    //   224: aload_1
    //   225: getfield 257	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Long	J
    //   228: putfield 258	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   231: aload_0
    //   232: getfield 258	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   235: lconst_0
    //   236: lcmp
    //   237: ifgt +19 -> 256
    //   240: aload_0
    //   241: aload_1
    //   242: getfield 260	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Long	J
    //   245: aload_1
    //   246: getfield 263	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   249: getfield 266	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_Long	J
    //   252: ladd
    //   253: putfield 258	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   256: aload_0
    //   257: aload_0
    //   258: getfield 267	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   261: aload_1
    //   262: getfield 268	com/tencent/mobileqq/transfile/NetResp:jdField_c_of_type_Long	J
    //   265: ladd
    //   266: putfield 267	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   269: aload_0
    //   270: aload_1
    //   271: getfield 270	com/tencent/mobileqq/transfile/NetResp:g	J
    //   274: putfield 42	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_c_of_type_Long	J
    //   277: aload_0
    //   278: aload_1
    //   279: getfield 272	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   282: putfield 44	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_o_of_type_Int	I
    //   285: aload_1
    //   286: getfield 229	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   289: ifne +520 -> 809
    //   292: aload_0
    //   293: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   296: getfield 273	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   299: astore 10
    //   301: aload 10
    //   303: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +686 -> 992
    //   309: aload_0
    //   310: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   313: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   316: astore 9
    //   318: new 281	java/io/FileInputStream
    //   321: dup
    //   322: aload 9
    //   324: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   327: astore 9
    //   329: aload 9
    //   331: aload 9
    //   333: invokevirtual 285	java/io/FileInputStream:available	()I
    //   336: i2l
    //   337: invokestatic 291	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   340: astore 11
    //   342: aload 11
    //   344: ifnull +643 -> 987
    //   347: aload_0
    //   348: aload 11
    //   350: invokestatic 297	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   353: putfield 38	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 38	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   360: aload 10
    //   362: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   365: ifne +622 -> 987
    //   368: aload_0
    //   369: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   372: getfield 108	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   375: bipush 6
    //   377: if_icmpeq +27 -> 404
    //   380: aload_0
    //   381: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   384: getfield 108	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   387: bipush 9
    //   389: if_icmpeq +15 -> 404
    //   392: aload_0
    //   393: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   396: getfield 108	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   399: bipush 17
    //   401: if_icmpne +586 -> 987
    //   404: aload_0
    //   405: ldc_w 301
    //   408: ldc_w 303
    //   411: invokevirtual 306	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	(ILjava/lang/String;)V
    //   414: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +43 -> 460
    //   420: ldc 77
    //   422: iconst_2
    //   423: new 79	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 308
    //   433: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 10
    //   438: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc_w 310
    //   444: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_0
    //   448: getfield 38	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   451: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: iconst_0
    //   461: istore_2
    //   462: iload_2
    //   463: istore_3
    //   464: aload 9
    //   466: ifnull +10 -> 476
    //   469: aload 9
    //   471: invokevirtual 313	java/io/FileInputStream:close	()V
    //   474: iload_2
    //   475: istore_3
    //   476: aload_0
    //   477: getfield 316	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   480: astore 9
    //   482: iload_3
    //   483: ifeq +299 -> 782
    //   486: iconst_1
    //   487: istore_2
    //   488: aload 9
    //   490: ldc_w 318
    //   493: iload_2
    //   494: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   497: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: aload_0
    //   502: invokespecial 132	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()Z
    //   505: ifeq +104 -> 609
    //   508: new 330	java/io/File
    //   511: dup
    //   512: aload_0
    //   513: getfield 331	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   516: getfield 333	com/tencent/mobileqq/transfile/NetReq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   522: astore 9
    //   524: new 330	java/io/File
    //   527: dup
    //   528: aload_0
    //   529: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   532: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   535: invokespecial 334	java/io/File:<init>	(Ljava/lang/String;)V
    //   538: astore 10
    //   540: aload 9
    //   542: aload 10
    //   544: invokestatic 339	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   547: pop
    //   548: iload 6
    //   550: istore 4
    //   552: iload 4
    //   554: istore 5
    //   556: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +50 -> 609
    //   562: ldc 77
    //   564: iconst_2
    //   565: new 79	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 341
    //   575: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 145	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   582: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   585: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc_w 343
    //   591: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: iload 4
    //   596: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: iload 4
    //   607: istore 5
    //   609: iload 5
    //   611: ifne +13 -> 624
    //   614: aload_0
    //   615: invokevirtual 345	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()V
    //   618: aload_0
    //   619: aload_1
    //   620: iconst_1
    //   621: invokevirtual 348	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   624: aload_0
    //   625: aconst_null
    //   626: putfield 331	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   629: return
    //   630: iconst_0
    //   631: istore 4
    //   633: goto -586 -> 47
    //   636: aload_0
    //   637: getfield 350	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   640: astore 9
    //   642: goto -438 -> 204
    //   645: iconst_0
    //   646: istore 4
    //   648: goto -434 -> 214
    //   651: astore 9
    //   653: iload_2
    //   654: istore_3
    //   655: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq -182 -> 476
    //   661: ldc 77
    //   663: iconst_2
    //   664: ldc_w 352
    //   667: aload 9
    //   669: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   672: iload_2
    //   673: istore_3
    //   674: goto -198 -> 476
    //   677: astore 10
    //   679: aconst_null
    //   680: astore 9
    //   682: iconst_1
    //   683: istore_2
    //   684: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +14 -> 701
    //   690: ldc 77
    //   692: iconst_2
    //   693: ldc_w 352
    //   696: aload 10
    //   698: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: iload_2
    //   702: istore_3
    //   703: aload 9
    //   705: ifnull -229 -> 476
    //   708: aload 9
    //   710: invokevirtual 313	java/io/FileInputStream:close	()V
    //   713: iload_2
    //   714: istore_3
    //   715: goto -239 -> 476
    //   718: astore 9
    //   720: iload_2
    //   721: istore_3
    //   722: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq -249 -> 476
    //   728: ldc 77
    //   730: iconst_2
    //   731: ldc_w 352
    //   734: aload 9
    //   736: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   739: iload_2
    //   740: istore_3
    //   741: goto -265 -> 476
    //   744: astore_1
    //   745: aconst_null
    //   746: astore 9
    //   748: aload 9
    //   750: ifnull +8 -> 758
    //   753: aload 9
    //   755: invokevirtual 313	java/io/FileInputStream:close	()V
    //   758: aload_1
    //   759: athrow
    //   760: astore 9
    //   762: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq -7 -> 758
    //   768: ldc 77
    //   770: iconst_2
    //   771: ldc_w 352
    //   774: aload 9
    //   776: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   779: goto -21 -> 758
    //   782: iconst_0
    //   783: istore_2
    //   784: goto -296 -> 488
    //   787: astore 9
    //   789: aload_0
    //   790: sipush -30000
    //   793: ldc_w 357
    //   796: invokevirtual 306	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	(ILjava/lang/String;)V
    //   799: aload_0
    //   800: invokevirtual 359	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   803: iconst_1
    //   804: istore 4
    //   806: goto -254 -> 552
    //   809: aload_0
    //   810: getfield 223	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Boolean	Z
    //   813: ifeq +10 -> 823
    //   816: aload_0
    //   817: invokevirtual 361	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:f	()V
    //   820: goto -196 -> 624
    //   823: aload_1
    //   824: getfield 362	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   827: ldc_w 364
    //   830: invokevirtual 367	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   833: ifnonnull +71 -> 904
    //   836: ldc2_w 368
    //   839: lstore 7
    //   841: aload_0
    //   842: getfield 316	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   845: ldc_w 371
    //   848: lload 7
    //   850: invokestatic 374	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   853: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   856: pop
    //   857: aload_1
    //   858: getfield 239	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   861: sipush 9364
    //   864: if_icmpne +61 -> 925
    //   867: aload_0
    //   868: getfield 376	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_Int	I
    //   871: iconst_3
    //   872: if_icmpge +53 -> 925
    //   875: aload_0
    //   876: ldc_w 378
    //   879: ldc_w 380
    //   882: invokevirtual 234	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   885: aload_0
    //   886: aload_0
    //   887: getfield 376	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_Int	I
    //   890: iconst_1
    //   891: iadd
    //   892: putfield 376	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_l_of_type_Int	I
    //   895: aload_0
    //   896: invokevirtual 383	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:m	()V
    //   899: aload_0
    //   900: invokevirtual 361	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:f	()V
    //   903: return
    //   904: aload_1
    //   905: getfield 362	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   908: ldc_w 364
    //   911: invokevirtual 367	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   914: checkcast 65	java/lang/String
    //   917: invokestatic 389	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   920: lstore 7
    //   922: goto -81 -> 841
    //   925: aload_1
    //   926: getfield 362	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   929: getstatic 392	com/tencent/mobileqq/utils/httputils/HttpMsg:f	Ljava/lang/String;
    //   932: invokevirtual 367	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   935: checkcast 65	java/lang/String
    //   938: astore 9
    //   940: aload_0
    //   941: aload_1
    //   942: getfield 239	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   945: aload_1
    //   946: getfield 243	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   949: aload 9
    //   951: aload_0
    //   952: getfield 350	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   955: invokevirtual 395	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   958: aload_0
    //   959: invokevirtual 359	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   962: goto -338 -> 624
    //   965: astore_1
    //   966: goto -218 -> 748
    //   969: astore_1
    //   970: goto -222 -> 748
    //   973: astore 10
    //   975: iconst_1
    //   976: istore_2
    //   977: goto -293 -> 684
    //   980: astore 10
    //   982: iconst_0
    //   983: istore_2
    //   984: goto -300 -> 684
    //   987: iconst_1
    //   988: istore_2
    //   989: goto -527 -> 462
    //   992: iconst_1
    //   993: istore_3
    //   994: goto -518 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	997	0	this	ShortVideoDownloadProcessor
    //   0	997	1	paramNetResp	NetResp
    //   461	528	2	i	int
    //   463	531	3	j	int
    //   45	760	4	bool1	boolean
    //   1	609	5	k	int
    //   4	545	6	bool2	boolean
    //   839	82	7	l1	long
    //   35	606	9	localObject1	Object
    //   651	17	9	localIOException1	java.io.IOException
    //   680	29	9	localObject2	Object
    //   718	17	9	localIOException2	java.io.IOException
    //   746	8	9	localObject3	Object
    //   760	15	9	localIOException3	java.io.IOException
    //   787	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   938	12	9	str	String
    //   299	244	10	localObject4	Object
    //   677	20	10	localIOException4	java.io.IOException
    //   973	1	10	localIOException5	java.io.IOException
    //   980	1	10	localIOException6	java.io.IOException
    //   340	9	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   469	474	651	java/io/IOException
    //   318	329	677	java/io/IOException
    //   708	713	718	java/io/IOException
    //   318	329	744	finally
    //   753	758	760	java/io/IOException
    //   540	548	787	java/lang/OutOfMemoryError
    //   329	342	965	finally
    //   347	404	965	finally
    //   404	414	965	finally
    //   414	460	965	finally
    //   684	701	969	finally
    //   329	342	973	java/io/IOException
    //   347	404	973	java/io/IOException
    //   404	414	973	java/io/IOException
    //   414	460	980	java/io/IOException
  }
  
  protected void a(NetResp paramNetResp, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      localHashMap.put("file_url", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      ServerAddr localServerAddr = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      if (localServerAddr != null)
      {
        if ((!paramBoolean) && (localServerAddr.jdField_a_of_type_JavaLangString != null))
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.contains(localServerAddr.jdField_a_of_type_JavaLangString)) {
            return;
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localServerAddr.jdField_a_of_type_JavaLangString);
        }
        localHashMap.put("server_ip", localServerAddr.jdField_a_of_type_JavaLangString);
        localHashMap.put("server_port", localServerAddr.jdField_a_of_type_Int + "");
      }
    }
    localHashMap.put("transfer_type", "2");
    localHashMap.put("business_type", this.jdField_c_of_type_Int + "");
    localHashMap.put("http_errorCode", paramNetResp.jdField_c_of_type_Int + "");
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    localHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
    localHashMap.put("md5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
    localHashMap.put("uuid", this.g);
    localHashMap.put("chatType", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int + "");
    localHashMap.put("chatUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_videoDown", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", paramRichProtoReq.toString());
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_a_of_type_Int == 1)
        {
          ArrayList localArrayList = InnerDns.a().a(paramRichProtoReq.jdField_b_of_type_JavaLangString, 1005);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            int j = 0;
            while (j < localArrayList.size())
            {
              ServerAddr localServerAddr = new ServerAddr();
              localServerAddr.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(i));
              localServerAddr.jdField_a_of_type_Int = 80;
              this.jdField_a_of_type_JavaUtilArrayList.add(localServerAddr);
              j += 1;
            }
          }
          this.jdField_d_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          label170:
          if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
            break label383;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " isDomain:" + paramRichProtoReq.jdField_a_of_type_Int + " domain:" + paramRichProtoReq.jdField_b_of_type_JavaLangString + " url:" + paramRichProtoReq.jdField_c_of_type_JavaLangString);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
          }
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_c_of_type_JavaLangString;
          if (!StringUtil.a(this.jdField_c_of_type_JavaLangString)) {
            break label371;
          }
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          a(paramRichProtoReq.jdField_b_of_type_ArrayOfByte, true);
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          break label170;
          label371:
          a(paramRichProtoReq.jdField_b_of_type_ArrayOfByte, false);
        }
        label383:
        if ((!paramRichProtoReq.f) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
        {
          ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown = false;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
          }
        }
        if (-5100026 != this.jdField_j_of_type_Int) {
          break label528;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
        }
        b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      }
    }
    for (;;)
    {
      d();
      return;
      label528:
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.jdField_j_of_type_Int);
        }
        b(this.jdField_j_of_type_Int, "视频文件过期");
      }
      else
      {
        b(9045, "申请信令失败");
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean) {}
    while (((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) || (this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    String str1;
    label98:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      str1 = "actShortVideoDownloadVideo";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) {
        break label550;
      }
      str1 = "actShortVideoDownloadThumb";
      if (this.jdField_o_of_type_Int > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.jdField_o_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.jdField_o_of_type_Int + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + str1);
      }
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.g);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int));
      if (!paramBoolean) {
        break label670;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label550:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6)
      {
        str1 = "actShortVideoDownloadVideo";
        break label98;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        str1 = "actShortVideoDiscussgroupDownloadThumb";
        break label98;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 17))
      {
        str1 = "actShortVideoDiscussgroupDownloadVideo";
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      }
      break label98;
      label670:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if (this.jdField_j_of_type_Int == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + "fileMd5=" + this.jdField_l_of_type_JavaLangString);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile encrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(1));
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      if (!paramBoolean) {
        break label525;
      }
    }
    Object localObject1;
    Object localObject2;
    label525:
    for (String str = d();; str = c())
    {
      localObject1 = new HttpNetReq();
      if (!StringUtil.a(this.jdField_d_of_type_JavaLangString)) {
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.jdField_d_of_type_JavaLangString);
      }
      ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$NetFailedListener = this;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      ((HttpNetReq)localObject1).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject1).jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject1).f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 17))
      {
        localObject2 = SharedPreUtils.f(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((HttpNetReq)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$AESDecryptor = new HttpNetReq.AESDecryptor(paramArrayOfByte);
      }
      ((HttpNetReq)localObject1).jdField_a_of_type_Long = 0L;
      ((HttpNetReq)localObject1).jdField_k_of_type_Boolean = true;
      ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((HttpNetReq)localObject1).jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "." + MD5.toMD5(this.g) + ".tmp");
      if (e())
      {
        paramArrayOfByte = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((HttpNetReq)localObject1).i = true;
        ((HttpNetReq)localObject1).j = false;
        if (new File(((HttpNetReq)localObject1).jdField_d_of_type_JavaLangString).exists()) {
          ((HttpNetReq)localObject1).jdField_a_of_type_Long = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      b("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject1).jdField_a_of_type_Long);
      if (d()) {
        break label534;
      }
      jdField_a_of_type_JavaUtilHashSet.remove(this.f);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile unencrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(0));
      break;
    }
    label534:
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject1);
    n();
    ((HttpNetReq)localObject1).jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean + " domain=" + this.jdField_d_of_type_JavaLangString + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Boolean)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (!StringUtil.a(this.jdField_d_of_type_JavaLangString)))
      {
        if (StringUtil.a(this.jdField_d_of_type_JavaLangString))
        {
          paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
          for (;;)
          {
            localObject1 = paramArrayOfByte;
            if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            localObject1 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("http://");
            ((StringBuffer)localObject2).append(((ServerAddr)localObject1).jdField_a_of_type_JavaLangString);
            if (((ServerAddr)localObject1).jdField_a_of_type_Int != 80)
            {
              ((StringBuffer)localObject2).append(":");
              ((StringBuffer)localObject2).append(((ServerAddr)localObject1).jdField_a_of_type_Int);
            }
            ((StringBuffer)localObject2).append("/");
            paramArrayOfByte[i] = RichMediaUtil.a(str, ((StringBuffer)localObject2).toString());
            i += 1;
          }
        }
        paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size() + 1];
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = str;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "last url= " + paramArrayOfByte[(paramArrayOfByte.length - 1)]);
          }
          break;
          localObject1 = new StringBuffer();
          if (!this.jdField_d_of_type_JavaLangString.startsWith("http://")) {
            ((StringBuffer)localObject1).append("http://");
          }
          ((StringBuffer)localObject1).append(this.jdField_d_of_type_JavaLangString);
          if (!this.jdField_d_of_type_JavaLangString.endsWith("/")) {
            ((StringBuffer)localObject1).append("/");
          }
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = RichMediaUtil.a(str, ((StringBuffer)localObject1).toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c = ((String[])localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      d(2002);
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(a());
      jdField_a_of_type_JavaUtilHashSet.remove(this.f);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject1);
  }
  
  public void ap_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.f));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 17)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "start()-- server not allow auto down video");
      }
      jdField_a_of_type_JavaUtilHashSet.remove(this.f);
      super.a();
    }
    while (jdField_a_of_type_JavaUtilHashSet.contains(this.f)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(this.f);
    d(2001);
    f();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_o_of_type_Boolean = false;
      d(2001);
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new aiqx(this));
    }
    return 0;
  }
  
  public void b(NetResp paramNetResp)
  {
    a(paramNetResp, false);
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null))
    {
      b(9302, "下载路径文件保存路径未指定。");
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.n = true;
    }
    return 0;
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
      if (localServerAddr.jdField_a_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localServerAddr.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      if (!this.jdField_d_of_type_JavaLangString.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      if (!this.jdField_d_of_type_JavaLangString.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
    }
  }
  
  protected String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.jdField_a_of_type_Int);
    }
    localStringBuilder.append("/qqdownload?ver=");
    localStringBuilder.append("3565");
    localStringBuilder.append("&rkey=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("&filetype=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("&mType=shortVideo");
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (int i = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; i = 0)
    {
      localStringBuilder.append("&videotype=").append(i);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType == 1)) {
        localStringBuilder.append("&subvideotype=").append(1);
      }
      b("getConnUrl", "url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.f);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_g_of_type_Int = this.jdField_j_of_type_Int;
    if (-5100026 == this.jdField_j_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.jdField_j_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      Object localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      }
      if (localObject != null)
      {
        ((TransferResult)localObject).jdField_a_of_type_Int = -1;
        ((TransferResult)localObject).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
        ((TransferResult)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((TransferResult)localObject).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localDownResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localDownCallBack.a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059")))) {
        d(5002);
      } else {
        d(2005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.jdField_k_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.f);
    d(2003);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject != null)
    {
      ((TransferResult)localObject).jdField_a_of_type_Int = 0;
      ((TransferResult)localObject).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_a_of_type_Int = 0;
      localDownResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      localDownResult.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      localDownResult.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int;
      localDownCallBack.a(localDownResult);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.jdField_c_of_type_Int);
    }
    localShortVideoDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localShortVideoDownReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_Int = 0;
    if (localShortVideoDownReq.f == 0)
    {
      localShortVideoDownReq.jdField_a_of_type_Int = 0;
      if ((localShortVideoDownReq.f != 0) && (1008 != localShortVideoDownReq.f)) {
        break label484;
      }
      localShortVideoDownReq.jdField_b_of_type_JavaLangString = null;
      label164:
      localShortVideoDownReq.jdField_b_of_type_Int = 2;
      localShortVideoDownReq.jdField_a_of_type_JavaLangString = this.g;
      localShortVideoDownReq.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label498;
      }
      localShortVideoDownReq.jdField_e_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      label231:
      this.jdField_c_of_type_Int = localShortVideoDownReq.jdField_e_of_type_Int;
      localShortVideoDownReq.jdField_j_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType == 1)) {
        localShortVideoDownReq.jdField_j_of_type_Int = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 16) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 18)) {
        break label530;
      }
    }
    label530:
    for (localShortVideoDownReq.jdField_g_of_type_Int = 1;; localShortVideoDownReq.jdField_g_of_type_Int = 2) {
      label484:
      label498:
      do
      {
        localShortVideoDownReq.h = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof Integer))) {
          localShortVideoDownReq.i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).intValue();
        }
        localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
        localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_dw";
        localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoDownReq);
        localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
        if (c()) {
          break label574;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (1 == localShortVideoDownReq.f)
        {
          localShortVideoDownReq.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localShortVideoDownReq.f)
        {
          localShortVideoDownReq.jdField_a_of_type_Int = 2;
          break;
        }
        localShortVideoDownReq.jdField_a_of_type_Int = 3;
        break;
        localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        break label164;
        if (1008 == localShortVideoDownReq.f)
        {
          localShortVideoDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int;
          break label231;
        }
        localShortVideoDownReq.jdField_e_of_type_Int = 0;
        break label231;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 17));
    }
    label574:
    b("requestStart", localRichProtoReq.toString());
    if (!d())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.f);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {
        str = "videoGd";
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */