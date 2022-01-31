package com.tencent.qphone.base.util;

import android.os.Handler;
import android.os.Looper;

class QLog$c
  extends Handler
{
  public QLog$c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message arg1)
  {
    // Byte code:
    //   0: ldc2_w 14
    //   3: lstore 4
    //   5: aload_1
    //   6: getfield 21	android/os/Message:what	I
    //   9: tableswitch	default:+27 -> 36, 1:+28->37, 2:+241->250, 3:+62->71
    //   37: ldc 23
    //   39: ldc 25
    //   41: invokestatic 31	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   48: invokestatic 43	com/tencent/qphone/base/util/QLog:initLogFile	(J)V
    //   51: iconst_0
    //   52: invokestatic 47	com/tencent/qphone/base/util/QLog:access$002	(I)I
    //   55: pop
    //   56: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   59: iconst_2
    //   60: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   63: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   66: iconst_2
    //   67: invokevirtual 59	com/tencent/qphone/base/util/QLog$c:sendEmptyMessage	(I)Z
    //   70: pop
    //   71: invokestatic 63	com/tencent/qphone/base/util/QLog:access$000	()I
    //   74: ifle -38 -> 36
    //   77: ldc 23
    //   79: ldc 65
    //   81: invokestatic 31	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: invokestatic 69	com/tencent/qphone/base/util/QLog:access$200	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload_1
    //   90: monitorenter
    //   91: aconst_null
    //   92: invokestatic 73	com/tencent/qphone/base/util/QLog:access$402	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
    //   95: invokestatic 76	com/tencent/qphone/base/util/QLog:access$302	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
    //   98: pop
    //   99: aload_1
    //   100: monitorexit
    //   101: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   104: iconst_3
    //   105: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   108: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   111: iconst_3
    //   112: ldc2_w 14
    //   115: invokevirtual 80	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
    //   118: pop
    //   119: return
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   125: invokestatic 63	com/tencent/qphone/base/util/QLog:access$000	()I
    //   128: istore_2
    //   129: ldc 23
    //   131: new 86	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   138: ldc 25
    //   140: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload_2
    //   144: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc 97
    //   149: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokestatic 101	com/tencent/qphone/base/util/QLog:access$100	()[I
    //   155: iload_2
    //   156: iaload
    //   157: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 31	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   170: iconst_1
    //   171: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   174: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   177: iconst_1
    //   178: invokestatic 101	com/tencent/qphone/base/util/QLog:access$100	()[I
    //   181: iload_2
    //   182: iaload
    //   183: ldc 105
    //   185: imul
    //   186: i2l
    //   187: invokevirtual 80	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
    //   190: pop
    //   191: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   194: iconst_3
    //   195: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   198: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   201: astore_1
    //   202: invokestatic 63	com/tencent/qphone/base/util/QLog:access$000	()I
    //   205: ifne +8 -> 213
    //   208: ldc2_w 106
    //   211: lstore 4
    //   213: aload_1
    //   214: iconst_3
    //   215: lload 4
    //   217: invokevirtual 80	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
    //   220: pop
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_3
    //   225: iload_3
    //   226: istore_2
    //   227: iload_3
    //   228: invokestatic 101	com/tencent/qphone/base/util/QLog:access$100	()[I
    //   231: arraylength
    //   232: if_icmplt +5 -> 237
    //   235: iconst_1
    //   236: istore_2
    //   237: iload_2
    //   238: invokestatic 47	com/tencent/qphone/base/util/QLog:access$002	(I)I
    //   241: pop
    //   242: return
    //   243: astore 6
    //   245: aload_1
    //   246: monitorexit
    //   247: aload 6
    //   249: athrow
    //   250: invokestatic 111	com/tencent/qphone/base/util/QLog:access$500	()Z
    //   253: ifeq +22 -> 275
    //   256: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   259: iconst_1
    //   260: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   263: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   266: iconst_1
    //   267: ldc2_w 112
    //   270: invokevirtual 80	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
    //   273: pop
    //   274: return
    //   275: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   278: iconst_2
    //   279: invokevirtual 55	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
    //   282: getstatic 51	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
    //   285: iconst_2
    //   286: ldc2_w 112
    //   289: invokevirtual 80	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
    //   292: pop
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	c
    //   128	110	2	i	int
    //   224	9	3	j	int
    //   3	213	4	l	long
    //   243	5	6	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   37	71	120	java/lang/Throwable
    //   91	101	243	finally
    //   245	247	243	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog.c
 * JD-Core Version:    0.7.0.1
 */