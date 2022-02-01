package com.tencent.mobileqq.troop.utils;

import java.io.File;
import java.io.FilenameFilter;

class TroopFileTransferManager$1$1
  implements FilenameFilter
{
  TroopFileTransferManager$1$1(TroopFileTransferManager.1 param1) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1.1
 * JD-Core Version:    0.7.0.1
 */