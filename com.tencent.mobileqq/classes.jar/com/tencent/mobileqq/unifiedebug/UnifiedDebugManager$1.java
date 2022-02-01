package com.tencent.mobileqq.unifiedebug;

import java.io.File;
import java.io.FilenameFilter;

class UnifiedDebugManager$1
  implements FilenameFilter
{
  UnifiedDebugManager$1(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.1
 * JD-Core Version:    0.7.0.1
 */