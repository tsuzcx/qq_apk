package cooperation.plugin;

import java.io.File;
import java.io.FilenameFilter;

class PluginInstaller$1
  implements FilenameFilter
{
  PluginInstaller$1(PluginInstaller paramPluginInstaller, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller.1
 * JD-Core Version:    0.7.0.1
 */