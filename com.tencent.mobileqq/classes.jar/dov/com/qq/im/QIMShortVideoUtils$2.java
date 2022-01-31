package dov.com.qq.im;

import android.content.Context;

public final class QIMShortVideoUtils$2
  implements Runnable
{
  public QIMShortVideoUtils$2(Context paramContext, String paramString, Runnable paramRunnable) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 14	dov/com/qq/im/QIMShortVideoUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6: invokestatic 32	bkjr:a	(Landroid/content/Context;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: invokestatic 38	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   16: ldc 40
    //   18: iconst_4
    //   19: invokevirtual 44	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore 7
    //   24: iload_2
    //   25: istore_1
    //   26: aload 7
    //   28: ifnull +100 -> 128
    //   31: iload_2
    //   32: istore_1
    //   33: aload 7
    //   35: ldc 46
    //   37: iconst_1
    //   38: invokeinterface 52 3 0
    //   43: ifne +85 -> 128
    //   46: aload 7
    //   48: ldc 54
    //   50: lconst_0
    //   51: invokeinterface 58 4 0
    //   56: lstore_3
    //   57: aload 7
    //   59: ldc 60
    //   61: ldc 61
    //   63: invokeinterface 65 3 0
    //   68: istore_1
    //   69: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: lload_3
    //   75: lconst_0
    //   76: lcmp
    //   77: ifle +151 -> 228
    //   80: iload_1
    //   81: ifle +147 -> 228
    //   84: lload 5
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +140 -> 228
    //   91: lload 5
    //   93: lload_3
    //   94: lsub
    //   95: iload_1
    //   96: sipush 1000
    //   99: imul
    //   100: i2l
    //   101: lcmp
    //   102: ifle +126 -> 228
    //   105: aload 7
    //   107: invokeinterface 75 1 0
    //   112: ldc 46
    //   114: iconst_1
    //   115: invokeinterface 81 3 0
    //   120: invokeinterface 85 1 0
    //   125: pop
    //   126: iload_2
    //   127: istore_1
    //   128: iload_1
    //   129: istore_2
    //   130: iload_2
    //   131: ifeq -119 -> 12
    //   134: getstatic 90	bilx:a	Lasot;
    //   137: ifnonnull +42 -> 179
    //   140: aload_0
    //   141: getfield 16	dov/com/qq/im/QIMShortVideoUtils$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: astore 8
    //   146: aload 8
    //   148: astore 7
    //   150: aload 8
    //   152: ifnonnull +7 -> 159
    //   155: ldc 92
    //   157: astore 7
    //   159: new 94	asot
    //   162: dup
    //   163: aload 7
    //   165: ldc 96
    //   167: invokespecial 99	asot:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: putstatic 90	bilx:a	Lasot;
    //   173: getstatic 90	bilx:a	Lasot;
    //   176: invokevirtual 101	asot:a	()V
    //   179: new 103	android/content/Intent
    //   182: dup
    //   183: aload_0
    //   184: getfield 14	dov/com/qq/im/QIMShortVideoUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   187: ldc 105
    //   189: invokespecial 108	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   192: astore 7
    //   194: aload 7
    //   196: ldc 110
    //   198: iconst_2
    //   199: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   202: pop
    //   203: aload_0
    //   204: getfield 14	dov/com/qq/im/QIMShortVideoUtils$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   207: aload 7
    //   209: invokevirtual 120	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   212: pop
    //   213: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq -204 -> 12
    //   219: ldc 127
    //   221: iconst_2
    //   222: ldc 129
    //   224: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: return
    //   228: ldc 127
    //   230: iconst_1
    //   231: ldc 135
    //   233: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: iconst_0
    //   237: istore_1
    //   238: invokestatic 38	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   241: astore 7
    //   243: invokestatic 139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   246: invokestatic 144	azmz:a	(Landroid/content/Context;)Lazmz;
    //   249: aload 7
    //   251: invokevirtual 148	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   254: invokevirtual 154	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   257: ldc 156
    //   259: iconst_1
    //   260: lconst_0
    //   261: lconst_0
    //   262: aconst_null
    //   263: ldc 158
    //   265: invokevirtual 161	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   268: iconst_0
    //   269: istore_1
    //   270: goto -142 -> 128
    //   273: astore 7
    //   275: iconst_1
    //   276: istore_1
    //   277: iload_1
    //   278: istore_2
    //   279: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -152 -> 130
    //   285: ldc 127
    //   287: iconst_2
    //   288: new 163	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   295: ldc 166
    //   297: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 7
    //   302: invokevirtual 174	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   305: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: iload_1
    //   315: istore_2
    //   316: goto -186 -> 130
    //   319: astore 7
    //   321: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -111 -> 213
    //   327: ldc 127
    //   329: iconst_2
    //   330: new 163	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   337: ldc 182
    //   339: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 7
    //   344: invokevirtual 183	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   347: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: goto -143 -> 213
    //   359: astore 7
    //   361: goto -84 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	2
    //   25	290	1	i	int
    //   1	315	2	j	int
    //   56	38	3	l1	long
    //   72	20	5	l2	long
    //   22	228	7	localObject	Object
    //   273	28	7	localException1	java.lang.Exception
    //   319	24	7	localThrowable	java.lang.Throwable
    //   359	1	7	localException2	java.lang.Exception
    //   144	7	8	str	String
    // Exception table:
    //   from	to	target	type
    //   13	24	273	java/lang/Exception
    //   33	74	273	java/lang/Exception
    //   105	126	273	java/lang/Exception
    //   228	236	273	java/lang/Exception
    //   203	213	319	java/lang/Throwable
    //   238	268	359	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMShortVideoUtils.2
 * JD-Core Version:    0.7.0.1
 */