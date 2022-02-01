package com.tencent.tkd.comment.panel.bridge.emoji;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface IQbEmoJiEmotion
{
  @Nullable
  public abstract Drawable getEmoJiDrawable(int paramInt);
  
  @NotNull
  public abstract int[] getEmoJiResourceArray();
  
  @NotNull
  public abstract String[] getEmoJiShowNameArray();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.bridge.emoji.IQbEmoJiEmotion
 * JD-Core Version:    0.7.0.1
 */