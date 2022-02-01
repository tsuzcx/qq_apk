package com.tencent.tkd.weibo.framework;

import android.graphics.drawable.Drawable;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface IEmoJiBridge
{
  @Nullable
  public abstract Drawable a(@NotNull String paramString);
  
  @Nullable
  public abstract Pattern a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.IEmoJiBridge
 * JD-Core Version:    0.7.0.1
 */