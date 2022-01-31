package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;

public class EchoTask
{
  private static final int DEFAULT_2G_TIMEOUT = 20000;
  private static final int DEFAULT_3G_TIMEOUT = 15000;
  private static final int DEFAULT_4G_TIMEOUT = 10000;
  private static final int DEFAULT_WIFI_TIMEOUT = 10000;
  private static Pair<String, String>[] ECHO_ADDRESS = { new Pair("http://183.60.50.149:8080/cgi-bin/httpecho?len=20", null), new Pair("http://112.90.137.111:8080/cgi-bin/httpecho?len=20", null), new Pair("http://120.198.191.71:8080/cgi-bin/httpecho?len=20", null) };
  public static final int ECHO_EXCEPTION = 3;
  public static final int ECHO_NORMAL = 1;
  public static final int ECHO_REDIRECT_EXCEPTION = -1000;
  public static final int ECHO_RESPONSECODE_EXCEPTION = -999;
  public static final int ECHO_RESP_LENGTH = 20;
  public static final int ECHO_SERVER_EXCEPTION = -998;
  public static final int ECHO_UNKONW_EXCEPTION = -997;
  public static final int ECHO_WRONG_CONTENT = 2;
  private static final int MAX_REDIRECT_TIME = 5;
  private String errorMsg = "unkonw";
  private Context mContext;
  private String mExpectContent;
  private String mRealResponse;
  private String mRequestURL;
  private String mResponseURL;
  private int mTimeout;
  public int mType;
  private int responseCode;
  
  public EchoTask(Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public EchoTask(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
    this.mTimeout = getTimeoutMills();
  }
  
  private void fillErrorMsg(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -998: 
      this.errorMsg = ("echo connect exception:" + paramString);
      return;
    case -1000: 
      this.errorMsg = ("echo connect redirect error:" + paramString);
      return;
    case -997: 
      this.errorMsg = ("echo unkonw exception:" + paramString);
      return;
    }
    this.errorMsg = ("echo response exception,the responseCode is:" + paramString);
  }
  
  private String getMethod(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "GET";
    }
    return "POST";
  }
  
  private int getSystemNetwork()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {}
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      return 0;
    case 9: 
      return 5;
    case 1: 
    case 6: 
      return 1;
    }
    switch (((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType())
    {
    case 4: 
    case 7: 
    case 11: 
    default: 
      return 2;
    case 13: 
      return 4;
    }
    return 3;
  }
  
  private int getTimeoutMills()
  {
    switch (getSystemNetwork())
    {
    case 2: 
    default: 
      return 20000;
    case 3: 
      return 15000;
    case 4: 
      return 10000;
    }
    return 10000;
  }
  
  public boolean checkEchoResp(String paramString)
  {
    paramString = paramString.toCharArray();
    if (paramString.length != 20) {
      return false;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (('A' > paramString[i]) || (paramString[i] > 'Z')) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  /* Error */
  public int doEcho()
  {
    // Byte code:
    //   0: getstatic 60	com/tencent/mobileqq/highway/netprobe/EchoTask:ECHO_ADDRESS	[Landroid/util/Pair;
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 9
    //   10: arraylength
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge +851 -> 867
    //   19: aload 5
    //   21: astore 6
    //   23: aload 5
    //   25: astore 7
    //   27: aload_0
    //   28: aload 9
    //   30: iload_2
    //   31: aaload
    //   32: getfield 158	android/util/Pair:first	Ljava/lang/Object;
    //   35: checkcast 145	java/lang/String
    //   38: putfield 160	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   41: aload 5
    //   43: astore 6
    //   45: aload 5
    //   47: astore 7
    //   49: aload_0
    //   50: aload 9
    //   52: iload_2
    //   53: aaload
    //   54: getfield 163	android/util/Pair:second	Ljava/lang/Object;
    //   57: checkcast 145	java/lang/String
    //   60: putfield 165	com/tencent/mobileqq/highway/netprobe/EchoTask:mExpectContent	Ljava/lang/String;
    //   63: aload 5
    //   65: astore 6
    //   67: aload 5
    //   69: astore 7
    //   71: aload_0
    //   72: getfield 160	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   75: astore 8
    //   77: iconst_0
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_5
    //   81: if_icmpge +812 -> 893
    //   84: aload 5
    //   86: astore 6
    //   88: aload 5
    //   90: astore 7
    //   92: new 167	java/net/URL
    //   95: dup
    //   96: aload 8
    //   98: invokespecial 170	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 174	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 176	java/net/HttpURLConnection
    //   107: astore 5
    //   109: aload 5
    //   111: astore 7
    //   113: aload 5
    //   115: astore 6
    //   117: aload 5
    //   119: iconst_1
    //   120: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
    //   123: aload 5
    //   125: astore 7
    //   127: aload 5
    //   129: astore 6
    //   131: aload 5
    //   133: iconst_1
    //   134: invokevirtual 183	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   137: aload 5
    //   139: astore 7
    //   141: aload 5
    //   143: astore 6
    //   145: aload 5
    //   147: iconst_0
    //   148: invokevirtual 186	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   151: aload 5
    //   153: astore 7
    //   155: aload 5
    //   157: astore 6
    //   159: aload 5
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 75	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   166: invokespecial 188	com/tencent/mobileqq/highway/netprobe/EchoTask:getMethod	(I)Ljava/lang/String;
    //   169: invokevirtual 191	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   172: aload 5
    //   174: astore 7
    //   176: aload 5
    //   178: astore 6
    //   180: aload 5
    //   182: aload_0
    //   183: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   186: invokevirtual 195	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   189: aload 5
    //   191: astore 7
    //   193: aload 5
    //   195: astore 6
    //   197: aload 5
    //   199: aload_0
    //   200: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   203: invokevirtual 198	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   206: aload 5
    //   208: astore 7
    //   210: aload 5
    //   212: astore 6
    //   214: aload 5
    //   216: invokevirtual 201	java/net/HttpURLConnection:connect	()V
    //   219: aload 5
    //   221: astore 7
    //   223: aload 5
    //   225: astore 6
    //   227: aload_0
    //   228: getfield 75	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   231: iconst_2
    //   232: if_icmpne +81 -> 313
    //   235: aload 5
    //   237: astore 7
    //   239: aload 5
    //   241: astore 6
    //   243: aload 5
    //   245: invokevirtual 205	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   248: astore 8
    //   250: aload 5
    //   252: astore 7
    //   254: aload 5
    //   256: astore 6
    //   258: sipush 2048
    //   261: newarray byte
    //   263: astore 10
    //   265: aload 5
    //   267: astore 7
    //   269: aload 5
    //   271: astore 6
    //   273: new 207	java/util/Random
    //   276: dup
    //   277: invokespecial 208	java/util/Random:<init>	()V
    //   280: aload 10
    //   282: invokevirtual 212	java/util/Random:nextBytes	([B)V
    //   285: aload 5
    //   287: astore 7
    //   289: aload 5
    //   291: astore 6
    //   293: aload 8
    //   295: aload 10
    //   297: invokevirtual 217	java/io/OutputStream:write	([B)V
    //   300: aload 5
    //   302: astore 7
    //   304: aload 5
    //   306: astore 6
    //   308: aload 8
    //   310: invokevirtual 220	java/io/OutputStream:flush	()V
    //   313: aload 5
    //   315: astore 7
    //   317: aload 5
    //   319: astore 6
    //   321: aload_0
    //   322: aload 5
    //   324: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   327: putfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   330: aload 5
    //   332: astore 7
    //   334: aload 5
    //   336: astore 6
    //   338: aload_0
    //   339: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   342: sipush 301
    //   345: if_icmpeq +21 -> 366
    //   348: aload 5
    //   350: astore 7
    //   352: aload 5
    //   354: astore 6
    //   356: aload_0
    //   357: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   360: sipush 302
    //   363: if_icmpne +315 -> 678
    //   366: iload_1
    //   367: iconst_1
    //   368: iadd
    //   369: iconst_5
    //   370: if_icmpne +262 -> 632
    //   373: aload 5
    //   375: astore 7
    //   377: aload 5
    //   379: astore 6
    //   381: aload_0
    //   382: sipush -1000
    //   385: ldc 227
    //   387: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   390: iconst_1
    //   391: istore_1
    //   392: iload_1
    //   393: ifne +438 -> 831
    //   396: aload 5
    //   398: astore 7
    //   400: aload 5
    //   402: astore 6
    //   404: aload_0
    //   405: aload 5
    //   407: invokevirtual 233	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   410: invokevirtual 234	java/net/URL:toString	()Ljava/lang/String;
    //   413: putfield 236	com/tencent/mobileqq/highway/netprobe/EchoTask:mResponseURL	Ljava/lang/String;
    //   416: aload 5
    //   418: astore 7
    //   420: aload 5
    //   422: astore 6
    //   424: aload_0
    //   425: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   428: sipush 200
    //   431: if_icmpeq +21 -> 452
    //   434: aload 5
    //   436: astore 7
    //   438: aload 5
    //   440: astore 6
    //   442: aload_0
    //   443: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   446: sipush 206
    //   449: if_icmpne +332 -> 781
    //   452: aload 5
    //   454: astore 7
    //   456: aload 5
    //   458: astore 6
    //   460: new 238	java/io/BufferedReader
    //   463: dup
    //   464: new 240	java/io/InputStreamReader
    //   467: dup
    //   468: aload 5
    //   470: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   473: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   476: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   479: astore 8
    //   481: aload 5
    //   483: astore 7
    //   485: aload 5
    //   487: astore 6
    //   489: new 85	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   496: astore 10
    //   498: aload 5
    //   500: astore 7
    //   502: aload 5
    //   504: astore 6
    //   506: aload 8
    //   508: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   511: astore 11
    //   513: aload 11
    //   515: ifnull +186 -> 701
    //   518: aload 5
    //   520: astore 7
    //   522: aload 5
    //   524: astore 6
    //   526: aload 10
    //   528: new 85	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   535: aload 11
    //   537: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc 255
    //   542: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: goto -54 -> 498
    //   555: astore 8
    //   557: aload 7
    //   559: astore 5
    //   561: aload 5
    //   563: astore 6
    //   565: aload 5
    //   567: invokevirtual 258	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   570: astore 7
    //   572: aload 5
    //   574: astore 6
    //   576: aload 7
    //   578: invokevirtual 263	java/io/InputStream:read	()I
    //   581: istore_1
    //   582: iload_1
    //   583: iconst_m1
    //   584: if_icmpne -12 -> 572
    //   587: aload 5
    //   589: astore 6
    //   591: aload_0
    //   592: sipush -997
    //   595: aload 8
    //   597: invokevirtual 264	java/io/IOException:toString	()Ljava/lang/String;
    //   600: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   603: aload 5
    //   605: astore 6
    //   607: aload 5
    //   609: ifnull +12 -> 621
    //   612: aload 5
    //   614: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   617: aload 5
    //   619: astore 6
    //   621: iload_2
    //   622: iconst_1
    //   623: iadd
    //   624: istore_2
    //   625: aload 6
    //   627: astore 5
    //   629: goto -615 -> 14
    //   632: aload 5
    //   634: astore 7
    //   636: aload 5
    //   638: astore 6
    //   640: aload 5
    //   642: ldc_w 269
    //   645: invokevirtual 273	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore 8
    //   650: aload 8
    //   652: ifnonnull +246 -> 898
    //   655: aload 5
    //   657: astore 7
    //   659: aload 5
    //   661: astore 6
    //   663: aload_0
    //   664: sipush -1000
    //   667: ldc_w 275
    //   670: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   673: iconst_1
    //   674: istore_1
    //   675: goto -283 -> 392
    //   678: aload 5
    //   680: astore 7
    //   682: aload 5
    //   684: astore 6
    //   686: aload_0
    //   687: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   690: sipush 404
    //   693: if_icmpne +195 -> 888
    //   696: iconst_1
    //   697: istore_1
    //   698: goto -306 -> 392
    //   701: aload 5
    //   703: astore 7
    //   705: aload 5
    //   707: astore 6
    //   709: aload 8
    //   711: invokevirtual 278	java/io/BufferedReader:close	()V
    //   714: aload 5
    //   716: astore 7
    //   718: aload 5
    //   720: astore 6
    //   722: aload_0
    //   723: aload 10
    //   725: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokevirtual 281	java/lang/String:trim	()Ljava/lang/String;
    //   731: putfield 283	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   734: aload 5
    //   736: astore 7
    //   738: aload 5
    //   740: astore 6
    //   742: aload_0
    //   743: aload_0
    //   744: getfield 283	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   747: invokevirtual 285	com/tencent/mobileqq/highway/netprobe/EchoTask:checkEchoResp	(Ljava/lang/String;)Z
    //   750: istore 4
    //   752: iload 4
    //   754: ifeq +15 -> 769
    //   757: aload 5
    //   759: ifnull +8 -> 767
    //   762: aload 5
    //   764: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   767: iconst_1
    //   768: ireturn
    //   769: aload 5
    //   771: ifnull +8 -> 779
    //   774: aload 5
    //   776: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   779: iconst_2
    //   780: ireturn
    //   781: aload 5
    //   783: astore 7
    //   785: aload 5
    //   787: astore 6
    //   789: aload_0
    //   790: sipush -999
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: aload_0
    //   801: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   804: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   807: ldc_w 290
    //   810: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   819: aload 5
    //   821: ifnull +8 -> 829
    //   824: aload 5
    //   826: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   829: iconst_3
    //   830: ireturn
    //   831: aload 5
    //   833: astore 6
    //   835: aload 5
    //   837: ifnull -216 -> 621
    //   840: aload 5
    //   842: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   845: aload 5
    //   847: astore 6
    //   849: goto -228 -> 621
    //   852: astore 5
    //   854: aload 6
    //   856: ifnull +8 -> 864
    //   859: aload 6
    //   861: invokevirtual 267	java/net/HttpURLConnection:disconnect	()V
    //   864: aload 5
    //   866: athrow
    //   867: iconst_3
    //   868: ireturn
    //   869: astore 5
    //   871: goto -17 -> 854
    //   874: astore 6
    //   876: goto -289 -> 587
    //   879: astore 8
    //   881: aload 7
    //   883: astore 5
    //   885: goto -324 -> 561
    //   888: iconst_0
    //   889: istore_1
    //   890: goto -498 -> 392
    //   893: iconst_0
    //   894: istore_1
    //   895: goto -503 -> 392
    //   898: iload_1
    //   899: iconst_1
    //   900: iadd
    //   901: istore_1
    //   902: goto -823 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	this	EchoTask
    //   78	824	1	i	int
    //   13	612	2	j	int
    //   11	6	3	k	int
    //   750	3	4	bool	boolean
    //   6	840	5	localObject1	Object
    //   852	13	5	localObject2	Object
    //   869	1	5	localObject3	Object
    //   883	1	5	localObject4	Object
    //   21	839	6	localObject5	Object
    //   874	1	6	localException	java.lang.Exception
    //   25	857	7	localObject6	Object
    //   75	432	8	localObject7	Object
    //   555	41	8	localIOException1	java.io.IOException
    //   648	62	8	str1	String
    //   879	1	8	localIOException2	java.io.IOException
    //   3	48	9	arrayOfPair	Pair[]
    //   263	461	10	localObject8	Object
    //   511	25	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   117	123	555	java/io/IOException
    //   131	137	555	java/io/IOException
    //   145	151	555	java/io/IOException
    //   159	172	555	java/io/IOException
    //   180	189	555	java/io/IOException
    //   197	206	555	java/io/IOException
    //   214	219	555	java/io/IOException
    //   227	235	555	java/io/IOException
    //   243	250	555	java/io/IOException
    //   258	265	555	java/io/IOException
    //   273	285	555	java/io/IOException
    //   293	300	555	java/io/IOException
    //   308	313	555	java/io/IOException
    //   321	330	555	java/io/IOException
    //   338	348	555	java/io/IOException
    //   356	366	555	java/io/IOException
    //   381	390	555	java/io/IOException
    //   404	416	555	java/io/IOException
    //   424	434	555	java/io/IOException
    //   442	452	555	java/io/IOException
    //   460	481	555	java/io/IOException
    //   489	498	555	java/io/IOException
    //   506	513	555	java/io/IOException
    //   526	552	555	java/io/IOException
    //   640	650	555	java/io/IOException
    //   663	673	555	java/io/IOException
    //   686	696	555	java/io/IOException
    //   709	714	555	java/io/IOException
    //   722	734	555	java/io/IOException
    //   742	752	555	java/io/IOException
    //   789	819	555	java/io/IOException
    //   117	123	852	finally
    //   131	137	852	finally
    //   145	151	852	finally
    //   159	172	852	finally
    //   180	189	852	finally
    //   197	206	852	finally
    //   214	219	852	finally
    //   227	235	852	finally
    //   243	250	852	finally
    //   258	265	852	finally
    //   273	285	852	finally
    //   293	300	852	finally
    //   308	313	852	finally
    //   321	330	852	finally
    //   338	348	852	finally
    //   356	366	852	finally
    //   381	390	852	finally
    //   404	416	852	finally
    //   424	434	852	finally
    //   442	452	852	finally
    //   460	481	852	finally
    //   489	498	852	finally
    //   506	513	852	finally
    //   526	552	852	finally
    //   565	572	852	finally
    //   576	582	852	finally
    //   591	603	852	finally
    //   640	650	852	finally
    //   663	673	852	finally
    //   686	696	852	finally
    //   709	714	852	finally
    //   722	734	852	finally
    //   742	752	852	finally
    //   789	819	852	finally
    //   27	41	869	finally
    //   49	63	869	finally
    //   71	77	869	finally
    //   92	109	869	finally
    //   565	572	874	java/lang/Exception
    //   576	582	874	java/lang/Exception
    //   27	41	879	java/io/IOException
    //   49	63	879	java/io/IOException
    //   71	77	879	java/io/IOException
    //   92	109	879	java/io/IOException
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public String getExpectContent()
  {
    return this.mExpectContent;
  }
  
  public String getResponseContent()
  {
    return this.mRealResponse;
  }
  
  public String getResponseUrl()
  {
    return this.mResponseURL;
  }
  
  public int getTimeout()
  {
    return this.mTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.EchoTask
 * JD-Core Version:    0.7.0.1
 */