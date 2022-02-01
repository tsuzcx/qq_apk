package com.tencent.mobileqq.mini.appbrand.utils;

import java.io.File;
import java.util.Comparator;

final class MiniLogManager$4
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.4
 * JD-Core Version:    0.7.0.1
 */