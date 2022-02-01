package com.tencent.mobileqq.unifiedebug;

import java.io.File;
import java.io.FilenameFilter;

class UnifiedDebugManager$1
  implements FilenameFilter
{
  UnifiedDebugManager$1(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.1
 * JD-Core Version:    0.7.0.1
 */