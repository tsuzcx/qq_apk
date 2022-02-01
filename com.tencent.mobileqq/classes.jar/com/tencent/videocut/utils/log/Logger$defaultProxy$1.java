package com.tencent.videocut.utils.log;

import android.util.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/utils/log/Logger$defaultProxy$1", "Lcom/tencent/videocut/utils/log/ILogProxy;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class Logger$defaultProxy$1
  implements ILogProxy
{
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.log.Logger.defaultProxy.1
 * JD-Core Version:    0.7.0.1
 */