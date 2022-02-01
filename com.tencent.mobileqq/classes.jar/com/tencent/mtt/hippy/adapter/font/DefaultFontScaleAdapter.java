package com.tencent.mtt.hippy.adapter.font;

import com.tencent.mtt.hippy.utils.LogUtils;

public class DefaultFontScaleAdapter
  implements HippyFontScaleAdapter
{
  public String getCustomFontFilePath(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCustomFontFilePath fontFamilyName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", style=");
    localStringBuilder.append(paramInt);
    LogUtils.d("DefaultFontScaleAdapter", localStringBuilder.toString());
    return null;
  }
  
  public CharSequence getEmoticonText(CharSequence paramCharSequence, int paramInt)
  {
    return paramCharSequence;
  }
  
  public float getFontScale()
  {
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.font.DefaultFontScaleAdapter
 * JD-Core Version:    0.7.0.1
 */