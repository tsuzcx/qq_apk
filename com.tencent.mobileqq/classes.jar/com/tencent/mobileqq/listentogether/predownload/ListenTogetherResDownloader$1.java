package com.tencent.mobileqq.listentogether.predownload;

import java.io.File;
import java.util.Comparator;

final class ListenTogetherResDownloader$1
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() < paramFile2.lastModified()) {
      return -1;
    }
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.1
 * JD-Core Version:    0.7.0.1
 */