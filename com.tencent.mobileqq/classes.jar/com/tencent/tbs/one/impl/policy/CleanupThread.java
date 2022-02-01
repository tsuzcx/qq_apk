package com.tencent.tbs.one.impl.policy;

import android.os.Process;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.PathService;
import java.io.File;

public class CleanupThread
  extends Thread
{
  private final File mRootDirectory;
  
  public CleanupThread(File paramFile)
  {
    this.mRootDirectory = paramFile;
  }
  
  public void run()
  {
    int i = 0;
    super.run();
    Logging.i("Running cleanup thread", new Object[0]);
    FileUtils.recursivelyDeleteFile(PathService.getProcessDirectory(this.mRootDirectory, Process.myPid()));
    File[] arrayOfFile = PathService.getHomeDirectory(this.mRootDirectory).listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        InstallationUtils.cleanUselessComponents(arrayOfFile[i]);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.CleanupThread
 * JD-Core Version:    0.7.0.1
 */