package dov.com.qq.im.aeeditor.module.text;

import bpam;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.File;

final class AEEditorTextControlPanel$8
  implements Runnable
{
  public void run()
  {
    try
    {
      FileUtils.clearDir(new File(AEEditorTextControlPanel.a()));
      return;
    }
    catch (Throwable localThrowable)
    {
      bpam.d("AEEditorTextControlPanel", "[clean] error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.8
 * JD-Core Version:    0.7.0.1
 */