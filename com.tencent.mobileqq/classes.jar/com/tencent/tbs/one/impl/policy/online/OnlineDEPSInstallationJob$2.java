package com.tencent.tbs.one.impl.policy.online;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import java.io.File;

class OnlineDEPSInstallationJob$2
  extends TBSOneCallback<Void>
{
  OnlineDEPSInstallationJob$2(OnlineDEPSInstallationJob paramOnlineDEPSInstallationJob, String paramString, File paramFile) {}
  
  public void onCompleted(Void paramVoid)
  {
    Logging.i("[%s] Finished intercepting DEPS download stream by runtime extension", new Object[] { this.val$category });
    OnlineDEPSInstallationJob.access$102(this.this$0, 0);
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
    OnlineDEPSInstallationJob.access$102(this.this$0, 0);
    this.this$0.fail(paramInt, paramString, null);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.online.OnlineDEPSInstallationJob.2
 * JD-Core Version:    0.7.0.1
 */