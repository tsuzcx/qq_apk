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
        if (NetworkUtil.h(BaseApplication.getContext()))
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
    //   10: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   13: aload_0
    //   14: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   17: invokevirtual 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   20: ifeq +4 -> 24
    //   23: return
    //   24: new 143	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: getfield 147	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   35: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 26
    //   40: aload_0
    //   41: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: iconst_0
    //   45: putfield 152	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   48: aload_0
    //   49: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   52: invokevirtual 155	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   55: ifnull +3392 -> 3447
    //   58: aload_0
    //   59: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   62: invokevirtual 155	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   65: iconst_5
    //   66: invokeinterface 161 2 0
    //   71: astore 24
    //   73: iconst_0
    //   74: istore 4
    //   76: aload 24
    //   78: ifnull +184 -> 262
    //   81: aload 24
    //   83: invokeinterface 167 1 0
    //   88: ifle +174 -> 262
    //   91: aload 24
    //   93: iconst_0
    //   94: invokeinterface 171 2 0
    //   99: ifnull +163 -> 262
    //   102: iconst_0
    //   103: aload 24
    //   105: iconst_0
    //   106: invokeinterface 171 2 0
    //   111: checkcast 173	mqq/manager/ProxyIpManager$ProxyIp
    //   114: getfield 176	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   117: sipush 10000
    //   120: sipush 20000
    //   123: invokestatic 181	com/dataline/util/HttpUtil:a	(ZIII)Lorg/apache/http/client/HttpClient;
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
    //   148: if_icmpgt +3289 -> 3437
    //   151: iload_1
    //   152: ifle +361 -> 513
    //   155: aload 19
    //   157: astore 22
    //   159: aload 19
    //   161: astore 21
    //   163: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokestatic 184	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   169: ifne +125 -> 294
    //   172: aload 19
    //   174: astore 22
    //   176: aload 19
    //   178: astore 21
    //   180: aload_0
    //   181: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   184: aload_0
    //   185: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   188: iconst_3
    //   189: bipush 106
    //   191: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   194: aload 19
    //   196: astore 22
    //   198: aload 19
    //   200: astore 21
    //   202: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   205: getstatic 194	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   208: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   211: aload 19
    //   213: ifnull -190 -> 23
    //   216: aload 19
    //   218: invokevirtual 204	java/io/FileInputStream:close	()V
    //   221: return
    //   222: astore 19
    //   224: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq -204 -> 23
    //   230: ldc 89
    //   232: iconst_2
    //   233: new 91	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   240: ldc 206
    //   242: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 19
    //   247: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   250: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload 19
    //   258: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: return
    //   262: invokestatic 214	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   265: ifnull +23 -> 288
    //   268: iconst_1
    //   269: istore 18
    //   271: iconst_0
    //   272: iload 18
    //   274: sipush 10000
    //   277: sipush 20000
    //   280: invokestatic 217	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
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
    //   314: ldc2_w 218
    //   317: invokestatic 225	java/lang/Thread:sleep	(J)V
    //   320: aload 19
    //   322: astore 22
    //   324: aload 19
    //   326: astore 21
    //   328: aload_0
    //   329: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   332: aload_0
    //   333: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   336: invokevirtual 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   339: istore 18
    //   341: iload 18
    //   343: ifeq +54 -> 397
    //   346: aload 19
    //   348: ifnull -325 -> 23
    //   351: aload 19
    //   353: invokevirtual 204	java/io/FileInputStream:close	()V
    //   356: return
    //   357: astore 19
    //   359: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -339 -> 23
    //   365: ldc 89
    //   367: iconst_2
    //   368: new 91	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   375: ldc 206
    //   377: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 19
    //   382: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   385: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: aload 19
    //   393: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   396: return
    //   397: aload 19
    //   399: astore 22
    //   401: aload 19
    //   403: astore 21
    //   405: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   408: invokestatic 184	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   411: ifne +93 -> 504
    //   414: aload 19
    //   416: astore 22
    //   418: aload 19
    //   420: astore 21
    //   422: aload_0
    //   423: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   426: aload_0
    //   427: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   430: iconst_3
    //   431: bipush 106
    //   433: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   436: aload 19
    //   438: astore 22
    //   440: aload 19
    //   442: astore 21
    //   444: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   447: getstatic 194	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   450: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   453: aload 19
    //   455: ifnull -432 -> 23
    //   458: aload 19
    //   460: invokevirtual 204	java/io/FileInputStream:close	()V
    //   463: return
    //   464: astore 19
    //   466: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -446 -> 23
    //   472: ldc 89
    //   474: iconst_2
    //   475: new 91	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   482: ldc 206
    //   484: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 19
    //   489: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   492: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: aload 19
    //   500: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   522: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   525: aload_0
    //   526: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   529: invokevirtual 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   532: istore 18
    //   534: iload 18
    //   536: ifeq +54 -> 590
    //   539: aload 19
    //   541: ifnull -518 -> 23
    //   544: aload 19
    //   546: invokevirtual 204	java/io/FileInputStream:close	()V
    //   549: return
    //   550: astore 19
    //   552: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq -532 -> 23
    //   558: ldc 89
    //   560: iconst_2
    //   561: new 91	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   568: ldc 206
    //   570: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 19
    //   575: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   578: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: aload 19
    //   586: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   589: return
    //   590: aload 19
    //   592: astore 22
    //   594: aload 19
    //   596: astore 21
    //   598: aload 26
    //   600: invokevirtual 229	java/io/File:length	()J
    //   603: aload_0
    //   604: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   607: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   610: lcmp
    //   611: ifeq +94 -> 705
    //   614: aload 19
    //   616: astore 22
    //   618: aload 19
    //   620: astore 21
    //   622: aload_0
    //   623: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   626: aload_0
    //   627: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   630: iconst_3
    //   631: sipush 206
    //   634: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   637: aload 19
    //   639: astore 22
    //   641: aload 19
    //   643: astore 21
    //   645: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   648: getstatic 235	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:s	I
    //   651: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   654: aload 19
    //   656: ifnull -633 -> 23
    //   659: aload 19
    //   661: invokevirtual 204	java/io/FileInputStream:close	()V
    //   664: return
    //   665: astore 19
    //   667: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq -647 -> 23
    //   673: ldc 89
    //   675: iconst_2
    //   676: new 91	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   683: ldc 206
    //   685: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload 19
    //   690: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   693: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: aload 19
    //   701: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   704: return
    //   705: aload 19
    //   707: astore 20
    //   709: aload 19
    //   711: ifnonnull +22 -> 733
    //   714: aload 19
    //   716: astore 22
    //   718: aload 19
    //   720: astore 21
    //   722: new 201	java/io/FileInputStream
    //   725: dup
    //   726: aload 26
    //   728: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   750: putfield 152	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
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
    //   771: ifle +255 -> 1026
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
    //   793: invokevirtual 242	java/io/FileInputStream:skip	(J)J
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
    //   817: invokevirtual 246	java/io/FileInputStream:read	([B)I
    //   820: istore_2
    //   821: iload_2
    //   822: ifle +2618 -> 3440
    //   825: iload_2
    //   826: i2l
    //   827: lload 8
    //   829: ladd
    //   830: lstore 6
    //   832: iload_2
    //   833: ifge +375 -> 1208
    //   836: aload 19
    //   838: ifnull +8 -> 846
    //   841: aload 19
    //   843: invokevirtual 204	java/io/FileInputStream:close	()V
    //   846: iload_1
    //   847: iconst_3
    //   848: if_icmple +2234 -> 3082
    //   851: aload_0
    //   852: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   855: aload_0
    //   856: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   859: iconst_3
    //   860: bipush 105
    //   862: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   865: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   868: ifeq +34 -> 902
    //   871: ldc 89
    //   873: iconst_2
    //   874: new 91	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   881: ldc 248
    //   883: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_0
    //   887: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   890: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   893: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: getstatic 253	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   905: iload_3
    //   906: aload_0
    //   907: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   910: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   913: invokestatic 256	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   916: aload_0
    //   917: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   920: aconst_null
    //   921: putfield 260	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   924: aload_0
    //   925: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   928: aconst_null
    //   929: putfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   932: return
    //   933: astore 20
    //   935: aload 19
    //   937: astore 22
    //   939: aload 19
    //   941: astore 21
    //   943: aload_0
    //   944: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   947: aload_0
    //   948: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   951: iconst_3
    //   952: sipush 201
    //   955: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   958: aload 19
    //   960: astore 22
    //   962: aload 19
    //   964: astore 21
    //   966: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   969: getstatic 262	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   972: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   975: aload 19
    //   977: ifnull -954 -> 23
    //   980: aload 19
    //   982: invokevirtual 204	java/io/FileInputStream:close	()V
    //   985: return
    //   986: astore 19
    //   988: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   991: ifeq -968 -> 23
    //   994: ldc 89
    //   996: iconst_2
    //   997: new 91	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1004: ldc 206
    //   1006: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload 19
    //   1011: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   1014: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: aload 19
    //   1022: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1025: return
    //   1026: aload 20
    //   1028: astore 19
    //   1030: lload 8
    //   1032: lload 6
    //   1034: lcmp
    //   1035: ifge -234 -> 801
    //   1038: aload 20
    //   1040: astore 23
    //   1042: aload 20
    //   1044: astore 22
    //   1046: aload 20
    //   1048: astore 21
    //   1050: aload 20
    //   1052: invokevirtual 204	java/io/FileInputStream:close	()V
    //   1055: aload 20
    //   1057: astore 23
    //   1059: aload 20
    //   1061: astore 22
    //   1063: aload 20
    //   1065: astore 21
    //   1067: new 201	java/io/FileInputStream
    //   1070: dup
    //   1071: aload 26
    //   1073: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1076: astore 19
    //   1078: aload 19
    //   1080: lload 8
    //   1082: invokevirtual 242	java/io/FileInputStream:skip	(J)J
    //   1085: pop2
    //   1086: goto -285 -> 801
    //   1089: astore 20
    //   1091: aload 23
    //   1093: astore 19
    //   1095: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1098: ifeq +35 -> 1133
    //   1101: ldc 89
    //   1103: iconst_2
    //   1104: new 91	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1111: ldc_w 264
    //   1114: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload 20
    //   1119: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   1122: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: aload 20
    //   1130: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1133: aload_0
    //   1134: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1137: aload_0
    //   1138: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1141: iconst_3
    //   1142: sipush 203
    //   1145: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1148: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1151: getstatic 267	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   1154: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   1157: aload 19
    //   1159: ifnull -1136 -> 23
    //   1162: aload 19
    //   1164: invokevirtual 204	java/io/FileInputStream:close	()V
    //   1167: return
    //   1168: astore 19
    //   1170: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1173: ifeq -1150 -> 23
    //   1176: ldc 89
    //   1178: iconst_2
    //   1179: new 91	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1186: ldc 206
    //   1188: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: aload 19
    //   1193: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   1196: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: aload 19
    //   1204: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1207: return
    //   1208: aload 19
    //   1210: astore 22
    //   1212: aload 19
    //   1214: astore 21
    //   1216: aload_0
    //   1217: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1220: getfield 260	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1223: arraylength
    //   1224: iconst_2
    //   1225: iadd
    //   1226: iconst_2
    //   1227: iadd
    //   1228: aload_0
    //   1229: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1232: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1235: arraylength
    //   1236: iadd
    //   1237: bipush 20
    //   1239: iadd
    //   1240: iload_2
    //   1241: iadd
    //   1242: istore_3
    //   1243: aload 19
    //   1245: astore 22
    //   1247: aload 19
    //   1249: astore 21
    //   1251: new 272	java/io/ByteArrayOutputStream
    //   1254: dup
    //   1255: iload_3
    //   1256: bipush 16
    //   1258: iadd
    //   1259: invokespecial 275	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1262: astore 20
    //   1264: aload 19
    //   1266: astore 22
    //   1268: aload 19
    //   1270: astore 21
    //   1272: new 277	java/io/DataOutputStream
    //   1275: dup
    //   1276: aload 20
    //   1278: invokespecial 280	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1281: astore 28
    //   1283: aload 28
    //   1285: ldc_w 281
    //   1288: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1291: aload 28
    //   1293: sipush 1007
    //   1296: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1299: aload 28
    //   1301: iconst_0
    //   1302: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1305: aload 28
    //   1307: iload_3
    //   1308: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1311: aload 28
    //   1313: aload_0
    //   1314: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1317: getfield 260	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1320: arraylength
    //   1321: invokevirtual 287	java/io/DataOutputStream:writeShort	(I)V
    //   1324: aload 28
    //   1326: aload_0
    //   1327: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1330: getfield 260	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   1333: invokevirtual 290	java/io/DataOutputStream:write	([B)V
    //   1336: aload 28
    //   1338: aload_0
    //   1339: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1342: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1345: arraylength
    //   1346: invokevirtual 287	java/io/DataOutputStream:writeShort	(I)V
    //   1349: aload 28
    //   1351: aload_0
    //   1352: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1355: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1358: invokevirtual 290	java/io/DataOutputStream:write	([B)V
    //   1361: aload 28
    //   1363: aload_0
    //   1364: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1367: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1370: ldc2_w 291
    //   1373: land
    //   1374: l2i
    //   1375: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1378: aload 28
    //   1380: ldc2_w 291
    //   1383: lload 8
    //   1385: land
    //   1386: l2i
    //   1387: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1390: aload 28
    //   1392: iload_2
    //   1393: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1396: aload 28
    //   1398: aload_0
    //   1399: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1402: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1405: bipush 32
    //   1407: lshr
    //   1408: l2i
    //   1409: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1412: aload 28
    //   1414: lload 8
    //   1416: bipush 32
    //   1418: lshr
    //   1419: l2i
    //   1420: invokevirtual 284	java/io/DataOutputStream:writeInt	(I)V
    //   1423: aload 28
    //   1425: aload 27
    //   1427: iconst_0
    //   1428: iload_2
    //   1429: invokevirtual 295	java/io/DataOutputStream:write	([BII)V
    //   1432: aload 20
    //   1434: invokevirtual 299	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1437: astore 23
    //   1439: aload 19
    //   1441: astore 22
    //   1443: aload 19
    //   1445: astore 21
    //   1447: aload 20
    //   1449: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   1452: aload 19
    //   1454: astore 22
    //   1456: aload 19
    //   1458: astore 21
    //   1460: aload 28
    //   1462: invokevirtual 301	java/io/DataOutputStream:close	()V
    //   1465: iload 4
    //   1467: ifeq +452 -> 1919
    //   1470: aload 19
    //   1472: astore 22
    //   1474: aload 19
    //   1476: astore 21
    //   1478: ldc_w 303
    //   1481: iconst_5
    //   1482: anewarray 305	java/lang/Object
    //   1485: dup
    //   1486: iconst_0
    //   1487: aload 24
    //   1489: iconst_0
    //   1490: invokeinterface 171 2 0
    //   1495: checkcast 173	mqq/manager/ProxyIpManager$ProxyIp
    //   1498: getfield 308	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1501: aastore
    //   1502: dup
    //   1503: iconst_1
    //   1504: lload 8
    //   1506: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1509: aastore
    //   1510: dup
    //   1511: iconst_2
    //   1512: iload_2
    //   1513: i2l
    //   1514: lload 8
    //   1516: ladd
    //   1517: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1520: aastore
    //   1521: dup
    //   1522: iconst_3
    //   1523: aload_0
    //   1524: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1527: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1530: aastore
    //   1531: dup
    //   1532: iconst_4
    //   1533: bipush 80
    //   1535: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1538: aastore
    //   1539: invokestatic 325	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1542: astore 20
    //   1544: aload 19
    //   1546: astore 22
    //   1548: aload 19
    //   1550: astore 21
    //   1552: aload_0
    //   1553: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1556: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   1559: putfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   1562: aload 19
    //   1564: astore 22
    //   1566: aload 19
    //   1568: astore 21
    //   1570: aload_0
    //   1571: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1574: aload 20
    //   1576: putfield 336	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   1579: aload 19
    //   1581: astore 22
    //   1583: aload 19
    //   1585: astore 21
    //   1587: aload_0
    //   1588: aload 25
    //   1590: aload 20
    //   1592: aload 23
    //   1594: invokespecial 338	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   1597: astore 20
    //   1599: aload 20
    //   1601: ifnonnull +370 -> 1971
    //   1604: aload 19
    //   1606: astore 22
    //   1608: aload 19
    //   1610: astore 21
    //   1612: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq +27 -> 1642
    //   1618: aload 19
    //   1620: astore 22
    //   1622: aload 19
    //   1624: astore 21
    //   1626: ldc 89
    //   1628: iconst_2
    //   1629: ldc_w 340
    //   1632: iconst_0
    //   1633: anewarray 305	java/lang/Object
    //   1636: invokestatic 325	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1639: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1642: aload 19
    //   1644: astore 22
    //   1646: aload 19
    //   1648: astore 21
    //   1650: getstatic 343	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:u	I
    //   1653: istore_3
    //   1654: sipush 16384
    //   1657: istore_2
    //   1658: goto -1512 -> 146
    //   1661: astore 21
    //   1663: ldc 89
    //   1665: iconst_1
    //   1666: ldc_w 345
    //   1669: aload 21
    //   1671: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1674: aload_0
    //   1675: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1678: aload_0
    //   1679: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1682: iconst_3
    //   1683: bipush 102
    //   1685: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1688: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1691: getstatic 351	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:l	I
    //   1694: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   1697: aload 19
    //   1699: astore 22
    //   1701: aload 19
    //   1703: astore 21
    //   1705: aload 20
    //   1707: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   1710: aload 19
    //   1712: astore 22
    //   1714: aload 19
    //   1716: astore 21
    //   1718: aload 28
    //   1720: invokevirtual 301	java/io/DataOutputStream:close	()V
    //   1723: aload 19
    //   1725: ifnull -1702 -> 23
    //   1728: aload 19
    //   1730: invokevirtual 204	java/io/FileInputStream:close	()V
    //   1733: return
    //   1734: astore 19
    //   1736: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1739: ifeq -1716 -> 23
    //   1742: ldc 89
    //   1744: iconst_2
    //   1745: new 91	java/lang/StringBuilder
    //   1748: dup
    //   1749: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1752: ldc 206
    //   1754: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: aload 19
    //   1759: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   1762: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: aload 19
    //   1770: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1773: return
    //   1774: astore 23
    //   1776: aload 19
    //   1778: astore 22
    //   1780: aload 19
    //   1782: astore 21
    //   1784: aload 20
    //   1786: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   1789: aload 19
    //   1791: astore 22
    //   1793: aload 19
    //   1795: astore 21
    //   1797: aload 28
    //   1799: invokevirtual 301	java/io/DataOutputStream:close	()V
    //   1802: aload 19
    //   1804: astore 22
    //   1806: aload 19
    //   1808: astore 21
    //   1810: aload 23
    //   1812: athrow
    //   1813: astore 19
    //   1815: aload 22
    //   1817: astore 21
    //   1819: ldc 89
    //   1821: iconst_1
    //   1822: ldc_w 353
    //   1825: aload 19
    //   1827: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1830: aload 22
    //   1832: astore 21
    //   1834: aload_0
    //   1835: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1838: aload_0
    //   1839: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1842: iconst_3
    //   1843: bipush 102
    //   1845: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1848: aload 22
    //   1850: astore 21
    //   1852: getstatic 191	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1855: getstatic 356	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:t	I
    //   1858: aload_0
    //   1859: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1862: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1865: invokestatic 256	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   1868: aload 22
    //   1870: ifnull -1847 -> 23
    //   1873: aload 22
    //   1875: invokevirtual 204	java/io/FileInputStream:close	()V
    //   1878: return
    //   1879: astore 19
    //   1881: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1884: ifeq -1861 -> 23
    //   1887: ldc 89
    //   1889: iconst_2
    //   1890: new 91	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1897: ldc 206
    //   1899: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: aload 19
    //   1904: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   1907: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1913: aload 19
    //   1915: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1918: return
    //   1919: aload 19
    //   1921: astore 22
    //   1923: aload 19
    //   1925: astore 21
    //   1927: ldc_w 358
    //   1930: iconst_3
    //   1931: anewarray 305	java/lang/Object
    //   1934: dup
    //   1935: iconst_0
    //   1936: aload_0
    //   1937: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1940: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   1943: aastore
    //   1944: dup
    //   1945: iconst_1
    //   1946: lload 8
    //   1948: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1951: aastore
    //   1952: dup
    //   1953: iconst_2
    //   1954: iload_2
    //   1955: i2l
    //   1956: lload 8
    //   1958: ladd
    //   1959: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1962: aastore
    //   1963: invokestatic 325	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1966: astore 20
    //   1968: goto -424 -> 1544
    //   1971: aload 19
    //   1973: astore 22
    //   1975: aload 19
    //   1977: astore 21
    //   1979: aload 20
    //   1981: invokeinterface 364 1 0
    //   1986: invokeinterface 369 1 0
    //   1991: istore_3
    //   1992: iload_3
    //   1993: sipush 200
    //   1996: if_icmpeq +498 -> 2494
    //   1999: iload_3
    //   2000: sipush 206
    //   2003: if_icmpeq +491 -> 2494
    //   2006: aload 19
    //   2008: astore 22
    //   2010: aload 19
    //   2012: astore 21
    //   2014: aload 20
    //   2016: invokeinterface 373 1 0
    //   2021: astore 23
    //   2023: aload 23
    //   2025: ifnull +123 -> 2148
    //   2028: aload 19
    //   2030: astore 22
    //   2032: aload 19
    //   2034: astore 21
    //   2036: new 91	java/lang/StringBuilder
    //   2039: dup
    //   2040: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2043: astore 27
    //   2045: aload 19
    //   2047: astore 22
    //   2049: aload 19
    //   2051: astore 21
    //   2053: aload 23
    //   2055: arraylength
    //   2056: istore 5
    //   2058: iconst_0
    //   2059: istore_2
    //   2060: iload_2
    //   2061: iload 5
    //   2063: if_icmpge +65 -> 2128
    //   2066: aload 23
    //   2068: iload_2
    //   2069: aaload
    //   2070: astore 28
    //   2072: aload 19
    //   2074: astore 22
    //   2076: aload 19
    //   2078: astore 21
    //   2080: aload 27
    //   2082: ldc_w 375
    //   2085: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: aload 28
    //   2090: invokeinterface 380 1 0
    //   2095: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: ldc_w 382
    //   2101: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: aload 28
    //   2106: invokeinterface 385 1 0
    //   2111: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: ldc_w 387
    //   2117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: pop
    //   2121: iload_2
    //   2122: iconst_1
    //   2123: iadd
    //   2124: istore_2
    //   2125: goto -65 -> 2060
    //   2128: aload 19
    //   2130: astore 22
    //   2132: aload 19
    //   2134: astore 21
    //   2136: aload_0
    //   2137: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2140: aload 27
    //   2142: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2145: putfield 390	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
    //   2148: aload 19
    //   2150: astore 22
    //   2152: aload 19
    //   2154: astore 21
    //   2156: aload 20
    //   2158: ldc_w 392
    //   2161: invokeinterface 396 2 0
    //   2166: astore 20
    //   2168: aload 20
    //   2170: ifnull +1260 -> 3430
    //   2173: aload 19
    //   2175: astore 22
    //   2177: aload 19
    //   2179: astore 21
    //   2181: aload 20
    //   2183: invokeinterface 385 1 0
    //   2188: ifnull +1242 -> 3430
    //   2191: aload 19
    //   2193: astore 22
    //   2195: aload 19
    //   2197: astore 21
    //   2199: aload 20
    //   2201: invokeinterface 385 1 0
    //   2206: ldc_w 398
    //   2209: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2212: ifeq +12 -> 2224
    //   2215: iconst_4
    //   2216: istore_1
    //   2217: sipush -6101
    //   2220: istore_3
    //   2221: goto -1385 -> 836
    //   2224: aload 19
    //   2226: astore 22
    //   2228: aload 19
    //   2230: astore 21
    //   2232: aload 20
    //   2234: invokeinterface 385 1 0
    //   2239: ldc_w 404
    //   2242: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2245: ifne +51 -> 2296
    //   2248: aload 19
    //   2250: astore 22
    //   2252: aload 19
    //   2254: astore 21
    //   2256: aload 20
    //   2258: invokeinterface 385 1 0
    //   2263: ldc_w 406
    //   2266: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2269: ifne +27 -> 2296
    //   2272: aload 19
    //   2274: astore 22
    //   2276: aload 19
    //   2278: astore 21
    //   2280: aload 20
    //   2282: invokeinterface 385 1 0
    //   2287: ldc_w 408
    //   2290: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2293: ifeq +111 -> 2404
    //   2296: aload 19
    //   2298: astore 22
    //   2300: aload 19
    //   2302: astore 21
    //   2304: aload_0
    //   2305: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2308: aload_0
    //   2309: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2312: iconst_3
    //   2313: sipush 206
    //   2316: invokevirtual 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2319: aload 19
    //   2321: astore 22
    //   2323: aload 19
    //   2325: astore 21
    //   2327: getstatic 253	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   2330: aload 20
    //   2332: invokeinterface 385 1 0
    //   2337: invokestatic 411	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2340: invokevirtual 414	java/lang/Integer:intValue	()I
    //   2343: aload_0
    //   2344: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2347: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   2350: invokestatic 256	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(IILjava/lang/String;)V
    //   2353: aload 19
    //   2355: ifnull -2332 -> 23
    //   2358: aload 19
    //   2360: invokevirtual 204	java/io/FileInputStream:close	()V
    //   2363: return
    //   2364: astore 19
    //   2366: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2369: ifeq -2346 -> 23
    //   2372: ldc 89
    //   2374: iconst_2
    //   2375: new 91	java/lang/StringBuilder
    //   2378: dup
    //   2379: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2382: ldc 206
    //   2384: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: aload 19
    //   2389: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   2392: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2398: aload 19
    //   2400: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2403: return
    //   2404: aload 19
    //   2406: astore 22
    //   2408: aload 19
    //   2410: astore 21
    //   2412: aload 20
    //   2414: invokeinterface 385 1 0
    //   2419: astore 20
    //   2421: iload_3
    //   2422: istore_2
    //   2423: aload 20
    //   2425: ifnull +38 -> 2463
    //   2428: aload 19
    //   2430: astore 22
    //   2432: iload_3
    //   2433: istore_2
    //   2434: aload 19
    //   2436: astore 21
    //   2438: aload 20
    //   2440: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2443: ifne +20 -> 2463
    //   2446: aload 19
    //   2448: astore 22
    //   2450: aload 19
    //   2452: astore 21
    //   2454: aload 20
    //   2456: invokestatic 411	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2459: invokevirtual 414	java/lang/Integer:intValue	()I
    //   2462: istore_2
    //   2463: sipush 16384
    //   2466: istore 5
    //   2468: iload_2
    //   2469: istore_3
    //   2470: iload 5
    //   2472: istore_2
    //   2473: goto -2327 -> 146
    //   2476: astore 20
    //   2478: sipush 16384
    //   2481: istore_2
    //   2482: goto -2336 -> 146
    //   2485: astore 20
    //   2487: sipush 16384
    //   2490: istore_2
    //   2491: goto -2345 -> 146
    //   2494: aload 19
    //   2496: astore 22
    //   2498: aload 19
    //   2500: astore 21
    //   2502: aload_0
    //   2503: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2506: iconst_0
    //   2507: aload 23
    //   2509: arraylength
    //   2510: i2l
    //   2511: invokevirtual 423	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   2514: aload 19
    //   2516: astore 22
    //   2518: lload 8
    //   2520: lstore 10
    //   2522: lload 8
    //   2524: lstore 12
    //   2526: aload 19
    //   2528: astore 21
    //   2530: new 425	java/io/DataInputStream
    //   2533: dup
    //   2534: aload 20
    //   2536: invokeinterface 429 1 0
    //   2541: invokeinterface 435 1 0
    //   2546: invokespecial 438	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   2549: astore 23
    //   2551: aload 19
    //   2553: astore 22
    //   2555: lload 8
    //   2557: lstore 10
    //   2559: lload 8
    //   2561: lstore 12
    //   2563: aload 19
    //   2565: astore 21
    //   2567: aload 23
    //   2569: ldc2_w 439
    //   2572: invokevirtual 441	java/io/DataInputStream:skip	(J)J
    //   2575: pop2
    //   2576: aload 19
    //   2578: astore 22
    //   2580: lload 8
    //   2582: lstore 10
    //   2584: lload 8
    //   2586: lstore 12
    //   2588: aload 19
    //   2590: astore 21
    //   2592: aload 23
    //   2594: invokevirtual 445	java/io/DataInputStream:readByte	()B
    //   2597: ifeq +8 -> 2605
    //   2600: iconst_0
    //   2601: istore_1
    //   2602: goto -1766 -> 836
    //   2605: aload 19
    //   2607: astore 22
    //   2609: lload 8
    //   2611: lstore 10
    //   2613: lload 8
    //   2615: lstore 12
    //   2617: aload 19
    //   2619: astore 21
    //   2621: aload 23
    //   2623: invokevirtual 448	java/io/DataInputStream:readInt	()I
    //   2626: i2l
    //   2627: lstore 14
    //   2629: aload 19
    //   2631: astore 22
    //   2633: lload 8
    //   2635: lstore 10
    //   2637: lload 8
    //   2639: lstore 12
    //   2641: aload 19
    //   2643: astore 21
    //   2645: aload 23
    //   2647: invokevirtual 448	java/io/DataInputStream:readInt	()I
    //   2650: i2l
    //   2651: lstore 16
    //   2653: aload 19
    //   2655: astore 22
    //   2657: lload 8
    //   2659: lstore 10
    //   2661: lload 8
    //   2663: lstore 12
    //   2665: aload 19
    //   2667: astore 21
    //   2669: aload 20
    //   2671: invokeinterface 429 1 0
    //   2676: invokeinterface 451 1 0
    //   2681: lload 16
    //   2683: bipush 32
    //   2685: lshl
    //   2686: lload 14
    //   2688: lor
    //   2689: lstore 8
    //   2691: aload 19
    //   2693: astore 22
    //   2695: lload 8
    //   2697: lstore 10
    //   2699: lload 8
    //   2701: lstore 12
    //   2703: aload 19
    //   2705: astore 21
    //   2707: aload_0
    //   2708: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2711: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2714: lload 8
    //   2716: lcmp
    //   2717: ifgt +85 -> 2802
    //   2720: aload 19
    //   2722: astore 22
    //   2724: lload 8
    //   2726: lstore 10
    //   2728: lload 8
    //   2730: lstore 12
    //   2732: aload 19
    //   2734: astore 21
    //   2736: aload_0
    //   2737: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2740: lload 8
    //   2742: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2745: aload 19
    //   2747: astore 22
    //   2749: lload 8
    //   2751: lstore 10
    //   2753: lload 8
    //   2755: lstore 12
    //   2757: aload 19
    //   2759: astore 21
    //   2761: aload_0
    //   2762: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2765: aload_0
    //   2766: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2769: getfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   2772: putfield 454	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   2775: aload 19
    //   2777: astore 22
    //   2779: lload 8
    //   2781: lstore 10
    //   2783: lload 8
    //   2785: lstore 12
    //   2787: aload 19
    //   2789: astore 21
    //   2791: aload_0
    //   2792: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2795: aload_0
    //   2796: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2799: invokevirtual 457	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   2802: lload 8
    //   2804: lload 6
    //   2806: lcmp
    //   2807: ifeq +79 -> 2886
    //   2810: aload 19
    //   2812: astore 22
    //   2814: lload 8
    //   2816: lstore 10
    //   2818: lload 8
    //   2820: lstore 12
    //   2822: aload 19
    //   2824: astore 21
    //   2826: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2829: ifeq +57 -> 2886
    //   2832: aload 19
    //   2834: astore 22
    //   2836: lload 8
    //   2838: lstore 10
    //   2840: lload 8
    //   2842: lstore 12
    //   2844: aload 19
    //   2846: astore 21
    //   2848: ldc 89
    //   2850: iconst_2
    //   2851: new 91	java/lang/StringBuilder
    //   2854: dup
    //   2855: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2858: ldc_w 459
    //   2861: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: lload 8
    //   2866: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2869: ldc_w 464
    //   2872: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: lload 6
    //   2877: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokestatic 466	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2886: sipush 16384
    //   2889: istore_2
    //   2890: iconst_0
    //   2891: istore_1
    //   2892: goto -2746 -> 146
    //   2895: astore 20
    //   2897: aload 19
    //   2899: astore 22
    //   2901: aload 19
    //   2903: astore 21
    //   2905: ldc 89
    //   2907: iconst_1
    //   2908: ldc_w 468
    //   2911: aload 20
    //   2913: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2916: aload 19
    //   2918: astore 22
    //   2920: aload 19
    //   2922: astore 21
    //   2924: getstatic 343	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:u	I
    //   2927: istore_3
    //   2928: sipush 16384
    //   2931: istore_2
    //   2932: lload 10
    //   2934: lstore 8
    //   2936: goto -2790 -> 146
    //   2939: astore 20
    //   2941: aload 19
    //   2943: astore 22
    //   2945: aload 19
    //   2947: astore 21
    //   2949: ldc 89
    //   2951: iconst_1
    //   2952: ldc_w 470
    //   2955: aload 20
    //   2957: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2960: aload 19
    //   2962: astore 22
    //   2964: aload 19
    //   2966: astore 21
    //   2968: getstatic 343	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:u	I
    //   2971: istore_3
    //   2972: sipush 16384
    //   2975: istore_2
    //   2976: lload 12
    //   2978: lstore 8
    //   2980: goto -2834 -> 146
    //   2983: astore 19
    //   2985: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2988: ifeq -2142 -> 846
    //   2991: ldc 89
    //   2993: iconst_2
    //   2994: new 91	java/lang/StringBuilder
    //   2997: dup
    //   2998: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3001: ldc 206
    //   3003: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3006: aload 19
    //   3008: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   3011: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3014: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3017: aload 19
    //   3019: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3022: goto -2176 -> 846
    //   3025: astore 19
    //   3027: aload 21
    //   3029: ifnull +8 -> 3037
    //   3032: aload 21
    //   3034: invokevirtual 204	java/io/FileInputStream:close	()V
    //   3037: aload 19
    //   3039: athrow
    //   3040: astore 20
    //   3042: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3045: ifeq -8 -> 3037
    //   3048: ldc 89
    //   3050: iconst_2
    //   3051: new 91	java/lang/StringBuilder
    //   3054: dup
    //   3055: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3058: ldc 206
    //   3060: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: aload 20
    //   3065: invokevirtual 207	java/io/IOException:toString	()Ljava/lang/String;
    //   3068: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3074: aload 20
    //   3076: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3079: goto -42 -> 3037
    //   3082: aload_0
    //   3083: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3086: aload_0
    //   3087: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3090: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   3093: putfield 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   3096: aload_0
    //   3097: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3100: aload_0
    //   3101: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3104: bipush 6
    //   3106: invokevirtual 473	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   3109: aload_0
    //   3110: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3113: aload_0
    //   3114: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3117: invokevirtual 475	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   3120: aload_0
    //   3121: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3124: aconst_null
    //   3125: putfield 478	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   3128: aload_0
    //   3129: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3132: aconst_null
    //   3133: putfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   3136: aload_0
    //   3137: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3140: aload_0
    //   3141: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3144: aload_0
    //   3145: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3148: getfield 481	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   3151: invokevirtual 485	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   3154: iconst_1
    //   3155: invokevirtual 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   3158: aload_0
    //   3159: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3162: getfield 491	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3165: astore 19
    //   3167: new 91	java/lang/StringBuilder
    //   3170: dup
    //   3171: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3174: aload_0
    //   3175: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3178: getfield 481	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   3181: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3184: ldc_w 493
    //   3187: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3193: astore 20
    //   3195: new 91	java/lang/StringBuilder
    //   3198: dup
    //   3199: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3202: astore 21
    //   3204: ldc_w 495
    //   3207: aload_0
    //   3208: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3211: getfield 498	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3214: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3217: ifeq +131 -> 3348
    //   3220: iconst_0
    //   3221: istore_1
    //   3222: aload 19
    //   3224: ldc_w 500
    //   3227: ldc_w 502
    //   3230: ldc_w 493
    //   3233: ldc_w 504
    //   3236: ldc_w 506
    //   3239: iconst_0
    //   3240: iconst_0
    //   3241: aload 20
    //   3243: aload 21
    //   3245: iload_1
    //   3246: invokevirtual 509	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3249: ldc_w 493
    //   3252: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3255: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3258: ldc_w 493
    //   3261: ldc_w 493
    //   3264: invokestatic 514	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3267: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3270: ifeq +68 -> 3338
    //   3273: new 91	java/lang/StringBuilder
    //   3276: dup
    //   3277: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   3280: ldc_w 516
    //   3283: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3286: aload_0
    //   3287: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   3290: getfield 481	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   3293: invokevirtual 462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3296: ldc_w 518
    //   3299: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3302: astore 19
    //   3304: ldc_w 495
    //   3307: aload_0
    //   3308: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   3311: getfield 498	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   3314: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3317: ifeq +36 -> 3353
    //   3320: iconst_0
    //   3321: istore_1
    //   3322: ldc_w 520
    //   3325: iconst_2
    //   3326: aload 19
    //   3328: iload_1
    //   3329: invokevirtual 509	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3332: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3335: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3338: getstatic 522	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:a	I
    //   3341: iconst_0
    //   3342: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   3345: goto -2429 -> 916
    //   3348: iconst_1
    //   3349: istore_1
    //   3350: goto -128 -> 3222
    //   3353: iconst_1
    //   3354: istore_1
    //   3355: goto -33 -> 3322
    //   3358: astore 20
    //   3360: aload 19
    //   3362: astore 21
    //   3364: aload 20
    //   3366: astore 19
    //   3368: goto -341 -> 3027
    //   3371: astore 20
    //   3373: aload 19
    //   3375: astore 21
    //   3377: aload 20
    //   3379: astore 19
    //   3381: goto -354 -> 3027
    //   3384: astore 20
    //   3386: aload 19
    //   3388: astore 22
    //   3390: aload 20
    //   3392: astore 19
    //   3394: goto -1579 -> 1815
    //   3397: astore 20
    //   3399: aload 19
    //   3401: astore 22
    //   3403: aload 20
    //   3405: astore 19
    //   3407: goto -1592 -> 1815
    //   3410: astore 20
    //   3412: goto -1610 -> 1802
    //   3415: astore 20
    //   3417: goto -1694 -> 1723
    //   3420: astore 20
    //   3422: goto -1957 -> 1465
    //   3425: astore 20
    //   3427: goto -2332 -> 1095
    //   3430: sipush 16384
    //   3433: istore_2
    //   3434: goto -3288 -> 146
    //   3437: goto -2601 -> 836
    //   3440: lload 8
    //   3442: lstore 6
    //   3444: goto -2612 -> 832
    //   3447: aconst_null
    //   3448: astore 24
    //   3450: goto -3377 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3453	0	this	TaskHttpUpload
    //   145	3210	1	i	int
    //   139	3295	2	j	int
    //   135	2837	3	k	int
    //   74	1392	4	m	int
    //   295	2176	5	n	int
    //   142	3301	6	l1	long
    //   7	3434	8	l2	long
    //   2520	413	10	l3	long
    //   2524	453	12	l4	long
    //   2627	60	14	l5	long
    //   2651	31	16	l6	long
    //   269	266	18	bool	boolean
    //   132	85	19	localObject1	java.lang.Object
    //   222	130	19	localIOException1	IOException
    //   357	102	19	localIOException2	IOException
    //   464	81	19	localIOException3	IOException
    //   550	110	19	localIOException4	IOException
    //   665	54	19	localIOException5	IOException
    //   799	182	19	localObject2	java.lang.Object
    //   986	35	19	localIOException6	IOException
    //   1028	135	19	localObject3	java.lang.Object
    //   1168	561	19	localIOException7	IOException
    //   1734	73	19	localIOException8	IOException
    //   1813	13	19	localInterruptedException1	java.lang.InterruptedException
    //   1879	480	19	localIOException9	IOException
    //   2364	601	19	localIOException10	IOException
    //   2983	35	19	localIOException11	IOException
    //   3025	13	19	localObject4	java.lang.Object
    //   3165	241	19	localObject5	java.lang.Object
    //   707	91	20	localObject6	java.lang.Object
    //   933	131	20	localFileNotFoundException	java.io.FileNotFoundException
    //   1089	40	20	localIOException12	IOException
    //   1262	1193	20	localObject7	java.lang.Object
    //   2476	1	20	localNumberFormatException	java.lang.NumberFormatException
    //   2485	185	20	localException1	Exception
    //   2895	17	20	localIllegalStateException	java.lang.IllegalStateException
    //   2939	17	20	localIOException13	IOException
    //   3040	35	20	localIOException14	IOException
    //   3193	49	20	str	String
    //   3358	7	20	localObject8	java.lang.Object
    //   3371	7	20	localObject9	java.lang.Object
    //   3384	7	20	localInterruptedException2	java.lang.InterruptedException
    //   3397	7	20	localInterruptedException3	java.lang.InterruptedException
    //   3410	1	20	localException2	Exception
    //   3415	1	20	localException3	Exception
    //   3420	1	20	localException4	Exception
    //   3425	1	20	localIOException15	IOException
    //   161	1488	21	localObject10	java.lang.Object
    //   1661	9	21	localIOException16	IOException
    //   1703	1673	21	localObject11	java.lang.Object
    //   157	3245	22	localObject12	java.lang.Object
    //   776	817	23	localObject13	java.lang.Object
    //   1774	37	23	localObject14	java.lang.Object
    //   2021	625	23	localObject15	java.lang.Object
    //   71	3378	24	localList	java.util.List
    //   126	1463	25	localHttpClient	HttpClient
    //   38	1034	26	localFile	java.io.File
    //   764	1377	27	localObject16	java.lang.Object
    //   1281	824	28	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   216	221	222	java/io/IOException
    //   351	356	357	java/io/IOException
    //   458	463	464	java/io/IOException
    //   544	549	550	java/io/IOException
    //   659	664	665	java/io/IOException
    //   722	733	933	java/io/FileNotFoundException
    //   980	985	986	java/io/IOException
    //   786	797	1089	java/io/IOException
    //   813	821	1089	java/io/IOException
    //   1050	1055	1089	java/io/IOException
    //   1067	1078	1089	java/io/IOException
    //   1162	1167	1168	java/io/IOException
    //   1283	1439	1661	java/io/IOException
    //   1728	1733	1734	java/io/IOException
    //   1283	1439	1774	finally
    //   1663	1697	1774	finally
    //   163	172	1813	java/lang/InterruptedException
    //   180	194	1813	java/lang/InterruptedException
    //   202	211	1813	java/lang/InterruptedException
    //   314	320	1813	java/lang/InterruptedException
    //   328	341	1813	java/lang/InterruptedException
    //   405	414	1813	java/lang/InterruptedException
    //   422	436	1813	java/lang/InterruptedException
    //   444	453	1813	java/lang/InterruptedException
    //   521	534	1813	java/lang/InterruptedException
    //   598	614	1813	java/lang/InterruptedException
    //   622	637	1813	java/lang/InterruptedException
    //   645	654	1813	java/lang/InterruptedException
    //   722	733	1813	java/lang/InterruptedException
    //   745	753	1813	java/lang/InterruptedException
    //   761	766	1813	java/lang/InterruptedException
    //   786	797	1813	java/lang/InterruptedException
    //   813	821	1813	java/lang/InterruptedException
    //   943	958	1813	java/lang/InterruptedException
    //   966	975	1813	java/lang/InterruptedException
    //   1050	1055	1813	java/lang/InterruptedException
    //   1067	1078	1813	java/lang/InterruptedException
    //   1216	1243	1813	java/lang/InterruptedException
    //   1251	1264	1813	java/lang/InterruptedException
    //   1272	1283	1813	java/lang/InterruptedException
    //   1447	1452	1813	java/lang/InterruptedException
    //   1460	1465	1813	java/lang/InterruptedException
    //   1478	1544	1813	java/lang/InterruptedException
    //   1552	1562	1813	java/lang/InterruptedException
    //   1570	1579	1813	java/lang/InterruptedException
    //   1587	1599	1813	java/lang/InterruptedException
    //   1612	1618	1813	java/lang/InterruptedException
    //   1626	1642	1813	java/lang/InterruptedException
    //   1650	1654	1813	java/lang/InterruptedException
    //   1705	1710	1813	java/lang/InterruptedException
    //   1718	1723	1813	java/lang/InterruptedException
    //   1784	1789	1813	java/lang/InterruptedException
    //   1797	1802	1813	java/lang/InterruptedException
    //   1810	1813	1813	java/lang/InterruptedException
    //   1927	1968	1813	java/lang/InterruptedException
    //   1979	1992	1813	java/lang/InterruptedException
    //   2014	2023	1813	java/lang/InterruptedException
    //   2036	2045	1813	java/lang/InterruptedException
    //   2053	2058	1813	java/lang/InterruptedException
    //   2080	2121	1813	java/lang/InterruptedException
    //   2136	2148	1813	java/lang/InterruptedException
    //   2156	2168	1813	java/lang/InterruptedException
    //   2181	2191	1813	java/lang/InterruptedException
    //   2199	2215	1813	java/lang/InterruptedException
    //   2232	2248	1813	java/lang/InterruptedException
    //   2256	2272	1813	java/lang/InterruptedException
    //   2280	2296	1813	java/lang/InterruptedException
    //   2304	2319	1813	java/lang/InterruptedException
    //   2327	2353	1813	java/lang/InterruptedException
    //   2412	2421	1813	java/lang/InterruptedException
    //   2438	2446	1813	java/lang/InterruptedException
    //   2454	2463	1813	java/lang/InterruptedException
    //   2502	2514	1813	java/lang/InterruptedException
    //   2530	2551	1813	java/lang/InterruptedException
    //   2567	2576	1813	java/lang/InterruptedException
    //   2592	2600	1813	java/lang/InterruptedException
    //   2621	2629	1813	java/lang/InterruptedException
    //   2645	2653	1813	java/lang/InterruptedException
    //   2669	2681	1813	java/lang/InterruptedException
    //   2707	2720	1813	java/lang/InterruptedException
    //   2736	2745	1813	java/lang/InterruptedException
    //   2761	2775	1813	java/lang/InterruptedException
    //   2791	2802	1813	java/lang/InterruptedException
    //   2826	2832	1813	java/lang/InterruptedException
    //   2848	2886	1813	java/lang/InterruptedException
    //   2905	2916	1813	java/lang/InterruptedException
    //   2924	2928	1813	java/lang/InterruptedException
    //   2949	2960	1813	java/lang/InterruptedException
    //   2968	2972	1813	java/lang/InterruptedException
    //   1873	1878	1879	java/io/IOException
    //   2358	2363	2364	java/io/IOException
    //   2412	2421	2476	java/lang/NumberFormatException
    //   2438	2446	2476	java/lang/NumberFormatException
    //   2454	2463	2476	java/lang/NumberFormatException
    //   2412	2421	2485	java/lang/Exception
    //   2438	2446	2485	java/lang/Exception
    //   2454	2463	2485	java/lang/Exception
    //   2530	2551	2895	java/lang/IllegalStateException
    //   2567	2576	2895	java/lang/IllegalStateException
    //   2592	2600	2895	java/lang/IllegalStateException
    //   2621	2629	2895	java/lang/IllegalStateException
    //   2645	2653	2895	java/lang/IllegalStateException
    //   2669	2681	2895	java/lang/IllegalStateException
    //   2707	2720	2895	java/lang/IllegalStateException
    //   2736	2745	2895	java/lang/IllegalStateException
    //   2761	2775	2895	java/lang/IllegalStateException
    //   2791	2802	2895	java/lang/IllegalStateException
    //   2826	2832	2895	java/lang/IllegalStateException
    //   2848	2886	2895	java/lang/IllegalStateException
    //   2530	2551	2939	java/io/IOException
    //   2567	2576	2939	java/io/IOException
    //   2592	2600	2939	java/io/IOException
    //   2621	2629	2939	java/io/IOException
    //   2645	2653	2939	java/io/IOException
    //   2669	2681	2939	java/io/IOException
    //   2707	2720	2939	java/io/IOException
    //   2736	2745	2939	java/io/IOException
    //   2761	2775	2939	java/io/IOException
    //   2791	2802	2939	java/io/IOException
    //   2826	2832	2939	java/io/IOException
    //   2848	2886	2939	java/io/IOException
    //   841	846	2983	java/io/IOException
    //   163	172	3025	finally
    //   180	194	3025	finally
    //   202	211	3025	finally
    //   314	320	3025	finally
    //   328	341	3025	finally
    //   405	414	3025	finally
    //   422	436	3025	finally
    //   444	453	3025	finally
    //   521	534	3025	finally
    //   598	614	3025	finally
    //   622	637	3025	finally
    //   645	654	3025	finally
    //   722	733	3025	finally
    //   745	753	3025	finally
    //   761	766	3025	finally
    //   786	797	3025	finally
    //   813	821	3025	finally
    //   943	958	3025	finally
    //   966	975	3025	finally
    //   1050	1055	3025	finally
    //   1067	1078	3025	finally
    //   1216	1243	3025	finally
    //   1251	1264	3025	finally
    //   1272	1283	3025	finally
    //   1447	1452	3025	finally
    //   1460	1465	3025	finally
    //   1478	1544	3025	finally
    //   1552	1562	3025	finally
    //   1570	1579	3025	finally
    //   1587	1599	3025	finally
    //   1612	1618	3025	finally
    //   1626	1642	3025	finally
    //   1650	1654	3025	finally
    //   1705	1710	3025	finally
    //   1718	1723	3025	finally
    //   1784	1789	3025	finally
    //   1797	1802	3025	finally
    //   1810	1813	3025	finally
    //   1819	1830	3025	finally
    //   1834	1848	3025	finally
    //   1852	1868	3025	finally
    //   1927	1968	3025	finally
    //   1979	1992	3025	finally
    //   2014	2023	3025	finally
    //   2036	2045	3025	finally
    //   2053	2058	3025	finally
    //   2080	2121	3025	finally
    //   2136	2148	3025	finally
    //   2156	2168	3025	finally
    //   2181	2191	3025	finally
    //   2199	2215	3025	finally
    //   2232	2248	3025	finally
    //   2256	2272	3025	finally
    //   2280	2296	3025	finally
    //   2304	2319	3025	finally
    //   2327	2353	3025	finally
    //   2412	2421	3025	finally
    //   2438	2446	3025	finally
    //   2454	2463	3025	finally
    //   2502	2514	3025	finally
    //   2530	2551	3025	finally
    //   2567	2576	3025	finally
    //   2592	2600	3025	finally
    //   2621	2629	3025	finally
    //   2645	2653	3025	finally
    //   2669	2681	3025	finally
    //   2707	2720	3025	finally
    //   2736	2745	3025	finally
    //   2761	2775	3025	finally
    //   2791	2802	3025	finally
    //   2826	2832	3025	finally
    //   2848	2886	3025	finally
    //   2905	2916	3025	finally
    //   2924	2928	3025	finally
    //   2949	2960	3025	finally
    //   2968	2972	3025	finally
    //   3032	3037	3040	java/io/IOException
    //   1078	1086	3358	finally
    //   1095	1133	3371	finally
    //   1133	1157	3371	finally
    //   1078	1086	3384	java/lang/InterruptedException
    //   1095	1133	3397	java/lang/InterruptedException
    //   1133	1157	3397	java/lang/InterruptedException
    //   1784	1789	3410	java/lang/Exception
    //   1797	1802	3410	java/lang/Exception
    //   1705	1710	3415	java/lang/Exception
    //   1718	1723	3415	java/lang/Exception
    //   1447	1452	3420	java/lang/Exception
    //   1460	1465	3420	java/lang/Exception
    //   1078	1086	3425	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */