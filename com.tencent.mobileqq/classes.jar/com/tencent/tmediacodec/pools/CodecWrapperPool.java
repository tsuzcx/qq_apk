package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/pools/CodecWrapperPool;", "Lcom/tencent/tmediacodec/pools/Pool;", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "capacity", "", "(I)V", "actionCallback", "Lcom/tencent/tmediacodec/pools/PoolActionCallback;", "storeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "clear", "", "isEmpty", "", "isFull", "obtain", "y", "pickSuitableCodecWrapper", "format", "put", "t", "remove", "setActionCallback", "callback", "toString", "", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class CodecWrapperPool
  implements Pool<ReuseCodecWrapper, FormatWrapper>
{
  public static final CodecWrapperPool.Companion Companion = new CodecWrapperPool.Companion(null);
  @NotNull
  public static final String TAG = "CodecWrapperPool";
  private PoolActionCallback actionCallback;
  private final int capacity;
  private final HashSet<ReuseCodecWrapper> storeSet;
  
  public CodecWrapperPool(int paramInt)
  {
    this.capacity = paramInt;
    this.storeSet = new HashSet();
  }
  
  private final ReuseCodecWrapper pickSuitableCodecWrapper(FormatWrapper paramFormatWrapper)
  {
    Iterator localIterator = ((Iterable)this.storeSet).iterator();
    while (localIterator.hasNext())
    {
      ReuseCodecWrapper localReuseCodecWrapper = (ReuseCodecWrapper)localIterator.next();
      if (localReuseCodecWrapper.canReuse(paramFormatWrapper) != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) {
        return localReuseCodecWrapper;
      }
    }
    return null;
  }
  
  public void clear()
  {
    LogUtils.INSTANCE.i("CodecWrapperPool", "CodecWrapperPool clear:" + this.storeSet);
    Iterator localIterator = ((Iterable)this.storeSet).iterator();
    while (localIterator.hasNext())
    {
      ReuseCodecWrapper localReuseCodecWrapper = (ReuseCodecWrapper)localIterator.next();
      PoolActionCallback localPoolActionCallback = this.actionCallback;
      if (localPoolActionCallback != null) {
        localPoolActionCallback.onErase(localReuseCodecWrapper);
      }
    }
    this.storeSet.clear();
  }
  
  public boolean isEmpty()
  {
    return this.storeSet.isEmpty();
  }
  
  public boolean isFull()
  {
    return this.storeSet.size() == this.capacity;
  }
  
  @Nullable
  public ReuseCodecWrapper obtain(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "y");
    paramFormatWrapper = pickSuitableCodecWrapper(paramFormatWrapper);
    LogUtils.INSTANCE.d("CodecWrapperPool", "obtain codecWrapper:" + paramFormatWrapper);
    if (paramFormatWrapper != null)
    {
      this.storeSet.remove(paramFormatWrapper);
      return paramFormatWrapper;
    }
    return null;
  }
  
  public void put(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "t");
    if (isFull()) {
      remove((ReuseCodecWrapper)CollectionsKt.first((Iterable)this.storeSet));
    }
    this.storeSet.add(paramReuseCodecWrapper);
  }
  
  public void remove(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "t");
    if (this.storeSet.remove(paramReuseCodecWrapper))
    {
      PoolActionCallback localPoolActionCallback = this.actionCallback;
      if (localPoolActionCallback != null) {
        localPoolActionCallback.onErase(paramReuseCodecWrapper);
      }
    }
  }
  
  public final void setActionCallback(@NotNull PoolActionCallback paramPoolActionCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramPoolActionCallback, "callback");
    this.actionCallback = paramPoolActionCallback;
  }
  
  @NotNull
  public String toString()
  {
    return "size:" + this.storeSet.size() + " elements:" + this.storeSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperPool
 * JD-Core Version:    0.7.0.1
 */