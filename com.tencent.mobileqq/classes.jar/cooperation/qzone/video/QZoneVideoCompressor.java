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
  private static ConcurrentHashMap a = new ConcurrentHashMap(8, 0.75F, 2);
  
  /* Error */
  public static int a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 27	java/io/File
    //   3: dup
    //   4: invokestatic 30	cooperation/qzone/video/QZoneVideoCompressor:a	()Ljava/lang/String;
    //   7: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokestatic 36	cooperation/qzone/video/QZoneVideoCompressor:a	(Ljava/io/File;)Z
    //   13: pop
    //   14: new 38	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 39	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 30	cooperation/qzone/video/QZoneVideoCompressor:a	()Ljava/lang/String;
    //   28: invokevirtual 43	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload 4
    //   34: aload_1
    //   35: invokestatic 49	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   38: invokevirtual 53	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   41: pop
    //   42: aload 4
    //   44: invokestatic 56	cooperation/qzone/video/QZoneVideoCompressor:b	()Ljava/lang/String;
    //   47: invokevirtual 43	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: new 58	java/lang/ProcessBuilder
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 61	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   60: iconst_1
    //   61: invokevirtual 65	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   64: invokevirtual 69	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +12 -> 84
    //   75: getstatic 17	cooperation/qzone/video/QZoneVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 79	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 81	java/io/BufferedReader
    //   87: dup
    //   88: new 83	java/io/InputStreamReader
    //   91: dup
    //   92: aload_1
    //   93: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   96: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +62 -> 175
    //   116: ldc 100
    //   118: iconst_1
    //   119: aload 5
    //   121: invokestatic 106	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: goto -20 -> 104
    //   127: astore_1
    //   128: ldc 100
    //   130: new 108	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   137: ldc 111
    //   139: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 121	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: iconst_0
    //   153: istore_3
    //   154: iload_3
    //   155: istore_2
    //   156: aload_0
    //   157: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne +13 -> 173
    //   163: getstatic 17	cooperation/qzone/video/QZoneVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   166: aload_0
    //   167: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: iload_3
    //   172: istore_2
    //   173: iload_2
    //   174: ireturn
    //   175: aload_1
    //   176: invokevirtual 129	java/lang/Process:waitFor	()I
    //   179: istore_3
    //   180: iload_3
    //   181: istore_2
    //   182: aload_0
    //   183: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne -13 -> 173
    //   189: getstatic 17	cooperation/qzone/video/QZoneVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   192: aload_0
    //   193: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: iload_3
    //   198: ireturn
    //   199: astore_1
    //   200: sipush -1111
    //   203: istore_2
    //   204: ldc 100
    //   206: ldc 131
    //   208: aload_1
    //   209: invokestatic 135	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_0
    //   213: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne -43 -> 173
    //   219: getstatic 17	cooperation/qzone/video/QZoneVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   222: aload_0
    //   223: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: sipush -1111
    //   230: ireturn
    //   231: astore_1
    //   232: aload_0
    //   233: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifne +11 -> 247
    //   239: getstatic 17	cooperation/qzone/video/QZoneVideoCompressor:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   242: aload_0
    //   243: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_1
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   0	249	1	paramArrayOfString	String[]
    //   155	49	2	i	int
    //   153	45	3	j	int
    //   21	84	4	localObject	Object
    //   109	11	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	84	127	java/io/InterruptedIOException
    //   84	104	127	java/io/InterruptedIOException
    //   104	111	127	java/io/InterruptedIOException
    //   116	124	127	java/io/InterruptedIOException
    //   175	180	127	java/io/InterruptedIOException
    //   0	84	199	java/lang/Throwable
    //   84	104	199	java/lang/Throwable
    //   104	111	199	java/lang/Throwable
    //   116	124	199	java/lang/Throwable
    //   175	180	199	java/lang/Throwable
    //   0	84	231	finally
    //   84	104	231	finally
    //   104	111	231	finally
    //   116	124	231	finally
    //   128	152	231	finally
    //   175	180	231	finally
    //   204	212	231	finally
  }
  
  public static int a(String[] paramArrayOfString)
  {
    return a(null, paramArrayOfString);
  }
  
  private static String a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + str;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QZLog.w("QZoneVideoCompressor", "cancel: key is empty!");
      return;
    }
    if (!a.containsKey(paramString))
    {
      QZLog.w("QZoneVideoCompressor", "cancel: process not exists or finished. key=" + paramString);
      return;
    }
    Process localProcess = (Process)a.remove(paramString);
    if (localProcess == null)
    {
      QZLog.w("QZoneVideoCompressor", "cancel: process == null. key=" + paramString);
      return;
    }
    QZLog.i("QZoneVideoCompressor", "cancel: killProcess. key=" + paramString);
    localProcess.destroy();
  }
  
  private static boolean a(File paramFile)
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
  
  private static String b()
  {
    return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + VideoEnvironment.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QZoneVideoCompressor
 * JD-Core Version:    0.7.0.1
 */