package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.open.base.FileUtils;

final class WinkEditorResourceManager$2
  implements Runnable
{
  public void run()
  {
    FileUtils.a(this.a, "camera/frame", WinkEditorResourceManager.m);
    WinkQLog.b("[AEEditor2]AEEditorResourceManager", "setupFrameEnv---pag file is successfully copied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.2
 * JD-Core Version:    0.7.0.1
 */