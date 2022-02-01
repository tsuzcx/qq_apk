package com.tencent.mobileqq.config.struct;

import java.io.File;
import java.util.Comparator;

class NearbyBannerManager$1
  implements Comparator<File>
{
  NearbyBannerManager$1(NearbyBannerManager paramNearbyBannerManager) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() > paramFile1.lastModified()) {
      return 1;
    }
    if (paramFile2.lastModified() < paramFile1.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.NearbyBannerManager.1
 * JD-Core Version:    0.7.0.1
 */