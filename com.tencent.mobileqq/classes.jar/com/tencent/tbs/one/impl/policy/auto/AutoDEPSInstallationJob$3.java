package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import java.io.File;

class AutoDEPSInstallationJob$3
  extends TBSOneCallback<Void>
{
  AutoDEPSInstallationJob$3(AutoDEPSInstallationJob paramAutoDEPSInstallationJob, String paramString, File paramFile) {}
  
  public void onCompleted(Void paramVoid)
  {
    Logging.i("[%s] Finished intercepting DEPS response stream by runtime extension", new Object[] { this.val$category });
    AutoDEPSInstallationJob.access$002(this.this$0, 0);
    try
    {
      paramVoid = DEPSConfig.parse(this.val$outputFile);
      this.this$0.finish(InstallationResult.make(InstallationResult.Source.EXTENSION, paramVoid));
      return;
    }
    catch (TBSOneException paramVoid)
    {
      this.this$0.fail(paramVoid.getErrorCode(), paramVoid.getMessage(), paramVoid.getCause());
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    AutoDEPSInstallationJob.access$002(this.this$0, 0);
    this.this$0.fail(paramInt, paramString, null);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(InstallationUtils.computeProgress(paramInt2, 50, 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoDEPSInstallationJob.3
 * JD-Core Version:    0.7.0.1
 */