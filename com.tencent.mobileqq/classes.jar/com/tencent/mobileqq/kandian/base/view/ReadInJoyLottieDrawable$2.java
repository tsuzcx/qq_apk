package com.tencent.mobileqq.kandian.base.view;

import java.io.File;
import java.io.FileFilter;

class ReadInJoyLottieDrawable$2
  implements FileFilter
{
  ReadInJoyLottieDrawable$2(ReadInJoyLottieDrawable paramReadInJoyLottieDrawable) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.2
 * JD-Core Version:    0.7.0.1
 */