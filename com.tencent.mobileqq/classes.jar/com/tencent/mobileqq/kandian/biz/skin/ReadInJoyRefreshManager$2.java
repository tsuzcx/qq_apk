package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.HashMap;

class ReadInJoyRefreshManager$2
  extends DownloadListener
{
  ReadInJoyRefreshManager$2(ReadInJoyRefreshManager paramReadInJoyRefreshManager, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("refreshId");
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoyRefreshManager.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refresh_");
    localStringBuilder.append(str);
    localHashMap.remove(localStringBuilder.toString());
    super.onCancel(paramDownloadTask);
  }
  
  /* Error */
  public void onDone(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 30	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   4: ldc 32
    //   6: invokevirtual 38	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_2
    //   10: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +37 -> 50
    //   16: new 45	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 75
    //   27: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: aload_1
    //   33: getfield 76	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   36: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 81
    //   42: iconst_2
    //   43: aload_3
    //   44: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: getfield 76	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   54: ifne +163 -> 217
    //   57: new 87	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 15	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 93	java/io/File:exists	()Z
    //   73: ifeq +181 -> 254
    //   76: aload_1
    //   77: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokestatic 100	com/tencent/mobileqq/kandian/biz/skin/RefreshRes:a	()Ljava/lang/String;
    //   83: iconst_0
    //   84: invokestatic 106	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   87: aload_0
    //   88: getfield 17	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_ComTencentMobileqqKandianBizSkinRefreshData	Lcom/tencent/mobileqq/kandian/biz/skin/RefreshData;
    //   91: iconst_1
    //   92: putfield 112	com/tencent/mobileqq/kandian/biz/skin/RefreshData:isShown	Z
    //   95: aload_0
    //   96: getfield 13	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoyRefreshManager	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   99: getfield 115	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   102: invokevirtual 121	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   105: invokevirtual 127	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   108: aload_0
    //   109: getfield 13	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoyRefreshManager	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   112: getfield 115	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   115: invokevirtual 130	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   118: aload_0
    //   119: getfield 17	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_ComTencentMobileqqKandianBizSkinRefreshData	Lcom/tencent/mobileqq/kandian/biz/skin/RefreshData;
    //   122: invokevirtual 134	com/tencent/mobileqq/kandian/biz/skin/RefreshData:toJson	()Lorg/json/JSONObject;
    //   125: invokevirtual 137	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 19	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_Int	I
    //   132: invokestatic 143	com/tencent/mobileqq/utils/SharedPreUtils:f	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   135: goto +67 -> 202
    //   138: astore_2
    //   139: goto +71 -> 210
    //   142: astore_3
    //   143: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +56 -> 202
    //   149: new 45	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   156: astore 4
    //   158: aload 4
    //   160: ldc 145
    //   162: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 4
    //   168: aload_2
    //   169: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: ldc 147
    //   177: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload_3
    //   184: invokestatic 151	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 81
    //   193: iconst_2
    //   194: aload 4
    //   196: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 154	java/io/File:delete	()Z
    //   206: pop
    //   207: goto +47 -> 254
    //   210: aload_1
    //   211: invokevirtual 154	java/io/File:delete	()Z
    //   214: pop
    //   215: aload_2
    //   216: athrow
    //   217: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +34 -> 254
    //   223: new 45	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   230: astore_1
    //   231: aload_1
    //   232: ldc 156
    //   234: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: aload_2
    //   240: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 81
    //   246: iconst_2
    //   247: aload_1
    //   248: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_0
    //   255: getfield 13	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoyRefreshManager	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   258: getfield 43	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   261: astore_1
    //   262: new 45	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: ldc 48
    //   273: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_3
    //   278: aload_2
    //   279: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_1
    //   284: aload_3
    //   285: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokevirtual 62	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	2
    //   0	293	1	paramDownloadTask	DownloadTask
    //   9	1	2	str1	String
    //   138	141	2	str2	String
    //   23	21	3	localStringBuilder1	StringBuilder
    //   142	42	3	localException	java.lang.Exception
    //   269	16	3	localStringBuilder2	StringBuilder
    //   156	39	4	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	135	138	finally
    //   143	202	138	finally
    //   76	135	142	java/lang/Exception
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.2
 * JD-Core Version:    0.7.0.1
 */