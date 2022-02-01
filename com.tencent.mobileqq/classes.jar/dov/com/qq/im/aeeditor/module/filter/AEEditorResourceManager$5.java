package dov.com.qq.im.aeeditor.module.filter;

import android.content.Context;
import com.tencent.open.base.FileUtils;
import dov.com.qq.im.ae.util.AEQLog;

final class AEEditorResourceManager$5
  implements Runnable
{
  AEEditorResourceManager$5(Context paramContext) {}
  
  public void run()
  {
    FileUtils.a(this.a, "camera/frame", AEEditorResourceManager.d);
    AEQLog.b("AEEditorResourceManager", "setupFrameEnv---pag file is successfully copied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager.5
 * JD-Core Version:    0.7.0.1
 */