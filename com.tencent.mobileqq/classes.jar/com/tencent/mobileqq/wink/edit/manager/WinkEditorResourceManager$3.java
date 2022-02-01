package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.io.File;
import java.io.IOException;

class WinkEditorResourceManager$3
  implements Runnable
{
  WinkEditorResourceManager$3(WinkEditorResourceManager paramWinkEditorResourceManager) {}
  
  public void run()
  {
    WinkEditorResourceManager.a(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.this$0.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(".nomedia");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists()) {
      try
      {
        FileUtils.createFile((String)localObject);
        return;
      }
      catch (IOException localIOException)
      {
        WinkQLog.a(this.this$0.d, "loadAssets", localIOException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.3
 * JD-Core Version:    0.7.0.1
 */