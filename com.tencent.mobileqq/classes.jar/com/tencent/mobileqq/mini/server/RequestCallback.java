package com.tencent.mobileqq.mini.server;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/server/RequestCallback;", "T", "", "onReqFailed", "", "retCode", "", "errMsg", "", "onReqSucceed", "rsp", "(Ljava/lang/Object;)V", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RequestCallback<T>
{
  public abstract void onReqFailed(long paramLong, @Nullable String paramString);
  
  public abstract void onReqSucceed(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.server.RequestCallback
 * JD-Core Version:    0.7.0.1
 */