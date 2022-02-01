package cooperation.ilive;

import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class IliveCdnPmUpdater
  implements PluginManagerUpdater
{
  private final File a;
  
  public IliveCdnPmUpdater()
  {
    String str = IlivePluginDownloadManager.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("IliveCdnPmUpdater", 2, "new IliveCdnPmUpdater file = " + str);
    }
    this.a = new File(str);
  }
  
  public File getLatest()
  {
    if (this.a.exists()) {
      return this.a;
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new IliveCdnPmUpdater.2(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new IliveCdnPmUpdater.1(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveCdnPmUpdater
 * JD-Core Version:    0.7.0.1
 */