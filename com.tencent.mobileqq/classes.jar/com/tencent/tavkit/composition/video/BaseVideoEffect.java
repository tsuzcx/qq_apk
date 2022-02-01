package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.tav.decoder.logger.Logger;

public abstract class BaseVideoEffect
  implements TAVVideoEffect
{
  private static final String TAG = "BaseVideoEffect";
  
  @Deprecated
  public final TAVVideoEffect.Filter createFilter()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createFilter: 这个方法不应该调用，应该调用 createFilter(RenderInfo renderInfo) stack = ");
    localStringBuilder.append(Log.getStackTraceString(new RuntimeException()));
    Logger.w("BaseVideoEffect", localStringBuilder.toString());
    return createFilter(null);
  }
  
  public abstract TAVVideoEffect.Filter createFilter(@Nullable RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.BaseVideoEffect
 * JD-Core Version:    0.7.0.1
 */