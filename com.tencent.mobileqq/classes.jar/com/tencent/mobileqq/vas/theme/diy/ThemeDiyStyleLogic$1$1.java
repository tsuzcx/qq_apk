package com.tencent.mobileqq.vas.theme.diy;

import java.io.File;
import java.io.FilenameFilter;

class ThemeDiyStyleLogic$1$1
  implements FilenameFilter
{
  ThemeDiyStyleLogic$1$1(ThemeDiyStyleLogic.1 param1) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.matches("chat_background_path_[0-9]*.xml")) || (paramString.matches("theme_background_path_[0-9]*.xml"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.1.1
 * JD-Core Version:    0.7.0.1
 */