package cooperation.qzone.plugin;

import java.io.File;
import java.io.FileFilter;

final class QZonePluginUtils$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUtils.1
 * JD-Core Version:    0.7.0.1
 */