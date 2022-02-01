package com.tencent.qqmini.sdk.monitor.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool
{
  protected static final Comparator<byte[]> BUF_COMPARATOR = new ByteArrayPool.1();
  private static ByteArrayPool genericInstance = new ByteArrayPool(102400);
  private static ByteArrayPool maxBufPoolInstance;
  private List<byte[]> mBuffersByLastUse = new LinkedList();
  private List<byte[]> mBuffersBySize = new ArrayList(64);
  private int mCurrentSize = 0;
  private final int mSizeLimit;
  
  public ByteArrayPool(int paramInt)
  {
    this.mSizeLimit = paramInt;
  }
  
  public static ByteArrayPool getGenericInstance()
  {
    return genericInstance;
  }
  
  public static ByteArrayPool getMaxBufInstance()
  {
    if (maxBufPoolInstance == null) {}
    try
    {
      if (maxBufPoolInstance == null) {
        maxBufPoolInstance = new ByteArrayPool(1024000);
      }
      return maxBufPoolInstance;
    }
    finally {}
  }
  
  private void trim()
  {
    try
    {
      if (this.mCurrentSize > this.mSizeLimit)
      {
        byte[] arrayOfByte = (byte[])this.mBuffersByLastUse.remove(0);
        this.mBuffersBySize.remove(arrayOfByte);
        this.mCurrentSize -= arrayOfByte.length;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public byte[] getBuf(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 44	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersBySize	Ljava/util/List;
    //   9: invokeinterface 72 1 0
    //   14: if_icmpge +67 -> 81
    //   17: aload_0
    //   18: getfield 44	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersBySize	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 75 2 0
    //   27: checkcast 63	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 46	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mCurrentSize	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 46	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mCurrentSize	I
    //   48: aload_0
    //   49: getfield 44	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersBySize	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 61 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 39	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersByLastUse	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 66 2 0
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -74 -> 4
    //   81: iload_1
    //   82: newarray byte
    //   84: astore_3
    //   85: goto -15 -> 70
    //   88: astore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	ByteArrayPool
    //   0	93	1	paramInt	int
    //   3	75	2	i	int
    //   30	55	3	arrayOfByte	byte[]
    //   88	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	88	finally
    //   81	85	88	finally
  }
  
  /* Error */
  public void returnBuf(byte[] paramArrayOfByte)
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
    //   10: getfield 48	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mSizeLimit	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 39	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersByLastUse	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 80 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 44	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersBySize	Ljava/util/List;
    //   37: aload_1
    //   38: getstatic 26	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:BUF_COMPARATOR	Ljava/util/Comparator;
    //   41: invokestatic 86	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: iload_3
    //   48: ifge +8 -> 56
    //   51: iload_3
    //   52: ineg
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 44	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mBuffersBySize	Ljava/util/List;
    //   60: iload_2
    //   61: aload_1
    //   62: invokeinterface 89 3 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 46	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mCurrentSize	I
    //   72: aload_1
    //   73: arraylength
    //   74: iadd
    //   75: putfield 46	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:mCurrentSize	I
    //   78: aload_0
    //   79: invokespecial 91	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:trim	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ByteArrayPool
    //   0	90	1	paramArrayOfByte	byte[]
    //   8	53	2	i	int
    //   13	39	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	85	finally
    //   22	45	85	finally
    //   56	82	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */