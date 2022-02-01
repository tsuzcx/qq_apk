package com.tencent.robolectric;

import java.util.Locale;

class ShadowParcel$ByteBuffer
{
  private static final byte[] a = new byte[0];
  private ShadowParcel.ByteBuffer.FakeEncodedItem[] b;
  private int c;
  private int d;
  private boolean e;
  
  ShadowParcel$ByteBuffer()
  {
    a();
  }
  
  private <T> ShadowParcel.ByteBuffer.FakeEncodedItem a(Class<T> paramClass)
  {
    ShadowParcel.ByteBuffer.FakeEncodedItem localFakeEncodedItem = this.b[this.c];
    if (localFakeEncodedItem != null)
    {
      a(paramClass, localFakeEncodedItem);
      return localFakeEncodedItem;
    }
    paramClass = new StringBuilder();
    paramClass.append("Reading uninitialized data at position ");
    paramClass.append(this.c);
    throw new ShadowParcel.UnreliableBehaviorError(paramClass.toString());
  }
  
  private void a(Class<?> paramClass, ShadowParcel.ByteBuffer.FakeEncodedItem paramFakeEncodedItem)
  {
    int j = this.c;
    int k = paramFakeEncodedItem.sizeBytes;
    int i = this.c;
    while (i < j + k)
    {
      Object localObject;
      if (i < this.d) {
        localObject = this.b[i];
      } else {
        localObject = null;
      }
      if (localObject != paramFakeEncodedItem)
      {
        j = this.c;
        Locale localLocale = Locale.US;
        if (localObject == null) {
          localObject = "uninitialized data or the end of the buffer";
        } else {
          localObject = ((ShadowParcel.ByteBuffer.FakeEncodedItem)localObject).value;
        }
        throw new ShadowParcel.UnreliableBehaviorError(paramClass, j, paramFakeEncodedItem, String.format(localLocale, "but [%s] interrupts it at position %d", new Object[] { localObject, Integer.valueOf(i) }));
      }
      i += 1;
    }
    this.c = Math.min(this.d, this.c + paramFakeEncodedItem.sizeBytes);
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] != 0) {
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean b(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof Number))
    {
      paramObject = (Number)paramObject;
      boolean bool1 = bool2;
      if (paramObject.longValue() == 0L)
      {
        bool1 = bool2;
        if (paramObject.doubleValue() == 0.0D) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      return a(paramObject, 0, paramObject.length);
    }
    return false;
  }
  
  public void a()
  {
    this.b = new ShadowParcel.ByteBuffer.FakeEncodedItem[0];
    this.c = 0;
    this.d = 0;
    this.e = false;
  }
  
  /* Error */
  public byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/robolectric/ShadowParcel$ByteBuffer:c	I
    //   4: istore_1
    //   5: new 121	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 122	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_2
    //   13: new 124	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 127	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_3
    //   22: new 129	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 130	java/util/ArrayList:<init>	()V
    //   29: astore 4
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 28	com/tencent/robolectric/ShadowParcel$ByteBuffer:c	I
    //   36: aload_0
    //   37: getfield 28	com/tencent/robolectric/ShadowParcel$ByteBuffer:c	I
    //   40: aload_0
    //   41: getfield 61	com/tencent/robolectric/ShadowParcel$ByteBuffer:d	I
    //   44: if_icmpge +20 -> 64
    //   47: aload 4
    //   49: aload_0
    //   50: ldc 4
    //   52: invokespecial 132	com/tencent/robolectric/ShadowParcel$ByteBuffer:a	(Ljava/lang/Class;)Lcom/tencent/robolectric/ShadowParcel$ByteBuffer$FakeEncodedItem;
    //   55: invokeinterface 137 2 0
    //   60: pop
    //   61: goto -25 -> 36
    //   64: aload_3
    //   65: aload 4
    //   67: invokeinterface 141 1 0
    //   72: invokevirtual 145	java/io/ObjectOutputStream:writeInt	(I)V
    //   75: aload 4
    //   77: invokeinterface 149 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 155 1 0
    //   91: ifeq +36 -> 127
    //   94: aload 4
    //   96: invokeinterface 159 1 0
    //   101: checkcast 56	com/tencent/robolectric/ShadowParcel$ByteBuffer$FakeEncodedItem
    //   104: astore 5
    //   106: aload_3
    //   107: aload 5
    //   109: getfield 59	com/tencent/robolectric/ShadowParcel$ByteBuffer$FakeEncodedItem:sizeBytes	I
    //   112: invokevirtual 145	java/io/ObjectOutputStream:writeInt	(I)V
    //   115: aload_3
    //   116: aload 5
    //   118: getfield 73	com/tencent/robolectric/ShadowParcel$ByteBuffer$FakeEncodedItem:value	Ljava/lang/Object;
    //   121: invokevirtual 163	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   124: goto -40 -> 84
    //   127: aload_3
    //   128: invokevirtual 166	java/io/ObjectOutputStream:flush	()V
    //   131: aload_2
    //   132: invokevirtual 169	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   135: astore_2
    //   136: aload_0
    //   137: iload_1
    //   138: putfield 28	com/tencent/robolectric/ShadowParcel$ByteBuffer:c	I
    //   141: aload_2
    //   142: areturn
    //   143: astore_2
    //   144: goto +15 -> 159
    //   147: astore_2
    //   148: new 45	com/tencent/robolectric/ShadowParcel$UnreliableBehaviorError
    //   151: dup
    //   152: ldc 171
    //   154: aload_2
    //   155: invokespecial 174	com/tencent/robolectric/ShadowParcel$UnreliableBehaviorError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: aload_0
    //   160: iload_1
    //   161: putfield 28	com/tencent/robolectric/ShadowParcel$ByteBuffer:c	I
    //   164: goto +5 -> 169
    //   167: aload_2
    //   168: athrow
    //   169: goto -2 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	ByteBuffer
    //   4	157	1	i	int
    //   12	130	2	localObject1	Object
    //   143	1	2	localObject2	Object
    //   147	21	2	localIOException	java.io.IOException
    //   21	107	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   29	66	4	localObject3	Object
    //   104	13	5	localFakeEncodedItem	ShadowParcel.ByteBuffer.FakeEncodedItem
    // Exception table:
    //   from	to	target	type
    //   5	36	143	finally
    //   36	61	143	finally
    //   64	84	143	finally
    //   84	124	143	finally
    //   127	136	143	finally
    //   148	159	143	finally
    //   5	36	147	java/io/IOException
    //   36	61	147	java/io/IOException
    //   64	84	147	java/io/IOException
    //   84	124	147	java/io/IOException
    //   127	136	147	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */