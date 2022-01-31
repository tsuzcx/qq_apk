package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.util.AttributeSet;
import bfwa;
import com.tencent.widget.FixSizeImageView;

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
  
  public void a()
  {
    setSupportMaskView(true);
    setMaskShape(bfwa.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ThemeFixSizeImageView
 * JD-Core Version:    0.7.0.1
 */