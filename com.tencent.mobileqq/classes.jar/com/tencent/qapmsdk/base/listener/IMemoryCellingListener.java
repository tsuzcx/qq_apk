package com.tencent.qapmsdk.base.listener;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onAfterDump", "", "onBeforeDump", "", "", "tag", "onBeforeUploadJson", "onCanDump", "", "memory", "", "onLowMemory", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IMemoryCellingListener
  extends IBaseListener
{
  public abstract void onAfterDump();
  
  @NotNull
  public abstract List<String> onBeforeDump(@NotNull String paramString);
  
  public abstract void onBeforeUploadJson();
  
  public abstract boolean onCanDump(long paramLong);
  
  public abstract void onLowMemory(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IMemoryCellingListener
 * JD-Core Version:    0.7.0.1
 */