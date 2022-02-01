package cooperation.plugin;

import android.content.Context;
import android.os.AsyncTask;

class PluginCrashReceiver$PluginDirInfoLoger
  extends AsyncTask<String, String, String>
{
  private static boolean a = false;
  private Context b;
  
  public PluginCrashReceiver$PluginDirInfoLoger(Context paramContext)
  {
    this.b = paramContext;
  }
  
  /* Error */
  protected String a(String... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 26	cooperation/plugin/PluginCrashReceiver$PluginDirInfoLoger:a	Z
    //   3: ifeq +6 -> 9
    //   6: ldc 28
    //   8: areturn
    //   9: iconst_1
    //   10: putstatic 26	cooperation/plugin/PluginCrashReceiver$PluginDirInfoLoger:a	Z
    //   13: aconst_null
    //   14: astore_2
    //   15: new 30	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: new 33	java/lang/ProcessBuilder
    //   26: dup
    //   27: iconst_3
    //   28: anewarray 35	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 37
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 39
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: aload_0
    //   44: getfield 19	cooperation/plugin/PluginCrashReceiver$PluginDirInfoLoger:b	Landroid/content/Context;
    //   47: ldc 41
    //   49: iconst_0
    //   50: invokevirtual 47	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   53: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   56: aastore
    //   57: invokespecial 56	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_1
    //   63: invokevirtual 60	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   66: pop
    //   67: new 62	java/io/BufferedReader
    //   70: dup
    //   71: new 64	java/io/InputStreamReader
    //   74: dup
    //   75: aload_1
    //   76: invokevirtual 68	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   79: invokevirtual 74	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   82: invokespecial 77	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   85: invokespecial 80	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 83	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +28 -> 123
    //   98: aload_2
    //   99: ldc 41
    //   101: invokevirtual 87	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifeq -15 -> 89
    //   107: aload_3
    //   108: aload_2
    //   109: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: ldc 93
    //   116: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: goto -31 -> 89
    //   123: new 30	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   130: astore_2
    //   131: aload_2
    //   132: ldc 95
    //   134: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: aload_3
    //   140: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 100
    //   149: iconst_1
    //   150: aload_2
    //   151: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_1
    //   158: invokevirtual 109	java/io/BufferedReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_3
    //   164: aload_1
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: goto +7 -> 175
    //   171: goto +16 -> 187
    //   174: astore_1
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 109	java/io/BufferedReader:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +6 -> 194
    //   191: goto -34 -> 157
    //   194: aconst_null
    //   195: areturn
    //   196: astore_1
    //   197: goto -12 -> 185
    //   200: astore_2
    //   201: goto -30 -> 171
    //   204: astore_1
    //   205: aconst_null
    //   206: areturn
    //   207: astore_2
    //   208: goto -25 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	PluginDirInfoLoger
    //   0	211	1	paramVarArgs	String[]
    //   14	166	2	localObject1	java.lang.Object
    //   200	1	2	localThrowable	java.lang.Throwable
    //   207	1	2	localException	java.lang.Exception
    //   22	118	3	localStringBuilder	java.lang.StringBuilder
    //   163	4	3	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   89	94	163	finally
    //   98	120	163	finally
    //   123	157	163	finally
    //   15	89	174	finally
    //   15	89	196	java/lang/Throwable
    //   89	94	200	java/lang/Throwable
    //   98	120	200	java/lang/Throwable
    //   123	157	200	java/lang/Throwable
    //   157	161	204	java/lang/Exception
    //   179	183	207	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver.PluginDirInfoLoger
 * JD-Core Version:    0.7.0.1
 */