package com.tencent.mobileqq.vas.tianshu;

import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "getTraceInfoOfLastClick", "", "setTraceInfoOfLastClick", "", "traceInfo", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITianshuWebManager
  extends IVasManager
{
  @NotNull
  public abstract String a();
  
  public abstract void a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.tianshu.ITianshuWebManager
 * JD-Core Version:    0.7.0.1
 */