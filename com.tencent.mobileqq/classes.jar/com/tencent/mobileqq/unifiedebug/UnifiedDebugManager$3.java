package com.tencent.mobileqq.unifiedebug;

import java.io.File;
import java.io.FilenameFilter;

class UnifiedDebugManager$3
  implements FilenameFilter
{
  UnifiedDebugManager$3(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.a)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.3
 * JD-Core Version:    0.7.0.1
 */