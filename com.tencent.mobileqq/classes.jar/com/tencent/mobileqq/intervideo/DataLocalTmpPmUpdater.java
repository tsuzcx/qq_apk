package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class DataLocalTmpPmUpdater
  implements PluginManagerUpdater
{
  private final File a;
  
  public DataLocalTmpPmUpdater(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/local/tmp/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("PluginManager.apk");
    this.a = new File(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater
 * JD-Core Version:    0.7.0.1
 */