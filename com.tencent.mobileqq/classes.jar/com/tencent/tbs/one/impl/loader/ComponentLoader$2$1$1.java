package com.tencent.tbs.one.impl.loader;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.base.task.Task;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import java.io.File;

class ComponentLoader$2$1$1
  extends ProgressiveCallback<InstallationResult<File>>
{
  ComponentLoader$2$1$1(ComponentLoader.2.1 param1) {}
  
  public void onCompleted(InstallationResult<File> paramInstallationResult)
  {
    Logging.i("[%s] {%s} Finished installing component itself from source %s", new Object[] { this.this$2.this$1.val$category, this.this$2.this$1.val$name, paramInstallationResult.source });
    this.this$2.val$self.finish();
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.this$2.val$self.fail(paramInt, paramString, paramThrowable);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    ComponentLoader.access$200(this.this$2.this$1.this$0, paramInt1, paramInt2, this.this$2.this$1.val$weight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.2.1.1
 * JD-Core Version:    0.7.0.1
 */