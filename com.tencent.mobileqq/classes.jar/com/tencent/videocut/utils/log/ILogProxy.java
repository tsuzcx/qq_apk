package com.tencent.videocut.utils.log;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/log/ILogProxy;", "", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_utils_release"}, k=1, mv={1, 4, 2})
public abstract interface ILogProxy
{
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.log.ILogProxy
 * JD-Core Version:    0.7.0.1
 */