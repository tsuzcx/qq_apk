package cooperation.qzone.video;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QZoneVideoCompressor
{
  private static final String FFMPEG_BIN_FILE_NAME_PIC = "trim_process_pic";
  private static final String FFMPEG_BIN_FILE_NAME_PIE = "trim_process_pie";
  private static final String LOGTAG = "QZoneVideoCompressor";
  private static ConcurrentHashMap<String, Process> processMap = new ConcurrentHashMap(8, 0.75F, 2);
  
  public static void cancel(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QZLog.w("QZoneVideoCompressor", "cancel: key is empty!");
      return;
    }
    if (!processMap.containsKey(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancel: process not exists or finished. key=");
      ((StringBuilder)localObject).append(paramString);
      QZLog.w("QZoneVideoCompressor", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (Process)processMap.remove(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancel: process == null. key=");
      ((StringBuilder)localObject).append(paramString);
      QZLog.w("QZoneVideoCompressor", ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel: killProcess. key=");
    localStringBuilder.append(paramString);
    QZLog.i("QZoneVideoCompressor", localStringBuilder.toString());
    ((Process)localObject).destroy();
  }
  
  private static String getFFmpegPath()
  {
    String str;
    if (Build.VERSION.SDK_INT >= 16) {
      str = "trim_process_pie";
    } else {
      str = "trim_process_pic";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private static String getShortVideoSoFullPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()));
    localStringBuilder.append(VideoEnvironment.getShortVideoSoLibName());
    return localStringBuilder.toString();
  }
  
  private static boolean setFileExecutable(File paramFile)
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
  
  /* Error */
  public static int trimByFFmpeg(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 109	java/io/File
    //   3: dup
    //   4: invokestatic 128	cooperation/qzone/video/QZoneVideoCompressor:getFFmpegPath	()Ljava/lang/String;
    //   7: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokestatic 132	cooperation/qzone/video/QZoneVideoCompressor:setFileExecutable	(Ljava/io/File;)Z
    //   13: pop
    //   14: new 134	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 135	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 128	cooperation/qzone/video/QZoneVideoCompressor:getFFmpegPath	()Ljava/lang/String;
    //   28: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload 4
    //   34: aload_1
    //   35: invokestatic 144	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   38: invokevirtual 148	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   41: pop
    //   42: aload 4
    //   44: invokestatic 150	cooperation/qzone/video/QZoneVideoCompressor:getShortVideoSoFullPath	()Ljava/lang/String;
    //   47: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: new 152	java/lang/ProcessBuilder
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 155	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   60: iconst_1
    //   61: invokevirtual 159	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   64: invokevirtual 163	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +12 -> 84
    //   75: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 167	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 169	java/io/BufferedReader
    //   87: dup
    //   88: new 171	java/io/InputStreamReader
    //   91: dup
    //   92: aload_1
    //   93: invokevirtual 175	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   96: invokespecial 178	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 181	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 184	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +20 -> 133
    //   116: invokestatic 187	cooperation/qzone/util/QZLog:isDevelopLevel	()Z
    //   119: ifeq -15 -> 104
    //   122: ldc 14
    //   124: iconst_4
    //   125: aload 5
    //   127: invokestatic 190	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: goto -26 -> 104
    //   133: aload_1
    //   134: invokevirtual 194	java/lang/Process:waitFor	()I
    //   137: istore_3
    //   138: iload_3
    //   139: istore_2
    //   140: aload_0
    //   141: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +97 -> 241
    //   147: iload_3
    //   148: istore_2
    //   149: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   152: aload_0
    //   153: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: goto +84 -> 241
    //   160: astore_1
    //   161: goto +113 -> 274
    //   164: astore_1
    //   165: ldc 14
    //   167: ldc 195
    //   169: aload_1
    //   170: invokestatic 199	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_0
    //   174: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +11 -> 188
    //   180: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   183: aload_0
    //   184: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: sipush -1111
    //   191: istore_2
    //   192: goto +49 -> 241
    //   195: new 53	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   202: astore_1
    //   203: aload_1
    //   204: ldc 201
    //   206: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_1
    //   211: aload_0
    //   212: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 14
    //   218: aload_1
    //   219: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 77	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: iconst_0
    //   226: istore_2
    //   227: iconst_0
    //   228: istore_3
    //   229: aload_0
    //   230: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne +8 -> 241
    //   236: iload_3
    //   237: istore_2
    //   238: goto -89 -> 149
    //   241: new 53	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   248: astore_0
    //   249: aload_0
    //   250: ldc 203
    //   252: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_0
    //   257: iload_2
    //   258: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: ldc 14
    //   264: iconst_1
    //   265: aload_0
    //   266: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 190	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iload_2
    //   273: ireturn
    //   274: aload_0
    //   275: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +11 -> 289
    //   281: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   284: aload_0
    //   285: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: goto +5 -> 294
    //   292: aload_1
    //   293: athrow
    //   294: goto -2 -> 292
    //   297: astore_1
    //   298: goto -103 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramString	String
    //   0	301	1	paramArrayOfString	String[]
    //   139	134	2	i	int
    //   137	100	3	j	int
    //   21	84	4	localObject	Object
    //   109	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	84	160	finally
    //   84	104	160	finally
    //   104	111	160	finally
    //   116	130	160	finally
    //   133	138	160	finally
    //   165	173	160	finally
    //   195	225	160	finally
    //   0	84	164	java/lang/Throwable
    //   84	104	164	java/lang/Throwable
    //   104	111	164	java/lang/Throwable
    //   116	130	164	java/lang/Throwable
    //   133	138	164	java/lang/Throwable
    //   0	84	297	java/io/InterruptedIOException
    //   84	104	297	java/io/InterruptedIOException
    //   104	111	297	java/io/InterruptedIOException
    //   116	130	297	java/io/InterruptedIOException
    //   133	138	297	java/io/InterruptedIOException
  }
  
  public static int trimByFFmpeg(String[] paramArrayOfString)
  {
    return trimByFFmpeg(null, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QZoneVideoCompressor
 * JD-Core Version:    0.7.0.1
 */