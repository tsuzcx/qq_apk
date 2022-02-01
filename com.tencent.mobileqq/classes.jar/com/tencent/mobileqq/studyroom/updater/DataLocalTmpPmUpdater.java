package com.tencent.mobileqq.studyroom.updater;

import com.tencent.mobileqq.app.ThreadManagerExecutor;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class DataLocalTmpPmUpdater
  implements IShadowPluginManagerUpdater
{
  private final File a;
  
  public DataLocalTmpPmUpdater(String paramString)
  {
    this.a = new File(String.format("/data/local/tmp/%sPluginManager.apk", new Object[] { paramString }));
  }
  
  public boolean a()
  {
    return false;
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
    return ThreadManagerExecutor.getExecutorService(16).submit(new DataLocalTmpPmUpdater.2(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new DataLocalTmpPmUpdater.1(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.DataLocalTmpPmUpdater
 * JD-Core Version:    0.7.0.1
 */