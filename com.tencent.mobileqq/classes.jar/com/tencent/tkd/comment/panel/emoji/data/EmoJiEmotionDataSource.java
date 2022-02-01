package com.tencent.tkd.comment.panel.emoji.data;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.comment.panel.base.data.IEmotionDataSource;
import com.tencent.tkd.comment.panel.bridge.emoji.IQbEmoJiEmotion;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;

public class EmoJiEmotionDataSource
  implements IEmotionDataSource
{
  private IQbEmoJiEmotion a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  @Nullable
  public Drawable a(int paramInt)
  {
    IQbEmoJiEmotion localIQbEmoJiEmotion = this.a;
    if (localIQbEmoJiEmotion != null) {
      return localIQbEmoJiEmotion.getEmoJiDrawable(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource
 * JD-Core Version:    0.7.0.1
 */