package com.tencent.tbs.one.impl.policy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.ExclusiveJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.loader.dex.DexUtils;
import java.io.File;

public class ExclusiveComponentInstallationJob
  extends ExclusiveJob<InstallationResult<File>>
{
  private DEPSConfig.ComponentConfig mComponentConfig;
  private Context mContext;
  private CancellableJob<InstallationResult<File>> mInnerJob;
  private File mOutputDirectory;
  
  public ExclusiveComponentInstallationJob(Context paramContext, DEPSConfig.ComponentConfig paramComponentConfig, CancellableJob<InstallationResult<File>> paramCancellableJob, File paramFile)
  {
    super(PathService.getProcessLockFile(paramFile), 10000L);
    this.mComponentConfig = paramComponentConfig;
    this.mInnerJob = paramCancellableJob;
    this.mOutputDirectory = paramFile;
    this.mContext = paramContext;
  }
  
  private void doDex2oat(File paramFile)
  {
    try
    {
      String str = this.mComponentConfig.getName();
      Object localObject = ManifestConfig.parse(new File(paramFile, "MANIFEST")).getEntryDexPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File(paramFile, (String)localObject);
        Logging.i("do dexopt for component %s,entryClass=%s,installDir=%s", new Object[] { str, localObject, paramFile });
        DexUtils.createClassLoader(this.mContext, (File)localObject, paramFile.getAbsolutePath(), paramFile.getAbsolutePath(), null, null, false);
      }
      return;
    }
    catch (Throwable paramFile)
    {
      Logging.e("exception occured in dex2oat,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
    }
  }
  
  public void cancel()
  {
    super.cancel();
    this.mInnerJob.cancel();
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    File localFile = this.mOutputDirectory;
    FileUtils.deleteFileWithWarning(localFile);
    InstallationUtils.deleteIncompleteFlag(localFile);
    super.fail(paramInt, paramString, paramThrowable);
  }
  
  public void finish(InstallationResult<File> paramInstallationResult)
  {
    doDex2oat((File)paramInstallationResult.result);
    InstallationUtils.deleteIncompleteFlag(this.mOutputDirectory);
    super.finish(paramInstallationResult);
  }
  
  public void onLockGranted()
  {
    File localFile = this.mOutputDirectory;
    if (InstallationUtils.isArchiveComplete(localFile))
    {
      if (localFile.exists())
      {
        finish(InstallationResult.make(InstallationResult.Source.EXISTING, localFile));
        return;
      }
      InstallationUtils.createIncompleteFlag(localFile);
    }
    for (;;)
    {
      this.mInnerJob.start(new ExclusiveComponentInstallationJob.1(this));
      return;
      if (localFile.exists()) {
        FileUtils.deleteFileWithWarning(localFile);
      }
    }
  }
  
  public void onLockTimeout(Exception paramException)
  {
    fail(311, "Failed to wait for component installation lock " + this.mOutputDirectory, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.ExclusiveComponentInstallationJob
 * JD-Core Version:    0.7.0.1
 */