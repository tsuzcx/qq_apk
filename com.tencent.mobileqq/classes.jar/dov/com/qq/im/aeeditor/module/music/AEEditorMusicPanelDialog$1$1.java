package dov.com.qq.im.aeeditor.module.music;

import blfg;
import blkd;
import blke;

public class AEEditorMusicPanelDialog$1$1
  implements Runnable
{
  public AEEditorMusicPanelDialog$1$1(blke paramblke) {}
  
  public void run()
  {
    try
    {
      blkd.a(this.a.a);
      return;
    }
    catch (Exception localException)
    {
      blfg.a("AEEditorMusicPanelDialog", "[animationDown], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.1.1
 * JD-Core Version:    0.7.0.1
 */