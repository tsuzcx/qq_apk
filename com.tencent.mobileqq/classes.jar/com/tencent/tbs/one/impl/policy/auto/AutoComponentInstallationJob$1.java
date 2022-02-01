package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import java.io.File;

class AutoComponentInstallationJob$1
  extends TBSOneCallback<Void>
{
  AutoComponentInstallationJob$1(AutoComponentInstallationJob paramAutoComponentInstallationJob, String paramString1, String paramString2, File paramFile) {}
  
  public void onCompleted(Void paramVoid)
  {
    Logging.i("[%s] {%s} Finished intercepting component installation job by runtime extension", new Object[] { this.val$category, this.val$name });
    AutoComponentInstallationJob.access$002(this.this$0, 0);
    this.this$0.finish(InstallationResult.make(InstallationResult.Source.EXTENSION, this.val$outputDirectory));
  }
  
  public void onError(int paramInt, String paramString)
  {
    AutoComponentInstallationJob.access$002(this.this$0, 0);
    this.this$0.fail(paramInt, paramString, null);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.1
 * JD-Core Version:    0.7.0.1
 */