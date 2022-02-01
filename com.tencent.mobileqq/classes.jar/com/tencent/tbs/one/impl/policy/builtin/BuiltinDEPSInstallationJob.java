package com.tencent.tbs.one.impl.policy.builtin;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import java.io.File;
import java.io.IOException;

public class BuiltinDEPSInstallationJob
  extends CancellableJob<InstallationResult<DEPSConfig>>
{
  private Context mCallerContext;
  private String mCategory;
  private File mOutputFile;
  
  public BuiltinDEPSInstallationJob(Context paramContext, String paramString, File paramFile)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString;
    this.mOutputFile = paramFile;
  }
  
  private void install(Context paramContext, String paramString, File paramFile)
  {
    paramContext = PathService.getNativeLibraryDirectory(paramContext);
    try
    {
      FileUtils.copyFile(PathService.getDEPSFileInNativeLibraryDirectory(paramContext, paramString), paramFile);
      return;
    }
    catch (IOException paramString)
    {
      try
      {
        paramContext = DEPSConfig.parse(paramFile);
        finish(InstallationResult.make(InstallationResult.Source.BUILTIN, paramContext));
        return;
      }
      catch (TBSOneException paramContext)
      {
        fail(paramContext.getErrorCode(), paramContext.getMessage(), paramContext.getCause());
      }
      paramString = paramString;
      fail(302, "Failed to copy builtin DEPS from " + paramContext.getAbsolutePath() + " to " + paramFile.getAbsolutePath(), paramString);
      return;
    }
  }
  
  public void run()
  {
    ThreadUtils.postOnBackgroundThread(new BuiltinDEPSInstallationJob.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.builtin.BuiltinDEPSInstallationJob
 * JD-Core Version:    0.7.0.1
 */