package io.flutter.embedding.engine.loader;

import java.io.File;
import java.io.FilenameFilter;

class ResourceCleaner$1
  implements FilenameFilter
{
  ResourceCleaner$1(ResourceCleaner paramResourceCleaner) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(".org.chromium.Chromium.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceCleaner.1
 * JD-Core Version:    0.7.0.1
 */