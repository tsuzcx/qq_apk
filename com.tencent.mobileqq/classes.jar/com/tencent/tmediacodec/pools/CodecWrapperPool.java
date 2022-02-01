package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.reuse.ReusePolicy.EraseType;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class CodecWrapperPool
  implements Pool<ReuseCodecWrapper, FormatWrapper>
{
  public static final String TAG = "CodecWrapperPool";
  private PoolActionCallback actionCallback;
  private final int capacity;
  private final String name;
  private final CopyOnWriteArraySet<ReuseCodecWrapper> storeSet = new CopyOnWriteArraySet();
  
  public CodecWrapperPool(int paramInt, @NonNull String paramString)
  {
    this.capacity = paramInt;
    this.name = paramString;
  }
  
  private ReuseCodecWrapper getFirstCodecWrapper()
  {
    Iterator localIterator = this.storeSet.iterator();
    if (localIterator.hasNext()) {
      return (ReuseCodecWrapper)localIterator.next();
    }
    return null;
  }
  
  private ReuseCodecWrapper getRemoveItem(ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Iterator localIterator = this.storeSet.iterator();
    if (TCodecManager.getInstance().getReusePolicy().eraseType == ReusePolicy.EraseType.SAME)
    {
      paramReuseCodecWrapper = replaceSameTypeCodec(paramReuseCodecWrapper, localIterator);
      if (paramReuseCodecWrapper != null) {
        return paramReuseCodecWrapper;
      }
    }
    return getFirstCodecWrapper();
  }
  
  private final ReuseCodecWrapper pickSuitableCodecWrapper(FormatWrapper paramFormatWrapper)
  {
    Iterator localIterator = this.storeSet.iterator();
    while (localIterator.hasNext())
    {
      ReuseCodecWrapper localReuseCodecWrapper = (ReuseCodecWrapper)localIterator.next();
      if ((!localReuseCodecWrapper.isRecycled) && (localReuseCodecWrapper.canReuse(paramFormatWrapper) != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO)) {
        return localReuseCodecWrapper;
      }
      localReuseCodecWrapper.trackCantReuse();
      if (localReuseCodecWrapper.needToErase()) {
        remove(localReuseCodecWrapper);
      }
    }
    return null;
  }
  
  private ReuseCodecWrapper replaceSameTypeCodec(ReuseCodecWrapper paramReuseCodecWrapper, Iterator paramIterator)
  {
    while (paramIterator.hasNext())
    {
      ReuseCodecWrapper localReuseCodecWrapper = (ReuseCodecWrapper)paramIterator.next();
      if (TextUtils.equals(paramReuseCodecWrapper.getCodecName(), localReuseCodecWrapper.getCodecName())) {
        return localReuseCodecWrapper;
      }
    }
    return null;
  }
  
  public void clear()
  {
    LogUtils.i("CodecWrapperPool", "CodecWrapperPool clear:" + this.storeSet);
    Iterator localIterator = this.storeSet.iterator();
    while (localIterator.hasNext())
    {
      ReuseCodecWrapper localReuseCodecWrapper = (ReuseCodecWrapper)localIterator.next();
      if (this.actionCallback != null) {
        this.actionCallback.onErase(localReuseCodecWrapper);
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
  public ReuseCodecWrapper obtain(@NonNull FormatWrapper paramFormatWrapper)
  {
    paramFormatWrapper = pickSuitableCodecWrapper(paramFormatWrapper);
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperPool", "obtain codecWrapper:" + paramFormatWrapper);
    }
    if (paramFormatWrapper != null)
    {
      this.storeSet.remove(paramFormatWrapper);
      return paramFormatWrapper;
    }
    return null;
  }
  
  public void put(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (isFull()) {
      remove(getRemoveItem(paramReuseCodecWrapper));
    }
    this.storeSet.add(paramReuseCodecWrapper);
  }
  
  public void remove(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (this.storeSet.remove(paramReuseCodecWrapper))
    {
      if (this.actionCallback != null) {
        this.actionCallback.onErase(paramReuseCodecWrapper);
      }
      return;
    }
    LogUtils.w("CodecWrapperPool", "pool:" + this.name + " remove " + paramReuseCodecWrapper + " not found");
  }
  
  public final void setActionCallback(@NonNull PoolActionCallback paramPoolActionCallback)
  {
    this.actionCallback = paramPoolActionCallback;
  }
  
  @NonNull
  public String toString()
  {
    return "size:" + this.storeSet.size() + " elements:" + this.storeSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperPool
 * JD-Core Version:    0.7.0.1
 */