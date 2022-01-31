package cooperation.weiyun.upload;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.utils.NetworkUtils;
import cooperation.weiyun.channel.HttpChannel;
import cooperation.weiyun.utils.StringUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class UploadTransfer
  implements Transfer
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected final UploadRequest a;
  private final Transfer.ProcessInfo jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo;
  protected final WyUploadJob a;
  public ArrayList a;
  protected DefaultHttpClient a;
  protected final byte[] a;
  protected int b;
  private long b;
  protected final byte[] b;
  protected int c;
  protected int d = 4;
  
  public UploadTransfer(UploadRequest paramUploadRequest, WyUploadJob paramWyUploadJob)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest = paramUploadRequest;
    this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob = paramWyUploadJob;
    this.jdField_a_of_type_ArrayOfByte = StringUtils.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.checkKey());
    this.jdField_b_of_type_ArrayOfByte = StringUtils.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.sha());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.size();
    this.jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo.jdField_a_of_type_JavaLangString = a().toString();
      label99:
      this.jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo.jdField_a_of_type_Int = a(new Object[] { this.jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo.jdField_a_of_type_JavaLangString, this });
      this.jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadRequest)
    {
      break label99;
    }
  }
  
  public static int a(Context paramContext)
  {
    int i = NetworkUtils.getNetworkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  public static int a(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + new Random().nextInt();
  }
  
  public int a()
  {
    return b();
  }
  
  /* Error */
  int a(StoragePlatomProto paramStoragePlatomProto, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 122	cooperation/weiyun/upload/UploadTransfer:a	()Lcooperation/weiyun/upload/UploadTransfer$ByteArrayBuffer;
    //   4: astore 20
    //   6: aconst_null
    //   7: astore 17
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 123	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   14: iconst_0
    //   15: istore 10
    //   17: iconst_0
    //   18: istore 8
    //   20: iconst_0
    //   21: istore 12
    //   23: iconst_0
    //   24: istore 9
    //   26: iload 12
    //   28: iconst_3
    //   29: if_icmplt +22 -> 51
    //   32: iload 9
    //   34: istore 11
    //   36: iload 10
    //   38: ifeq +1167 -> 1205
    //   41: iload 9
    //   43: istore 11
    //   45: iload 8
    //   47: iconst_3
    //   48: if_icmpge +1157 -> 1205
    //   51: aload_0
    //   52: getfield 36	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   55: invokevirtual 128	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   58: ifne +26 -> 84
    //   61: ldc 129
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +1074 -> 1141
    //   70: iconst_1
    //   71: istore 14
    //   73: aload_0
    //   74: aload 20
    //   76: iload 14
    //   78: invokevirtual 132	cooperation/weiyun/upload/UploadTransfer:a	(Lcooperation/weiyun/upload/UploadTransfer$ByteArrayBuffer;Z)V
    //   81: iload 4
    //   83: ireturn
    //   84: iload 5
    //   86: sipush 8192
    //   89: if_icmple +1109 -> 1198
    //   92: iload 12
    //   94: i2d
    //   95: dstore 6
    //   97: iload 5
    //   99: ldc2_w 133
    //   102: dload 6
    //   104: invokestatic 140	java/lang/Math:pow	(DD)D
    //   107: d2i
    //   108: idiv
    //   109: sipush 8192
    //   112: invokestatic 144	java/lang/Math:max	(II)I
    //   115: istore 11
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   122: iload 11
    //   124: aload_3
    //   125: iconst_0
    //   126: iload 4
    //   128: invokevirtual 149	cooperation/weiyun/upload/StoragePlatomProto:a	(JI[BII)I
    //   131: istore 13
    //   133: aload_0
    //   134: aload_2
    //   135: invokevirtual 152	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   138: astore 18
    //   140: aload 18
    //   142: new 154	cooperation/weiyun/upload/SppByteArrayEntity
    //   145: dup
    //   146: aload_3
    //   147: iconst_0
    //   148: iload 13
    //   150: iload 11
    //   152: iadd
    //   153: invokespecial 157	cooperation/weiyun/upload/SppByteArrayEntity:<init>	([BII)V
    //   156: invokevirtual 163	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   159: iconst_0
    //   160: istore 13
    //   162: aload_0
    //   163: getfield 165	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   166: aload 18
    //   168: invokevirtual 171	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   171: astore 18
    //   173: aload 18
    //   175: astore 17
    //   177: aload 17
    //   179: ifnonnull +59 -> 238
    //   182: aload 17
    //   184: astore 18
    //   186: aload_0
    //   187: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   190: iload 9
    //   192: istore 10
    //   194: aload 17
    //   196: ifnull +1027 -> 1223
    //   199: iload 9
    //   201: istore 10
    //   203: aload 17
    //   205: invokeinterface 179 1 0
    //   210: ifnull +1013 -> 1223
    //   213: aload 17
    //   215: invokeinterface 179 1 0
    //   220: invokeinterface 184 1 0
    //   225: iload 13
    //   227: istore 10
    //   229: iload 12
    //   231: iconst_1
    //   232: iadd
    //   233: istore 12
    //   235: goto -209 -> 26
    //   238: aload 17
    //   240: astore 18
    //   242: aload 17
    //   244: invokeinterface 188 1 0
    //   249: invokeinterface 193 1 0
    //   254: istore 9
    //   256: iload 9
    //   258: sipush 200
    //   261: if_icmpeq +116 -> 377
    //   264: iload 9
    //   266: ldc 194
    //   268: iadd
    //   269: istore 10
    //   271: aload 17
    //   273: astore 18
    //   275: aload 17
    //   277: ldc 196
    //   279: invokeinterface 200 2 0
    //   284: astore 19
    //   286: iload 10
    //   288: istore 9
    //   290: aload 19
    //   292: ifnull +35 -> 327
    //   295: iload 10
    //   297: istore 9
    //   299: aload 17
    //   301: astore 18
    //   303: aload 19
    //   305: arraylength
    //   306: ifle +21 -> 327
    //   309: aload 17
    //   311: astore 18
    //   313: aload 19
    //   315: iconst_0
    //   316: aaload
    //   317: invokeinterface 205 1 0
    //   322: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   325: istore 9
    //   327: aload 17
    //   329: astore 18
    //   331: aload_0
    //   332: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   335: iload 9
    //   337: istore 10
    //   339: aload 17
    //   341: ifnull +882 -> 1223
    //   344: iload 9
    //   346: istore 10
    //   348: aload 17
    //   350: invokeinterface 179 1 0
    //   355: ifnull +868 -> 1223
    //   358: aload 17
    //   360: invokeinterface 179 1 0
    //   365: invokeinterface 184 1 0
    //   370: iload 13
    //   372: istore 10
    //   374: goto -145 -> 229
    //   377: aload 17
    //   379: astore 18
    //   381: new 213	java/io/BufferedInputStream
    //   384: dup
    //   385: aload 17
    //   387: invokeinterface 179 1 0
    //   392: invokeinterface 217 1 0
    //   397: invokespecial 220	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: aload 20
    //   402: getfield 223	cooperation/weiyun/upload/UploadTransfer$ByteArrayBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   405: invokevirtual 229	java/io/InputStream:read	([B)I
    //   408: istore 10
    //   410: iload 10
    //   412: ifgt +53 -> 465
    //   415: ldc 230
    //   417: istore 9
    //   419: iload 9
    //   421: istore 10
    //   423: aload 17
    //   425: ifnull +798 -> 1223
    //   428: iload 9
    //   430: istore 10
    //   432: aload 17
    //   434: invokeinterface 179 1 0
    //   439: ifnull +784 -> 1223
    //   442: aload 17
    //   444: invokeinterface 179 1 0
    //   449: invokeinterface 184 1 0
    //   454: ldc 230
    //   456: istore 9
    //   458: iload 13
    //   460: istore 10
    //   462: goto -233 -> 229
    //   465: iload 9
    //   467: sipush 200
    //   470: if_icmpne +177 -> 647
    //   473: iconst_1
    //   474: istore 14
    //   476: aload 17
    //   478: astore 18
    //   480: aload_1
    //   481: iload 14
    //   483: aload 20
    //   485: getfield 223	cooperation/weiyun/upload/UploadTransfer$ByteArrayBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   488: iload 10
    //   490: invokevirtual 233	cooperation/weiyun/upload/StoragePlatomProto:a	(Z[BI)I
    //   493: istore 9
    //   495: iload 9
    //   497: ifne +384 -> 881
    //   500: aload 17
    //   502: astore 18
    //   504: aload_0
    //   505: iconst_0
    //   506: putfield 123	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   509: aload 17
    //   511: astore 18
    //   513: aload_0
    //   514: iload 11
    //   516: putfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   519: iload 12
    //   521: ifne +57 -> 578
    //   524: aload 17
    //   526: astore 18
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 237	cooperation/weiyun/upload/UploadTransfer:c	I
    //   533: iconst_1
    //   534: iadd
    //   535: putfield 237	cooperation/weiyun/upload/UploadTransfer:c	I
    //   538: aload 17
    //   540: astore 18
    //   542: aload_0
    //   543: getfield 237	cooperation/weiyun/upload/UploadTransfer:c	I
    //   546: aload_0
    //   547: getfield 27	cooperation/weiyun/upload/UploadTransfer:d	I
    //   550: if_icmplt +28 -> 578
    //   553: aload 17
    //   555: astore 18
    //   557: aload_0
    //   558: aload_0
    //   559: getfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   562: sipush 8192
    //   565: iadd
    //   566: putfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   569: aload 17
    //   571: astore 18
    //   573: aload_0
    //   574: iconst_0
    //   575: putfield 237	cooperation/weiyun/upload/UploadTransfer:c	I
    //   578: aload 17
    //   580: astore 18
    //   582: aload_0
    //   583: getfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   586: sipush 8192
    //   589: if_icmpge +64 -> 653
    //   592: aload 17
    //   594: astore 18
    //   596: aload_0
    //   597: sipush 8192
    //   600: putfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   603: iconst_0
    //   604: istore 4
    //   606: iload 4
    //   608: istore 11
    //   610: aload 17
    //   612: ifnull +593 -> 1205
    //   615: iload 4
    //   617: istore 11
    //   619: aload 17
    //   621: invokeinterface 179 1 0
    //   626: ifnull +579 -> 1205
    //   629: aload 17
    //   631: invokeinterface 179 1 0
    //   636: invokeinterface 184 1 0
    //   641: iconst_0
    //   642: istore 4
    //   644: goto -579 -> 65
    //   647: iconst_0
    //   648: istore 14
    //   650: goto -174 -> 476
    //   653: aload 17
    //   655: astore 18
    //   657: aload_0
    //   658: getfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   661: ldc 98
    //   663: if_icmple -60 -> 603
    //   666: aload 17
    //   668: astore 18
    //   670: aload_0
    //   671: ldc 98
    //   673: putfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   676: goto -73 -> 603
    //   679: astore 19
    //   681: iconst_0
    //   682: istore 10
    //   684: aload 17
    //   686: astore 18
    //   688: aload_0
    //   689: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   692: aload 19
    //   694: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   697: aload 17
    //   699: astore 18
    //   701: aload 19
    //   703: invokestatic 246	com/tencent/weiyun/transmission/utils/ErrorCodeUtil:getErrorCode4IOException	(Ljava/io/IOException;)I
    //   706: istore 13
    //   708: iload 10
    //   710: istore 11
    //   712: iload 13
    //   714: istore 9
    //   716: aload 17
    //   718: astore 18
    //   720: aload 17
    //   722: ifnull +49 -> 771
    //   725: iload 10
    //   727: istore 11
    //   729: iload 13
    //   731: istore 9
    //   733: aload 17
    //   735: astore 18
    //   737: aload 17
    //   739: invokeinterface 179 1 0
    //   744: ifnull +27 -> 771
    //   747: aload 17
    //   749: invokeinterface 179 1 0
    //   754: invokeinterface 184 1 0
    //   759: aload 17
    //   761: astore 18
    //   763: iload 13
    //   765: istore 9
    //   767: iload 10
    //   769: istore 11
    //   771: aload_0
    //   772: iconst_0
    //   773: putfield 237	cooperation/weiyun/upload/UploadTransfer:c	I
    //   776: aload_0
    //   777: aload_0
    //   778: getfield 27	cooperation/weiyun/upload/UploadTransfer:d	I
    //   781: i2d
    //   782: ldc2_w 247
    //   785: dmul
    //   786: d2i
    //   787: putfield 27	cooperation/weiyun/upload/UploadTransfer:d	I
    //   790: iload 9
    //   792: ldc 249
    //   794: if_icmpne +298 -> 1092
    //   797: aload_0
    //   798: aload_0
    //   799: getfield 123	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   802: iconst_1
    //   803: iadd
    //   804: putfield 123	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   807: iload 9
    //   809: ldc 250
    //   811: if_icmpeq +53 -> 864
    //   814: iload 9
    //   816: ldc 249
    //   818: if_icmpeq +46 -> 864
    //   821: iload 9
    //   823: ldc 251
    //   825: if_icmpeq +39 -> 864
    //   828: iload 9
    //   830: ldc 252
    //   832: if_icmpeq +32 -> 864
    //   835: iload 9
    //   837: ldc 253
    //   839: if_icmpeq +25 -> 864
    //   842: iload 9
    //   844: ldc 254
    //   846: if_icmpeq +18 -> 864
    //   849: iload 9
    //   851: ldc 255
    //   853: if_icmpeq +11 -> 864
    //   856: iload 9
    //   858: ldc_w 256
    //   861: if_icmpne +351 -> 1212
    //   864: invokestatic 262	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   867: invokestatic 266	com/tencent/weiyun/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   870: ifne +230 -> 1100
    //   873: ldc_w 267
    //   876: istore 4
    //   878: goto -813 -> 65
    //   881: ldc_w 268
    //   884: iload 9
    //   886: if_icmpne +45 -> 931
    //   889: iload 9
    //   891: istore 10
    //   893: aload 17
    //   895: ifnull +328 -> 1223
    //   898: iload 9
    //   900: istore 10
    //   902: aload 17
    //   904: invokeinterface 179 1 0
    //   909: ifnull +314 -> 1223
    //   912: aload 17
    //   914: invokeinterface 179 1 0
    //   919: invokeinterface 184 1 0
    //   924: iload 13
    //   926: istore 10
    //   928: goto -699 -> 229
    //   931: iload 9
    //   933: istore 11
    //   935: aload 17
    //   937: ifnull +268 -> 1205
    //   940: iload 9
    //   942: istore 11
    //   944: aload 17
    //   946: invokeinterface 179 1 0
    //   951: ifnull +254 -> 1205
    //   954: aload 17
    //   956: invokeinterface 179 1 0
    //   961: invokeinterface 184 1 0
    //   966: iload 9
    //   968: istore 4
    //   970: goto -905 -> 65
    //   973: astore 19
    //   975: iconst_0
    //   976: istore 10
    //   978: aload 17
    //   980: astore 18
    //   982: aload_0
    //   983: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   986: aload 19
    //   988: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   991: ldc_w 269
    //   994: istore 13
    //   996: iload 10
    //   998: istore 11
    //   1000: iload 13
    //   1002: istore 9
    //   1004: aload 17
    //   1006: astore 18
    //   1008: aload 17
    //   1010: ifnull -239 -> 771
    //   1013: iload 10
    //   1015: istore 11
    //   1017: iload 13
    //   1019: istore 9
    //   1021: aload 17
    //   1023: astore 18
    //   1025: aload 17
    //   1027: invokeinterface 179 1 0
    //   1032: ifnull -261 -> 771
    //   1035: aload 17
    //   1037: invokeinterface 179 1 0
    //   1042: invokeinterface 184 1 0
    //   1047: iload 10
    //   1049: istore 11
    //   1051: iload 13
    //   1053: istore 9
    //   1055: aload 17
    //   1057: astore 18
    //   1059: goto -288 -> 771
    //   1062: astore_1
    //   1063: aload 18
    //   1065: ifnull +25 -> 1090
    //   1068: aload 18
    //   1070: invokeinterface 179 1 0
    //   1075: ifnull +15 -> 1090
    //   1078: aload 18
    //   1080: invokeinterface 179 1 0
    //   1085: invokeinterface 184 1 0
    //   1090: aload_1
    //   1091: athrow
    //   1092: aload_0
    //   1093: iconst_0
    //   1094: putfield 123	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   1097: goto -290 -> 807
    //   1100: iload 8
    //   1102: iconst_1
    //   1103: iadd
    //   1104: istore 8
    //   1106: ldc2_w 270
    //   1109: ldc2_w 133
    //   1112: iload 12
    //   1114: i2d
    //   1115: ldc2_w 272
    //   1118: invokestatic 140	java/lang/Math:pow	(DD)D
    //   1121: dadd
    //   1122: dmul
    //   1123: d2l
    //   1124: lstore 15
    //   1126: lload 15
    //   1128: invokestatic 279	java/lang/Thread:sleep	(J)V
    //   1131: aload 18
    //   1133: astore 17
    //   1135: iconst_1
    //   1136: istore 10
    //   1138: goto -909 -> 229
    //   1141: iconst_0
    //   1142: istore 14
    //   1144: goto -1071 -> 73
    //   1147: astore_1
    //   1148: iload 9
    //   1150: istore 4
    //   1152: goto -1087 -> 65
    //   1155: astore_1
    //   1156: aload 17
    //   1158: astore 18
    //   1160: goto -97 -> 1063
    //   1163: astore 19
    //   1165: goto -187 -> 978
    //   1168: astore 19
    //   1170: iconst_0
    //   1171: istore 10
    //   1173: goto -195 -> 978
    //   1176: astore 19
    //   1178: goto -494 -> 684
    //   1181: astore 19
    //   1183: iconst_0
    //   1184: istore 10
    //   1186: goto -502 -> 684
    //   1189: astore 18
    //   1191: iload 10
    //   1193: istore 9
    //   1195: goto -868 -> 327
    //   1198: iload 5
    //   1200: istore 11
    //   1202: goto -1085 -> 117
    //   1205: iload 11
    //   1207: istore 4
    //   1209: goto -1144 -> 65
    //   1212: aload 18
    //   1214: astore 17
    //   1216: iload 11
    //   1218: istore 10
    //   1220: goto -991 -> 229
    //   1223: iload 10
    //   1225: istore 9
    //   1227: iload 13
    //   1229: istore 10
    //   1231: goto -1002 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1234	0	this	UploadTransfer
    //   0	1234	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	1234	2	paramURL	URL
    //   0	1234	3	paramArrayOfByte	byte[]
    //   0	1234	4	paramInt1	int
    //   0	1234	5	paramInt2	int
    //   95	8	6	d1	double
    //   18	1087	8	i	int
    //   24	1202	9	j	int
    //   15	1215	10	k	int
    //   34	1183	11	m	int
    //   21	1092	12	n	int
    //   131	1097	13	i1	int
    //   71	1072	14	bool	boolean
    //   1124	3	15	l	long
    //   7	1208	17	localObject1	Object
    //   138	1021	18	localObject2	Object
    //   1189	24	18	localThrowable	java.lang.Throwable
    //   284	30	19	arrayOfHeader	org.apache.http.Header[]
    //   679	23	19	localIOException1	IOException
    //   973	14	19	localException1	java.lang.Exception
    //   1163	1	19	localException2	java.lang.Exception
    //   1168	1	19	localException3	java.lang.Exception
    //   1176	1	19	localIOException2	IOException
    //   1181	1	19	localIOException3	IOException
    //   4	480	20	localByteArrayBuffer	UploadTransfer.ByteArrayBuffer
    // Exception table:
    //   from	to	target	type
    //   186	190	679	java/io/IOException
    //   242	256	679	java/io/IOException
    //   275	286	679	java/io/IOException
    //   303	309	679	java/io/IOException
    //   313	327	679	java/io/IOException
    //   331	335	679	java/io/IOException
    //   381	410	679	java/io/IOException
    //   480	495	679	java/io/IOException
    //   504	509	679	java/io/IOException
    //   513	519	679	java/io/IOException
    //   528	538	679	java/io/IOException
    //   542	553	679	java/io/IOException
    //   557	569	679	java/io/IOException
    //   573	578	679	java/io/IOException
    //   582	592	679	java/io/IOException
    //   596	603	679	java/io/IOException
    //   657	666	679	java/io/IOException
    //   670	676	679	java/io/IOException
    //   186	190	973	java/lang/Exception
    //   242	256	973	java/lang/Exception
    //   275	286	973	java/lang/Exception
    //   303	309	973	java/lang/Exception
    //   313	327	973	java/lang/Exception
    //   331	335	973	java/lang/Exception
    //   381	410	973	java/lang/Exception
    //   480	495	973	java/lang/Exception
    //   504	509	973	java/lang/Exception
    //   513	519	973	java/lang/Exception
    //   528	538	973	java/lang/Exception
    //   542	553	973	java/lang/Exception
    //   557	569	973	java/lang/Exception
    //   573	578	973	java/lang/Exception
    //   582	592	973	java/lang/Exception
    //   596	603	973	java/lang/Exception
    //   657	666	973	java/lang/Exception
    //   670	676	973	java/lang/Exception
    //   186	190	1062	finally
    //   242	256	1062	finally
    //   275	286	1062	finally
    //   303	309	1062	finally
    //   313	327	1062	finally
    //   331	335	1062	finally
    //   381	410	1062	finally
    //   480	495	1062	finally
    //   504	509	1062	finally
    //   513	519	1062	finally
    //   528	538	1062	finally
    //   542	553	1062	finally
    //   557	569	1062	finally
    //   573	578	1062	finally
    //   582	592	1062	finally
    //   596	603	1062	finally
    //   657	666	1062	finally
    //   670	676	1062	finally
    //   688	697	1062	finally
    //   701	708	1062	finally
    //   982	991	1062	finally
    //   1126	1131	1147	java/lang/InterruptedException
    //   97	117	1155	finally
    //   117	159	1155	finally
    //   162	173	1155	finally
    //   97	117	1163	java/lang/Exception
    //   117	159	1163	java/lang/Exception
    //   162	173	1168	java/lang/Exception
    //   97	117	1176	java/io/IOException
    //   117	159	1176	java/io/IOException
    //   162	173	1181	java/io/IOException
    //   275	286	1189	java/lang/Throwable
    //   303	309	1189	java/lang/Throwable
    //   313	327	1189	java/lang/Throwable
  }
  
  public UploadTransfer.ByteArrayBuffer a()
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i > 0)
        {
          UploadTransfer.ByteArrayBuffer localByteArrayBuffer1 = (UploadTransfer.ByteArrayBuffer)((SoftReference)this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1)).get();
          if (localByteArrayBuffer1 != null)
          {
            UploadTransfer.ByteArrayBuffer localByteArrayBuffer2 = localByteArrayBuffer1;
            if (localByteArrayBuffer1 == null) {
              localByteArrayBuffer2 = new UploadTransfer.ByteArrayBuffer(new byte[40960]);
            }
            return localByteArrayBuffer2;
          }
          i -= 1;
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  String a(int paramInt)
  {
    return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetworkType(BaseApplicationImpl.getApplication())), Integer.valueOf(paramInt) });
  }
  
  URL a()
  {
    return new URL("http", this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverIp(), this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverPort(), a(31532));
  }
  
  HttpPost a(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient == null) {
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = HttpChannel.a();
    }
    HttpChannel.a(this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient, this.jdField_a_of_type_Int);
    return paramURL;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient != null)
    {
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = null;
    }
  }
  
  void a(StoragePlatomProto paramStoragePlatomProto, int paramInt)
  {
    switch (paramStoragePlatomProto.a())
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
    a(paramStoragePlatomProto, this.jdField_a_of_type_Long + paramInt);
  }
  
  void a(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    if (paramLong != paramStoragePlatomProto.a()) {}
    for (this.jdField_a_of_type_Long = paramStoragePlatomProto.a();; this.jdField_a_of_type_Long = paramLong)
    {
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  /* Error */
  public void a(UploadTransfer.ByteArrayBuffer paramByteArrayBuffer, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 281	java/util/ArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: bipush 10
    //   13: if_icmple +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 32	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: new 287	java/lang/ref/SoftReference
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 392	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   31: invokevirtual 396	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	UploadTransfer
    //   0	43	1	paramByteArrayBuffer	UploadTransfer.ByteArrayBuffer
    //   0	43	2	paramBoolean	boolean
    //   9	5	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	38	finally
    //   19	35	38	finally
  }
  
  void a(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile) {}
  }
  
  /* Error */
  int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	cooperation/weiyun/upload/UploadTransfer:a	()Ljava/net/URL;
    //   4: astore 15
    //   6: new 399	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 34	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest	Lcom/tencent/weiyun/uploader/UploadRequest;
    //   14: invokevirtual 409	com/tencent/weiyun/uploader/UploadRequest:path	()Ljava/lang/String;
    //   17: ldc_w 411
    //   20: invokespecial 413	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 14
    //   25: aload_0
    //   26: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   29: ldc2_w 414
    //   32: lcmp
    //   33: ifle +95 -> 128
    //   36: new 146	cooperation/weiyun/upload/StoragePlatomProto
    //   39: dup
    //   40: sipush 1007
    //   43: aload_0
    //   44: getfield 54	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_ArrayOfByte	[B
    //   47: aload_0
    //   48: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   51: aload_0
    //   52: getfield 49	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_ArrayOfByte	[B
    //   55: iconst_0
    //   56: i2l
    //   57: invokespecial 418	cooperation/weiyun/upload/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   60: astore 13
    //   62: ldc_w 419
    //   65: newarray byte
    //   67: astore 16
    //   69: iconst_0
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 36	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   75: invokevirtual 128	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifne +90 -> 172
    //   85: aload_0
    //   86: aload 14
    //   88: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   91: aload_0
    //   92: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   95: ldc 129
    //   97: ireturn
    //   98: astore 13
    //   100: aload_0
    //   101: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   104: aload 13
    //   106: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   109: ldc_w 422
    //   112: ireturn
    //   113: astore 13
    //   115: aload_0
    //   116: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   119: aload 13
    //   121: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   124: ldc_w 423
    //   127: ireturn
    //   128: new 146	cooperation/weiyun/upload/StoragePlatomProto
    //   131: dup
    //   132: sipush 1000
    //   135: aload_0
    //   136: getfield 54	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_ArrayOfByte	[B
    //   139: aload_0
    //   140: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   143: aload_0
    //   144: getfield 49	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_ArrayOfByte	[B
    //   147: iconst_0
    //   148: i2l
    //   149: invokespecial 418	cooperation/weiyun/upload/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   152: astore 13
    //   154: goto -92 -> 62
    //   157: astore 13
    //   159: aload_0
    //   160: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   163: aload 13
    //   165: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   168: ldc_w 424
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   176: ifgt +33 -> 209
    //   179: invokestatic 262	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   182: invokestatic 426	cooperation/weiyun/upload/UploadTransfer:a	(Landroid/content/Context;)I
    //   185: istore_2
    //   186: iload_2
    //   187: ifge +17 -> 204
    //   190: aload_0
    //   191: aload 14
    //   193: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   196: aload_0
    //   197: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   200: ldc_w 267
    //   203: ireturn
    //   204: aload_0
    //   205: iload_2
    //   206: putfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   209: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   212: lstore 5
    //   214: aload_0
    //   215: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   218: lstore 7
    //   220: aload 14
    //   222: lload 7
    //   224: invokevirtual 429	java/io/RandomAccessFile:seek	(J)V
    //   227: aload 13
    //   229: invokevirtual 431	cooperation/weiyun/upload/StoragePlatomProto:a	()I
    //   232: istore_3
    //   233: aload 14
    //   235: aload 16
    //   237: iload_3
    //   238: aload_0
    //   239: getfield 235	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   242: invokevirtual 434	java/io/RandomAccessFile:read	([BII)I
    //   245: istore_2
    //   246: iload_2
    //   247: ifgt +37 -> 284
    //   250: aload_0
    //   251: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   254: lstore 9
    //   256: aload_0
    //   257: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   260: lstore 11
    //   262: lload 9
    //   264: lload 11
    //   266: lcmp
    //   267: ifge +17 -> 284
    //   270: aload_0
    //   271: aload 14
    //   273: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   276: aload_0
    //   277: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   280: ldc_w 435
    //   283: ireturn
    //   284: iload_2
    //   285: ifgt +35 -> 320
    //   288: aload_0
    //   289: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   292: lstore 9
    //   294: aload_0
    //   295: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   298: lstore 11
    //   300: lload 9
    //   302: lload 11
    //   304: lcmp
    //   305: ifne +15 -> 320
    //   308: aload_0
    //   309: aload 14
    //   311: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   314: aload_0
    //   315: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   318: iconst_0
    //   319: ireturn
    //   320: iload_1
    //   321: iconst_1
    //   322: iadd
    //   323: istore_1
    //   324: iload_1
    //   325: i2l
    //   326: lstore 9
    //   328: aload 13
    //   330: lload 9
    //   332: invokevirtual 437	cooperation/weiyun/upload/StoragePlatomProto:a	(J)V
    //   335: aload_0
    //   336: aload 13
    //   338: aload 15
    //   340: aload 16
    //   342: iload_3
    //   343: iload_2
    //   344: invokevirtual 439	cooperation/weiyun/upload/UploadTransfer:a	(Lcooperation/weiyun/upload/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   347: istore_3
    //   348: iload_3
    //   349: ifeq +15 -> 364
    //   352: aload_0
    //   353: aload 14
    //   355: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   358: aload_0
    //   359: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   362: iload_3
    //   363: ireturn
    //   364: aload_0
    //   365: getfield 36	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   368: invokevirtual 128	cooperation/weiyun/upload/WyUploadJob:a	()Z
    //   371: istore 4
    //   373: iload 4
    //   375: ifne +16 -> 391
    //   378: aload_0
    //   379: aload 14
    //   381: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   384: aload_0
    //   385: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   388: ldc 129
    //   390: ireturn
    //   391: aload_0
    //   392: aload 13
    //   394: iload_2
    //   395: invokevirtual 441	cooperation/weiyun/upload/UploadTransfer:a	(Lcooperation/weiyun/upload/StoragePlatomProto;I)V
    //   398: aload_0
    //   399: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   402: astore 17
    //   404: aload 17
    //   406: aload 17
    //   408: getfield 442	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_b_of_type_Long	J
    //   411: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   414: lload 5
    //   416: lsub
    //   417: ladd
    //   418: putfield 442	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_b_of_type_Long	J
    //   421: aload_0
    //   422: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   425: astore 17
    //   427: aload 17
    //   429: aload 17
    //   431: getfield 444	cooperation/weiyun/upload/Transfer$ProcessInfo:c	J
    //   434: aload_0
    //   435: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   438: lload 7
    //   440: lsub
    //   441: ladd
    //   442: putfield 444	cooperation/weiyun/upload/Transfer$ProcessInfo:c	J
    //   445: aload_0
    //   446: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   449: aload_0
    //   450: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   453: lcmp
    //   454: ifeq -146 -> 308
    //   457: aload_0
    //   458: getfield 56	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   461: lstore 5
    //   463: aload_0
    //   464: getfield 62	cooperation/weiyun/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   467: lstore 7
    //   469: lload 5
    //   471: lload 7
    //   473: lcmp
    //   474: ifle +17 -> 491
    //   477: aload_0
    //   478: aload 14
    //   480: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   483: aload_0
    //   484: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   487: ldc_w 445
    //   490: ireturn
    //   491: goto -420 -> 71
    //   494: astore 13
    //   496: aload_0
    //   497: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   500: aload 13
    //   502: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   505: aload_0
    //   506: aload 14
    //   508: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   511: aload_0
    //   512: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   515: ldc_w 446
    //   518: ireturn
    //   519: astore 13
    //   521: aload_0
    //   522: getfield 67	cooperation/weiyun/upload/UploadTransfer:jdField_a_of_type_CooperationWeiyunUploadTransfer$ProcessInfo	Lcooperation/weiyun/upload/Transfer$ProcessInfo;
    //   525: aload 13
    //   527: putfield 240	cooperation/weiyun/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   530: aload_0
    //   531: aload 14
    //   533: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   536: aload_0
    //   537: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   540: ldc_w 269
    //   543: ireturn
    //   544: astore 13
    //   546: aload_0
    //   547: aload 14
    //   549: invokevirtual 421	cooperation/weiyun/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   552: aload_0
    //   553: invokevirtual 173	cooperation/weiyun/upload/UploadTransfer:a	()V
    //   556: aload 13
    //   558: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	UploadTransfer
    //   70	255	1	i	int
    //   185	210	2	j	int
    //   232	131	3	k	int
    //   78	296	4	bool	boolean
    //   212	258	5	l1	long
    //   218	254	7	l2	long
    //   254	77	9	l3	long
    //   260	43	11	l4	long
    //   60	1	13	localStoragePlatomProto1	StoragePlatomProto
    //   98	7	13	localFileNotFoundException	java.io.FileNotFoundException
    //   113	7	13	localMalformedURLException	MalformedURLException
    //   152	1	13	localStoragePlatomProto2	StoragePlatomProto
    //   157	236	13	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   494	7	13	localIOException	IOException
    //   519	7	13	localException	java.lang.Exception
    //   544	13	13	localObject	Object
    //   23	525	14	localRandomAccessFile	RandomAccessFile
    //   4	335	15	localURL	URL
    //   67	274	16	arrayOfByte	byte[]
    //   402	28	17	localProcessInfo	Transfer.ProcessInfo
    // Exception table:
    //   from	to	target	type
    //   0	25	98	java/io/FileNotFoundException
    //   0	25	113	java/net/MalformedURLException
    //   25	62	157	java/lang/IllegalArgumentException
    //   128	154	157	java/lang/IllegalArgumentException
    //   71	80	494	java/io/IOException
    //   172	186	494	java/io/IOException
    //   204	209	494	java/io/IOException
    //   209	246	494	java/io/IOException
    //   250	262	494	java/io/IOException
    //   288	300	494	java/io/IOException
    //   328	348	494	java/io/IOException
    //   364	373	494	java/io/IOException
    //   391	469	494	java/io/IOException
    //   71	80	519	java/lang/Exception
    //   172	186	519	java/lang/Exception
    //   204	209	519	java/lang/Exception
    //   209	246	519	java/lang/Exception
    //   250	262	519	java/lang/Exception
    //   288	300	519	java/lang/Exception
    //   328	348	519	java/lang/Exception
    //   364	373	519	java/lang/Exception
    //   391	469	519	java/lang/Exception
    //   71	80	544	finally
    //   172	186	544	finally
    //   204	209	544	finally
    //   209	246	544	finally
    //   250	262	544	finally
    //   288	300	544	finally
    //   328	348	544	finally
    //   364	373	544	finally
    //   391	469	544	finally
    //   496	505	544	finally
    //   521	530	544	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.upload.UploadTransfer
 * JD-Core Version:    0.7.0.1
 */