package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "", "()V", "isInPool", "", "()Z", "setInPool", "(Z)V", "next", "getNext", "()Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "setNext", "(Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;)V", "changeNext", "", "nextObjext", "outPool", "reset", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public class RecyclablePool$Recyclable
{
  public static final RecyclablePool.Recyclable.Companion Companion = new RecyclablePool.Recyclable.Companion(null);
  private static final String TAG = "QAPM_common_RecyclablePool_Recyclable";
  private boolean isInPool;
  @Nullable
  private Recyclable next;
  
  public final void changeNext(@Nullable Recyclable paramRecyclable, boolean paramBoolean)
  {
    if ((this.isInPool) && (paramBoolean))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_RecyclablePool_Recyclable", "changeNext " + paramRecyclable + ", " + paramBoolean });
      throw ((Throwable)new RuntimeException("conflict inPool and outPool"));
    }
    this.next = paramRecyclable;
  }
  
  @Nullable
  public final Recyclable getNext()
  {
    return this.next;
  }
  
  public final boolean isInPool()
  {
    return this.isInPool;
  }
  
  public void reset()
  {
    this.next = ((Recyclable)null);
  }
  
  public final void setInPool(boolean paramBoolean)
  {
    this.isInPool = paramBoolean;
  }
  
  public final void setNext(@Nullable Recyclable paramRecyclable)
  {
    this.next = paramRecyclable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.RecyclablePool.Recyclable
 * JD-Core Version:    0.7.0.1
 */