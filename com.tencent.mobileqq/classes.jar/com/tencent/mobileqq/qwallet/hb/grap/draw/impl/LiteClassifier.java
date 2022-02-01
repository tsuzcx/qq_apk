package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import java.lang.reflect.Array;
import java.util.List;
import org.tensorflow.lite.Interpreter;

public abstract class LiteClassifier
{
  protected Interpreter a;
  public List<String> b;
  
  /* Error */
  public LiteClassifier(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 18	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 19	java/util/ArrayList:<init>	()V
    //   12: putfield 21	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LiteClassifier:b	Ljava/util/List;
    //   15: aload_0
    //   16: new 23	org/tensorflow/lite/Interpreter
    //   19: dup
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 26	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LiteClassifier:a	(Ljava/lang/String;)Ljava/nio/MappedByteBuffer;
    //   25: invokespecial 29	org/tensorflow/lite/Interpreter:<init>	(Ljava/nio/MappedByteBuffer;)V
    //   28: putfield 31	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LiteClassifier:a	Lorg/tensorflow/lite/Interpreter;
    //   31: aload_2
    //   32: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +83 -> 118
    //   38: new 39	java/io/File
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 46	java/io/File:exists	()Z
    //   49: ifeq +69 -> 118
    //   52: new 48	java/io/BufferedReader
    //   55: dup
    //   56: new 50	java/io/FileReader
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 51	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   64: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 58	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +26 -> 100
    //   77: aload_2
    //   78: ldc 60
    //   80: invokevirtual 66	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   83: iconst_0
    //   84: aaload
    //   85: astore_2
    //   86: aload_0
    //   87: getfield 21	com/tencent/mobileqq/qwallet/hb/grap/draw/impl/LiteClassifier:b	Ljava/util/List;
    //   90: aload_2
    //   91: invokeinterface 72 2 0
    //   96: pop
    //   97: goto -29 -> 68
    //   100: aload_1
    //   101: invokevirtual 75	java/io/BufferedReader:close	()V
    //   104: return
    //   105: astore_2
    //   106: goto +6 -> 112
    //   109: astore_2
    //   110: aload_2
    //   111: athrow
    //   112: aload_1
    //   113: invokevirtual 75	java/io/BufferedReader:close	()V
    //   116: aload_2
    //   117: athrow
    //   118: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	LiteClassifier
    //   0	119	1	paramString1	String
    //   0	119	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   68	73	105	finally
    //   77	97	105	finally
    //   110	112	105	finally
    //   68	73	109	java/lang/Throwable
    //   77	97	109	java/lang/Throwable
  }
  
  /* Error */
  private java.nio.MappedByteBuffer a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: new 39	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 9
    //   22: new 78	java/io/FileInputStream
    //   25: dup
    //   26: aload 9
    //   28: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore 5
    //   33: aload 8
    //   35: astore_1
    //   36: aload 7
    //   38: astore 4
    //   40: aload 5
    //   42: invokevirtual 85	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   45: astore 6
    //   47: aload 6
    //   49: astore_1
    //   50: aload 6
    //   52: astore 4
    //   54: aload 9
    //   56: invokevirtual 89	java/io/File:length	()J
    //   59: lstore_2
    //   60: aload 6
    //   62: astore_1
    //   63: aload 6
    //   65: astore 4
    //   67: aload 6
    //   69: getstatic 95	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   72: lconst_0
    //   73: lload_2
    //   74: invokevirtual 101	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   77: astore 7
    //   79: aload 6
    //   81: ifnull +8 -> 89
    //   84: aload 6
    //   86: invokevirtual 102	java/nio/channels/FileChannel:close	()V
    //   89: aload 5
    //   91: invokevirtual 103	java/io/FileInputStream:close	()V
    //   94: aload 7
    //   96: areturn
    //   97: astore 4
    //   99: goto +57 -> 156
    //   102: astore 6
    //   104: aload 5
    //   106: astore_1
    //   107: aload 6
    //   109: astore 5
    //   111: goto +26 -> 137
    //   114: astore 6
    //   116: aconst_null
    //   117: astore 5
    //   119: aload 4
    //   121: astore_1
    //   122: aload 6
    //   124: astore 4
    //   126: goto +30 -> 156
    //   129: astore 5
    //   131: aconst_null
    //   132: astore 4
    //   134: aload 6
    //   136: astore_1
    //   137: aload 5
    //   139: athrow
    //   140: astore 7
    //   142: aload 4
    //   144: astore 6
    //   146: aload_1
    //   147: astore 5
    //   149: aload 7
    //   151: astore 4
    //   153: aload 6
    //   155: astore_1
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 102	java/nio/channels/FileChannel:close	()V
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 103	java/io/FileInputStream:close	()V
    //   174: aload 4
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	LiteClassifier
    //   0	177	1	paramString	String
    //   59	15	2	l	long
    //   7	59	4	localObject1	Object
    //   97	23	4	localObject2	Object
    //   124	51	4	localObject3	Object
    //   31	87	5	localObject4	Object
    //   129	9	5	localThrowable1	Throwable
    //   147	23	5	str	String
    //   4	81	6	localFileChannel	java.nio.channels.FileChannel
    //   102	6	6	localThrowable2	Throwable
    //   114	21	6	localObject5	Object
    //   144	10	6	localObject6	Object
    //   1	94	7	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   140	10	7	localObject7	Object
    //   10	24	8	localObject8	Object
    //   20	35	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   40	47	97	finally
    //   54	60	97	finally
    //   67	79	97	finally
    //   40	47	102	java/lang/Throwable
    //   54	60	102	java/lang/Throwable
    //   67	79	102	java/lang/Throwable
    //   12	33	114	finally
    //   12	33	129	java/lang/Throwable
    //   137	140	140	finally
  }
  
  public abstract String a();
  
  public abstract boolean a(DoodleItem paramDoodleItem, String paramString, float paramFloat1, int paramInt, float paramFloat2);
  
  public float[] a(float[][][][] paramArrayOfFloat)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (float[][])Array.newInstance(Float.TYPE, new int[] { 1, this.b.size() });
      this.a.run(paramArrayOfFloat, localObject);
      return localObject[0];
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      if (this.a != null) {
        this.a.close();
      }
      this.b.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LiteClassifier
 * JD-Core Version:    0.7.0.1
 */