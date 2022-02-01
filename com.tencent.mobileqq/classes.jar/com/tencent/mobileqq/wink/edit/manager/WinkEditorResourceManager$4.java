package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.open.base.FileUtils;
import java.io.File;

class WinkEditorResourceManager$4
  implements Runnable
{
  WinkEditorResourceManager$4(WinkEditorResourceManager paramWinkEditorResourceManager) {}
  
  public void run()
  {
    if (new File(WinkEditorResourceManager.j).exists())
    {
      WinkQLog.b("[AEEditor2]AEEditorResourceManager", "ensureSetupTextConfig---pag file is already copied");
      return;
    }
    FileUtils.a(QQWinkEnvironment.a(), "delete", WinkEditorResourceManager.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.4
 * JD-Core Version:    0.7.0.1
 */