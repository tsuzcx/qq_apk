package com.tencent.mobileqq.weiyun.sdk.upload;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.weiyun.channel.HttpChannel;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.utils.NetworkUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import mqq.app.MobileQQ;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class UploadTransfer
  implements Transfer
{
  protected int a;
  private long jdField_a_of_type_Long;
  private final Transfer.ProcessInfo jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo;
  protected final WyUploadJob a;
  protected final UploadRequest a;
  public ArrayList<SoftReference<UploadTransfer.ByteArrayBuffer>> a;
  protected DefaultHttpClient a;
  protected final byte[] a;
  protected int b;
  private long b;
  protected final byte[] b;
  protected int c = 0;
  protected int d = 4;
  
  public UploadTransfer(UploadRequest paramUploadRequest, WyUploadJob paramWyUploadJob)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest = paramUploadRequest;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob = paramWyUploadJob;
    this.jdField_a_of_type_ArrayOfByte = StringUtils.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.checkKey());
    this.jdField_b_of_type_ArrayOfByte = StringUtils.a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.sha());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.size();
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo.jdField_a_of_type_JavaLangString = a().toString();
      label119:
      paramUploadRequest = this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo;
      paramUploadRequest.jdField_a_of_type_Int = a(new Object[] { paramUploadRequest.jdField_a_of_type_JavaLangString, this });
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadRequest)
    {
      break label119;
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
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        Object localObject = paramVarArgs[j];
        if (localObject != null) {
          i = i * 31 + localObject.hashCode();
        }
        j += 1;
      }
    }
    return k * 31 + new Random().nextInt();
  }
  
  private static String a(int paramInt)
  {
    return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetworkType(MobileQQ.sMobileQQ)), Integer.valueOf(paramInt) });
  }
  
  private URL a()
  {
    if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {
      return new URL("https", "upload.weiyun.com", a(31532));
    }
    return new URL("http", this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverIp(), this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverPort(), a(31532));
  }
  
  private HttpPost a(URL paramURL)
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
  
  private void a()
  {
    DefaultHttpClient localDefaultHttpClient = this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
    if (localDefaultHttpClient != null)
    {
      localDefaultHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = null;
    }
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
    //   1: invokevirtual 238	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()Lcom/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer$ByteArrayBuffer;
    //   4: astore 23
    //   6: iconst_0
    //   7: istore 16
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 30	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   14: aconst_null
    //   15: astore 19
    //   17: iconst_0
    //   18: istore 9
    //   20: iconst_0
    //   21: istore 12
    //   23: iconst_0
    //   24: istore 10
    //   26: iconst_0
    //   27: istore 13
    //   29: iload 12
    //   31: iconst_3
    //   32: if_icmplt +22 -> 54
    //   35: iload 9
    //   37: istore 8
    //   39: iload 10
    //   41: ifeq +1217 -> 1258
    //   44: iload 9
    //   46: istore 8
    //   48: iload 13
    //   50: iconst_3
    //   51: if_icmpge +1207 -> 1258
    //   54: aload_0
    //   55: getfield 45	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob	Lcom/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob;
    //   58: invokevirtual 243	com/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob:a	()Z
    //   61: ifne +10 -> 71
    //   64: ldc 244
    //   66: istore 8
    //   68: goto +1190 -> 1258
    //   71: iload 5
    //   73: sipush 8192
    //   76: if_icmple +1253 -> 1329
    //   79: iload 12
    //   81: i2d
    //   82: dstore 6
    //   84: aload 19
    //   86: astore 20
    //   88: iload 5
    //   90: ldc2_w 245
    //   93: dload 6
    //   95: invokestatic 252	java/lang/Math:pow	(DD)D
    //   98: d2i
    //   99: idiv
    //   100: sipush 8192
    //   103: invokestatic 256	java/lang/Math:max	(II)I
    //   106: istore 8
    //   108: goto +3 -> 111
    //   111: aload 19
    //   113: astore 20
    //   115: aload_1
    //   116: aload_0
    //   117: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   120: iload 8
    //   122: aload_3
    //   123: iconst_0
    //   124: iload 4
    //   126: invokevirtual 261	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:a	(JI[BII)I
    //   129: istore 11
    //   131: aload 19
    //   133: astore 20
    //   135: aload_0
    //   136: aload_2
    //   137: invokespecial 263	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   140: astore 24
    //   142: aload 19
    //   144: astore 20
    //   146: aload 24
    //   148: new 265	com/tencent/mobileqq/weiyun/sdk/upload/SppByteArrayEntity
    //   151: dup
    //   152: aload_3
    //   153: iconst_0
    //   154: iload 11
    //   156: iload 8
    //   158: iadd
    //   159: invokespecial 268	com/tencent/mobileqq/weiyun/sdk/upload/SppByteArrayEntity:<init>	([BII)V
    //   162: invokevirtual 272	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   165: aload 19
    //   167: astore 21
    //   169: aload 19
    //   171: astore 22
    //   173: aload 19
    //   175: astore 20
    //   177: aload_0
    //   178: getfield 28	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   181: aload 24
    //   183: invokevirtual 276	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   186: astore 19
    //   188: aload 19
    //   190: ifnonnull +72 -> 262
    //   193: aload 19
    //   195: astore 21
    //   197: aload 19
    //   199: astore 22
    //   201: aload 19
    //   203: astore 20
    //   205: aload_0
    //   206: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   209: iload 9
    //   211: istore 8
    //   213: aload 19
    //   215: ifnull +33 -> 248
    //   218: iload 9
    //   220: istore 8
    //   222: aload 19
    //   224: invokeinterface 284 1 0
    //   229: ifnull +19 -> 248
    //   232: iload 9
    //   234: istore 8
    //   236: aload 19
    //   238: invokeinterface 284 1 0
    //   243: invokeinterface 289 1 0
    //   248: iconst_0
    //   249: istore 10
    //   251: iload 8
    //   253: istore 11
    //   255: iload 13
    //   257: istore 14
    //   259: goto +982 -> 1241
    //   262: aload 19
    //   264: astore 21
    //   266: aload 19
    //   268: astore 22
    //   270: aload 19
    //   272: astore 20
    //   274: aload 19
    //   276: invokeinterface 293 1 0
    //   281: invokeinterface 298 1 0
    //   286: istore 9
    //   288: iload 9
    //   290: sipush 200
    //   293: if_icmpeq +138 -> 431
    //   296: iload 9
    //   298: ldc_w 299
    //   301: iadd
    //   302: istore 8
    //   304: aload 19
    //   306: astore 21
    //   308: aload 19
    //   310: astore 22
    //   312: aload 19
    //   314: astore 20
    //   316: aload 19
    //   318: ldc_w 301
    //   321: invokeinterface 305 2 0
    //   326: astore 24
    //   328: iload 8
    //   330: istore 9
    //   332: aload 24
    //   334: ifnull +51 -> 385
    //   337: iload 8
    //   339: istore 9
    //   341: aload 19
    //   343: astore 21
    //   345: aload 19
    //   347: astore 22
    //   349: aload 19
    //   351: astore 20
    //   353: aload 24
    //   355: arraylength
    //   356: ifle +29 -> 385
    //   359: aload 19
    //   361: astore 21
    //   363: aload 19
    //   365: astore 22
    //   367: aload 19
    //   369: astore 20
    //   371: aload 24
    //   373: iconst_0
    //   374: aaload
    //   375: invokeinterface 310 1 0
    //   380: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   383: istore 9
    //   385: aload 19
    //   387: astore 21
    //   389: aload 19
    //   391: astore 22
    //   393: aload 19
    //   395: astore 20
    //   397: aload_0
    //   398: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   401: iload 9
    //   403: istore 8
    //   405: aload 19
    //   407: ifnull -159 -> 248
    //   410: iload 9
    //   412: istore 8
    //   414: aload 19
    //   416: invokeinterface 284 1 0
    //   421: ifnull -173 -> 248
    //   424: iload 9
    //   426: istore 8
    //   428: goto -192 -> 236
    //   431: aload 19
    //   433: astore 21
    //   435: aload 19
    //   437: astore 22
    //   439: aload 19
    //   441: astore 20
    //   443: new 316	java/io/BufferedInputStream
    //   446: dup
    //   447: aload 19
    //   449: invokeinterface 284 1 0
    //   454: invokeinterface 320 1 0
    //   459: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   462: aload 23
    //   464: getfield 326	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer$ByteArrayBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   467: invokevirtual 332	java/io/InputStream:read	([B)I
    //   470: istore 10
    //   472: iload 10
    //   474: ifgt +38 -> 512
    //   477: ldc_w 333
    //   480: istore 9
    //   482: iload 9
    //   484: istore 8
    //   486: aload 19
    //   488: ifnull -240 -> 248
    //   491: iload 9
    //   493: istore 8
    //   495: aload 19
    //   497: invokeinterface 284 1 0
    //   502: ifnull -254 -> 248
    //   505: iload 9
    //   507: istore 8
    //   509: goto -273 -> 236
    //   512: iload 9
    //   514: sipush 200
    //   517: if_icmpne +9 -> 526
    //   520: iconst_1
    //   521: istore 15
    //   523: goto +6 -> 529
    //   526: iconst_0
    //   527: istore 15
    //   529: aload 19
    //   531: astore 21
    //   533: aload 19
    //   535: astore 22
    //   537: aload 19
    //   539: astore 20
    //   541: aload 23
    //   543: getfield 326	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer$ByteArrayBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   546: astore 24
    //   548: aload 19
    //   550: astore 20
    //   552: aload_1
    //   553: iload 15
    //   555: aload 24
    //   557: iload 10
    //   559: invokevirtual 336	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:a	(Z[BI)I
    //   562: istore 9
    //   564: iload 9
    //   566: ifne +165 -> 731
    //   569: aload 19
    //   571: astore 20
    //   573: aload_0
    //   574: iconst_0
    //   575: putfield 30	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   578: aload 19
    //   580: astore 20
    //   582: aload_0
    //   583: iload 8
    //   585: putfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   588: iload 12
    //   590: ifne +57 -> 647
    //   593: aload 19
    //   595: astore 20
    //   597: aload_0
    //   598: aload_0
    //   599: getfield 34	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:c	I
    //   602: iconst_1
    //   603: iadd
    //   604: putfield 34	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:c	I
    //   607: aload 19
    //   609: astore 20
    //   611: aload_0
    //   612: getfield 34	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:c	I
    //   615: aload_0
    //   616: getfield 36	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:d	I
    //   619: if_icmplt +28 -> 647
    //   622: aload 19
    //   624: astore 20
    //   626: aload_0
    //   627: aload_0
    //   628: getfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   631: sipush 8192
    //   634: iadd
    //   635: putfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   638: aload 19
    //   640: astore 20
    //   642: aload_0
    //   643: iconst_0
    //   644: putfield 34	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:c	I
    //   647: aload 19
    //   649: astore 20
    //   651: aload_0
    //   652: getfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   655: sipush 8192
    //   658: if_icmpge +17 -> 675
    //   661: aload 19
    //   663: astore 20
    //   665: aload_0
    //   666: sipush 8192
    //   669: putfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   672: goto +26 -> 698
    //   675: aload 19
    //   677: astore 20
    //   679: aload_0
    //   680: getfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   683: ldc 106
    //   685: if_icmple +13 -> 698
    //   688: aload 19
    //   690: astore 20
    //   692: aload_0
    //   693: ldc 106
    //   695: putfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   698: aload 19
    //   700: ifnull +25 -> 725
    //   703: aload 19
    //   705: invokeinterface 284 1 0
    //   710: ifnull +15 -> 725
    //   713: aload 19
    //   715: invokeinterface 284 1 0
    //   720: invokeinterface 289 1 0
    //   725: iconst_0
    //   726: istore 8
    //   728: goto +530 -> 1258
    //   731: ldc_w 337
    //   734: iload 9
    //   736: if_icmpne +45 -> 781
    //   739: iload 9
    //   741: istore 8
    //   743: aload 19
    //   745: ifnull -497 -> 248
    //   748: iload 9
    //   750: istore 8
    //   752: aload 19
    //   754: invokeinterface 284 1 0
    //   759: ifnull -511 -> 248
    //   762: aload 19
    //   764: invokeinterface 284 1 0
    //   769: invokeinterface 289 1 0
    //   774: iload 9
    //   776: istore 8
    //   778: goto -530 -> 248
    //   781: iload 9
    //   783: istore 8
    //   785: aload 19
    //   787: ifnull +471 -> 1258
    //   790: iload 9
    //   792: istore 8
    //   794: aload 19
    //   796: invokeinterface 284 1 0
    //   801: ifnull +457 -> 1258
    //   804: aload 19
    //   806: invokeinterface 284 1 0
    //   811: invokeinterface 289 1 0
    //   816: iload 9
    //   818: istore 8
    //   820: goto +438 -> 1258
    //   823: astore 21
    //   825: goto +18 -> 843
    //   828: astore 21
    //   830: goto +25 -> 855
    //   833: astore 20
    //   835: aload 21
    //   837: astore 19
    //   839: aload 20
    //   841: astore 21
    //   843: iconst_0
    //   844: istore 10
    //   846: goto +41 -> 887
    //   849: astore 21
    //   851: aload 22
    //   853: astore 19
    //   855: iconst_0
    //   856: istore 10
    //   858: goto +115 -> 973
    //   861: astore 21
    //   863: goto +24 -> 887
    //   866: astore 21
    //   868: goto +105 -> 973
    //   871: astore 21
    //   873: goto +14 -> 887
    //   876: astore 21
    //   878: goto +95 -> 973
    //   881: astore_1
    //   882: goto +399 -> 1281
    //   885: astore 21
    //   887: aload 19
    //   889: astore 20
    //   891: aload_0
    //   892: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   895: aload 21
    //   897: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   900: ldc_w 341
    //   903: istore 11
    //   905: iload 11
    //   907: istore 8
    //   909: iload 10
    //   911: istore 9
    //   913: aload 19
    //   915: astore 20
    //   917: aload 19
    //   919: ifnull +128 -> 1047
    //   922: iload 11
    //   924: istore 8
    //   926: iload 10
    //   928: istore 9
    //   930: aload 19
    //   932: astore 20
    //   934: aload 19
    //   936: invokeinterface 284 1 0
    //   941: ifnull +106 -> 1047
    //   944: iload 10
    //   946: istore 9
    //   948: iload 11
    //   950: istore 8
    //   952: aload 19
    //   954: invokeinterface 284 1 0
    //   959: invokeinterface 289 1 0
    //   964: aload 19
    //   966: astore 20
    //   968: goto +79 -> 1047
    //   971: astore 21
    //   973: aload 19
    //   975: astore 20
    //   977: aload_0
    //   978: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   981: aload 21
    //   983: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   986: aload 19
    //   988: astore 20
    //   990: aload 21
    //   992: invokestatic 347	com/tencent/weiyun/transmission/utils/ErrorCodeUtil:getErrorCode4IOException	(Ljava/io/IOException;)I
    //   995: istore 11
    //   997: iload 11
    //   999: istore 8
    //   1001: iload 10
    //   1003: istore 9
    //   1005: aload 19
    //   1007: astore 20
    //   1009: aload 19
    //   1011: ifnull +36 -> 1047
    //   1014: iload 11
    //   1016: istore 8
    //   1018: iload 10
    //   1020: istore 9
    //   1022: aload 19
    //   1024: astore 20
    //   1026: aload 19
    //   1028: invokeinterface 284 1 0
    //   1033: ifnull +14 -> 1047
    //   1036: iload 11
    //   1038: istore 8
    //   1040: iload 10
    //   1042: istore 9
    //   1044: goto -92 -> 952
    //   1047: aload_0
    //   1048: iconst_0
    //   1049: putfield 34	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:c	I
    //   1052: aload_0
    //   1053: getfield 36	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:d	I
    //   1056: i2d
    //   1057: dstore 6
    //   1059: dload 6
    //   1061: invokestatic 353	java/lang/Double:isNaN	(D)Z
    //   1064: pop
    //   1065: aload_0
    //   1066: dload 6
    //   1068: ldc2_w 354
    //   1071: dmul
    //   1072: d2i
    //   1073: putfield 36	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:d	I
    //   1076: iload 8
    //   1078: ldc_w 356
    //   1081: if_icmpne +16 -> 1097
    //   1084: aload_0
    //   1085: aload_0
    //   1086: getfield 30	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   1089: iconst_1
    //   1090: iadd
    //   1091: putfield 30	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   1094: goto +8 -> 1102
    //   1097: aload_0
    //   1098: iconst_0
    //   1099: putfield 30	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Int	I
    //   1102: iload 8
    //   1104: ldc_w 357
    //   1107: if_icmpeq +75 -> 1182
    //   1110: iload 8
    //   1112: ldc_w 356
    //   1115: if_icmpeq +67 -> 1182
    //   1118: iload 8
    //   1120: ldc_w 358
    //   1123: if_icmpeq +59 -> 1182
    //   1126: iload 8
    //   1128: ldc_w 359
    //   1131: if_icmpeq +51 -> 1182
    //   1134: iload 8
    //   1136: ldc_w 360
    //   1139: if_icmpeq +43 -> 1182
    //   1142: iload 8
    //   1144: ldc_w 361
    //   1147: if_icmpeq +35 -> 1182
    //   1150: iload 8
    //   1152: ldc_w 362
    //   1155: if_icmpeq +27 -> 1182
    //   1158: iload 8
    //   1160: istore 11
    //   1162: iload 9
    //   1164: istore 10
    //   1166: iload 13
    //   1168: istore 14
    //   1170: aload 20
    //   1172: astore 19
    //   1174: iload 8
    //   1176: ldc_w 363
    //   1179: if_icmpne +62 -> 1241
    //   1182: getstatic 125	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   1185: invokestatic 367	com/tencent/weiyun/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1188: ifne +11 -> 1199
    //   1191: ldc_w 368
    //   1194: istore 8
    //   1196: goto +62 -> 1258
    //   1199: iload 12
    //   1201: i2d
    //   1202: ldc2_w 369
    //   1205: invokestatic 252	java/lang/Math:pow	(DD)D
    //   1208: ldc2_w 245
    //   1211: dadd
    //   1212: ldc2_w 371
    //   1215: dmul
    //   1216: d2l
    //   1217: lstore 17
    //   1219: lload 17
    //   1221: invokestatic 378	java/lang/Thread:sleep	(J)V
    //   1224: iload 13
    //   1226: iconst_1
    //   1227: iadd
    //   1228: istore 14
    //   1230: iconst_1
    //   1231: istore 10
    //   1233: aload 20
    //   1235: astore 19
    //   1237: iload 8
    //   1239: istore 11
    //   1241: iload 12
    //   1243: iconst_1
    //   1244: iadd
    //   1245: istore 12
    //   1247: iload 11
    //   1249: istore 9
    //   1251: iload 14
    //   1253: istore 13
    //   1255: goto -1226 -> 29
    //   1258: iload 16
    //   1260: istore 15
    //   1262: iload 8
    //   1264: ifne +6 -> 1270
    //   1267: iconst_1
    //   1268: istore 15
    //   1270: aload_0
    //   1271: aload 23
    //   1273: iload 15
    //   1275: invokevirtual 381	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Lcom/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer$ByteArrayBuffer;Z)V
    //   1278: iload 8
    //   1280: ireturn
    //   1281: aload 20
    //   1283: ifnull +25 -> 1308
    //   1286: aload 20
    //   1288: invokeinterface 284 1 0
    //   1293: ifnull +15 -> 1308
    //   1296: aload 20
    //   1298: invokeinterface 284 1 0
    //   1303: invokeinterface 289 1 0
    //   1308: goto +5 -> 1313
    //   1311: aload_1
    //   1312: athrow
    //   1313: goto -2 -> 1311
    //   1316: astore 20
    //   1318: iload 8
    //   1320: istore 9
    //   1322: goto -937 -> 385
    //   1325: astore_1
    //   1326: goto -68 -> 1258
    //   1329: iload 5
    //   1331: istore 8
    //   1333: goto -1222 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1336	0	this	UploadTransfer
    //   0	1336	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	1336	2	paramURL	URL
    //   0	1336	3	paramArrayOfByte	byte[]
    //   0	1336	4	paramInt1	int
    //   0	1336	5	paramInt2	int
    //   82	985	6	d1	double
    //   37	1295	8	i	int
    //   18	1303	9	j	int
    //   24	1208	10	k	int
    //   129	1119	11	m	int
    //   21	1225	12	n	int
    //   27	1227	13	i1	int
    //   257	995	14	i2	int
    //   521	753	15	bool1	boolean
    //   7	1252	16	bool2	boolean
    //   1217	3	17	l	long
    //   15	1221	19	localObject1	Object
    //   86	605	20	localObject2	Object
    //   833	7	20	localException1	java.lang.Exception
    //   889	408	20	localObject3	Object
    //   1316	1	20	localThrowable	java.lang.Throwable
    //   167	365	21	localObject4	Object
    //   823	1	21	localException2	java.lang.Exception
    //   828	8	21	localIOException1	IOException
    //   841	1	21	localException3	java.lang.Exception
    //   849	1	21	localIOException2	IOException
    //   861	1	21	localException4	java.lang.Exception
    //   866	1	21	localIOException3	IOException
    //   871	1	21	localException5	java.lang.Exception
    //   876	1	21	localIOException4	IOException
    //   885	11	21	localException6	java.lang.Exception
    //   971	20	21	localIOException5	IOException
    //   171	681	22	localObject5	Object
    //   4	1268	23	localByteArrayBuffer	UploadTransfer.ByteArrayBuffer
    //   140	416	24	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   552	564	823	java/lang/Exception
    //   573	578	823	java/lang/Exception
    //   582	588	823	java/lang/Exception
    //   597	607	823	java/lang/Exception
    //   611	622	823	java/lang/Exception
    //   626	638	823	java/lang/Exception
    //   642	647	823	java/lang/Exception
    //   651	661	823	java/lang/Exception
    //   665	672	823	java/lang/Exception
    //   679	688	823	java/lang/Exception
    //   692	698	823	java/lang/Exception
    //   552	564	828	java/io/IOException
    //   573	578	828	java/io/IOException
    //   582	588	828	java/io/IOException
    //   597	607	828	java/io/IOException
    //   611	622	828	java/io/IOException
    //   626	638	828	java/io/IOException
    //   642	647	828	java/io/IOException
    //   651	661	828	java/io/IOException
    //   665	672	828	java/io/IOException
    //   679	688	828	java/io/IOException
    //   692	698	828	java/io/IOException
    //   177	188	833	java/lang/Exception
    //   205	209	833	java/lang/Exception
    //   274	288	833	java/lang/Exception
    //   316	328	833	java/lang/Exception
    //   353	359	833	java/lang/Exception
    //   371	385	833	java/lang/Exception
    //   397	401	833	java/lang/Exception
    //   443	472	833	java/lang/Exception
    //   541	548	833	java/lang/Exception
    //   177	188	849	java/io/IOException
    //   205	209	849	java/io/IOException
    //   274	288	849	java/io/IOException
    //   316	328	849	java/io/IOException
    //   353	359	849	java/io/IOException
    //   371	385	849	java/io/IOException
    //   397	401	849	java/io/IOException
    //   443	472	849	java/io/IOException
    //   541	548	849	java/io/IOException
    //   146	165	861	java/lang/Exception
    //   146	165	866	java/io/IOException
    //   135	142	871	java/lang/Exception
    //   135	142	876	java/io/IOException
    //   88	108	881	finally
    //   115	131	881	finally
    //   135	142	881	finally
    //   146	165	881	finally
    //   177	188	881	finally
    //   205	209	881	finally
    //   274	288	881	finally
    //   316	328	881	finally
    //   353	359	881	finally
    //   371	385	881	finally
    //   397	401	881	finally
    //   443	472	881	finally
    //   541	548	881	finally
    //   552	564	881	finally
    //   573	578	881	finally
    //   582	588	881	finally
    //   597	607	881	finally
    //   611	622	881	finally
    //   626	638	881	finally
    //   642	647	881	finally
    //   651	661	881	finally
    //   665	672	881	finally
    //   679	688	881	finally
    //   692	698	881	finally
    //   891	900	881	finally
    //   977	986	881	finally
    //   990	997	881	finally
    //   88	108	885	java/lang/Exception
    //   115	131	885	java/lang/Exception
    //   88	108	971	java/io/IOException
    //   115	131	971	java/io/IOException
    //   316	328	1316	java/lang/Throwable
    //   353	359	1316	java/lang/Throwable
    //   371	385	1316	java/lang/Throwable
    //   1219	1224	1325	java/lang/InterruptedException
  }
  
  public UploadTransfer.ByteArrayBuffer a()
  {
    Object localObject3 = null;
    try
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      Object localObject1 = localObject3;
      if (i > 0)
      {
        localObject1 = (UploadTransfer.ByteArrayBuffer)((SoftReference)this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1)).get();
        if (localObject1 == null) {
          break label79;
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new UploadTransfer.ByteArrayBuffer(new byte[40960]);
      }
      return localObject3;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw localObject2;
        }
        label79:
        i -= 1;
      }
    }
  }
  
  void a(StoragePlatomProto paramStoragePlatomProto, int paramInt)
  {
    int i = paramStoragePlatomProto.a();
    if (i != 0) {
      if (i != 1)
      {
        if (i == 2) {}
      }
      else
      {
        long l = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob.a(this.jdField_a_of_type_Long, l);
        return;
      }
    }
    a(paramStoragePlatomProto, this.jdField_a_of_type_Long + paramInt);
  }
  
  void a(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    if (paramLong != paramStoragePlatomProto.a()) {
      this.jdField_a_of_type_Long = paramStoragePlatomProto.a();
    } else {
      this.jdField_a_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
  }
  
  public void a(UploadTransfer.ByteArrayBuffer paramByteArrayBuffer, boolean paramBoolean)
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (i > 10) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(new SoftReference(paramByteArrayBuffer));
      return;
    }
    finally {}
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
    //   1: invokespecial 79	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()Ljava/net/URL;
    //   4: astore 15
    //   6: new 419	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 43	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest	Lcom/tencent/weiyun/uploader/UploadRequest;
    //   14: invokevirtual 429	com/tencent/weiyun/uploader/UploadRequest:path	()Ljava/lang/String;
    //   17: ldc_w 431
    //   20: invokespecial 433	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 14
    //   25: aload_0
    //   26: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   29: ldc2_w 434
    //   32: lcmp
    //   33: ifle +32 -> 65
    //   36: new 258	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto
    //   39: dup
    //   40: sipush 1007
    //   43: aload_0
    //   44: getfield 63	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_ArrayOfByte	[B
    //   47: aload_0
    //   48: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   51: aload_0
    //   52: getfield 58	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ArrayOfByte	[B
    //   55: iconst_0
    //   56: i2l
    //   57: invokespecial 438	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   60: astore 13
    //   62: goto +29 -> 91
    //   65: new 258	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto
    //   68: dup
    //   69: sipush 1000
    //   72: aload_0
    //   73: getfield 63	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_ArrayOfByte	[B
    //   76: aload_0
    //   77: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   80: aload_0
    //   81: getfield 58	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ArrayOfByte	[B
    //   84: iconst_0
    //   85: i2l
    //   86: invokespecial 438	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   89: astore 13
    //   91: ldc_w 439
    //   94: newarray byte
    //   96: astore 16
    //   98: iconst_0
    //   99: istore_1
    //   100: aload_0
    //   101: getfield 45	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob	Lcom/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob;
    //   104: invokevirtual 243	com/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob:a	()Z
    //   107: istore 4
    //   109: iload 4
    //   111: ifne +16 -> 127
    //   114: aload_0
    //   115: aload 14
    //   117: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   120: aload_0
    //   121: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   124: ldc 244
    //   126: ireturn
    //   127: aload_0
    //   128: getfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   131: ifgt +33 -> 164
    //   134: getstatic 125	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   137: invokestatic 443	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Landroid/content/Context;)I
    //   140: istore_2
    //   141: iload_2
    //   142: ifge +17 -> 159
    //   145: aload_0
    //   146: aload 14
    //   148: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   151: aload_0
    //   152: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   155: ldc_w 368
    //   158: ireturn
    //   159: aload_0
    //   160: iload_2
    //   161: putfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   164: invokestatic 96	android/os/SystemClock:uptimeMillis	()J
    //   167: lstore 5
    //   169: aload_0
    //   170: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   173: lstore 7
    //   175: aload 14
    //   177: lload 7
    //   179: invokevirtual 446	java/io/RandomAccessFile:seek	(J)V
    //   182: aload 13
    //   184: invokevirtual 448	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:a	()I
    //   187: istore_3
    //   188: aload 14
    //   190: aload 16
    //   192: iload_3
    //   193: aload_0
    //   194: getfield 32	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Int	I
    //   197: invokevirtual 451	java/io/RandomAccessFile:read	([BII)I
    //   200: istore_2
    //   201: iload_2
    //   202: ifgt +37 -> 239
    //   205: aload_0
    //   206: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   209: lstore 9
    //   211: aload_0
    //   212: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   215: lstore 11
    //   217: lload 9
    //   219: lload 11
    //   221: lcmp
    //   222: ifge +17 -> 239
    //   225: aload_0
    //   226: aload 14
    //   228: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   231: aload_0
    //   232: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   235: ldc_w 452
    //   238: ireturn
    //   239: iload_2
    //   240: ifgt +18 -> 258
    //   243: aload_0
    //   244: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   247: aload_0
    //   248: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   251: lcmp
    //   252: ifne +6 -> 258
    //   255: goto +144 -> 399
    //   258: iload_1
    //   259: iconst_1
    //   260: iadd
    //   261: istore_1
    //   262: aload 13
    //   264: iload_1
    //   265: i2l
    //   266: invokevirtual 454	com/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto:a	(J)V
    //   269: aload_0
    //   270: aload 13
    //   272: aload 15
    //   274: aload 16
    //   276: iload_3
    //   277: iload_2
    //   278: invokevirtual 456	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Lcom/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   281: istore_3
    //   282: iload_3
    //   283: ifeq +15 -> 298
    //   286: aload_0
    //   287: aload 14
    //   289: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   292: aload_0
    //   293: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   296: iload_3
    //   297: ireturn
    //   298: aload_0
    //   299: getfield 45	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadWyUploadJob	Lcom/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob;
    //   302: invokevirtual 243	com/tencent/mobileqq/weiyun/sdk/upload/WyUploadJob:a	()Z
    //   305: istore 4
    //   307: iload 4
    //   309: ifne +16 -> 325
    //   312: aload_0
    //   313: aload 14
    //   315: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   318: aload_0
    //   319: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   322: ldc 244
    //   324: ireturn
    //   325: aload_0
    //   326: aload 13
    //   328: iload_2
    //   329: invokevirtual 458	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Lcom/tencent/mobileqq/weiyun/sdk/upload/StoragePlatomProto;I)V
    //   332: aload_0
    //   333: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   336: astore 17
    //   338: aload 17
    //   340: aload 17
    //   342: getfield 459	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_b_of_type_Long	J
    //   345: invokestatic 96	android/os/SystemClock:uptimeMillis	()J
    //   348: lload 5
    //   350: lsub
    //   351: ladd
    //   352: putfield 459	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_b_of_type_Long	J
    //   355: aload_0
    //   356: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   359: astore 17
    //   361: aload 17
    //   363: aload 17
    //   365: getfield 461	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:c	J
    //   368: aload_0
    //   369: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   372: lload 7
    //   374: lsub
    //   375: ladd
    //   376: putfield 461	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:c	J
    //   379: aload_0
    //   380: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   383: lstore 5
    //   385: aload_0
    //   386: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   389: lstore 7
    //   391: lload 5
    //   393: lload 7
    //   395: lcmp
    //   396: ifne +15 -> 411
    //   399: aload_0
    //   400: aload 14
    //   402: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   405: aload_0
    //   406: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   409: iconst_0
    //   410: ireturn
    //   411: aload_0
    //   412: getfield 65	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_Long	J
    //   415: lstore 5
    //   417: aload_0
    //   418: getfield 71	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_b_of_type_Long	J
    //   421: lstore 7
    //   423: lload 5
    //   425: lload 7
    //   427: lcmp
    //   428: ifle +17 -> 445
    //   431: aload_0
    //   432: aload 14
    //   434: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   437: aload_0
    //   438: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   441: ldc_w 462
    //   444: ireturn
    //   445: goto -345 -> 100
    //   448: astore 13
    //   450: goto +53 -> 503
    //   453: astore 13
    //   455: aload_0
    //   456: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   459: aload 13
    //   461: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   464: aload_0
    //   465: aload 14
    //   467: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   470: aload_0
    //   471: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   474: ldc_w 341
    //   477: ireturn
    //   478: astore 13
    //   480: aload_0
    //   481: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   484: aload 13
    //   486: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   489: aload_0
    //   490: aload 14
    //   492: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   495: aload_0
    //   496: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   499: ldc_w 463
    //   502: ireturn
    //   503: aload_0
    //   504: aload 14
    //   506: invokevirtual 441	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	(Ljava/io/RandomAccessFile;)V
    //   509: aload_0
    //   510: invokespecial 278	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:a	()V
    //   513: aload 13
    //   515: athrow
    //   516: astore 13
    //   518: aload_0
    //   519: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   522: aload 13
    //   524: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   527: ldc_w 464
    //   530: ireturn
    //   531: astore 13
    //   533: aload_0
    //   534: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   537: aload 13
    //   539: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   542: ldc_w 465
    //   545: ireturn
    //   546: astore 13
    //   548: aload_0
    //   549: getfield 76	com/tencent/mobileqq/weiyun/sdk/upload/UploadTransfer:jdField_a_of_type_ComTencentMobileqqWeiyunSdkUploadTransfer$ProcessInfo	Lcom/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo;
    //   552: aload 13
    //   554: putfield 340	com/tencent/mobileqq/weiyun/sdk/upload/Transfer$ProcessInfo:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   557: ldc_w 466
    //   560: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	UploadTransfer
    //   99	166	1	i	int
    //   140	189	2	j	int
    //   187	110	3	k	int
    //   107	201	4	bool	boolean
    //   167	257	5	l1	long
    //   173	253	7	l2	long
    //   209	9	9	l3	long
    //   215	5	11	l4	long
    //   60	267	13	localStoragePlatomProto	StoragePlatomProto
    //   448	1	13	localObject	Object
    //   453	7	13	localException	java.lang.Exception
    //   478	36	13	localIOException	IOException
    //   516	7	13	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   531	7	13	localMalformedURLException	MalformedURLException
    //   546	7	13	localFileNotFoundException	java.io.FileNotFoundException
    //   23	482	14	localRandomAccessFile	RandomAccessFile
    //   4	269	15	localURL	URL
    //   96	179	16	arrayOfByte	byte[]
    //   336	28	17	localProcessInfo	Transfer.ProcessInfo
    // Exception table:
    //   from	to	target	type
    //   100	109	448	finally
    //   127	141	448	finally
    //   159	164	448	finally
    //   164	201	448	finally
    //   205	217	448	finally
    //   243	255	448	finally
    //   262	282	448	finally
    //   298	307	448	finally
    //   325	391	448	finally
    //   411	423	448	finally
    //   455	464	448	finally
    //   480	489	448	finally
    //   100	109	453	java/lang/Exception
    //   127	141	453	java/lang/Exception
    //   159	164	453	java/lang/Exception
    //   164	201	453	java/lang/Exception
    //   205	217	453	java/lang/Exception
    //   243	255	453	java/lang/Exception
    //   262	282	453	java/lang/Exception
    //   298	307	453	java/lang/Exception
    //   325	391	453	java/lang/Exception
    //   411	423	453	java/lang/Exception
    //   100	109	478	java/io/IOException
    //   127	141	478	java/io/IOException
    //   159	164	478	java/io/IOException
    //   164	201	478	java/io/IOException
    //   205	217	478	java/io/IOException
    //   243	255	478	java/io/IOException
    //   262	282	478	java/io/IOException
    //   298	307	478	java/io/IOException
    //   325	391	478	java/io/IOException
    //   411	423	478	java/io/IOException
    //   25	62	516	java/lang/IllegalArgumentException
    //   65	91	516	java/lang/IllegalArgumentException
    //   0	25	531	java/net/MalformedURLException
    //   0	25	546	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.upload.UploadTransfer
 * JD-Core Version:    0.7.0.1
 */