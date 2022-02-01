package com.tencent.qapmsdk.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
      while (this.currentSize > this.sizeLimit)
      {
        Object localObject1 = this.buffersByLastUse.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffersByLastUse.removeAt(0)");
        localObject1 = (byte[])localObject1;
        this.buffersBySize.remove(localObject1);
        this.currentSize -= localObject1.length;
      }
      return;
    }
    finally
    {
      localObject2 = finally;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @NotNull
  public final byte[] getBuf(int paramInt)
  {
    int i = 0;
    try
    {
      int j = ((Collection)this.buffersBySize).size();
      while (i < j)
      {
        localObject1 = this.buffersBySize.get(i);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffersBySize[i]");
        localObject1 = (byte[])localObject1;
        if (localObject1.length >= paramInt)
        {
          this.currentSize -= localObject1.length;
          this.buffersBySize.remove(i);
          this.buffersByLastUse.remove(localObject1);
          return localObject1;
        }
        i += 1;
      }
      Object localObject1 = new byte[paramInt];
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void returnBuf(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        int i = paramArrayOfByte.length;
        int j = this.sizeLimit;
        if (i > j) {
          return;
        }
        this.buffersByLastUse.add(paramArrayOfByte);
        j = Collections.binarySearch((List)this.buffersBySize, paramArrayOfByte, BUF_COMPARATOR);
        i = j;
        if (j < 0) {
          i = -j - 1;
        }
        this.buffersBySize.add(i, paramArrayOfByte);
        this.currentSize += paramArrayOfByte.length;
        trim();
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */