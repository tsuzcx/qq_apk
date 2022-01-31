package io.flutter.view;

import java.io.File;
import java.io.FilenameFilter;

final class ResourceExtractor$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("res_timestamp-");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.ResourceExtractor.1
 * JD-Core Version:    0.7.0.1
 */