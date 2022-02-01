package com.tencent.mobileqq.ocr.ui;

import java.util.Comparator;

class HighlightModel$1
  implements Comparator<String>
{
  HighlightModel$1(HighlightModel paramHighlightModel) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    return paramString2.length() - paramString1.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.HighlightModel.1
 * JD-Core Version:    0.7.0.1
 */