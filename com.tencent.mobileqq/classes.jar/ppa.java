import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ppa
  implements ThreadPool.Job
{
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String b;
  
  public ppa(DnsService paramDnsService, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        Object localObject1 = new URL("http://182.254.116.117/d?dn=" + this.jdField_a_of_type_JavaLangString + "&ttl=1");
        localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
        ((HttpURLConnection)localObject1).setUseCaches(false);
        ((HttpURLConnection)localObject1).setDoInput(true);
        ((HttpURLConnection)localObject1).setConnectTimeout(10000);
        ((HttpURLConnection)localObject1).setReadTimeout(10000);
        ((HttpURLConnection)localObject1).connect();
        if ((((HttpURLConnection)localObject1).getContentLength() == 0) || (((HttpURLConnection)localObject1).getResponseCode() != 200)) {
          throw new Exception("HttpDNS get fail in " + paramInt);
        }
      }
      catch (Exception localException)
      {
        QDLog.d("DnsService", "httpDNS error", localException);
        localException.printStackTrace();
      }
    }
    Object localObject2;
    do
    {
      return null;
      localObject2 = new URL("http://182.254.116.116/d?dn=" + this.jdField_a_of_type_JavaLangString + "&ttl=1");
      break;
      localObject3 = new StringBuilder();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject2).getInputStream()));
      while (localBufferedReader != null)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        ((StringBuilder)localObject3).append(str);
      }
      ((HttpURLConnection)localObject2).disconnect();
      localObject2 = ((StringBuilder)localObject3).toString();
      if (((String)localObject2).length() == 0)
      {
        QDLog.b("DnsService", "httpDNS failed in " + paramInt);
        return null;
      }
      localObject2 = ((String)localObject2).split(",");
      localObject3 = localObject2[0];
      if (localObject2.length > 1) {
        Integer.valueOf(localObject2[1]).intValue();
      }
      localObject2 = ((String)localObject3).split(";");
    } while (localObject2.length <= 0);
    DnsService.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService).remove(this.jdField_a_of_type_JavaLangString);
    Object localObject3 = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < localObject2.length)
      {
        if (DnsService.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService, localObject2[paramInt])) {
          ((ArrayList)localObject3).add(localObject2[paramInt]);
        }
      }
      else
      {
        DnsService.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService).put(this.jdField_a_of_type_JavaLangString, localObject3);
        if (((ArrayList)localObject3).size() <= 0) {
          break;
        }
        localObject2 = (String)((ArrayList)localObject3).get(0);
        return localObject2;
      }
      paramInt += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext)
  {
    // Byte code:
    //   0: invokestatic 189	com/tencent/component/network/module/common/DnsService:a	()[B
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   10: invokestatic 192	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   13: aload_0
    //   14: invokeinterface 195 2 0
    //   19: pop
    //   20: aload_1
    //   21: monitorexit
    //   22: aconst_null
    //   23: astore_1
    //   24: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   27: astore 6
    //   29: aload 6
    //   31: astore 8
    //   33: ldc 202
    //   35: aload 6
    //   37: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +8 -> 48
    //   43: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   46: astore 8
    //   48: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   51: lstore 4
    //   53: aload_0
    //   54: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   57: invokestatic 217	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   60: ifeq +2159 -> 2219
    //   63: aload_0
    //   64: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   67: invokestatic 220	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   70: aload_0
    //   71: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 225	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   77: ifne +24 -> 101
    //   80: aload_0
    //   81: iconst_0
    //   82: invokespecial 227	ppa:a	(I)Ljava/lang/String;
    //   85: astore 6
    //   87: aload 6
    //   89: astore_1
    //   90: aload 6
    //   92: ifnonnull +9 -> 101
    //   95: aload_0
    //   96: iconst_1
    //   97: invokespecial 227	ppa:a	(I)Ljava/lang/String;
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +99 -> 204
    //   108: ldc 86
    //   110: new 32	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   117: ldc 235
    //   119: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   136: ifne +46 -> 182
    //   139: aload_0
    //   140: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   143: aload_0
    //   144: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: aload_1
    //   148: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   151: invokestatic 189	com/tencent/component/network/module/common/DnsService:a	()[B
    //   154: astore_1
    //   155: aload_1
    //   156: monitorenter
    //   157: aload_0
    //   158: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   161: invokestatic 192	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   164: aload_0
    //   165: invokeinterface 239 2 0
    //   170: pop
    //   171: aload_1
    //   172: monitorexit
    //   173: aconst_null
    //   174: areturn
    //   175: astore 6
    //   177: aload_1
    //   178: monitorexit
    //   179: aload 6
    //   181: athrow
    //   182: aload_0
    //   183: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   186: aload_0
    //   187: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: aconst_null
    //   191: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   194: goto -43 -> 151
    //   197: astore 6
    //   199: aload_1
    //   200: monitorexit
    //   201: aload 6
    //   203: athrow
    //   204: aload_0
    //   205: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   208: invokestatic 220	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   211: aload_0
    //   212: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: invokevirtual 240	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: aload_0
    //   220: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   223: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne +1990 -> 2216
    //   229: aload_0
    //   230: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: invokestatic 246	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   236: astore 6
    //   238: aload 6
    //   240: ifnull +1976 -> 2216
    //   243: aload 6
    //   245: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   248: astore 6
    //   250: aload 6
    //   252: astore_1
    //   253: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   256: ifeq +27 -> 283
    //   259: ldc 86
    //   261: new 32	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   268: ldc 254
    //   270: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_1
    //   284: astore 6
    //   286: aload_0
    //   287: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   290: aload_1
    //   291: invokestatic 163	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   294: ifne +126 -> 420
    //   297: aload_1
    //   298: astore 6
    //   300: aload_0
    //   301: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   304: invokestatic 256	com/tencent/component/network/module/common/DnsService:b	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   307: ifeq +113 -> 420
    //   310: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   313: lload 4
    //   315: lsub
    //   316: lstore_2
    //   317: aload_0
    //   318: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: astore 6
    //   323: ldc2_w 257
    //   326: lload_2
    //   327: lsub
    //   328: ldc2_w 259
    //   331: lcmp
    //   332: iflt +1839 -> 2171
    //   335: ldc2_w 257
    //   338: lload_2
    //   339: lsub
    //   340: lstore_2
    //   341: aload 6
    //   343: lload_2
    //   344: invokestatic 265	com/tencent/component/network/module/common/dns/DnsMain:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   347: astore 7
    //   349: aload_1
    //   350: astore 6
    //   352: aload 7
    //   354: ifnull +66 -> 420
    //   357: aload_1
    //   358: astore 6
    //   360: aload 7
    //   362: arraylength
    //   363: ifle +57 -> 420
    //   366: aload 7
    //   368: iconst_0
    //   369: aaload
    //   370: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   373: astore 6
    //   375: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   378: ifeq +42 -> 420
    //   381: ldc 86
    //   383: new 32	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 267
    //   393: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   400: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc_w 269
    //   406: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 6
    //   411: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   423: astore 7
    //   425: aload 7
    //   427: astore_1
    //   428: ldc 202
    //   430: aload 7
    //   432: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   435: ifeq +7 -> 442
    //   438: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   441: astore_1
    //   442: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   445: ifeq +106 -> 551
    //   448: ldc 86
    //   450: new 32	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 271
    //   460: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   467: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 273
    //   473: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 6
    //   478: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 275
    //   484: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   490: lload 4
    //   492: lsub
    //   493: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   496: ldc_w 280
    //   499: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 8
    //   504: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: ldc_w 282
    //   510: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc_w 284
    //   520: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokestatic 290	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   526: invokevirtual 293	java/lang/Thread:getId	()J
    //   529: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   532: ldc_w 295
    //   535: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   542: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_0
    //   552: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   555: ifne +1623 -> 2178
    //   558: aload_0
    //   559: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   562: aload_0
    //   563: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 6
    //   568: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   571: invokestatic 189	com/tencent/component/network/module/common/DnsService:a	()[B
    //   574: astore_1
    //   575: aload_1
    //   576: monitorenter
    //   577: aload_0
    //   578: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   581: invokestatic 192	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   584: aload_0
    //   585: invokeinterface 239 2 0
    //   590: pop
    //   591: aload_1
    //   592: monitorexit
    //   593: aconst_null
    //   594: areturn
    //   595: astore 6
    //   597: ldc 86
    //   599: ldc_w 300
    //   602: aload 6
    //   604: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   607: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   610: ifeq +27 -> 637
    //   613: ldc 86
    //   615: new 32	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   622: ldc 254
    //   624: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_1
    //   628: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload_1
    //   638: astore 6
    //   640: aload_0
    //   641: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   644: aload_1
    //   645: invokestatic 163	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   648: ifne +148 -> 796
    //   651: aload_1
    //   652: astore 6
    //   654: aload_0
    //   655: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   658: invokestatic 256	com/tencent/component/network/module/common/DnsService:b	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   661: ifeq +135 -> 796
    //   664: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   667: lload 4
    //   669: lsub
    //   670: lstore_2
    //   671: aload_1
    //   672: astore 7
    //   674: aload_0
    //   675: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   678: astore 6
    //   680: ldc2_w 257
    //   683: lload_2
    //   684: lsub
    //   685: ldc2_w 259
    //   688: lcmp
    //   689: iflt +1360 -> 2049
    //   692: ldc2_w 257
    //   695: lload_2
    //   696: lsub
    //   697: lstore_2
    //   698: aload_1
    //   699: astore 7
    //   701: aload 6
    //   703: lload_2
    //   704: invokestatic 265	com/tencent/component/network/module/common/dns/DnsMain:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   707: astore 9
    //   709: aload_1
    //   710: astore 6
    //   712: aload 9
    //   714: ifnull +82 -> 796
    //   717: aload_1
    //   718: astore 6
    //   720: aload_1
    //   721: astore 7
    //   723: aload 9
    //   725: arraylength
    //   726: ifle +70 -> 796
    //   729: aload_1
    //   730: astore 7
    //   732: aload 9
    //   734: iconst_0
    //   735: aaload
    //   736: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   739: astore_1
    //   740: aload_1
    //   741: astore 6
    //   743: aload_1
    //   744: astore 7
    //   746: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   749: ifeq +47 -> 796
    //   752: aload_1
    //   753: astore 7
    //   755: ldc 86
    //   757: new 32	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 267
    //   767: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_0
    //   771: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   774: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 269
    //   780: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_1
    //   784: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_1
    //   794: astore 6
    //   796: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   799: astore 7
    //   801: aload 7
    //   803: astore_1
    //   804: ldc 202
    //   806: aload 7
    //   808: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   811: ifeq +7 -> 818
    //   814: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   817: astore_1
    //   818: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   821: ifeq +106 -> 927
    //   824: ldc 86
    //   826: new 32	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 271
    //   836: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload_0
    //   840: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   843: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: ldc_w 273
    //   849: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 6
    //   854: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 275
    //   860: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   866: lload 4
    //   868: lsub
    //   869: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   872: ldc_w 280
    //   875: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload 8
    //   880: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: ldc_w 282
    //   886: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_1
    //   890: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: ldc_w 284
    //   896: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokestatic 290	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   902: invokevirtual 293	java/lang/Thread:getId	()J
    //   905: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   908: ldc_w 295
    //   911: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload_0
    //   915: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   918: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   921: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload_0
    //   928: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   931: ifne +1125 -> 2056
    //   934: aload_0
    //   935: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   938: astore_1
    //   939: aload_0
    //   940: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   943: astore 7
    //   945: aload_1
    //   946: aload 7
    //   948: aload 6
    //   950: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   953: goto -382 -> 571
    //   956: astore 6
    //   958: ldc 86
    //   960: ldc_w 300
    //   963: aload 6
    //   965: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   968: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   971: ifeq +27 -> 998
    //   974: ldc 86
    //   976: new 32	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   983: ldc 254
    //   985: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload_1
    //   989: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload_1
    //   999: astore 6
    //   1001: aload_0
    //   1002: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1005: aload_1
    //   1006: invokestatic 163	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1009: ifne +148 -> 1157
    //   1012: aload_1
    //   1013: astore 6
    //   1015: aload_0
    //   1016: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1019: invokestatic 256	com/tencent/component/network/module/common/DnsService:b	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1022: ifeq +135 -> 1157
    //   1025: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1028: lload 4
    //   1030: lsub
    //   1031: lstore_2
    //   1032: aload_1
    //   1033: astore 7
    //   1035: aload_0
    //   1036: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1039: astore 6
    //   1041: ldc2_w 257
    //   1044: lload_2
    //   1045: lsub
    //   1046: ldc2_w 259
    //   1049: lcmp
    //   1050: iflt +1044 -> 2094
    //   1053: ldc2_w 257
    //   1056: lload_2
    //   1057: lsub
    //   1058: lstore_2
    //   1059: aload_1
    //   1060: astore 7
    //   1062: aload 6
    //   1064: lload_2
    //   1065: invokestatic 265	com/tencent/component/network/module/common/dns/DnsMain:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1068: astore 9
    //   1070: aload_1
    //   1071: astore 6
    //   1073: aload 9
    //   1075: ifnull +82 -> 1157
    //   1078: aload_1
    //   1079: astore 6
    //   1081: aload_1
    //   1082: astore 7
    //   1084: aload 9
    //   1086: arraylength
    //   1087: ifle +70 -> 1157
    //   1090: aload_1
    //   1091: astore 7
    //   1093: aload 9
    //   1095: iconst_0
    //   1096: aaload
    //   1097: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1100: astore_1
    //   1101: aload_1
    //   1102: astore 6
    //   1104: aload_1
    //   1105: astore 7
    //   1107: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1110: ifeq +47 -> 1157
    //   1113: aload_1
    //   1114: astore 7
    //   1116: ldc 86
    //   1118: new 32	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1125: ldc_w 267
    //   1128: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload_0
    //   1132: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1135: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 269
    //   1141: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload_1
    //   1145: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1154: aload_1
    //   1155: astore 6
    //   1157: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1160: astore 7
    //   1162: aload 7
    //   1164: astore_1
    //   1165: ldc 202
    //   1167: aload 7
    //   1169: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1172: ifeq +7 -> 1179
    //   1175: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1178: astore_1
    //   1179: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1182: ifeq +106 -> 1288
    //   1185: ldc 86
    //   1187: new 32	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 271
    //   1197: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload_0
    //   1201: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: ldc_w 273
    //   1210: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: aload 6
    //   1215: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc_w 275
    //   1221: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1227: lload 4
    //   1229: lsub
    //   1230: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1233: ldc_w 280
    //   1236: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload 8
    //   1241: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: ldc_w 282
    //   1247: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: aload_1
    //   1251: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: ldc_w 284
    //   1257: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: invokestatic 290	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1263: invokevirtual 293	java/lang/Thread:getId	()J
    //   1266: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1269: ldc_w 295
    //   1272: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload_0
    //   1276: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1279: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1282: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1288: aload_0
    //   1289: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1292: ifne +809 -> 2101
    //   1295: aload_0
    //   1296: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1299: astore_1
    //   1300: aload_0
    //   1301: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1304: astore 7
    //   1306: goto -361 -> 945
    //   1309: astore 6
    //   1311: ldc 86
    //   1313: ldc_w 302
    //   1316: aload 6
    //   1318: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1321: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1324: ifeq +27 -> 1351
    //   1327: ldc 86
    //   1329: new 32	java/lang/StringBuilder
    //   1332: dup
    //   1333: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1336: ldc 254
    //   1338: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: aload_1
    //   1342: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: aload_1
    //   1352: astore 6
    //   1354: aload_0
    //   1355: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1358: aload_1
    //   1359: invokestatic 163	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1362: ifne +148 -> 1510
    //   1365: aload_1
    //   1366: astore 6
    //   1368: aload_0
    //   1369: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1372: invokestatic 256	com/tencent/component/network/module/common/DnsService:b	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1375: ifeq +135 -> 1510
    //   1378: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1381: lload 4
    //   1383: lsub
    //   1384: lstore_2
    //   1385: aload_1
    //   1386: astore 7
    //   1388: aload_0
    //   1389: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1392: astore 6
    //   1394: ldc2_w 257
    //   1397: lload_2
    //   1398: lsub
    //   1399: ldc2_w 259
    //   1402: lcmp
    //   1403: iflt +729 -> 2132
    //   1406: ldc2_w 257
    //   1409: lload_2
    //   1410: lsub
    //   1411: lstore_2
    //   1412: aload_1
    //   1413: astore 7
    //   1415: aload 6
    //   1417: lload_2
    //   1418: invokestatic 265	com/tencent/component/network/module/common/dns/DnsMain:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1421: astore 9
    //   1423: aload_1
    //   1424: astore 6
    //   1426: aload 9
    //   1428: ifnull +82 -> 1510
    //   1431: aload_1
    //   1432: astore 6
    //   1434: aload_1
    //   1435: astore 7
    //   1437: aload 9
    //   1439: arraylength
    //   1440: ifle +70 -> 1510
    //   1443: aload_1
    //   1444: astore 7
    //   1446: aload 9
    //   1448: iconst_0
    //   1449: aaload
    //   1450: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1453: astore_1
    //   1454: aload_1
    //   1455: astore 6
    //   1457: aload_1
    //   1458: astore 7
    //   1460: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1463: ifeq +47 -> 1510
    //   1466: aload_1
    //   1467: astore 7
    //   1469: ldc 86
    //   1471: new 32	java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1478: ldc_w 267
    //   1481: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload_0
    //   1485: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1488: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: ldc_w 269
    //   1494: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: aload_1
    //   1498: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1507: aload_1
    //   1508: astore 6
    //   1510: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1513: astore 7
    //   1515: aload 7
    //   1517: astore_1
    //   1518: ldc 202
    //   1520: aload 7
    //   1522: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1525: ifeq +7 -> 1532
    //   1528: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1531: astore_1
    //   1532: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1535: ifeq +106 -> 1641
    //   1538: ldc 86
    //   1540: new 32	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1547: ldc_w 271
    //   1550: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: aload_0
    //   1554: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1557: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 273
    //   1563: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 6
    //   1568: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: ldc_w 275
    //   1574: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1580: lload 4
    //   1582: lsub
    //   1583: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1586: ldc_w 280
    //   1589: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: aload 8
    //   1594: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: ldc_w 282
    //   1600: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: aload_1
    //   1604: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: ldc_w 284
    //   1610: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: invokestatic 290	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1616: invokevirtual 293	java/lang/Thread:getId	()J
    //   1619: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1622: ldc_w 295
    //   1625: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: aload_0
    //   1629: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1632: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1635: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1638: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1641: aload_0
    //   1642: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1645: ifne +494 -> 2139
    //   1648: aload_0
    //   1649: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1652: astore_1
    //   1653: aload_0
    //   1654: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1657: astore 7
    //   1659: goto -714 -> 945
    //   1662: astore 6
    //   1664: ldc 86
    //   1666: ldc_w 304
    //   1669: aload 6
    //   1671: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1674: aload_1
    //   1675: astore 6
    //   1677: invokestatic 200	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1680: astore 7
    //   1682: aload 7
    //   1684: astore_1
    //   1685: ldc 202
    //   1687: aload 7
    //   1689: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1692: ifeq +7 -> 1699
    //   1695: invokestatic 208	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1698: astore_1
    //   1699: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1702: ifeq +106 -> 1808
    //   1705: ldc 86
    //   1707: new 32	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1714: ldc_w 271
    //   1717: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: aload_0
    //   1721: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1724: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: ldc_w 273
    //   1730: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: aload 6
    //   1735: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: ldc_w 275
    //   1741: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1747: lload 4
    //   1749: lsub
    //   1750: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1753: ldc_w 280
    //   1756: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload 8
    //   1761: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: ldc_w 282
    //   1767: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: aload_1
    //   1771: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: ldc_w 284
    //   1777: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: invokestatic 290	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1783: invokevirtual 293	java/lang/Thread:getId	()J
    //   1786: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1789: ldc_w 295
    //   1792: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: aload_0
    //   1796: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1799: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1802: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1805: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1808: aload_0
    //   1809: getfield 20	ppa:jdField_a_of_type_Boolean	Z
    //   1812: ifne +205 -> 2017
    //   1815: aload_0
    //   1816: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1819: aload_0
    //   1820: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1823: aload 6
    //   1825: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1828: aload 9
    //   1830: athrow
    //   1831: astore 6
    //   1833: aload_1
    //   1834: monitorexit
    //   1835: aload 6
    //   1837: athrow
    //   1838: astore 9
    //   1840: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1843: ifeq +27 -> 1870
    //   1846: ldc 86
    //   1848: new 32	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1855: ldc 254
    //   1857: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: aload_1
    //   1861: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1867: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1870: aload_1
    //   1871: astore 6
    //   1873: aload_0
    //   1874: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1877: aload_1
    //   1878: invokestatic 163	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1881: ifne -204 -> 1677
    //   1884: aload_1
    //   1885: astore 6
    //   1887: aload_0
    //   1888: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   1891: invokestatic 256	com/tencent/component/network/module/common/DnsService:b	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1894: ifeq -217 -> 1677
    //   1897: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1900: lload 4
    //   1902: lsub
    //   1903: lstore_2
    //   1904: aload_0
    //   1905: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1908: astore 6
    //   1910: ldc2_w 257
    //   1913: lload_2
    //   1914: lsub
    //   1915: ldc2_w 259
    //   1918: lcmp
    //   1919: iflt +91 -> 2010
    //   1922: ldc2_w 257
    //   1925: lload_2
    //   1926: lsub
    //   1927: lstore_2
    //   1928: aload 6
    //   1930: lload_2
    //   1931: invokestatic 265	com/tencent/component/network/module/common/dns/DnsMain:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1934: astore 7
    //   1936: aload_1
    //   1937: astore 6
    //   1939: aload 7
    //   1941: ifnull -264 -> 1677
    //   1944: aload_1
    //   1945: astore 6
    //   1947: aload 7
    //   1949: arraylength
    //   1950: ifle -273 -> 1677
    //   1953: aload 7
    //   1955: iconst_0
    //   1956: aaload
    //   1957: invokevirtual 249	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1960: astore 6
    //   1962: invokestatic 252	com/tencent/component/network/module/base/QDLog:b	()Z
    //   1965: ifeq +42 -> 2007
    //   1968: ldc 86
    //   1970: new 32	java/lang/StringBuilder
    //   1973: dup
    //   1974: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1977: ldc_w 267
    //   1980: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: aload_0
    //   1984: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1987: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1990: ldc_w 269
    //   1993: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: aload 6
    //   1998: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2004: invokestatic 129	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2007: goto -330 -> 1677
    //   2010: ldc2_w 259
    //   2013: lstore_2
    //   2014: goto -86 -> 1928
    //   2017: aload_0
    //   2018: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   2021: aload_0
    //   2022: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2025: aconst_null
    //   2026: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2029: goto -201 -> 1828
    //   2032: astore_1
    //   2033: ldc 86
    //   2035: ldc_w 304
    //   2038: aload_1
    //   2039: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2042: aload 7
    //   2044: astore 6
    //   2046: goto -1250 -> 796
    //   2049: ldc2_w 259
    //   2052: lstore_2
    //   2053: goto -1355 -> 698
    //   2056: aload_0
    //   2057: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   2060: astore_1
    //   2061: aload_0
    //   2062: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2065: astore 6
    //   2067: aload_1
    //   2068: aload 6
    //   2070: aconst_null
    //   2071: invokestatic 237	com/tencent/component/network/module/common/DnsService:a	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2074: goto -1503 -> 571
    //   2077: astore_1
    //   2078: ldc 86
    //   2080: ldc_w 304
    //   2083: aload_1
    //   2084: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2087: aload 7
    //   2089: astore 6
    //   2091: goto -934 -> 1157
    //   2094: ldc2_w 259
    //   2097: lstore_2
    //   2098: goto -1039 -> 1059
    //   2101: aload_0
    //   2102: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   2105: astore_1
    //   2106: aload_0
    //   2107: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2110: astore 6
    //   2112: goto -45 -> 2067
    //   2115: astore_1
    //   2116: ldc 86
    //   2118: ldc_w 304
    //   2121: aload_1
    //   2122: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2125: aload 7
    //   2127: astore 6
    //   2129: goto -619 -> 1510
    //   2132: ldc2_w 259
    //   2135: lstore_2
    //   2136: goto -724 -> 1412
    //   2139: aload_0
    //   2140: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   2143: astore_1
    //   2144: aload_0
    //   2145: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2148: astore 6
    //   2150: goto -83 -> 2067
    //   2153: astore 6
    //   2155: ldc 86
    //   2157: ldc_w 304
    //   2160: aload 6
    //   2162: invokestatic 94	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2165: aload_1
    //   2166: astore 6
    //   2168: goto -1748 -> 420
    //   2171: ldc2_w 259
    //   2174: lstore_2
    //   2175: goto -1834 -> 341
    //   2178: aload_0
    //   2179: getfield 15	ppa:jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsService	Lcom/tencent/component/network/module/common/DnsService;
    //   2182: astore_1
    //   2183: aload_0
    //   2184: getfield 22	ppa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2187: astore 6
    //   2189: goto -122 -> 2067
    //   2192: astore 7
    //   2194: aload 6
    //   2196: astore_1
    //   2197: aload 7
    //   2199: astore 6
    //   2201: goto -46 -> 2155
    //   2204: astore 7
    //   2206: aload 6
    //   2208: astore_1
    //   2209: aload 7
    //   2211: astore 6
    //   2213: goto -549 -> 1664
    //   2216: goto -1963 -> 253
    //   2219: aconst_null
    //   2220: astore_1
    //   2221: goto -2002 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2224	0	this	ppa
    //   0	2224	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   316	1859	2	l1	long
    //   51	1850	4	l2	long
    //   27	64	6	str1	String
    //   175	5	6	localObject1	Object
    //   197	5	6	localObject2	Object
    //   236	331	6	localObject3	Object
    //   595	8	6	localUnknownHostException	java.net.UnknownHostException
    //   638	311	6	localObject4	Object
    //   956	8	6	localException	Exception
    //   999	215	6	localObject5	Object
    //   1309	8	6	localError	java.lang.Error
    //   1352	215	6	localObject6	Object
    //   1662	8	6	localThrowable1	java.lang.Throwable
    //   1675	149	6	localJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   1831	5	6	localObject7	Object
    //   1871	278	6	localObject8	Object
    //   2153	8	6	localThrowable2	java.lang.Throwable
    //   2166	46	6	localObject9	Object
    //   347	1779	7	localObject10	Object
    //   2192	6	7	localThrowable3	java.lang.Throwable
    //   2204	6	7	localThrowable4	java.lang.Throwable
    //   31	1729	8	str2	String
    //   707	1122	9	arrayOfInetAddress	java.net.InetAddress[]
    //   1838	1	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   6	22	175	finally
    //   177	179	175	finally
    //   157	173	197	finally
    //   199	201	197	finally
    //   219	238	595	java/net/UnknownHostException
    //   243	250	595	java/net/UnknownHostException
    //   219	238	956	java/lang/Exception
    //   243	250	956	java/lang/Exception
    //   219	238	1309	java/lang/Error
    //   243	250	1309	java/lang/Error
    //   1904	1910	1662	java/lang/Throwable
    //   1928	1936	1662	java/lang/Throwable
    //   1947	1962	1662	java/lang/Throwable
    //   577	593	1831	finally
    //   1833	1835	1831	finally
    //   219	238	1838	finally
    //   243	250	1838	finally
    //   597	607	1838	finally
    //   958	968	1838	finally
    //   1311	1321	1838	finally
    //   674	680	2032	java/lang/Throwable
    //   701	709	2032	java/lang/Throwable
    //   723	729	2032	java/lang/Throwable
    //   732	740	2032	java/lang/Throwable
    //   746	752	2032	java/lang/Throwable
    //   755	793	2032	java/lang/Throwable
    //   1035	1041	2077	java/lang/Throwable
    //   1062	1070	2077	java/lang/Throwable
    //   1084	1090	2077	java/lang/Throwable
    //   1093	1101	2077	java/lang/Throwable
    //   1107	1113	2077	java/lang/Throwable
    //   1116	1154	2077	java/lang/Throwable
    //   1388	1394	2115	java/lang/Throwable
    //   1415	1423	2115	java/lang/Throwable
    //   1437	1443	2115	java/lang/Throwable
    //   1446	1454	2115	java/lang/Throwable
    //   1460	1466	2115	java/lang/Throwable
    //   1469	1507	2115	java/lang/Throwable
    //   317	323	2153	java/lang/Throwable
    //   341	349	2153	java/lang/Throwable
    //   360	375	2153	java/lang/Throwable
    //   375	420	2192	java/lang/Throwable
    //   1962	2007	2204	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ppa
 * JD-Core Version:    0.7.0.1
 */