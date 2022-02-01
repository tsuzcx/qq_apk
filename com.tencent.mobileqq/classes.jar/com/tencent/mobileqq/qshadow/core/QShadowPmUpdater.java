package com.tencent.mobileqq.qshadow.core;

import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class QShadowPmUpdater
  implements PluginManagerUpdater
{
  private File mLocalPmFile;
  
  public QShadowPmUpdater(File paramFile)
  {
    this.mLocalPmFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.mLocalPmFile;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.QShadowPmUpdater
 * JD-Core Version:    0.7.0.1
 */