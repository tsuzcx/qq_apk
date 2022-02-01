package com.tencent.mobileqq.qassistant.util;

import java.io.File;
import java.util.Comparator;

final class CommandUtils$1
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return (int)(paramFile2.lastModified() - paramFile1.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.CommandUtils.1
 * JD-Core Version:    0.7.0.1
 */