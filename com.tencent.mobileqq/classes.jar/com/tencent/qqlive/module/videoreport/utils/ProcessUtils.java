package com.tencent.qqlive.module.videoreport.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Iterator;
import java.util.List;

public class ProcessUtils
{
  private static final String TAG = "ProcessUtils";
  
  /* Error */
  private static String getProcessName(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: new 19	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   14: astore_3
    //   15: aload_2
    //   16: astore_1
    //   17: aload_3
    //   18: ldc 22
    //   20: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: iload_0
    //   28: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: ldc 31
    //   37: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: astore_1
    //   43: new 33	java/io/FileReader
    //   46: dup
    //   47: aload_3
    //   48: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 40	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: sipush 512
    //   58: newarray char
    //   60: astore_1
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 44	java/io/FileReader:read	([C)I
    //   66: pop
    //   67: iconst_0
    //   68: istore_0
    //   69: iload_0
    //   70: aload_1
    //   71: arraylength
    //   72: if_icmpge +16 -> 88
    //   75: aload_1
    //   76: iload_0
    //   77: caload
    //   78: ifeq +10 -> 88
    //   81: iload_0
    //   82: iconst_1
    //   83: iadd
    //   84: istore_0
    //   85: goto -16 -> 69
    //   88: new 46	java/lang/String
    //   91: dup
    //   92: aload_1
    //   93: iconst_0
    //   94: iload_0
    //   95: invokespecial 49	java/lang/String:<init>	([CII)V
    //   98: astore_1
    //   99: aload_2
    //   100: invokevirtual 52	java/io/FileReader:close	()V
    //   103: aload_1
    //   104: areturn
    //   105: astore_2
    //   106: new 19	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: ldc 54
    //   117: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_3
    //   122: aload_2
    //   123: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 8
    //   129: aload_3
    //   130: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 63	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: areturn
    //   138: astore_3
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: astore_2
    //   143: goto +102 -> 245
    //   146: astore_3
    //   147: goto +11 -> 158
    //   150: astore_2
    //   151: goto +94 -> 245
    //   154: astore_3
    //   155: aload 4
    //   157: astore_2
    //   158: aload_2
    //   159: astore_1
    //   160: new 19	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   167: astore 4
    //   169: aload_2
    //   170: astore_1
    //   171: aload 4
    //   173: ldc 65
    //   175: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: astore_1
    //   181: aload 4
    //   183: aload_3
    //   184: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_2
    //   189: astore_1
    //   190: ldc 8
    //   192: aload 4
    //   194: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 63	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_2
    //   201: ifnull +41 -> 242
    //   204: aload_2
    //   205: invokevirtual 52	java/io/FileReader:close	()V
    //   208: ldc 67
    //   210: areturn
    //   211: astore_1
    //   212: new 19	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   219: astore_2
    //   220: aload_2
    //   221: ldc 54
    //   223: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_2
    //   228: aload_1
    //   229: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc 8
    //   235: aload_2
    //   236: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 63	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: ldc 67
    //   244: areturn
    //   245: aload_1
    //   246: ifnull +41 -> 287
    //   249: aload_1
    //   250: invokevirtual 52	java/io/FileReader:close	()V
    //   253: goto +34 -> 287
    //   256: astore_1
    //   257: new 19	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   264: astore_3
    //   265: aload_3
    //   266: ldc 54
    //   268: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_3
    //   273: aload_1
    //   274: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: ldc 8
    //   280: aload_3
    //   281: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 63	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto +5 -> 292
    //   290: aload_2
    //   291: athrow
    //   292: goto -2 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramInt	int
    //   6	184	1	localObject1	Object
    //   211	39	1	localThrowable1	java.lang.Throwable
    //   256	18	1	localThrowable2	java.lang.Throwable
    //   4	96	2	localFileReader	java.io.FileReader
    //   105	35	2	localThrowable3	java.lang.Throwable
    //   142	1	2	localObject2	Object
    //   150	1	2	localObject3	Object
    //   157	134	2	localStringBuilder1	StringBuilder
    //   14	116	3	localStringBuilder2	StringBuilder
    //   138	4	3	localObject4	Object
    //   146	1	3	localThrowable4	java.lang.Throwable
    //   154	30	3	localThrowable5	java.lang.Throwable
    //   264	17	3	localStringBuilder3	StringBuilder
    //   1	192	4	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	103	105	java/lang/Throwable
    //   55	67	138	finally
    //   69	75	138	finally
    //   88	99	138	finally
    //   55	67	146	java/lang/Throwable
    //   69	75	146	java/lang/Throwable
    //   88	99	146	java/lang/Throwable
    //   7	15	150	finally
    //   17	24	150	finally
    //   26	32	150	finally
    //   34	41	150	finally
    //   43	55	150	finally
    //   160	169	150	finally
    //   171	179	150	finally
    //   181	188	150	finally
    //   190	200	150	finally
    //   7	15	154	java/lang/Throwable
    //   17	24	154	java/lang/Throwable
    //   26	32	154	java/lang/Throwable
    //   34	41	154	java/lang/Throwable
    //   43	55	154	java/lang/Throwable
    //   204	208	211	java/lang/Throwable
    //   249	253	256	java/lang/Throwable
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    Context localContext = null;
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        localContext = paramContext;
        localObject = paramContext.iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          do
          {
            localContext = paramContext;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localContext = paramContext;
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          } while (localRunningAppProcessInfo == null);
          localContext = paramContext;
        } while (localRunningAppProcessInfo.pid != Process.myPid());
        localContext = paramContext;
        paramContext = localRunningAppProcessInfo.processName;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getProcessName error ");
      ((StringBuilder)localObject).append(localContext);
      ((StringBuilder)localObject).append(paramContext);
      Log.d("ProcessUtils", ((StringBuilder)localObject).toString());
    }
    return getProcessName(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */