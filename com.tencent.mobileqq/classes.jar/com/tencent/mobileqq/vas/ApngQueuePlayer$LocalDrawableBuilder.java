package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;

public class ApngQueuePlayer$LocalDrawableBuilder
  implements ApngQueuePlayer.DrawableBuilder
{
  private int a;
  private String b;
  
  public ApngQueuePlayer$LocalDrawableBuilder(String paramString, int paramInt)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public URLDrawable a(Drawable paramDrawable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", this.a);
    localBundle.putBoolean("key_use_cache", false);
    String str = this.b;
    return VasApngUtil.getApngDrawable(str, "dontCacheMe", paramDrawable, null, str, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ApngQueuePlayer.LocalDrawableBuilder
 * JD-Core Version:    0.7.0.1
 */