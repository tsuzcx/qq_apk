package com.tencent.tmassistantsdk.internal.a;

public class b
{
  protected static final String a = b.class.getSimpleName();
  
  /* Error */
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 16	com/tencent/tmassistantsdk/internal/a/b:a	Ljava/lang/String;
    //   5: astore 14
    //   7: new 23	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   14: ldc 26
    //   16: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 32
    //   25: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 37
    //   34: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_3
    //   38: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 39
    //   43: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 4
    //   48: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc 41
    //   53: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 43
    //   63: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: lload 6
    //   68: invokevirtual 46	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc 48
    //   73: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload 8
    //   78: invokevirtual 46	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc 50
    //   83: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload 10
    //   88: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc 52
    //   93: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: astore 15
    //   98: aload 11
    //   100: ifnonnull +63 -> 163
    //   103: ldc 54
    //   105: astore 13
    //   107: aload 14
    //   109: aload 15
    //   111: aload 13
    //   113: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: new 68	com/tencent/tmassistantsdk/internal/a/c
    //   125: dup
    //   126: aload_1
    //   127: iload_2
    //   128: aload_3
    //   129: iload 4
    //   131: aload 5
    //   133: lload 6
    //   135: lload 8
    //   137: iload 10
    //   139: aload 11
    //   141: invokespecial 71	com/tencent/tmassistantsdk/internal/a/c:<init>	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JJI[B)V
    //   144: astore_1
    //   145: new 73	com/tencent/tmassistantsdk/internal/a/a
    //   148: dup
    //   149: invokespecial 74	com/tencent/tmassistantsdk/internal/a/a:<init>	()V
    //   152: aload_1
    //   153: invokevirtual 77	com/tencent/tmassistantsdk/internal/a/a:a	(Lcom/tencent/tmassistantsdk/internal/a/c;)J
    //   156: lstore 6
    //   158: aload_0
    //   159: monitorexit
    //   160: lload 6
    //   162: lreturn
    //   163: aload 11
    //   165: arraylength
    //   166: istore 12
    //   168: iload 12
    //   170: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: astore 13
    //   175: goto -68 -> 107
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	b
    //   0	183	1	paramString1	String
    //   0	183	2	paramInt1	int
    //   0	183	3	paramString2	String
    //   0	183	4	paramInt2	int
    //   0	183	5	paramString3	String
    //   0	183	6	paramLong1	long
    //   0	183	8	paramLong2	long
    //   0	183	10	paramInt3	int
    //   0	183	11	paramArrayOfByte	byte[]
    //   166	3	12	i	int
    //   105	69	13	localObject	Object
    //   5	103	14	str	String
    //   96	14	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	98	178	finally
    //   107	158	178	finally
    //   163	168	178	finally
  }
  
  /* Error */
  public java.util.ArrayList<c> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 73	com/tencent/tmassistantsdk/internal/a/a
    //   5: dup
    //   6: invokespecial 74	com/tencent/tmassistantsdk/internal/a/a:<init>	()V
    //   9: invokevirtual 86	com/tencent/tmassistantsdk/internal/a/a:a	()Ljava/util/ArrayList;
    //   12: astore_3
    //   13: getstatic 16	com/tencent/tmassistantsdk/internal/a/b:a	Ljava/lang/String;
    //   16: astore 4
    //   18: new 23	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   25: ldc 88
    //   27: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 5
    //   32: aload_3
    //   33: ifnonnull +24 -> 57
    //   36: ldc 54
    //   38: astore_2
    //   39: aload 4
    //   41: aload 5
    //   43: aload_2
    //   44: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: areturn
    //   57: aload_3
    //   58: invokevirtual 94	java/util/ArrayList:size	()I
    //   61: istore_1
    //   62: iload_1
    //   63: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: astore_2
    //   67: goto -28 -> 39
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	b
    //   61	2	1	i	int
    //   38	29	2	localObject1	Object
    //   70	4	2	localObject2	Object
    //   12	46	3	localArrayList	java.util.ArrayList
    //   16	24	4	str	String
    //   30	12	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	32	70	finally
    //   39	53	70	finally
    //   57	62	70	finally
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 16	com/tencent/tmassistantsdk/internal/a/b:a	Ljava/lang/String;
    //   5: new 23	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   12: ldc 99
    //   14: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 46	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifge +17 -> 47
    //   33: getstatic 16	com/tencent/tmassistantsdk/internal/a/b:a	Ljava/lang/String;
    //   36: ldc 101
    //   38: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: istore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_3
    //   46: ireturn
    //   47: new 73	com/tencent/tmassistantsdk/internal/a/a
    //   50: dup
    //   51: invokespecial 74	com/tencent/tmassistantsdk/internal/a/a:<init>	()V
    //   54: lload_1
    //   55: invokevirtual 103	com/tencent/tmassistantsdk/internal/a/a:a	(J)Z
    //   58: istore_3
    //   59: getstatic 16	com/tencent/tmassistantsdk/internal/a/b:a	Ljava/lang/String;
    //   62: new 23	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   69: ldc 105
    //   71: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_3
    //   75: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   78: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 66	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: goto -41 -> 43
    //   87: astore 4
    //   89: aload_0
    //   90: monitorexit
    //   91: aload 4
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	b
    //   0	94	1	paramLong	long
    //   42	33	3	bool	boolean
    //   87	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	87	finally
    //   33	41	87	finally
    //   47	84	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.a.b
 * JD-Core Version:    0.7.0.1
 */