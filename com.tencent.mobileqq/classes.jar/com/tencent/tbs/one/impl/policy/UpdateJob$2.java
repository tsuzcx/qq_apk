package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.CoreThreadCallback;
import java.io.File;

class UpdateJob$2
  extends CoreThreadCallback<InstallationResult<File>>
{
  UpdateJob$2(UpdateJob paramUpdateJob, String paramString, int paramInt) {}
  
  public void onCompleted(InstallationResult<File> paramInstallationResult)
  {
    Logging.i("[%s] Finished updating component at %s from %s", new Object[] { UpdateJob.access$200(this.this$0).getCategory(), ((File)paramInstallationResult.result).getAbsolutePath(), paramInstallationResult.source });
    UpdateJob.access$300(this.this$0, this.val$name);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    Logging.e("[%s] Failed to update component %s#%d, error: [%d] %s", new Object[] { UpdateJob.access$200(this.this$0).getCategory(), this.val$name, Integer.valueOf(this.val$version), Integer.valueOf(paramInt), paramString, paramThrowable });
    this.this$0.fail(paramInt, "Failed to update component " + this.val$name + ", caused by: " + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.UpdateJob.2
 * JD-Core Version:    0.7.0.1
 */