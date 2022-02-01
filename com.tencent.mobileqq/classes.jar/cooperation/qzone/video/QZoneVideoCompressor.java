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
      QZLog.w("QZoneVideoCompressor", "cancel: process not exists or finished. key=" + paramString);
      return;
    }
    Process localProcess = (Process)processMap.remove(paramString);
    if (localProcess == null)
    {
      QZLog.w("QZoneVideoCompressor", "cancel: process == null. key=" + paramString);
      return;
    }
    QZLog.i("QZoneVideoCompressor", "cancel: killProcess. key=" + paramString);
    localProcess.destroy();
  }
  
  private static String getFFmpegPath()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + str;
    }
  }
  
  private static String getShortVideoSoFullPath()
  {
    return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + VideoEnvironment.getShortVideoSoLibName();
  }
  
  private static boolean setFileExecutable(File paramFile)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFile == null) || (!paramFile.exists())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFile.canExecute());
      bool1 = bool2;
    } while (paramFile.setExecutable(true));
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
    //   113: ifnull +93 -> 206
    //   116: invokestatic 187	cooperation/qzone/util/QZLog:isDevelopLevel	()Z
    //   119: ifeq -15 -> 104
    //   122: ldc 14
    //   124: iconst_4
    //   125: aload 5
    //   127: invokestatic 190	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: goto -26 -> 104
    //   133: astore_1
    //   134: ldc 14
    //   136: new 53	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   143: ldc 192
    //   145: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 77	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iconst_0
    //   159: istore_3
    //   160: iload_3
    //   161: istore_2
    //   162: aload_0
    //   163: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifne +13 -> 179
    //   169: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   172: aload_0
    //   173: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: iload_3
    //   178: istore_2
    //   179: ldc 14
    //   181: iconst_1
    //   182: new 53	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   189: ldc 194
    //   191: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_2
    //   195: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 190	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: iload_2
    //   205: ireturn
    //   206: aload_1
    //   207: invokevirtual 201	java/lang/Process:waitFor	()I
    //   210: istore_3
    //   211: iload_3
    //   212: istore_2
    //   213: aload_0
    //   214: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne -38 -> 179
    //   220: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   223: aload_0
    //   224: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: iload_3
    //   229: istore_2
    //   230: goto -51 -> 179
    //   233: astore_1
    //   234: sipush -1111
    //   237: istore_3
    //   238: ldc 14
    //   240: ldc 202
    //   242: aload_1
    //   243: invokestatic 206	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: iload_3
    //   247: istore_2
    //   248: aload_0
    //   249: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne -73 -> 179
    //   255: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   258: aload_0
    //   259: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: pop
    //   263: iload_3
    //   264: istore_2
    //   265: goto -86 -> 179
    //   268: astore_1
    //   269: aload_0
    //   270: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   273: ifne +11 -> 284
    //   276: getstatic 28	cooperation/qzone/video/QZoneVideoCompressor:processMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   279: aload_0
    //   280: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   0	286	1	paramArrayOfString	String[]
    //   161	104	2	i	int
    //   159	105	3	j	int
    //   21	84	4	localObject	Object
    //   109	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	84	133	java/io/InterruptedIOException
    //   84	104	133	java/io/InterruptedIOException
    //   104	111	133	java/io/InterruptedIOException
    //   116	130	133	java/io/InterruptedIOException
    //   206	211	133	java/io/InterruptedIOException
    //   0	84	233	java/lang/Throwable
    //   84	104	233	java/lang/Throwable
    //   104	111	233	java/lang/Throwable
    //   116	130	233	java/lang/Throwable
    //   206	211	233	java/lang/Throwable
    //   0	84	268	finally
    //   84	104	268	finally
    //   104	111	268	finally
    //   116	130	268	finally
    //   134	158	268	finally
    //   206	211	268	finally
    //   238	246	268	finally
  }
  
  public static int trimByFFmpeg(String[] paramArrayOfString)
  {
    return trimByFFmpeg(null, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QZoneVideoCompressor
 * JD-Core Version:    0.7.0.1
 */