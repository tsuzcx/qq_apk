package com.tencent.mobileqq.troop.utils;

import bdin;
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
    if ((paramHttpClient == null) || (paramString == null) || (paramArrayOfByte == null)) {}
    do
    {
      for (;;)
      {
        return null;
        HttpPost localHttpPost = new HttpPost(paramString);
        localHttpPost.setHeader("User-Agent", "TroopFile");
        localHttpPost.setHeader("Content-Type", "text/octet");
        localHttpPost.setHeader("Connection", "keep-alive");
        if (bdin.h(BaseApplication.getContext()))
        {
          localHttpPost.setHeader("Net-type", "Wifi");
          localHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
        }
        try
        {
          paramHttpClient = paramHttpClient.execute(localHttpPost);
          return paramHttpClient;
          localHttpPost.setHeader("Net-type", "gprs");
        }
        catch (ClientProtocolException paramHttpClient)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "ClientProtocolException, url" + paramString);
          }
          paramHttpClient.printStackTrace();
          return null;
        }
        catch (IOException paramHttpClient)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "IOException, url" + paramString);
          }
          paramHttpClient.printStackTrace();
          return null;
        }
        catch (IllegalArgumentException paramHttpClient)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("TroopFileTransferManager", 2, "IllegalArgumentException, url" + paramString);
            return null;
          }
        }
        catch (Exception paramHttpClient) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopFileTransferManager", 2, "Exception, url" + paramString);
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   4: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   7: lstore 8
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
    //   38: astore 26
    //   40: aload_0
    //   41: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: iconst_0
    //   45: putfield 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   48: aload_0
    //   49: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   52: invokevirtual 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   55: ifnull +3666 -> 3721
    //   58: aload_0
    //   59: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   62: invokevirtual 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   65: iconst_5
    //   66: invokeinterface 162 2 0
    //   71: astore 24
    //   73: iconst_0
    //   74: istore 4
    //   76: aload 24
    //   78: ifnull +184 -> 262
    //   81: aload 24
    //   83: invokeinterface 168 1 0
    //   88: ifle +174 -> 262
    //   91: aload 24
    //   93: iconst_0
    //   94: invokeinterface 172 2 0
    //   99: ifnull +163 -> 262
    //   102: iconst_0
    //   103: aload 24
    //   105: iconst_0
    //   106: invokeinterface 172 2 0
    //   111: checkcast 174	mqq/manager/ProxyIpManager$ProxyIp
    //   114: getfield 177	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   117: sipush 10000
    //   120: sipush 20000
    //   123: invokestatic 182	ec:a	(ZIII)Lorg/apache/http/client/HttpClient;
    //   126: astore 25
    //   128: iconst_1
    //   129: istore 4
    //   131: aconst_null
    //   132: astore 19
    //   134: iconst_m1
    //   135: istore_3
    //   136: sipush 1024
    //   139: istore_2
    //   140: lload 8
    //   142: lstore 6
    //   144: iconst_0
    //   145: istore_1
    //   146: iload_1
    //   147: iconst_3
    //   148: if_icmpgt +3557 -> 3705
    //   151: iload_1
    //   152: ifle +361 -> 513
    //   155: aload 19
    //   157: astore 22
    //   159: aload 19
    //   161: astore 21
    //   163: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokestatic 185	bdin:g	(Landroid/content/Context;)Z
    //   169: ifne +125 -> 294
    //   172: aload 19
    //   174: astore 22
    //   176: aload 19
    //   178: astore 21
    //   180: aload_0
    //   181: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   184: aload_0
    //   185: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   188: iconst_3
    //   189: bipush 106
    //   191: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   194: aload 19
    //   196: astore 22
    //   198: aload 19
    //   200: astore 21
    //   202: getstatic 192	bcps:b	I
    //   205: getstatic 195	bcps:k	I
    //   208: invokestatic 200	bcpr:a	(II)V
    //   211: aload 19
    //   213: ifnull -190 -> 23
    //   216: aload 19
    //   218: invokevirtual 205	java/io/FileInputStream:close	()V
    //   221: return
    //   222: astore 19
    //   224: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq -204 -> 23
    //   230: ldc 89
    //   232: iconst_2
    //   233: new 91	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   240: ldc 207
    //   242: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 19
    //   247: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   250: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload 19
    //   258: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: return
    //   262: invokestatic 215	ec:a	()Lee;
    //   265: ifnull +23 -> 288
    //   268: iconst_1
    //   269: istore 18
    //   271: iconst_0
    //   272: iload 18
    //   274: sipush 10000
    //   277: sipush 20000
    //   280: invokestatic 218	ec:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   283: astore 25
    //   285: goto -154 -> 131
    //   288: iconst_0
    //   289: istore 18
    //   291: goto -20 -> 271
    //   294: iconst_0
    //   295: istore 5
    //   297: iload 5
    //   299: iload_1
    //   300: bipush 100
    //   302: imul
    //   303: if_icmpge +210 -> 513
    //   306: aload 19
    //   308: astore 22
    //   310: aload 19
    //   312: astore 21
    //   314: ldc2_w 219
    //   317: invokestatic 226	java/lang/Thread:sleep	(J)V
    //   320: aload 19
    //   322: astore 22
    //   324: aload 19
    //   326: astore 21
    //   328: aload_0
    //   329: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   332: aload_0
    //   333: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   336: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   339: istore 18
    //   341: iload 18
    //   343: ifeq +54 -> 397
    //   346: aload 19
    //   348: ifnull -325 -> 23
    //   351: aload 19
    //   353: invokevirtual 205	java/io/FileInputStream:close	()V
    //   356: return
    //   357: astore 19
    //   359: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -339 -> 23
    //   365: ldc 89
    //   367: iconst_2
    //   368: new 91	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   375: ldc 207
    //   377: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 19
    //   382: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   385: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: aload 19
    //   393: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   396: return
    //   397: aload 19
    //   399: astore 22
    //   401: aload 19
    //   403: astore 21
    //   405: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   408: invokestatic 185	bdin:g	(Landroid/content/Context;)Z
    //   411: ifne +93 -> 504
    //   414: aload 19
    //   416: astore 22
    //   418: aload 19
    //   420: astore 21
    //   422: aload_0
    //   423: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   426: aload_0
    //   427: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   430: iconst_3
    //   431: bipush 106
    //   433: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   436: aload 19
    //   438: astore 22
    //   440: aload 19
    //   442: astore 21
    //   444: getstatic 192	bcps:b	I
    //   447: getstatic 195	bcps:k	I
    //   450: invokestatic 200	bcpr:a	(II)V
    //   453: aload 19
    //   455: ifnull -432 -> 23
    //   458: aload 19
    //   460: invokevirtual 205	java/io/FileInputStream:close	()V
    //   463: return
    //   464: astore 19
    //   466: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -446 -> 23
    //   472: ldc 89
    //   474: iconst_2
    //   475: new 91	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   482: ldc 207
    //   484: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 19
    //   489: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   492: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: aload 19
    //   500: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: return
    //   504: iload 5
    //   506: iconst_1
    //   507: iadd
    //   508: istore 5
    //   510: goto -213 -> 297
    //   513: aload 19
    //   515: astore 22
    //   517: aload 19
    //   519: astore 21
    //   521: aload_0
    //   522: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   525: aload_0
    //   526: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   529: invokevirtual 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   532: istore 18
    //   534: iload 18
    //   536: ifeq +54 -> 590
    //   539: aload 19
    //   541: ifnull -518 -> 23
    //   544: aload 19
    //   546: invokevirtual 205	java/io/FileInputStream:close	()V
    //   549: return
    //   550: astore 19
    //   552: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq -532 -> 23
    //   558: ldc 89
    //   560: iconst_2
    //   561: new 91	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   568: ldc 207
    //   570: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 19
    //   575: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   578: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: aload 19
    //   586: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   589: return
    //   590: aload 19
    //   592: astore 22
    //   594: aload 19
    //   596: astore 21
    //   598: aload 26
    //   600: invokevirtual 230	java/io/File:length	()J
    //   603: aload_0
    //   604: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   607: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   610: lcmp
    //   611: ifeq +94 -> 705
    //   614: aload 19
    //   616: astore 22
    //   618: aload 19
    //   620: astore 21
    //   622: aload_0
    //   623: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   626: aload_0
    //   627: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   630: iconst_3
    //   631: sipush 206
    //   634: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   637: aload 19
    //   639: astore 22
    //   641: aload 19
    //   643: astore 21
    //   645: getstatic 192	bcps:b	I
    //   648: getstatic 236	bcps:t	I
    //   651: invokestatic 200	bcpr:a	(II)V
    //   654: aload 19
    //   656: ifnull -633 -> 23
    //   659: aload 19
    //   661: invokevirtual 205	java/io/FileInputStream:close	()V
    //   664: return
    //   665: astore 19
    //   667: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq -647 -> 23
    //   673: ldc 89
    //   675: iconst_2
    //   676: new 91	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   683: ldc 207
    //   685: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload 19
    //   690: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   693: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: aload 19
    //   701: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   704: return
    //   705: aload 19
    //   707: astore 20
    //   709: aload 19
    //   711: ifnonnull +22 -> 733
    //   714: aload 19
    //   716: astore 22
    //   718: aload 19
    //   720: astore 21
    //   722: new 202	java/io/FileInputStream
    //   725: dup
    //   726: aload 26
    //   728: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   731: astore 20
    //   733: iload_1
    //   734: iconst_1
    //   735: iadd
    //   736: istore_1
    //   737: aload 20
    //   739: astore 22
    //   741: aload 20
    //   743: astore 21
    //   745: aload_0
    //   746: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   749: iload_1
    //   750: putfield 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   753: aload 20
    //   755: astore 22
    //   757: aload 20
    //   759: astore 21
    //   761: iload_2
    //   762: newarray byte
    //   764: astore 27
    //   766: lload 8
    //   768: lload 6
    //   770: lcmp
    //   771: ifle +261 -> 1032
    //   774: aload 20
    //   776: astore 23
    //   778: aload 20
    //   780: astore 22
    //   782: aload 20
    //   784: astore 21
    //   786: aload 20
    //   788: lload 8
    //   790: lload 6
    //   792: lsub
    //   793: invokevirtual 243	java/io/FileInputStream:skip	(J)J
    //   796: pop2
    //   797: aload 20
    //   799: astore 19
    //   801: aload 19
    //   803: astore 23
    //   805: aload 19
    //   807: astore 22
    //   809: aload 19
    //   811: astore 21
    //   813: aload 19
    //   815: aload 27
    //   817: invokevirtual 247	java/io/FileInputStream:read	([B)I
    //   820: istore_2
    //   821: iload_2
    //   822: ifle +2892 -> 3714
    //   825: iload_2
    //   826: i2l
    //   827: lload 8
    //   829: ladd
    //   830: lstore 6
    //   832: iload_2
    //   833: ifge +381 -> 1214
    //   836: aload 19
    //   838: astore 21
    //   840: iload_3
    //   841: istore_2
    //   842: aload 21
    //   844: ifnull +8 -> 852
    //   847: aload 21
    //   849: invokevirtual 205	java/io/FileInputStream:close	()V
    //   852: iload_1
    //   853: iconst_3
    //   854: if_icmple +2404 -> 3258
    //   857: aload_0
    //   858: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   861: aload_0
    //   862: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   865: iconst_3
    //   866: bipush 105
    //   868: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   871: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   874: ifeq +34 -> 908
    //   877: ldc 89
    //   879: iconst_2
    //   880: new 91	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   887: ldc 249
    //   889: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload_0
    //   893: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   896: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   899: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: getstatic 254	bcps:d	I
    //   911: iload_2
    //   912: aload_0
    //   913: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   916: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   919: invokestatic 257	bcpr:a	(IILjava/lang/String;)V
    //   922: aload_0
    //   923: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   926: aconst_null
    //   927: putfield 261	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   930: aload_0
    //   931: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   934: aconst_null
    //   935: putfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   938: return
    //   939: astore 20
    //   941: aload 19
    //   943: astore 22
    //   945: aload 19
    //   947: astore 21
    //   949: aload_0
    //   950: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   953: aload_0
    //   954: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   957: iconst_3
    //   958: sipush 201
    //   961: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   964: aload 19
    //   966: astore 22
    //   968: aload 19
    //   970: astore 21
    //   972: getstatic 192	bcps:b	I
    //   975: getstatic 263	bcps:g	I
    //   978: invokestatic 200	bcpr:a	(II)V
    //   981: aload 19
    //   983: ifnull -960 -> 23
    //   986: aload 19
    //   988: invokevirtual 205	java/io/FileInputStream:close	()V
    //   991: return
    //   992: astore 19
    //   994: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   997: ifeq -974 -> 23
    //   1000: ldc 89
    //   1002: iconst_2
    //   1003: new 91	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1010: ldc 207
    //   1012: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload 19
    //   1017: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   1020: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: aload 19
    //   1028: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1031: return
    //   1032: aload 20
    //   1034: astore 19
    //   1036: lload 8
    //   1038: lload 6
    //   1040: lcmp
    //   1041: ifge -240 -> 801
    //   1044: aload 20
    //   1046: astore 23
    //   1048: aload 20
    //   1050: astore 22
    //   1052: aload 20
    //   1054: astore 21
    //   1056: aload 20
    //   1058: invokevirtual 205	java/io/FileInputStream:close	()V
    //   1061: aload 20
    //   1063: astore 23
    //   1065: aload 20
    //   1067: astore 22
    //   1069: aload 20
    //   1071: astore 21
    //   1073: new 202	java/io/FileInputStream
    //   1076: dup
    //   1077: aload 26
    //   1079: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1082: astore 19
    //   1084: aload 19
    //   1086: lload 8
    //   1088: invokevirtual 243	java/io/FileInputStream:skip	(J)J
    //   1091: pop2
    //   1092: goto -291 -> 801
    //   1095: astore 20
    //   1097: aload 23
    //   1099: astore 19
    //   1101: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +35 -> 1139
    //   1107: ldc 89
    //   1109: iconst_2
    //   1110: new 91	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1117: ldc_w 265
    //   1120: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: aload 20
    //   1125: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   1128: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: aload 20
    //   1136: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1139: aload_0
    //   1140: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1143: aload_0
    //   1144: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1147: iconst_3
    //   1148: sipush 203
    //   1151: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1154: getstatic 192	bcps:b	I
    //   1157: getstatic 268	bcps:j	I
    //   1160: invokestatic 200	bcpr:a	(II)V
    //   1163: aload 19
    //   1165: ifnull -1142 -> 23
    //   1168: aload 19
    //   1170: invokevirtual 205	java/io/FileInputStream:close	()V
    //   1173: return
    //   1174: astore 19
    //   1176: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1179: ifeq -1156 -> 23
    //   1182: ldc 89
    //   1184: iconst_2
    //   1185: new 91	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1192: ldc 207
    //   1194: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload 19
    //   1199: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   1202: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: aload 19
    //   1210: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1213: return
    //   1214: aload 19
    //   1216: astore 22
    //   1218: aload 19
    //   1220: astore 21
    //   1222: aload_0
    //   1223: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1226: getfield 261	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1229: arraylength
    //   1230: iconst_2
    //   1231: iadd
    //   1232: iconst_2
    //   1233: iadd
    //   1234: aload_0
    //   1235: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1238: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1241: arraylength
    //   1242: iadd
    //   1243: bipush 20
    //   1245: iadd
    //   1246: iload_2
    //   1247: iadd
    //   1248: istore_3
    //   1249: aload 19
    //   1251: astore 22
    //   1253: aload 19
    //   1255: astore 21
    //   1257: new 273	java/io/ByteArrayOutputStream
    //   1260: dup
    //   1261: iload_3
    //   1262: bipush 16
    //   1264: iadd
    //   1265: invokespecial 276	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1268: astore 20
    //   1270: aload 19
    //   1272: astore 22
    //   1274: aload 19
    //   1276: astore 21
    //   1278: new 278	java/io/DataOutputStream
    //   1281: dup
    //   1282: aload 20
    //   1284: invokespecial 281	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1287: astore 28
    //   1289: aload 28
    //   1291: ldc_w 282
    //   1294: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1297: aload 28
    //   1299: sipush 1007
    //   1302: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1305: aload 28
    //   1307: iconst_0
    //   1308: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1311: aload 28
    //   1313: iload_3
    //   1314: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1317: aload 28
    //   1319: aload_0
    //   1320: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1323: getfield 261	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1326: arraylength
    //   1327: invokevirtual 288	java/io/DataOutputStream:writeShort	(I)V
    //   1330: aload 28
    //   1332: aload_0
    //   1333: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1336: getfield 261	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1339: invokevirtual 291	java/io/DataOutputStream:write	([B)V
    //   1342: aload 28
    //   1344: aload_0
    //   1345: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1348: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1351: arraylength
    //   1352: invokevirtual 288	java/io/DataOutputStream:writeShort	(I)V
    //   1355: aload 28
    //   1357: aload_0
    //   1358: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1361: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1364: invokevirtual 291	java/io/DataOutputStream:write	([B)V
    //   1367: aload 28
    //   1369: aload_0
    //   1370: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1373: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1376: ldc2_w 292
    //   1379: land
    //   1380: l2i
    //   1381: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1384: aload 28
    //   1386: ldc2_w 292
    //   1389: lload 8
    //   1391: land
    //   1392: l2i
    //   1393: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1396: aload 28
    //   1398: iload_2
    //   1399: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1402: aload 28
    //   1404: aload_0
    //   1405: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1408: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1411: bipush 32
    //   1413: lshr
    //   1414: l2i
    //   1415: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1418: aload 28
    //   1420: lload 8
    //   1422: bipush 32
    //   1424: lshr
    //   1425: l2i
    //   1426: invokevirtual 285	java/io/DataOutputStream:writeInt	(I)V
    //   1429: aload 28
    //   1431: aload 27
    //   1433: iconst_0
    //   1434: iload_2
    //   1435: invokevirtual 296	java/io/DataOutputStream:write	([BII)V
    //   1438: aload 20
    //   1440: invokevirtual 300	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1443: astore 23
    //   1445: aload 19
    //   1447: astore 22
    //   1449: aload 19
    //   1451: astore 21
    //   1453: aload 20
    //   1455: invokevirtual 301	java/io/ByteArrayOutputStream:close	()V
    //   1458: aload 19
    //   1460: astore 22
    //   1462: aload 19
    //   1464: astore 21
    //   1466: aload 28
    //   1468: invokevirtual 302	java/io/DataOutputStream:close	()V
    //   1471: iload 4
    //   1473: ifeq +452 -> 1925
    //   1476: aload 19
    //   1478: astore 22
    //   1480: aload 19
    //   1482: astore 21
    //   1484: ldc_w 304
    //   1487: iconst_5
    //   1488: anewarray 306	java/lang/Object
    //   1491: dup
    //   1492: iconst_0
    //   1493: aload 24
    //   1495: iconst_0
    //   1496: invokeinterface 172 2 0
    //   1501: checkcast 174	mqq/manager/ProxyIpManager$ProxyIp
    //   1504: getfield 309	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1507: aastore
    //   1508: dup
    //   1509: iconst_1
    //   1510: lload 8
    //   1512: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1515: aastore
    //   1516: dup
    //   1517: iconst_2
    //   1518: iload_2
    //   1519: i2l
    //   1520: lload 8
    //   1522: ladd
    //   1523: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1526: aastore
    //   1527: dup
    //   1528: iconst_3
    //   1529: aload_0
    //   1530: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1533: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1536: aastore
    //   1537: dup
    //   1538: iconst_4
    //   1539: bipush 80
    //   1541: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1544: aastore
    //   1545: invokestatic 326	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1548: astore 20
    //   1550: aload 19
    //   1552: astore 22
    //   1554: aload 19
    //   1556: astore 21
    //   1558: aload_0
    //   1559: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1562: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   1565: putfield 334	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   1568: aload 19
    //   1570: astore 22
    //   1572: aload 19
    //   1574: astore 21
    //   1576: aload_0
    //   1577: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1580: aload 20
    //   1582: putfield 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   1585: aload 19
    //   1587: astore 22
    //   1589: aload 19
    //   1591: astore 21
    //   1593: aload_0
    //   1594: aload 25
    //   1596: aload 20
    //   1598: aload 23
    //   1600: invokespecial 339	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   1603: astore 27
    //   1605: aload 27
    //   1607: ifnonnull +370 -> 1977
    //   1610: aload 19
    //   1612: astore 22
    //   1614: aload 19
    //   1616: astore 21
    //   1618: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1621: ifeq +27 -> 1648
    //   1624: aload 19
    //   1626: astore 22
    //   1628: aload 19
    //   1630: astore 21
    //   1632: ldc 89
    //   1634: iconst_2
    //   1635: ldc_w 341
    //   1638: iconst_0
    //   1639: anewarray 306	java/lang/Object
    //   1642: invokestatic 326	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1645: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1648: aload 19
    //   1650: astore 22
    //   1652: aload 19
    //   1654: astore 21
    //   1656: getstatic 344	bcps:z	I
    //   1659: istore_3
    //   1660: sipush 16384
    //   1663: istore_2
    //   1664: goto -1518 -> 146
    //   1667: astore 21
    //   1669: ldc 89
    //   1671: iconst_1
    //   1672: ldc_w 346
    //   1675: aload 21
    //   1677: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1680: aload_0
    //   1681: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1684: aload_0
    //   1685: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1688: iconst_3
    //   1689: bipush 102
    //   1691: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1694: getstatic 192	bcps:b	I
    //   1697: getstatic 352	bcps:m	I
    //   1700: invokestatic 200	bcpr:a	(II)V
    //   1703: aload 19
    //   1705: astore 22
    //   1707: aload 19
    //   1709: astore 21
    //   1711: aload 20
    //   1713: invokevirtual 301	java/io/ByteArrayOutputStream:close	()V
    //   1716: aload 19
    //   1718: astore 22
    //   1720: aload 19
    //   1722: astore 21
    //   1724: aload 28
    //   1726: invokevirtual 302	java/io/DataOutputStream:close	()V
    //   1729: aload 19
    //   1731: ifnull -1708 -> 23
    //   1734: aload 19
    //   1736: invokevirtual 205	java/io/FileInputStream:close	()V
    //   1739: return
    //   1740: astore 19
    //   1742: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1745: ifeq -1722 -> 23
    //   1748: ldc 89
    //   1750: iconst_2
    //   1751: new 91	java/lang/StringBuilder
    //   1754: dup
    //   1755: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1758: ldc 207
    //   1760: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 19
    //   1765: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   1768: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: aload 19
    //   1776: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1779: return
    //   1780: astore 23
    //   1782: aload 19
    //   1784: astore 22
    //   1786: aload 19
    //   1788: astore 21
    //   1790: aload 20
    //   1792: invokevirtual 301	java/io/ByteArrayOutputStream:close	()V
    //   1795: aload 19
    //   1797: astore 22
    //   1799: aload 19
    //   1801: astore 21
    //   1803: aload 28
    //   1805: invokevirtual 302	java/io/DataOutputStream:close	()V
    //   1808: aload 19
    //   1810: astore 22
    //   1812: aload 19
    //   1814: astore 21
    //   1816: aload 23
    //   1818: athrow
    //   1819: astore 19
    //   1821: aload 22
    //   1823: astore 21
    //   1825: ldc 89
    //   1827: iconst_1
    //   1828: ldc_w 354
    //   1831: aload 19
    //   1833: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1836: aload 22
    //   1838: astore 21
    //   1840: aload_0
    //   1841: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1844: aload_0
    //   1845: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1848: iconst_3
    //   1849: bipush 102
    //   1851: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1854: aload 22
    //   1856: astore 21
    //   1858: getstatic 192	bcps:b	I
    //   1861: getstatic 357	bcps:u	I
    //   1864: aload_0
    //   1865: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1868: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1871: invokestatic 257	bcpr:a	(IILjava/lang/String;)V
    //   1874: aload 22
    //   1876: ifnull -1853 -> 23
    //   1879: aload 22
    //   1881: invokevirtual 205	java/io/FileInputStream:close	()V
    //   1884: return
    //   1885: astore 19
    //   1887: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1890: ifeq -1867 -> 23
    //   1893: ldc 89
    //   1895: iconst_2
    //   1896: new 91	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1903: ldc 207
    //   1905: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: aload 19
    //   1910: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   1913: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1919: aload 19
    //   1921: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1924: return
    //   1925: aload 19
    //   1927: astore 22
    //   1929: aload 19
    //   1931: astore 21
    //   1933: ldc_w 359
    //   1936: iconst_3
    //   1937: anewarray 306	java/lang/Object
    //   1940: dup
    //   1941: iconst_0
    //   1942: aload_0
    //   1943: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1946: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1949: aastore
    //   1950: dup
    //   1951: iconst_1
    //   1952: lload 8
    //   1954: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1957: aastore
    //   1958: dup
    //   1959: iconst_2
    //   1960: iload_2
    //   1961: i2l
    //   1962: lload 8
    //   1964: ladd
    //   1965: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1968: aastore
    //   1969: invokestatic 326	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1972: astore 20
    //   1974: goto -424 -> 1550
    //   1977: aload 19
    //   1979: astore 22
    //   1981: aload 19
    //   1983: astore 21
    //   1985: aload 27
    //   1987: invokeinterface 365 1 0
    //   1992: invokeinterface 370 1 0
    //   1997: istore_3
    //   1998: iload_3
    //   1999: sipush 200
    //   2002: if_icmpeq +514 -> 2516
    //   2005: iload_3
    //   2006: sipush 206
    //   2009: if_icmpeq +507 -> 2516
    //   2012: aload 19
    //   2014: astore 22
    //   2016: aload 19
    //   2018: astore 21
    //   2020: aload 27
    //   2022: invokeinterface 374 1 0
    //   2027: astore 20
    //   2029: aload 20
    //   2031: ifnull +123 -> 2154
    //   2034: aload 19
    //   2036: astore 22
    //   2038: aload 19
    //   2040: astore 21
    //   2042: new 91	java/lang/StringBuilder
    //   2045: dup
    //   2046: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2049: astore 23
    //   2051: aload 19
    //   2053: astore 22
    //   2055: aload 19
    //   2057: astore 21
    //   2059: aload 20
    //   2061: arraylength
    //   2062: istore 5
    //   2064: iconst_0
    //   2065: istore_2
    //   2066: iload_2
    //   2067: iload 5
    //   2069: if_icmpge +65 -> 2134
    //   2072: aload 20
    //   2074: iload_2
    //   2075: aaload
    //   2076: astore 28
    //   2078: aload 19
    //   2080: astore 22
    //   2082: aload 19
    //   2084: astore 21
    //   2086: aload 23
    //   2088: ldc_w 376
    //   2091: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: aload 28
    //   2096: invokeinterface 381 1 0
    //   2101: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: ldc_w 383
    //   2107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: aload 28
    //   2112: invokeinterface 386 1 0
    //   2117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: ldc_w 388
    //   2123: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: pop
    //   2127: iload_2
    //   2128: iconst_1
    //   2129: iadd
    //   2130: istore_2
    //   2131: goto -65 -> 2066
    //   2134: aload 19
    //   2136: astore 22
    //   2138: aload 19
    //   2140: astore 21
    //   2142: aload_0
    //   2143: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2146: aload 23
    //   2148: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2151: putfield 391	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
    //   2154: aload 19
    //   2156: astore 22
    //   2158: aload 19
    //   2160: astore 21
    //   2162: aload 27
    //   2164: ldc_w 393
    //   2167: invokeinterface 397 2 0
    //   2172: astore 20
    //   2174: iload_3
    //   2175: istore_2
    //   2176: lload 8
    //   2178: lstore 10
    //   2180: aload 20
    //   2182: ifnull +1499 -> 3681
    //   2185: aload 19
    //   2187: astore 22
    //   2189: aload 19
    //   2191: astore 21
    //   2193: iload_3
    //   2194: istore_2
    //   2195: lload 8
    //   2197: lstore 10
    //   2199: aload 20
    //   2201: invokeinterface 386 1 0
    //   2206: ifnull +1475 -> 3681
    //   2209: aload 19
    //   2211: astore 22
    //   2213: aload 19
    //   2215: astore 21
    //   2217: aload 20
    //   2219: invokeinterface 386 1 0
    //   2224: ldc_w 399
    //   2227: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2230: ifeq +16 -> 2246
    //   2233: iconst_4
    //   2234: istore_1
    //   2235: sipush -6101
    //   2238: istore_2
    //   2239: aload 19
    //   2241: astore 21
    //   2243: goto -1401 -> 842
    //   2246: aload 19
    //   2248: astore 22
    //   2250: aload 19
    //   2252: astore 21
    //   2254: aload 20
    //   2256: invokeinterface 386 1 0
    //   2261: ldc_w 405
    //   2264: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2267: ifne +51 -> 2318
    //   2270: aload 19
    //   2272: astore 22
    //   2274: aload 19
    //   2276: astore 21
    //   2278: aload 20
    //   2280: invokeinterface 386 1 0
    //   2285: ldc_w 407
    //   2288: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2291: ifne +27 -> 2318
    //   2294: aload 19
    //   2296: astore 22
    //   2298: aload 19
    //   2300: astore 21
    //   2302: aload 20
    //   2304: invokeinterface 386 1 0
    //   2309: ldc_w 409
    //   2312: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2315: ifeq +111 -> 2426
    //   2318: aload 19
    //   2320: astore 22
    //   2322: aload 19
    //   2324: astore 21
    //   2326: aload_0
    //   2327: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2330: aload_0
    //   2331: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2334: iconst_3
    //   2335: sipush 206
    //   2338: invokevirtual 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2341: aload 19
    //   2343: astore 22
    //   2345: aload 19
    //   2347: astore 21
    //   2349: getstatic 254	bcps:d	I
    //   2352: aload 20
    //   2354: invokeinterface 386 1 0
    //   2359: invokestatic 412	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2362: invokevirtual 415	java/lang/Integer:intValue	()I
    //   2365: aload_0
    //   2366: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2369: getfield 252	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   2372: invokestatic 257	bcpr:a	(IILjava/lang/String;)V
    //   2375: aload 19
    //   2377: ifnull -2354 -> 23
    //   2380: aload 19
    //   2382: invokevirtual 205	java/io/FileInputStream:close	()V
    //   2385: return
    //   2386: astore 19
    //   2388: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2391: ifeq -2368 -> 23
    //   2394: ldc 89
    //   2396: iconst_2
    //   2397: new 91	java/lang/StringBuilder
    //   2400: dup
    //   2401: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2404: ldc 207
    //   2406: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: aload 19
    //   2411: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   2414: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2420: aload 19
    //   2422: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2425: return
    //   2426: aload 19
    //   2428: astore 22
    //   2430: aload 19
    //   2432: astore 21
    //   2434: aload 20
    //   2436: invokeinterface 386 1 0
    //   2441: astore 20
    //   2443: iload_3
    //   2444: istore_2
    //   2445: aload 20
    //   2447: ifnull +38 -> 2485
    //   2450: aload 19
    //   2452: astore 22
    //   2454: iload_3
    //   2455: istore_2
    //   2456: aload 19
    //   2458: astore 21
    //   2460: aload 20
    //   2462: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2465: ifne +20 -> 2485
    //   2468: aload 19
    //   2470: astore 22
    //   2472: aload 19
    //   2474: astore 21
    //   2476: aload 20
    //   2478: invokestatic 412	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2481: invokevirtual 415	java/lang/Integer:intValue	()I
    //   2484: istore_2
    //   2485: sipush 16384
    //   2488: istore 5
    //   2490: iload_2
    //   2491: istore_3
    //   2492: iload 5
    //   2494: istore_2
    //   2495: goto -2349 -> 146
    //   2498: astore 20
    //   2500: sipush 16384
    //   2503: istore_2
    //   2504: goto -2358 -> 146
    //   2507: astore 20
    //   2509: sipush 16384
    //   2512: istore_2
    //   2513: goto -2367 -> 146
    //   2516: aload 19
    //   2518: astore 22
    //   2520: aload 19
    //   2522: astore 21
    //   2524: aload_0
    //   2525: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2528: iconst_0
    //   2529: aload 23
    //   2531: arraylength
    //   2532: i2l
    //   2533: invokestatic 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   2536: new 426	java/io/DataInputStream
    //   2539: dup
    //   2540: aload 27
    //   2542: invokeinterface 430 1 0
    //   2547: invokeinterface 436 1 0
    //   2552: invokespecial 439	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   2555: astore 20
    //   2557: aload 20
    //   2559: astore 21
    //   2561: lload 8
    //   2563: lstore 10
    //   2565: lload 8
    //   2567: lstore 12
    //   2569: aload 20
    //   2571: ldc2_w 440
    //   2574: invokevirtual 442	java/io/DataInputStream:skip	(J)J
    //   2577: pop2
    //   2578: aload 20
    //   2580: astore 21
    //   2582: lload 8
    //   2584: lstore 10
    //   2586: lload 8
    //   2588: lstore 12
    //   2590: aload 20
    //   2592: invokevirtual 446	java/io/DataInputStream:readByte	()B
    //   2595: istore_2
    //   2596: iload_2
    //   2597: ifeq +87 -> 2684
    //   2600: iconst_0
    //   2601: istore 4
    //   2603: iload_3
    //   2604: istore_2
    //   2605: iload 4
    //   2607: istore_1
    //   2608: aload 19
    //   2610: astore 21
    //   2612: aload 20
    //   2614: ifnull -1772 -> 842
    //   2617: aload 19
    //   2619: astore 22
    //   2621: aload 19
    //   2623: astore 21
    //   2625: aload 20
    //   2627: invokevirtual 447	java/io/DataInputStream:close	()V
    //   2630: iload_3
    //   2631: istore_2
    //   2632: iload 4
    //   2634: istore_1
    //   2635: aload 19
    //   2637: astore 21
    //   2639: goto -1797 -> 842
    //   2642: astore 20
    //   2644: aload 19
    //   2646: astore 22
    //   2648: aload 19
    //   2650: astore 21
    //   2652: aload 20
    //   2654: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   2657: iload_3
    //   2658: istore_2
    //   2659: iload 4
    //   2661: istore_1
    //   2662: aload 19
    //   2664: astore 21
    //   2666: goto -1824 -> 842
    //   2669: astore 19
    //   2671: aload 21
    //   2673: ifnull +8 -> 2681
    //   2676: aload 21
    //   2678: invokevirtual 205	java/io/FileInputStream:close	()V
    //   2681: aload 19
    //   2683: athrow
    //   2684: aload 20
    //   2686: astore 21
    //   2688: lload 8
    //   2690: lstore 10
    //   2692: lload 8
    //   2694: lstore 12
    //   2696: aload 20
    //   2698: invokevirtual 450	java/io/DataInputStream:readInt	()I
    //   2701: i2l
    //   2702: lstore 14
    //   2704: aload 20
    //   2706: astore 21
    //   2708: lload 8
    //   2710: lstore 10
    //   2712: lload 8
    //   2714: lstore 12
    //   2716: aload 20
    //   2718: invokevirtual 450	java/io/DataInputStream:readInt	()I
    //   2721: i2l
    //   2722: lstore 16
    //   2724: aload 20
    //   2726: astore 21
    //   2728: lload 8
    //   2730: lstore 10
    //   2732: lload 8
    //   2734: lstore 12
    //   2736: aload 27
    //   2738: invokeinterface 430 1 0
    //   2743: invokeinterface 453 1 0
    //   2748: lload 16
    //   2750: bipush 32
    //   2752: lshl
    //   2753: lload 14
    //   2755: lor
    //   2756: lstore 8
    //   2758: aload 20
    //   2760: astore 21
    //   2762: lload 8
    //   2764: lstore 10
    //   2766: lload 8
    //   2768: lstore 12
    //   2770: aload_0
    //   2771: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2774: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2777: lload 8
    //   2779: lcmp
    //   2780: ifgt +73 -> 2853
    //   2783: aload 20
    //   2785: astore 21
    //   2787: lload 8
    //   2789: lstore 10
    //   2791: lload 8
    //   2793: lstore 12
    //   2795: aload_0
    //   2796: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2799: lload 8
    //   2801: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2804: aload 20
    //   2806: astore 21
    //   2808: lload 8
    //   2810: lstore 10
    //   2812: lload 8
    //   2814: lstore 12
    //   2816: aload_0
    //   2817: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2820: aload_0
    //   2821: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2824: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2827: putfield 456	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   2830: aload 20
    //   2832: astore 21
    //   2834: lload 8
    //   2836: lstore 10
    //   2838: lload 8
    //   2840: lstore 12
    //   2842: aload_0
    //   2843: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2846: aload_0
    //   2847: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2850: invokevirtual 459	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   2853: lload 8
    //   2855: lload 6
    //   2857: lcmp
    //   2858: ifeq +71 -> 2929
    //   2861: aload 20
    //   2863: astore 21
    //   2865: lload 8
    //   2867: lstore 10
    //   2869: lload 8
    //   2871: lstore 12
    //   2873: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2876: ifeq +53 -> 2929
    //   2879: aload 20
    //   2881: astore 21
    //   2883: lload 8
    //   2885: lstore 10
    //   2887: lload 8
    //   2889: lstore 12
    //   2891: ldc 89
    //   2893: iconst_2
    //   2894: new 91	java/lang/StringBuilder
    //   2897: dup
    //   2898: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2901: ldc_w 461
    //   2904: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: lload 8
    //   2909: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2912: ldc_w 466
    //   2915: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2918: lload 6
    //   2920: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2923: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2926: invokestatic 468	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2929: aload 20
    //   2931: ifnull +16 -> 2947
    //   2934: aload 19
    //   2936: astore 22
    //   2938: aload 19
    //   2940: astore 21
    //   2942: aload 20
    //   2944: invokevirtual 447	java/io/DataInputStream:close	()V
    //   2947: sipush 16384
    //   2950: istore_2
    //   2951: iconst_0
    //   2952: istore_1
    //   2953: goto -2807 -> 146
    //   2956: astore 20
    //   2958: aload 19
    //   2960: astore 22
    //   2962: aload 19
    //   2964: astore 21
    //   2966: aload 20
    //   2968: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   2971: goto -24 -> 2947
    //   2974: astore 21
    //   2976: aconst_null
    //   2977: astore 20
    //   2979: ldc 89
    //   2981: iconst_1
    //   2982: ldc_w 470
    //   2985: aload 21
    //   2987: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2990: getstatic 344	bcps:z	I
    //   2993: istore_3
    //   2994: aload 20
    //   2996: ifnull +702 -> 3698
    //   2999: aload 19
    //   3001: astore 22
    //   3003: aload 19
    //   3005: astore 21
    //   3007: aload 20
    //   3009: invokevirtual 447	java/io/DataInputStream:close	()V
    //   3012: sipush 16384
    //   3015: istore_2
    //   3016: goto -2870 -> 146
    //   3019: astore 20
    //   3021: aload 19
    //   3023: astore 22
    //   3025: aload 19
    //   3027: astore 21
    //   3029: aload 20
    //   3031: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   3034: sipush 16384
    //   3037: istore_2
    //   3038: goto -2892 -> 146
    //   3041: astore 22
    //   3043: aconst_null
    //   3044: astore 20
    //   3046: aload 20
    //   3048: astore 21
    //   3050: ldc 89
    //   3052: iconst_1
    //   3053: ldc_w 472
    //   3056: aload 22
    //   3058: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3061: aload 20
    //   3063: astore 21
    //   3065: getstatic 344	bcps:z	I
    //   3068: istore_3
    //   3069: iload_3
    //   3070: istore_2
    //   3071: lload 8
    //   3073: lstore 10
    //   3075: aload 20
    //   3077: ifnull +604 -> 3681
    //   3080: aload 19
    //   3082: astore 22
    //   3084: aload 19
    //   3086: astore 21
    //   3088: aload 20
    //   3090: invokevirtual 447	java/io/DataInputStream:close	()V
    //   3093: sipush 16384
    //   3096: istore_2
    //   3097: goto -2951 -> 146
    //   3100: astore 20
    //   3102: aload 19
    //   3104: astore 22
    //   3106: aload 19
    //   3108: astore 21
    //   3110: aload 20
    //   3112: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   3115: sipush 16384
    //   3118: istore_2
    //   3119: goto -2973 -> 146
    //   3122: astore 20
    //   3124: aconst_null
    //   3125: astore 23
    //   3127: aload 23
    //   3129: ifnull +16 -> 3145
    //   3132: aload 19
    //   3134: astore 22
    //   3136: aload 19
    //   3138: astore 21
    //   3140: aload 23
    //   3142: invokevirtual 447	java/io/DataInputStream:close	()V
    //   3145: aload 19
    //   3147: astore 22
    //   3149: aload 19
    //   3151: astore 21
    //   3153: aload 20
    //   3155: athrow
    //   3156: astore 23
    //   3158: aload 19
    //   3160: astore 22
    //   3162: aload 19
    //   3164: astore 21
    //   3166: aload 23
    //   3168: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   3171: goto -26 -> 3145
    //   3174: astore 19
    //   3176: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3179: ifeq -2327 -> 852
    //   3182: ldc 89
    //   3184: iconst_2
    //   3185: new 91	java/lang/StringBuilder
    //   3188: dup
    //   3189: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3192: ldc 207
    //   3194: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3197: aload 19
    //   3199: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   3202: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3208: aload 19
    //   3210: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3213: goto -2361 -> 852
    //   3216: astore 20
    //   3218: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3221: ifeq -540 -> 2681
    //   3224: ldc 89
    //   3226: iconst_2
    //   3227: new 91	java/lang/StringBuilder
    //   3230: dup
    //   3231: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3234: ldc 207
    //   3236: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: aload 20
    //   3241: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   3244: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3247: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3250: aload 20
    //   3252: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3255: goto -574 -> 2681
    //   3258: aload_0
    //   3259: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3262: aload_0
    //   3263: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3266: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   3269: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   3272: aload_0
    //   3273: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3276: aload_0
    //   3277: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3280: bipush 6
    //   3282: invokevirtual 475	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   3285: aload_0
    //   3286: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3289: aload_0
    //   3290: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3293: invokevirtual 478	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   3296: aload_0
    //   3297: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3300: getfield 481	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   3303: invokestatic 486	bdhe:a	([B)Ljava/lang/String;
    //   3306: astore 19
    //   3308: aload_0
    //   3309: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3312: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   3315: invokestatic 486	bdhe:a	([B)Ljava/lang/String;
    //   3318: astore 20
    //   3320: aload_0
    //   3321: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3324: aload_0
    //   3325: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3328: aload_0
    //   3329: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3332: getfield 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3335: invokevirtual 492	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbtn;
    //   3338: iconst_1
    //   3339: aload 19
    //   3341: aload 20
    //   3343: aload_0
    //   3344: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3347: getfield 495	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   3350: invokevirtual 498	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lbbtn;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3353: aload_0
    //   3354: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3357: aconst_null
    //   3358: putfield 481	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   3361: aload_0
    //   3362: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3365: aconst_null
    //   3366: putfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   3369: aload_0
    //   3370: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3373: getfield 501	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3376: astore 19
    //   3378: new 91	java/lang/StringBuilder
    //   3381: dup
    //   3382: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3385: aload_0
    //   3386: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3389: getfield 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3392: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3395: ldc_w 503
    //   3398: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3404: astore 20
    //   3406: new 91	java/lang/StringBuilder
    //   3409: dup
    //   3410: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3413: astore 21
    //   3415: ldc_w 505
    //   3418: aload_0
    //   3419: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3422: getfield 508	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3425: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3428: ifeq +131 -> 3559
    //   3431: iconst_0
    //   3432: istore_1
    //   3433: aload 19
    //   3435: ldc_w 510
    //   3438: ldc_w 512
    //   3441: ldc_w 503
    //   3444: ldc_w 514
    //   3447: ldc_w 516
    //   3450: iconst_0
    //   3451: iconst_0
    //   3452: aload 20
    //   3454: aload 21
    //   3456: iload_1
    //   3457: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3460: ldc_w 503
    //   3463: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3466: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3469: ldc_w 503
    //   3472: ldc_w 503
    //   3475: invokestatic 524	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3478: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3481: ifeq +68 -> 3549
    //   3484: new 91	java/lang/StringBuilder
    //   3487: dup
    //   3488: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3491: ldc_w 526
    //   3494: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: aload_0
    //   3498: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3501: getfield 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   3504: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3507: ldc_w 528
    //   3510: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: astore 19
    //   3515: ldc_w 505
    //   3518: aload_0
    //   3519: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3522: getfield 508	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3525: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3528: ifeq +36 -> 3564
    //   3531: iconst_0
    //   3532: istore_1
    //   3533: ldc_w 530
    //   3536: iconst_2
    //   3537: aload 19
    //   3539: iload_1
    //   3540: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3543: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3546: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3549: getstatic 532	bcps:a	I
    //   3552: iconst_0
    //   3553: invokestatic 200	bcpr:a	(II)V
    //   3556: goto -2634 -> 922
    //   3559: iconst_1
    //   3560: istore_1
    //   3561: goto -128 -> 3433
    //   3564: iconst_1
    //   3565: istore_1
    //   3566: goto -33 -> 3533
    //   3569: astore 20
    //   3571: aload 19
    //   3573: astore 21
    //   3575: aload 20
    //   3577: astore 19
    //   3579: goto -908 -> 2671
    //   3582: astore 20
    //   3584: aload 19
    //   3586: astore 21
    //   3588: aload 20
    //   3590: astore 19
    //   3592: goto -921 -> 2671
    //   3595: astore 20
    //   3597: aload 19
    //   3599: astore 22
    //   3601: aload 20
    //   3603: astore 19
    //   3605: goto -1784 -> 1821
    //   3608: astore 20
    //   3610: aload 19
    //   3612: astore 22
    //   3614: aload 20
    //   3616: astore 19
    //   3618: goto -1797 -> 1821
    //   3621: astore 20
    //   3623: aload 21
    //   3625: astore 23
    //   3627: goto -500 -> 3127
    //   3630: astore 21
    //   3632: aload 20
    //   3634: astore 23
    //   3636: aload 21
    //   3638: astore 20
    //   3640: goto -513 -> 3127
    //   3643: astore 22
    //   3645: lload 10
    //   3647: lstore 8
    //   3649: goto -603 -> 3046
    //   3652: astore 21
    //   3654: lload 12
    //   3656: lstore 8
    //   3658: goto -679 -> 2979
    //   3661: astore 20
    //   3663: goto -1855 -> 1808
    //   3666: astore 20
    //   3668: goto -1939 -> 1729
    //   3671: astore 20
    //   3673: goto -2202 -> 1471
    //   3676: astore 20
    //   3678: goto -2577 -> 1101
    //   3681: sipush 16384
    //   3684: istore 5
    //   3686: iload_2
    //   3687: istore_3
    //   3688: lload 10
    //   3690: lstore 8
    //   3692: iload 5
    //   3694: istore_2
    //   3695: goto -3549 -> 146
    //   3698: sipush 16384
    //   3701: istore_2
    //   3702: goto -3556 -> 146
    //   3705: iload_3
    //   3706: istore_2
    //   3707: aload 19
    //   3709: astore 21
    //   3711: goto -2869 -> 842
    //   3714: lload 8
    //   3716: lstore 6
    //   3718: goto -2886 -> 832
    //   3721: aconst_null
    //   3722: astore 24
    //   3724: goto -3651 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3727	0	this	TaskHttpUpload
    //   145	3421	1	i	int
    //   139	3568	2	j	int
    //   135	3571	3	k	int
    //   74	2586	4	m	int
    //   295	3398	5	n	int
    //   142	3575	6	l1	long
    //   7	3708	8	l2	long
    //   2178	1511	10	l3	long
    //   2567	1088	12	l4	long
    //   2702	52	14	l5	long
    //   2722	27	16	l6	long
    //   269	266	18	bool	boolean
    //   132	85	19	localObject1	java.lang.Object
    //   222	130	19	localIOException1	IOException
    //   357	102	19	localIOException2	IOException
    //   464	81	19	localIOException3	IOException
    //   550	110	19	localIOException4	IOException
    //   665	54	19	localIOException5	IOException
    //   799	188	19	localObject2	java.lang.Object
    //   992	35	19	localIOException6	IOException
    //   1034	135	19	localObject3	java.lang.Object
    //   1174	561	19	localIOException7	IOException
    //   1740	73	19	localIOException8	IOException
    //   1819	13	19	localInterruptedException1	java.lang.InterruptedException
    //   1885	496	19	localIOException9	IOException
    //   2386	277	19	localIOException10	IOException
    //   2669	494	19	localObject4	java.lang.Object
    //   3174	35	19	localIOException11	IOException
    //   3306	402	19	localObject5	java.lang.Object
    //   707	91	20	localObject6	java.lang.Object
    //   939	131	20	localFileNotFoundException	java.io.FileNotFoundException
    //   1095	40	20	localIOException12	IOException
    //   1268	1209	20	localObject7	java.lang.Object
    //   2498	1	20	localNumberFormatException	java.lang.NumberFormatException
    //   2507	1	20	localException1	Exception
    //   2555	71	20	localDataInputStream	java.io.DataInputStream
    //   2642	301	20	localIOException13	IOException
    //   2956	11	20	localIOException14	IOException
    //   2977	31	20	localObject8	java.lang.Object
    //   3019	11	20	localIOException15	IOException
    //   3044	45	20	localObject9	java.lang.Object
    //   3100	11	20	localIOException16	IOException
    //   3122	32	20	localObject10	java.lang.Object
    //   3216	35	20	localIOException17	IOException
    //   3318	135	20	str	String
    //   3569	7	20	localObject11	java.lang.Object
    //   3582	7	20	localObject12	java.lang.Object
    //   3595	7	20	localInterruptedException2	java.lang.InterruptedException
    //   3608	7	20	localInterruptedException3	java.lang.InterruptedException
    //   3621	12	20	localObject13	java.lang.Object
    //   3638	1	20	localObject14	java.lang.Object
    //   3661	1	20	localException2	Exception
    //   3666	1	20	localException3	Exception
    //   3671	1	20	localException4	Exception
    //   3676	1	20	localIOException18	IOException
    //   161	1494	21	localObject15	java.lang.Object
    //   1667	9	21	localIOException19	IOException
    //   1709	1256	21	localObject16	java.lang.Object
    //   2974	12	21	localIllegalStateException1	java.lang.IllegalStateException
    //   3005	619	21	localObject17	java.lang.Object
    //   3630	7	21	localObject18	java.lang.Object
    //   3652	1	21	localIllegalStateException2	java.lang.IllegalStateException
    //   3709	1	21	localObject19	java.lang.Object
    //   157	2867	22	localObject20	java.lang.Object
    //   3041	16	22	localIOException20	IOException
    //   3082	531	22	localObject21	java.lang.Object
    //   3643	1	22	localIOException21	IOException
    //   776	823	23	localObject22	java.lang.Object
    //   1780	37	23	localObject23	java.lang.Object
    //   2049	1092	23	localStringBuilder	java.lang.StringBuilder
    //   3156	11	23	localIOException22	IOException
    //   3625	10	23	localObject24	java.lang.Object
    //   71	3652	24	localList	java.util.List
    //   126	1469	25	localHttpClient	HttpClient
    //   38	1040	26	localFile	java.io.File
    //   764	1973	27	localObject25	java.lang.Object
    //   1287	824	28	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   216	221	222	java/io/IOException
    //   351	356	357	java/io/IOException
    //   458	463	464	java/io/IOException
    //   544	549	550	java/io/IOException
    //   659	664	665	java/io/IOException
    //   722	733	939	java/io/FileNotFoundException
    //   986	991	992	java/io/IOException
    //   786	797	1095	java/io/IOException
    //   813	821	1095	java/io/IOException
    //   1056	1061	1095	java/io/IOException
    //   1073	1084	1095	java/io/IOException
    //   1168	1173	1174	java/io/IOException
    //   1289	1445	1667	java/io/IOException
    //   1734	1739	1740	java/io/IOException
    //   1289	1445	1780	finally
    //   1669	1703	1780	finally
    //   163	172	1819	java/lang/InterruptedException
    //   180	194	1819	java/lang/InterruptedException
    //   202	211	1819	java/lang/InterruptedException
    //   314	320	1819	java/lang/InterruptedException
    //   328	341	1819	java/lang/InterruptedException
    //   405	414	1819	java/lang/InterruptedException
    //   422	436	1819	java/lang/InterruptedException
    //   444	453	1819	java/lang/InterruptedException
    //   521	534	1819	java/lang/InterruptedException
    //   598	614	1819	java/lang/InterruptedException
    //   622	637	1819	java/lang/InterruptedException
    //   645	654	1819	java/lang/InterruptedException
    //   722	733	1819	java/lang/InterruptedException
    //   745	753	1819	java/lang/InterruptedException
    //   761	766	1819	java/lang/InterruptedException
    //   786	797	1819	java/lang/InterruptedException
    //   813	821	1819	java/lang/InterruptedException
    //   949	964	1819	java/lang/InterruptedException
    //   972	981	1819	java/lang/InterruptedException
    //   1056	1061	1819	java/lang/InterruptedException
    //   1073	1084	1819	java/lang/InterruptedException
    //   1222	1249	1819	java/lang/InterruptedException
    //   1257	1270	1819	java/lang/InterruptedException
    //   1278	1289	1819	java/lang/InterruptedException
    //   1453	1458	1819	java/lang/InterruptedException
    //   1466	1471	1819	java/lang/InterruptedException
    //   1484	1550	1819	java/lang/InterruptedException
    //   1558	1568	1819	java/lang/InterruptedException
    //   1576	1585	1819	java/lang/InterruptedException
    //   1593	1605	1819	java/lang/InterruptedException
    //   1618	1624	1819	java/lang/InterruptedException
    //   1632	1648	1819	java/lang/InterruptedException
    //   1656	1660	1819	java/lang/InterruptedException
    //   1711	1716	1819	java/lang/InterruptedException
    //   1724	1729	1819	java/lang/InterruptedException
    //   1790	1795	1819	java/lang/InterruptedException
    //   1803	1808	1819	java/lang/InterruptedException
    //   1816	1819	1819	java/lang/InterruptedException
    //   1933	1974	1819	java/lang/InterruptedException
    //   1985	1998	1819	java/lang/InterruptedException
    //   2020	2029	1819	java/lang/InterruptedException
    //   2042	2051	1819	java/lang/InterruptedException
    //   2059	2064	1819	java/lang/InterruptedException
    //   2086	2127	1819	java/lang/InterruptedException
    //   2142	2154	1819	java/lang/InterruptedException
    //   2162	2174	1819	java/lang/InterruptedException
    //   2199	2209	1819	java/lang/InterruptedException
    //   2217	2233	1819	java/lang/InterruptedException
    //   2254	2270	1819	java/lang/InterruptedException
    //   2278	2294	1819	java/lang/InterruptedException
    //   2302	2318	1819	java/lang/InterruptedException
    //   2326	2341	1819	java/lang/InterruptedException
    //   2349	2375	1819	java/lang/InterruptedException
    //   2434	2443	1819	java/lang/InterruptedException
    //   2460	2468	1819	java/lang/InterruptedException
    //   2476	2485	1819	java/lang/InterruptedException
    //   2524	2536	1819	java/lang/InterruptedException
    //   2625	2630	1819	java/lang/InterruptedException
    //   2652	2657	1819	java/lang/InterruptedException
    //   2942	2947	1819	java/lang/InterruptedException
    //   2966	2971	1819	java/lang/InterruptedException
    //   3007	3012	1819	java/lang/InterruptedException
    //   3029	3034	1819	java/lang/InterruptedException
    //   3088	3093	1819	java/lang/InterruptedException
    //   3110	3115	1819	java/lang/InterruptedException
    //   3140	3145	1819	java/lang/InterruptedException
    //   3153	3156	1819	java/lang/InterruptedException
    //   3166	3171	1819	java/lang/InterruptedException
    //   1879	1884	1885	java/io/IOException
    //   2380	2385	2386	java/io/IOException
    //   2434	2443	2498	java/lang/NumberFormatException
    //   2460	2468	2498	java/lang/NumberFormatException
    //   2476	2485	2498	java/lang/NumberFormatException
    //   2434	2443	2507	java/lang/Exception
    //   2460	2468	2507	java/lang/Exception
    //   2476	2485	2507	java/lang/Exception
    //   2625	2630	2642	java/io/IOException
    //   163	172	2669	finally
    //   180	194	2669	finally
    //   202	211	2669	finally
    //   314	320	2669	finally
    //   328	341	2669	finally
    //   405	414	2669	finally
    //   422	436	2669	finally
    //   444	453	2669	finally
    //   521	534	2669	finally
    //   598	614	2669	finally
    //   622	637	2669	finally
    //   645	654	2669	finally
    //   722	733	2669	finally
    //   745	753	2669	finally
    //   761	766	2669	finally
    //   786	797	2669	finally
    //   813	821	2669	finally
    //   949	964	2669	finally
    //   972	981	2669	finally
    //   1056	1061	2669	finally
    //   1073	1084	2669	finally
    //   1222	1249	2669	finally
    //   1257	1270	2669	finally
    //   1278	1289	2669	finally
    //   1453	1458	2669	finally
    //   1466	1471	2669	finally
    //   1484	1550	2669	finally
    //   1558	1568	2669	finally
    //   1576	1585	2669	finally
    //   1593	1605	2669	finally
    //   1618	1624	2669	finally
    //   1632	1648	2669	finally
    //   1656	1660	2669	finally
    //   1711	1716	2669	finally
    //   1724	1729	2669	finally
    //   1790	1795	2669	finally
    //   1803	1808	2669	finally
    //   1816	1819	2669	finally
    //   1825	1836	2669	finally
    //   1840	1854	2669	finally
    //   1858	1874	2669	finally
    //   1933	1974	2669	finally
    //   1985	1998	2669	finally
    //   2020	2029	2669	finally
    //   2042	2051	2669	finally
    //   2059	2064	2669	finally
    //   2086	2127	2669	finally
    //   2142	2154	2669	finally
    //   2162	2174	2669	finally
    //   2199	2209	2669	finally
    //   2217	2233	2669	finally
    //   2254	2270	2669	finally
    //   2278	2294	2669	finally
    //   2302	2318	2669	finally
    //   2326	2341	2669	finally
    //   2349	2375	2669	finally
    //   2434	2443	2669	finally
    //   2460	2468	2669	finally
    //   2476	2485	2669	finally
    //   2524	2536	2669	finally
    //   2625	2630	2669	finally
    //   2652	2657	2669	finally
    //   2942	2947	2669	finally
    //   2966	2971	2669	finally
    //   3007	3012	2669	finally
    //   3029	3034	2669	finally
    //   3088	3093	2669	finally
    //   3110	3115	2669	finally
    //   3140	3145	2669	finally
    //   3153	3156	2669	finally
    //   3166	3171	2669	finally
    //   2942	2947	2956	java/io/IOException
    //   2536	2557	2974	java/lang/IllegalStateException
    //   3007	3012	3019	java/io/IOException
    //   2536	2557	3041	java/io/IOException
    //   3088	3093	3100	java/io/IOException
    //   2536	2557	3122	finally
    //   3140	3145	3156	java/io/IOException
    //   847	852	3174	java/io/IOException
    //   2676	2681	3216	java/io/IOException
    //   1084	1092	3569	finally
    //   1101	1139	3582	finally
    //   1139	1163	3582	finally
    //   1084	1092	3595	java/lang/InterruptedException
    //   1101	1139	3608	java/lang/InterruptedException
    //   1139	1163	3608	java/lang/InterruptedException
    //   2569	2578	3621	finally
    //   2590	2596	3621	finally
    //   2696	2704	3621	finally
    //   2716	2724	3621	finally
    //   2736	2748	3621	finally
    //   2770	2783	3621	finally
    //   2795	2804	3621	finally
    //   2816	2830	3621	finally
    //   2842	2853	3621	finally
    //   2873	2879	3621	finally
    //   2891	2929	3621	finally
    //   3050	3061	3621	finally
    //   3065	3069	3621	finally
    //   2979	2994	3630	finally
    //   2569	2578	3643	java/io/IOException
    //   2590	2596	3643	java/io/IOException
    //   2696	2704	3643	java/io/IOException
    //   2716	2724	3643	java/io/IOException
    //   2736	2748	3643	java/io/IOException
    //   2770	2783	3643	java/io/IOException
    //   2795	2804	3643	java/io/IOException
    //   2816	2830	3643	java/io/IOException
    //   2842	2853	3643	java/io/IOException
    //   2873	2879	3643	java/io/IOException
    //   2891	2929	3643	java/io/IOException
    //   2569	2578	3652	java/lang/IllegalStateException
    //   2590	2596	3652	java/lang/IllegalStateException
    //   2696	2704	3652	java/lang/IllegalStateException
    //   2716	2724	3652	java/lang/IllegalStateException
    //   2736	2748	3652	java/lang/IllegalStateException
    //   2770	2783	3652	java/lang/IllegalStateException
    //   2795	2804	3652	java/lang/IllegalStateException
    //   2816	2830	3652	java/lang/IllegalStateException
    //   2842	2853	3652	java/lang/IllegalStateException
    //   2873	2879	3652	java/lang/IllegalStateException
    //   2891	2929	3652	java/lang/IllegalStateException
    //   1790	1795	3661	java/lang/Exception
    //   1803	1808	3661	java/lang/Exception
    //   1711	1716	3666	java/lang/Exception
    //   1724	1729	3666	java/lang/Exception
    //   1453	1458	3671	java/lang/Exception
    //   1466	1471	3671	java/lang/Exception
    //   1084	1092	3676	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */