package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.ExclusiveJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.PathService;
import java.io.File;

public class ExclusiveDEPSInstallationJob
  extends ExclusiveJob<InstallationResult<DEPSConfig>>
{
  private CancellableJob<InstallationResult<DEPSConfig>> mInnerJob;
  private File mOutputFile;
  
  public ExclusiveDEPSInstallationJob(CancellableJob<InstallationResult<DEPSConfig>> paramCancellableJob, File paramFile)
  {
    super(PathService.getProcessLockFile(paramFile), 10000L);
    this.mInnerJob = paramCancellableJob;
    this.mOutputFile = paramFile;
  }
  
  public void cancel()
  {
    super.cancel();
    this.mInnerJob.cancel();
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    File localFile = this.mOutputFile;
    FileUtils.deleteFileWithWarning(localFile);
    InstallationUtils.deleteIncompleteFlag(localFile);
    super.fail(paramInt, paramString, paramThrowable);
  }
  
  public void finish(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    InstallationUtils.deleteIncompleteFlag(this.mOutputFile);
    super.finish(paramInstallationResult);
  }
  
  public void onLockGranted()
  {
    Object localObject = this.mOutputFile;
    if (InstallationUtils.isArchiveComplete((File)localObject))
    {
      if (((File)localObject).exists()) {
        try
        {
          localObject = DEPSConfig.parse((File)localObject);
          finish(InstallationResult.make(InstallationResult.Source.EXISTING, localObject));
          return;
        }
        catch (TBSOneException localTBSOneException)
        {
          fail(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
          return;
        }
      }
      InstallationUtils.createIncompleteFlag(localTBSOneException);
    }
    for (;;)
    {
      this.mInnerJob.start(new ExclusiveDEPSInstallationJob.1(this));
      return;
      if (localTBSOneException.exists()) {
        FileUtils.deleteFileWithWarning(localTBSOneException);
      }
    }
  }
  
  public void onLockTimeout(Exception paramException)
  {
    fail(301, "Failed to wait for DEPS installation lock " + this.mOutputFile, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.ExclusiveDEPSInstallationJob
 * JD-Core Version:    0.7.0.1
 */