package com.tencent.tkd.weibo.richEditText.span;

import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/span/EmotionSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "emotionName", "", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "getEmotionName", "()Ljava/lang/String;", "setEmotionName", "(Ljava/lang/String;)V", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class EmotionSpan
  extends ImageSpan
{
  @NotNull
  private String a;
  
  public EmotionSpan(@NotNull Drawable paramDrawable, @NotNull String paramString, int paramInt)
  {
    super(paramDrawable, paramInt);
    this.a = paramString;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.span.EmotionSpan
 * JD-Core Version:    0.7.0.1
 */