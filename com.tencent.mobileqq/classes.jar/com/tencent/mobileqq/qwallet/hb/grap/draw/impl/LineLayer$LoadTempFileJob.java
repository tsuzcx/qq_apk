package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class LineLayer$LoadTempFileJob
  implements Runnable
{
  private WeakReference<LoadTempFileJobListener> a;
  private int b;
  private Map<Integer, String> c = new HashMap();
  private int d = -1;
  
  public LineLayer$LoadTempFileJob(int paramInt1, Map<Integer, String> paramMap, int paramInt2, LoadTempFileJobListener paramLoadTempFileJobListener)
  {
    Object localObject;
    this.a = new WeakReference(localObject);
    this.b = paramMap;
    this.c.putAll(paramInt2);
    this.d = paramLoadTempFileJobListener;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 29	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:c	Ljava/util/Map;
    //   9: aload_0
    //   10: getfield 40	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:b	I
    //   13: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 66 2 0
    //   21: checkcast 68	java/lang/String
    //   24: astore 5
    //   26: aload 5
    //   28: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +84 -> 115
    //   34: aload_0
    //   35: getfield 29	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:c	Ljava/util/Map;
    //   38: invokeinterface 78 1 0
    //   43: invokeinterface 84 1 0
    //   48: astore 4
    //   50: iconst_0
    //   51: istore_1
    //   52: aload 4
    //   54: invokeinterface 90 1 0
    //   59: ifeq +35 -> 94
    //   62: aload 4
    //   64: invokeinterface 94 1 0
    //   69: checkcast 58	java/lang/Integer
    //   72: invokevirtual 98	java/lang/Integer:intValue	()I
    //   75: istore_2
    //   76: iload_2
    //   77: iload_1
    //   78: if_icmple -26 -> 52
    //   81: iload_2
    //   82: aload_0
    //   83: getfield 40	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:b	I
    //   86: if_icmpgt -34 -> 52
    //   89: iload_2
    //   90: istore_1
    //   91: goto -39 -> 52
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:c	Ljava/util/Map;
    //   98: iload_1
    //   99: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: invokeinterface 66 2 0
    //   107: checkcast 68	java/lang/String
    //   110: astore 5
    //   112: goto +8 -> 120
    //   115: aload_0
    //   116: getfield 40	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob:b	I
    //   119: istore_1
    //   120: aload 6
    //   122: astore 4
    //   124: iload_3
    //   125: istore_2
    //   126: aload 5
    //   128: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +110 -> 241
    //   134: aload 6
    //   136: astore 4
    //   138: iload_3
    //   139: istore_2
    //   140: iload_1
    //   141: ifeq +100 -> 241
    //   144: aload 5
    //   146: invokestatic 104	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   149: astore 4
    //   151: iload_1
    //   152: istore_2
    //   153: goto +88 -> 241
    //   156: aload 6
    //   158: astore 4
    //   160: iload_3
    //   161: istore_2
    //   162: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +76 -> 241
    //   168: ldc 111
    //   170: iconst_2
    //   171: ldc 113
    //   173: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 6
    //   178: astore 4
    //   180: iload_3
    //   181: istore_2
    //   182: goto +59 -> 241
    //   185: astore 5
    //   187: aload 6
    //   189: astore 4
    //   191: iload_3
    //   192: istore_2
    //   193: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +45 -> 241
    //   199: new 119	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   206: astore 4
    //   208: aload 4
    //   210: ldc 122
    //   212: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: aload 5
    //   220: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 111
    //   226: iconst_2
    //   227: aload 4
    //   229: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iload_3
    //   236: istore_2
    //   237: aload 6
    //   239: astore 4
    //   241: new 135	android/os/Handler
    //   244: dup
    //   245: invokestatic 141	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   248: invokespecial 144	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   251: new 146	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob$1
    //   254: dup
    //   255: aload_0
    //   256: iload_2
    //   257: aload 4
    //   259: invokespecial 149	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob$1:<init>	(Lcom/tencent/mobileqq/qwallet/hb/grap/draw/impl/LineLayer$LoadTempFileJob;ILandroid/graphics/Bitmap;)V
    //   262: invokevirtual 153	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   265: pop
    //   266: return
    //   267: astore 4
    //   269: goto -113 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	LoadTempFileJob
    //   51	101	1	i	int
    //   75	182	2	j	int
    //   4	232	3	k	int
    //   48	210	4	localObject1	Object
    //   267	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   24	121	5	str	String
    //   185	34	5	localException	java.lang.Exception
    //   1	237	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	50	185	java/lang/Exception
    //   52	76	185	java/lang/Exception
    //   81	89	185	java/lang/Exception
    //   94	112	185	java/lang/Exception
    //   115	120	185	java/lang/Exception
    //   126	134	185	java/lang/Exception
    //   144	151	185	java/lang/Exception
    //   5	50	267	java/lang/OutOfMemoryError
    //   52	76	267	java/lang/OutOfMemoryError
    //   81	89	267	java/lang/OutOfMemoryError
    //   94	112	267	java/lang/OutOfMemoryError
    //   115	120	267	java/lang/OutOfMemoryError
    //   126	134	267	java/lang/OutOfMemoryError
    //   144	151	267	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.LoadTempFileJob
 * JD-Core Version:    0.7.0.1
 */