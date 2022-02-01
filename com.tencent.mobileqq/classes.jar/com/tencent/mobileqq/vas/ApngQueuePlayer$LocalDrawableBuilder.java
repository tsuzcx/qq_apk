package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;

public class ApngQueuePlayer$LocalDrawableBuilder
  implements ApngQueuePlayer.DrawableBuilder
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public ApngQueuePlayer$LocalDrawableBuilder(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public URLDrawable a(Drawable paramDrawable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", this.jdField_a_of_type_Int);
    localBundle.putBoolean("key_use_cache", false);
    return VasApngUtil.getApngDrawable(this.jdField_a_of_type_JavaLangString, "dontCacheMe", paramDrawable, null, this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ApngQueuePlayer.LocalDrawableBuilder
 * JD-Core Version:    0.7.0.1
 */