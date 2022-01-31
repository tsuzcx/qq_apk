package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.MergePathsContent;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class MergePaths
  implements ContentModel
{
  private final boolean hidden;
  private final MergePaths.MergePathsMode mode;
  private final String name;
  
  public MergePaths(String paramString, MergePaths.MergePathsMode paramMergePathsMode, boolean paramBoolean)
  {
    this.name = paramString;
    this.mode = paramMergePathsMode;
    this.hidden = paramBoolean;
  }
  
  public MergePaths.MergePathsMode getMode()
  {
    return this.mode;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  @Nullable
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    if (!paramLottieDrawable.enableMergePathsForKitKatAndAbove())
    {
      L.warn("Animation contains merge paths but they are disabled.");
      return null;
    }
    return new MergePathsContent(this);
  }
  
  public String toString()
  {
    return "MergePaths{mode=" + this.mode + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.MergePaths
 * JD-Core Version:    0.7.0.1
 */