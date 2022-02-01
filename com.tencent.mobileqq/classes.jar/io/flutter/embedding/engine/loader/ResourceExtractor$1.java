package io.flutter.embedding.engine.loader;

import java.io.File;
import java.io.FilenameFilter;

class ResourceExtractor$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("res_timestamp-");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ResourceExtractor.1
 * JD-Core Version:    0.7.0.1
 */