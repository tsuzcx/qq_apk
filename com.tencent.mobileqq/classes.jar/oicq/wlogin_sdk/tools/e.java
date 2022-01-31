package oicq.wlogin_sdk.tools;

import java.io.File;
import java.io.FilenameFilter;

final class e
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.matches("wtlogin_[0-9]+\\.log");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.e
 * JD-Core Version:    0.7.0.1
 */