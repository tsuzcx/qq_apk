package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.Emoticon;

public abstract interface ISmallEmoticonInfo
{
  public abstract Drawable getBigDrawable(Context paramContext, float paramFloat);
  
  public abstract Emoticon getEmoticon();
  
  public abstract void setEmoticon(Emoticon paramEmoticon);
  
  public abstract void setIsAPNG(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */