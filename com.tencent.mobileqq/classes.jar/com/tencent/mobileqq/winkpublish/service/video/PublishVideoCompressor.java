package com.tencent.mobileqq.winkpublish.service.video;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostVideoHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class PublishVideoCompressor
{
  private static ConcurrentHashMap<String, Process> a = new ConcurrentHashMap(8, 0.75F, 2);
  
  /* Error */
  public static int a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: invokestatic 31	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	()Ljava/lang/String;
    //   7: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokestatic 37	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	(Ljava/io/File;)Z
    //   13: pop
    //   14: new 39	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 40	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 31	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	()Ljava/lang/String;
    //   28: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload 4
    //   34: aload_1
    //   35: invokestatic 50	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   38: invokevirtual 54	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   41: pop
    //   42: aload 4
    //   44: invokestatic 57	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:b	()Ljava/lang/String;
    //   47: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: new 59	java/lang/ProcessBuilder
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 62	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   60: iconst_1
    //   61: invokevirtual 66	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   64: invokevirtual 70	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +12 -> 84
    //   75: getstatic 18	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 82	java/io/BufferedReader
    //   87: dup
    //   88: new 84	java/io/InputStreamReader
    //   91: dup
    //   92: aload_1
    //   93: invokevirtual 90	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   96: invokespecial 93	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 96	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 99	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +20 -> 133
    //   116: invokestatic 105	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   119: ifeq -15 -> 104
    //   122: ldc 107
    //   124: iconst_4
    //   125: aload 5
    //   127: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: goto -26 -> 104
    //   133: aload_1
    //   134: invokevirtual 115	java/lang/Process:waitFor	()I
    //   137: istore_3
    //   138: iload_3
    //   139: istore_2
    //   140: aload_0
    //   141: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +99 -> 243
    //   147: iload_3
    //   148: istore_2
    //   149: getstatic 18	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   152: aload_0
    //   153: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: goto +86 -> 243
    //   160: astore_1
    //   161: goto +115 -> 276
    //   164: astore_1
    //   165: ldc 107
    //   167: iconst_1
    //   168: ldc 121
    //   170: aload_1
    //   171: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_0
    //   175: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +11 -> 189
    //   181: getstatic 18	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   184: aload_0
    //   185: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: sipush -1111
    //   192: istore_2
    //   193: goto +50 -> 243
    //   196: new 127	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   203: astore_1
    //   204: aload_1
    //   205: ldc 130
    //   207: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: aload_0
    //   213: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: ldc 107
    //   219: iconst_1
    //   220: aload_1
    //   221: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_0
    //   228: istore_2
    //   229: iconst_0
    //   230: istore_3
    //   231: aload_0
    //   232: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +8 -> 243
    //   238: iload_3
    //   239: istore_2
    //   240: goto -91 -> 149
    //   243: new 127	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   250: astore_0
    //   251: aload_0
    //   252: ldc 139
    //   254: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_0
    //   259: iload_2
    //   260: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 107
    //   266: iconst_1
    //   267: aload_0
    //   268: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: iload_2
    //   275: ireturn
    //   276: aload_0
    //   277: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +11 -> 291
    //   283: getstatic 18	com/tencent/mobileqq/winkpublish/service/video/PublishVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   286: aload_0
    //   287: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: goto +5 -> 296
    //   294: aload_1
    //   295: athrow
    //   296: goto -2 -> 294
    //   299: astore_1
    //   300: goto -104 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramString	String
    //   0	303	1	paramArrayOfString	String[]
    //   139	136	2	i	int
    //   137	102	3	j	int
    //   21	84	4	localObject	Object
    //   109	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	84	160	finally
    //   84	104	160	finally
    //   104	111	160	finally
    //   116	130	160	finally
    //   133	138	160	finally
    //   165	174	160	finally
    //   196	227	160	finally
    //   0	84	164	java/lang/Throwable
    //   84	104	164	java/lang/Throwable
    //   104	111	164	java/lang/Throwable
    //   116	130	164	java/lang/Throwable
    //   133	138	164	java/lang/Throwable
    //   0	84	299	java/io/InterruptedIOException
    //   84	104	299	java/io/InterruptedIOException
    //   104	111	299	java/io/InterruptedIOException
    //   116	130	299	java/io/InterruptedIOException
    //   133	138	299	java/io/InterruptedIOException
  }
  
  private static String a()
  {
    String str;
    if (Build.VERSION.SDK_INT >= 16) {
      str = "trim_process_pie";
    } else {
      str = "trim_process_pic";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleHostVideoHelper.getShortVideoSoPath(HostUIHelper.getInstance().getHostApplicationContext()));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("QZoneVideoCompressor", 1, "cancel: key is empty!");
      return;
    }
    if (!a.containsKey(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancel: process not exists or finished. key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("QZoneVideoCompressor", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (Process)a.remove(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancel: process == null. key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("QZoneVideoCompressor", 1, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel: killProcess. key=");
    localStringBuilder.append(paramString);
    QLog.i("QZoneVideoCompressor", 1, localStringBuilder.toString());
    ((Process)localObject).destroy();
  }
  
  private static boolean a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if (!paramFile.canExecute()) {
        return paramFile.setExecutable(true);
      }
      return true;
    }
    return false;
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleHostVideoHelper.getShortVideoSoPath(HostUIHelper.getInstance().getHostApplicationContext()));
    localStringBuilder.append(QCircleHostVideoHelper.getShortVideoSoLibName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.PublishVideoCompressor
 * JD-Core Version:    0.7.0.1
 */