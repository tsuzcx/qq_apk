package com.tencent.mobileqq.wink.editor.music;

import com.tencent.aelight.camera.log.AEQLog;

class WinkEditorPanelDialogDelegate$1$1
  implements Runnable
{
  WinkEditorPanelDialogDelegate$1$1(WinkEditorPanelDialogDelegate.1 param1) {}
  
  public void run()
  {
    try
    {
      if (WinkEditorPanelDialogDelegate.a(this.a.a) != null)
      {
        WinkEditorPanelDialogDelegate.a(this.a.a).b();
        return;
      }
    }
    catch (Exception localException)
    {
      AEQLog.a("AEEditorLyricPanelDialog", "[dismiss], Dialog.dismiss() raised exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.1.1
 * JD-Core Version:    0.7.0.1
 */