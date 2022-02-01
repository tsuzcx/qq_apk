package cooperation.plugin;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Dex2Oat
{
  private static final boolean a = b(System.getProperty("java.vm.version"));
  
  public static String a()
  {
    String str2 = (String)ReflecterHelper.a("dalvik.system.VMRuntime", "getCurrentInstructionSet");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "arm";
    }
    return str1;
  }
  
  public static String a(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    paramFile1 = str;
    if (!str.endsWith(".dex"))
    {
      int i = str.lastIndexOf(".");
      if (i < 0)
      {
        paramFile1 = new StringBuilder();
        paramFile1.append(str);
        paramFile1.append(".dex");
        paramFile1 = paramFile1.toString();
      }
      else
      {
        paramFile1 = new StringBuilder(i + 4);
        paramFile1.append(str, 0, i);
        paramFile1.append(".dex");
        paramFile1 = paramFile1.toString();
      }
    }
    return new File(paramFile2, paramFile1).getPath();
  }
  
  public static boolean a()
  {
    return (a) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static final boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean a(String paramString)
  {
    String str = PluginInstaller.a();
    if ((paramString != null) && (!paramString.equals("")) && (str != null) && (!str.equals("")))
    {
      if (paramString.equals(str))
      {
        paramString = new StringBuilder();
        paramString.append("same fingerprint:");
        paramString.append(str);
        Log.d("plugin_tag.Dex2Oat", paramString.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("system OTA,fingerprint not equal:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(str);
      Log.d("plugin_tag.Dex2Oat", localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fingerprint empty:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",current:");
    localStringBuilder.append(str);
    Log.d("plugin_tag.Dex2Oat", localStringBuilder.toString());
    return false;
  }
  
  public static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, Dex2Oat.ResultCallback paramResultCallback)
  {
    return a(paramCollection, paramFile, paramBoolean, paramString, new AtomicInteger(0), paramResultCallback, 2);
  }
  
  /* Error */
  private static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, Dex2Oat.ResultCallback paramResultCallback, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 147	java/util/concurrent/CountDownLatch
    //   6: dup
    //   7: aload_0
    //   8: invokeinterface 153 1 0
    //   13: invokespecial 154	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   16: astore 10
    //   18: iload 6
    //   20: new 156	cooperation/plugin/Dex2Oat$1
    //   23: dup
    //   24: invokespecial 157	cooperation/plugin/Dex2Oat$1:<init>	()V
    //   27: invokestatic 163	java/util/concurrent/Executors:newFixedThreadPool	(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    //   30: astore 9
    //   32: invokestatic 166	java/lang/System:nanoTime	()J
    //   35: lstore 7
    //   37: new 168	java/util/ArrayList
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 171	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   45: astore 11
    //   47: aload 11
    //   49: new 173	cooperation/plugin/Dex2Oat$2
    //   52: dup
    //   53: invokespecial 174	cooperation/plugin/Dex2Oat$2:<init>	()V
    //   56: invokestatic 180	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   59: aload 11
    //   61: invokestatic 184	java/util/Collections:reverse	(Ljava/util/List;)V
    //   64: aload 11
    //   66: invokevirtual 188	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   69: astore 11
    //   71: aload 11
    //   73: invokeinterface 193 1 0
    //   78: ifeq +40 -> 118
    //   81: aload 9
    //   83: new 195	cooperation/plugin/Dex2Oat$OptimizeWorker
    //   86: dup
    //   87: aload 11
    //   89: invokeinterface 199 1 0
    //   94: checkcast 49	java/io/File
    //   97: aload_1
    //   98: iload_2
    //   99: aload_3
    //   100: aload 4
    //   102: aload 10
    //   104: aload 5
    //   106: invokespecial 202	cooperation/plugin/Dex2Oat$OptimizeWorker:<init>	(Ljava/io/File;Ljava/io/File;ZLjava/lang/String;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/CountDownLatch;Lcooperation/plugin/Dex2Oat$ResultCallback;)V
    //   109: invokeinterface 208 2 0
    //   114: pop
    //   115: goto -44 -> 71
    //   118: aload 10
    //   120: invokevirtual 211	java/util/concurrent/CountDownLatch:await	()V
    //   123: invokestatic 166	java/lang/System:nanoTime	()J
    //   126: lload 7
    //   128: lsub
    //   129: ldc2_w 212
    //   132: ldiv
    //   133: lstore 7
    //   135: aload 4
    //   137: invokevirtual 216	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   140: aload_0
    //   141: invokeinterface 153 1 0
    //   146: if_icmpne +54 -> 200
    //   149: new 65	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   156: astore_0
    //   157: aload_0
    //   158: ldc 218
    //   160: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_0
    //   165: lload 7
    //   167: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: ldc 223
    //   174: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 120
    //   180: aload_0
    //   181: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 226	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aload 9
    //   190: invokeinterface 229 1 0
    //   195: ldc 2
    //   197: monitorexit
    //   198: iconst_1
    //   199: ireturn
    //   200: ldc 120
    //   202: ldc 231
    //   204: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload 9
    //   210: invokeinterface 229 1 0
    //   215: ldc 2
    //   217: monitorexit
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_0
    //   221: goto +25 -> 246
    //   224: astore_0
    //   225: ldc 120
    //   227: ldc 236
    //   229: aload_0
    //   230: invokestatic 240	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload 9
    //   236: invokeinterface 229 1 0
    //   241: ldc 2
    //   243: monitorexit
    //   244: iconst_0
    //   245: ireturn
    //   246: aload 9
    //   248: invokeinterface 229 1 0
    //   253: aload_0
    //   254: athrow
    //   255: astore_0
    //   256: ldc 2
    //   258: monitorexit
    //   259: goto +5 -> 264
    //   262: aload_0
    //   263: athrow
    //   264: goto -2 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramCollection	Collection<File>
    //   0	267	1	paramFile	File
    //   0	267	2	paramBoolean	boolean
    //   0	267	3	paramString	String
    //   0	267	4	paramAtomicInteger	AtomicInteger
    //   0	267	5	paramResultCallback	Dex2Oat.ResultCallback
    //   0	267	6	paramInt	int
    //   35	131	7	l	long
    //   30	217	9	localExecutorService	java.util.concurrent.ExecutorService
    //   16	103	10	localCountDownLatch	java.util.concurrent.CountDownLatch
    //   45	43	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   118	188	220	finally
    //   200	208	220	finally
    //   225	234	220	finally
    //   118	188	224	java/lang/InterruptedException
    //   200	208	224	java/lang/InterruptedException
    //   3	71	255	finally
    //   71	115	255	finally
    //   188	195	255	finally
    //   208	215	255	finally
    //   234	241	255	finally
    //   246	255	255	finally
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!paramString.matches()) {}
    }
    try
    {
      int i = Integer.parseInt(paramString.group(1));
      int j = Integer.parseInt(paramString.group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat
 * JD-Core Version:    0.7.0.1
 */