package com.tencent.tmediacodec.pools;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/pools/Pool;", "T", "Y", "", "clear", "", "isEmpty", "", "isFull", "obtain", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "t", "(Ljava/lang/Object;)V", "remove", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface Pool<T, Y>
{
  public abstract void clear();
  
  public abstract boolean isEmpty();
  
  public abstract boolean isFull();
  
  @Nullable
  public abstract T obtain(Y paramY);
  
  public abstract void put(T paramT);
  
  public abstract void remove(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.Pool
 * JD-Core Version:    0.7.0.1
 */