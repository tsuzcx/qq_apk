package com.tencent.mobileqq.dinifly.animation.content;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

final class BaseStrokeContent$PathGroup
{
  private final List<PathContent> paths = new ArrayList();
  @Nullable
  private final TrimPathContent trimPath;
  
  private BaseStrokeContent$PathGroup(@Nullable TrimPathContent paramTrimPathContent)
  {
    this.trimPath = paramTrimPathContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.BaseStrokeContent.PathGroup
 * JD-Core Version:    0.7.0.1
 */