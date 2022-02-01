package cooperation.ilive;

import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class FixedPathPmUpdater
  implements PluginManagerUpdater
{
  private final File a;
  
  public File getLatest()
  {
    return this.a;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return null;
  }
  
  public Future<File> update()
  {
    return null;
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.FixedPathPmUpdater
 * JD-Core Version:    0.7.0.1
 */