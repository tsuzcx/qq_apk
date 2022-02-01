package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TbsLog
{
  public static final int TBSLOG_CODE_SDK_BASE = 1000;
  public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
  public static final int TBSLOG_CODE_SDK_INIT = 999;
  public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
  public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
  public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
  public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
  public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
  public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
  public static final String X5LOGTAG = "x5logtag";
  private static boolean a = false;
  private static boolean b = true;
  private static TbsLogClient c;
  public static int sLogMaxCount = 10;
  public static List<String> sTbsLogList = new LinkedList();
  
  /* Error */
  public static void addLog(int paramInt, String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   11: invokeinterface 61 1 0
    //   16: getstatic 49	com/tencent/smtt/utils/TbsLog:sLogMaxCount	I
    //   19: if_icmple +48 -> 67
    //   22: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   25: invokeinterface 61 1 0
    //   30: getstatic 49	com/tencent/smtt/utils/TbsLog:sLogMaxCount	I
    //   33: isub
    //   34: istore_3
    //   35: iload_3
    //   36: ifle +31 -> 67
    //   39: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   42: invokeinterface 61 1 0
    //   47: ifle +20 -> 67
    //   50: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   53: iconst_0
    //   54: invokeinterface 65 2 0
    //   59: pop
    //   60: iload_3
    //   61: iconst_1
    //   62: isub
    //   63: istore_3
    //   64: goto -29 -> 35
    //   67: aconst_null
    //   68: astore 5
    //   70: aload 5
    //   72: astore 4
    //   74: aload_1
    //   75: ifnull +10 -> 85
    //   78: aload_1
    //   79: aload_2
    //   80: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_1
    //   88: aload 4
    //   90: ifnonnull +6 -> 96
    //   93: ldc 73
    //   95: astore_1
    //   96: ldc 75
    //   98: iconst_5
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   107: invokestatic 87	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: iconst_1
    //   114: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: bipush 48
    //   122: invokestatic 97	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   125: aastore
    //   126: dup
    //   127: iconst_3
    //   128: iload_0
    //   129: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: iconst_4
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   140: astore_1
    //   141: getstatic 47	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   144: aload_1
    //   145: invokeinterface 101 2 0
    //   150: pop
    //   151: goto +12 -> 163
    //   154: astore_1
    //   155: goto +12 -> 167
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   163: aload 6
    //   165: monitorexit
    //   166: return
    //   167: aload 6
    //   169: monitorexit
    //   170: goto +5 -> 175
    //   173: aload_1
    //   174: athrow
    //   175: goto -2 -> 173
    //   178: astore_1
    //   179: aload 5
    //   181: astore 4
    //   183: goto -98 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramInt	int
    //   0	186	1	paramString	String
    //   0	186	2	paramVarArgs	Object[]
    //   34	30	3	i	int
    //   72	110	4	localObject1	Object
    //   68	112	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	35	154	finally
    //   39	60	154	finally
    //   78	85	154	finally
    //   96	151	154	finally
    //   159	163	154	finally
    //   163	166	154	finally
    //   167	170	154	finally
    //   8	35	158	java/lang/Exception
    //   39	60	158	java/lang/Exception
    //   96	151	158	java/lang/Exception
    //   78	85	178	java/lang/Exception
  }
  
  public static void app_extra(String paramString, Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = paramContext.getApplicationContext();
        paramContext = new String[6];
        i = 0;
        paramContext[0] = "com.tencent.tbs";
        paramContext[1] = "com.tencent.mtt";
        paramContext[2] = "com.tencent.mm";
        paramContext[3] = "com.tencent.mobileqq";
        paramContext[4] = "com.tencent.mtt.sdk.test";
        paramContext[5] = "com.qzone";
        int j = paramContext.length;
        if (i < j)
        {
          if (!((Context)localObject).getPackageName().contains(paramContext[i])) {
            break label246;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("app_extra pid:");
          ((StringBuilder)localObject).append(Process.myPid());
          ((StringBuilder)localObject).append("; APP_TAG:");
          ((StringBuilder)localObject).append(new String[] { "DEMO", "QB", "WX", "QQ", "TEST", "QZ" }[i]);
          ((StringBuilder)localObject).append("!");
          i(paramString, ((StringBuilder)localObject).toString());
        }
        if (i == paramContext.length)
        {
          paramContext = new StringBuilder();
          paramContext.append("app_extra pid:");
          paramContext.append(Process.myPid());
          paramContext.append("; APP_TAG:OTHER!");
          i(paramString, paramContext.toString());
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("app_extra exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
        w(paramString, ((StringBuilder)localObject).toString());
      }
      return;
      label246:
      i += 1;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    TbsLogClient localTbsLogClient = c;
    if (localTbsLogClient == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.d(paramString1, localStringBuilder.toString());
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    d(paramString1, paramString2);
    TbsLogClient localTbsLogClient = c;
    if ((localTbsLogClient != null) && (a) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localTbsLogClient.showLog(localStringBuilder.toString());
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    TbsLogClient localTbsLogClient = c;
    if (localTbsLogClient == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.e(paramString1, localStringBuilder.toString());
    localTbsLogClient = c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("(E)-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.writeLog(localStringBuilder.toString());
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    e(paramString1, paramString2);
    TbsLogClient localTbsLogClient = c;
    if ((localTbsLogClient != null) && (a) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localTbsLogClient.showLog(localStringBuilder.toString());
    }
  }
  
  public static String getTbsLogFilePath()
  {
    if (TbsLogClient.c != null) {
      return TbsLogClient.c.getAbsolutePath();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    TbsLogClient localTbsLogClient = c;
    if (localTbsLogClient == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.i(paramString1, localStringBuilder.toString());
    localTbsLogClient = c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("(I)-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.writeLog(localStringBuilder.toString());
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    i(paramString1, paramString2);
    TbsLogClient localTbsLogClient = c;
    if ((localTbsLogClient != null) && (a) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localTbsLogClient.showLog(localStringBuilder.toString());
    }
  }
  
  public static void i(Throwable paramThrowable)
  {
    i("handle_throwable", Log.getStackTraceString(paramThrowable));
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      if (c == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setLogView(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      TbsLogClient localTbsLogClient = c;
      if (localTbsLogClient == null) {
        return;
      }
      localTbsLogClient.setLogView(paramTextView);
    }
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    if (paramTbsLogClient == null) {
      return false;
    }
    c = paramTbsLogClient;
    paramTbsLogClient = c;
    TbsLogClient.setWriteLogJIT(b);
    return true;
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    b = paramBoolean;
    if (c == null) {
      return;
    }
    TbsLogClient.setWriteLogJIT(paramBoolean);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    TbsLogClient localTbsLogClient = c;
    if (localTbsLogClient == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.v(paramString1, localStringBuilder.toString());
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    v(paramString1, paramString2);
    TbsLogClient localTbsLogClient = c;
    if ((localTbsLogClient != null) && (a) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localTbsLogClient.showLog(localStringBuilder.toString());
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    TbsLogClient localTbsLogClient = c;
    if (localTbsLogClient == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.w(paramString1, localStringBuilder.toString());
    localTbsLogClient = c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("(W)-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-TBS:");
    localStringBuilder.append(paramString2);
    localTbsLogClient.writeLog(localStringBuilder.toString());
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    w(paramString1, paramString2);
    TbsLogClient localTbsLogClient = c;
    if ((localTbsLogClient != null) && (a) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localTbsLogClient.showLog(localStringBuilder.toString());
    }
  }
  
  public static void writeLogToDisk()
  {
    try
    {
      if (c != null) {
        c.writeLogToDisk();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLog
 * JD-Core Version:    0.7.0.1
 */