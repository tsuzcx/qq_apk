package cooperation.plugin;

import java.io.File;
import java.io.FilenameFilter;

class PluginDownloader$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginDownloader.1
 * JD-Core Version:    0.7.0.1
 */