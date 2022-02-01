package cooperation.plugin;

import java.io.File;
import java.io.FileFilter;

final class PluginInfoUtil$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */