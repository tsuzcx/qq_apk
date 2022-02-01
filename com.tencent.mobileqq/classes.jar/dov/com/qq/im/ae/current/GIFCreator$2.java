package dov.com.qq.im.ae.current;

import java.io.File;
import java.io.FilenameFilter;

class GIFCreator$2
  implements FilenameFilter
{
  GIFCreator$2(GIFCreator paramGIFCreator) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.current.GIFCreator.2
 * JD-Core Version:    0.7.0.1
 */