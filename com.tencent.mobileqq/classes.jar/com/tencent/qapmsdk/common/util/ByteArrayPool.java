package com.tencent.qapmsdk.common.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ByteArrayPool;", "", "sizeLimit", "", "(I)V", "buffersByLastUse", "Ljava/util/LinkedList;", "", "buffersBySize", "Ljava/util/ArrayList;", "currentSize", "getBuf", "len", "returnBuf", "", "buf", "trim", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ByteArrayPool
{
  private static final Comparator<byte[]> BUF_COMPARATOR = (Comparator)ByteArrayPool.Companion.BUF_COMPARATOR.1.INSTANCE;
  public static final ByteArrayPool.Companion Companion = new ByteArrayPool.Companion(null);
  @NotNull
  private static ByteArrayPool genericInstance = new ByteArrayPool(102400);
  private final LinkedList<byte[]> buffersByLastUse;
  private final ArrayList<byte[]> buffersBySize;
  private int currentSize;
  private final int sizeLimit;
  
  public ByteArrayPool(int paramInt)
  {
    this.sizeLimit = paramInt;
    this.buffersByLastUse = new LinkedList();
    this.buffersBySize = new ArrayList(64);
  }
  
  @NotNull
  public static final ByteArrayPool getGenericInstance()
  {
    ByteArrayPool.Companion localCompanion = Companion;
    return genericInstance;
  }
  
  public static final void setGenericInstance(@NotNull ByteArrayPool paramByteArrayPool)
  {
    ByteArrayPool.Companion localCompanion = Companion;
    genericInstance = paramByteArrayPool;
  }
  
  private final void trim()
  {
    try
    {
      if (this.currentSize > this.sizeLimit)
      {
        Object localObject1 = this.buffersByLastUse.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffersByLastUse.removeAt(0)");
        localObject1 = (byte[])localObject1;
        this.buffersBySize.remove(localObject1);
        this.currentSize -= localObject1.length;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @NotNull
  public final byte[] getBuf(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 80	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersBySize	Ljava/util/ArrayList;
    //   8: checkcast 110	java/util/Collection
    //   11: invokeinterface 114 1 0
    //   16: istore_3
    //   17: iload_2
    //   18: iload_3
    //   19: if_icmpge +77 -> 96
    //   22: aload_0
    //   23: getfield 80	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersBySize	Ljava/util/ArrayList;
    //   26: iload_2
    //   27: invokevirtual 117	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 119
    //   36: invokestatic 102	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   39: aload 4
    //   41: checkcast 104	[B
    //   44: astore 4
    //   46: aload 4
    //   48: arraylength
    //   49: iload_1
    //   50: if_icmplt +39 -> 89
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 90	com/tencent/qapmsdk/common/util/ByteArrayPool:currentSize	I
    //   58: aload 4
    //   60: arraylength
    //   61: isub
    //   62: putfield 90	com/tencent/qapmsdk/common/util/ByteArrayPool:currentSize	I
    //   65: aload_0
    //   66: getfield 80	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersBySize	Ljava/util/ArrayList;
    //   69: iload_2
    //   70: invokevirtual 120	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: getfield 75	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersByLastUse	Ljava/util/LinkedList;
    //   78: aload 4
    //   80: invokevirtual 121	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: aload 4
    //   88: areturn
    //   89: iload_2
    //   90: iconst_1
    //   91: iadd
    //   92: istore_2
    //   93: goto -76 -> 17
    //   96: iload_1
    //   97: newarray byte
    //   99: astore 4
    //   101: goto -17 -> 84
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ByteArrayPool
    //   0	111	1	paramInt	int
    //   3	90	2	i	int
    //   16	4	3	j	int
    //   30	70	4	localObject1	Object
    //   104	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	104	finally
    //   22	84	104	finally
    //   96	101	104	finally
  }
  
  /* Error */
  public final void returnBuf(@org.jetbrains.annotations.Nullable byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 70	com/tencent/qapmsdk/common/util/ByteArrayPool:sizeLimit	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 75	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersByLastUse	Ljava/util/LinkedList;
    //   26: aload_1
    //   27: invokevirtual 126	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 80	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersBySize	Ljava/util/ArrayList;
    //   35: checkcast 128	java/util/List
    //   38: aload_1
    //   39: getstatic 60	com/tencent/qapmsdk/common/util/ByteArrayPool:BUF_COMPARATOR	Ljava/util/Comparator;
    //   42: invokestatic 134	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   45: istore_3
    //   46: iload_3
    //   47: istore_2
    //   48: iload_3
    //   49: ifge +8 -> 57
    //   52: iload_3
    //   53: ineg
    //   54: iconst_1
    //   55: isub
    //   56: istore_2
    //   57: aload_0
    //   58: getfield 80	com/tencent/qapmsdk/common/util/ByteArrayPool:buffersBySize	Ljava/util/ArrayList;
    //   61: iload_2
    //   62: aload_1
    //   63: invokevirtual 137	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 90	com/tencent/qapmsdk/common/util/ByteArrayPool:currentSize	I
    //   71: aload_1
    //   72: arraylength
    //   73: iadd
    //   74: putfield 90	com/tencent/qapmsdk/common/util/ByteArrayPool:currentSize	I
    //   77: aload_0
    //   78: invokespecial 139	com/tencent/qapmsdk/common/util/ByteArrayPool:trim	()V
    //   81: goto -62 -> 19
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ByteArrayPool
    //   0	89	1	paramArrayOfByte	byte[]
    //   8	54	2	i	int
    //   13	40	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	84	finally
    //   22	46	84	finally
    //   57	81	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */