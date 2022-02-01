package dov.com.qq.im.aeeditor.module.music;

import bpam;
import bpij;
import bpim;

public class AEEditorLyricPanelDialog$3$1
  implements Runnable
{
  public AEEditorLyricPanelDialog$3$1(bpim parambpim) {}
  
  public void run()
  {
    try
    {
      bpij.a(this.a.a);
      return;
    }
    catch (Exception localException)
    {
      bpam.a("AEEditorLyricPanelDialog", "[animationDown], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.3.1
 * JD-Core Version:    0.7.0.1
 */