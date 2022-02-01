package com.tencent.tbs.one.impl.policy.auto;

import android.content.Context;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import java.io.File;

class AutoComponentInstallationJob$7
  extends TBSOneCallback<Void>
{
  AutoComponentInstallationJob$7(AutoComponentInstallationJob paramAutoComponentInstallationJob, String paramString1, String paramString2, File paramFile, Context paramContext, int paramInt) {}
  
  public void onCompleted(Void paramVoid)
  {
    Logging.i("[%s] {%s} Finished intercepting component download stream by runtime extension", new Object[] { this.val$category, this.val$name });
    AutoComponentInstallationJob.access$002(this.this$0, 0);
    this.this$0.finish(InstallationResult.make(InstallationResult.Source.EXTENSION, this.val$outputDirectory));
  }
  
  public void onError(int paramInt, String paramString)
  {
    Logging.i("[%s] {%s} Failed to intercept component download stream by runtime extension: [%d] %s", new Object[] { this.val$category, this.val$name, Integer.valueOf(paramInt), paramString });
    AutoComponentInstallationJob.access$002(this.this$0, 0);
    AutoComponentInstallationJob.access$1100(this.this$0, this.val$callerContext, this.val$category, this.val$name, this.val$versionCode, AutoComponentInstallationJob.access$1000(this.this$0), -1);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(InstallationUtils.computeProgress(paramInt2, 70, 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.7
 * JD-Core Version:    0.7.0.1
 */