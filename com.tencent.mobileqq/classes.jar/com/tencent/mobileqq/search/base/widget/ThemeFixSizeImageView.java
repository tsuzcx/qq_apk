package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class ThemeFixSizeImageView
  extends ThemeImageView
{
  public ThemeFixSizeImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemeFixSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ThemeFixSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init()
  {
    setSupportMaskView(true);
    setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.widget.ThemeFixSizeImageView
 * JD-Core Version:    0.7.0.1
 */