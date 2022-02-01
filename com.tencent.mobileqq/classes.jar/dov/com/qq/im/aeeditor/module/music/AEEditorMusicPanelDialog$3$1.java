package dov.com.qq.im.aeeditor.module.music;

import bpam;
import bpja;
import bpjd;

public class AEEditorMusicPanelDialog$3$1
  implements Runnable
{
  public AEEditorMusicPanelDialog$3$1(bpjd parambpjd) {}
  
  public void run()
  {
    try
    {
      bpja.a(this.a.a);
      return;
    }
    catch (Exception localException)
    {
      bpam.a("AEEditorMusicPanelDialog", "[animationDown], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.3.1
 * JD-Core Version:    0.7.0.1
 */