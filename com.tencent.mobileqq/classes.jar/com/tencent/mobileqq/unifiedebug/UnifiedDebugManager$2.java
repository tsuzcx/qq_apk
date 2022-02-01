package com.tencent.mobileqq.unifiedebug;

import java.io.File;
import java.io.FilenameFilter;

class UnifiedDebugManager$2
  implements FilenameFilter
{
  UnifiedDebugManager$2(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.2
 * JD-Core Version:    0.7.0.1
 */