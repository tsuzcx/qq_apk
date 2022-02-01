package dov.com.qq.im.aeeditor.module.music;

import dov.com.qq.im.ae.util.AEQLog;

class AEEditorPanelDialogDelegate$1$1
  implements Runnable
{
  AEEditorPanelDialogDelegate$1$1(AEEditorPanelDialogDelegate.1 param1) {}
  
  public void run()
  {
    try
    {
      if (AEEditorPanelDialogDelegate.a(this.a.a) != null) {
        AEEditorPanelDialogDelegate.a(this.a.a).b();
      }
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a("AEEditorLyricPanelDialog", "[dismiss], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorPanelDialogDelegate.1.1
 * JD-Core Version:    0.7.0.1
 */