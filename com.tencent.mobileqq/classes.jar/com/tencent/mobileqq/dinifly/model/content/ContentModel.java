package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public abstract interface ContentModel
{
  @Nullable
  public abstract Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ContentModel
 * JD-Core Version:    0.7.0.1
 */