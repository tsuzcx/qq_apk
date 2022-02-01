package com.tencent.mtt.hippy.adapter.font;

public abstract interface HippyFontScaleAdapter
{
  public abstract String getCustomFontFilePath(String paramString, int paramInt);
  
  public abstract CharSequence getEmoticonText(CharSequence paramCharSequence, int paramInt);
  
  public abstract float getFontScale();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
 * JD-Core Version:    0.7.0.1
 */