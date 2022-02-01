package com.tencent.open.base;

import java.io.File;
import java.util.Comparator;

class MD5Utils$FileComparator
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.base.MD5Utils.FileComparator
 * JD-Core Version:    0.7.0.1
 */