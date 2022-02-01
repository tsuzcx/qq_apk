package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class ThemeFixSizeImageView
  extends FixSizeImageView
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
  
  public void init()
  {
    setSupportMaskView(true);
    setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ThemeFixSizeImageView
 * JD-Core Version:    0.7.0.1
 */