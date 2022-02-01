package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

public class TroopFileTransferManager$TaskHttpUpload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpUpload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 2);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private HttpResponse a(HttpClient paramHttpClient, String paramString, byte[] paramArrayOfByte)
  {
    HttpPost localHttpPost;
    if ((paramHttpClient != null) && (paramString != null))
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      localHttpPost = new HttpPost(paramString);
      localHttpPost.setHeader("User-Agent", "TroopFile");
      localHttpPost.setHeader("Content-Type", "text/octet");
      localHttpPost.setHeader("Connection", "keep-alive");
      if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
        localHttpPost.setHeader("Net-type", "Wifi");
      } else {
        localHttpPost.setHeader("Net-type", "gprs");
      }
      localHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
    }
    try
    {
      paramHttpClient = paramHttpClient.execute(localHttpPost);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      if (!QLog.isColorLevel()) {
        break label221;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("IOException, url");
      paramArrayOfByte.append(paramString);
      QLog.d("TroopFileTransferManager", 2, paramArrayOfByte.toString());
      paramHttpClient.printStackTrace();
      return null;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      if (!QLog.isColorLevel()) {
        break label265;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("ClientProtocolException, url");
      paramArrayOfByte.append(paramString);
      QLog.d("TroopFileTransferManager", 2, paramArrayOfByte.toString());
      paramHttpClient.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramHttpClient)
    {
      break label144;
    }
    catch (Exception paramHttpClient)
    {
      label105:
      break label105;
    }
    if (QLog.isColorLevel())
    {
      paramHttpClient = new StringBuilder();
      paramHttpClient.append("Exception, url");
      paramHttpClient.append(paramString);
      QLog.d("TroopFileTransferManager", 2, paramHttpClient.toString());
    }
    return null;
    label144:
    if (QLog.isColorLevel())
    {
      paramHttpClient = new StringBuilder();
      paramHttpClient.append("IllegalArgumentException, url");
      paramHttpClient.append(paramString);
      QLog.d("TroopFileTransferManager", 2, paramHttpClient.toString());
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   4: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   7: lstore 6
    //   9: aload_0
    //   10: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   13: aload_0
    //   14: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   17: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   20: ifeq +4 -> 24
    //   23: return
    //   24: new 144	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: getfield 148	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   35: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 20
    //   40: aload_0
    //   41: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: iconst_0
    //   45: putfield 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   48: sipush 1024
    //   51: istore 4
    //   53: aload_0
    //   54: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   57: invokevirtual 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   60: ifnull +21 -> 81
    //   63: aload_0
    //   64: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   67: invokevirtual 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   70: iconst_5
    //   71: invokeinterface 162 2 0
    //   76: astore 15
    //   78: goto +6 -> 84
    //   81: aconst_null
    //   82: astore 15
    //   84: aload 15
    //   86: ifnull +55 -> 141
    //   89: aload 15
    //   91: invokeinterface 168 1 0
    //   96: ifle +45 -> 141
    //   99: aload 15
    //   101: iconst_0
    //   102: invokeinterface 172 2 0
    //   107: ifnull +34 -> 141
    //   110: iconst_0
    //   111: aload 15
    //   113: iconst_0
    //   114: invokeinterface 172 2 0
    //   119: checkcast 174	mqq/manager/ProxyIpManager$ProxyIp
    //   122: getfield 177	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   125: sipush 10000
    //   128: sipush 20000
    //   131: invokestatic 182	com/dataline/util/HttpUtil:a	(ZIII)Lorg/apache/http/client/HttpClient;
    //   134: astore 16
    //   136: iconst_1
    //   137: istore_3
    //   138: goto +34 -> 172
    //   141: invokestatic 185	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   144: ifnull +9 -> 153
    //   147: iconst_1
    //   148: istore 14
    //   150: goto +6 -> 156
    //   153: iconst_0
    //   154: istore 14
    //   156: iconst_0
    //   157: iload 14
    //   159: sipush 10000
    //   162: sipush 20000
    //   165: invokestatic 188	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   168: astore 16
    //   170: iconst_0
    //   171: istore_3
    //   172: lload 6
    //   174: lstore 8
    //   176: iconst_0
    //   177: istore_1
    //   178: aconst_null
    //   179: astore 17
    //   181: iconst_m1
    //   182: istore_2
    //   183: aload 15
    //   185: astore 21
    //   187: aload 17
    //   189: astore 15
    //   191: iload_1
    //   192: iconst_3
    //   193: if_icmpgt +2776 -> 2969
    //   196: aload 16
    //   198: astore 19
    //   200: iload_1
    //   201: ifle +363 -> 564
    //   204: aload 15
    //   206: astore 17
    //   208: aload 15
    //   210: astore 18
    //   212: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   215: invokestatic 191	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   218: ifne +103 -> 321
    //   221: aload 15
    //   223: astore 17
    //   225: aload 15
    //   227: astore 18
    //   229: aload_0
    //   230: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   233: aload_0
    //   234: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: iconst_3
    //   238: bipush 106
    //   240: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   243: aload 15
    //   245: astore 17
    //   247: aload 15
    //   249: astore 18
    //   251: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   254: getstatic 201	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   257: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   260: aload 15
    //   262: ifnull +58 -> 320
    //   265: aload 15
    //   267: invokevirtual 211	java/io/FileInputStream:close	()V
    //   270: return
    //   271: astore 15
    //   273: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +44 -> 320
    //   279: new 89	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   286: astore 16
    //   288: aload 16
    //   290: ldc 213
    //   292: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 16
    //   298: aload 15
    //   300: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   303: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 100
    //   309: iconst_2
    //   310: aload 16
    //   312: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aload 15
    //   317: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: return
    //   321: iconst_0
    //   322: istore 5
    //   324: aload 16
    //   326: astore 19
    //   328: iload 5
    //   330: iload_1
    //   331: bipush 100
    //   333: imul
    //   334: if_icmpge +230 -> 564
    //   337: aload 15
    //   339: astore 17
    //   341: aload 15
    //   343: astore 18
    //   345: ldc2_w 219
    //   348: invokestatic 226	java/lang/Thread:sleep	(J)V
    //   351: aload 15
    //   353: astore 17
    //   355: aload 15
    //   357: astore 18
    //   359: aload_0
    //   360: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   363: aload_0
    //   364: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   367: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   370: istore 14
    //   372: iload 14
    //   374: ifeq +64 -> 438
    //   377: aload 15
    //   379: ifnull +58 -> 437
    //   382: aload 15
    //   384: invokevirtual 211	java/io/FileInputStream:close	()V
    //   387: return
    //   388: astore 15
    //   390: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +44 -> 437
    //   396: new 89	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   403: astore 16
    //   405: aload 16
    //   407: ldc 213
    //   409: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 16
    //   415: aload 15
    //   417: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   420: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: ldc 100
    //   426: iconst_2
    //   427: aload 16
    //   429: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: aload 15
    //   434: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: return
    //   438: aload 15
    //   440: astore 17
    //   442: aload 15
    //   444: astore 18
    //   446: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   449: invokestatic 191	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   452: ifne +103 -> 555
    //   455: aload 15
    //   457: astore 17
    //   459: aload 15
    //   461: astore 18
    //   463: aload_0
    //   464: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   467: aload_0
    //   468: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   471: iconst_3
    //   472: bipush 106
    //   474: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   477: aload 15
    //   479: astore 17
    //   481: aload 15
    //   483: astore 18
    //   485: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   488: getstatic 201	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   491: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   494: aload 15
    //   496: ifnull +58 -> 554
    //   499: aload 15
    //   501: invokevirtual 211	java/io/FileInputStream:close	()V
    //   504: return
    //   505: astore 15
    //   507: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +44 -> 554
    //   513: new 89	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   520: astore 16
    //   522: aload 16
    //   524: ldc 213
    //   526: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 16
    //   532: aload 15
    //   534: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   537: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: ldc 100
    //   543: iconst_2
    //   544: aload 16
    //   546: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: aload 15
    //   551: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   554: return
    //   555: iload 5
    //   557: iconst_1
    //   558: iadd
    //   559: istore 5
    //   561: goto -237 -> 324
    //   564: aload 15
    //   566: astore 17
    //   568: aload 15
    //   570: astore 18
    //   572: aload_0
    //   573: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   576: aload_0
    //   577: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   580: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   583: istore 14
    //   585: iload 14
    //   587: ifeq +64 -> 651
    //   590: aload 15
    //   592: ifnull +58 -> 650
    //   595: aload 15
    //   597: invokevirtual 211	java/io/FileInputStream:close	()V
    //   600: return
    //   601: astore 15
    //   603: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +44 -> 650
    //   609: new 89	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   616: astore 16
    //   618: aload 16
    //   620: ldc 213
    //   622: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 16
    //   628: aload 15
    //   630: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   633: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: ldc 100
    //   639: iconst_2
    //   640: aload 16
    //   642: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: aload 15
    //   647: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   650: return
    //   651: aload 15
    //   653: astore 17
    //   655: aload 15
    //   657: astore 18
    //   659: aload 20
    //   661: invokevirtual 230	java/io/File:length	()J
    //   664: aload_0
    //   665: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   668: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   671: lcmp
    //   672: ifeq +104 -> 776
    //   675: aload 15
    //   677: astore 17
    //   679: aload 15
    //   681: astore 18
    //   683: aload_0
    //   684: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   687: aload_0
    //   688: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   691: iconst_3
    //   692: sipush 206
    //   695: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   698: aload 15
    //   700: astore 17
    //   702: aload 15
    //   704: astore 18
    //   706: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   709: getstatic 236	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:t	I
    //   712: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   715: aload 15
    //   717: ifnull +58 -> 775
    //   720: aload 15
    //   722: invokevirtual 211	java/io/FileInputStream:close	()V
    //   725: return
    //   726: astore 15
    //   728: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +44 -> 775
    //   734: new 89	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   741: astore 16
    //   743: aload 16
    //   745: ldc 213
    //   747: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload 16
    //   753: aload 15
    //   755: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   758: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: ldc 100
    //   764: iconst_2
    //   765: aload 16
    //   767: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: aload 15
    //   772: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   775: return
    //   776: aload 15
    //   778: astore 16
    //   780: aload 15
    //   782: ifnonnull +126 -> 908
    //   785: aload 15
    //   787: astore 17
    //   789: aload 15
    //   791: astore 18
    //   793: new 208	java/io/FileInputStream
    //   796: dup
    //   797: aload 20
    //   799: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   802: astore 16
    //   804: goto +104 -> 908
    //   807: aload 15
    //   809: astore 17
    //   811: aload 15
    //   813: astore 18
    //   815: aload_0
    //   816: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   819: aload_0
    //   820: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   823: iconst_3
    //   824: sipush 201
    //   827: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   830: aload 15
    //   832: astore 17
    //   834: aload 15
    //   836: astore 18
    //   838: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   841: getstatic 242	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   844: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   847: aload 15
    //   849: ifnull +58 -> 907
    //   852: aload 15
    //   854: invokevirtual 211	java/io/FileInputStream:close	()V
    //   857: return
    //   858: astore 15
    //   860: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq +44 -> 907
    //   866: new 89	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   873: astore 16
    //   875: aload 16
    //   877: ldc 213
    //   879: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 16
    //   885: aload 15
    //   887: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   890: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: ldc 100
    //   896: iconst_2
    //   897: aload 16
    //   899: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: aload 15
    //   904: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   907: return
    //   908: iload_1
    //   909: iconst_1
    //   910: iadd
    //   911: istore_1
    //   912: aload 16
    //   914: astore 17
    //   916: aload 16
    //   918: astore 18
    //   920: aload_0
    //   921: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   924: iload_1
    //   925: putfield 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   928: aload 16
    //   930: astore 17
    //   932: aload 16
    //   934: astore 18
    //   936: iload 4
    //   938: newarray byte
    //   940: astore 22
    //   942: lload 6
    //   944: lload 8
    //   946: lcmp
    //   947: ifle +29 -> 976
    //   950: aload 16
    //   952: astore 17
    //   954: aload 16
    //   956: astore 18
    //   958: aload 16
    //   960: lload 6
    //   962: lload 8
    //   964: lsub
    //   965: invokevirtual 246	java/io/FileInputStream:skip	(J)J
    //   968: pop2
    //   969: aload 16
    //   971: astore 15
    //   973: goto +85 -> 1058
    //   976: aload 16
    //   978: astore 15
    //   980: lload 6
    //   982: lload 8
    //   984: lcmp
    //   985: ifge +73 -> 1058
    //   988: aload 16
    //   990: astore 17
    //   992: aload 16
    //   994: astore 18
    //   996: aload 16
    //   998: invokevirtual 211	java/io/FileInputStream:close	()V
    //   1001: aload 16
    //   1003: astore 17
    //   1005: aload 16
    //   1007: astore 18
    //   1009: new 208	java/io/FileInputStream
    //   1012: dup
    //   1013: aload 20
    //   1015: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1018: astore 15
    //   1020: aload 15
    //   1022: lload 6
    //   1024: invokevirtual 246	java/io/FileInputStream:skip	(J)J
    //   1027: pop2
    //   1028: goto +30 -> 1058
    //   1031: astore 16
    //   1033: aload 15
    //   1035: astore 17
    //   1037: aload 16
    //   1039: astore 15
    //   1041: aload 17
    //   1043: astore 16
    //   1045: goto +1859 -> 2904
    //   1048: astore 16
    //   1050: goto +1740 -> 2790
    //   1053: astore 16
    //   1055: goto +1531 -> 2586
    //   1058: aload 15
    //   1060: aload 22
    //   1062: invokevirtual 250	java/io/FileInputStream:read	([B)I
    //   1065: istore 4
    //   1067: iload 4
    //   1069: ifle +14 -> 1083
    //   1072: iload 4
    //   1074: i2l
    //   1075: lload 6
    //   1077: ladd
    //   1078: lstore 8
    //   1080: goto +7 -> 1087
    //   1083: lload 6
    //   1085: lstore 8
    //   1087: aload 15
    //   1089: astore 16
    //   1091: iload 4
    //   1093: ifge +6 -> 1099
    //   1096: goto +1877 -> 2973
    //   1099: aload_0
    //   1100: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1103: getfield 254	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1106: arraylength
    //   1107: iconst_2
    //   1108: iadd
    //   1109: iconst_2
    //   1110: iadd
    //   1111: aload_0
    //   1112: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1115: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1118: arraylength
    //   1119: iadd
    //   1120: bipush 20
    //   1122: iadd
    //   1123: iload 4
    //   1125: iadd
    //   1126: istore_2
    //   1127: new 259	java/io/ByteArrayOutputStream
    //   1130: dup
    //   1131: iload_2
    //   1132: bipush 16
    //   1134: iadd
    //   1135: invokespecial 262	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1138: astore 17
    //   1140: new 264	java/io/DataOutputStream
    //   1143: dup
    //   1144: aload 17
    //   1146: invokespecial 267	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1149: astore 23
    //   1151: aload 23
    //   1153: ldc_w 268
    //   1156: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1159: aload 23
    //   1161: sipush 1007
    //   1164: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1167: aload 23
    //   1169: iconst_0
    //   1170: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1173: aload 23
    //   1175: iload_2
    //   1176: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1179: aload 23
    //   1181: aload_0
    //   1182: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1185: getfield 254	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1188: arraylength
    //   1189: invokevirtual 274	java/io/DataOutputStream:writeShort	(I)V
    //   1192: aload 23
    //   1194: aload_0
    //   1195: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1198: getfield 254	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1201: invokevirtual 277	java/io/DataOutputStream:write	([B)V
    //   1204: aload 23
    //   1206: aload_0
    //   1207: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1210: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1213: arraylength
    //   1214: invokevirtual 274	java/io/DataOutputStream:writeShort	(I)V
    //   1217: aload 23
    //   1219: aload_0
    //   1220: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1223: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1226: invokevirtual 277	java/io/DataOutputStream:write	([B)V
    //   1229: aload 23
    //   1231: aload_0
    //   1232: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1235: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1238: ldc2_w 278
    //   1241: land
    //   1242: l2i
    //   1243: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1246: aload 23
    //   1248: ldc2_w 278
    //   1251: lload 6
    //   1253: land
    //   1254: l2i
    //   1255: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1258: aload 23
    //   1260: iload 4
    //   1262: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1265: aload 23
    //   1267: aload_0
    //   1268: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1271: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1274: bipush 32
    //   1276: lshr
    //   1277: l2i
    //   1278: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1281: aload 23
    //   1283: lload 6
    //   1285: bipush 32
    //   1287: lshr
    //   1288: l2i
    //   1289: invokevirtual 271	java/io/DataOutputStream:writeInt	(I)V
    //   1292: aload 23
    //   1294: aload 22
    //   1296: iconst_0
    //   1297: iload 4
    //   1299: invokevirtual 282	java/io/DataOutputStream:write	([BII)V
    //   1302: aload 17
    //   1304: invokevirtual 286	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1307: astore 18
    //   1309: aload 17
    //   1311: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   1314: aload 23
    //   1316: invokevirtual 288	java/io/DataOutputStream:close	()V
    //   1319: iload_3
    //   1320: ifeq +73 -> 1393
    //   1323: ldc_w 290
    //   1326: iconst_5
    //   1327: anewarray 292	java/lang/Object
    //   1330: dup
    //   1331: iconst_0
    //   1332: aload 21
    //   1334: iconst_0
    //   1335: invokeinterface 172 2 0
    //   1340: checkcast 174	mqq/manager/ProxyIpManager$ProxyIp
    //   1343: getfield 295	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_1
    //   1349: lload 6
    //   1351: invokestatic 301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1354: aastore
    //   1355: dup
    //   1356: iconst_2
    //   1357: iload 4
    //   1359: i2l
    //   1360: lload 6
    //   1362: ladd
    //   1363: invokestatic 301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1366: aastore
    //   1367: dup
    //   1368: iconst_3
    //   1369: aload_0
    //   1370: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1373: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1376: aastore
    //   1377: dup
    //   1378: iconst_4
    //   1379: bipush 80
    //   1381: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1384: aastore
    //   1385: invokestatic 315	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1388: astore 17
    //   1390: goto +45 -> 1435
    //   1393: ldc_w 317
    //   1396: iconst_3
    //   1397: anewarray 292	java/lang/Object
    //   1400: dup
    //   1401: iconst_0
    //   1402: aload_0
    //   1403: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1406: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_1
    //   1412: lload 6
    //   1414: invokestatic 301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1417: aastore
    //   1418: dup
    //   1419: iconst_2
    //   1420: iload 4
    //   1422: i2l
    //   1423: lload 6
    //   1425: ladd
    //   1426: invokestatic 301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1429: aastore
    //   1430: invokestatic 315	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1433: astore 17
    //   1435: aload_0
    //   1436: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1439: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   1442: putfield 325	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   1445: aload_0
    //   1446: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1449: aload 17
    //   1451: putfield 328	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   1454: aload_0
    //   1455: aload 19
    //   1457: aload 17
    //   1459: aload 18
    //   1461: invokespecial 330	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   1464: astore 22
    //   1466: aload 22
    //   1468: ifnonnull +32 -> 1500
    //   1471: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1474: ifeq +19 -> 1493
    //   1477: ldc 100
    //   1479: iconst_2
    //   1480: ldc_w 332
    //   1483: iconst_0
    //   1484: anewarray 292	java/lang/Object
    //   1487: invokestatic 315	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1490: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1493: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:z	I
    //   1496: istore_2
    //   1497: goto +1995 -> 3492
    //   1500: aload 22
    //   1502: invokeinterface 341 1 0
    //   1507: invokeinterface 346 1 0
    //   1512: istore_2
    //   1513: iload_2
    //   1514: sipush 200
    //   1517: if_icmpeq +379 -> 1896
    //   1520: iload_2
    //   1521: sipush 206
    //   1524: if_icmpeq +372 -> 1896
    //   1527: aload 22
    //   1529: invokeinterface 350 1 0
    //   1534: astore 17
    //   1536: aload 17
    //   1538: ifnull +108 -> 1646
    //   1541: new 89	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1548: astore 18
    //   1550: aload 17
    //   1552: arraylength
    //   1553: istore 5
    //   1555: iconst_0
    //   1556: istore 4
    //   1558: iload 4
    //   1560: iload 5
    //   1562: if_icmpge +72 -> 1634
    //   1565: aload 17
    //   1567: iload 4
    //   1569: aaload
    //   1570: astore 23
    //   1572: aload 18
    //   1574: ldc_w 352
    //   1577: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: pop
    //   1581: aload 18
    //   1583: aload 23
    //   1585: invokeinterface 357 1 0
    //   1590: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: aload 18
    //   1596: ldc_w 359
    //   1599: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload 18
    //   1605: aload 23
    //   1607: invokeinterface 362 1 0
    //   1612: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: aload 18
    //   1618: ldc_w 364
    //   1621: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: iload 4
    //   1627: iconst_1
    //   1628: iadd
    //   1629: istore 4
    //   1631: goto -73 -> 1558
    //   1634: aload_0
    //   1635: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1638: aload 18
    //   1640: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1643: putfield 367	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
    //   1646: aload 22
    //   1648: ldc_w 369
    //   1651: invokeinterface 373 2 0
    //   1656: astore 17
    //   1658: aload 17
    //   1660: ifnull +233 -> 1893
    //   1663: aload 17
    //   1665: invokeinterface 362 1 0
    //   1670: ifnull +223 -> 1893
    //   1673: aload 17
    //   1675: invokeinterface 362 1 0
    //   1680: ldc_w 375
    //   1683: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1686: ifeq +12 -> 1698
    //   1689: iconst_4
    //   1690: istore_1
    //   1691: sipush -6101
    //   1694: istore_2
    //   1695: goto +1278 -> 2973
    //   1698: aload 17
    //   1700: invokeinterface 362 1 0
    //   1705: ldc_w 381
    //   1708: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1711: ifne +80 -> 1791
    //   1714: aload 17
    //   1716: invokeinterface 362 1 0
    //   1721: ldc_w 383
    //   1724: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1727: ifne +64 -> 1791
    //   1730: aload 17
    //   1732: invokeinterface 362 1 0
    //   1737: ldc_w 385
    //   1740: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1743: istore 14
    //   1745: iload 14
    //   1747: ifeq +6 -> 1753
    //   1750: goto +41 -> 1791
    //   1753: aload 17
    //   1755: invokeinterface 362 1 0
    //   1760: astore 17
    //   1762: aload 17
    //   1764: ifnull +129 -> 1893
    //   1767: aload 17
    //   1769: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1772: ifne +121 -> 1893
    //   1775: aload 17
    //   1777: invokestatic 394	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1780: invokevirtual 397	java/lang/Integer:intValue	()I
    //   1783: istore 4
    //   1785: iload 4
    //   1787: istore_2
    //   1788: goto +1704 -> 3492
    //   1791: aload_0
    //   1792: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1795: aload_0
    //   1796: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1799: iconst_3
    //   1800: sipush 206
    //   1803: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1806: getstatic 399	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1809: aload 17
    //   1811: invokeinterface 362 1 0
    //   1816: invokestatic 394	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1819: invokevirtual 397	java/lang/Integer:intValue	()I
    //   1822: aload_0
    //   1823: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1826: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1829: invokestatic 402	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   1832: aload 16
    //   1834: ifnull +58 -> 1892
    //   1837: aload 16
    //   1839: invokevirtual 211	java/io/FileInputStream:close	()V
    //   1842: return
    //   1843: astore 15
    //   1845: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1848: ifeq +44 -> 1892
    //   1851: new 89	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1858: astore 16
    //   1860: aload 16
    //   1862: ldc 213
    //   1864: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: pop
    //   1868: aload 16
    //   1870: aload 15
    //   1872: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   1875: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: pop
    //   1879: ldc 100
    //   1881: iconst_2
    //   1882: aload 16
    //   1884: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: aload 15
    //   1889: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1892: return
    //   1893: goto +1599 -> 3492
    //   1896: aload_0
    //   1897: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1900: iconst_0
    //   1901: aload 18
    //   1903: arraylength
    //   1904: i2l
    //   1905: invokestatic 405	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1908: new 407	java/io/DataInputStream
    //   1911: dup
    //   1912: aload 22
    //   1914: invokeinterface 411 1 0
    //   1919: invokeinterface 417 1 0
    //   1924: invokespecial 420	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   1927: astore 18
    //   1929: aload 18
    //   1931: ldc2_w 421
    //   1934: invokevirtual 423	java/io/DataInputStream:skip	(J)J
    //   1937: pop2
    //   1938: aload 18
    //   1940: invokevirtual 427	java/io/DataInputStream:readByte	()B
    //   1943: istore 4
    //   1945: iload 4
    //   1947: ifeq +23 -> 1970
    //   1950: aload 18
    //   1952: invokevirtual 428	java/io/DataInputStream:close	()V
    //   1955: goto +10 -> 1965
    //   1958: astore 17
    //   1960: aload 17
    //   1962: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   1965: iconst_0
    //   1966: istore_1
    //   1967: goto +1006 -> 2973
    //   1970: aload 18
    //   1972: invokevirtual 431	java/io/DataInputStream:readInt	()I
    //   1975: i2l
    //   1976: lstore 10
    //   1978: aload 18
    //   1980: invokevirtual 431	java/io/DataInputStream:readInt	()I
    //   1983: i2l
    //   1984: lstore 12
    //   1986: aload 22
    //   1988: invokeinterface 411 1 0
    //   1993: invokeinterface 434 1 0
    //   1998: lload 10
    //   2000: lload 12
    //   2002: bipush 32
    //   2004: lshl
    //   2005: lor
    //   2006: lstore 6
    //   2008: aload_0
    //   2009: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2012: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2015: lstore 10
    //   2017: lload 10
    //   2019: lload 6
    //   2021: lcmp
    //   2022: ifgt +50 -> 2072
    //   2025: aload_0
    //   2026: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2029: lload 6
    //   2031: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2034: aload_0
    //   2035: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2038: aload_0
    //   2039: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2042: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2045: putfield 437	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   2048: aload_0
    //   2049: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2052: aload_0
    //   2053: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2056: invokevirtual 440	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   2059: goto +13 -> 2072
    //   2062: astore 17
    //   2064: goto +134 -> 2198
    //   2067: astore 17
    //   2069: goto +142 -> 2211
    //   2072: lload 6
    //   2074: lload 8
    //   2076: lcmp
    //   2077: ifeq +76 -> 2153
    //   2080: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2083: ifeq +70 -> 2153
    //   2086: new 89	java/lang/StringBuilder
    //   2089: dup
    //   2090: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2093: astore 17
    //   2095: aload 17
    //   2097: ldc_w 442
    //   2100: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: pop
    //   2104: aload 17
    //   2106: lload 6
    //   2108: invokevirtual 445	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2111: pop
    //   2112: aload 17
    //   2114: ldc_w 447
    //   2117: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: pop
    //   2121: aload 17
    //   2123: lload 8
    //   2125: invokevirtual 445	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2128: pop
    //   2129: ldc 100
    //   2131: iconst_2
    //   2132: aload 17
    //   2134: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2137: invokestatic 449	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2140: goto +13 -> 2153
    //   2143: astore 17
    //   2145: goto +30 -> 2175
    //   2148: astore 17
    //   2150: goto +30 -> 2180
    //   2153: aload 18
    //   2155: invokevirtual 428	java/io/DataInputStream:close	()V
    //   2158: goto +10 -> 2168
    //   2161: astore 17
    //   2163: aload 17
    //   2165: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   2168: iconst_0
    //   2169: istore_1
    //   2170: goto +206 -> 2376
    //   2173: astore 17
    //   2175: goto +23 -> 2198
    //   2178: astore 17
    //   2180: goto +31 -> 2211
    //   2183: astore 19
    //   2185: aload 18
    //   2187: astore 17
    //   2189: aload 19
    //   2191: astore 18
    //   2193: goto +188 -> 2381
    //   2196: astore 17
    //   2198: aload 17
    //   2200: astore 22
    //   2202: lload 6
    //   2204: lstore 10
    //   2206: goto +33 -> 2239
    //   2209: astore 17
    //   2211: aload 17
    //   2213: astore 22
    //   2215: lload 6
    //   2217: lstore 10
    //   2219: goto +92 -> 2311
    //   2222: astore 17
    //   2224: aconst_null
    //   2225: astore 19
    //   2227: goto +162 -> 2389
    //   2230: astore 22
    //   2232: aconst_null
    //   2233: astore 18
    //   2235: lload 6
    //   2237: lstore 10
    //   2239: aload 18
    //   2241: astore 17
    //   2243: ldc 100
    //   2245: iconst_1
    //   2246: ldc_w 451
    //   2249: aload 22
    //   2251: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2254: aload 18
    //   2256: astore 17
    //   2258: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:z	I
    //   2261: istore 4
    //   2263: lload 10
    //   2265: lstore 6
    //   2267: iload 4
    //   2269: istore_2
    //   2270: aload 18
    //   2272: ifnull +104 -> 2376
    //   2275: aload 18
    //   2277: invokevirtual 428	java/io/DataInputStream:close	()V
    //   2280: lload 10
    //   2282: lstore 6
    //   2284: iload 4
    //   2286: istore_2
    //   2287: goto +89 -> 2376
    //   2290: astore 17
    //   2292: lload 10
    //   2294: lstore 6
    //   2296: iload 4
    //   2298: istore_2
    //   2299: goto +72 -> 2371
    //   2302: astore 22
    //   2304: aconst_null
    //   2305: astore 18
    //   2307: lload 6
    //   2309: lstore 10
    //   2311: aload 18
    //   2313: astore 17
    //   2315: ldc 100
    //   2317: iconst_1
    //   2318: ldc_w 456
    //   2321: aload 22
    //   2323: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2326: aload 18
    //   2328: astore 17
    //   2330: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:z	I
    //   2333: istore 4
    //   2335: lload 10
    //   2337: lstore 6
    //   2339: iload 4
    //   2341: istore_2
    //   2342: aload 18
    //   2344: ifnull +32 -> 2376
    //   2347: aload 18
    //   2349: invokevirtual 428	java/io/DataInputStream:close	()V
    //   2352: lload 10
    //   2354: lstore 6
    //   2356: iload 4
    //   2358: istore_2
    //   2359: goto +17 -> 2376
    //   2362: astore 17
    //   2364: iload 4
    //   2366: istore_2
    //   2367: lload 10
    //   2369: lstore 6
    //   2371: aload 17
    //   2373: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   2376: goto +1116 -> 3492
    //   2379: astore 18
    //   2381: aload 17
    //   2383: astore 19
    //   2385: aload 18
    //   2387: astore 17
    //   2389: aload 19
    //   2391: ifnull +18 -> 2409
    //   2394: aload 19
    //   2396: invokevirtual 428	java/io/DataInputStream:close	()V
    //   2399: goto +10 -> 2409
    //   2402: astore 18
    //   2404: aload 18
    //   2406: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   2409: aload 17
    //   2411: athrow
    //   2412: astore 18
    //   2414: goto +110 -> 2524
    //   2417: astore 18
    //   2419: ldc 100
    //   2421: iconst_1
    //   2422: ldc_w 458
    //   2425: aload 18
    //   2427: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2430: aload_0
    //   2431: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2434: aload_0
    //   2435: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2438: iconst_3
    //   2439: bipush 102
    //   2441: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2444: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2447: getstatic 461	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:m	I
    //   2450: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   2453: aload 17
    //   2455: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   2458: aload 23
    //   2460: invokevirtual 288	java/io/DataOutputStream:close	()V
    //   2463: aload 16
    //   2465: ifnull +58 -> 2523
    //   2468: aload 16
    //   2470: invokevirtual 211	java/io/FileInputStream:close	()V
    //   2473: return
    //   2474: astore 15
    //   2476: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2479: ifeq +44 -> 2523
    //   2482: new 89	java/lang/StringBuilder
    //   2485: dup
    //   2486: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2489: astore 16
    //   2491: aload 16
    //   2493: ldc 213
    //   2495: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: pop
    //   2499: aload 16
    //   2501: aload 15
    //   2503: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   2506: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: pop
    //   2510: ldc 100
    //   2512: iconst_2
    //   2513: aload 16
    //   2515: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2518: aload 15
    //   2520: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2523: return
    //   2524: aload 17
    //   2526: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   2529: aload 23
    //   2531: invokevirtual 288	java/io/DataOutputStream:close	()V
    //   2534: aload 18
    //   2536: athrow
    //   2537: astore 16
    //   2539: goto +22 -> 2561
    //   2542: astore 15
    //   2544: aload 16
    //   2546: astore 17
    //   2548: aload 15
    //   2550: astore 16
    //   2552: aload 17
    //   2554: astore 15
    //   2556: goto +234 -> 2790
    //   2559: astore 16
    //   2561: aload 15
    //   2563: astore 17
    //   2565: aload 16
    //   2567: astore 15
    //   2569: aload 17
    //   2571: astore 16
    //   2573: goto +331 -> 2904
    //   2576: astore 16
    //   2578: goto +212 -> 2790
    //   2581: astore 16
    //   2583: goto +906 -> 3489
    //   2586: aload 15
    //   2588: astore 17
    //   2590: aload 15
    //   2592: astore 18
    //   2594: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2597: ifeq +77 -> 2674
    //   2600: aload 15
    //   2602: astore 17
    //   2604: aload 15
    //   2606: astore 18
    //   2608: new 89	java/lang/StringBuilder
    //   2611: dup
    //   2612: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2615: astore 19
    //   2617: aload 15
    //   2619: astore 17
    //   2621: aload 15
    //   2623: astore 18
    //   2625: aload 19
    //   2627: ldc_w 463
    //   2630: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2633: pop
    //   2634: aload 15
    //   2636: astore 17
    //   2638: aload 15
    //   2640: astore 18
    //   2642: aload 19
    //   2644: aload 16
    //   2646: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   2649: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2652: pop
    //   2653: aload 15
    //   2655: astore 17
    //   2657: aload 15
    //   2659: astore 18
    //   2661: ldc 100
    //   2663: iconst_2
    //   2664: aload 19
    //   2666: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2669: aload 16
    //   2671: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2674: aload 15
    //   2676: astore 17
    //   2678: aload 15
    //   2680: astore 18
    //   2682: aload_0
    //   2683: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2686: aload_0
    //   2687: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2690: iconst_3
    //   2691: sipush 203
    //   2694: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2697: aload 15
    //   2699: astore 17
    //   2701: aload 15
    //   2703: astore 18
    //   2705: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2708: getstatic 466	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   2711: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   2714: aload 15
    //   2716: ifnull +58 -> 2774
    //   2719: aload 15
    //   2721: invokevirtual 211	java/io/FileInputStream:close	()V
    //   2724: return
    //   2725: astore 15
    //   2727: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2730: ifeq +44 -> 2774
    //   2733: new 89	java/lang/StringBuilder
    //   2736: dup
    //   2737: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2740: astore 16
    //   2742: aload 16
    //   2744: ldc 213
    //   2746: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: pop
    //   2750: aload 16
    //   2752: aload 15
    //   2754: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   2757: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: pop
    //   2761: ldc 100
    //   2763: iconst_2
    //   2764: aload 16
    //   2766: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2769: aload 15
    //   2771: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2774: return
    //   2775: astore 15
    //   2777: aload 17
    //   2779: astore 16
    //   2781: goto +123 -> 2904
    //   2784: astore 16
    //   2786: aload 18
    //   2788: astore 15
    //   2790: aload 15
    //   2792: astore 17
    //   2794: ldc 100
    //   2796: iconst_1
    //   2797: ldc_w 468
    //   2800: aload 16
    //   2802: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2805: aload 15
    //   2807: astore 17
    //   2809: aload_0
    //   2810: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2813: aload_0
    //   2814: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2817: iconst_3
    //   2818: bipush 102
    //   2820: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2823: aload 15
    //   2825: astore 17
    //   2827: getstatic 198	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2830: getstatic 471	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:u	I
    //   2833: aload_0
    //   2834: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2837: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   2840: invokestatic 402	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   2843: aload 15
    //   2845: ifnull +58 -> 2903
    //   2848: aload 15
    //   2850: invokevirtual 211	java/io/FileInputStream:close	()V
    //   2853: return
    //   2854: astore 15
    //   2856: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2859: ifeq +44 -> 2903
    //   2862: new 89	java/lang/StringBuilder
    //   2865: dup
    //   2866: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2869: astore 16
    //   2871: aload 16
    //   2873: ldc 213
    //   2875: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2878: pop
    //   2879: aload 16
    //   2881: aload 15
    //   2883: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   2886: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: pop
    //   2890: ldc 100
    //   2892: iconst_2
    //   2893: aload 16
    //   2895: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2898: aload 15
    //   2900: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2903: return
    //   2904: aload 16
    //   2906: ifnull +60 -> 2966
    //   2909: aload 16
    //   2911: invokevirtual 211	java/io/FileInputStream:close	()V
    //   2914: goto +52 -> 2966
    //   2917: astore 16
    //   2919: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2922: ifeq +44 -> 2966
    //   2925: new 89	java/lang/StringBuilder
    //   2928: dup
    //   2929: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2932: astore 17
    //   2934: aload 17
    //   2936: ldc 213
    //   2938: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2941: pop
    //   2942: aload 17
    //   2944: aload 16
    //   2946: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   2949: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2952: pop
    //   2953: ldc 100
    //   2955: iconst_2
    //   2956: aload 17
    //   2958: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2961: aload 16
    //   2963: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2966: aload 15
    //   2968: athrow
    //   2969: aload 15
    //   2971: astore 16
    //   2973: aload 16
    //   2975: ifnull +60 -> 3035
    //   2978: aload 16
    //   2980: invokevirtual 211	java/io/FileInputStream:close	()V
    //   2983: goto +52 -> 3035
    //   2986: astore 15
    //   2988: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2991: ifeq +44 -> 3035
    //   2994: new 89	java/lang/StringBuilder
    //   2997: dup
    //   2998: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3001: astore 16
    //   3003: aload 16
    //   3005: ldc 213
    //   3007: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3010: pop
    //   3011: aload 16
    //   3013: aload 15
    //   3015: invokevirtual 214	java/io/IOException:toString	()Ljava/lang/String;
    //   3018: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: pop
    //   3022: ldc 100
    //   3024: iconst_2
    //   3025: aload 16
    //   3027: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3030: aload 15
    //   3032: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3035: iload_1
    //   3036: iconst_3
    //   3037: if_icmple +82 -> 3119
    //   3040: aload_0
    //   3041: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3044: aload_0
    //   3045: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3048: iconst_3
    //   3049: bipush 105
    //   3051: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   3054: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3057: ifeq +45 -> 3102
    //   3060: new 89	java/lang/StringBuilder
    //   3063: dup
    //   3064: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3067: astore 15
    //   3069: aload 15
    //   3071: ldc_w 473
    //   3074: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3077: pop
    //   3078: aload 15
    //   3080: aload_0
    //   3081: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3084: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   3087: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3090: pop
    //   3091: ldc 100
    //   3093: iconst_2
    //   3094: aload 15
    //   3096: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3099: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3102: getstatic 399	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   3105: iload_2
    //   3106: aload_0
    //   3107: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3110: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   3113: invokestatic 402	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   3116: goto +321 -> 3437
    //   3119: aload_0
    //   3120: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3123: aload_0
    //   3124: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3127: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   3130: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   3133: aload_0
    //   3134: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3137: aload_0
    //   3138: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3141: bipush 6
    //   3143: invokevirtual 476	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   3146: aload_0
    //   3147: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3150: aload_0
    //   3151: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3154: invokevirtual 479	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   3157: aload_0
    //   3158: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3161: getfield 482	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   3164: invokestatic 488	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   3167: astore 15
    //   3169: aload_0
    //   3170: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3173: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   3176: invokestatic 488	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   3179: astore 16
    //   3181: aload_0
    //   3182: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3185: aload_0
    //   3186: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3189: aload_0
    //   3190: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3193: getfield 490	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3196: invokevirtual 494	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   3199: iconst_1
    //   3200: aload 15
    //   3202: aload 16
    //   3204: aload_0
    //   3205: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3208: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   3211: invokevirtual 500	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3214: aload_0
    //   3215: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3218: aconst_null
    //   3219: putfield 482	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   3222: aload_0
    //   3223: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3226: aconst_null
    //   3227: putfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   3230: aload_0
    //   3231: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3234: getfield 503	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3237: astore 15
    //   3239: new 89	java/lang/StringBuilder
    //   3242: dup
    //   3243: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3246: astore 16
    //   3248: aload 16
    //   3250: aload_0
    //   3251: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3254: getfield 490	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3257: invokevirtual 445	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3260: pop
    //   3261: aload 16
    //   3263: ldc_w 505
    //   3266: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3269: pop
    //   3270: aload 16
    //   3272: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3275: astore 16
    //   3277: new 89	java/lang/StringBuilder
    //   3280: dup
    //   3281: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3284: astore 17
    //   3286: aload 17
    //   3288: ldc_w 507
    //   3291: aload_0
    //   3292: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3295: getfield 510	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3298: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3301: iconst_1
    //   3302: ixor
    //   3303: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3306: pop
    //   3307: aload 17
    //   3309: ldc_w 505
    //   3312: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3315: pop
    //   3316: aload 15
    //   3318: ldc_w 515
    //   3321: ldc_w 517
    //   3324: ldc_w 505
    //   3327: ldc_w 519
    //   3330: ldc_w 521
    //   3333: iconst_0
    //   3334: iconst_0
    //   3335: aload 16
    //   3337: aload 17
    //   3339: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: ldc_w 505
    //   3345: ldc_w 505
    //   3348: invokestatic 526	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3351: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3354: ifeq +76 -> 3430
    //   3357: new 89	java/lang/StringBuilder
    //   3360: dup
    //   3361: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3364: astore 15
    //   3366: aload 15
    //   3368: ldc_w 528
    //   3371: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: pop
    //   3375: aload 15
    //   3377: aload_0
    //   3378: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3381: getfield 490	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3384: invokevirtual 445	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3387: pop
    //   3388: aload 15
    //   3390: ldc_w 530
    //   3393: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3396: pop
    //   3397: aload 15
    //   3399: ldc_w 507
    //   3402: aload_0
    //   3403: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3406: getfield 510	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3409: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3412: iconst_1
    //   3413: ixor
    //   3414: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3417: pop
    //   3418: ldc_w 532
    //   3421: iconst_2
    //   3422: aload 15
    //   3424: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3427: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3430: getstatic 534	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:a	I
    //   3433: iconst_0
    //   3434: invokestatic 206	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   3437: aload_0
    //   3438: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3441: aconst_null
    //   3442: putfield 254	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   3445: aload_0
    //   3446: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3449: aconst_null
    //   3450: putfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   3453: return
    //   3454: astore 16
    //   3456: goto -2649 -> 807
    //   3459: astore 17
    //   3461: goto -2142 -> 1319
    //   3464: astore 15
    //   3466: goto -1573 -> 1893
    //   3469: astore 15
    //   3471: goto -1008 -> 2463
    //   3474: astore 17
    //   3476: goto -942 -> 2534
    //   3479: astore 17
    //   3481: aload 16
    //   3483: astore 15
    //   3485: aload 17
    //   3487: astore 16
    //   3489: goto -903 -> 2586
    //   3492: sipush 16384
    //   3495: istore 4
    //   3497: aload 16
    //   3499: astore 15
    //   3501: aload 19
    //   3503: astore 16
    //   3505: goto -3314 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3508	0	this	TaskHttpUpload
    //   177	2861	1	i	int
    //   182	2924	2	j	int
    //   137	1183	3	k	int
    //   51	3445	4	m	int
    //   322	1241	5	n	int
    //   7	2363	6	l1	long
    //   174	1950	8	l2	long
    //   1976	392	10	l3	long
    //   1984	17	12	l4	long
    //   148	1598	14	bool	boolean
    //   76	190	15	localObject1	java.lang.Object
    //   271	112	15	localIOException1	IOException
    //   388	112	15	localIOException2	IOException
    //   505	91	15	localIOException3	IOException
    //   601	120	15	localIOException4	IOException
    //   726	127	15	localIOException5	IOException
    //   858	45	15	localIOException6	IOException
    //   971	117	15	localObject2	java.lang.Object
    //   1843	45	15	localIOException7	IOException
    //   2474	45	15	localIOException8	IOException
    //   2542	7	15	localInterruptedException1	java.lang.InterruptedException
    //   2554	166	15	localObject3	java.lang.Object
    //   2725	45	15	localIOException9	IOException
    //   2775	1	15	localObject4	java.lang.Object
    //   2788	61	15	localObject5	java.lang.Object
    //   2854	116	15	localIOException10	IOException
    //   2986	45	15	localIOException11	IOException
    //   3067	356	15	localObject6	java.lang.Object
    //   3464	1	15	localNumberFormatException	java.lang.NumberFormatException
    //   3469	1	15	localException1	Exception
    //   3483	17	15	localObject7	java.lang.Object
    //   134	872	16	localObject8	java.lang.Object
    //   1031	7	16	localObject9	java.lang.Object
    //   1043	1	16	localObject10	java.lang.Object
    //   1048	1	16	localInterruptedException2	java.lang.InterruptedException
    //   1053	1	16	localIOException12	IOException
    //   1089	1425	16	localObject11	java.lang.Object
    //   2537	8	16	localObject12	java.lang.Object
    //   2550	1	16	localInterruptedException3	java.lang.InterruptedException
    //   2559	7	16	localObject13	java.lang.Object
    //   2571	1	16	localObject14	java.lang.Object
    //   2576	1	16	localInterruptedException4	java.lang.InterruptedException
    //   2581	89	16	localIOException13	IOException
    //   2740	40	16	localObject15	java.lang.Object
    //   2784	17	16	localInterruptedException5	java.lang.InterruptedException
    //   2869	41	16	localStringBuilder1	StringBuilder
    //   2917	45	16	localIOException14	IOException
    //   2971	365	16	localObject16	java.lang.Object
    //   3454	28	16	localFileNotFoundException	java.io.FileNotFoundException
    //   3487	17	16	localObject17	java.lang.Object
    //   179	1631	17	localObject18	java.lang.Object
    //   1958	3	17	localIOException15	IOException
    //   2062	1	17	localIOException16	IOException
    //   2067	1	17	localIllegalStateException1	java.lang.IllegalStateException
    //   2093	40	17	localStringBuilder2	StringBuilder
    //   2143	1	17	localIOException17	IOException
    //   2148	1	17	localIllegalStateException2	java.lang.IllegalStateException
    //   2161	3	17	localIOException18	IOException
    //   2173	1	17	localIOException19	IOException
    //   2178	1	17	localIllegalStateException3	java.lang.IllegalStateException
    //   2187	1	17	localObject19	java.lang.Object
    //   2196	3	17	localIOException20	IOException
    //   2209	3	17	localIllegalStateException4	java.lang.IllegalStateException
    //   2222	1	17	localObject20	java.lang.Object
    //   2241	16	17	localObject21	java.lang.Object
    //   2290	1	17	localIOException21	IOException
    //   2313	16	17	localObject22	java.lang.Object
    //   2362	20	17	localIOException22	IOException
    //   2387	951	17	localObject23	java.lang.Object
    //   3459	1	17	localException2	Exception
    //   3474	1	17	localException3	Exception
    //   3479	7	17	localIOException23	IOException
    //   210	2138	18	localObject24	java.lang.Object
    //   2379	7	18	localObject25	java.lang.Object
    //   2402	3	18	localIOException24	IOException
    //   2412	1	18	localObject26	java.lang.Object
    //   2417	118	18	localIOException25	IOException
    //   2592	195	18	localObject27	java.lang.Object
    //   198	1258	19	localObject28	java.lang.Object
    //   2183	7	19	localObject29	java.lang.Object
    //   2225	1277	19	localObject30	java.lang.Object
    //   38	976	20	localFile	java.io.File
    //   185	1148	21	localObject31	java.lang.Object
    //   940	1274	22	localObject32	java.lang.Object
    //   2230	20	22	localIOException26	IOException
    //   2302	20	22	localIllegalStateException5	java.lang.IllegalStateException
    //   1149	1381	23	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   265	270	271	java/io/IOException
    //   382	387	388	java/io/IOException
    //   499	504	505	java/io/IOException
    //   595	600	601	java/io/IOException
    //   720	725	726	java/io/IOException
    //   852	857	858	java/io/IOException
    //   1020	1028	1031	finally
    //   1020	1028	1048	java/lang/InterruptedException
    //   1020	1028	1053	java/io/IOException
    //   1837	1842	1843	java/io/IOException
    //   1950	1955	1958	java/io/IOException
    //   2025	2059	2062	java/io/IOException
    //   2025	2059	2067	java/lang/IllegalStateException
    //   2121	2140	2143	java/io/IOException
    //   2121	2140	2148	java/lang/IllegalStateException
    //   2153	2158	2161	java/io/IOException
    //   2008	2017	2173	java/io/IOException
    //   2080	2121	2173	java/io/IOException
    //   2008	2017	2178	java/lang/IllegalStateException
    //   2080	2121	2178	java/lang/IllegalStateException
    //   1929	1945	2183	finally
    //   1970	1998	2183	finally
    //   2008	2017	2183	finally
    //   2025	2059	2183	finally
    //   2080	2121	2183	finally
    //   2121	2140	2183	finally
    //   1929	1945	2196	java/io/IOException
    //   1970	1998	2196	java/io/IOException
    //   1929	1945	2209	java/lang/IllegalStateException
    //   1970	1998	2209	java/lang/IllegalStateException
    //   1908	1929	2222	finally
    //   1908	1929	2230	java/io/IOException
    //   2275	2280	2290	java/io/IOException
    //   1908	1929	2302	java/lang/IllegalStateException
    //   2347	2352	2362	java/io/IOException
    //   2243	2254	2379	finally
    //   2258	2263	2379	finally
    //   2315	2326	2379	finally
    //   2330	2335	2379	finally
    //   2394	2399	2402	java/io/IOException
    //   1151	1309	2412	finally
    //   2419	2453	2412	finally
    //   1151	1309	2417	java/io/IOException
    //   2468	2473	2474	java/io/IOException
    //   1099	1151	2537	finally
    //   1309	1319	2537	finally
    //   1323	1390	2537	finally
    //   1393	1435	2537	finally
    //   1435	1466	2537	finally
    //   1471	1493	2537	finally
    //   1493	1497	2537	finally
    //   1500	1513	2537	finally
    //   1527	1536	2537	finally
    //   1541	1555	2537	finally
    //   1572	1625	2537	finally
    //   1634	1646	2537	finally
    //   1646	1658	2537	finally
    //   1663	1689	2537	finally
    //   1698	1745	2537	finally
    //   1753	1762	2537	finally
    //   1767	1785	2537	finally
    //   1791	1832	2537	finally
    //   1896	1908	2537	finally
    //   1950	1955	2537	finally
    //   1960	1965	2537	finally
    //   2153	2158	2537	finally
    //   2163	2168	2537	finally
    //   2275	2280	2537	finally
    //   2347	2352	2537	finally
    //   2371	2376	2537	finally
    //   2394	2399	2537	finally
    //   2404	2409	2537	finally
    //   2409	2412	2537	finally
    //   2453	2463	2537	finally
    //   2524	2534	2537	finally
    //   2534	2537	2537	finally
    //   1099	1151	2542	java/lang/InterruptedException
    //   1309	1319	2542	java/lang/InterruptedException
    //   1323	1390	2542	java/lang/InterruptedException
    //   1393	1435	2542	java/lang/InterruptedException
    //   1435	1466	2542	java/lang/InterruptedException
    //   1471	1493	2542	java/lang/InterruptedException
    //   1493	1497	2542	java/lang/InterruptedException
    //   1500	1513	2542	java/lang/InterruptedException
    //   1527	1536	2542	java/lang/InterruptedException
    //   1541	1555	2542	java/lang/InterruptedException
    //   1572	1625	2542	java/lang/InterruptedException
    //   1634	1646	2542	java/lang/InterruptedException
    //   1646	1658	2542	java/lang/InterruptedException
    //   1663	1689	2542	java/lang/InterruptedException
    //   1698	1745	2542	java/lang/InterruptedException
    //   1753	1762	2542	java/lang/InterruptedException
    //   1767	1785	2542	java/lang/InterruptedException
    //   1791	1832	2542	java/lang/InterruptedException
    //   1896	1908	2542	java/lang/InterruptedException
    //   1950	1955	2542	java/lang/InterruptedException
    //   1960	1965	2542	java/lang/InterruptedException
    //   2153	2158	2542	java/lang/InterruptedException
    //   2163	2168	2542	java/lang/InterruptedException
    //   2275	2280	2542	java/lang/InterruptedException
    //   2347	2352	2542	java/lang/InterruptedException
    //   2371	2376	2542	java/lang/InterruptedException
    //   2394	2399	2542	java/lang/InterruptedException
    //   2404	2409	2542	java/lang/InterruptedException
    //   2409	2412	2542	java/lang/InterruptedException
    //   2453	2463	2542	java/lang/InterruptedException
    //   2524	2534	2542	java/lang/InterruptedException
    //   2534	2537	2542	java/lang/InterruptedException
    //   1058	1067	2559	finally
    //   1058	1067	2576	java/lang/InterruptedException
    //   1058	1067	2581	java/io/IOException
    //   2719	2724	2725	java/io/IOException
    //   212	221	2775	finally
    //   229	243	2775	finally
    //   251	260	2775	finally
    //   345	351	2775	finally
    //   359	372	2775	finally
    //   446	455	2775	finally
    //   463	477	2775	finally
    //   485	494	2775	finally
    //   572	585	2775	finally
    //   659	675	2775	finally
    //   683	698	2775	finally
    //   706	715	2775	finally
    //   793	804	2775	finally
    //   815	830	2775	finally
    //   838	847	2775	finally
    //   920	928	2775	finally
    //   936	942	2775	finally
    //   958	969	2775	finally
    //   996	1001	2775	finally
    //   1009	1020	2775	finally
    //   2594	2600	2775	finally
    //   2608	2617	2775	finally
    //   2625	2634	2775	finally
    //   2642	2653	2775	finally
    //   2661	2674	2775	finally
    //   2682	2697	2775	finally
    //   2705	2714	2775	finally
    //   2794	2805	2775	finally
    //   2809	2823	2775	finally
    //   2827	2843	2775	finally
    //   212	221	2784	java/lang/InterruptedException
    //   229	243	2784	java/lang/InterruptedException
    //   251	260	2784	java/lang/InterruptedException
    //   345	351	2784	java/lang/InterruptedException
    //   359	372	2784	java/lang/InterruptedException
    //   446	455	2784	java/lang/InterruptedException
    //   463	477	2784	java/lang/InterruptedException
    //   485	494	2784	java/lang/InterruptedException
    //   572	585	2784	java/lang/InterruptedException
    //   659	675	2784	java/lang/InterruptedException
    //   683	698	2784	java/lang/InterruptedException
    //   706	715	2784	java/lang/InterruptedException
    //   793	804	2784	java/lang/InterruptedException
    //   815	830	2784	java/lang/InterruptedException
    //   838	847	2784	java/lang/InterruptedException
    //   920	928	2784	java/lang/InterruptedException
    //   936	942	2784	java/lang/InterruptedException
    //   958	969	2784	java/lang/InterruptedException
    //   996	1001	2784	java/lang/InterruptedException
    //   1009	1020	2784	java/lang/InterruptedException
    //   2594	2600	2784	java/lang/InterruptedException
    //   2608	2617	2784	java/lang/InterruptedException
    //   2625	2634	2784	java/lang/InterruptedException
    //   2642	2653	2784	java/lang/InterruptedException
    //   2661	2674	2784	java/lang/InterruptedException
    //   2682	2697	2784	java/lang/InterruptedException
    //   2705	2714	2784	java/lang/InterruptedException
    //   2848	2853	2854	java/io/IOException
    //   2909	2914	2917	java/io/IOException
    //   2978	2983	2986	java/io/IOException
    //   793	804	3454	java/io/FileNotFoundException
    //   1309	1319	3459	java/lang/Exception
    //   1753	1762	3464	java/lang/NumberFormatException
    //   1753	1762	3464	java/lang/Exception
    //   1767	1785	3464	java/lang/NumberFormatException
    //   1767	1785	3464	java/lang/Exception
    //   2453	2463	3469	java/lang/Exception
    //   2524	2534	3474	java/lang/Exception
    //   958	969	3479	java/io/IOException
    //   996	1001	3479	java/io/IOException
    //   1009	1020	3479	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */