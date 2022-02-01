package com.tencent.tbs.one.impl.loader;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.task.Task;
import java.io.File;

class ComponentLoader$3$1$1
  extends TBSOneCallback<File>
{
  ComponentLoader$3$1$1(ComponentLoader.3.1 param1) {}
  
  public void onCompleted(File paramFile)
  {
    Logging.i("[%s] {%s} Finished installing dependency %s", new Object[] { this.this$2.this$1.val$category, this.this$2.this$1.val$name, this.this$2.this$1.val$dependency });
    this.this$2.val$self.finish();
  }
  
  public void onError(int paramInt, String paramString)
  {
    this.this$2.val$self.fail(paramInt, "Failed to install dependency " + this.this$2.this$1.val$dependency + ", caused by: " + paramString);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    ComponentLoader.access$200(this.this$2.this$1.this$0, paramInt1, paramInt2, this.this$2.this$1.val$weight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.3.1.1
 * JD-Core Version:    0.7.0.1
 */