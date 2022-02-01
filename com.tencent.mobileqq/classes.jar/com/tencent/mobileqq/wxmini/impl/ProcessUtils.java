package com.tencent.mobileqq.wxmini.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Method;

class ProcessUtils
{
  @SuppressLint({"PrivateApi"})
  private static String a()
  {
    Object localObject = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
    ((Method)localObject).setAccessible(true);
    String str = null;
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    return str;
  }
  
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Application.getProcessName();
    }
    try
    {
      String str = a();
      return str;
    }
    catch (Exception localException)
    {
      label18:
      break label18;
    }
    return a(paramContext, Process.myPid());
  }
  
  /* Error */
  public static String a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +224 -> 225
    //   4: iload_1
    //   5: ifgt +6 -> 11
    //   8: ldc 72
    //   10: areturn
    //   11: aload_0
    //   12: ldc 74
    //   14: invokevirtual 80	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 82	android/app/ActivityManager
    //   20: invokevirtual 86	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   23: invokeinterface 92 1 0
    //   28: astore_0
    //   29: aload_0
    //   30: invokeinterface 98 1 0
    //   35: ifeq +52 -> 87
    //   38: aload_0
    //   39: invokeinterface 102 1 0
    //   44: checkcast 104	android/app/ActivityManager$RunningAppProcessInfo
    //   47: astore 4
    //   49: aload 4
    //   51: getfield 107	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   54: iload_1
    //   55: if_icmpne -26 -> 29
    //   58: aload 4
    //   60: getfield 111	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   63: ifnull -34 -> 29
    //   66: aload 4
    //   68: getfield 111	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   71: ldc 72
    //   73: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne -47 -> 29
    //   79: aload 4
    //   81: getfield 111	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: sipush 128
    //   90: newarray byte
    //   92: astore 6
    //   94: aconst_null
    //   95: astore 5
    //   97: aconst_null
    //   98: astore 4
    //   100: new 117	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   107: astore_0
    //   108: aload_0
    //   109: ldc 120
    //   111: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: iload_1
    //   117: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: ldc 129
    //   124: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: new 131	java/io/BufferedInputStream
    //   131: dup
    //   132: new 133	java/io/FileInputStream
    //   135: dup
    //   136: aload_0
    //   137: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   143: invokespecial 142	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   146: astore_0
    //   147: aload_0
    //   148: aload 6
    //   150: invokevirtual 148	java/io/InputStream:read	([B)I
    //   153: istore_3
    //   154: iload_3
    //   155: ifle +28 -> 183
    //   158: iconst_0
    //   159: istore_1
    //   160: goto +97 -> 257
    //   163: new 46	java/lang/String
    //   166: dup
    //   167: aload 6
    //   169: iconst_0
    //   170: iload_2
    //   171: invokespecial 151	java/lang/String:<init>	([BII)V
    //   174: astore 4
    //   176: aload_0
    //   177: invokevirtual 154	java/io/InputStream:close	()V
    //   180: aload 4
    //   182: areturn
    //   183: aload_0
    //   184: invokevirtual 154	java/io/InputStream:close	()V
    //   187: ldc 72
    //   189: areturn
    //   190: astore 5
    //   192: aload_0
    //   193: astore 4
    //   195: aload 5
    //   197: astore_0
    //   198: goto +7 -> 205
    //   201: goto +16 -> 217
    //   204: astore_0
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 154	java/io/InputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 154	java/io/InputStream:close	()V
    //   225: ldc 72
    //   227: areturn
    //   228: astore_0
    //   229: goto -142 -> 87
    //   232: astore_0
    //   233: aload 5
    //   235: astore_0
    //   236: goto -19 -> 217
    //   239: astore 4
    //   241: goto -40 -> 201
    //   244: astore_0
    //   245: aload 4
    //   247: areturn
    //   248: astore_0
    //   249: ldc 72
    //   251: areturn
    //   252: astore 4
    //   254: goto -39 -> 215
    //   257: iload_3
    //   258: istore_2
    //   259: iload_1
    //   260: iload_3
    //   261: if_icmpge -98 -> 163
    //   264: aload 6
    //   266: iload_1
    //   267: baload
    //   268: sipush 128
    //   271: if_icmpgt +20 -> 291
    //   274: aload 6
    //   276: iload_1
    //   277: baload
    //   278: ifgt +6 -> 284
    //   281: goto +10 -> 291
    //   284: iload_1
    //   285: iconst_1
    //   286: iadd
    //   287: istore_1
    //   288: goto -31 -> 257
    //   291: iload_1
    //   292: istore_2
    //   293: goto -130 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContext	Context
    //   0	296	1	paramInt	int
    //   170	123	2	i	int
    //   153	109	3	j	int
    //   47	164	4	localObject1	Object
    //   239	7	4	localException1	Exception
    //   252	1	4	localException2	Exception
    //   95	1	5	localObject2	Object
    //   190	44	5	localObject3	Object
    //   92	183	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   147	154	190	finally
    //   163	176	190	finally
    //   100	147	204	finally
    //   11	29	228	java/lang/Exception
    //   29	85	228	java/lang/Exception
    //   100	147	232	java/lang/Exception
    //   147	154	239	java/lang/Exception
    //   163	176	239	java/lang/Exception
    //   176	180	244	java/lang/Exception
    //   183	187	248	java/lang/Exception
    //   221	225	248	java/lang/Exception
    //   210	215	252	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */