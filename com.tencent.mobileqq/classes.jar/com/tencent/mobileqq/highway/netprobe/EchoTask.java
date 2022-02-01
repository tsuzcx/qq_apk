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
    case -997: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("echo unkonw exception:");
      localStringBuilder.append(paramString);
      this.errorMsg = localStringBuilder.toString();
      return;
    case -998: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("echo connect exception:");
      localStringBuilder.append(paramString);
      this.errorMsg = localStringBuilder.toString();
      return;
    case -999: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("echo response exception,the responseCode is:");
      localStringBuilder.append(paramString);
      this.errorMsg = localStringBuilder.toString();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("echo connect redirect error:");
    localStringBuilder.append(paramString);
    this.errorMsg = localStringBuilder.toString();
  }
  
  private String getMethod(int paramInt)
  {
    if (paramInt != 2) {
      return "GET";
    }
    return "POST";
  }
  
  private int getSystemNetwork()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      int i = localNetworkInfo.getType();
      if (i != 9) {
        switch (i)
        {
        default: 
          break;
        case 1: 
        case 6: 
          return 1;
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
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
      } else {
        return 5;
      }
    }
    return 0;
  }
  
  private int getTimeoutMills()
  {
    int i = getSystemNetwork();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return 20000;
          }
          return 10000;
        }
        return 15000;
      }
      return 20000;
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
    while (i < j) {
      if (('A' <= paramString[i]) && (paramString[i] <= 'Z')) {
        i += 1;
      } else {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public int doEcho()
  {
    // Byte code:
    //   0: getstatic 60	com/tencent/mobileqq/highway/netprobe/EchoTask:ECHO_ADDRESS	[Landroid/util/Pair;
    //   3: astore 9
    //   5: aload 9
    //   7: arraylength
    //   8: istore_3
    //   9: aconst_null
    //   10: astore 5
    //   12: iconst_0
    //   13: istore_1
    //   14: iload_1
    //   15: iload_3
    //   16: if_icmpge +913 -> 929
    //   19: aload_0
    //   20: aload 9
    //   22: iload_1
    //   23: aaload
    //   24: getfield 158	android/util/Pair:first	Ljava/lang/Object;
    //   27: checkcast 145	java/lang/String
    //   30: putfield 160	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   33: aload_0
    //   34: aload 9
    //   36: iload_1
    //   37: aaload
    //   38: getfield 163	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 145	java/lang/String
    //   44: putfield 165	com/tencent/mobileqq/highway/netprobe/EchoTask:mExpectContent	Ljava/lang/String;
    //   47: aload_0
    //   48: getfield 160	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   51: astore 7
    //   53: iconst_0
    //   54: istore_2
    //   55: aload 5
    //   57: astore 6
    //   59: iload_2
    //   60: iconst_5
    //   61: if_icmpge +905 -> 966
    //   64: new 167	java/net/URL
    //   67: dup
    //   68: aload 7
    //   70: invokespecial 170	java/net/URL:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 174	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   76: checkcast 176	java/net/HttpURLConnection
    //   79: astore 5
    //   81: aload 5
    //   83: astore 7
    //   85: aload 5
    //   87: astore 6
    //   89: aload 5
    //   91: iconst_1
    //   92: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
    //   95: aload 5
    //   97: astore 7
    //   99: aload 5
    //   101: astore 6
    //   103: aload 5
    //   105: iconst_1
    //   106: invokevirtual 183	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   109: aload 5
    //   111: astore 7
    //   113: aload 5
    //   115: astore 6
    //   117: aload 5
    //   119: iconst_0
    //   120: invokevirtual 186	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   123: aload 5
    //   125: astore 7
    //   127: aload 5
    //   129: astore 6
    //   131: aload 5
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 75	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   138: invokespecial 188	com/tencent/mobileqq/highway/netprobe/EchoTask:getMethod	(I)Ljava/lang/String;
    //   141: invokevirtual 191	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: aload 5
    //   146: astore 7
    //   148: aload 5
    //   150: astore 6
    //   152: aload 5
    //   154: aload_0
    //   155: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   158: invokevirtual 195	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   161: aload 5
    //   163: astore 7
    //   165: aload 5
    //   167: astore 6
    //   169: aload 5
    //   171: aload_0
    //   172: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   175: invokevirtual 198	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   178: aload 5
    //   180: astore 7
    //   182: aload 5
    //   184: astore 6
    //   186: aload 5
    //   188: invokevirtual 201	java/net/HttpURLConnection:connect	()V
    //   191: aload 5
    //   193: astore 7
    //   195: aload 5
    //   197: astore 6
    //   199: aload_0
    //   200: getfield 75	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   203: iconst_2
    //   204: if_icmpne +81 -> 285
    //   207: aload 5
    //   209: astore 7
    //   211: aload 5
    //   213: astore 6
    //   215: aload 5
    //   217: invokevirtual 205	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   220: astore 8
    //   222: aload 5
    //   224: astore 7
    //   226: aload 5
    //   228: astore 6
    //   230: sipush 2048
    //   233: newarray byte
    //   235: astore 10
    //   237: aload 5
    //   239: astore 7
    //   241: aload 5
    //   243: astore 6
    //   245: new 207	java/util/Random
    //   248: dup
    //   249: invokespecial 208	java/util/Random:<init>	()V
    //   252: aload 10
    //   254: invokevirtual 212	java/util/Random:nextBytes	([B)V
    //   257: aload 5
    //   259: astore 7
    //   261: aload 5
    //   263: astore 6
    //   265: aload 8
    //   267: aload 10
    //   269: invokevirtual 217	java/io/OutputStream:write	([B)V
    //   272: aload 5
    //   274: astore 7
    //   276: aload 5
    //   278: astore 6
    //   280: aload 8
    //   282: invokevirtual 220	java/io/OutputStream:flush	()V
    //   285: aload 5
    //   287: astore 7
    //   289: aload 5
    //   291: astore 6
    //   293: aload_0
    //   294: aload 5
    //   296: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   299: putfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   302: aload 5
    //   304: astore 7
    //   306: aload 5
    //   308: astore 6
    //   310: aload_0
    //   311: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   314: sipush 301
    //   317: if_icmpeq +49 -> 366
    //   320: aload 5
    //   322: astore 7
    //   324: aload 5
    //   326: astore 6
    //   328: aload_0
    //   329: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   332: sipush 302
    //   335: if_icmpne +6 -> 341
    //   338: goto +28 -> 366
    //   341: aload 5
    //   343: astore 7
    //   345: aload 5
    //   347: astore 6
    //   349: aload 5
    //   351: astore 8
    //   353: aload_0
    //   354: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   357: sipush 404
    //   360: if_icmpne +610 -> 970
    //   363: goto +573 -> 936
    //   366: iload_2
    //   367: iconst_1
    //   368: iadd
    //   369: istore_2
    //   370: iload_2
    //   371: iconst_5
    //   372: if_icmpne +23 -> 395
    //   375: aload 5
    //   377: astore 7
    //   379: aload 5
    //   381: astore 6
    //   383: aload_0
    //   384: sipush -1000
    //   387: ldc 227
    //   389: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   392: goto +544 -> 936
    //   395: aload 5
    //   397: astore 7
    //   399: aload 5
    //   401: astore 6
    //   403: aload 5
    //   405: ldc 231
    //   407: invokevirtual 235	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore 8
    //   412: aload 8
    //   414: ifnonnull +527 -> 941
    //   417: aload 5
    //   419: astore 7
    //   421: aload 5
    //   423: astore 6
    //   425: aload_0
    //   426: sipush -1000
    //   429: ldc 237
    //   431: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   434: goto +502 -> 936
    //   437: iload_2
    //   438: ifne +372 -> 810
    //   441: aload 5
    //   443: astore 7
    //   445: aload 5
    //   447: astore 6
    //   449: aload_0
    //   450: aload 5
    //   452: invokevirtual 241	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   455: invokevirtual 242	java/net/URL:toString	()Ljava/lang/String;
    //   458: putfield 244	com/tencent/mobileqq/highway/netprobe/EchoTask:mResponseURL	Ljava/lang/String;
    //   461: aload 5
    //   463: astore 7
    //   465: aload 5
    //   467: astore 6
    //   469: aload_0
    //   470: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   473: sipush 200
    //   476: if_icmpeq +107 -> 583
    //   479: aload 5
    //   481: astore 7
    //   483: aload 5
    //   485: astore 6
    //   487: aload_0
    //   488: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   491: sipush 206
    //   494: if_icmpne +6 -> 500
    //   497: goto +86 -> 583
    //   500: aload 5
    //   502: astore 7
    //   504: aload 5
    //   506: astore 6
    //   508: new 85	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   515: astore 8
    //   517: aload 5
    //   519: astore 7
    //   521: aload 5
    //   523: astore 6
    //   525: aload 8
    //   527: aload_0
    //   528: getfield 225	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   531: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 5
    //   537: astore 7
    //   539: aload 5
    //   541: astore 6
    //   543: aload 8
    //   545: ldc 249
    //   547: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 5
    //   553: astore 7
    //   555: aload 5
    //   557: astore 6
    //   559: aload_0
    //   560: sipush -999
    //   563: aload 8
    //   565: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   571: aload 5
    //   573: ifnull +8 -> 581
    //   576: aload 5
    //   578: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   581: iconst_3
    //   582: ireturn
    //   583: aload 5
    //   585: astore 7
    //   587: aload 5
    //   589: astore 6
    //   591: new 254	java/io/BufferedReader
    //   594: dup
    //   595: new 256	java/io/InputStreamReader
    //   598: dup
    //   599: aload 5
    //   601: invokevirtual 260	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   604: invokespecial 263	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   607: invokespecial 266	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   610: astore 8
    //   612: aload 5
    //   614: astore 7
    //   616: aload 5
    //   618: astore 6
    //   620: new 85	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   627: astore 10
    //   629: aload 5
    //   631: astore 7
    //   633: aload 5
    //   635: astore 6
    //   637: aload 8
    //   639: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   642: astore 11
    //   644: aload 11
    //   646: ifnull +75 -> 721
    //   649: aload 5
    //   651: astore 7
    //   653: aload 5
    //   655: astore 6
    //   657: new 85	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   664: astore 12
    //   666: aload 5
    //   668: astore 7
    //   670: aload 5
    //   672: astore 6
    //   674: aload 12
    //   676: aload 11
    //   678: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload 5
    //   684: astore 7
    //   686: aload 5
    //   688: astore 6
    //   690: aload 12
    //   692: ldc_w 271
    //   695: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 5
    //   701: astore 7
    //   703: aload 5
    //   705: astore 6
    //   707: aload 10
    //   709: aload 12
    //   711: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: goto -89 -> 629
    //   721: aload 5
    //   723: astore 7
    //   725: aload 5
    //   727: astore 6
    //   729: aload 8
    //   731: invokevirtual 274	java/io/BufferedReader:close	()V
    //   734: aload 5
    //   736: astore 7
    //   738: aload 5
    //   740: astore 6
    //   742: aload_0
    //   743: aload 10
    //   745: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   751: putfield 279	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   754: aload 5
    //   756: astore 7
    //   758: aload 5
    //   760: astore 6
    //   762: aload_0
    //   763: aload_0
    //   764: getfield 279	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   767: invokevirtual 281	com/tencent/mobileqq/highway/netprobe/EchoTask:checkEchoResp	(Ljava/lang/String;)Z
    //   770: istore 4
    //   772: iload 4
    //   774: ifeq +15 -> 789
    //   777: aload 5
    //   779: ifnull +8 -> 787
    //   782: aload 5
    //   784: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   787: iconst_1
    //   788: ireturn
    //   789: aload 5
    //   791: ifnull +8 -> 799
    //   794: aload 5
    //   796: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   799: iconst_2
    //   800: ireturn
    //   801: astore 8
    //   803: aload 7
    //   805: astore 5
    //   807: goto +30 -> 837
    //   810: aload 5
    //   812: astore 6
    //   814: aload 5
    //   816: ifnull +89 -> 905
    //   819: goto +77 -> 896
    //   822: astore 7
    //   824: aload 5
    //   826: astore 6
    //   828: aload 7
    //   830: astore 5
    //   832: goto +84 -> 916
    //   835: astore 8
    //   837: aload 5
    //   839: astore 6
    //   841: aload 5
    //   843: invokevirtual 284	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   846: astore 7
    //   848: aload 5
    //   850: astore 6
    //   852: aload 7
    //   854: invokevirtual 289	java/io/InputStream:read	()I
    //   857: istore_2
    //   858: iload_2
    //   859: iconst_m1
    //   860: if_icmpeq +11 -> 871
    //   863: goto -15 -> 848
    //   866: astore 5
    //   868: goto +48 -> 916
    //   871: aload 5
    //   873: astore 6
    //   875: aload_0
    //   876: sipush -997
    //   879: aload 8
    //   881: invokevirtual 290	java/io/IOException:toString	()Ljava/lang/String;
    //   884: invokespecial 229	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   887: aload 5
    //   889: astore 6
    //   891: aload 5
    //   893: ifnull +12 -> 905
    //   896: aload 5
    //   898: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   901: aload 5
    //   903: astore 6
    //   905: aload 6
    //   907: astore 5
    //   909: iload_1
    //   910: iconst_1
    //   911: iadd
    //   912: istore_1
    //   913: goto -899 -> 14
    //   916: aload 6
    //   918: ifnull +8 -> 926
    //   921: aload 6
    //   923: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   926: aload 5
    //   928: athrow
    //   929: iconst_3
    //   930: ireturn
    //   931: astore 6
    //   933: goto -62 -> 871
    //   936: iconst_1
    //   937: istore_2
    //   938: goto -501 -> 437
    //   941: aload 8
    //   943: astore 7
    //   945: aload 5
    //   947: astore 6
    //   949: goto -890 -> 59
    //   952: astore 5
    //   954: goto -38 -> 916
    //   957: astore 8
    //   959: aload 6
    //   961: astore 5
    //   963: goto -126 -> 837
    //   966: aload 6
    //   968: astore 8
    //   970: iconst_0
    //   971: istore_2
    //   972: aload 8
    //   974: astore 5
    //   976: goto -539 -> 437
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	this	EchoTask
    //   13	900	1	i	int
    //   54	918	2	j	int
    //   8	9	3	k	int
    //   770	3	4	bool	boolean
    //   10	839	5	localObject1	Object
    //   866	36	5	localObject2	Object
    //   907	39	5	localObject3	Object
    //   952	1	5	localObject4	Object
    //   961	14	5	localObject5	Object
    //   57	865	6	localObject6	Object
    //   931	1	6	localException	java.lang.Exception
    //   947	20	6	localObject7	Object
    //   51	753	7	localObject8	Object
    //   822	7	7	localObject9	Object
    //   846	98	7	localObject10	Object
    //   220	510	8	localObject11	Object
    //   801	1	8	localIOException1	java.io.IOException
    //   835	107	8	localIOException2	java.io.IOException
    //   957	1	8	localIOException3	java.io.IOException
    //   968	5	8	localObject12	Object
    //   3	32	9	arrayOfPair	Pair[]
    //   235	509	10	localObject13	Object
    //   642	35	11	str	String
    //   664	46	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	95	801	java/io/IOException
    //   103	109	801	java/io/IOException
    //   117	123	801	java/io/IOException
    //   131	144	801	java/io/IOException
    //   152	161	801	java/io/IOException
    //   169	178	801	java/io/IOException
    //   186	191	801	java/io/IOException
    //   199	207	801	java/io/IOException
    //   215	222	801	java/io/IOException
    //   230	237	801	java/io/IOException
    //   245	257	801	java/io/IOException
    //   265	272	801	java/io/IOException
    //   280	285	801	java/io/IOException
    //   293	302	801	java/io/IOException
    //   310	320	801	java/io/IOException
    //   328	338	801	java/io/IOException
    //   353	363	801	java/io/IOException
    //   383	392	801	java/io/IOException
    //   403	412	801	java/io/IOException
    //   425	434	801	java/io/IOException
    //   449	461	801	java/io/IOException
    //   469	479	801	java/io/IOException
    //   487	497	801	java/io/IOException
    //   508	517	801	java/io/IOException
    //   525	535	801	java/io/IOException
    //   543	551	801	java/io/IOException
    //   559	571	801	java/io/IOException
    //   591	612	801	java/io/IOException
    //   620	629	801	java/io/IOException
    //   637	644	801	java/io/IOException
    //   657	666	801	java/io/IOException
    //   674	682	801	java/io/IOException
    //   690	699	801	java/io/IOException
    //   707	718	801	java/io/IOException
    //   729	734	801	java/io/IOException
    //   742	754	801	java/io/IOException
    //   762	772	801	java/io/IOException
    //   19	53	822	finally
    //   19	53	835	java/io/IOException
    //   89	95	866	finally
    //   103	109	866	finally
    //   117	123	866	finally
    //   131	144	866	finally
    //   152	161	866	finally
    //   169	178	866	finally
    //   186	191	866	finally
    //   199	207	866	finally
    //   215	222	866	finally
    //   230	237	866	finally
    //   245	257	866	finally
    //   265	272	866	finally
    //   280	285	866	finally
    //   293	302	866	finally
    //   310	320	866	finally
    //   328	338	866	finally
    //   353	363	866	finally
    //   383	392	866	finally
    //   403	412	866	finally
    //   425	434	866	finally
    //   449	461	866	finally
    //   469	479	866	finally
    //   487	497	866	finally
    //   508	517	866	finally
    //   525	535	866	finally
    //   543	551	866	finally
    //   559	571	866	finally
    //   591	612	866	finally
    //   620	629	866	finally
    //   637	644	866	finally
    //   657	666	866	finally
    //   674	682	866	finally
    //   690	699	866	finally
    //   707	718	866	finally
    //   729	734	866	finally
    //   742	754	866	finally
    //   762	772	866	finally
    //   841	848	866	finally
    //   852	858	866	finally
    //   875	887	866	finally
    //   841	848	931	java/lang/Exception
    //   852	858	931	java/lang/Exception
    //   64	81	952	finally
    //   64	81	957	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.EchoTask
 * JD-Core Version:    0.7.0.1
 */