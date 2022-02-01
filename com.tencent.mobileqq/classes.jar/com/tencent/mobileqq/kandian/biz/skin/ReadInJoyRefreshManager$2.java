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
    String str = paramDownloadTask.b().getString("refreshId");
    HashMap localHashMap = this.d.c;
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
    //   1: invokevirtual 33	com/tencent/mobileqq/vip/DownloadTask:b	()Landroid/os/Bundle;
    //   4: ldc 35
    //   6: invokevirtual 41	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_2
    //   10: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +37 -> 50
    //   16: new 48	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 78
    //   27: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: aload_1
    //   33: getfield 79	com/tencent/mobileqq/vip/DownloadTask:c	I
    //   36: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 84
    //   42: iconst_2
    //   43: aload_3
    //   44: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: getfield 79	com/tencent/mobileqq/vip/DownloadTask:c	I
    //   54: ifne +163 -> 217
    //   57: new 89	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 18	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:a	Ljava/lang/String;
    //   65: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 95	java/io/File:exists	()Z
    //   73: ifeq +181 -> 254
    //   76: aload_1
    //   77: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokestatic 102	com/tencent/mobileqq/kandian/biz/skin/RefreshRes:a	()Ljava/lang/String;
    //   83: iconst_0
    //   84: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   87: aload_0
    //   88: getfield 20	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:b	Lcom/tencent/mobileqq/kandian/biz/skin/RefreshData;
    //   91: iconst_1
    //   92: putfield 114	com/tencent/mobileqq/kandian/biz/skin/RefreshData:isShown	Z
    //   95: aload_0
    //   96: getfield 16	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:d	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   99: getfield 117	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:a	Lcom/tencent/common/app/AppInterface;
    //   102: invokevirtual 123	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   105: invokevirtual 129	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   108: aload_0
    //   109: getfield 16	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:d	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   112: getfield 117	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:a	Lcom/tencent/common/app/AppInterface;
    //   115: invokevirtual 132	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   118: aload_0
    //   119: getfield 20	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:b	Lcom/tencent/mobileqq/kandian/biz/skin/RefreshData;
    //   122: invokevirtual 136	com/tencent/mobileqq/kandian/biz/skin/RefreshData:toJson	()Lorg/json/JSONObject;
    //   125: invokevirtual 139	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 22	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:c	I
    //   132: invokestatic 145	com/tencent/mobileqq/utils/SharedPreUtils:f	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   135: goto +67 -> 202
    //   138: astore_2
    //   139: goto +71 -> 210
    //   142: astore_3
    //   143: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +56 -> 202
    //   149: new 48	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   156: astore 4
    //   158: aload 4
    //   160: ldc 147
    //   162: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 4
    //   168: aload_2
    //   169: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: ldc 149
    //   177: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload_3
    //   184: invokestatic 153	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 84
    //   193: iconst_2
    //   194: aload 4
    //   196: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 156	java/io/File:delete	()Z
    //   206: pop
    //   207: goto +47 -> 254
    //   210: aload_1
    //   211: invokevirtual 156	java/io/File:delete	()Z
    //   214: pop
    //   215: aload_2
    //   216: athrow
    //   217: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +34 -> 254
    //   223: new 48	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   230: astore_1
    //   231: aload_1
    //   232: ldc 158
    //   234: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: aload_2
    //   240: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 84
    //   246: iconst_2
    //   247: aload_1
    //   248: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_0
    //   255: getfield 16	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager$2:d	Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager;
    //   258: getfield 46	com/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshManager:c	Ljava/util/HashMap;
    //   261: astore_1
    //   262: new 48	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: ldc 51
    //   273: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_3
    //   278: aload_2
    //   279: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_1
    //   284: aload_3
    //   285: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokevirtual 65	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.2
 * JD-Core Version:    0.7.0.1
 */